package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import exceptions.ClientDoesNotExistException;
import exceptions.ClientDoesNotHaveDeposit;
import gui.TextPrompt.Show;
import actions.AdminActions;
import beans.DepositBean;

public class ViewDepositsWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form ViewDepositsWindow
	 */
	public ViewDepositsWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		depositsTable = new javax.swing.JTable();
		backButton = new javax.swing.JButton();
		alldepositsButton = new javax.swing.JButton();
		viewDepositByIdButton = new javax.swing.JButton();
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

		depositsTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"deposit id", "client id", "balance", "type", "estimated balance", "opening date", "closing date"
				}
				));
		jScrollPane1.setViewportView(depositsTable);

		backButton.setText("Back");
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backButtonActionPerformed(evt);
			}
		});

		alldepositsButton.setText("View all deposits");
		alldepositsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				alldepositsButtonActionPerformed(evt);
			}
		});

		viewDepositByIdButton.setText("View deposit by id");
		viewDepositByIdButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewDepositByIdButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE)
										.addComponent(backButton))
										.addGroup(layout.createSequentialGroup()
												.addComponent(alldepositsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(viewDepositByIdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 191, Short.MAX_VALUE)))
												.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(46, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(alldepositsButton)
								.addComponent(viewDepositByIdButton)
								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(backButton)
								.addGap(18, 18, 18))
				);
		pack();
	}// </editor-fold>                        

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                           
		this.setVisible(false);
		this.dispose();
	}                                          

	private void alldepositsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                
		DefaultTableModel model = (DefaultTableModel) depositsTable.getModel();
		model.setRowCount(0);

		int rows;
		int occurrences = 0;

		AdminActions adminAction = new AdminActions();
		List<DepositBean> depositsList = new ArrayList<DepositBean>();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{
			depositsList = adminAction.viewAllDeposits();
			occurrences = depositsList.size();
			for (rows = 0;rows < occurrences;rows++)
			{
				model.insertRow(rows, new Object [] 
						{depositsList.get(rows).getDepositId(),
						depositsList.get(rows).getClientId(), 
						depositsList.get(rows).getBalance(),
						depositsList.get(rows).getType(),
						depositsList.get(rows).getEstimatedBalance(),
						depositsList.get(rows).getOpeningDate(), 
						depositsList.get(rows).getClosingDate()});
			}
		} 
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
			errorMessageWindow.setVisible(true);
		}
	}                                                 

	private void viewDepositByIdButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                      
		DefaultTableModel model = (DefaultTableModel) depositsTable.getModel();
		model.setRowCount(0);

		int rows;
		int occurrences = 0;
		String text = idTextField.getText();
		long clientId;

		List<DepositBean> depositsList = new ArrayList<DepositBean>();
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try
		{
			clientId = Long.parseLong(text);
			depositsList = adminAction.viewClientDeposits(clientId);
			occurrences = depositsList.size();
			for (rows = 0;rows < occurrences;rows++)
			{
				model.insertRow(rows, new Object [] 
						{depositsList.get(rows).getDepositId(),
						depositsList.get(rows).getClientId(), 
						depositsList.get(rows).getBalance(),
						depositsList.get(rows).getType(), 
						depositsList.get(rows).getEstimatedBalance(),
						depositsList.get(rows).getOpeningDate(), 
						depositsList.get(rows).getClosingDate()});
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
		catch (ClientDoesNotHaveDeposit e) 
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

	// Variables declaration - do not modify                     
	private javax.swing.JButton alldepositsButton;
	private javax.swing.JButton backButton;
	private javax.swing.JTable depositsTable;
	private javax.swing.JTextField idTextField;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton viewDepositByIdButton;
	// End of variables declaration              
}                                                     

