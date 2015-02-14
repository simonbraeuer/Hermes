package at.gov.parlament.documentation.hermes.service;

import at.gov.parlament.documentation.hermes.domain.IRecordConfig;
import at.gov.parlament.documentation.hermes.exceptions.HashingServiceException;
import at.gov.parlament.documentation.hermes.exceptions.RecordServiceException;

public interface IRecordService {
	void record (IRecordConfig config) throws RecordServiceException;
}
