
package at.gov.parlament.documentation.hermes.service;

import java.awt.Component;
import java.awt.print.Printable;

/**
 *
 */
public interface IPrintUtilityService extends Printable
{
	/**
	 * Prints a Component with it's content
	 * @param component 
	 */
	void printComponent(Component component);
	/**
	 * Prints the text on standard printer.
	 * @param text 
	 */
	void printText(String text);
}
