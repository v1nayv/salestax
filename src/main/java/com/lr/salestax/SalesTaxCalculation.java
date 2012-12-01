
package com.lr.salestax;

import java.io.File;

import com.lr.salestax.impl.SalesTaxFileInputParser;

/**
 * Description: Description goes here.
 * 
 * @author <a href="mailto:xxx@xxx">Vinay Vasudevamurthy</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
public class SalesTaxCalculation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final InputParser<File> inputParser = new SalesTaxFileInputParser();
		final Transaction transaction = inputParser.parseInput(new File(args[0]));
		transaction.compute();

	}
}
