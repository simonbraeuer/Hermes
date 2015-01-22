package at.gov.parlament.documentation.hermes.services;

import at.gov.parlament.documentation.hermes.exceptions.HermesException;
import at.gov.parlament.documentation.hermes.exceptions.HermesExceptionCode;

public class ServiceException extends HermesException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(HermesExceptionCode code) {
		super(code);
	}

}
