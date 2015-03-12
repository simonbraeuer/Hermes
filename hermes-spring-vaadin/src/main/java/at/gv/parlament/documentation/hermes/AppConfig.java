package at.gv.parlament.documentation.hermes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vaadin.spring.annotation.EnableVaadin;

import at.gv.parlament.documentation.hermes.service.ILoginService;
import at.gv.parlament.documentation.hermes.service.LoginService;
import at.gv.parlament.documentation.hermes.service.record.DebutRecordService;
import at.gv.parlament.documentation.hermes.service.record.FfmpegRecordService;
import at.gv.parlament.documentation.hermes.service.record.IMasterRecordService;
import at.gv.parlament.documentation.hermes.service.record.MasterRecordService;

@Configuration
@EnableVaadin
public class AppConfig {
	LoginService loginService;
	
	@Autowired
	DebutRecordService debutRecordService;
	
	@Autowired
	FfmpegRecordService ffmpegRecordService;
	
	
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
		ret.registerService(DebutRecordService.SOURCE, debutRecordService);
		ret.registerService(FfmpegRecordService.SOURCE, ffmpegRecordService);
		return ret;
	}

}
