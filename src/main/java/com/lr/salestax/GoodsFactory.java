
package com.lr.salestax;

import com.lr.salestax.goods.Goods;
import com.lr.salestax.goods.impl.Books;
import com.lr.salestax.goods.impl.Food;
import com.lr.salestax.goods.impl.MedicalProducts;
import com.lr.salestax.goods.impl.MiscGoods;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class GoodsFactory {

	/**
	 * @param type
	 * @param noOfItems
	 * @param goodsDescription
	 * @param goodsCostPerItem
	 * @param isImported
	 * @return Goods object
	 */
	public Goods createGoods(final GoodsType type, final double noOfItems, final String goodsDescription, final double goodsCostPerItem, final boolean isImported) {

		final Goods goodsObjToReturn;
		switch (type) {
		case BOOKS:
			goodsObjToReturn = createBook(noOfItems, goodsDescription, goodsCostPerItem, isImported);
			break;

		case FOOD:
			goodsObjToReturn = createFood(noOfItems, goodsDescription, goodsCostPerItem, isImported);
			break;

		case MEDICAL_PRODUCTS:
			goodsObjToReturn = createMedicalProducts(noOfItems, goodsDescription, goodsCostPerItem, isImported);
			break;

		case MISC_GOODS:
			goodsObjToReturn = createMiscProducts(noOfItems, goodsDescription, goodsCostPerItem, isImported);
			break;
		default:
			goodsObjToReturn = createMiscProducts(noOfItems, goodsDescription, goodsCostPerItem, isImported);
			break;
		}

		return goodsObjToReturn;
	}

	/**
	 * @param noOfItems
	 * @param goodsDescription
	 * @param goodsCostPerItem
	 * @param isImported
	 * @return
	 */
	private Goods createBook(double noOfItems, String goodsDescription, double goodsCostPerItem, boolean isImported) {

		return new Books(goodsDescription, goodsCostPerItem, noOfItems, isImported);
	}

	/**
	 * @param noOfItems
	 * @param goodsDescription
	 * @param goodsCostPerItem
	 * @param isImported
	 * @return
	 */
	private Goods createFood(double noOfItems, String goodsDescription, double goodsCostPerItem, boolean isImported) {

		return new Food(goodsDescription, goodsCostPerItem, noOfItems, isImported);
	}

	/**
	 * @param noOfItems
	 * @param goodsDescription
	 * @param goodsCostPerItem
	 * @param isImported
	 * @return
	 */
	private Goods createMedicalProducts(double noOfItems, String goodsDescription, double goodsCostPerItem, boolean isImported) {

		return new MedicalProducts(goodsDescription, goodsCostPerItem, noOfItems, isImported);
	}

	/**
	 * @param noOfItems
	 * @param goodsDescription
	 * @param goodsCostPerItem
	 * @param isImported
	 * @return
	 */
	private Goods createMiscProducts(double noOfItems, String goodsDescription, double goodsCostPerItem, boolean isImported) {

		return new MiscGoods(goodsDescription, goodsCostPerItem, noOfItems, isImported);
	}

}
