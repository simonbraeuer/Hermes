/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import at.gov.parlament.documentation.hermes.controller.MainTabViewController;
import net.miginfocom.swing.MigLayout;

/**
 *
 */
public class MainTabView extends JPanel implements IMainTabView
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainTabViewController controller;
	private JTabbedPane tabbedPane;
	
	public MainTabView()
	{
		super(new MigLayout("fill"));		
		
		initializeComponents();
	}

	private void initializeComponents()
	{
		tabbedPane = new JTabbedPane();
		add(tabbedPane, "grow");
	}

	public void setController(MainTabViewController controller)
	{
		this.controller = controller;
	}
	
	public void addView(String name, IView view)
	{
		tabbedPane.addTab(name, (JPanel)view);
	}
	
}
