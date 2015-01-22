package at.gov.parlament.documentation.hermes.services;

import at.gov.parlament.documentation.hermes.exceptions.HermesExceptionCode;

public enum ServiceExceptionCode implements HermesExceptionCode {
	
	RECORD_CONFIG_NULL(201);

	private final int number;

	private ServiceExceptionCode(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

}
