package hermes.services;

import hermes.domain.IRecordConfig;

public class RecordServiceImpl implements IRecordService {
	
	
	@Override
	public void record(IRecordConfig config) throws ServiceException {
		if ( config == null ) {
			throw new ServiceException(ServiceExceptionCode.RECORD_CONFIG_NULL);
		}
	}

}
