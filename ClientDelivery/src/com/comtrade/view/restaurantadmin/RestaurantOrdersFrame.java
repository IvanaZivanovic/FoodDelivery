package com.comtrade.view.restaurantadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.MealOrder;
import com.comtrade.domain.Order;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class RestaurantOrdersFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableOrders;
	private DefaultTableModel dtmOrders = new DefaultTableModel();
	private DefaultTableModel dtmDetails = new DefaultTableModel();
	private DefaultTableModel dtmAddress = new DefaultTableModel();
	private JScrollPane scrollPaneDetails;
	private JTable tableDetails;
	private JScrollPane scrollPaneAddress;
	private JTable tableAddress;
	private JButton btnNewButton;
	private Restaurant r;
	private List<Order> orders = new ArrayList<Order>();
	private int idOrder;
	private int idDetails;
	private JButton btnRespond;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblTitle;
	private JLabel lblDeliveryTime;
	private JTextField tfTime;
	private JTextArea textAreaComment;
	private JTextField tfContact;

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public RestaurantOrdersFrame(Restaurant restaurant) throws ClassNotFoundException, IOException {
		r = restaurant;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		RestaurantOrdersFrame.class.getResource("/images/restaurant-background-3.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
      
      	
      	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPaneOrders = new JScrollPane(tableOrders);
		scrollPaneOrders.setBounds(121, 104, 742, 193);
		contentPane.add(scrollPaneOrders);
		
		tableOrders = new JTable(dtmOrders);
		tableOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableOrders.getSelectedRow();
				idOrder = Integer.parseInt(tableOrders.getModel().getValueAt(row, 0).toString());
				setDetails();
				setAddress();
				textAreaComment.setText("");
			}
		});
		scrollPaneOrders.setViewportView(tableOrders);
		Object [] columns = {"ID", "Date", "Time", "Amount", "Status"};
		dtmOrders.addColumn(columns[0]);
		dtmOrders.addColumn(columns[1]);
		dtmOrders.addColumn(columns[2]);
		dtmOrders.addColumn(columns[3]);
		dtmOrders.addColumn(columns[4]);
		setOrders();
		
		
		scrollPaneDetails = new JScrollPane(tableDetails);
		scrollPaneDetails.setBounds(121, 337, 514, 159);
		contentPane.add(scrollPaneDetails);
		
		tableDetails = new JTable(dtmDetails);
		tableDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableDetails.getSelectedRow();
				idDetails = Integer.parseInt(tableDetails.getModel().getValueAt(row, 0).toString());
				setComment();
				
			}
		});
		scrollPaneDetails.setViewportView(tableDetails);
		Object [] columnsDetails = {"ID","Meal", "Size", "Quantity"};
		dtmDetails.addColumn(columnsDetails[0]);
		dtmDetails.addColumn(columnsDetails[1]);
		dtmDetails.addColumn(columnsDetails[2]);
		dtmDetails.addColumn(columnsDetails[3]);
		
		scrollPaneAddress = new JScrollPane(tableAddress);
		scrollPaneAddress.setBounds(121, 519, 555, 59);
		contentPane.add(scrollPaneAddress);
		
		tableAddress = new JTable(dtmAddress);
		scrollPaneAddress.setViewportView(tableAddress);
		Object [] columnsAdd = {"Municipality", "Street", "St number", "Apartment", "Last name", "Phone"};
		dtmAddress.addColumn(columnsAdd[0]);
		dtmAddress.addColumn(columnsAdd[1]);
		dtmAddress.addColumn(columnsAdd[2]);
		dtmAddress.addColumn(columnsAdd[3]);
		dtmAddress.addColumn(columnsAdd[4]);
		dtmAddress.addColumn(columnsAdd[5]);
		
		
		ImageIcon logo =  new ImageIcon(restaurant.getPhoto());
		btnNewButton = new JButton(logo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					setOrders();
					dtmDetails.setRowCount(0);
					dtmAddress.setRowCount(0);
					textAreaComment.setText("");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(27, 26, 80, 80);
		contentPane.add(btnNewButton);
		
		btnRespond = new JButton("Respond");
		btnRespond.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRespond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Order order = new Order();
				order.setIdOrder(idOrder);
				int input = JOptionPane.showConfirmDialog(null, "Accept this order?");
				if(input == 0) {
						order.setStatus("accepted");
						order.setMessage("Estimated delivery time is " + tfTime.getText() + " minutes. "+"Contact phone number is " + tfContact.getText() + ".");
						TransferObject request = TransferObject.create(order, ConstantFc.ORDER, ConstantBl.PUT);
						try {
							TransferObject response = FrontController.getInstance().execute(request);
							JOptionPane.showMessageDialog(null, response.getMessage());
							setOrders();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if(input == 1) {
						order.setStatus("rejected");
						order.setMessage("/");
						TransferObject request = TransferObject.create(order, ConstantFc.ORDER, ConstantBl.PUT);
						try {
							TransferObject response = FrontController.getInstance().execute(request);
							JOptionPane.showMessageDialog(null, response.getMessage());
							setOrders();
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
		btnRespond.setBounds(726, 548, 120, 30);
		contentPane.add(btnRespond);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(684, 337, 179, 80);
		contentPane.add(scrollPane_1);
		
		lblTitle = new JLabel("My Orders");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(800, 26, 172, 20);
		contentPane.add(lblTitle);
		
		lblDeliveryTime = new JLabel("Time:");
		lblDeliveryTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeliveryTime.setForeground(Color.WHITE);
		lblDeliveryTime.setBounds(684, 442, 62, 14);
		contentPane.add(lblDeliveryTime);
		
		tfTime = new JTextField();
		tfTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfTime.setBounds(745, 439, 62, 20);
		contentPane.add(tfTime);
		tfTime.setColumns(10);
		
		JLabel lblMinutes = new JLabel("min");
		lblMinutes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinutes.setForeground(Color.WHITE);
		lblMinutes.setBounds(829, 442, 40, 14);
		contentPane.add(lblMinutes);
		
		textAreaComment = new JTextArea();
		textAreaComment.setBounds(684, 333, 179, 80);
		contentPane.add(textAreaComment);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContact.setForeground(Color.WHITE);
		lblContact.setBounds(684, 482, 85, 14);
		contentPane.add(lblContact);
		
		tfContact = new JTextField();
		tfContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfContact.setBounds(755, 479, 110, 20);
		contentPane.add(tfContact);
		tfContact.setColumns(10);
		
		
		
	}

	protected void setComment() {
		
			for(Order or : orders) {
				if(or.getIdOrder() == idOrder) {
					List<MealOrder> mealOrders = or.getMealOrdersList();
					for(MealOrder mo : mealOrders ) {
						if(mo.getIdMealOrder() == idDetails) {
						textAreaComment.setText(mo.getComment());	
						}
						
					}
				}
			}
		}
		
	
	protected void setAddress() {
		dtmAddress.setRowCount(0);
			for(Order or : orders) {
				if(or.getIdOrder() == idOrder) {
					Object [] rowAddress = {or.getAddress().getMunicipality(), or.getAddress().getStreetName(),
							or.getAddress().getStreetNo(), or.getAddress().getAppNumber(), or.getAddress().getAppLastName(), or.getUser().getPhoneNumber()};
						dtmAddress.addRow(rowAddress);
					}
				}
			}
		
		
	protected void setDetails() {
		dtmDetails.setRowCount(0);
		
			for(Order or : orders) {
				if(or.getIdOrder() == idOrder) {
					List<MealOrder> mealOrders = or.getMealOrdersList();
					for(MealOrder mo : mealOrders ) {
						Object [] rowDetails = {mo.getIdMealOrder(), mo.getMeal().getName(), mo.getMeal().getSize(), mo.getQuantity()};
						dtmDetails.addRow(rowDetails);
					}
				}
			}
		}
		
	
		
	private void setOrders() throws ClassNotFoundException, IOException {
		TransferObject request = TransferObject.create(r, ConstantFc.ORDER, ConstantBl.GET_ALL_R);
      	TransferObject response = FrontController.getInstance().execute(request);
      	orders = (List<Order>) response.getResponse();
      	
      	dtmOrders.setRowCount(0);
      		for(Order or : orders) {
				//"ID", "Date", "Time", "Amount", "Status"
				Object[]row = {or.getIdOrder(), or.getDate(), or.getTime(), or.getAmount(), or.getStatus()};
				dtmOrders.addRow(row);
				
			}
		}
	}

