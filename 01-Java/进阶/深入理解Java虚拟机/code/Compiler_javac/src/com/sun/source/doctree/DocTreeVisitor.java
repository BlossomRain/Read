/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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


/**
 * A visitor of trees, in the style of the visitor design pattern.
 * Classes implementing this interface are used to operate
 * on a tree when the kind of tree is unknown at compile time.
 * When a visitor is passed to an tree's {@link DocTree#accept
 * accept} method, the <code>visit<i>Xyz</i></code> method most applicable
 * to that tree is invoked.
 *
 * <p> Classes implementing this interface may or may not throw a
 * {@code NullPointerException} if the additional parameter {@code p}
 * is {@code null}; see documentation of the implementing class for
 * details.
 *
 * <p> <b>WARNING:</b> It is possible that methods will be added to
 * this interface to accommodate new, currently unknown, doc comment
 * structures added to future versions of the Java&trade; programming
 * language.  Therefore, visitor classes directly implementing this
 * interface may be source incompatible with future versions of the
 * platform.
 *
 * @param <R> the return type of this visitor's methods.  Use {@link
 *            Void} for visitors that do not need to return results.
 * @param <P> the type of the additional parameter to this visitor's
 *            methods.  Use {@code Void} for visitors that do not need an
 *            additional parameter.
 *
 * @since 1.8
 */
public interface DocTreeVisitor<R,P> {

    /**
     * Visits an AttributeTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitAttribute(AttributeTree node, P p);

    /**
     * Visits an AuthorTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitAuthor(AuthorTree node, P p);

    /**
     * Visits a CommentTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitComment(CommentTree node, P p);

    /**
     * Visits a DeprecatedTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitDeprecated(DeprecatedTree node, P p);

    /**
     * Visits a DocCommentTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitDocComment(DocCommentTree node, P p);

    /**
     * Visits a DocRootTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitDocRoot(DocRootTree node, P p);

    /**
     * Visits a DocTypeTree node.
     *
     * @implSpec Visits a {@code DocTypeTree} node
     * by calling {@code visitOther(node, p)}.
     *
     * @param node the node being visited
     * @param p    a parameter value
     * @return a result value
     * @since 10
     */
    default R visitDocType(DocTypeTree node, P p) {
        return visitOther(node, p);
    }

    /**
     * Visits an EndElementTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitEndElement(EndElementTree node, P p);

    /**
     * Visits an EntityTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitEntity(EntityTree node, P p);

    /**
     * Visits an ErroneousTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitErroneous(ErroneousTree node, P p);

    /**
     * Visits a HiddenTree node.
     *
     * @implSpec Visits a {@code HiddenTree} node
     * by calling {@code visitOther(node, p)}.
     *
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     *
     * @since 9
     */
    default R visitHidden(HiddenTree node, P p)  {
        return visitOther(node, p);
    }

    /**
     * Visits an IdentifierTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitIdentifier(IdentifierTree node, P p);

    /**
     * Visits an IndexTree node.
     *
     * @implSpec Visits an {@code IndexTree} node
     * by calling {@code visitOther(node, p)}.
     *
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     *
     * @since 9
     */
    default R visitIndex(IndexTree node, P p) {
        return visitOther(node, p);
    }

    /**
     * Visits an InheritDocTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitInheritDoc(InheritDocTree node, P p);

    /**
     * Visits a LinkTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitLink(LinkTree node, P p);

    /**
     * Visits an LiteralTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitLiteral(LiteralTree node, P p);

    /**
     * Visits a ParamTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitParam(ParamTree node, P p);

    /**
     * Visits a ProvidesTree node.
     *
     * @implSpec Visits a {@code ProvidesTree} node
     * by calling {@code visitOther(node, p)}.
     *
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     *
     * @since 9
     */
    default R visitProvides(ProvidesTree node, P p) {
        return visitOther(node, p);
    }

    /**
     * Visits a ReferenceTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitReference(ReferenceTree node, P p);

    /**
     * Visits a ReturnTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitReturn(ReturnTree node, P p);

    /**
     * Visits a SeeTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitSee(SeeTree node, P p);

    /**
     * Visits a SerialTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitSerial(SerialTree node, P p);

    /**
     * Visits a SerialDataTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitSerialData(SerialDataTree node, P p);

    /**
     * Visits a SerialFieldTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitSerialField(SerialFieldTree node, P p);

    /**
     * Visits a SinceTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitSince(SinceTree node, P p);

    /**
     * Visits a StartElementTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitStartElement(StartElementTree node, P p);

    /**
     * Visits a SummaryTree node.
     *
     * @implSpec Visits a {@code SummaryTree} node
     * by calling {@code visitOther(node, p)}.
     *
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     * @since 10
     */
    default R visitSummary(SummaryTree node, P p) {
        return visitOther(node, p);
    }

    /**
     * Visits a TextTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitText(TextTree node, P p);

    /**
     * Visits a ThrowsTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitThrows(ThrowsTree node, P p);

    /**
     * Visits an UnknownBlockTagTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitUnknownBlockTag(UnknownBlockTagTree node, P p);

    /**
     * Visits an UnknownInlineTagTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitUnknownInlineTag(UnknownInlineTagTree node, P p);

    /**
     * Visits a UsesTree node.
     *
     * @implSpec Visits a {@code UsesTree} node
     * by calling {@code visitOther(node, p)}.
     *
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     *
     * @since 9
     */
    default R visitUses(UsesTree node, P p) {
        return visitOther(node, p);
    }

    /**
     * Visits a ValueTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitValue(ValueTree node, P p);

    /**
     * Visits a VersionTreeTree node.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitVersion(VersionTree node, P p);

    /**
     * Visits an unknown type of DocTree node.
     * This can occur if the set of tags evolves and new kinds
     * of nodes are added to the {@code DocTree} hierarchy.
     * @param node the node being visited
     * @param p a parameter value
     * @return a result value
     */
    R visitOther(DocTree node, P p);
}
