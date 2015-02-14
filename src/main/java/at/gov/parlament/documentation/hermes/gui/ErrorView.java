
package at.gov.parlament.documentation.hermes.gui;

import javax.swing.JOptionPane;

/**
 *
 */
public class ErrorView implements IErrorView
{
    public void displayErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }

}
