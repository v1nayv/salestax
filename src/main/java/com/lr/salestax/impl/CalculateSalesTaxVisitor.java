
package com.lr.salestax.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lr.salestax.GoodsVisitor;
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
public final class CalculateSalesTaxVisitor
	implements GoodsVisitor
{

	private final DecimalFormat _decimalFormat = new DecimalFormat("#.##");

	private final List<String> _output;

	private double _salesTax = 0;

	private double _total = 0;

	/**
	 * 
	 */
	public CalculateSalesTaxVisitor() {
		_output = new ArrayList<String>();
	}

	/**
	 * @return the output
	 */
	public List<String> getOutput() {
		return Collections.unmodifiableList(_output);
	}

	/**
	 * @return the salesTax
	 */
	public double getSalesTax() {
		return _salesTax;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return _total;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.GoodsVisitor#visit(com.lr.salestax.goods.impl.Books)
	 */
	@Override
	public void visit(final Books books) {
		processGoods(books);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.GoodsVisitor#visit(com.lr.salestax.goods.impl.Food)
	 */
	@Override
	public void visit(final Food food) {
		processGoods(food);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.GoodsVisitor#visit(com.lr.salestax.goods.impl.MedicalProducts)
	 */
	@Override
	public void visit(final MedicalProducts medicalProducts) {
		processGoods(medicalProducts);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.GoodsVisitor#visit(com.lr.salestax.goods.impl.MiscGoods)
	 */
	@Override
	public void visit(final MiscGoods miscGoods) {
		processGoods(miscGoods);

	}

	private double calculateTotal(final Goods goods) {
		double total = 0;
		if (goods.isImported()) {
			total += goods.getImportedDutyTaxAmount();
		}

		return total + (goods.getNoOfItems() * goods.getGoodsCostPerItem() + roundOfSalesTax(goods.getSalesTaxAmount()));
	}

	private void processGoods(final Goods goods) {
		_total += calculateTotal(goods);
		_salesTax += goods.getSalesTaxAmount();
		if (goods.isImported()) {
			_salesTax += roundOfSalesTax(goods.getImportedDutyTaxAmount());
		}
		_output.add(goods.getNoOfItems() + " " + goods.getGoodsDescription() + " : " + _decimalFormat.format(calculateTotal(goods)));

	}

	private double roundOfSalesTax(final double value) {

		final BigDecimal salesTax = BigDecimal.valueOf(value);
		return salesTax.setScale(1, RoundingMode.HALF_UP).setScale(2).doubleValue();

	}

}
