/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.controller;

import at.gov.parlament.documentation.hermes.gui.IMainTabView;
import at.gov.parlament.documentation.hermes.gui.IView;
import at.gov.parlament.documentation.hermes.service.IBeanService;



/**
 *
 */
public class MainTabViewController implements IController
{

    private IMainTabView view;
    private IBeanService beanService;
    
    public void setMainTabView(IMainTabView view)
    {
    	this.view = view;
    	view.setController(this);
	}

    public void addView(String name, IController controller)
    {
    	view.addView(name, controller.getView());
    }

    public IView getView()
    {
            return view;
    }
}
