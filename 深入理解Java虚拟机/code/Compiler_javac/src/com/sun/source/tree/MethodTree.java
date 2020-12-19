/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

import java.util.List;
import javax.lang.model.element.Name;

/**
 * A tree node for a method or annotation type element declaration.
 *
 * For example:
 * <pre>
 *   <em>modifiers</em> <em>typeParameters</em> <em>type</em> <em>name</em>
 *      ( <em>parameters</em> )
 *      <em>body</em>
 *
 *   <em>modifiers</em> <em>type</em> <em>name</em> () default <em>defaultValue</em>
 * </pre>
 *
 * @jls sections 8.4, 8.6, 8.7, 9.4, and 9.6
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
public interface MethodTree extends Tree {
    /**
     * Returns the modifiers, including any annotations for the method being declared.
     * @return the modifiers
     */
    ModifiersTree getModifiers();

    /**
     * Returns the name of the method being declared.
     * @return the name
     */
    Name getName();

    /**
     * Returns the return type of the method being declared.
     * Returns {@code null} for a constructor.
     * @return the return type
     */
    Tree getReturnType();

    /**
     * Returns the type parameters of the method being declared.
     * @return the type parameters
     */
    List<? extends TypeParameterTree> getTypeParameters();

    /**
     * Returns the parameters of the method being declared.
     * @return the parameters
     */
    List<? extends VariableTree> getParameters();

    /**
     * Return an explicit receiver parameter ("this" parameter),
     * or {@code null} if none.
     *
     * @return an explicit receiver parameter ("this" parameter)
     * @since 1.8
     */
    VariableTree getReceiverParameter();

    /**
     * Returns the exceptions listed as being thrown by this method.
     * @return the exceptions
     */
    List<? extends ExpressionTree> getThrows();

    /**
     * Returns the method body, or {@code null} if this is an abstract or native method.
     * @return the method body
     */
    BlockTree getBody();

    /**
     * Returns the default value, if this is an element within
     * an annotation type declaration.
     * Returns {@code null} otherwise.
     * @return the default value
     */
    Tree getDefaultValue(); // for annotation types
}
