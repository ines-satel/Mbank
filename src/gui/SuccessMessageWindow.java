package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class SuccessMessageWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form successMessageWindow
	 */
	public SuccessMessageWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		successDialog = new javax.swing.JDialog();
		successButton = new javax.swing.JButton();
		successLabel = new javax.swing.JLabel();
		successIconLabel = new javax.swing.JLabel();

		javax.swing.GroupLayout successDialogLayout = new javax.swing.GroupLayout(successDialog.getContentPane());
		successDialog.getContentPane().setLayout(successDialogLayout);
		successDialogLayout.setHorizontalGroup(
				successDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				);
		successDialogLayout.setVerticalGroup(
				successDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
				);

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

		// Center the frame in the center of the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/4;
		int y = (dim.height-h)/4;
		this.setLocation(x, y);

		successButton.setText("OK");
		successButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				successButtonActionPerformed(evt);
			}
		});

		successIconLabel.setIcon(new javax.swing.ImageIcon("success-icon.png")); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(successButton)
						.addGap(251, 251, 251))
						.addGroup(layout.createSequentialGroup()
								.addGap(52, 52, 52)
								.addComponent(successLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(successIconLabel)
								.addContainerGap(26, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(62, 62, 62)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(successIconLabel)
								.addComponent(successLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
								.addComponent(successButton)
								.addGap(33, 33, 33))
				);
		pack();
	}// </editor-fold>                        

	private void successButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                              
		this.setVisible(false);
		this.dispose(); 
	}                                           

	// Variables declaration               
	private javax.swing.JButton successButton;
	private javax.swing.JDialog successDialog;
	private javax.swing.JLabel successIconLabel;
	private javax.swing.JLabel successLabel;
	// End of variables declaration                  

	//Getter & Setter
	public JLabel getSuccessLabel() 
	{
		return successLabel;
	}

	public void setSuccessLabel(JLabel successLabel) 
	{
		this.successLabel = successLabel;
	} 
}
