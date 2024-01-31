package it.capgemini.archetype.srv.exception;

public class BusinessServiceException extends RuntimeException {
	private static final long serialVersionUID = 4443003279173894607L;

	public BusinessServiceException() {
		super();
	}

	public BusinessServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessServiceException(String message) {
		super(message);
	}

	public BusinessServiceException(Throwable cause) {
		super(cause);
	}

}
