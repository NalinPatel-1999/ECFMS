package in.co.ocha.exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
 * 
 * @author Nalin
 * @version 1.0
 * @Copyright (c) Nalin Patel
 * 
 */

public class RecordNotFoundException extends Exception{

	/**
	 * @param msg
	 *            error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);

	}
}
