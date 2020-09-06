package com.comtrade.view.user;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.Address;
import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AddressFrame extends JFrame {

	private JPanel contentPane;
	private User u;
	private JTextField tfCity;
	private JTextField tfZipCOde;
	private JTextField tfMunicipality;
	private JTextField tfStreetName;
	private JTextField tfStreetNo;
	private JTextField tfAppNo;
	private JTextField tfAppLastName;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private Set<Address> addresses = new LinkedHashSet<Address>();
	private int idAddress;
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public AddressFrame(User user) throws ClassNotFoundException, IOException {
		u = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 627);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		AddressFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.BLACK);
		lblCity.setBounds(213, 202, 130, 14);
		contentPane.add(lblCity);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setForeground(Color.BLACK);
		lblZipCode.setBounds(385, 262, 114, 14);
		contentPane.add(lblZipCode);
		
		JLabel lblMunicipality = new JLabel("Municipality");
		lblMunicipality.setForeground(Color.BLACK);
		lblMunicipality.setBounds(29, 265, 113, 14);
		contentPane.add(lblMunicipality);
		
		JLabel lblStreetName = new JLabel("Street Name");
		lblStreetName.setForeground(Color.BLACK);
		lblStreetName.setBounds(29, 315, 114, 14);
		contentPane.add(lblStreetName);
		
		JLabel lblStreetNo = new JLabel("Street Number");
		lblStreetNo.setForeground(Color.BLACK);
		lblStreetNo.setBounds(385, 312, 113, 14);
		contentPane.add(lblStreetNo);
		
		JLabel lblApNumber = new JLabel("Apartment Number");
		lblApNumber.setForeground(Color.BLACK);
		lblApNumber.setBounds(385, 363, 114, 14);
		contentPane.add(lblApNumber);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setBounds(29, 363, 113, 14);
		contentPane.add(lblLastName);
		
		tfCity = new JTextField();
		tfCity.setBounds(365, 199, 150, 20);
		contentPane.add(tfCity);
		tfCity.setColumns(10);
		
		tfZipCOde = new JTextField();
		tfZipCOde.setBounds(509, 259, 236, 20);
		contentPane.add(tfZipCOde);
		tfZipCOde.setColumns(10);
		
		tfMunicipality = new JTextField();
		tfMunicipality.setBounds(171, 262, 175, 20);
		contentPane.add(tfMunicipality);
		tfMunicipality.setColumns(10);
		
		tfStreetName = new JTextField();
		tfStreetName.setBounds(171, 312, 172, 20);
		contentPane.add(tfStreetName);
		tfStreetName.setColumns(10);
		
		tfStreetNo = new JTextField();
		tfStreetNo.setBounds(508, 309, 237, 20);
		contentPane.add(tfStreetNo);
		tfStreetNo.setColumns(10);
		
		tfAppNo = new JTextField();
		tfAppNo.setBounds(509, 360, 236, 20);
		contentPane.add(tfAppNo);
		tfAppNo.setColumns(10);
		
		tfAppLastName = new JTextField();
		tfAppLastName.setBounds(171, 360, 175, 20);
		contentPane.add(tfAppLastName);
		tfAppLastName.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address address = new Address();
				address.setUser(u);
				address.setAppLastName(tfAppLastName.getText());
				address.setAppNumber(tfAppNo.getText());
				address.setCity(tfCity.getText());
				address.setMunicipality(tfMunicipality.getText());
				address.setZipCode(tfZipCOde.getText());
				address.setStreetName(tfStreetName.getText());
				address.setStreetNo(tfStreetNo.getText());
				
				TransferObject request = TransferObject.create(address, ConstantFc.ADDRESS, ConstantBl.POST);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					loadTableData();
					JOptionPane.showMessageDialog(null, response.getMessage());
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
		btnSave.setBounds(171, 416, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Address address = new Address();
				address.setUser(u);
				address.setIdAddress(idAddress);
				address.setAppLastName(tfAppLastName.getText());
				address.setAppNumber(tfAppNo.getText());
				address.setCity(tfCity.getText());
				address.setMunicipality(tfMunicipality.getText());
				address.setZipCode(tfZipCOde.getText());
				address.setStreetName(tfStreetName.getText());
				address.setStreetNo(tfStreetNo.getText());
				
				TransferObject request = TransferObject.create(address, ConstantFc.ADDRESS, ConstantBl.PUT);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					loadTableData();
					JOptionPane.showMessageDialog(null, response.getMessage());
					clearTxtFields();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(306, 416, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Address address = new Address();
				address.setIdAddress(idAddress);
				TransferObject request = TransferObject.create(address, ConstantFc.ADDRESS, ConstantBl.DELETE);
				try {
					TransferObject response = FrontController.getInstance().execute(request);
					loadTableData();
					JOptionPane.showMessageDialog(null, response.getMessage());
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
		btnDelete.setBounds(452, 416, 89, 23);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(29, 474, 767, 101);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				idAddress = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				tfCity.setText(table.getModel().getValueAt(row, 1).toString());
				tfZipCOde.setText(table.getModel().getValueAt(row, 2).toString());
				tfMunicipality.setText(table.getModel().getValueAt(row, 3).toString());
				tfStreetName.setText(table.getModel().getValueAt(row, 4).toString());
				tfStreetNo.setText(table.getModel().getValueAt(row, 5).toString());
				tfAppNo.setText(table.getModel().getValueAt(row, 6).toString());
				tfAppLastName.setText(table.getModel().getValueAt(row, 7).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnGot2Rest = new JButton("Go2 Restaurants");
		btnGot2Rest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserViewRestFrame uvrf = null;
				try {
					uvrf = new UserViewRestFrame(u);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				uvrf.setVisible(true);
			}
		});
		btnGot2Rest.setBounds(598, 416, 147, 23);
		contentPane.add(btnGot2Rest);
		Object [] columns = {"Id", "City", "ZipCode", "Municipality", "Street", "Number", "AppNo", "Last name"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		dtm.addColumn(columns[5]);
		dtm.addColumn(columns[6]);
		dtm.addColumn(columns[7]);
				
		loadTableData();
	}

	protected void clearTxtFields() {
		tfAppLastName.setText("");
		tfAppNo.setText("");
		tfCity.setText("");
		tfMunicipality.setText("");
		tfStreetName.setText("");
		tfStreetNo.setText("");
		tfZipCOde.setText("");
		
	}

	protected void loadTableData() throws ClassNotFoundException, IOException {
		dtm.setRowCount(0);
		//Address address = new Address();
		//address.setUser(u);
		TransferObject request = TransferObject.create(u, ConstantFc.ADDRESS, ConstantBl.GET_ALL_U);
		TransferObject response = FrontController.getInstance().execute(request);
		addresses = (Set<Address>) response.getResponse();
		if(addresses != null) {
			for (Address a : addresses) {
				Object [] rowObjects = {a.getIdAddress(), a.getCity(), a.getZipCode(), a.getMunicipality(), a.getStreetName(), 
						a.getStreetNo(), a.getAppNumber(), a.getAppLastName()};
				dtm.addRow(rowObjects);
			
		}
		
		}
		
	}
}
