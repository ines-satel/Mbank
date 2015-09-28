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
import beans.AccountBean;

public class ViewAccountsWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form ViewAccountsWindow
	 */
	public ViewAccountsWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		backButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		accountsTable = new javax.swing.JTable();
		allAccountsButton = new javax.swing.JButton();
		viewAccountByIdButton = new javax.swing.JButton();
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

		backButton.setText("Back");
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backButtonActionPerformed(evt);
			}
		});

		accountsTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"account id", "client id", "balance", "credit limit", "comment"
				}
				));
		jScrollPane1.setViewportView(accountsTable);

		allAccountsButton.setText("View all accounts");
		allAccountsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				allAccountsButtonActionPerformed(evt);
			}
		});

		viewAccountByIdButton.setText("View account by id");
		viewAccountByIdButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewAccountByIdButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(37, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(allAccountsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(viewAccountByIdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(38, 38, 38))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(47, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(allAccountsButton)
								.addComponent(viewAccountByIdButton)
								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(backButton)
								.addGap(21, 21, 21))
				);
		pack();
	}// </editor-fold>                        

	private void allAccountsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{    
		DefaultTableModel model = (DefaultTableModel) accountsTable.getModel();
		model.setRowCount(0);

		int rows;
		int occurrences = 0;
		
		AdminActions adminAction = new AdminActions();
		List<AccountBean> accountsList = new ArrayList<AccountBean>();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{
			accountsList=adminAction.viewAllAccountDetails();
			occurrences=accountsList.size();
			for (rows = 0;rows < occurrences;rows++)
			{
				model.insertRow(rows, new Object [] 
						{accountsList.get(rows).getAccountId(),
						accountsList.get(rows).getClientId(), 
						accountsList.get(rows).getBalance(),
						accountsList.get(rows).getCreditLimit(), 
						accountsList.get(rows).getComment()});
			}
		} 
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
			errorMessageWindow.setVisible(true);
		}
	}                                                 

	private void viewAccountByIdButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                      
		DefaultTableModel model = (DefaultTableModel) accountsTable.getModel();
	    model.setRowCount(0);
	    
		String text = idTextField.getText();
		long clientId = 0;
		int row=0;
		
		AccountBean account = new AccountBean();
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{
			clientId = Long.parseLong(text);
			account=adminAction.viewAccountDetails(clientId);

			model.insertRow(row, new Object [] 
					{account.getAccountId(),
					account.getClientId(), 
					account.getBalance(),
					account.getCreditLimit(), 
					account.getComment()});
		}
		catch (ClientDoesNotExistException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText(e.getMessage());
			errorMessageWindow.setVisible(true);
		} 
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
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
	private javax.swing.JButton allAccountsButton;
	private javax.swing.JButton backButton;
	private javax.swing.JTextField idTextField;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable accountsTable;
	private javax.swing.JButton viewAccountByIdButton;
	// End of variables declaration  
}
