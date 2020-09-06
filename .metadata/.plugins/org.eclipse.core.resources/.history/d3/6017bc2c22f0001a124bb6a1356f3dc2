package com.comtrade.view.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.Address;
import com.comtrade.domain.Category;
import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Meal;
import com.comtrade.domain.MealOrder;
import com.comtrade.domain.Order;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class OrderCartFrame extends JFrame {

	private JPanel contentPane;
	private Restaurant r;
	private User u;
	private JTable tableMeals;
	private JTable tableCart;
	private JScrollPane scrollPaneCart;
	private DefaultTableModel dtmCart = new DefaultTableModel();
	private DefaultTableModel dtmMeals = new DefaultTableModel();
	private int idCategory;
	private int idMeal;
	private int rowCart;
	private int quantityCart;
	private int idAddress;
	private JComboBox cbCategories;
	private JComboBox cbAddresses;
	private JButton btnLogo;
	private Set<Category> categories = new LinkedHashSet<Category>();
	private Set<Meal> meals = new LinkedHashSet<Meal>();
	private Set<Address> addresses = new LinkedHashSet<Address>();
	private JLabel lblAmountCalculated;
	private JSpinner spinnerQuantity;
	private JTextArea textAreaComment;
	private JLabel lblMinRest;
	private List<MealOrder> mealOrdersList = new CopyOnWriteArrayList<MealOrder>();
	private Order order = new Order();

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public OrderCartFrame(User user, Restaurant restaurant) throws ClassNotFoundException, IOException {
		r = restaurant;
		u = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1157, 653);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		OrderCartFrame.class.getResource("/images/order-wallpaper.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
      	
      	      			
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategories = new JLabel("Categories");
		lblCategories.setForeground(Color.WHITE);
		lblCategories.setBounds(256, 103, 94, 14);
		contentPane.add(lblCategories);
		
		JComboBox cbCategories = new JComboBox();
		cbCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Category cat : categories) {
					if(cat.getName().equals(cbCategories.getSelectedItem().toString())) {
						idCategory = cat.getIdCategory();
					}
				}
			}
		});
		cbCategories.setBounds(377, 100, 164, 20);
		contentPane.add(cbCategories);
		
		TransferObject reqCat = TransferObject.create(r, ConstantFc.CATEGORY, ConstantBl.GET_R_CAT);
		TransferObject responseCat = FrontController.getInstance().execute(reqCat);
		categories = (Set<Category>) responseCat.getResponse();
		for (Category cat : categories) {
			cbCategories.addItem(cat.getName());
		} //cbCategories.setSelectedIndex(0);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmMeals.setRowCount(0);
				for (Meal m : meals) {
					if(idCategory == m.getCategory().getIdCategory()) {
						Object [] rowMeal = {m.getIdMeal(), m.getName(), m.getSize(), m.getPrice()};
						dtmMeals.addRow(rowMeal);
					}
				}
			}
		});
		btnShow.setBounds(609, 99, 89, 23);
		contentPane.add(btnShow);
		
		ImageIcon logo = new ImageIcon(r.getPhoto());
		JButton btnLogo = new JButton(logo);
		/*btnLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getAddresses();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});*/
		btnLogo.setBounds(995, 66, 80, 80);
		contentPane.add(btnLogo);
		
		JSpinner spinnerQuantity = new JSpinner();
		spinnerQuantity.setBounds(1007, 209, 68, 20);
		contentPane.add(spinnerQuantity);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setBounds(909, 212, 88, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setForeground(Color.WHITE);
		lblComment.setBounds(909, 270, 88, 14);
		contentPane.add(lblComment);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(spinnerQuantity.getValue().toString())==0) {
					JOptionPane.showMessageDialog(null, "Please select quantity");
				}else {
				MealOrder mealOrder = new MealOrder();
				Meal meal = new Meal();
				meal.setIdMeal(idMeal);
				for (Meal m : meals) {
					if(idMeal == m.getIdMeal()) {
						meal = m;
					}
				}
				mealOrder.setMeal(meal);
				int quantity = Integer.parseInt(spinnerQuantity.getValue().toString());
				String comment = textAreaComment.getText();
				double amount = quantity * meal.getPrice();
				mealOrder.setAmount(amount);
				mealOrder.setComment(comment);
				mealOrder.setQuantity(quantity);
				mealOrdersList.add(mealOrder);
				Object [] rowCart = {meal.getName(), meal.getPrice(), mealOrder.getQuantity(), mealOrder.getAmount()};
				dtmCart.addRow(rowCart);
				lblAmountCalculated.setText(String.valueOf((amount + Double.parseDouble(lblAmountCalculated.getText()))));
				textAreaComment.setText("");
			}
			}
		});
		btnAddToCart.setBounds(929, 352, 146, 23);
		contentPane.add(btnAddToCart);
		
		JButton btnRemove = new JButton("Remove From Cart");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MealOrder mealOrder = new MealOrder();
				Meal meal = new Meal();
				mealOrder.setMeal(meal);
				meal.setName(tableCart.getModel().getValueAt(rowCart, 0).toString());
				meal.setPrice(Double.valueOf(tableCart.getModel().getValueAt(rowCart, 1).toString()));
				mealOrder.setQuantity(Integer.parseInt(tableCart.getModel().getValueAt(rowCart, 2).toString()));
				mealOrder.setAmount(Double.parseDouble(tableCart.getModel().getValueAt(rowCart, 3).toString()));
				for (MealOrder mo : mealOrdersList) {
					if(mo.getMeal().getName().equals(mealOrder.getMeal().getName()) && 
							mo.getMeal().getPrice() == mealOrder.getMeal().getPrice() &&
							mo.getQuantity() == mealOrder.getQuantity() && 
							mo.getAmount() == mealOrder.getAmount()) {
						mealOrdersList.remove(mo);
						break;
					}
				}
				lblAmountCalculated.setText(String.valueOf(Double.parseDouble(lblAmountCalculated.getText()) - mealOrder.getAmount()));
				dtmCart.removeRow(rowCart);
			}
			
		});
		btnRemove.setBounds(677, 352, 164, 23);
		contentPane.add(btnRemove);
		
		JScrollPane scrollPaneMeals = new JScrollPane(tableMeals);
		scrollPaneMeals.setBounds(199, 154, 683, 152);
		contentPane.add(scrollPaneMeals);
		
		tableMeals = new JTable(dtmMeals);
		scrollPaneMeals.setViewportView(tableMeals);
		tableMeals.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableMeals.getSelectedRow();
				idMeal = Integer.parseInt(tableMeals.getModel().getValueAt(row, 0).toString());
			}
		});
		Object [] columnsMeals = {"Id", "Name", "Size", "Price"};
		dtmMeals.addColumn(columnsMeals[0]);
		dtmMeals.addColumn(columnsMeals[1]);
		dtmMeals.addColumn(columnsMeals[2]);
		dtmMeals.addColumn(columnsMeals[3]);
		
		scrollPaneCart = new JScrollPane(tableCart);
		scrollPaneCart.setBounds(199, 399, 876, 127);
		contentPane.add(scrollPaneCart);
		
		tableCart = new JTable(dtmCart);
		tableCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowCart = tableCart.getSelectedRow();
			}
		});
		scrollPaneCart.setViewportView(tableCart);
		Object [] columnsCart = {"Name", "Price", "Quantity", "Amount"};
		dtmCart.addColumn(columnsCart[0]);
		dtmCart.addColumn(columnsCart[1]);
		dtmCart.addColumn(columnsCart[2]);
		dtmCart.addColumn(columnsCart[3]);
		
		lblAmountCalculated = new JLabel("0");
		lblAmountCalculated.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmountCalculated.setForeground(Color.WHITE);
		lblAmountCalculated.setBounds(996, 573, 80, 14);
		contentPane.add(lblAmountCalculated);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalAmount.setForeground(Color.WHITE);
		lblTotalAmount.setBounds(813, 573, 111, 14);
		contentPane.add(lblTotalAmount);
		
		JScrollPane scrollPaneComment = new JScrollPane();
		scrollPaneComment.setBounds(993, 265, 82, 76);
		contentPane.add(scrollPaneComment);
		textAreaComment = new JTextArea();
		scrollPaneComment.setViewportView(textAreaComment);
		
		JButton btnPlaceOrder = new JButton("Place my Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(lblAmountCalculated.getText()) >= Double.parseDouble(lblMinRest.getText())) {
					int input = JOptionPane.showConfirmDialog(null, "Are you sure?");
					if(input == 0) {
						order.setAmount(Double.parseDouble(lblAmountCalculated.getText()));
						order.setMealOrdersList(mealOrdersList);
						order.setUser(u);
						order.setRestaurant(r);
						Address address = new Address();
						address.setIdAddress(idAddress);
						order.setAddress(address);
						order.setMessage("/");
						SimpleDateFormat sdfDate = new SimpleDateFormat("dd:MM:yyyy");
						SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
											    
					    String timeNow = sdfTime.format(new Date()).toString();
					    String [] time = timeNow.split(":");
					    int hour = Integer.parseInt(time[0]);
					    int min = Integer.parseInt(time[1]);
					    int sec = Integer.parseInt(time[2]);
					    
					    String dateToday = sdfDate.format(new Date()).toString();
					    String [] date = dateToday.split(":");
					    int day = Integer.parseInt(date[0]);
					    int month = Integer.parseInt(date[1]);
					    int year = Integer.parseInt(date[2]);
					    
					    LocalTime lTime = LocalTime.of(hour, min, sec);
					    LocalDate lDate = LocalDate.of(year, month, day);
					    order.setDate(lDate);
					    order.setTime(lTime);
					    
						TransferObject request = new TransferObject().create(order, ConstantFc.ORDER, ConstantBl.POST);
						try {
							TransferObject response = FrontController.getInstance().execute(request);
							JOptionPane.showMessageDialog(null, response.getMessage());
							MyOrdersFrame mof = new MyOrdersFrame(u);
							mof.setVisible(true);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {JOptionPane.showMessageDialog(null, "Your cart amount is under minimal order value");}
				
			}
		});
		btnPlaceOrder.setBounds(441, 569, 186, 23);
		contentPane.add(btnPlaceOrder);
		
		JLabel lblMinimalOrder = new JLabel("Minimal Order");
		lblMinimalOrder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinimalOrder.setForeground(Color.WHITE);
		lblMinimalOrder.setBounds(857, 67, 128, 14);
		contentPane.add(lblMinimalOrder);
		
		lblMinRest = new JLabel(String.valueOf(restaurant.getMinOrder()));
		lblMinRest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinRest.setForeground(Color.WHITE);
		lblMinRest.setBounds(891, 103, 94, 14);
		contentPane.add(lblMinRest);
		
		JLabel lblAddresses = new JLabel("Addresses:");
		lblAddresses.setForeground(Color.WHITE);
		lblAddresses.setBounds(256, 38, 94, 14);
		contentPane.add(lblAddresses);
		
		cbAddresses = new JComboBox();
		cbAddresses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Address a : addresses) {
					if(cbAddresses.getSelectedItem().toString().contains(a.getStreetName()) && 
							cbAddresses.getSelectedItem().toString().contains(a.getStreetNo()) &&
									cbAddresses.getSelectedItem().toString().contains(a.getMunicipality()) &&
									cbAddresses.getSelectedItem().toString().contains(a.getAppLastName()) &&
									cbAddresses.getSelectedItem().toString().contains(a.getCity())) {
						idAddress = a.getIdAddress();
					}
				}
			}
		});
		cbAddresses.setBounds(377, 35, 321, 20);
		contentPane.add(cbAddresses);
		
		JButton btnAddAddress = new JButton("Add an Address");
		btnAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddressFrame af = null;
				try {
					af = new AddressFrame(u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				af.setVisible(true);
			}
		});
		btnAddAddress.setBounds(745, 34, 128, 23);
		contentPane.add(btnAddAddress);
		
		//cbAddresses.setSelectedIndex(0);
		
		
		
		TransferObject reqMeal = TransferObject.create(r, ConstantFc.MEAL, ConstantBl.GET_R_MEAL);
		TransferObject responseMeal = FrontController.getInstance().execute(reqMeal);
		meals = (Set<Meal>) responseMeal.getResponse();
		
		getAddresses();
		
	}

	private void getAddresses() throws ClassNotFoundException, IOException {
		
		TransferObject requestAddress = TransferObject.create(u, ConstantFc.ADDRESS, ConstantBl.GET_ALL_U);
		TransferObject responseAddress = FrontController.getInstance().execute(requestAddress);
		addresses = (Set<Address>) responseAddress.getResponse();
		
		cbAddresses.removeAllItems();
		for (Address a : addresses) {
			cbAddresses.addItem(a.getStreetName() + " " + a.getStreetNo() + ", " + a.getMunicipality() 
			+ ", " + a.getCity() + ", " + a.getAppLastName());
		}
		
	}
}
