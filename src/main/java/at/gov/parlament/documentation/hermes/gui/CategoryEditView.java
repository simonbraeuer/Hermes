package at.gov.parlament.documentation.hermes.gui;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import at.gov.parlament.documentation.hermes.controller.CategoryEditController;
import at.gov.parlament.documentation.hermes.controller.IController;
import at.gov.parlament.documentation.hermes.domain.Category;
import net.miginfocom.swing.MigLayout;


public class CategoryEditView extends JPanel implements ICategoryEditView
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryEditController categoryController;
	private DefaultListModel categoryListModel;
	List<Category> categoryList;
	Category currentCategory;
	
	private JPanel listPanel;
	private JList categoryListGui;
	private JButton addCategoryButton;
	
	private JPanel addEditPanel;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JButton saveButton;
	private JButton deleteButton;
	
	public CategoryEditView()
	{
		super(new MigLayout());
		setLayout(new BorderLayout());
		currentCategory = new Category();
		buildUserInterface();
	}
	
	private void buildUserInterface()
	{
		listPanel = new JPanel(new BorderLayout());
		addEditPanel = new JPanel(new MigLayout());
		
		categoryListModel = new DefaultListModel();
		categoryListGui = new JList(categoryListModel);
		categoryListGui.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryListGui.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				unitListMouseClicked(me);
			}
		});
		
		addCategoryButton = new JButton("Add Unit");
		addCategoryButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				addUnitButtonActionPerformed(ae);
			}
		});
		
		listPanel.add(categoryListGui, BorderLayout.CENTER);
		listPanel.add(addCategoryButton, BorderLayout.PAGE_END);
		
		add(listPanel, BorderLayout.LINE_START);
		add(addEditPanel, BorderLayout.LINE_END);
	}
	
	public void setCategoryList(List<Category> categoryList)
	{
		this.categoryList = categoryList;
		drawList();
	}
	
	private void drawAddEditPanel()
	{
		addEditPanel.removeAll();
		nameLabel = new JLabel("Name:");
		
		String nameTextFieldText = "";
		
		if(currentCategory.getEntity().getId() != null)
		{
			nameTextFieldText = currentCategory.getName();
		}
		
		nameTextField = new JTextField(nameTextFieldText, 20);
		
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				saveButtonActionPerformed(ae);
			}
		});
		
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				deleteButtonActionPerformed(ae);
			}
		});
		
		addEditPanel.add(nameLabel, "gaptop 15");
		addEditPanel.add(nameTextField, "wrap, gaptop 15");
		addEditPanel.add(saveButton, "");
		addEditPanel.add(deleteButton, "");
		revalidate();
	}
	
	private void addUnitButtonActionPerformed(ActionEvent ae)
	{
		currentCategory = new Category();
		drawAddEditPanel();
	}
	
	private void saveButtonActionPerformed(ActionEvent ae)
	{
		currentCategory.setName(nameTextField.getText());
		categoryController.saveCategory();
		currentCategory = new Category();
		addEditPanel.removeAll();
	}
	
	private void deleteButtonActionPerformed(ActionEvent ae)
	{
		categoryController.deleteCategory();
		currentCategory = new Category();
		addEditPanel.removeAll();
	}
	
	private void unitListMouseClicked(MouseEvent me)
	{
		currentCategory = categoryList.get(categoryListGui.getSelectedIndex());
		drawAddEditPanel();
	}
	
	private void drawList()
	{
		categoryListModel.clear();
		
		for (Category unit : categoryList)
		{
			categoryListModel.addElement(unit.getName());
		}
	}
	
	public void setController(IController controller)
	{
		this.categoryController = (CategoryEditController) controller;
	}
	
	public Category getCategory()
	{
		return currentCategory;
	}
}
