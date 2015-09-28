package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class ErrorMessageWindow extends javax.swing.JFrame
{
	/**
	 * Creates new form ErrorMessageWindow
	 */
	public ErrorMessageWindow() {
		initComponents();
	}
	/**
	 * This method is called from within the constructor to initialize the form.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {

		errorDialog = new javax.swing.JDialog();
		errorButton = new javax.swing.JButton();
		errorTextMsg = new javax.swing.JLabel();
		errorIconLabel = new javax.swing.JLabel();

		javax.swing.GroupLayout errorDialogLayout = new javax.swing.GroupLayout(errorDialog.getContentPane());
		errorDialog.getContentPane().setLayout(errorDialogLayout);
		errorDialogLayout.setHorizontalGroup(
				errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
				);
		errorDialogLayout.setVerticalGroup(
				errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

		errorButton.setText("OK");
		errorButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				errorButtonActionPerformed(evt);
			}
		});

		errorIconLabel.setIcon(new javax.swing.ImageIcon("error-icon.gif")); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(32, 32, 32)
						.addComponent(errorTextMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(errorIconLabel)
						.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(263, Short.MAX_VALUE)
								.addComponent(errorButton)
								.addGap(254, 254, 254))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(errorTextMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGap(40, 40, 40)
												.addComponent(errorIconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(errorButton)
												.addGap(26, 26, 26))
				);
		pack();
	}// </editor-fold>                        

	private void errorButtonActionPerformed(java.awt.event.ActionEvent evt) 
	{                                            
		this.setVisible(false);
		this.dispose();
	}                                            

	// Variables declaration                    
	private javax.swing.JButton errorButton;
	private javax.swing.JDialog errorDialog;
	private javax.swing.JLabel errorIconLabel;
	private javax.swing.JLabel errorTextMsg;
	// End of variables declaration        

	//Setter & Getter
	public void setErrorTextMsg(JLabel errorTextMsg) 
	{
		this.errorTextMsg = errorTextMsg;
	}

	public JLabel getErrorTextMsg() 
	{
		return errorTextMsg;
	}
}