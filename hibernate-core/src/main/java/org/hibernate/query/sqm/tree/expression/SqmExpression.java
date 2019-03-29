/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.query.sqm.tree.expression;

import java.util.function.Supplier;

import org.hibernate.query.sqm.tree.select.SqmSelectableNode;
import org.hibernate.sql.ast.produce.metamodel.spi.ExpressableType;

/**
 * The base contract for any kind of expression node in the SQM tree.
 * An expression might be a reference to an attribute, a literal,
 * a function, etc.
 *
 * @author Steve Ebersole
 */
public interface SqmExpression extends SqmSelectableNode {
	/**
	 * The expression's type
	 *
	 * todo (6.0) : given the conversion to use Suppliers, should this act as the resolution?
	 * 		- iow, should this method consider and inferable and fallback types?
	 * 		- or, should this method act as access to the "inherent type" with
	 * 			an additional resolution method?
	 *
	 * @return The expression's type.
	 */
	ExpressableType getExpressableType();

	/**
	 * Obtains a Supplier for this expression's inferable type.  Used in conjunction with
	 * {@link InferableTypeSqmExpression#impliedType(Supplier)}
	 *
	 * Not all expressions can act as the source of an inferred type, in which case the
	 * method would return {@code null}, or its Supplier would return {@code null}
	 *
	 * @return The inferable type
	 *
	 * @see InferableTypeSqmExpression#impliedType
	 */
	Supplier<? extends ExpressableType> getInferableType();
}