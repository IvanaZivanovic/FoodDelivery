package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SetNewPasswordFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pf1;
	private JPasswordField pf2;
	private User u;
	

	

	/**
	 * Create the frame.
	 */
	public SetNewPasswordFrame(User user) {
		u = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		SetNewPasswordFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewPass = new JLabel("New Password");
		lblNewPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewPass.setBounds(105, 167, 142, 20);
		contentPane.add(lblNewPass);
		
		JLabel lblRepeatPass = new JLabel("Repeat Password");
		lblRepeatPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRepeatPass.setBounds(105, 223, 142, 20);
		contentPane.add(lblRepeatPass);
		
		
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ok = true;
				String password = String.copyValueOf(pf1.getPassword());
				String password2 = String.copyValueOf(pf2.getPassword());
				if (!password.equals(password2)) {
					JOptionPane.showMessageDialog(null, "Passwords don't match");
					pf1.setText("");
					pf2.setText("");
					ok = false; 
				} 
				if (ok == true){
					u.setPassword(String.copyValueOf(pf1.getPassword()));
					TransferObject request = TransferObject.create(u, ConstantFc.USER, ConstantBl.PUT_PASS);
					try {
						TransferObject response = FrontController.getInstance().execute(request);
						JOptionPane.showMessageDialog(null, response.getMessage());
						LoginFrame lf = new LoginFrame();
						lf.setVisible(true);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
				}
								
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(303, 299, 120, 27);
		contentPane.add(btnSave);
		
		pf1 = new JPasswordField();
		pf1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pf1.setBounds(303, 164, 150, 27);
		contentPane.add(pf1);
		
		pf2 = new JPasswordField();
		pf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pf2.setBounds(303, 216, 150, 27);
		contentPane.add(pf2);
	}
}
