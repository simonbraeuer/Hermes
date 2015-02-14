package at.gov.parlament.documentation.hermes.exceptions;


public enum HashingServiceExceptionCode implements HermesExceptionCode {
	
	HASHING_EXCEPTION(201);

	private final int number;

	private HashingServiceExceptionCode(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

}
