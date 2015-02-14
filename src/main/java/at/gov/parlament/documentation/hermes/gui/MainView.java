package at.gov.parlament.documentation.hermes.gui;

import javax.swing.*;

import at.gov.parlament.documentation.hermes.controller.AppController;
import net.miginfocom.swing.MigLayout;


/**
 * 
 */
public class MainView extends JFrame implements IMainView
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AppController controller;
    private JPanel mainPanel;
    
    public MainView()
    {                     
        setLayout(new MigLayout("fill"));
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hermes - Parlamentarische Mediendokumentation");
        mainPanel = new JPanel(new MigLayout("fill"));
        this.add(mainPanel,"grow");
    }                 
    
    @Override
    public void showView()
    {
        setVisible(true);
    }
    
    @Override
    public void closeView() 
    {
        setVisible(false);
    }
    
    @Override
    public void setController(AppController controller)
    {
        this.controller = controller;        
    }

    public void setContainedView(IView view)
	{
        mainPanel.removeAll();
        mainPanel.add((JComponent)view, "grow");
        mainPanel.revalidate();
    }
}
