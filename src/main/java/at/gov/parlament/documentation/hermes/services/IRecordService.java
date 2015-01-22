package at.gov.parlament.documentation.hermes.services;

import at.gov.parlament.documentation.hermes.domain.IRecordConfig;

public interface IRecordService {
	void record (IRecordConfig config) throws ServiceException;
}
