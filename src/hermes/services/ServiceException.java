package hermes.services;

import hermes.exceptions.HermesExceptionCode;
import hermes.exceptions.HermesException;

public class ServiceException extends HermesException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(HermesExceptionCode code) {
		super(code);
	}

}
