package at.gv.parlament.documentation.hermes;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vaadin.spring.annotation.EnableVaadin;

import at.gv.parlament.documentation.hermes.domain.RecordSource;
import at.gv.parlament.documentation.hermes.service.login.ILoginService;
import at.gv.parlament.documentation.hermes.service.login.LoginService;
import at.gv.parlament.documentation.hermes.service.record.DebutRecordService;
import at.gv.parlament.documentation.hermes.service.record.DummyRecordService;
import at.gv.parlament.documentation.hermes.service.record.DummyRecordService2;
import at.gv.parlament.documentation.hermes.service.record.FfmpegRecordService;
import at.gv.parlament.documentation.hermes.service.record.IMasterRecordService;
import at.gv.parlament.documentation.hermes.service.record.IRecordService;
import at.gv.parlament.documentation.hermes.service.record.MasterRecordService;
import at.gv.parlament.documentation.hermes.service.record.RecordWebCamRecordService;

@Configuration
@EnableVaadin
@EnableJpaRepositories(basePackages = "at.gv.parlament.documentation.hermes.dao")
public class AppConfig {
	LoginService loginService;
	
	@Autowired
	DummyRecordService2 dummyRecordService2;
	
	@Autowired
	DebutRecordService debutRecordService;
	
	@Autowired
	FfmpegRecordService ffmpegRecordService;
	
	@Autowired
	RecordWebCamRecordService recordWebCamRecordService;
	
	@Autowired
	DummyRecordService dummyRecordService;
	
	@Autowired
	Environment environment;
	
	@Bean(name="appDataPath")
	public String appDataPath() {
		return environment.getProperty("appdata.path", "/opt/files");
	}
	
	@Bean(name="appDataPathTmp")
	public String appDataPathTmp() {
		return environment.getProperty("appdata.path", appDataPath()+File.separator+"tmp");
	}
	
	@Bean
	public IMasterRecordService getMasterRecordService() {
		MasterRecordService ret = new MasterRecordService();
		//ret.registerService(DebutRecordService.SOURCE, debutRecordService);
		//ret.registerService(FfmpegRecordService.SOURCE, ffmpegRecordService);
		//ret.registerService(RecordWebCamRecordService.SOURCE, recordWebCamRecordService);
		ret.registerService(DummyRecordService.SOURCE, dummyRecordService, true);
		ret.registerService(DummyRecordService2.SOURCE, dummyRecordService2, false);
		return ret;
	}

}
