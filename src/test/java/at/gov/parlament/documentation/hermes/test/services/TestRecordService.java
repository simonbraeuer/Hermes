package at.gov.parlament.documentation.hermes.test.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.gov.parlament.documentation.hermes.domain.CutVideoRecordConfig;
import at.gov.parlament.documentation.hermes.exceptions.RecordServiceException;
import at.gov.parlament.documentation.hermes.exceptions.RecordServiceExceptionCode;
import at.gov.parlament.documentation.hermes.service.RecordService;

public class TestRecordService {
	
	private static String MPG_IN ="/Users/sbr/git/hermes/src/test/resources/video/testvideo.mpg";
	private static String MPG_OUT = "/Users/sbr/git/hermes/src/test/resources/video/output/out.mpg";
	private static String STARTTIME ="01:02:45";
	private static String ENDTIME ="01:03:00";
	
	/***
	 * Test if exception is thrown when configuration is null.
	 */
	@Test
	public void testRecordServiceImplNull() {
		RecordService recordService = new RecordService();
		try {
			recordService.record(null);
			fail();
		} catch (RecordServiceException e) {
			assertEquals (e.getCode(),RecordServiceExceptionCode.RECORD_CONFIG_NULL);
		}
	}
	
	/***
	 * Test if exception is thrown when config is wrong configured.
	 * @throws RecordServiceException expected
	 */
	@Test(expected=RecordServiceException.class)
	public void testRecordServiceImplWrongConfig() throws RecordServiceException {
		RecordService recordService = new RecordService();
		recordService.record(new CutVideoRecordConfig("notExistingVideo.avi", "notExistingVideo2.avi", "", ""));
	}
	
	/***
	 * Test correct mpg record with start and endtime
	 * @throws RecordServiceException not expected
	 */
	@Test
	public void testRecordServiceImplMpg() throws RecordServiceException {
		RecordService recordService = new RecordService();
		recordService.record(new CutVideoRecordConfig(MPG_IN, MPG_OUT, STARTTIME, ENDTIME));
	}

}
