
package at.gov.parlament.documentation.hermes.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class BeanService implements IBeanService, ApplicationContextAware
{
    ApplicationContext context;
    
    public void setApplicationContext(ApplicationContext context)
    {
        this.context = context;     
    }
    
    public <T> T getBean(Class<T> type)
    {
        return context.getBean(type);
    }

}
