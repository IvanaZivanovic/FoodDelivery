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

import com.comtrade.domain.Category;
import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.RestCat;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;
import com.comtrade.view.superadmin.CategoryFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class CategoryRestFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableOnHold;
	private JTable tableMyCat;
	private Set<Category> allCat = new LinkedHashSet<Category>();
	private Set<Category> onHold = new LinkedHashSet<Category>();
	private Set<RestCat> myCat = new LinkedHashSet<RestCat>();
	private int idAll;
	private int idHold;
	private int idMy;
	private int rowHold;
	private String nameAll;
	private Restaurant r;
	private User u;
	private JComboBox cBCatAvailable;
	private DefaultTableModel dtmHold = new DefaultTableModel();
	private DefaultTableModel dtmMy = new DefaultTableModel();
	

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public CategoryRestFrame(User user, Restaurant restaurant) throws ClassNotFoundException, IOException {
		r=restaurant;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		CategoryRestFrame.class.getResource("/images/restaurant-background-3.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoriesAvailable = new JLabel("Categories:");
		lblCategoriesAvailable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoriesAvailable.setForeground(Color.WHITE);
		lblCategoriesAvailable.setBounds(273, 85, 120, 30);
		contentPane.add(lblCategoriesAvailable);
		
		cBCatAvailable = new JComboBox();
		cBCatAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cBCatAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Category category : allCat) {
					if(category.getName().equals(cBCatAvailable.getSelectedItem().toString())) {
						idAll = category.getIdCategory();
						nameAll = cBCatAvailable.getSelectedItem().toString();
					}
				}
			}
		});
		cBCatAvailable.setBounds(384, 87, 235, 30);
		contentPane.add(cBCatAvailable);
		
		
			
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Category cat : allCat) {
					if (idAll==cat.getIdCategory()) {
						onHold.add(cat);
						Object [] row = {cat.getIdCategory(), cat.getName()};
						dtmHold.addRow(row);
						break;
					}
				}
				
			}
		});
		btnAdd.setBounds(657, 87, 120, 30);
		contentPane.add(btnAdd);
		
		JScrollPane scrollPaneOnHold = new JScrollPane(tableOnHold);
		scrollPaneOnHold.setBounds(146, 151, 664, 168);
		contentPane.add(scrollPaneOnHold);
		
		tableOnHold = new JTable(dtmHold);
		tableOnHold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rowHold = tableOnHold.getSelectedRow();
				idHold = Integer.parseInt(tableOnHold.getModel().getValueAt(rowHold, 0).toString());
				
			}
		});
		scrollPaneOnHold.setViewportView(tableOnHold);
		Object [] columnseObjects = {"Id", "Name"};
		dtmHold.addColumn(columnseObjects[0]);
		dtmHold.addColumn(columnseObjects[1]);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				r.setCategories(onHold);
				TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.POST_R_CA);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					loadMyCat();
					dtmHold.setRowCount(0);
					onHold.clear();
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
		btnInsert.setBounds(657, 358, 120, 30);
		contentPane.add(btnInsert);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Category c : onHold) {
					if(c.getIdCategory()==idHold)
						onHold.remove(c);
						dtmHold.removeRow(rowHold);
					break;
					
				}
				
			}
		});
		btnRemove.setBounds(469, 358, 120, 30);
		contentPane.add(btnRemove);
		
		JScrollPane scrollPaneMyCat = new JScrollPane(tableMyCat);
		scrollPaneMyCat.setBounds(146, 406, 664, 150);
		contentPane.add(scrollPaneMyCat);
		
		tableMyCat = new JTable(dtmMy);
		tableMyCat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = tableMyCat.getSelectedRow();
				idMy = Integer.parseInt(tableMyCat.getModel().getValueAt(row, 0).toString());
			}
		});
		scrollPaneMyCat.setViewportView(tableMyCat);
		Object[]columns = {"Id", "Name"};
		dtmMy.addColumn(columns[0]);
		dtmMy.addColumn(columns[1]);
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RestCat restCat = new RestCat();
				restCat.setIdRestCat(idMy);
				TransferObject request = TransferObject.create(restCat, ConstantFc.RESTAURANT, ConstantBl.DELETE_R_CA);
				try {
					TransferObject respone = FrontController.getInstance().execute(request);
					dtmMy.setRowCount(0);
					loadMyCat();
					JOptionPane.showMessageDialog(null, respone.getMessage());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(657, 570, 120, 30);
		contentPane.add(btnDelete);
		
		ImageIcon logo = new ImageIcon(r.getPhoto());
		JButton btnNewButton = new JButton(logo);
		btnNewButton.setBounds(27, 26, 80, 80);
		contentPane.add(btnNewButton);
		
		JLabel lblTitle = new JLabel("Categories");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(800, 26, 172, 24);
		contentPane.add(lblTitle);
		
		JLabel lblMyCategories = new JLabel("My Categories");
		lblMyCategories.setForeground(Color.WHITE);
		lblMyCategories.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMyCategories.setBounds(191, 365, 190, 30);
		contentPane.add(lblMyCategories);
		
		loadMyCat();
		loadCbAllCat();
	}



	private void loadMyCat() throws ClassNotFoundException, IOException {
		dtmMy.setRowCount(0);
				
		TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.GET_R_CAT);
		TransferObject response = FrontController.getInstance().execute(request);
		myCat = (Set<RestCat>) response.getResponse();
		//r.setCategories(myCat);
		for (RestCat restCat : myCat) {
			Object [] row = {restCat.getIdRestCat(), restCat.getNameCategory()};
			dtmMy.addRow(row);
		}
		
	}


	private void loadCbAllCat() throws ClassNotFoundException, IOException {
		TransferObject requestAll = TransferObject.create(null, ConstantFc.CATEGORY, ConstantBl.GET_ALL);
		TransferObject responseAll = FrontController.getInstance().execute(requestAll);
		allCat = (Set<Category>) responseAll.getResponse();
		
		for (Category category : allCat) {
			cBCatAvailable.addItem(category.getName());
			
		}
		
	}
}
