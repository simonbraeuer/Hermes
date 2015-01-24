package at.gov.parlament.documentation.hermes.services;

import at.gov.parlament.documentation.hermes.exceptions.HermesExceptionCode;

public enum ServiceExceptionCode implements HermesExceptionCode {
	
	RECORD_CONFIG_NULL(201), RECORD_CUTVIDEO_EXCEPTION(202), RECORD_CONFIG_CLASS_UNKNOWN(203);

	private final int number;

	private ServiceExceptionCode(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

}
