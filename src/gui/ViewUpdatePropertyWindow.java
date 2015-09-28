package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import exceptions.PropertyDoesNotExistException;
import gui.TextPrompt.Show;
import actions.AdminActions;

public class ViewUpdatePropertyWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form ViewUpdatePropertyWindow
	 */
	public ViewUpdatePropertyWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		propertyKeysComboBoxView = new javax.swing.JComboBox();
		viewPropertyValueButton = new javax.swing.JButton();
		viewTextField = new javax.swing.JTextField();
		updatePropertyValueButton = new javax.swing.JButton();
		updateTextField = new javax.swing.JTextField();
		propertyKeysComboBoxUpdate = new javax.swing.JComboBox();
		backButton = new javax.swing.JButton();

		TextPrompt promptView = new TextPrompt("Click on view button", viewTextField, Show.ALWAYS);
		promptView.changeStyle(Font.ITALIC);
		promptView.changeAlpha(0.5f);

		TextPrompt promptUpdate = new TextPrompt("Enter a new value", updateTextField, Show.ALWAYS);
		promptUpdate.changeStyle(Font.ITALIC);
		promptUpdate.changeAlpha(0.5f);

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

		// Center the frame in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/4;
		int y = (dim.height-h)/4;
		this.setLocation(x, y);

		propertyKeysComboBoxView.setModel(new javax.swing.DefaultComboBoxModel
				(new String[] { "admin_password", 
						"admin_username", 
						"commission_rate",
						"gold_credit_limit",
						"gold_daily_interest",
						"gold_deposit_commission",
						"gold_deposit_rate",
						"platinum_credit_limit",
						"platinum_daily_interest",
						"platinum_deposit_commission",
						"platinum_deposit_rate",
						"pre_open_fee",
						"regular_credit_limit",
						"regular_daily_interest",
						"regular_deposit_commission",
				"regular_deposit_rate" }));

		viewPropertyValueButton.setText("View property value");
		viewPropertyValueButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewPropertyValueButtonActionPerformed(evt);
			}
		});

		updatePropertyValueButton.setText("Update property value");
		updatePropertyValueButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updatePropertyValueButtonActionPerformed(evt);
			}
		});

		propertyKeysComboBoxUpdate.setModel(new javax.swing.DefaultComboBoxModel

				(new String[] { "admin_password", 
						"admin_username", 
						"commission_rate",
						"gold_credit_limit",
						"gold_daily_interest",
						"gold_deposit_commission",
						"gold_deposit_rate",
						"platinum_credit_limit",
						"platinum_daily_interest",
						"platinum_deposit_commission",
						"platinum_deposit_rate",
						"pre_open_fee",
						"regular_credit_limit",
						"regular_daily_interest",
						"regular_deposit_commission",
				"regular_deposit_rate" }));

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
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(backButton))
										.addGroup(layout.createSequentialGroup()
												.addGap(34, 34, 34)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(propertyKeysComboBoxView, 0, 179, Short.MAX_VALUE)
														.addComponent(propertyKeysComboBoxUpdate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGap(18, 18, 18)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(updatePropertyValueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(viewPropertyValueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addComponent(updateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
																		.addComponent(viewTextField))))
																		.addGap(60, 60, 60))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(70, 70, 70)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(propertyKeysComboBoxView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(viewTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(viewPropertyValueButton))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(updatePropertyValueButton)
										.addComponent(updateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(propertyKeysComboBoxUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
										.addComponent(backButton)
										.addGap(23, 23, 23))
				);
		pack();
	}// </editor-fold>                        

	private void viewPropertyValueButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                        
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		String propertiesKey = (String) propertyKeysComboBoxView.getSelectedItem();
		try 
		{
			String propValue = adminAction.viewSystemProperty(propertiesKey);
			viewTextField.setText(propValue);
		} 
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
			errorMessageWindow.setVisible(true);
		} 
		catch (PropertyDoesNotExistException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText(e.getMessage());
			errorMessageWindow.setVisible(true);
		}
	}           

	private void updatePropertyValueButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                          
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		SuccessMessageWindow successMessageWindow = new SuccessMessageWindow();
		String propertiesKey = (String) propertyKeysComboBoxUpdate.getSelectedItem();
		String propertiesValue = updateTextField.getText();
		try 
		{
			adminAction.updateSystemProperty(propertiesKey, propertiesValue);
			//new window of success
			successMessageWindow.getSuccessLabel().setText("property "+propertiesKey+" successfully updated");
			successMessageWindow.setVisible(true);
		} 
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
			errorMessageWindow.setVisible(true);;
		} 
		catch (PropertyDoesNotExistException e) 
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
	private javax.swing.JButton backButton;
	private javax.swing.JComboBox propertyKeysComboBoxUpdate;
	private javax.swing.JComboBox propertyKeysComboBoxView;
	private javax.swing.JButton updatePropertyValueButton;
	private javax.swing.JTextField updateTextField;
	private javax.swing.JButton viewPropertyValueButton;
	private javax.swing.JTextField viewTextField;
	// End of variables declaration                   
}