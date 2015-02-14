package at.gov.parlament.documentation.hermes.exceptions;


public enum RecordServiceExceptionCode implements HermesExceptionCode {
	
	RECORD_CONFIG_NULL(201), RECORD_CONFIG_CLASS_UNKNOWN(202), RECORD_CUTVIDEO_EXCEPTION(203);

	private final int number;

	private RecordServiceExceptionCode(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}

}