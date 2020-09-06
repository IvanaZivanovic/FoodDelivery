package com.comtrade.view.superadmin;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RestaurantAdminFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfRestaurantName;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private JPasswordField pfRepeatPass;
	private JTextField tfPhone;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField tfEmail;
	private Set<User>admins = new LinkedHashSet<User>();
	private int idUser;

	

	/**
	 * Create the frame.
	 */
	public RestaurantAdminFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		RestaurantAdminFrame.class.getResource("/images/super-admin-background.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRestaurantName = new JLabel("Restaurant Name");
		lblRestaurantName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRestaurantName.setForeground(Color.WHITE);
		lblRestaurantName.setBounds(320, 188, 102, 14);
		contentPane.add(lblRestaurantName);
		
		tfRestaurantName = new JTextField();
		tfRestaurantName.setBounds(445, 185, 136, 20);
		contentPane.add(tfRestaurantName);
		tfRestaurantName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(609, 188, 98, 14);
		contentPane.add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(717, 185, 136, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(320, 227, 98, 14);
		contentPane.add(lblPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(444, 224, 137, 20);
		contentPane.add(pfPassword);
		
		JLabel lblRepeatPass = new JLabel("Repeat Pass");
		lblRepeatPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepeatPass.setForeground(Color.WHITE);
		lblRepeatPass.setBounds(609, 227, 98, 14);
		contentPane.add(lblRepeatPass);
		
		pfRepeatPass = new JPasswordField();
		pfRepeatPass.setBounds(717, 224, 137, 20);
		contentPane.add(pfRepeatPass);
		
		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(609, 269, 98, 14);
		contentPane.add(lblPhone);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(717, 266, 137, 20);
		contentPane.add(tfPhone);
		tfPhone.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = tfRestaurantName.getText();
				String phone = tfPhone.getText();
				String pass = String.valueOf(pfPassword.getPassword());
				String pass2 = String.valueOf(pfRepeatPass.getPassword());
				String email = tfEmail.getText();
				String username = tfUsername.getText();
				String moneky = "@";
				int status = 0;
				int idRole = 2;
					if(!email.contains(moneky)) {
						JOptionPane.showMessageDialog(null, "Please enter a valid email address");
					} else if (!pass.equals(pass2)) {
						JOptionPane.showMessageDialog(null, "Passwords don't match");
						pfPassword.setText("");
						pfRepeatPass.setText("");
					} else {
					User admin = new User(name, "/", email, phone, username, pass, status);
					admin.setIdRole(idRole);
					TransferObject request = TransferObject.create(admin, ConstantFc.USER, ConstantBl.POST);
					try {
						TransferObject response = FrontController.getInstance().execute(request);
						String messageString = response.getMessage();
						
						setDataInTable();
						clearTxtFields();
						
						JOptionPane.showMessageDialog(null, messageString);
						RestaurantFrame rf = new RestaurantFrame();
						rf.setVisible(true);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					};
			}
		});
		btnSave.setBounds(256, 358, 102, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User userR = new User();
				userR.setIdUser(idUser);
				userR.setEmail(tfEmail.getText());
				userR.setPhoneNumber(tfPhone.getText());
				userR.setFirstName(tfRestaurantName.getText());
				userR.setLastName("/");
				TransferObject request = TransferObject.create(userR, ConstantFc.USER, ConstantBl.PUT);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					tfEmail.setText("");
					tfPhone.setText("");
					tfRestaurantName.setText("");
					tfUsername.setText("");
					setDataInTable();
					JOptionPane.showMessageDialog(null, response.getMessage());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(428, 358, 112, 23);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(206, 409, 792, 162);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				idUser = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				tfEmail.setText(table.getModel().getValueAt(row, 3).toString());
				tfPhone.setText(table.getModel().getValueAt(row, 4).toString());
				tfRestaurantName.setText(table.getModel().getValueAt(row, 1).toString());
				tfUsername.setText(table.getModel().getValueAt(row, 2).toString());
				
				}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(320, 272, 89, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(445, 269, 136, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnRestaurants = new JButton("Go2 Restaurants");
		btnRestaurants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestaurantFrame restaurantFrame = null;
				try {
					restaurantFrame = new RestaurantFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				restaurantFrame.setVisible(true);
			}
		});
		btnRestaurants.setBounds(805, 358, 136, 23);
		contentPane.add(btnRestaurants);
		
		JLabel lblTitle = new JLabel("Admins");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(820, 26, 172, 20);
		contentPane.add(lblTitle);
		Object [] columns = {"ID", "NameR", "Username", "E-mail", "Phone"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		
		setDataInTable();
	}


	protected void clearTxtFields() {
		tfEmail.setText("");
		tfPhone.setText("");
		tfRestaurantName.setText("");
		tfUsername.setText("");
		pfPassword.setText("");
		pfRepeatPass.setText("");
		
	}


	private void setDataInTable() {
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(null, ConstantFc.USER, ConstantBl.GET_ALL_R);
		try {
			TransferObject response = FrontController.getInstance().execute(request);
			admins = (Set<User>) response.getResponse();
			for (User a : admins) {
				Object [] row = {a.getIdUser(), a.getFirstName(), a.getUsername(), a.getEmail(), a.getPhoneNumber()};
				dtm.addRow(row);
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
