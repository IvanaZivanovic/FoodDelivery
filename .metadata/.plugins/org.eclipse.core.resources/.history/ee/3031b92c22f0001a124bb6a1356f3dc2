package com.comtrade.view.superadmin;

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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;


public class RestaurantFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfCity;
	private JTextField tfMunicipality;
	private JTextField tfMinimumDelivery;
	private JTable tableRestaurants;
	private DefaultTableModel dtm = new DefaultTableModel();
	
	private int idRestaurant;
	
	private int idUser;
	private JComboBox cbFromHours;
	private JComboBox cbFromMinutes;
	private JComboBox cbCloseHours;
	private JComboBox cbCloseMinutes;
	private JComboBox cbUser; 
	private int openHours;
	private int closeHours;
	private int openMinutes;
	private int closeMinutes;
	private Set<Restaurant> restaurants = new LinkedHashSet<Restaurant>();
	
	private Set<User> admins = new LinkedHashSet<User>();
	private JTextField tfPhoto;
	
	

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public RestaurantFrame() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		RestaurantFrame.class.getResource("/images/super-admin-background.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(258, 206, 106, 14);
		contentPane.add(lblName);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCity.setForeground(Color.WHITE);
		lblCity.setBounds(637, 200, 108, 14);
		contentPane.add(lblCity);
		
		JLabel lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setForeground(Color.WHITE);
		lblMunicipality.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMunicipality.setBounds(258, 252, 106, 14);
		contentPane.add(lblMunicipality);
		
		JLabel lblMinimalOrder = new JLabel("Minimal Order");
		lblMinimalOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMinimalOrder.setForeground(Color.WHITE);
		lblMinimalOrder.setBounds(637, 252, 108, 14);
		contentPane.add(lblMinimalOrder);
		
		tfName = new JTextField();
		tfName.setBounds(374, 200, 191, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfCity = new JTextField();
		tfCity.setBounds(769, 194, 165, 20);
		contentPane.add(tfCity);
		tfCity.setColumns(10);
		
		tfMunicipality = new JTextField();
		tfMunicipality.setBounds(374, 246, 191, 20);
		contentPane.add(tfMunicipality);
		tfMunicipality.setColumns(10);
		
		tfMinimumDelivery = new JTextField();
		tfMinimumDelivery.setBounds(769, 246, 165, 20);
		contentPane.add(tfMinimumDelivery);
		tfMinimumDelivery.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameString = tfName.getText();
				String cityString = tfCity.getText();
				String municipalityString = tfMunicipality.getText();
				double minOrder = Double.valueOf(tfMinimumDelivery.getText());
				/*String openTime = openHours + ":" + openMinutes;
				String closeTime = closeHours + ":" + closeMinutes;*/
				LocalTime open = LocalTime.of(openHours, openMinutes);
				LocalTime close = LocalTime.of(closeHours, closeMinutes);
				String photo =  tfPhoto.getText();
				
				Restaurant restaurant = new Restaurant(nameString, cityString, municipalityString, minOrder);
				restaurant.setOpenTime(open);
				restaurant.setCloseTime(close);
				restaurant.setPhoto(photo);
				/*Cuisine cuisine = new Cuisine();
				cuisine.setIdCuisine(idCuisine);
				restaurant.setCuisine(cuisine);*/
				User user = new User();
				user.setIdUser(idUser);
				restaurant.setUser(user);
				TransferObject request = TransferObject.create(restaurant, ConstantFc.RESTAURANT, ConstantBl.POST);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String messageString = response.getMessage();
					setDataInTable();
					clearTxtFields();
					JOptionPane.showMessageDialog(null, messageString);
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnSave.setBounds(373, 375, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Restaurant r = new Restaurant(tfName.getText(), tfCity.getText(), 
						tfMunicipality.getText(), Double.parseDouble(tfMinimumDelivery.getText()));
				r.setIdRestaurant(idRestaurant);
				LocalTime open = LocalTime.of(openHours, openMinutes);
				LocalTime close = LocalTime.of(closeHours, closeMinutes);
				r.setOpenTime(open);
				r.setCloseTime(close);
				r.setPhoto(tfPhoto.getText());
				
				User user = new User();
				user.setIdUser(idUser);
				r.setUser(user);
				TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.PUT);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String messageString = response.getMessage();
					setDataInTable();
					clearTxtFields();
					JOptionPane.showMessageDialog(null, messageString);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(568, 375, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Restaurant r = new Restaurant();
				r.setIdRestaurant(idRestaurant);
				TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.DELETE);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String messageString = response.getMessage();
					setDataInTable();
					clearTxtFields();
					JOptionPane.showMessageDialog(null, messageString);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(844, 375, 89, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPaneRestaurants = new JScrollPane(tableRestaurants);
		scrollPaneRestaurants.setBounds(124, 409, 938, 178);
		contentPane.add(scrollPaneRestaurants);
		
		tableRestaurants = new JTable(dtm);
		tableRestaurants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableRestaurants.getSelectedRow();
				idRestaurant = Integer.parseInt(tableRestaurants.getModel().getValueAt(row, 0).toString());
				tfName.setText(tableRestaurants.getModel().getValueAt(row, 1).toString());
				tfCity.setText(tableRestaurants.getModel().getValueAt(row, 2).toString());
				tfMunicipality.setText(tableRestaurants.getModel().getValueAt(row, 3).toString());
				tfMinimumDelivery.setText(tableRestaurants.getModel().getValueAt(row, 4).toString());
				tfPhoto.setText(tableRestaurants.getModel().getValueAt(row, 7).toString());
				
				String openTime = tableRestaurants.getModel().getValueAt(row, 5).toString();
				String [] open = openTime.split(":");
				int openH = Integer.parseInt(open[0]);
				int openM = Integer.parseInt(open[1]);
				cbFromHours.setSelectedItem(openH);
				cbFromMinutes.setSelectedItem(openM);
				
				String closeTime = tableRestaurants.getModel().getValueAt(row, 6).toString();
				String [] close = closeTime.split(":");
				int closeH = Integer.parseInt(close[0]);
				int closeM = Integer.parseInt(close[1]);
				cbCloseHours.setSelectedItem(closeH);
				cbCloseMinutes.setSelectedItem(closeM);
				
				String user2 = tableRestaurants.getModel().getValueAt(row, 8).toString();
				for (User u : admins) {
					if(u.getUsername().equals(user2)) {
						cbUser.setSelectedItem(u.getUsername());
						break;
					}
				}
			}
		});
		scrollPaneRestaurants.setViewportView(tableRestaurants);
		
		JLabel lblWorkingHours = new JLabel("Working Hours:");
		lblWorkingHours.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWorkingHours.setForeground(Color.WHITE);
		lblWorkingHours.setBounds(388, 101, 126, 14);
		contentPane.add(lblWorkingHours);
		
		JLabel lblOpen = new JLabel("Open");
		lblOpen.setForeground(Color.WHITE);
		lblOpen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOpen.setBounds(527, 81, 65, 14);
		contentPane.add(lblOpen);
		
		cbFromHours = new JComboBox();
		cbFromHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openHours = Integer.parseInt(cbFromHours.getSelectedItem().toString());
				}
		});
		cbFromHours.setBounds(582, 75, 76, 20);
		contentPane.add(cbFromHours);
		
		cbFromMinutes = new JComboBox();
		cbFromMinutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMinutes = Integer.parseInt(cbFromMinutes.getSelectedItem().toString());
			}
		});
		cbFromMinutes.setBounds(695, 75, 76, 20);
		contentPane.add(cbFromMinutes);
		
		JLabel lblClose = new JLabel("Close");
		lblClose.setForeground(Color.WHITE);
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClose.setBounds(527, 123, 46, 14);
		contentPane.add(lblClose);
		
		cbCloseHours = new JComboBox();
		cbCloseHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeHours = Integer.parseInt(cbCloseHours.getSelectedItem().toString());
			}
		});
		cbCloseHours.setBounds(582, 120, 76, 20);
		contentPane.add(cbCloseHours);
		
		cbCloseMinutes = new JComboBox();
		cbCloseMinutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeMinutes = Integer.parseInt(cbCloseMinutes.getSelectedItem().toString());
			}
		});
		cbCloseMinutes.setBounds(695, 120, 76, 20);
		contentPane.add(cbCloseMinutes);
		
		JLabel lblUserRestaurant = new JLabel("User");
		lblUserRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserRestaurant.setForeground(Color.WHITE);
		lblUserRestaurant.setBounds(258, 310, 60, 14);
		contentPane.add(lblUserRestaurant);
		
		cbUser = new JComboBox();
		cbUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = cbUser.getSelectedItem().toString();
				for (User u : admins) {
					if(user.equals(u.getUsername())) {
						idUser = u.getIdUser();
						break;
					}
				}
			}
		});
		cbUser.setBounds(374, 308, 191, 20);
		contentPane.add(cbUser);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoto.setForeground(Color.WHITE);
		lblPhoto.setBounds(637, 310, 46, 14);
		contentPane.add(lblPhoto);
		
		tfPhoto = new JTextField("photos/logo/donesiIvana-small.JPG");
		tfPhoto.setBounds(769, 308, 165, 20);
		contentPane.add(tfPhoto);
		tfPhoto.setColumns(10);
		
		JLabel lblTitle = new JLabel("Restaurants");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(820, 26, 172, 20);
		contentPane.add(lblTitle);
		
		Object[] columns = {"ID", "Name", "City", "Municipality", "Min Order", "Opens", "Closes", "Photo", "User"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		dtm.addColumn(columns[5]);
		dtm.addColumn(columns[6]);
		dtm.addColumn(columns[7]);
		dtm.addColumn(columns[8]);
		setDataInTable();
		setCbTime();
		
		setCbUser();
	}

	private void setCbUser() throws ClassNotFoundException, IOException {
		TransferObject request = TransferObject.create(null, ConstantFc.USER, ConstantBl.GET_ALL_R);
		TransferObject response = FrontController.getInstance().execute(request);
		admins = (Set<User>) response.getResponse();
		for (User u : admins) {
			cbUser.addItem(u.getUsername().toString());
		}
		
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
		cbFromHours.setSelectedIndex(0);
		cbFromMinutes.setSelectedIndex(0);
		cbCloseHours.setSelectedIndex(0);
		cbCloseMinutes.setSelectedIndex(0);
	}

	protected void clearTxtFields() {
		tfCity.setText("");
		tfMinimumDelivery.setText("");
		tfMunicipality.setText("");
		tfName.setText("");
		tfPhoto.setText("");
		cbFromHours.setSelectedIndex(0);
		cbFromMinutes.setSelectedIndex(0);
		cbCloseHours.setSelectedIndex(0);
		cbCloseMinutes.setSelectedIndex(0);
		cbUser.setSelectedIndex(0);
		
	}

	private void setDataInTable() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(null, ConstantFc.RESTAURANT, ConstantBl.GET_ALL);
		TransferObject response = FrontController.getInstance().execute(request);
		restaurants = (Set<Restaurant>) response.getResponse();
		for (Restaurant r : restaurants) {
			Object[]rowRest = {r.getIdRestaurant(), r.getName(), r.getCity(), r.getMunicipallity(), 
					r.getMinOrder(), r.getOpenTime(), r.getCloseTime(), r.getPhoto(), r.getUser().getUsername()};
			dtm.addRow(rowRest);
		}
	}
}
