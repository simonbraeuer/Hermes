/*
 */
package at.gov.parlament.documentation.hermes.gui;

import at.gov.parlament.documentation.hermes.controller.AppController;


/**
 *
 */
public interface IMainView
{
    void showView();    
    void closeView();   
    
    void setController(AppController controller);
    
    void setContainedView(IView view);
}
