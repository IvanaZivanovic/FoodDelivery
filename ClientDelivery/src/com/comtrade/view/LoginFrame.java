package com.comtrade.view;

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
import com.comtrade.proxy.Proxy;
import com.comtrade.proxy.ProxyLogin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField pfPassword;

	

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 472);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		LoginFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(106, 188, 83, 17);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfUsername.setBounds(241, 183, 185, 27);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setBounds(106, 234, 83, 17);
		contentPane.add(lblPassword);
		
		ImageIcon login = new ImageIcon("photos/buttons/login.jpg");
		JButton btnLogin = new JButton(login);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = tfUsername.getText();
				String password = String.copyValueOf(pfPassword.getPassword());
				User user = new User(username, password);
				TransferObject request = TransferObject.create(user, ConstantFc.USER, ConstantBl.POST_LOGIN);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					User userResponse = (User) response.getResponse();
					Proxy proxy = new ProxyLogin();
					proxy.login(userResponse);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogin.setBounds(337, 284, 101, 20);
		contentPane.add(btnLogin);
		
		//ImageIcon register = new ImageIcon("photos/buttons/register.jpg");
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterNewUserFrame newUserFrame = null;
				try {
					newUserFrame = new RegisterNewUserFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				newUserFrame.setVisible(true);
			}
		});
		btnSignUp.setBounds(106, 343, 107, 27);
		contentPane.add(btnSignUp);
		
		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pfPassword.setBounds(241, 229, 185, 27);
		contentPane.add(pfPassword);
		
		//ImageIcon forgotPass = new ImageIcon("photos/buttons/forgotPass.jpg");
		JButton btnForgotPass = new JButton("Forgot Password?");
		btnForgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ForgotPasswordFrame fpf = new ForgotPasswordFrame();
				fpf.setVisible(true);
			}
		});
		btnForgotPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnForgotPass.setBounds(272, 343, 154, 27);
		contentPane.add(btnForgotPass);
		
		
	}
}
