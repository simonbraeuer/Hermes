package at.gov.parlament.documentation.hermes.services;

import org.springframework.stereotype.Service;

import at.gov.parlament.documentation.hermes.domain.IRecordConfig;


public interface RecordService {
	void record (IRecordConfig config) throws ServiceException;
}
