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
import com.comtrade.view.user.AddressFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegisterNewUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfEmail;
	private JTextField tfLastName;
	private JTextField tfPhoneNumber;
	private JTextField tfUsername;
	private Set<User> users = new LinkedHashSet<User>();
	private JPasswordField pfPassword;
	private JPasswordField pfPassword2;
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public RegisterNewUserFrame() throws ClassNotFoundException, IOException {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 899, 510);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		RegisterNewUserFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
      
      	TransferObject request = TransferObject.create(null, ConstantFc.USER, ConstantBl.GET_ALL_U);
      	TransferObject response = FrontController.getInstance().execute(request);
		users = (Set<User>) response.getResponse();
      	
      
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(147, 217, 100, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(430, 217, 100, 14);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(205, 365, 100, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(147, 269, 100, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRepeatPass = new JLabel("Repeat password");
		lblRepeatPass.setBounds(430, 269, 100, 14);
		contentPane.add(lblRepeatPass);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(147, 320, 100, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(430, 320, 100, 14);
		contentPane.add(lblPhoneNumber);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(257, 214, 139, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(257, 317, 139, 20);
		contentPane.add(tfEmail);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(563, 214, 139, 20);
		contentPane.add(tfLastName);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setColumns(10);
		tfPhoneNumber.setBounds(563, 317, 139, 20);
		contentPane.add(tfPhoneNumber);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(333, 362, 139, 20);
		contentPane.add(tfUsername);
		
		
		
		JButton btnCheckAvailability = new JButton("Check availability");
		btnCheckAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean busy = false;
				if(tfUsername.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Username must be at least 1 character long");
					busy = true;
				}
				else {	for (User userResp : users) {
						if(tfUsername.getText().equals(userResp.getUsername())) {
							busy = true;
							JOptionPane.showMessageDialog(null, "This username is already taken. Please choose another one.");
							tfUsername.setText("");
							break;
						}
					} if(busy == false ) {
						JOptionPane.showMessageDialog(null, "Username is available!");
					}
				}
				}
			
		});
		btnCheckAvailability.setBounds(563, 362, 139, 23);
		contentPane.add(btnCheckAvailability);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(257, 266, 139, 20);
		contentPane.add(pfPassword);
		
		pfPassword2 = new JPasswordField();
		pfPassword2.setBounds(563, 266, 139, 20);
		contentPane.add(pfPassword2);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean ok = true;
				String password = String.copyValueOf(pfPassword.getPassword());
				String password2 = String.copyValueOf(pfPassword2.getPassword());
				if(tfUsername.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Username must be at least 1 character long");
					ok = false;
				} if (!password.equals(password2)) {
					JOptionPane.showMessageDialog(null, "Passwords don't match");
					pfPassword.setText("");
					pfPassword2.setText("");
					ok = false; 
				} if (!tfEmail.getText().contains("@") || !tfEmail.getText().contains(".")) {
					JOptionPane.showMessageDialog(null, "Please enter a valid email address");
					ok = false;
				}
					for (User userResp : users) {
						if(tfUsername.getText().equals(userResp.getUsername())) {
							ok = false;
							JOptionPane.showMessageDialog(null, "This username is already taken. Please choose another one.");
							tfUsername.setText("");
							break;
						} else if(tfEmail.getText().equals(userResp.getEmail())) {
							ok = false;
							JOptionPane.showMessageDialog(null, "This email is already registrated");
							tfEmail.setText("");
							break;
						}
					} if(ok == true ) {
						//JOptionPane.showMessageDialog(null, "Ubode ga!");
						User user = new User();
						user.setFirstName(tfFirstName.getText());
						user.setLastName(tfLastName.getText());
						user.setEmail(tfEmail.getText());
						user.setPassword(String.copyValueOf(pfPassword.getPassword()));
						user.setUsername(tfUsername.getText());
						user.setPhoneNumber(tfPhoneNumber.getText());
						user.setStatus(0);
						user.setIdRole(3);
						TransferObject requestReg = TransferObject.create(user, ConstantFc.USER, ConstantBl.POST_USER);
						try {
							TransferObject responseReg = FrontController.getInstance().execute(requestReg);
							User user2 = (User) responseReg.getResponse();
							
							JOptionPane.showMessageDialog(null, responseReg.getMessage());
							AddressFrame af = new AddressFrame(user2);
							af.setVisible(true);
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
		btnRegister.setBounds(563, 408, 139, 23);
		contentPane.add(btnRegister);
	}
}
