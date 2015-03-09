package at.gov.parlament.documentation.hermes.service;


public interface IContributionBuildService {
	boolean isRecording();
	boolean startRecord(String outputFile);
	boolean stopRecord();
	String getCurrentFile();
}
