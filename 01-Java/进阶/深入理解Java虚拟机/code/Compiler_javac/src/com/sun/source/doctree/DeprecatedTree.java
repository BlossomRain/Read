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
 * A tree node for an @deprecated block tag.
 *
 * <p>
 * &#064;deprecated deprecated text.
 *
 * @since 1.8
 */
public interface DeprecatedTree extends BlockTagTree {
    /**
     * Returns the description explaining why an item is deprecated.
     * @return the description
     */
    List<? extends DocTree> getBody();
}
