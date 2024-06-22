/*
 * Copyright (c) 1999, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.parser;

import java.util.HashMap;
import java.util.Map;

import com.sun.tools.javac.parser.Tokens.Comment;
import com.sun.tools.javac.tree.DCTree.DCDocComment;
import com.sun.tools.javac.tree.DocCommentTable;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.DiagnosticSource;


/**
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class LazyDocCommentTable implements DocCommentTable {
    private static class Entry {
        final Comment comment;
        DCDocComment tree;

        Entry(Comment c) {
            comment = c;
        }
    }

    ParserFactory fac;
    DiagnosticSource diagSource;
    Map<JCTree, Entry> table;

    LazyDocCommentTable(ParserFactory fac) {
        this.fac = fac;
        diagSource = fac.log.currentSource();
        table = new HashMap<>();
    }

    public boolean hasComment(JCTree tree) {
        return table.containsKey(tree);
    }

    public Comment getComment(JCTree tree) {
        Entry e = table.get(tree);
        return (e == null) ? null : e.comment;
    }

    public String getCommentText(JCTree tree) {
        Comment c = getComment(tree);
        return (c == null) ? null : c.getText();
    }

    public DCDocComment getCommentTree(JCTree tree) {
        Entry e = table.get(tree);
        if (e == null)
            return null;
        if (e.tree == null)
            e.tree = new DocCommentParser(fac, diagSource, e.comment).parse();
        return e.tree;
    }

    public void putComment(JCTree tree, Comment c) {
        table.put(tree, new Entry(c));
    }

}
