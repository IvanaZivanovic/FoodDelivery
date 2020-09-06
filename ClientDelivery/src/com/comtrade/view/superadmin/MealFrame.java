package com.comtrade.view.superadmin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.Category;
import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.Meal;
import com.comtrade.domain.TransferObject;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class MealFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfPrice;
	private Set<Category> categories;
	private Set<Cuisine> cuisines;
	private Set<Meal> meals;
	private JComboBox cbCuisine;
	private JComboBox cbCategory;
	private int idCuisine;
	private int idCategory;
	private int idMeal;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField tfSize;

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public MealFrame() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		CategoryFrame.class.getResource("/images/super-admin-background.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBackground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(413, 66, 77, 20);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfName.setBounds(509, 63, 231, 27);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setBounds(413, 120, 77, 20);
		contentPane.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfPrice.setBounds(509, 117, 231, 27);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setBounds(278, 242, 83, 20);
		contentPane.add(lblCategory);
		
		cbCategory = new JComboBox();
		cbCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String categoryString = cbCategory.getSelectedItem().toString();
				for (Category cat : categories) {
					if (cat.getName().equals(categoryString)) {
						idCategory = cat.getIdCategory();
						break;
						}
				}
			}
		});
		
		cbCategory.setBounds(374, 239, 196, 27);
		contentPane.add(cbCategory);
		
		JLabel lblCuisine = new JLabel("Cuisine");
		lblCuisine.setForeground(Color.WHITE);
		lblCuisine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCuisine.setBounds(613, 242, 100, 20);
		contentPane.add(lblCuisine);
		
		cbCuisine = new JComboBox();
		cbCuisine.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCuisine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cuisineString = cbCuisine.getSelectedItem().toString();
				for (Cuisine cu : cuisines) {
					if (cu.getName().equals(cuisineString)) {
						idCuisine = cu.getIdCuisine();
						break;
					}
					
				}
			}
		});
		
		cbCuisine.setBounds(723, 239, 214, 27);
		contentPane.add(cbCuisine);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameString = tfName.getText();
				Double priceDouble = Double.parseDouble(tfPrice.getText().toString());
				String size = tfSize.getText();
				Cuisine cuisine = new Cuisine();
				Category category = new Category();
				cuisine.setIdCuisine(idCuisine);
				category.setIdCategory(idCategory);
				Meal meal = new Meal(nameString, priceDouble, cuisine, category);
				meal.setSize(size);
				TransferObject request = TransferObject.create(meal, ConstantFc.MEAL, ConstantBl.POST);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String messageString = response.getMessage();
					setDataMealsTable();
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
		btnSave.setBounds(245, 298, 100, 27);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				Double price = Double.parseDouble(tfPrice.getText().toString());
				Cuisine cu = new Cuisine();
				Category cat = new Category();
				cu.setIdCuisine(idCuisine);
				cat.setIdCategory(idCategory);
				Meal meal = new Meal(name, price, cu, cat);
				meal.setIdMeal(idMeal);
				meal.setSize(tfSize.getText());
				
				TransferObject requestM = TransferObject.create(meal, ConstantFc.MEAL, ConstantBl.PUT);
				try {
					TransferObject responseM = FrontController.getInstance().execute(requestM);
					String message = responseM.getMessage();
					setDataMealsTable();
					clearTxtFields();
					JOptionPane.showMessageDialog(null, message);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(385, 298, 100, 27);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Meal meal = new Meal();
				meal.setIdMeal(idMeal);
				TransferObject requestM = TransferObject.create(meal, ConstantFc.MEAL, ConstantBl.DELETE);
				try {
					TransferObject responseM = FrontController.getInstance().execute(requestM);
					String message = responseM.getMessage();
					setDataMealsTable();
					clearTxtFields();
					JOptionPane.showMessageDialog(null, message);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDelete.setBounds(527, 298, 100, 27);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(214, 348, 742, 240);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				idMeal = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				tfName.setText(table.getModel().getValueAt(row, 1).toString());
				tfPrice.setText(table.getModel().getValueAt(row, 3).toString());
				tfSize.setText(table.getModel().getValueAt(row, 2).toString());
				for (Meal m : meals) {
					if(m.getIdMeal()==idMeal) {
						cbCategory.setSelectedItem(m.getCategory().getName());
						cbCuisine.setSelectedItem(m.getCuisine().getName());
					}
				}
												
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSize.setForeground(Color.WHITE);
		lblSize.setBounds(413, 178, 80, 20);
		contentPane.add(lblSize);
		
		tfSize = new JTextField();
		tfSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfSize.setBounds(509, 175, 231, 27);
		contentPane.add(tfSize);
		tfSize.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				
				for (Meal m : meals) {
					if(m.getCategory().getIdCategory()==idCategory || m.getCuisine().getIdCuisine()==idCuisine) {
						Object [] row = {m.getIdMeal(), m.getName(), m.getSize(), m.getPrice(), m.getCuisine().getName(), m.getCategory().getName()};
						dtm.addRow(row);
					}
				}
				
			}
		});
		btnSearch.setBounds(822, 298, 100, 27);
		contentPane.add(btnSearch);
		
		JLabel lblTitle = new JLabel("Meals");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(820, 26, 172, 20);
		contentPane.add(lblTitle);
		
		ImageIcon refresh = new ImageIcon("photos/refresh.JPG");
		
		JButton btnReload = new JButton(refresh);
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setDataMealsTable();
					clearTxtFields();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReload.setBounds(822, 97, 65, 65);
		contentPane.add(btnReload);
		Object [] columns = {"ID Meal", "Name", "Size", "Price", "Cuisine", "Category"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		dtm.addColumn(columns[5]);
		
		setDataMealsTable();
		setDataCategory();
		setDataCuisine();	
	}

	protected void clearTxtFields() {
		tfName.setText("");
		tfPrice.setText("");
		//cbCategory.setSelectedIndex(0);
		//cbCuisine.setSelectedIndex(0);
		tfSize.setText("");
	}

	private void setDataMealsTable() throws ClassNotFoundException, IOException {
		dtm.setRowCount(0);
		TransferObject requestMeal = TransferObject.create(null, ConstantFc.MEAL, ConstantBl.GET_ALL);
		TransferObject responseMeal = FrontController.getInstance().execute(requestMeal);
		meals = (Set<Meal>) responseMeal.getResponse();
		for (Meal m : meals) {
			Object [] rowM = {m.getIdMeal(), m.getName(), m.getSize(), m.getPrice(), m.getCuisine().getName(), m.getCategory().getName()};
			dtm.addRow(rowM);
		}
	}

	private void setDataCuisine() throws ClassNotFoundException, IOException {
		TransferObject requestCuisine = TransferObject.create(null, ConstantFc.CUISINE, ConstantBl.GET_ALL);
		TransferObject responseCuisine = FrontController.getInstance().execute(requestCuisine);
		cuisines = (Set<Cuisine>) responseCuisine.getResponse();
		for (Cuisine c : cuisines) {
			cbCuisine.addItem(c.getName());
		}
		cbCuisine.setSelectedIndex(0);
	}

	private void setDataCategory() throws ClassNotFoundException, IOException {
		TransferObject requestCategory = TransferObject.create(null, ConstantFc.CATEGORY, ConstantBl.GET_ALL);
		TransferObject responseCategory = FrontController.getInstance().execute(requestCategory);
		categories = (Set<Category>) responseCategory.getResponse();
		for (Category cat : categories) {
			cbCategory.addItem(cat.getName());
		}
		cbCategory.setSelectedIndex(0);
	}
}
