package com.comtrade.view.restaurantadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Order;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MidAdminFrame extends JFrame {

	private JPanel contentPane;
	private Restaurant r;
	private User u;
	private List<Order> orders = new ArrayList<Order>();
	

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public MidAdminFrame(User user, Restaurant restaurant) throws ClassNotFoundException, IOException {
		r = restaurant;
		u = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		MidAdminFrame.class.getResource("/images/restaurant-background-3.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon logo = new ImageIcon(restaurant.getPhoto());
		JButton btnAbout = new JButton(logo);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutRestaurantFrame aboutRestaurantFrame = null;
				try {
					aboutRestaurantFrame = new AboutRestaurantFrame(user, restaurant);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				aboutRestaurantFrame.setVisible(true);
			}
		});
		btnAbout.setBounds(403, 245, 80, 80);
		contentPane.add(btnAbout);
		
		JButton btnCategory = new JButton("Category");
		btnCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoryRestFrame categoryRestFrame = null;
				try {
					categoryRestFrame = new CategoryRestFrame(user, restaurant);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				categoryRestFrame.setVisible(true);
			}
		});
		btnCategory.setBounds(563, 137, 120, 30);
		contentPane.add(btnCategory);
		
		JButton btnMeal = new JButton("Meal");
		btnMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MealRestFrame mealRestFrame = new MealRestFrame(user, restaurant);
					mealRestFrame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnMeal.setBounds(225, 412, 120, 23);
		contentPane.add(btnMeal);
		
		JButton btnOrders = new JButton("Orders");
		btnOrders.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RestaurantOrdersFrame rof = null;
				try {
					rof = new RestaurantOrdersFrame(restaurant);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rof.setVisible(true);
			}
		});
		btnOrders.setBounds(563, 412, 120, 30);
		contentPane.add(btnOrders);
		
		JButton btnCuisine = new JButton("Cuisine");
		btnCuisine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCuisine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CuisineRestFrame cuisineRestFrame = null;
				try {
					cuisineRestFrame = new CuisineRestFrame(user, restaurant);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cuisineRestFrame.setVisible(true);
			}
		});
		btnCuisine.setBounds(225, 137, 120, 23);
		contentPane.add(btnCuisine);
		
		getOrders();
		
		
	}


	private void getOrders() throws ClassNotFoundException, IOException {
		TransferObject request = TransferObject.create(r, ConstantFc.ORDER, ConstantBl.GET_ALL_R);
      	TransferObject response = FrontController.getInstance().execute(request);
      	orders = (List<Order>) response.getResponse();
      	for (Order order : orders) {
			if (order.getStatus().equals("waiting")) {
				JOptionPane.showMessageDialog(null, "You have a new order waiting. Please check your orders right away!");
				
					break;
				} 
			}
					
	}
	
}
