package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import exceptions.ClientDoesNotExistException;
import gui.TextPrompt.Show;
import actions.AdminActions;
import beans.ClientBean;

public class RemoveClientWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form RemoveClientWindow
	 */
	public RemoveClientWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		clientDetailsTable = new javax.swing.JTable();
		viewClientDetailsButton = new javax.swing.JButton();
		removeButton = new javax.swing.JButton();
		clientIdLabel = new javax.swing.JLabel();
		idTextField = new javax.swing.JTextField();
		backButton = new javax.swing.JButton();

		TextPrompt promptId = new TextPrompt("Enter client id", idTextField, Show.ALWAYS);
		promptId.changeStyle(Font.ITALIC);
		promptId.changeAlpha(0.5f);

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

		// Center the frame in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/5;
		int y = (dim.height-h)/4;
		this.setLocation(x, y);

		clientDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"client id", "client name", "password", "type", "address", "email", "phone", "comment"
				}
				));
		jScrollPane1.setViewportView(clientDetailsTable);

		viewClientDetailsButton.setText("View client details");
		viewClientDetailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewClientDetailsButtonActionPerformed(evt);
			}
		});

		removeButton.setText("Remove client");
		removeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButtonActionPerformed(evt);
			}
		});

		clientIdLabel.setText("client id");

		backButton.setText("Back");
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(46, 46, 46)
						.addComponent(clientIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(viewClientDetailsButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
												.addGap(0, 0, Short.MAX_VALUE)
												.addComponent(backButton)))
												.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(38, 38, 38)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(clientIdLabel)
								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(viewClientDetailsButton)
								.addComponent(removeButton))
								.addGap(33, 33, 33)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
								.addComponent(backButton)
								.addGap(21, 21, 21))
				);
		pack();
	}// </editor-fold>                        

	private void viewClientDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{         
		DefaultTableModel model = (DefaultTableModel) clientDetailsTable.getModel();
		model.setRowCount(0);

		String text = idTextField.getText();
		long clientId = 0;
		int row=0;

		ClientBean client = new ClientBean();
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{
			clientId = Long.parseLong(text);
			client=adminAction.viewClientDetails(clientId);

			model.insertRow(row, new Object [] 
					{client.getClientId(),
					client.getClientName(),
					client.getPassword(),
					client.getType(),
					client.getAddress(),
					client.getEmail(),
					client.getPhone(),
					client.getComment()});
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

	private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                             
		AdminActions adminAction = new AdminActions();
		SuccessMessageWindow successMessageWindow = new SuccessMessageWindow();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();

		String id = idTextField.getText();
		long clientId;
		try 
		{
			clientId = Long.parseLong(id);
			adminAction.removeClient(clientId);
			//new window of success
			successMessageWindow.getSuccessLabel().setText("client "+clientId+" successfully removed");
			successMessageWindow.setVisible(true);
			this.idTextField.setText("");
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
	private javax.swing.JButton backButton;
	private javax.swing.JTable clientDetailsTable;
	private javax.swing.JLabel clientIdLabel;
	private javax.swing.JTextField idTextField;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton removeButton;
	private javax.swing.JButton viewClientDetailsButton;
	// End of variables declaration   

}                                            

