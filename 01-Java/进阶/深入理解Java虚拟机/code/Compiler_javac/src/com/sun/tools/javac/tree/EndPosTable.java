/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.tree;

/**
 * Specifies the methods to access a mappings of syntax trees to end positions.
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own
 * risk.  This code and its internal interfaces are subject to change
 * or deletion without notice.</b></p>
 */
public interface EndPosTable {

    /**
     * This method will return the end position of a given tree, otherwise a
     * Positions.NOPOS will be returned.
     * @param tree JCTree
     * @return position of the source tree or Positions.NOPOS for non-existent mapping
     */
    public int getEndPos(JCTree tree);

    /**
     * Store ending position for a tree, the value of which is the greater of
     * last error position and the given ending position.
     * @param tree The tree.
     * @param endpos The ending position to associate with the tree.
     */
    public abstract void storeEnd(JCTree tree, int endpos);

    /**
     * Give an old tree and a new tree, the old tree will be replaced with
     * the new tree, the position of the new tree will be that of the old
     * tree.
     * @param oldtree a JCTree to be replaced
     * @param newtree a JCTree to be replaced with
     * @return position of the old tree or Positions.NOPOS for non-existent mapping
     */
    public int replaceTree(JCTree oldtree, JCTree newtree);
}
