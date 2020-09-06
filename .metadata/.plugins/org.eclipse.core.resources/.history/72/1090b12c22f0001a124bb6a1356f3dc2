package com.comtrade.view.restaurantadmin;


import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.RestCuisine;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class CuisineRestFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableCuisinesOnHold;
	private JTable tableMyCuisines;
	private JComboBox cbCuisinesAvailable;
	private DefaultTableModel dtmCuHold = new DefaultTableModel();
	private DefaultTableModel dtmCuMy = new DefaultTableModel();
	private Set<Cuisine> cuisinesAvailable = new LinkedHashSet<Cuisine>();
	private Set<Cuisine> cuisineOnHold = new LinkedHashSet<Cuisine>();
	private Set<RestCuisine> cuisineMy = new LinkedHashSet<RestCuisine>();
	private Restaurant r;
	private User u;
	private int idCuisineAv;
	private int idCuisineMy;
	private int idCuisineHold;
	private int rowOnHold;
	private int rowMy;

	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public CuisineRestFrame(User user, Restaurant restaurant) throws ClassNotFoundException, IOException {
		r = restaurant;
		u = user;
		//cuisineMy = restaurant.getCuisines();
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setBounds(100, 100, 1014, 655);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		CuisineRestFrame.class.getResource("/images/restaurant-background-3.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCuisinesAvailable = new JLabel("Cuisines available:");
		lblCuisinesAvailable.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCuisinesAvailable.setForeground(Color.WHITE);
		lblCuisinesAvailable.setBounds(219, 103, 150, 30);
		contentPane.add(lblCuisinesAvailable);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Cuisine cu : cuisinesAvailable) {
					if (idCuisineAv==cu.getIdCuisine()) {
						cuisineOnHold.add(cu);
						Object [] row = {cu.getIdCuisine(), cu.getName()};
						dtmCuHold.addRow(row);
						break;
					}
				}
			}
		});
		btnAdd.setBounds(603, 147, 120, 30);
		contentPane.add(btnAdd);
		
		JButton btnInsertCuisines = new JButton("Insert cuisines");
		btnInsertCuisines.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInsertCuisines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.setCuisines(cuisineOnHold);
				TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.POST_R_CU);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					loadMyCuisine();
					dtmCuHold.setRowCount(0);
					cuisineOnHold.clear();
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
		btnInsertCuisines.setBounds(573, 341, 150, 30);
		contentPane.add(btnInsertCuisines);
		
		cbCuisinesAvailable = new JComboBox();
		cbCuisinesAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCuisinesAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Cuisine cu : cuisinesAvailable) {
					if(cu.getName().equals(cbCuisinesAvailable.getSelectedItem().toString())) {
						idCuisineAv = cu.getIdCuisine();
						break;
					}
				}
			}
		});
		cbCuisinesAvailable.setBounds(409, 103, 314, 30);
		contentPane.add(cbCuisinesAvailable);
		
		JScrollPane scrollPaneCuisinesOnHold = new JScrollPane(tableCuisinesOnHold);
		scrollPaneCuisinesOnHold.setBounds(169, 202, 582, 128);
		contentPane.add(scrollPaneCuisinesOnHold);
		
		tableCuisinesOnHold = new JTable(dtmCuHold);
		tableCuisinesOnHold.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rowOnHold = tableCuisinesOnHold.getSelectedRow();
				idCuisineHold = Integer.parseInt(tableCuisinesOnHold.getModel().getValueAt(rowOnHold, 0).toString());
				
			}
		});
		scrollPaneCuisinesOnHold.setViewportView(tableCuisinesOnHold);
		Object [] columnsCuAv = {"ID", "Name"};
		dtmCuHold.addColumn(columnsCuAv[0]);
		dtmCuHold.addColumn(columnsCuAv[1]);
		
		JLabel lblMyCuisines = new JLabel("My Cuisines:");
		lblMyCuisines.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMyCuisines.setForeground(Color.WHITE);
		lblMyCuisines.setBounds(219, 392, 112, 24);
		contentPane.add(lblMyCuisines);
		
		JScrollPane scrollPaneMyCuisine = new JScrollPane(tableMyCuisines);
		scrollPaneMyCuisine.setBounds(169, 427, 582, 132);
		contentPane.add(scrollPaneMyCuisine);
		
		tableMyCuisines = new JTable(dtmCuMy);
		tableMyCuisines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rowMy = tableMyCuisines.getSelectedRow();
				idCuisineMy = Integer.parseInt(tableMyCuisines.getModel().getValueAt(rowMy, 0).toString());
			}
		});
		scrollPaneMyCuisine.setViewportView(tableMyCuisines);
		Object [] columnsCuMy = {"ID", "Name"};
		dtmCuMy.addColumn(columnsCuAv[0]);
		dtmCuMy.addColumn(columnsCuAv[1]);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RestCuisine restCuisine = new RestCuisine();
				restCuisine.setIdRestCuisine(idCuisineMy);
				TransferObject request = TransferObject.create(restCuisine, ConstantFc.RESTAURANT, ConstantBl.DELETE_R_CU);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					dtmCuMy.setRowCount(0);
					loadMyCuisine();
					
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
		btnDelete.setBounds(603, 570, 120, 30);
		contentPane.add(btnDelete);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Cuisine c : cuisineOnHold) {
					if(c.getIdCuisine() == idCuisineHold) {
						cuisineOnHold.remove(c);
						dtmCuHold.removeRow(rowOnHold);
						break;
					}
				}
			}
		});
		btnRemove.setBounds(425, 341, 120, 30);
		contentPane.add(btnRemove);
		
		ImageIcon logo = new ImageIcon(r.getPhoto());
		JButton btnNewButton = new JButton(logo);
		btnNewButton.setBounds(27, 26, 80, 80);
		contentPane.add(btnNewButton);
		
		JLabel lblTitle = new JLabel("Cuisines");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(800, 26, 172, 20);
		contentPane.add(lblTitle);
		
		loadCbCuisineAll();
		loadMyCuisine();
		
	}



	private void loadCbCuisineAll() throws ClassNotFoundException, IOException {
		TransferObject requestCB = TransferObject.create(null, ConstantFc.CUISINE, ConstantBl.GET_ALL);
		TransferObject responseCB = FrontController.getInstance().execute(requestCB);
		cuisinesAvailable = (Set<Cuisine>) responseCB.getResponse();
		
		for (Cuisine c : cuisinesAvailable) {
			cbCuisinesAvailable.addItem(c.getName());
		}
		cbCuisinesAvailable.setSelectedIndex(0);
		
	}

	private void loadMyCuisine() throws ClassNotFoundException, IOException {
			
		dtmCuMy.setRowCount(0);
		TransferObject request = TransferObject.create(r, ConstantFc.RESTAURANT, ConstantBl.GET_R_CU);
		TransferObject response = FrontController.getInstance().execute(request);
		cuisineMy =(Set<RestCuisine>) response.getResponse();
		for (RestCuisine c : cuisineMy) {
			Object [] rowObjects = {c.getIdRestCuisine(), c.getNameCuisine()};
			dtmCuMy.addRow(rowObjects);
			
		}
		
	}
}
