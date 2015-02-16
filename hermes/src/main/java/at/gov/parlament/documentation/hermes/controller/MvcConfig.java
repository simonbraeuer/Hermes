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
    	registry.addResourceHandler("/css/**").addResourceLocations("/file:/opt/files/css/");
    	registry.addResourceHandler("/files/png/**").addResourceLocations("file:/opt/files/png/");
    	registry.addResourceHandler("/files/**").addResourceLocations("file:/opt/files/");
    }
}
