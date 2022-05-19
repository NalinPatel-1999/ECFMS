package in.co.ocha.exception;

/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * 
 * @author Nalin
 * @version 1.0
 * @Copyright (c) Nalin Patel
 * 
 */
public class ApplicationException extends Exception {

	/**
	 * @param msg
	 *            : Error message
	 */
	Exception rootException = null;
	
	public ApplicationException(String msg) {
		super(msg);
	}
	public ApplicationException(Exception e) {
		super(e.getMessage());
		rootException = e;
	}

}
