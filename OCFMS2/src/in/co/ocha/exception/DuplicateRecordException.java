package in.co.ocha.exception;

/**
 * DuplicateRecordException thrown when a duplicate record occurred
 * 
 * @author Nalin 
 * @version 1.0
 * @Copyright (c) Nalin Patel
 * 
 */

public class DuplicateRecordException extends Exception {

	/**
	 * @param msg
	 *            error message
	 */
	public DuplicateRecordException(String msg) {
		super(msg);
	}

}
