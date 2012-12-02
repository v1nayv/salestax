
package com.lr.salestax.goods.impl;

import com.lr.salestax.GoodsVisitor;
import com.lr.salestax.goods.Goods;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class Food
	extends Goods
{

	/**
	 * @param goodsDescription
	 * @param goodsCostPerItem
	 * @param noOfItems
	 * @param isImported
	 */
	public Food(final String goodsDescription, final double goodsCostPerItem, final int noOfItems, final boolean isImported) {
		super(goodsDescription, goodsCostPerItem, noOfItems, isImported);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.goods.Goods#getSalesTaxAmount()
	 */
	@Override
	public double getSalesTaxAmount() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.goods.Goods#welcome(com.lr.salestax.GoodsVisitor)
	 */
	@Override
	public void welcome(GoodsVisitor visitor) {
		visitor.visit(this);

	}

}
