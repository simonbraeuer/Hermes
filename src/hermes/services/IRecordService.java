package hermes.services;

import hermes.domain.IRecordConfig;

public interface IRecordService {
	void record (IRecordConfig config) throws ServiceException;
}
