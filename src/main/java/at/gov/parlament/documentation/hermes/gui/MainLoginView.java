package at.gov.parlament.documentation.hermes.gui;

import javax.swing.JComponent;
import javax.swing.JPanel;

import at.gov.parlament.documentation.hermes.controller.LoginController;
import net.miginfocom.swing.MigLayout;

/**
 *
 */
public class MainLoginView extends JPanel implements IMainLoginView
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginController controller;
	
	public MainLoginView()
	{
		super(new MigLayout("fill"));
	}
	
	public void setController(LoginController controller)
	{
		this.controller = controller;
	}
	
	public void setDetailView(IView view)
	{
		removeAll();
		add((JComponent) view, "grow");
		updateUI();
	}
}
