
package com.lr.salestax.impl;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.lr.salestax.goods.Goods;
import com.lr.salestax.goods.impl.Books;
import com.lr.salestax.goods.impl.Food;
import com.lr.salestax.goods.impl.MiscGoods;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class CalculateSalesTaxVisitorTestCase {

	private CalculateSalesTaxVisitor _calculateSalesTaxVisitor;

	/**
	 * 
	 */
	@Before
	public void setup() {
		_calculateSalesTaxVisitor = new CalculateSalesTaxVisitor();
	}

	/**
	 * 
	 */
	@Test
	public void testTransactionForGoodsNotImported() {
		final List<Goods> goodsList = getMockGoods();
		process(goodsList);
		final List<String> output = _calculateSalesTaxVisitor.getOutput();
		final String salesTax = _calculateSalesTaxVisitor.getSalesTaxAsString();
		final String total = _calculateSalesTaxVisitor.getTotalAsString();

		assertEquals("Output size  was not as expected", 3, output.size());
		assertEquals("Output was not as expected", "1 book : 12.49", output.get(0));
		assertEquals("Output was not as expected", "1 music CD : 16.49", output.get(1));
		assertEquals("Output was not as expected", "1 chocolate bar : 0.85", output.get(2));
		assertEquals("Sales Tax was not as expected", "1.5", salesTax);
		assertEquals("Total was not as expected", "29.83", total);

	}

	/**
	 * 
	 */
	@Test
	public void testTransactionForImportedGoods() {
		final List<Goods> goodsList = getImportedMockGoods();
		process(goodsList);
		final List<String> output = _calculateSalesTaxVisitor.getOutput();
		final String salesTax = _calculateSalesTaxVisitor.getSalesTaxAsString();
		final String total = _calculateSalesTaxVisitor.getTotalAsString();

		assertEquals("Output size  was not as expected", 2, output.size());
		assertEquals("Output was not as expected", "1 imported box of chocolates : 10.5", output.get(0));
		assertEquals("Output was not as expected", "1 imported bottle of perfume : 54.65", output.get(1));
		assertEquals("Sales Tax was not as expected", "7.65", salesTax);
		assertEquals("Total was not as expected", "65.15", total);

	}

	private List<Goods> getImportedMockGoods() {

		final Goods food = new Food("imported box of chocolates", 10.00, 1, true);
		final Goods miscGoods = new MiscGoods("imported bottle of perfume", 47.50, 1, true);

		return asList(food, miscGoods);
	}

	/**
	 * @return
	 */
	private List<Goods> getMockGoods() {
		final Goods books = new Books("book", 12.49, 1, false);
		final Goods miscProducts = new MiscGoods("music CD", 14.99, 1, false);
		final Goods foods = new Food("chocolate bar", 0.85, 1, false);

		return asList(books, miscProducts, foods);
	}

	/**
	 * @param goodsList
	 */
	private void process(List<Goods> goodsList) {

		for (final Goods goods : goodsList) {
			goods.welcome(_calculateSalesTaxVisitor);
		}

	}

}
