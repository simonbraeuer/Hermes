package at.gov.parlament.documentation.hermes.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import at.gov.parlament.documentation.hermes.domain.MainSessionBean;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
   
	private String preOptPath = "";
	//private String preOptPath = "//D:/DEV/privat";
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/css/**").addResourceLocations(getResourceCssLocation());
		registry.addResourceHandler("/resources/png/**").addResourceLocations(getResourcePngLocation());
		registry.addResourceHandler("/resources/**").addResourceLocations(getResourceWarLocation());
		registry.addResourceHandler("/files/**").addResourceLocations(getResourceFilesLocation());
    }
	
	private String getResourceWarLocation () {
    	return "file:/" + preOptPath + "opt/files/";
    }
	
	private String getResourcePngLocation () {
		return "/resources/png/";
    }
	
	private String getResourceCssLocation () {
		return "file:/" + preOptPath + "opt/files/css/";
    }
	
	private String getResourceFilesLocation () {
		return "file:/" + preOptPath + "opt/files/";
    }
}
