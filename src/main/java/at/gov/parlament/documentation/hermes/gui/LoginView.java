/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import at.gov.parlament.documentation.hermes.controller.LoginController;

/**
 *
 */
public class LoginView extends JPanel implements ILoginView
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginController controller;
    private JLabel labelTitle;
	private JLabel labelLogin;
	private JLabel labelPassword;
	private JLabel labelErrorMessage;
	private JTextField textLogin;
	private JPasswordField textPassword;
	private JButton buttonLogin;
	private JButton buttonRegister;
	private LoginViewActionListener actionListener = new LoginViewActionListener();
	
    private JSeparator separator = new JSeparator();

	public LoginView()
	{
		super(new MigLayout());
		buildGUI();
	}

	private void buildGUI()
	{
        labelTitle = new JLabel("Login");
        
		labelLogin = new JLabel("Name:");
		textLogin = new JTextField("", 20);

		labelPassword = new JLabel("Password:");
		textPassword = new JPasswordField("", 20);

		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(actionListener);
			
		buttonRegister = new JButton("Register");
		buttonRegister.addActionListener(actionListener);
        
        add(labelTitle, "split 2, span");
        add(separator, "growx, wrap");
		add(labelLogin, "");
		add(textLogin, "wrap");
		add(labelPassword, "");
		add(textPassword, "wrap");
		add(buttonLogin, "");
		add(buttonRegister, "right");
	}

	public void setController(LoginController controller)
	{
		this.controller = controller;
	}
	
	class LoginViewActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == buttonLogin)
			{
				String[] credentials = new String[2];
				credentials[0] = textLogin.getText();
				credentials[1] = String.valueOf(textPassword.getPassword());
				controller.authenticate(credentials);
			}
			
			if (e.getSource() == buttonRegister) 
			{
				controller.registerUser();
			}
		}		
	}
}
