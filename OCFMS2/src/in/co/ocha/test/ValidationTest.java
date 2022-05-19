package in.co.ocha.test;

import in.co.util.DataValidator;

public class ValidationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		if (DataValidator.isNull("22") || !DataValidator.isInteger("kkkkkkkkkkkkkkkkk")) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}
		
	}

}
