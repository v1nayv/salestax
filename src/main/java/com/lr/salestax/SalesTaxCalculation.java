
package com.lr.salestax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;

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
		Scanner s = null;
		try {
			s = new Scanner(new FileInputStream(new File(args[0])));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (s.hasNext()) {
			s.nextLine();
			s.findInLine("(\\d+) (.*) (.*)");
			MatchResult result = s.match();
			for (int i = 1; i <= result.groupCount(); i++) {
				System.out.println(result.group(i));
			}
		}
		s.close();
	}
}
