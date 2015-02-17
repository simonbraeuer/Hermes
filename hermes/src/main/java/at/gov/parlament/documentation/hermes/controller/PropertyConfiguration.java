package at.gov.parlament.documentation.hermes.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.crsh.console.jline.internal.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyConfiguration {
	private String getJndiPropertyFilePath ( ) {
		//return ("D:\\DEV\\privat\\git\\hermes\\hermes\\src\\main\\resources\\windowsApplication.properties");
		return ("/Users/sbr/git/HermesRepo/hermes/src/main/resources/macApplication.properties");
    }
    
    @Bean @Qualifier("hermesProperties")
    public Properties getApplicationProperties () {
    	Properties ret = new Properties();
    	String sPropertyFilePath = getJndiPropertyFilePath();
    	Log.info("Property file: " + sPropertyFilePath);
    	try {
			ret.load(new FileInputStream(sPropertyFilePath));
		} catch (FileNotFoundException e) {
			Log.error("Cannot load properties: " + e);
		} catch (IOException e) {
			Log.error("Cannot load properties: " + e);
		}
    	return ret;
    }
}
