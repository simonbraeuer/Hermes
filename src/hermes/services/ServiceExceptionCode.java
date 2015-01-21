package hermes.services;

import hermes.exceptions.HermesExceptionCode;

public enum ServiceExceptionCode implements HermesExceptionCode {
	
	RECORD_CONFIG_NULL(201);

	private final int number;

	private ServiceExceptionCode(int number) {
		this.number = number;
	}
	
	@Override
	public int getNumber() {
		return number;
	}

}
