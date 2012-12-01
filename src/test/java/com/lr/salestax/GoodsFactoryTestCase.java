
package com.lr.salestax;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
@RunWith(JUnit4.class)
public class GoodsFactoryTestCase {

	/**
	 * 
	 */
	@Test
	public void testBookCreation() {

		final Goods objCreated = new GoodsFactory().createGoods(GoodsType.BOOKS, 5, "blahblah", 10, false);

		assertTrue("Object created was not of type Books", objCreated instanceof Books);
	}

	/**
	 * 
	 */
	@Test
	public void testFoodCreation() {

		final Goods objCreated = new GoodsFactory().createGoods(GoodsType.FOOD, 5, "blahblah", 10, false);

		assertTrue("Object created was not of type Food", objCreated instanceof Food);
	}

	/**
	 * 
	 */
	@Test
	public void testMedicalProductsCreation() {

		final Goods objCreated = new GoodsFactory().createGoods(GoodsType.MEDICAL_PRODUCTS, 5, "blahblah", 10, false);

		assertTrue("Object created was not of type MedicalProducts", objCreated instanceof MedicalProducts);
	}

	/**
	 * 
	 */
	@Test
	public void testMiscProductsCreation() {

		final Goods objCreated = new GoodsFactory().createGoods(GoodsType.MISC_GOODS, 5, "blahblah", 10, false);

		assertTrue("Object created was not of type MiscGoods", objCreated instanceof MiscGoods);
	}

}
