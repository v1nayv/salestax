
package com.lr.salestax.impl;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.lr.salestax.goods.Goods;
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
public class SalesTaxFileInputParserTestCase {

	private static final String PATH_TO_INPUT_FILE = "src/test/resources/sampleinput.txt";

	/**
	 * 
	 */
	@Test
	public void testIfInputParsingWorksCorrectly() {

		final SalesTaxFileInputParser inputParser = new SalesTaxFileInputParser();

		final SalesTaxTransaction transaction = (SalesTaxTransaction) inputParser.parseInput(new File(PATH_TO_INPUT_FILE));

		final List<Goods> goodsList = transaction.getListOfGoods();
		final Goods miscGoods = goodsList.get(0);
		final Goods medicalGoods = goodsList.get(1);
		final Goods foodGoods = goodsList.get(2);

		assertMiscGoods(miscGoods);
		assertMedicalGoods(medicalGoods);
		assertFoodGoods(foodGoods);

	}

	/**
	 * @param foodGoods
	 */
	private void assertFoodGoods(Goods foodGoods) {

		assertTrue("Wrong type of Goods", foodGoods instanceof Food);
		assertEquals("Cost per item is wrong", Double.valueOf(11.25), Double.valueOf(foodGoods.getGoodsCostPerItem()));
		assertEquals("No.of  item is wrong", Double.valueOf(2.0), Double.valueOf(foodGoods.getNoOfItems()));
		assertTrue("isImported has wrong value", foodGoods.isImported());

	}

	/**
	 * @param medicalGoods
	 */
	private void assertMedicalGoods(Goods medicalGoods) {
		assertTrue("Wrong type of Goods", medicalGoods instanceof MedicalProducts);
		assertEquals("Cost per item is wrong", Double.valueOf(9.75), Double.valueOf(medicalGoods.getGoodsCostPerItem()));
		assertEquals("No.of  item is wrong", Double.valueOf(1.0), Double.valueOf(medicalGoods.getNoOfItems()));
		assertFalse("isImported has wrong value", medicalGoods.isImported());

	}

	/**
	 * @param miscGoods
	 */
	private void assertMiscGoods(Goods miscGoods) {
		assertTrue("Wrong type of Goods", miscGoods instanceof MiscGoods);
		assertEquals("Cost per item is wrong", Double.valueOf(18.99), Double.valueOf(miscGoods.getGoodsCostPerItem()));
		assertEquals("No.of  item is wrong", Double.valueOf(1.0), Double.valueOf(miscGoods.getNoOfItems()));
		assertFalse("isImported has wrong value", miscGoods.isImported());

	}
}
