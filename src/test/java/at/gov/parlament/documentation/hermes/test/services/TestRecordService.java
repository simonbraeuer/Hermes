package at.gov.parlament.documentation.hermes.test.services;


import static org.junit.Assert.*;

import org.junit.Test;

import at.gov.parlament.documentation.hermes.services.RecordServiceImpl;
import at.gov.parlament.documentation.hermes.services.ServiceException;
import at.gov.parlament.documentation.hermes.services.ServiceExceptionCode;

public class TestRecordService {

	@Test
	public void testRecordServiceImplNull() {
		RecordServiceImpl recordService = new RecordServiceImpl();
		try {
			recordService.record(null);
			fail();
		} catch (ServiceException e) {
			assertEquals (e.getCode(),ServiceExceptionCode.RECORD_CONFIG_NULL);
		}
	}

}
