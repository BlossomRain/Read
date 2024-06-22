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
 * A tree node for an unrecognized inline tag.
 *
 * <p>
 * &#064;name content
 *
 * @since 1.8
 *
 */
public interface UnknownBlockTagTree extends BlockTagTree {
    /**
     * Returns the content of an unrecognized block tag.
     * @return the content
     */
    List<? extends DocTree> getContent();
}
