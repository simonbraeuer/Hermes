package hermes.exceptions;

public class HermesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HermesExceptionCode code;
    
	
	public HermesException(HermesExceptionCode code) {
		this.code = code;
	}


	public HermesExceptionCode getCode() {
		return code;
	}
}
