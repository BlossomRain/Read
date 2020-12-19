/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.tools.javac.processing;

import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.resources.CompilerProperties.Errors;
import com.sun.tools.javac.resources.CompilerProperties.Notes;
import com.sun.tools.javac.resources.CompilerProperties.Warnings;
import com.sun.tools.javac.util.*;
import com.sun.tools.javac.util.DefinedBy.Api;
import com.sun.tools.javac.util.JCDiagnostic.DiagnosticFlag;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.*;
import javax.lang.model.element.*;
import javax.tools.JavaFileObject;
import javax.tools.Diagnostic;
import javax.annotation.processing.*;

/**
 * An implementation of the Messager built on top of log.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public class JavacMessager implements Messager {
    Log log;
    JavacProcessingEnvironment processingEnv;
    int errorCount = 0;
    int warningCount = 0;

    JavacMessager(Context context, JavacProcessingEnvironment processingEnv) {
        log = Log.instance(context);
        this.processingEnv = processingEnv;
    }

    // processingEnv.getElementUtils()

    @DefinedBy(Api.ANNOTATION_PROCESSING)
    public void printMessage(Diagnostic.Kind kind, CharSequence msg) {
        printMessage(kind, msg, null, null, null);
    }

    @DefinedBy(Api.ANNOTATION_PROCESSING)
    public void printMessage(Diagnostic.Kind kind, CharSequence msg,
                      Element e) {
        printMessage(kind, msg, e, null, null);
    }

    /**
     * Prints a message of the specified kind at the location of the
     * annotation mirror of the annotated element.
     *
     * @param kind the kind of message
     * @param msg  the message, or an empty string if none
     * @param e    the annotated element
     * @param a    the annotation to use as a position hint
     */
    @DefinedBy(Api.ANNOTATION_PROCESSING)
    public void printMessage(Diagnostic.Kind kind, CharSequence msg,
                      Element e, AnnotationMirror a) {
        printMessage(kind, msg, e, a, null);
    }

    /**
     * Prints a message of the specified kind at the location of the
     * annotation value inside the annotation mirror of the annotated
     * element.
     *
     * @param kind the kind of message
     * @param msg  the message, or an empty string if none
     * @param e    the annotated element
     * @param a    the annotation containing the annotaiton value
     * @param v    the annotation value to use as a position hint
     */
    @DefinedBy(Api.ANNOTATION_PROCESSING)
    public void printMessage(Diagnostic.Kind kind, CharSequence msg,
                      Element e, AnnotationMirror a, AnnotationValue v) {
        JavaFileObject oldSource = null;
        JavaFileObject newSource = null;
        JCDiagnostic.DiagnosticPosition pos = null;
        JavacElements elemUtils = processingEnv.getElementUtils();
        Pair<JCTree, JCCompilationUnit> treeTop = elemUtils.getTreeAndTopLevel(e, a, v);
        if (treeTop != null) {
            newSource = treeTop.snd.sourcefile;
            if (newSource != null) {
                // save the old version and reinstate it later
                oldSource = log.useSource(newSource);
                pos = treeTop.fst.pos();
            }
        }
        try {
            switch (kind) {
            case ERROR:
                errorCount++;
                log.error(DiagnosticFlag.MULTIPLE, pos, Errors.ProcMessager(msg.toString()));
                break;

            case WARNING:
                warningCount++;
                log.warning(pos, Warnings.ProcMessager(msg.toString()));
                break;

            case MANDATORY_WARNING:
                warningCount++;
                log.mandatoryWarning(pos, Warnings.ProcMessager(msg.toString()));
                break;

            default:
                log.note(pos, Notes.ProcMessager(msg.toString()));
                break;
            }
        } finally {
            // reinstate the saved version, only if it was saved earlier
            if (newSource != null)
                log.useSource(oldSource);
        }
    }

    /**
     * Prints an error message.
     * Equivalent to {@code printError(null, msg)}.
     * @param msg  the message, or an empty string if none
     */
    public void printError(String msg) {
        printMessage(Diagnostic.Kind.ERROR, msg);
    }

    /**
     * Prints a warning message.
     * Equivalent to {@code printWarning(null, msg)}.
     * @param msg  the message, or an empty string if none
     */
    public void printWarning(String msg) {
        printMessage(Diagnostic.Kind.WARNING, msg);
    }

    /**
     * Prints a notice.
     * @param msg  the message, or an empty string if none
     */
    public void printNotice(String msg) {
        printMessage(Diagnostic.Kind.NOTE, msg);
    }

    public boolean errorRaised() {
        return errorCount > 0;
    }

    public int errorCount() {
        return errorCount;
    }

    public int warningCount() {
        return warningCount;
    }

    public void newRound() {
        errorCount = 0;
    }

    public String toString() {
        return "javac Messager";
    }
}
