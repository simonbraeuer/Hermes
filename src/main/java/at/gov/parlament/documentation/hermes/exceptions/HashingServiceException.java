package at.gov.parlament.documentation.hermes.exceptions;



public class HashingServiceException extends HermesException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HashingServiceException(HashingServiceExceptionCode code) {
		super(code);
	}

}
