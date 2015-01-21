package hermes.test.services;


import static org.junit.Assert.*;
import hermes.services.RecordServiceImpl;
import hermes.services.ServiceException;
import hermes.services.ServiceExceptionCode;

import org.junit.Test;

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
