package at.gov.parlament.documentation.hermes.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
   
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/css/**").addResourceLocations(getResourceCssLocation());
		registry.addResourceHandler("/resources/png/**").addResourceLocations(getResourcePngLocation());
		registry.addResourceHandler("/resources/**").addResourceLocations(getResourceWarLocation());
		registry.addResourceHandler("/files/**").addResourceLocations(getResourceFilesLocation());
    }
    
	private String getResourceWarLocation () {
    	return "file:///D:/DEV/privat/opt/files/";
    }
	
	private String getResourcePngLocation () {
    	return "file:///D:/DEV/privat/opt/files/png/";
    }
	
	private String getResourceCssLocation () {
    	return "file:///D:/DEV/privat/opt/files/css/";
    }
	
	private String getResourceFilesLocation () {
    	return "file:///D:/DEV/privat/opt/files/";
    }
}
