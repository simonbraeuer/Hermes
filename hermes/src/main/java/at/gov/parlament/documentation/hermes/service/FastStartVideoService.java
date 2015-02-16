package at.gov.parlament.documentation.hermes.service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.crsh.console.jline.internal.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FastStartVideoService implements IFastStartVideoService {
	
	@Autowired
	private Properties applicationProperties = new Properties();
	
	@Override
	public boolean convert(File convertToFastStartVideo) {
		Log.info("Start faststart conversion: " + convertToFastStartVideo);
		
		String command = applicationProperties.getProperty("fastStartVideoService.convertCommand", "/Users/sbr/bachelordata/bin/ffmpeg -i ${inputFile} -c:a copy -c:v copy -movflags faststart ${outputFile}");
		if(command.isEmpty()) {
			Log.error("Could not convert file!");
			return false;
		}
		command = command.replace("${inputFile}", convertToFastStartVideo.getAbsolutePath());
		command = command.replace("${outputFile}", convertToFastStartVideo.getAbsolutePath());
		try {
			executeCommand(command);
		} catch (IOException e) {
			Log.error("Could not convert file!");
			return false;
		} catch (InterruptedException e) {
			Log.error("Could not convert file!");
			return false;
		}
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
