/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.controller;

import at.gov.parlament.documentation.hermes.domain.User;
import at.gov.parlament.documentation.hermes.gui.IErrorView;
import at.gov.parlament.documentation.hermes.gui.ILoginView;
import at.gov.parlament.documentation.hermes.gui.IMainLoginView;
import at.gov.parlament.documentation.hermes.gui.IRegisterView;
import at.gov.parlament.documentation.hermes.gui.IView;
import at.gov.parlament.documentation.hermes.service.IBeanService;
import at.gov.parlament.documentation.hermes.service.ILoginService;
import at.gov.parlament.documentation.hermes.service.IUserService;



/**
 *
 */
public class LoginController
{
	private ILoginService loginService;
	private IRegisterView registerView;
	private IMainLoginView mainLoginView;
	private IErrorView errorView;
	private ILoginView loginView;
	private IUserService userService;
	private User user;
	private IBeanService beanService;
	
	public void setBeanService(IBeanService beanService)
	{
		this.beanService = beanService;
	}
	
	public void setMainLoginView(IMainLoginView mainLoginView)
	{
		this.mainLoginView = mainLoginView;
		mainLoginView.setController(this);
	}
	
	public void setLoginView(ILoginView loginView)
	{
		this.loginView = loginView;
		loginView.setController(this);
		mainLoginView.setDetailView(loginView);
	}
	
	public void setErrorView(IErrorView errorView)
	{
		this.errorView = errorView;
	}
	
	public ILoginView getLoginView()
	{
		return this.loginView;
	}
	
	public void setRegisterView(IRegisterView registerView)
	{
		this.registerView = registerView;
		registerView.setController(this);	
	}
	
	public IRegisterView getRegisterView()
	{
		return this.registerView;
	}
	
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}
	
	public void setLoginService(ILoginService loginService)
	{
		this.loginService = loginService;
	}
	
	public IView getView()
	{
		return mainLoginView;
	}
	
	public void registerUser()
	{
		mainLoginView.setDetailView(registerView);
	}
	
	public void registerUser(String name, String password)
	{
		userService.registerUser(name, password);
		mainLoginView.setDetailView(loginView);
	}
	
	public void cancelRegisterUser()
	{
		mainLoginView.setDetailView(loginView);
	}
		
	public void authenticate(String[] credentials)
	{
		user = loginService.login(credentials[0], credentials[1]);
		
		if (user != null)
		{
			user.setLogedIn(true);
			AppController appController = beanService.getBean(AppController.class);
			appController.setFormsAndViews();
		}
		else
		{
			errorView.displayErrorMessage("Login failed");
		}			
	}
}
