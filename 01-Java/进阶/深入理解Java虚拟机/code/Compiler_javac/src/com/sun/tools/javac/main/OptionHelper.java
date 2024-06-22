/*
 * Copyright (c) 2006, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.main;

import java.nio.file.Path;

import com.sun.tools.javac.resources.CompilerProperties.Errors;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.JCDiagnostic.Error;
import com.sun.tools.javac.util.Log;
import com.sun.tools.javac.util.Log.PrefixKind;

/**
 * Helper object to be used by {@link Option#process}, providing access to
 * the compilation environment.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own
 * risk.  This code and its internal interfaces are subject to change
 * or deletion without notice.</b></p>
 */

public abstract class OptionHelper {

    /**
     * Get the current value of an option.
     * @param option the option
     * @return the value of the option
     */
    public abstract String get(Option option);

    /**
     * Set the value of an option.
     * @param name the primary name of the option
     * @param value the value for the option
     */
    public abstract void put(String name, String value);

    /**
     * Remove any prior value for an option.
     * @param name the primary name of the option
     */
    public abstract void remove(String name);

    /**
     * Handle a file manager option.
     * @param option the option
     * @param value the value for the option
     * @return true if the option was handled successfully, and false otherwise
     */
    public abstract boolean handleFileManagerOption(Option option, String value);

    /**
     * Get access to the Log for the compilation.
     * @return the log
     */
    public abstract Log getLog();

    /**
     * Get the name of the tool, such as "javac", to be used in info like -help.
     * @return the name of the tool
     */
    public abstract String getOwnName();

    /**
     * Returns a new InvalidValueException, with a localized detail message.
     * @param key the resource key for the message
     * @param args the arguments, if any, for the resource string
     * @return the InvalidValueException
     */
    Option.InvalidValueException newInvalidValueException(Error error) {
        return new Option.InvalidValueException(getLog().localize(error));
    }

    /** Record a file to be compiled. */
    abstract void addFile(Path p);

    /** Record the name of a class for annotation processing. */
    abstract void addClassName(String s);

    /** An implementation of OptionHelper that mostly throws exceptions. */
    public static class GrumpyHelper extends OptionHelper {
        private final Log log;

        public GrumpyHelper(Log log) {
            this.log = log;
        }

        @Override
        public Log getLog() {
            return log;
        }

        @Override
        public String getOwnName() {
            throw new IllegalStateException();
        }

        @Override
        public String get(Option option) {
            throw new IllegalArgumentException();
        }

        @Override
        public void put(String name, String value) {
            throw new IllegalArgumentException();
        }

        @Override
        public void remove(String name) {
            throw new IllegalArgumentException();
        }

        @Override
        public boolean handleFileManagerOption(Option option, String value) {
            throw new IllegalArgumentException();
        }

        @Override
        public void addFile(Path p) {
            throw new IllegalArgumentException(p.toString());
        }

        @Override
        public void addClassName(String s) {
            throw new IllegalArgumentException(s);
        }
    }

}
