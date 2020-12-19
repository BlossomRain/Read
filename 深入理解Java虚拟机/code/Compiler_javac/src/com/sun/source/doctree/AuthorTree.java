/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

import java.util.List;

/**
 * A tree node for an @author block tag.
 *
 * <p>
 * &#064;author name-text.
 *
 * @since 1.8
 */
public interface AuthorTree extends BlockTagTree {
    /**
     * Returns the name of the author.
     * @return the name
     */
    List<? extends DocTree> getName();
}
