package com.comtrade.view.superadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MidFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MidFrame frame = new MidFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MidFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 706, 398);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		MidFrame.class.getResource("/images/super-admin-background.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRestaurant = new JButton("Restaurant");
		btnRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RestaurantFrame restaurantFrame = null;
				try {
					restaurantFrame = new RestaurantFrame();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				restaurantFrame.setVisible(true);
			}
		});
		btnRestaurant.setBounds(400, 292, 130, 25);
		contentPane.add(btnRestaurant);
		
		JButton btnCuisine = new JButton("Cuisine");
		btnCuisine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCuisine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuisineFrame cuisineFrame = null;
				try {
					cuisineFrame = new CuisineFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cuisineFrame.setVisible(true);
			}
		});
		btnCuisine.setBounds(572, 292, 130, 25);
		contentPane.add(btnCuisine);
		
		JButton btnCategory = new JButton("Category");
		btnCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoryFrame categoryFrame = null;
				try {
					categoryFrame = new CategoryFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				categoryFrame.setVisible(true);
			}
		});
		btnCategory.setBounds(365, 368, 130, 25);
		contentPane.add(btnCategory);
		
		JButton btnMeal = new JButton("Meal");
		btnMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MealFrame mealFrame = null;
				try {
					mealFrame = new MealFrame();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mealFrame.setVisible(true);
			}
		});
		btnMeal.setBounds(595, 368, 130, 25);
		contentPane.add(btnMeal);
		
		JButton btnRestaurantAdmin = new JButton("Restaurant Admin");
		btnRestaurantAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRestaurantAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RestaurantAdminFrame restaurantAdminFrame = new RestaurantAdminFrame();
				restaurantAdminFrame.setVisible(true);
			}
		});
		btnRestaurantAdmin.setBounds(473, 215, 160, 30);
		contentPane.add(btnRestaurantAdmin);
	}
}
