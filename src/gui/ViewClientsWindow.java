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
import beans.ClientBean;
import actions.AdminActions;

public class ViewClientsWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form ViewAllClientsWindow
	 */
	public ViewClientsWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		backButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		allClientsTable = new javax.swing.JTable();
		allClientsButton = new javax.swing.JButton();
		viewClientByIdButton = new javax.swing.JButton();
		idTextField = new javax.swing.JTextField();

		TextPrompt promptId = new TextPrompt("Enter client id", idTextField, Show.ALWAYS);
		promptId.changeStyle(Font.ITALIC);
		promptId.changeAlpha(0.5f);

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

		// Center the frame in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/5;
		int y = (dim.height-h)/6;
		this.setLocation(x, y);

		backButton.setText("Back");
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				backButtonActionPerformed(evt);
			}
		});

		allClientsTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"client id", "client name", "password", "type", "address", "email", "phone", "comment"
				}
				));
		jScrollPane1.setViewportView(allClientsTable);

		allClientsButton.setText("View all clients");
		allClientsButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				allClientsButtonActionPerformed(evt);
			}
		});

		viewClientByIdButton.setText("View client by id");
		viewClientByIdButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewClientByIdButtonActionPerformed(evt);
			}
		});

		idTextField.setToolTipText("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(36, 36, 36)
										.addComponent(allClientsButton)
										.addGap(10, 10, 10)
										.addComponent(viewClientByIdButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addGap(0, 0, Short.MAX_VALUE)
														.addComponent(backButton)))
														.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(39, 39, 39)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(allClientsButton)
								.addComponent(viewClientByIdButton)
								.addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
								.addGap(18, 18, 18)
								.addComponent(backButton)
								.addGap(16, 16, 16))
				);
		pack();
	}// </editor-fold>                        

	private void allClientsButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                 
		DefaultTableModel model = (DefaultTableModel) allClientsTable.getModel();
		model.setRowCount(0);

		int rows;
		int occurrences = 0;
		
		AdminActions adminAction = new AdminActions();
		List<ClientBean> clientsList = new ArrayList<ClientBean>();
		ErrorMessageWindow errorMessageWindow = new ErrorMessageWindow();
		try 
		{
			clientsList=adminAction.viewAllClientDetails();
			occurrences=clientsList.size();
			for (rows = 0;rows < occurrences;rows++)
			{
				model.insertRow(rows, new Object [] 
						{clientsList.get(rows).getClientId(),
						clientsList.get(rows).getClientName(), 
						clientsList.get(rows).getPassword(),
						clientsList.get(rows).getType(),
						clientsList.get(rows).getAddress(),
						clientsList.get(rows).getEmail(), 
						clientsList.get(rows).getPhone(), 
						clientsList.get(rows).getComment()});
			}
		} 
		catch (SQLException e) 
		{
			errorMessageWindow.getErrorTextMsg().setText("SQL Error has occurred, please try again");
			errorMessageWindow.setVisible(true);
		}
	}                                                

	private void viewClientByIdButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                                     
		DefaultTableModel model = (DefaultTableModel) allClientsTable.getModel();
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

	private void backButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                           
		this.setVisible(false);
		this.dispose();
	}                                          

	// Variables declaration                    
	private javax.swing.JButton allClientsButton;
	private javax.swing.JTable allClientsTable;
	private javax.swing.JButton backButton;
	private javax.swing.JTextField idTextField;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton viewClientByIdButton;
	// End of variables declaration       
}
