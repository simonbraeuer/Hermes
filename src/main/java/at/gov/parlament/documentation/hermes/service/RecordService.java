package at.gov.parlament.documentation.hermes.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import at.gov.parlament.documentation.hermes.dao.CategoryEntity;
import at.gov.parlament.documentation.hermes.dao.ICategoryDao;
import at.gov.parlament.documentation.hermes.domain.CutVideoRecordConfig;
import at.gov.parlament.documentation.hermes.domain.IRecordConfig;
import at.gov.parlament.documentation.hermes.exceptions.RecordServiceException;
import at.gov.parlament.documentation.hermes.exceptions.RecordServiceExceptionCode;
import at.gov.parlament.documentation.hermes.service.IRecordService;

@Slf4j
public class RecordService implements IRecordService {
	private static final String FFMPEG_BINARY = "/Users/sbr/bachelordata/bin/ffmpeg";
	
	public void record(IRecordConfig config) throws RecordServiceException {
		log.debug("record: {}", config);
		if ( config == null ) {
			throw new RecordServiceException(RecordServiceExceptionCode.RECORD_CONFIG_NULL);
		}
		
		if ( config instanceof CutVideoRecordConfig ) {
			recordCutVideo ( (CutVideoRecordConfig) config );
		}
		else
		{
			throw new RecordServiceException(RecordServiceExceptionCode.RECORD_CONFIG_CLASS_UNKNOWN);
		}
	}
	
	private void recordCutVideo (CutVideoRecordConfig config) throws RecordServiceException {
		log.debug("recordCutVideo(): {}", config);
		
		String command = FFMPEG_BINARY+" -ss " + config.getStartTime() + " -i " + config.getInVideo() + " -t " + config.getEndTime() + " -c copy " + config.getOutVideo();
		//CategoryEntity entity = new CategoryEntity();
		//iCategoryDao.create(entity);
		try {
			if (executeCommand (command) != 0) {
				throw new RecordServiceException(RecordServiceExceptionCode.RECORD_CUTVIDEO_EXCEPTION);
			}
		} catch (IOException e) {
			throw new RecordServiceException(RecordServiceExceptionCode.RECORD_CUTVIDEO_EXCEPTION);
		} catch (InterruptedException e) {
			throw new RecordServiceException(RecordServiceExceptionCode.RECORD_CUTVIDEO_EXCEPTION);
		}
	}
	
	private int executeCommand (String command) throws IOException, InterruptedException {
		log.info("excuteCommand: {}", command);
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
		log.info("excuteCommand->result: {}", process.exitValue());
		return process.exitValue();
	}
}
