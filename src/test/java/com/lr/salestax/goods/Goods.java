
package com.lr.salestax.goods;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public interface Goods {

	/**
	 * 
	 */
	double SALES_TAX = 0.10;

	/**
	 * 
	 */
	double IMPORTED_DUTY_TAX = 0.05;

	/**
	 * @return goods value per item.
	 */
	double getGoodsValue();

	/**
	 * @return imprted duty tax amount.
	 */
	double getImportedDutyTaxAmount();

	/**
	 * @return number of goods
	 */
	double getNumberOfGoods();

	/**
	 * @return sales tax amount
	 */
	double getSalesTaxAmount();

}
