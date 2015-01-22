package at.gov.parlament.documentation.hermes.services;

import at.gov.parlament.documentation.hermes.domain.IRecordConfig;

public class RecordServiceImpl implements IRecordService {
	
	public void record(IRecordConfig config) throws ServiceException {
		if ( config == null ) {
			throw new ServiceException(ServiceExceptionCode.RECORD_CONFIG_NULL);
		}
	}

}
