package at.gov.parlament.documentation.hermes.dao.exceptions;

import at.gov.parlament.documentation.hermes.exceptions.HermesException;
import at.gov.parlament.documentation.hermes.exceptions.HermesExceptionCode;


public class DAOException extends HermesException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(HermesExceptionCode code) {
		super(code);
	}

}
