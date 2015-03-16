package at.gv.parlament.documentation.hermes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vaadin.spring.annotation.EnableVaadin;

import at.gv.parlament.documentation.hermes.domain.RecordSource;
import at.gv.parlament.documentation.hermes.service.ILoginService;
import at.gv.parlament.documentation.hermes.service.LoginService;
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
	
	
	
	@Bean
	public ILoginService loginService() {
		if(loginService == null) {
			loginService = new LoginService();
		}
		return loginService;
	}
	
//	@Bean
//	public IMainViewController getMainViewController() {
//		return new MainViewController();
//	}
//	
//	@Bean
//	public IMainView getMainView() {
//		return new MainView();
//	}
//	
//	
//	@Bean
//	public LoginView getLoginView() {
//		return new LoginView();
//	}
	
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
