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
 * A tree node for an @since block tag.
 *
 * <p>
 * &#064;since since-text
 *
 * @since 1.8
 */
public interface SinceTree extends BlockTagTree {
    /**
     * Returns the text explaining the availability of the item being documented.
     * @return the text
     */
    List<? extends DocTree> getBody();
}
