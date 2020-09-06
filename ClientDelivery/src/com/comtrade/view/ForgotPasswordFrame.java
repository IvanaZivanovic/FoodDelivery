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
import java.awt.Color;

public class ForgotPasswordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private JTextField tfPhoneNumber;

	

	/**
	 * Create the frame.
	 */
	public ForgotPasswordFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		ForgotPasswordFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(117, 165, 120, 20);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(117, 222, 120, 20);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.BLACK);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(117, 281, 120, 20);
		contentPane.add(lblPhoneNumber);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUsername.setBounds(282, 162, 150, 27);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEmail.setColumns(10);
		tfEmail.setBounds(282, 219, 150, 27);
		contentPane.add(tfEmail);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPhoneNumber.setColumns(10);
		tfPhoneNumber.setBounds(282, 278, 150, 27);
		contentPane.add(tfPhoneNumber);
		
		JButton btnSend = new JButton("Send data");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user = new User();
				user.setUsername(tfUsername.getText());
				TransferObject request = TransferObject.create(user, ConstantFc.USER, ConstantBl.GET_ONE);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					User user2 = (User) response.getResponse();
					if(user2.getEmail().equals(tfEmail.getText()) && user2.getPhoneNumber().equals(tfPhoneNumber.getText())) {
						SetNewPasswordFrame snpf = new SetNewPasswordFrame(user2);
						snpf.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Data does not match, please try again");
						tfEmail.setText("");
						tfPhoneNumber.setText("");
						tfUsername.setText("");
					}
				
					} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSend.setBounds(210, 339, 120, 27);
		contentPane.add(btnSend);
	}
}
