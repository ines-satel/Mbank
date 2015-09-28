package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import exceptions.ClientDoesNotExistException;
import gui.TextPrompt.Show;
import actions.AdminActions;
import beans.ActivityBean;

public class ViewActivitiesWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form ViewActivitiesWindow
	 */
	public ViewActivitiesWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		activitiesTable = new javax.swing.JTable();
		backButton = new javax.swing.JButton();
		allActivitiesButton = new javax.swing.JButton();
		viewActivitiesByIdButton = new javax.swing.JButton();
		idTextField = new javax.swing.JTextField();

		TextPrompt promptId = new TextPrompt("Enter client id", idTextField, Show.ALWAYS);
		promptId.changeStyle(Font.ITALIC);
		promptId.changeAlpha(0.5f);

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

		// Center the frame in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/4;
		int y = (dim.height-h)/6;
		this.setLocation(x, y);

		activitiesTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"activity id", "client id", "ammount", "activity date", "commission", "description"
				}
				));
		jScrollPane1.setViewportView(activitiesTable);

		backButton.setText("Back");
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backButtonActionPerformed(evt);
			}
		});

		allActivitiesButton.setText("View all activities");
		allActivitiesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				allActivitiesButtonActionPerformed(evt);
			}
		});

		viewActivitiesByIdButton.setText("View activities by id");
		viewActivitiesByIdButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewActivitiesByIdButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(22, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(allActivitiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(viewActivitiesByIdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(backButton)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(21, 21, 21))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(55, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(allActivitiesButton)
								.addComponent(viewActivitiesByIdButton)
								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(16, 16, 16)
								.addComponent(backButton)
								.addContainerGap())
				);
		pack();
	}// </editor-fold>                        

	private void allActivitiesButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{    
		DefaultTableModel model = (DefaultTableModel) activitiesTable.getModel();
		model.setRowCount(0);

		int rows;
		int occurrences = 0;
		
		AdminActions adminAction = new AdminActions();
		List<ActivityBean> activitiesList = new ArrayList<ActivityBean>();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{
			activitiesList = adminAction.viewAllActivities();
			occurrences=activitiesList.size();
			for (rows = 0;rows < occurrences;rows++)
			{
				model.insertRow(rows, new Object [] 
						{activitiesList.get(rows).getId(),
						activitiesList.get(rows).getClientId(), 
						activitiesList.get(rows).getAmount(),
						activitiesList.get(rows).getActivityDate(), 
						activitiesList.get(rows).getCommission(),
						activitiesList.get(rows).getDescription()});
			}
		} 
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
			errorMessageWindow.setVisible(true);
		}
	}                                                   

	private void viewActivitiesByIdButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                         
		DefaultTableModel model = (DefaultTableModel) activitiesTable.getModel();
		model.setRowCount(0);
		
		int rows;
		int occurrences = 0;
		String text = idTextField.getText();
		long clientId;
		
		List<ActivityBean> activitiesList = new ArrayList<ActivityBean>();
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try
		{
			clientId = Long.parseLong(text);
			activitiesList = adminAction.viewClientActivities(clientId);
			occurrences = activitiesList.size();
			for (rows = 0;rows < occurrences;rows++)
			{
				model.insertRow(rows, new Object [] 
						{activitiesList.get(rows).getId(),
						activitiesList.get(rows).getClientId(), 
						activitiesList.get(rows).getAmount(),
						activitiesList.get(rows).getActivityDate(), 
						activitiesList.get(rows).getCommission(),
						activitiesList.get(rows).getDescription()});
			}
		}
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
			errorMessageWindow.setVisible(true);
		} 
		catch (ClientDoesNotExistException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText(e.getMessage());
			errorMessageWindow.setVisible(true);
		} 
		catch (NumberFormatException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("Your input is invalid, please enter a valid Id number");
			errorMessageWindow.setVisible(true);
		}
	}                                                        

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                           
		this.setVisible(false);
		this.dispose();
	}                                          

	// Variables declaration                    
	private javax.swing.JTable activitiesTable;
	private javax.swing.JButton allActivitiesButton;
	private javax.swing.JButton backButton;
	private javax.swing.JTextField idTextField;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton viewActivitiesByIdButton;
	// End of variables declaration
}
