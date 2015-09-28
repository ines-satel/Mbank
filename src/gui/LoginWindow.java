package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;
import exceptions.LoginException;
import exceptions.PropertyDoesNotExistException;
import gui.TextPrompt.Show;
import actions.AdminActions;

public class LoginWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form NewJFrame
	 */
	public LoginWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		loginPanel = new javax.swing.JPanel();
		nameTextField = new javax.swing.JTextField();
		nameLabel = new javax.swing.JLabel();
		passwordLabel = new javax.swing.JLabel();
		passwordTextField = new javax.swing.JPasswordField();
		loginButton = new javax.swing.JButton();
		bankIcon = new javax.swing.JLabel();
		loginMenuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		loginMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		optionsMenu = new javax.swing.JMenu();
		helpMenuItem = new javax.swing.JMenuItem();

		TextPrompt promptName = new TextPrompt("user name", nameTextField, Show.ALWAYS);
		promptName.changeStyle(Font.ITALIC);
		promptName.changeAlpha(0.5f);

		TextPrompt promptPassword = new TextPrompt("password", passwordTextField, Show.ALWAYS);
		promptPassword.changeStyle(Font.ITALIC);
		promptPassword.changeAlpha(0.5f);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Center the frame in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/3;
		int y = (dim.height-h)/4;
		this.setLocation(x, y);

		nameLabel.setText("User name");

		passwordLabel.setText("Password");

		loginButton.setText("Login");
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});

		bankIcon.setIcon(new javax.swing.ImageIcon("bank-icon.jpg")); // NOI18N
		bankIcon.setMaximumSize(new java.awt.Dimension(84, 84));
		bankIcon.setMinimumSize(new java.awt.Dimension(84, 84));

		javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
		loginPanel.setLayout(loginPanelLayout);
		loginPanelLayout.setHorizontalGroup(
				loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(loginPanelLayout.createSequentialGroup()
						.addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(loginPanelLayout.createSequentialGroup()
										.addGap(134, 134, 134)
										.addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(loginPanelLayout.createSequentialGroup()
												.addGap(51, 51, 51)
												.addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addGroup(loginPanelLayout.createSequentialGroup()
																.addComponent(passwordLabel)
																.addGap(18, 18, 18)
																.addComponent(passwordTextField))
																.addGroup(loginPanelLayout.createSequentialGroup()
																		.addComponent(nameLabel)
																		.addGap(18, 18, 18)
																		.addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginPanelLayout.createSequentialGroup()
																						.addComponent(bankIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(28, 28, 28)))))))
																						.addContainerGap(68, Short.MAX_VALUE))
				);
		loginPanelLayout.setVerticalGroup(
				loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(loginPanelLayout.createSequentialGroup()
						.addComponent(bankIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(nameLabel)
								.addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(20, 20, 20)
								.addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordLabel))
										.addGap(33, 33, 33)
										.addComponent(loginButton)
										.addContainerGap(77, Short.MAX_VALUE))
				);

		fileMenu.setText("File");

		loginMenuItem.setText("Login");
		loginMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(loginMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		loginMenuBar.add(fileMenu);

		optionsMenu.setText("Options");

		helpMenuItem.setText("Help");
		optionsMenu.add(helpMenuItem);

		loginMenuBar.add(optionsMenu);

		setJMenuBar(loginMenuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(66, 66, 66)
						.addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(80, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		pack();
	}// </editor-fold>                        

	private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                            
		AdminActions adminAction = new AdminActions();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{	//check if the user name and password are valid (compare to those in the DB)
			if(nameTextField.getText().equals(adminAction.viewSystemProperty("admin_username"))
					&& passwordTextField.getText().equals(adminAction.viewSystemProperty("admin_password")))
			{	
				//If they both equal to the values in the DB, 
				//a new window of the admin main menu is opens
				AdminOptionsWindow optionsWindow = new AdminOptionsWindow();
				optionsWindow.setVisible(true);
				this.setVisible(false);
				this.dispose();
			}
			else
			{
				LoginException loginException = new LoginException();
				errorMessageWindow.getErrorTextMsg().setText(loginException.getMessage());
				errorMessageWindow.setVisible(true);
			}
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

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) 
	{                                             
		System.exit(0);
	}                                            

	private void loginMenuItemActionPerformed(java.awt.event.ActionEvent evt) 
	{                                              
		loginButtonActionPerformed(evt);
	}   
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginWindow().setVisible(true);
			}
		});
	}

	// Variables declaration                    
	private javax.swing.JLabel bankIcon;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenuItem helpMenuItem;
	private javax.swing.JButton loginButton;
	private javax.swing.JMenuBar loginMenuBar;
	private javax.swing.JMenuItem loginMenuItem;
	private javax.swing.JPanel loginPanel;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JTextField nameTextField;
	private javax.swing.JMenu optionsMenu;
	private javax.swing.JLabel passwordLabel;
	private javax.swing.JPasswordField passwordTextField;
	// End of variables declaration                   
}