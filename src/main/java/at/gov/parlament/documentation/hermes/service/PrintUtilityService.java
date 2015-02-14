/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package at.gov.parlament.documentation.hermes.service;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JTextPane;
import javax.swing.RepaintManager;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PrintUtilityService implements IPrintUtilityService
{

	private Component componentToBePrinted;

	public void printComponent(Component componentToBePrinted)
	{
		this.componentToBePrinted = componentToBePrinted;

		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(this);
		if (printJob.printDialog())
		{
			try
			{
				printJob.print();
			}
			catch (PrinterException pe)
			{
				System.out.println("Error printing: " + pe);
			}
		}
	}

	public int print(Graphics g, PageFormat pageFormat, int pageIndex)
	{
		if (pageIndex > 0)
		{
			return (NO_SUCH_PAGE);
		}
		else
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			disableDoubleBuffering(componentToBePrinted);

			componentToBePrinted.paint(g2d);

			enableDoubleBuffering(componentToBePrinted);
			return (PAGE_EXISTS);
		}
	}

	public void printText(String text)
	{
		JTextPane jtp = new JTextPane();
		jtp.setBackground(Color.white);
		jtp.setText(text);
		boolean show = true;
		try
		{
			jtp.print(null, null, show, null, null, show);
		}
		catch (java.awt.print.PrinterException ex)
		{
			log.error("Cannot print text");
		}

	}

	public static void disableDoubleBuffering(Component c)
	{
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(false);
	}

	public static void enableDoubleBuffering(Component c)
	{
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(true);
	}
}