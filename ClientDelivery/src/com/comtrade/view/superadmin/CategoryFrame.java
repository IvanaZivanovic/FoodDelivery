package com.comtrade.view.superadmin;

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
import com.comtrade.domain.TransferObject;
import com.comtrade.frontcontroller.FrontController;
import com.comtrade.view.restaurantadmin.AboutRestaurantFrame;
import com.comtrade.view.restaurantadmin.CategoryRestFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class CategoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private DefaultTableModel dtm = new DefaultTableModel();
	private int idCategory;
	private JTable table;

	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public CategoryFrame() throws ClassNotFoundException, IOException {
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
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(438, 208, 100, 20);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(527, 207, 159, 27);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				Category c = new Category(name);
				TransferObject request = TransferObject.create(c, ConstantFc.CATEGORY, ConstantBl.POST);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String message = response.getMessage();
					setDataInTable();
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
		btnSave.setBounds(270, 308, 100, 27);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nameString = tfName.getText();
				Category c = new Category(nameString);
				c.setIdCategory(idCategory);
				TransferObject request = TransferObject.create(c, ConstantFc.CATEGORY, ConstantBl.PUT);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String message = response.getMessage();
					clearTxtFields();
					setDataInTable();
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
		btnUpdate.setBounds(423, 308, 100, 27);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Category c = new Category();
				c.setIdCategory(idCategory);
				TransferObject request = TransferObject.create(c, ConstantFc.CATEGORY, ConstantBl.DELETE);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					String message = response.getMessage();
					clearTxtFields();
					setDataInTable();
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
		btnDelete.setBounds(782, 308, 100, 27);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(189, 357, 784, 203);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				idCategory = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				tfName.setText(table.getModel().getValueAt(row, 1).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblTitle = new JLabel("Categories");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(820, 26, 172, 20);
		contentPane.add(lblTitle);
		Object [] columns = {"ID", "Name"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		setDataInTable();
	}

	protected void clearTxtFields() {
		tfName.setText("");
		
	}

	private void setDataInTable() throws ClassNotFoundException, IOException {
		dtm.setRowCount(0);
		TransferObject request = TransferObject.create(null, ConstantFc.CATEGORY, ConstantBl.GET_ALL);
		TransferObject response = FrontController.getInstance().execute(request);
		Set<Category> categories = (Set<Category>) response.getResponse();
		for (Category c : categories) {
			Object []row = {c.getIdCategory(), c.getName()};
			dtm.addRow(row);
			
		}
		
	}
}
