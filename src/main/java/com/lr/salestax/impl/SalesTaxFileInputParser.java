
package com.lr.salestax.impl;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.MatchResult;

import com.lr.salestax.GoodsFactory;
import com.lr.salestax.GoodsType;
import com.lr.salestax.InputParser;
import com.lr.salestax.Transaction;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class SalesTaxFileInputParser
	implements InputParser<File>
{

	private static final int NO_OF_ITEMS_INDEX = 1;

	private static final int GOODS_DESCRIPTION_INDEX = 2;

	private static final int GOODS_COST_INDEX = 3;

	private static List<String> BOOKS_FILTER_LIST;

	private static List<String> MEDICALGOODS_FILTER_LIST;

	private static List<String> FOODS_TYPE_LIST;

	private static final String INPUT_REGEX = "(\\d+) (.*) at (.*)";

	private static final String REGEX_COMMA_SEPARATED_VALUES = "\\s*,\\s*";

	private static final String IMPORTED_KEYWORD = "imported";

	private final GoodsFactory _goodsFactory = new GoodsFactory();

	static {

		final Properties salesTaxProperties = new Properties();
		final ClassLoader loader = Thread.currentThread().getContextClassLoader();
		final InputStream stream = loader.getResourceAsStream("salestax.properties");
		try {
			salesTaxProperties.load(stream);
			BOOKS_FILTER_LIST = asList(salesTaxProperties.getProperty("books.type.list").split(REGEX_COMMA_SEPARATED_VALUES));
			MEDICALGOODS_FILTER_LIST = asList(salesTaxProperties.getProperty("medicalgoods.type.list").split(REGEX_COMMA_SEPARATED_VALUES));
			FOODS_TYPE_LIST = asList(salesTaxProperties.getProperty("foods.type.list").split(REGEX_COMMA_SEPARATED_VALUES));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.InputParser#parseInput(java.lang.Object)
	 */
	@Override
	public Transaction parseInput(File file) {

		final Transaction transaction = new SalesTaxTransaction();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			@SuppressWarnings("unused")
			String line = scanner.findInLine(INPUT_REGEX);
			MatchResult result = scanner.match();
			final double noOfItems = Double.parseDouble(result.group(NO_OF_ITEMS_INDEX));
			final String goodsDescription = result.group(GOODS_DESCRIPTION_INDEX);
			final double goodsCostPerItem = Double.parseDouble(result.group(GOODS_COST_INDEX));
			final GoodsType goodsType = getGoodsType(goodsDescription);
			final boolean isImported = isImported(goodsDescription);

			((SalesTaxTransaction) transaction).addGoods(_goodsFactory.createGoods(goodsType, noOfItems, goodsDescription, goodsCostPerItem, isImported));

			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}

		}
		scanner.close();

		return transaction;

	}

	/**
	 * @param goodsDescription
	 * @return
	 */
	private GoodsType getGoodsType(final String goodsDescription) {

		GoodsType typeToReturn = GoodsType.MISC_GOODS;
		for (final String booksFilterList : BOOKS_FILTER_LIST) {
			if (goodsDescription.contains(booksFilterList)) {
				typeToReturn = GoodsType.BOOKS;
				break;
			}
		}

		for (final String medicalFilterList : MEDICALGOODS_FILTER_LIST) {
			if (goodsDescription.contains(medicalFilterList)) {
				typeToReturn = GoodsType.MEDICAL_PRODUCTS;
				break;
			}
		}

		for (final String medicalFilterList : FOODS_TYPE_LIST) {
			if (goodsDescription.contains(medicalFilterList)) {
				typeToReturn = GoodsType.FOOD;
				break;
			}
		}

		return typeToReturn;
	}

	/**
	 * @param goodsDescription
	 * @return
	 */
	private boolean isImported(final String goodsDescription) {
		return goodsDescription.contains(IMPORTED_KEYWORD);
	}
}
