/**
 * File Name: top.hting.exception.CustomeException.java

 * @Date:2018年8月28日下午10:27:30
 */
package top.hting.exception;

/**
 * File Name: top.hting.exception.CustomeException.java
 * 
 * @Date:2018年8月28日下午10:27:30
 */
public class CustomeException extends RuntimeException {

	/**
	 * 
	 */
	
	public CustomeException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	
	public CustomeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	
	public CustomeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	
	public CustomeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	
	public CustomeException(Throwable cause) {
		super(cause);
	}
	
	
	
}
