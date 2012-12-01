
package com.lr.salestax.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lr.salestax.Transaction;
import com.lr.salestax.goods.Goods;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class SalesTaxTransaction
	implements Transaction
{

	private List<Goods> _listOfGoods = Collections.emptyList();

	/**
	 * @param goods
	 */
	public void addGoods(final Goods goods) {
		if (_listOfGoods == Collections.EMPTY_LIST) {
			_listOfGoods = new ArrayList<Goods>();
		}
		_listOfGoods.add(goods);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.lr.salestax.Transaction#compute()
	 */
	@Override
	public void compute() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the listOfGoods
	 */
	public List<Goods> getListOfGoods() {
		return Collections.unmodifiableList(_listOfGoods);
	}

}