package at.gv.parlament.documentation.hermes.service.record;

import java.io.IOException;
import java.util.Properties;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;

import at.gv.parlament.documentation.hermes.domain.RecordSetting;

@Log4j
public abstract class AbstractPropertyRecordService implements IRecordService {
	
	private RecordSetting currentRecordSetting;
	
	@Autowired
	protected Properties applicationProperties;
	
	protected abstract String getName();
	
	protected abstract String getDefaultStartCommand();
	protected abstract String getDefaultStopCommand();
	
	protected String getStartCommand() {
		return applicationProperties.getProperty( getName()+".startCommand", getDefaultStartCommand());
	}
	
	protected String getStopCommand() {
		return applicationProperties.getProperty( getName()+".stopCommand", getDefaultStopCommand());
	}
	
	@Override
	public void startRecord(RecordSetting setting) {
		log.info(getName() + " - Start record: " + setting);
		String outputFile = setting.getFileName();
		String command = getStartCommand();
		
		command = command.replace("${outputFile}", outputFile);
		
		try {
			currentRecordSetting = setting;
			executeCommand(command);
		} catch (IOException e) {
			log.error("Could not start record!");
		} catch (InterruptedException e) {
			log.error("Could not start record!");
		}
	}

	@Override
	public void stopRecord() {
		log.info("Stop recording");
		String command = getStopCommand();
		
		try {
			currentRecordSetting = null;
			executeCommand(command);
		} catch (IOException e) {
			log.error("Could not stop record!");
		} catch (InterruptedException e) {
			log.error("Could not stop record!");
		}
	}
	
	@Override
	public RecordSetting isRecording() {
		return currentRecordSetting;
	}
	
	protected void executeCommand (String command) throws IOException, InterruptedException {
		log.info("excuteCommand: " + command);
		Runtime.getRuntime().exec(command);
	}
}
