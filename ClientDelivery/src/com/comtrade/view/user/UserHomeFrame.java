package com.comtrade.view.user;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Order;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class UserHomeFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JTextField tfPhone;
	private JLabel lblUsernameTxt;
	private User u;
	

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public UserHomeFrame(User user) throws ClassNotFoundException, IOException {
		u = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 704, 489);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		UserViewRestFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
     
      	/*TransferObject request = TransferObject.create(u, ConstantFc.ORDER, ConstantBl.GET_ALL_U);
		TransferObject response = FrontController.getInstance().execute(request);
		map = (Map<Integer, Set<Order>>) response.getResponse();*/
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(34, 185, 99, 14);
		contentPane.add(lblUsername);
		
		lblUsernameTxt = new JLabel("");
		lblUsernameTxt.setForeground(Color.BLACK);
		lblUsernameTxt.setBounds(153, 185, 144, 14);
		contentPane.add(lblUsernameTxt);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setBounds(34, 229, 99, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setBounds(34, 266, 99, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setBounds(34, 302, 99, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setBounds(34, 345, 99, 14);
		contentPane.add(lblPhone);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(153, 226, 144, 20);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(153, 263, 144, 20);
		contentPane.add(tfLastName);
		tfLastName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(153, 299, 144, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(153, 342, 144, 20);
		contentPane.add(tfPhone);
		tfPhone.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User user = new User();
				
				user.setFirstName(tfFirstName.getText());
				user.setLastName(tfLastName.getText());
				user.setEmail(tfEmail.getText());
				user.setPhoneNumber(tfPhone.getText());
				user.setIdUser(u.getIdUser());
				
				TransferObject request = TransferObject.create(user, ConstantFc.USER, ConstantBl.PUT);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					JOptionPane.showMessageDialog(null, response.getMessage());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(208, 390, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnMyAddresses = new JButton("My addresses");
		btnMyAddresses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddressFrame address = null;
				try {
					address = new AddressFrame(user);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				address.setVisible(true);
			}
		});
		btnMyAddresses.setBounds(386, 229, 138, 23);
		contentPane.add(btnMyAddresses);
		
		JButton btnMyOrders = new JButton("My Orders");
		btnMyOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyOrdersFrame myOrdersFrame = null;
				try {
					myOrdersFrame = new MyOrdersFrame(u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myOrdersFrame.setVisible(true);
			}
		});
		btnMyOrders.setBounds(386, 308, 138, 23);
		contentPane.add(btnMyOrders);
		
		lblUsernameTxt.setText(user.getUsername());
		tfFirstName.setText(user.getFirstName());
		tfLastName.setText(user.getLastName());
		tfEmail.setText(user.getEmail());
		tfPhone.setText(user.getPhoneNumber());
		
		JButton btnOrderNow = new JButton("Order Now");
		btnOrderNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserViewRestFrame restorani = null;
				try {
					restorani = new UserViewRestFrame(u);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		restorani.setVisible(true);
	    		
	    		/*LocalTime dateTimeOne = LocalTime.parse("22:32:38");
	    		if(dateTimeOne.isAfter(tr)) {
	    			UserViewAllRestFrame restorani = new UserViewAllRestFrame();
		    		restorani.setVisible(true);
	    		} else JOptionPane.showMessageDialog(null, "zatvoren zbog jer je kasno");*/
	    	
			}
		});
		btnOrderNow.setBounds(386, 390, 138, 23);
		contentPane.add(btnOrderNow);
	}
}
