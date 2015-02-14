/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.gui;

import at.gov.parlament.documentation.hermes.controller.MainTabViewController;

/**
 *
  */
public interface IMainTabView extends IView
{
	/**
	 * Set the Contoller for the Main Tab View.
	 * @param controller in Instace of MainTabViewController
	 */
	void setController(MainTabViewController controller);  
	 /**
	  * Add a new View to the TabView.
	  * @param name name which is diplayed on the tabtitle.
	  * @param view The view component which is dislayed in the Tab.
	  */
	 void addView(String name, IView view);
}
