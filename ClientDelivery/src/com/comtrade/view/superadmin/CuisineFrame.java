package com.comtrade.view.superadmin;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class CuisineFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private int idCuisine;

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public CuisineFrame() throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		CuisineFrame.class.getResource("/images/super-admin-background.JPG"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(418, 230, 90, 20);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfName.setBounds(499, 227, 175, 27);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				Cuisine cuisine = new Cuisine();
				cuisine.setName(name);
				TransferObject request = TransferObject.create(cuisine, ConstantFc.CUISINE, ConstantBl.POST);
				
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
		btnSave.setBounds(259, 319, 100, 27);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cuisine cuisine = new Cuisine();
				cuisine.setName(tfName.getText());
				cuisine.setIdCuisine(idCuisine);
				TransferObject request = TransferObject.create(cuisine, ConstantFc.CUISINE, ConstantBl.PUT);
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
		btnUpdate.setBounds(400, 319, 100, 27);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cuisine cuisine = new Cuisine();
				cuisine.setIdCuisine(idCuisine);
				TransferObject request = TransferObject.create(cuisine, ConstantFc.CUISINE, ConstantBl.DELETE);
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
		btnDelete.setBounds(836, 319, 100, 27);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(182, 378, 791, 175);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				idCuisine = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				tfName.setText(table.getModel().getValueAt(row, 1).toString());
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblTitle = new JLabel("Cuisines");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(820, 26, 172, 20);
		contentPane.add(lblTitle);
		Object [] columns = {"ID", "Name"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		setDataInTable();
	}



	private void setDataInTable() {
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(null, ConstantFc.CUISINE, ConstantBl.GET_ALL);
		try {
			TransferObject response = FrontController.getInstance().execute(request);
			Set<Cuisine> cuisines = (Set<Cuisine>) response.getResponse();
			for (Cuisine c : cuisines) {
				Object [] rowCuisine = {c.getIdCuisine(), c.getName()};
				dtm.addRow(rowCuisine);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	protected void clearTxtFields() {
		tfName.setText("");
		
	}
	
}
