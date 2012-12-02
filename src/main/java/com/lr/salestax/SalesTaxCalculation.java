
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

		if (args.length > 0) {
			final InputParser<File> inputParser = new SalesTaxFileInputParser();
			final Transaction transaction = inputParser.parseInput(new File(args[0]));
			transaction.compute();
		} else {

			System.out.println("Path to input file needs to be passed as command line arguments.");
			System.out.println("Sample input file contents :");
			System.out.println("1 book at 12.49");
			System.out.println("1 music CD at 14.99");
			System.out.println("1 chocolate bar at 0.85");

		}

	}
}
