package com.comtrade.view.restaurantadmin;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JFrame;

import com.comtrade.domain.Category;
import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.DtoMealRest;
import com.comtrade.domain.Meal;

import com.comtrade.domain.RestMeal;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;




public class MealRestFrame extends JFrame {
	
	private JPanel contentPane;
	private User u;
	private Restaurant r;
	private JTable tableOnHold;
	private JTable tableMy;
	private DefaultTableModel dtmOnHold = new DefaultTableModel();
	private DefaultTableModel dtmMy = new DefaultTableModel();
	private DefaultTableModel dtmByCat = new DefaultTableModel();
	private JComboBox cbCategory;
	private Set<Category> categories = new LinkedHashSet<Category>();
	private Set<Meal> meals = new LinkedHashSet<Meal>();
	private Set<Meal> onHold = new LinkedHashSet<Meal>();
	private Set<DtoMealRest> myMeals = new LinkedHashSet<DtoMealRest>();
	private int idCategory;
	private int idMeal;
	private int idOnHold;
	private int rowOnHold;
	private int idMy;
	private JTable tableMealsByCat;
	private JTextField tfSearchMeals;

	
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public MealRestFrame(User user, Restaurant restaurant) throws ClassNotFoundException, IOException {
		r = restaurant;
		u = user;
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		MealRestFrame.class.getResource("/images/restaurant-background-3.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbCategory = new JComboBox();
		cbCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
		cbCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Category category : categories) {
					if(category.getName().equals(cbCategory.getSelectedItem().toString())) {
						idCategory = category.getIdCategory();
						
					}
				}
			}
		});
		cbCategory.setBounds(312, 78, 219, 27);
		getContentPane().add(cbCategory);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setBounds(176, 81, 115, 20);
		getContentPane().add(lblCategory);
		
		JScrollPane scrollPaneOnHold = new JScrollPane(tableOnHold);
		scrollPaneOnHold.setBounds(125, 256, 582, 135);
		getContentPane().add(scrollPaneOnHold);
		
		tableOnHold = new JTable(dtmOnHold);
		tableOnHold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rowOnHold = tableOnHold.getSelectedRow();
				idOnHold = Integer.parseInt(tableOnHold.getModel().getValueAt(rowOnHold, 0).toString());
			}
		});
		scrollPaneOnHold.setViewportView(tableOnHold);
		Object [] columns = {"Id", "Name", "Category", "Size", "Price"};
		dtmOnHold.addColumn(columns[0]);
		dtmOnHold.addColumn(columns[1]);
		dtmOnHold.addColumn(columns[2]);
		dtmOnHold.addColumn(columns[3]);
		dtmOnHold.addColumn(columns[4]);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for ( Meal meal : onHold) {
					if(meal.getIdMeal() == idOnHold) {
						onHold.remove(meal);
						dtmOnHold.removeRow(rowOnHold);
						break;
					}
				}
			}
		});
		btnRemove.setBounds(438, 415, 120, 27);
		getContentPane().add(btnRemove);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.setMeals(onHold);
				TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.POST_R_MEAL);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					loadMyMeals();
					dtmOnHold.setRowCount(0);
					onHold.clear();
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
		btnInsert.setBounds(572, 415, 120, 27);
		getContentPane().add(btnInsert);
		
		JScrollPane scrollPaneMy = new JScrollPane(tableMy);
		scrollPaneMy.setBounds(125, 456, 582, 109);
		getContentPane().add(scrollPaneMy);
		
		tableMy = new JTable(dtmMy);
		tableMy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableMy.getSelectedRow();
				idMy = Integer.parseInt(tableMy.getModel().getValueAt(row, 0).toString());
				
			}
		});
		scrollPaneMy.setViewportView(tableMy);
		Object [] columnsMy = {"ID", "Name", "Size", "Price", "Category"};
		dtmMy.addColumn(columnsMy[0]);
		dtmMy.addColumn(columnsMy[1]);
		dtmMy.addColumn(columnsMy[2]);
		dtmMy.addColumn(columnsMy[3]);
		dtmMy.addColumn(columnsMy[4]);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestMeal restMeal = new RestMeal();
				restMeal.setIdRestMeal(idMy);
				TransferObject request = TransferObject.create(restMeal, ConstantFc.RESTAURANT, ConstantBl.DELETE_R_MEAL);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					loadMyMeals();
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
		btnDelete.setBounds(584, 576, 120, 27);
		getContentPane().add(btnDelete);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmByCat.setRowCount(0);
				Category category = new Category();
				category.setIdCategory(idCategory);
				TransferObject request = TransferObject.create(category, ConstantFc.MEAL, ConstantBl.GET_MEALS_4_CAT);
				TransferObject response;
				try {
					response = FrontController.getInstance().execute(request);
					meals = (Set<Meal>) response.getResponse();
					for (Meal meal : meals) {
						Object [] rowMeal = {meal.getIdMeal(), meal.getName(), meal.getSize(), meal.getPrice()};
						dtmByCat.addRow(rowMeal);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSearch.setBounds(572, 78, 120, 27);
		getContentPane().add(btnSearch);
		
		JScrollPane scrollPaneMealsByC = new JScrollPane(tableMealsByCat);
		scrollPaneMealsByC.setBounds(125, 119, 582, 92);
		getContentPane().add(scrollPaneMealsByC);
		
		tableMealsByCat = new JTable(dtmByCat);
		tableMealsByCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int rowMeal = tableMealsByCat.getSelectedRow();
				idMeal = Integer.parseInt(tableMealsByCat.getModel().getValueAt(rowMeal, 0).toString());
			}
		});
		scrollPaneMealsByC.setViewportView(tableMealsByCat);
		Object [] columnsCa = {"ID", "Name", "Size", "Price"};
		dtmByCat.addColumn(columnsCa[0]);
		dtmByCat.addColumn(columnsCa[1]);
		dtmByCat.addColumn(columnsCa[2]);
		dtmByCat.addColumn(columnsCa[3]);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Meal m : meals) {
					if(m.getIdMeal() == idMeal) {
						Object [] rowObjects = {m.getIdMeal(), m.getName(), m.getCategory().getName(), m.getSize(), m.getPrice()};
						dtmOnHold.addRow(rowObjects);
						onHold.add(m);
					}
				}
			}
		});
		btnAdd.setBounds(572, 222, 120, 27);
		getContentPane().add(btnAdd);
		
		ImageIcon logo = new ImageIcon(r.getPhoto());
		JButton btnNewButton = new JButton(logo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					loadMyMeals();
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
		
		JLabel lblMyMeals = new JLabel("My meals");
		lblMyMeals.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMyMeals.setForeground(Color.WHITE);
		lblMyMeals.setBounds(179, 417, 101, 22);
		contentPane.add(lblMyMeals);
		
		JLabel lblTitle = new JLabel("Meals");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(800, 26, 172, 20);
		contentPane.add(lblTitle);
		
		JButton btnCreateNewMeal = new JButton("Create new Meal");
		btnCreateNewMeal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCreateNewMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MealAddFrame maf = null;
				try {
					maf = new MealAddFrame(u, r);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				maf.setVisible(true);
				
			}
		});
		btnCreateNewMeal.setBounds(750, 78, 150, 27);
		contentPane.add(btnCreateNewMeal);
		
		JButton btnSearchBy = new JButton("Search Meals");
		btnSearchBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtmMy.setRowCount(0);
				String searchBy = tfSearchMeals.getText();
				for (DtoMealRest dtoMealRest : myMeals) {
					if(dtoMealRest.getCategory().getName().contains(searchBy) ||
							dtoMealRest.getName().contains(searchBy)) {
						Object [] rowObject = {dtoMealRest.getIdRestMeal(), dtoMealRest.getName(), 
								dtoMealRest.getSize(), dtoMealRest.getPrice(), dtoMealRest.getCategory().getName()};
						dtmMy.addRow(rowObject);
					}
				}
			}
		});
		btnSearchBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearchBy.setBounds(325, 576, 120, 27);
		contentPane.add(btnSearchBy);
		
		tfSearchMeals = new JTextField();
		tfSearchMeals.setBounds(176, 576, 120, 27);
		contentPane.add(tfSearchMeals);
		tfSearchMeals.setColumns(10);
		
		loadCBCategory();
		loadMyMeals();
		
	}

	protected void loadMyMeals() throws ClassNotFoundException, IOException {
		dtmMy.setRowCount(0);
		
		TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.GET_R_MEAL);
		TransferObject response = FrontController.getInstance().execute(request);
		myMeals = (Set<DtoMealRest>) response.getResponse();
		//r.setCategories(myCat);
		for (DtoMealRest restMeal : myMeals) {
			Object [] row = {restMeal.getIdRestMeal(), restMeal.getName(), restMeal.getSize(), restMeal.getPrice(), restMeal.getCategory().getName()};
			dtmMy.addRow(row);
		}
		
	}

	private void loadCBCategory() throws ClassNotFoundException, IOException {
		TransferObject request = TransferObject.create(r, ConstantFc.CATEGORY, ConstantBl.GET_R_CAT);
		TransferObject response = FrontController.getInstance().execute(request);
		categories = (Set<Category>) response.getResponse();
		for (Category category : categories) {
			cbCategory.addItem(category.getName());
		} 
		
		//cbCategory.setSelectedIndex(0);
		
	}
}
