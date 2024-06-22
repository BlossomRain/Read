/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 *
 * A tree node for an @uses block tag.
 *
 * <p>
 * &#064;uses service-type description
 *
 * @since 9
 */
public interface UsesTree extends BlockTagTree {
    /**
     * Returns the name of the service type being documented.
     * @return the name of the service type
     */
    ReferenceTree getServiceType();

    /**
     * Returns a description of the use of service type within the module.
     * @return the description
     */
    List<? extends DocTree> getDescription();
}
