
package com.lr.salestax;


/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @param <T>
 * @since 0.1
 */
public interface InputParser<T> {

	/**
	 * @param t
	 * @return Transaction object.
	 */
	Transaction parseInput(T t);
}
