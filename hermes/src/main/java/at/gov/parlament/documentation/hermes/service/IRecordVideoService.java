package at.gov.parlament.documentation.hermes.service;


public interface IRecordVideoService {
	boolean isRecording();
	boolean startRecord(String outputFile);
	boolean stopRecord();
}