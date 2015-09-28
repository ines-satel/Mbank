package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

public class AdminOptionsWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form AdminOptionsWindow
	 */
	public AdminOptionsWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		bankIcon = new javax.swing.JLabel();
		addNewClientButton = new javax.swing.JButton();
		viewAccountsDetailsButton = new javax.swing.JButton();
		removeClientButton = new javax.swing.JButton();
		updateClientDetailsButton = new javax.swing.JButton();
		viewClientsDetailsButton = new javax.swing.JButton();
		viewDepositsDetsilsButton = new javax.swing.JButton();
		viewActivitiesButton = new javax.swing.JButton();
		viewUpdateSystemPropertyButton = new javax.swing.JButton();
		logoutButton = new javax.swing.JButton();
		exitButton = new javax.swing.JButton();
		adminOptionsMenuBar = new javax.swing.JMenuBar();
		fileMenu = new javax.swing.JMenu();
		logoutMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		optionsMenu = new javax.swing.JMenu();
		helpMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		// Center the frame in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/5;
		int y = (dim.height-h)/6;
		this.setLocation(x, y);

		bankIcon.setIcon(new javax.swing.ImageIcon("bank-icon.jpg")); // NOI18N
		bankIcon.setMaximumSize(new java.awt.Dimension(84, 84));
		bankIcon.setMinimumSize(new java.awt.Dimension(84, 84));
		bankIcon.setName(""); // NOI18N

		addNewClientButton.setText("Add new client");
		addNewClientButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addNewClientButtonActionPerformed(evt);
			}
		});

		viewAccountsDetailsButton.setText("View acounts details");
		viewAccountsDetailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewAccountsDetailsButtonActionPerformed(evt);
			}
		});

		removeClientButton.setText("Remove client");
		removeClientButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeClientButtonActionPerformed(evt);
			}
		});

		updateClientDetailsButton.setText("Update client details");
		updateClientDetailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateClientDetailsButtonActionPerformed(evt);
			}
		});

		viewClientsDetailsButton.setText("View clients details");
		viewClientsDetailsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewClientsDetailsButtonActionPerformed(evt);
			}
		});

		viewDepositsDetsilsButton.setText("View deposits details");
		viewDepositsDetsilsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewDepositsDetsilsButtonActionPerformed(evt);
			}
		});

		viewActivitiesButton.setText("View activities");
		viewActivitiesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewActivitiesButtonActionPerformed(evt);
			}
		});

		viewUpdateSystemPropertyButton.setText("View/update system property");
		viewUpdateSystemPropertyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewUpdateSystemPropertyButtonActionPerformed(evt);
			}
		});

		logoutButton.setText("Log out");
		logoutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutButtonActionPerformed(evt);
			}
		});

		exitButton.setText("Exit");
		exitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitButtonActionPerformed(evt);
			}
		});

		fileMenu.setText("File");

		logoutMenuItem.setText("Log out");
		logoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(logoutMenuItem);

		exitMenuItem.setText("Exit");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitMenuItem);

		adminOptionsMenuBar.add(fileMenu);

		optionsMenu.setText("Options");

		helpMenuItem.setText("Help");
		helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				helpMenuItemActionPerformed(evt);
			}
		});
		optionsMenu.add(helpMenuItem);

		adminOptionsMenuBar.add(optionsMenu);

		setJMenuBar(adminOptionsMenuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(174, 174, 174)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(addNewClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(removeClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(updateClientDetailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(viewClientsDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(88, 88, 88)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(viewActivitiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(viewUpdateSystemPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(viewDepositsDetsilsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(viewAccountsDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addComponent(logoutButton))
														.addGap(18, 18, 18)
														.addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addContainerGap(83, Short.MAX_VALUE))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(bankIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(356, 356, 356))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(bankIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(addNewClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(viewAccountsDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(26, 26, 26)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(removeClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(viewDepositsDetsilsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(updateClientDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(viewActivitiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(35, 35, 35)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(viewClientsDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(viewUpdateSystemPropertyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(97, 97, 97)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(logoutButton)
																.addComponent(exitButton))
																.addGap(59, 59, 59))
				);
		pack();
	}// </editor-fold>                        

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) 
	{                                             
		System.exit(0);
	}                                            

	private void logoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) 
	{                                               
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}                                              

	private void addNewClientButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                   
		AddNewClientWindow addNewClientWindow = new AddNewClientWindow();
		addNewClientWindow.setVisible(true);
	}                                                  

	private void removeClientButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                   
		RemoveClientWindow removeClientWindow = new RemoveClientWindow();
		removeClientWindow.setVisible(true);
	}                                                  

	private void updateClientDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                          
		UpdateClientDetailsWindow updateClientDetailsWindow = new UpdateClientDetailsWindow();
		updateClientDetailsWindow.setVisible(true);
	}                                                         

	private void viewClientsDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                         
		ViewClientsWindow viewClientsWindow = new ViewClientsWindow();
		viewClientsWindow.setVisible(true);
	}                                                        

	private void viewAccountsDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                          
		ViewAccountsWindow viewAccountsWindow = new ViewAccountsWindow();
		viewAccountsWindow.setVisible(true);
	}                                                         

	private void viewDepositsDetsilsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                          
		ViewDepositsWindow viewDepositsWindow = new ViewDepositsWindow();
		viewDepositsWindow.setVisible(true);
	}                                                         

	private void viewActivitiesButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                     
		ViewActivitiesWindow viewActivitiesWindow = new ViewActivitiesWindow();
		viewActivitiesWindow.setVisible(true);
	}                                                    

	private void viewUpdateSystemPropertyButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                               
		ViewUpdatePropertyWindow viewUpdatePropertyWindow = new ViewUpdatePropertyWindow();
		viewUpdatePropertyWindow.setVisible(true);
	}                                                              

	private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) 
	{                                             
		// TODO add your handling code here:
	}                                            

	private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                             
		logoutMenuItemActionPerformed(evt);
	}                                                                                  

	private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                           
		exitMenuItemActionPerformed(evt);
	}                                          

	// Variables declaration                    
	private javax.swing.JButton addNewClientButton;
	private javax.swing.JMenuBar adminOptionsMenuBar;
	private javax.swing.JLabel bankIcon;
	private javax.swing.JButton exitButton;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JMenu fileMenu;
	private javax.swing.JMenuItem helpMenuItem;
	private javax.swing.JButton logoutButton;
	private javax.swing.JMenuItem logoutMenuItem;
	private javax.swing.JMenu optionsMenu;
	private javax.swing.JButton removeClientButton;
	private javax.swing.JButton updateClientDetailsButton;
	private javax.swing.JButton viewAccountsDetailsButton;
	private javax.swing.JButton viewActivitiesButton;
	private javax.swing.JButton viewClientsDetailsButton;
	private javax.swing.JButton viewDepositsDetsilsButton;
	private javax.swing.JButton viewUpdateSystemPropertyButton;
	// End of variables declaration                   
}