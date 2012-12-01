
package com.lr.salestax.goods.impl;

import com.lr.salestax.goods.Goods;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class Books
	extends Goods
{

	/**
	 * @param goodsDescription
	 * @param goodsCostPerItem
	 * @param noOfItems
	 * @param isImported
	 */
	public Books(final String goodsDescription, final double goodsCostPerItem, final double noOfItems, final boolean isImported) {
		super(goodsDescription, goodsCostPerItem, noOfItems, isImported);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.goods.Goods#getSalesTaxAmount()
	 */
	@Override
	public double getSalesTaxAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
