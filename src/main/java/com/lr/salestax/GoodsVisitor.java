
package com.lr.salestax;

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
public interface GoodsVisitor {

	/**
	 * @param books
	 */
	void visit(Books books);

	/**
	 * @param food
	 */
	void visit(Food food);

	/**
	 * @param medicalProducts
	 */
	void visit(MedicalProducts medicalProducts);

	/**
	 * @param miscGoods
	 */
	void visit(MiscGoods miscGoods);

}
