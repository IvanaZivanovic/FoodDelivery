package com.comtrade.view.restaurantadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;

import com.comtrade.frontcontroller.FrontController;
import com.comtrade.view.user.AddressFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class AboutRestaurantFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfCity;
	private JTextField tfMunicipality;
	private JTextField tfMinOrder;
	private JLabel lblNameRest;
	private JComboBox cbFromHours;
	private JComboBox cbFromMinutes;
	private JComboBox cbCloseHours;
	private JComboBox cbCloseMinutes;
	private JComboBox cbUser; 
	private int openHours;
	private int closeHours;
	private int openMinutes;
	private int closeMinutes;
	
	private Restaurant r;
	private User u;
	private JButton btnNewButton;
	private JLabel lblTitle;

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public AboutRestaurantFrame(User user, Restaurant restaurant) throws ClassNotFoundException, IOException {
		r = restaurant;
		u = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		AboutRestaurantFrame.class.getResource("/images/restaurant-background-3.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(323, 201, 177, 20);
		contentPane.add(lblName);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setForeground(Color.WHITE);
		lblCity.setBounds(323, 244, 177, 20);
		contentPane.add(lblCity);
		
		JLabel lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMunicipality.setForeground(Color.WHITE);
		lblMunicipality.setBounds(323, 291, 177, 20);
		contentPane.add(lblMunicipality);
		
		JLabel lblMinOrder = new JLabel("Minimum for Delivery");
		lblMinOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinOrder.setForeground(Color.WHITE);
		lblMinOrder.setBounds(323, 334, 177, 20);
		contentPane.add(lblMinOrder);
		
		lblNameRest = new JLabel("");
		lblNameRest.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameRest.setForeground(Color.WHITE);
		lblNameRest.setBounds(537, 201, 145, 22);
		contentPane.add(lblNameRest);
		
		tfCity = new JTextField();
		tfCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfCity.setBounds(537, 241, 145, 22);
		contentPane.add(tfCity);
		tfCity.setColumns(10);
		
		tfMunicipality = new JTextField();
		tfMunicipality.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfMunicipality.setBounds(537, 288, 145, 22);
		contentPane.add(tfMunicipality);
		tfMunicipality.setColumns(10);
		
		tfMinOrder = new JTextField();
		tfMinOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfMinOrder.setBounds(537, 331, 145, 22);
		contentPane.add(tfMinOrder);
		tfMinOrder.setColumns(10);
		
		JLabel lblWorkingHours = new JLabel("Working Hours:");
		lblWorkingHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWorkingHours.setForeground(Color.WHITE);
		lblWorkingHours.setBounds(219, 438, 136, 20);
		contentPane.add(lblWorkingHours);
		
		JLabel lblOpen = new JLabel("Open");
		lblOpen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOpen.setForeground(Color.WHITE);
		lblOpen.setBounds(370, 422, 92, 20);
		contentPane.add(lblOpen);
		
		cbFromHours = new JComboBox();
		cbFromHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbFromHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openHours = Integer.parseInt(cbFromHours.getSelectedItem().toString());
			}
		});
		
		cbFromHours.setBounds(494, 422, 76, 20);
		contentPane.add(cbFromHours);
		
		cbFromMinutes = new JComboBox();
		cbFromMinutes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbFromMinutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMinutes = Integer.parseInt(cbFromMinutes.getSelectedItem().toString());
			}
		});
		
		cbFromMinutes.setBounds(607, 422, 76, 20);
		contentPane.add(cbFromMinutes);
		
		JLabel lblClose = new JLabel("Close");
		lblClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClose.setForeground(Color.WHITE);
		lblClose.setBounds(371, 472, 91, 20);
		contentPane.add(lblClose);
		
		cbCloseHours = new JComboBox();
		cbCloseHours.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCloseHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeHours = Integer.parseInt(cbCloseHours.getSelectedItem().toString());
			}
		});
		
		cbCloseHours.setBounds(494, 472, 76, 20);
		contentPane.add(cbCloseHours);
		
		cbCloseMinutes = new JComboBox();
		cbCloseMinutes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCloseMinutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeMinutes = Integer.parseInt(cbCloseMinutes.getSelectedItem().toString());
			}
		});
		
		cbCloseMinutes.setBounds(607, 472, 76, 20);
		contentPane.add(cbCloseMinutes);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Restaurant restAdmin = r;
				
				
				r.setCity(tfCity.getText());
				r.setMinOrder(Double.parseDouble(tfMinOrder.getText()));
				r.setMunicipallity(tfMunicipality.getText());
				r.setOpenTime(LocalTime.of(openHours, openMinutes));
				r.setCloseTime(LocalTime.of(closeHours, closeMinutes));
				
				TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.PUT);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String message = response.getMessage();
					JOptionPane.showMessageDialog(null, message);
								
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(476, 532, 120, 27);
		contentPane.add(btnUpdate);
		
		ImageIcon logo = new ImageIcon(r.getPhoto());
		btnNewButton = new JButton(logo);
		btnNewButton.setBounds(27, 26, 80, 80);
		contentPane.add(btnNewButton);
		
		lblTitle = new JLabel("About");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(800, 26, 172, 20);
		contentPane.add(lblTitle);
				
		setCbTime();
		
		setFields();
						
		
	}
	
	private void setFields() {
				
		lblNameRest.setText(r.getName());
		tfCity.setText(r.getCity());
		tfMinOrder.setText(String.valueOf(r.getMinOrder()));
		tfMunicipality.setText(r.getMunicipallity());
		
		String openTime = r.getOpenTime().toString();
		String [] open = openTime.split(":");
		int openH = Integer.parseInt(open[0]);
		int openM = Integer.parseInt(open[1]);
		cbFromHours.setSelectedItem(openH);
		cbFromMinutes.setSelectedItem(openM);
		
		String closeTime = r.getCloseTime().toString();
		String [] close = closeTime.split(":");
		int closeH = Integer.parseInt(close[0]);
		int closeM = Integer.parseInt(close[1]);
		cbCloseHours.setSelectedItem(closeH);
		cbCloseMinutes.setSelectedItem(closeM);		
	}

	private void setCbTime() {
		for (int i = 0; i < 24; i++) {
			cbFromHours.addItem(i);
			cbCloseHours.addItem(i);
		}
		for (int i = 0; i < 60; i++) {
			cbFromMinutes.addItem(i);
			cbCloseMinutes.addItem(i);
		}
		
	}
}
