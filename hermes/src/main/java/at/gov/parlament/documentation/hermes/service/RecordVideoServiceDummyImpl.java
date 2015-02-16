package at.gov.parlament.documentation.hermes.service;

import groovy.util.logging.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.crsh.console.jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RecordVideoServiceDummyImpl implements IRecordVideoService{
	@Autowired
	private Properties applicationProperties = new Properties();
	
	@Autowired
	private IFastStartVideoService fastStartService;
	
	private boolean isRecording;
	private String currentFile;

	@Override
	public boolean isRecording() {
		return isRecording;
	}

	@Override
	public boolean startRecord(String outputFile) {
		Log.info("Start recording: " + outputFile);
		isRecording = true;
		String outputDirectory = applicationProperties.getProperty("recordService.outputDirectory", "/opt/files/");
		
		String command = applicationProperties.getProperty("recordService.startCommand", "/Applications/Debut.app/Contents/MacOS/Debut -record -format mp4 -file ${outputFile} -videodir ${outputDirectory}");

		command = command.replace("${outputFile}", outputFile);
		command = command.replace("${outputDirectory}", outputDirectory);
		try {
			executeCommand(command);
		} catch (IOException e) {
			Log.error("Could not start record!");
			isRecording = false;
			return false;
		} catch (InterruptedException e) {
			Log.error("Could not start record!");
			isRecording = false;
			return false;
		}
		currentFile = outputDirectory+outputFile+".mp4";
		return true;
	}

	@Override
	public boolean stopRecord() {
		Log.info("Stop recording");
		String command = applicationProperties.getProperty("recordService.stopCommand", "/Applications/Debut.app/Contents/MacOS/Debut -stop");
		//		String sOutputFile = applicationProperties.getProperty("recordService.outputFile", "");
		try {
			executeCommand(command);
			
		} catch (IOException e) {
			Log.error("Could not stop record!");
			return false;
		} catch (InterruptedException e) {
			Log.error("Could not stop record!");
			return false;
		}
		fastStartService.convert(new File(currentFile));
		isRecording = false;
		return true;
	}
	
	private int executeCommand (String command) throws IOException, InterruptedException {
		Log.info("excuteCommand: {}", command);
		Process process = Runtime.getRuntime().exec(command);
		process.waitFor();
		Log.info("excuteCommand->result: {}", process.exitValue());
		return process.exitValue();
	}
	
}
