package gui;

import exceptions.ClientDoesNotExistException;
import gui.TextPrompt.Show;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;

import actions.AdminActions;
import beans.ClientBean;

public class UpdateClientDetailsWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form UpdateClientDetailsWindow
	 */
	public UpdateClientDetailsWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		backButton = new javax.swing.JButton();
		idTextField = new javax.swing.JTextField();
		viewClientButton = new javax.swing.JButton();
		nameLabel = new javax.swing.JLabel();
		addressLabel = new javax.swing.JLabel();
		emailLabel = new javax.swing.JLabel();
		phoneLabel = new javax.swing.JLabel();
		commentLabel = new javax.swing.JLabel();
		phoneTextField = new javax.swing.JTextField();
		emailTextField = new javax.swing.JTextField();
		addressTextField = new javax.swing.JTextField();
		nameTextField = new javax.swing.JTextField();
		commentTextField = new javax.swing.JTextField();
		updateNameButton = new javax.swing.JButton();
		updateAddressButton = new javax.swing.JButton();
		updateEmailButton = new javax.swing.JButton();
		updatePhoneButton = new javax.swing.JButton();
		updateCommentButton = new javax.swing.JButton();

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

		viewClientButton.setText("View client");
		viewClientButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewClientButtonActionPerformed(evt);
			}
		});

		nameLabel.setText("Full Name");

		addressLabel.setText("Address");

		emailLabel.setText("Email");

		phoneLabel.setText("Phone");

		commentLabel.setText("Comment");

		updateNameButton.setText("Update name");
		updateNameButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateNameButtonActionPerformed(evt);
			}
		});

		updateAddressButton.setText("Update address");
		updateAddressButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateAddressButtonActionPerformed(evt);
			}
		});

		updateEmailButton.setText("Update email");
		updateEmailButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateEmailButtonActionPerformed(evt);
			}
		});

		updatePhoneButton.setText("Update phone");
		updatePhoneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updatePhoneButtonActionPerformed(evt);
			}
		});

		updateCommentButton.setText("Update comment");
		updateCommentButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateCommentButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(49, 49, 49)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(layout.createSequentialGroup()
										.addComponent(backButton)
										.addGap(1, 1, 1))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																				.addComponent(phoneLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
																				.addComponent(emailLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																				.addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																						.addComponent(addressTextField)
																						.addComponent(commentTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
																						.addComponent(phoneTextField)
																						.addComponent(emailTextField))
																						.addGap(34, 34, 34))
																						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																										.addComponent(updateNameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(updateAddressButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(updateEmailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(updatePhoneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(updateCommentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(viewClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addGroup(layout.createSequentialGroup()
																																.addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
																																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																.addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
																																.addGap(147, 147, 147)))
																																.addContainerGap(37, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(36, 36, 36)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(viewClientButton))
								.addGap(64, 64, 64)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(updateNameButton))
										.addGap(18, 18, 18)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(updateAddressButton))
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(updateEmailButton))
														.addGap(18, 18, 18)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(updatePhoneButton))
																.addGap(18, 18, 18)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(commentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addComponent(updateCommentButton))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
																				.addComponent(backButton)
																				.addGap(33, 33, 33))
				);
		pack();
	}// </editor-fold>                        

	private void viewClientButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                 
		String id = idTextField.getText();
		long clientId;
		
		ClientBean client = new ClientBean();
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{
			clientId = Long.parseLong(id);
			client = adminAction.viewClientDetails(clientId);
			phoneTextField.setText(String.valueOf(client.getPhone()));
			emailTextField.setText(client.getEmail());
			addressTextField.setText(client.getAddress());
			nameTextField.setText(client.getClientName());
			commentTextField.setText(client.getComment());	
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

	private void updateNameButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                 
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		SuccessMessageWindow successMessageWindow = new SuccessMessageWindow();
		String newName = nameTextField.getText();
		String id = idTextField.getText();
		long clientId = Long.parseLong(id);
		try 
		{
			adminAction.updateClientName(clientId, newName);
			//new window of success
			successMessageWindow.getSuccessLabel().setText("client name successfully updated");
			successMessageWindow.setVisible(true);
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
	}                                                

	private void updateAddressButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                    
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		SuccessMessageWindow successMessageWindow = new SuccessMessageWindow();
		String newAddress = addressTextField.getText();
		String id = idTextField.getText();
		long clientId = Long.parseLong(id);
		try 
		{
			adminAction.updateClientAddress(clientId, newAddress);
			//new window of success
			successMessageWindow.getSuccessLabel().setText("client address successfully updated");
			successMessageWindow.setVisible(true);
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
	}                                                   

	private void updateEmailButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                  
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		SuccessMessageWindow successMessageWindow = new SuccessMessageWindow();
		String newEmail = emailTextField.getText();
		String id = idTextField.getText();
		long clientId = Long.parseLong(id);
		try 
		{
			adminAction.updateClientEmail(clientId, newEmail);
			//new window of success
			successMessageWindow.getSuccessLabel().setText("client email successfully updated");
			successMessageWindow.setVisible(true);
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
	}                                                 

	private void updatePhoneButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                  
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		SuccessMessageWindow successMessageWindow = new SuccessMessageWindow();
		String newPhone = phoneTextField.getText();
		String id = idTextField.getText();
		long clientId = Long.parseLong(id);
		try 
		{
			adminAction.updateClientPhone(clientId, Long.parseLong(newPhone));
			//new window of success
			successMessageWindow.getSuccessLabel().setText("client phone successfully updated");
			successMessageWindow.setVisible(true);
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
	}                                                 

	private void updateCommentButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                    
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		SuccessMessageWindow successMessageWindow = new SuccessMessageWindow();
		String newComment = commentTextField.getText();
		String id = idTextField.getText();
		long clientId = Long.parseLong(id);
		try 
		{
			adminAction.updateClientComment(clientId, newComment);
			//new window of success
			successMessageWindow.getSuccessLabel().setText("client comment successfully updated");
			successMessageWindow.setVisible(true);
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
	}                                                   

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                           
		this.setVisible(false);
		this.dispose();
	}                                          

	// Variables declaration                  
	private javax.swing.JLabel addressLabel;
	private javax.swing.JTextField addressTextField;
	private javax.swing.JButton backButton;
	private javax.swing.JLabel commentLabel;
	private javax.swing.JTextField commentTextField;
	private javax.swing.JLabel emailLabel;
	private javax.swing.JTextField emailTextField;
	private javax.swing.JTextField idTextField;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JLabel phoneLabel;
	private javax.swing.JTextField phoneTextField;
	private javax.swing.JButton updateAddressButton;
	private javax.swing.JButton updateCommentButton;
	private javax.swing.JButton updateEmailButton;
	private javax.swing.JButton updateNameButton;
	private javax.swing.JButton updatePhoneButton;
	private javax.swing.JButton viewClientButton;
	// End of variables declaration                   
}
