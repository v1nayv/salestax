
package com.lr.salestax.goods;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public abstract class Goods {

	private final String _goodsDescription;

	private final double _goodsCostPerItem;

	private final double _noOfItems;

	private final boolean _isImported;

	/**
	 * 
	 */
	public static final double SALES_TAX = 0.10;

	/**
	 * 
	 */
	public static final double IMPORTED_DUTY_TAX = 0.05;

	/**
	 * @param goodsDescription name of the goods
	 * @param goodsCostPerItem cost of the good
	 * @param noOfItems no of item.
	 * @param isImported true if the good is imported
	 */
	public Goods(final String goodsDescription, final double goodsCostPerItem, final double noOfItems, final boolean isImported) {
		_goodsDescription = goodsDescription;
		_goodsCostPerItem = goodsCostPerItem;
		_noOfItems = noOfItems;
		_isImported = isImported;
	}

	/**
	 * @return the goodsCostPerItem
	 */
	public double getGoodsCostPerItem() {
		return _goodsCostPerItem;
	}

	/**
	 * @return the goodsDescription
	 */
	public String getGoodsDescription() {
		return _goodsDescription;
	}

	/**
	 * @return the noOfItems
	 */
	public double getNoOfItems() {
		return _noOfItems;
	}

	/**
	 * @return sales tax amount
	 */
	public abstract double getSalesTaxAmount();

	/**
	 * @return the isImported
	 */
	public boolean isImported() {
		return _isImported;
	}

	/**
	 * @return imported duty tax amount.
	 */
	protected double getImportedDutyTaxAmount() {

		return _goodsCostPerItem * _noOfItems * IMPORTED_DUTY_TAX;
	}

}
