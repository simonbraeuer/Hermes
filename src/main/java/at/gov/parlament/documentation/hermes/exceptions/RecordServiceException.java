package at.gov.parlament.documentation.hermes.exceptions;



public class RecordServiceException extends HermesException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordServiceException(RecordServiceExceptionCode code) {
		super(code);
	}

}
