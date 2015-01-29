package at.gov.parlament.documentation.hermes.services;

import java.io.IOException;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import at.gov.parlament.documentation.hermes.dao.entities.CategoryEntity;
import at.gov.parlament.documentation.hermes.dao.interfaces.CategoryDao;
import at.gov.parlament.documentation.hermes.domain.CutVideoRecordConfig;
import at.gov.parlament.documentation.hermes.domain.IRecordConfig;
import at.gov.parlament.documentation.hermes.services.RecordService;

@Service("userService")
@Slf4j
public class RecordServiceImpl implements RecordService {
	private static final String FFMPEG_BINARY = "/Users/sbr/bachelordata/bin/ffmpeg";
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	public void record(IRecordConfig config) throws ServiceException {
		log.debug("record: {}", config);
		if ( config == null ) {
			throw new ServiceException(ServiceExceptionCode.RECORD_CONFIG_NULL);
		}
		
		if ( config instanceof CutVideoRecordConfig ) {
			recordCutVideo ( (CutVideoRecordConfig) config );
		}
		else
		{
			throw new ServiceException(ServiceExceptionCode.RECORD_CONFIG_CLASS_UNKNOWN);
		}
	}
	
	private void recordCutVideo (CutVideoRecordConfig config) throws ServiceException {
		log.debug("recordCutVideo(): {}", config);
		
		String command = FFMPEG_BINARY+" -ss " + config.getStartTime() + " -i " + config.getInVideo() + " -t " + config.getEndTime() + " -c copy " + config.getOutVideo();
		CategoryEntity entity = new CategoryEntity("test", "Bruno");
		categoryDao.create(entity);
		try {
			if (executeCommand (command) != 0) {
				throw new ServiceException(ServiceExceptionCode.RECORD_CUTVIDEO_EXCEPTION);
			}
		} catch (IOException e) {
			throw new ServiceException(ServiceExceptionCode.RECORD_CUTVIDEO_EXCEPTION);
		} catch (InterruptedException e) {
			throw new ServiceException(ServiceExceptionCode.RECORD_CUTVIDEO_EXCEPTION);
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
