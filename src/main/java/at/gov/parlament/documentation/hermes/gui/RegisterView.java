/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

import at.gov.parlament.documentation.hermes.controller.LoginController;
import net.miginfocom.swing.MigLayout;


/**
 *
 */
public class RegisterView extends JPanel implements IRegisterView
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginController controller;
    private JLabel labelTitle;
	private JLabel labelLogin;
	private JLabel labelPassword;
	private JLabel labelPasswordCheck;
	private JTextField textLogin;
	private JPasswordField textPassword;
	private JPasswordField textPasswordCheck;
	private JButton buttonSave;
	private JButton buttonCancel;
	private RegisterActionListener actionListener = new RegisterActionListener();
	
    private JSeparator separator = new JSeparator();
	
	public RegisterView()
	{
		super(new MigLayout());
		buildGUI();
	}

	private void buildGUI()
	{
        labelTitle = new JLabel("Register");
        
		labelLogin = new JLabel("Username:");
		textLogin = new JTextField("", 20);

		labelPassword = new JLabel("Password:");
		textPassword = new JPasswordField("", 20);

		labelPasswordCheck = new JLabel("Repeat password:");
		textPasswordCheck = new JPasswordField("", 20);

		buttonSave = new JButton("Save");
		buttonSave.addActionListener(actionListener);

		buttonCancel = new JButton("Cancel");
		buttonCancel.addActionListener(actionListener);

        add(labelTitle, "split 2, span");
        add(separator, "growx, wrap");
		add(labelLogin, "");
		add(textLogin, "wrap");
		add(labelPassword, "");
		add(textPassword, "wrap");
		add(labelPasswordCheck, "");
		add(textPasswordCheck, "wrap");
		add(buttonSave, "");
		add(buttonCancel, "right");
	}	

	public void setController(LoginController controller)
	{
		this.controller = controller;
	}
	
	class RegisterActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == buttonSave)
			{				
				controller.registerUser(textLogin.getText(), String.valueOf(textPassword.getPassword()));
			}
			
			if (e.getSource() == buttonCancel)
			{
				controller.cancelRegisterUser();
			}
		}
		
	}
}
