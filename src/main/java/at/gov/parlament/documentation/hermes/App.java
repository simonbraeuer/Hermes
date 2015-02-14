package at.gov.parlament.documentation.hermes;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import at.gov.parlament.documentation.hermes.controller.AppController;

/**
 * Hello hermes world!
 *
 */
public class App 
{
    private static Logger logger = Logger.getLogger(App.class);
    
    public static void main( String[] args )
    {        
        logger.info("YASL startup");
        
        try
        {
            UIManager.setLookAndFeel("com.jgoodies.plaf.plastic.PlasticXPLookAndFeel");
        }
        catch(Exception ex)
        {
            logger.error("Failed to set look and feel", ex);
        }       
        
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");        
        AppController controller = (AppController) context.getBean("appController");        
        controller.run();                   
    }
}