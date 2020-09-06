package com.comtrade.view.user;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.MealOrder;
import com.comtrade.domain.Order;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyOrdersFrame extends JFrame {

	private JPanel contentPane;
	private JTable tableMyOrders;
	private User u;
	private DefaultTableModel dtmMyOrders = new DefaultTableModel();
	private DefaultTableModel dtmDetails = new DefaultTableModel();
	private List<Order> orders = new ArrayList<Order>();
	private JScrollPane scrollPaneDetails;
	private JTable tableDetails;
	private int idOrder;
	private JTextArea textAreaDeliveryTime; 
	
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public MyOrdersFrame(User user) throws ClassNotFoundException, IOException  {
		u = user;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1041, 633);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		MyOrdersFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };
      
      	
      
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*TransferObject request = TransferObject.create(u, ConstantFc.ORDER, ConstantBl.GET_ALL_U);
		TransferObject response = FrontController.getInstance().execute(request);
		map = (Map<Integer, Set<Order>>) response.getResponse();*/
		
		JScrollPane scrollPaneMyOrders = new JScrollPane(tableMyOrders);		
		scrollPaneMyOrders.setBounds(45, 224, 931, 174);
		contentPane.add(scrollPaneMyOrders);
		
		tableMyOrders = new JTable(dtmMyOrders);
		tableMyOrders.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableMyOrders.getSelectedRow();
				idOrder = Integer.parseInt(tableMyOrders.getModel().getValueAt(row, 0).toString());
				setDetails();
				showDeliveryTime();
				
				
				
			}
		});
		scrollPaneMyOrders.setViewportView(tableMyOrders);
		Object [] columns = {"ID", "Date", "Time", "Restaurant", "Amount", "Status"};
		dtmMyOrders.addColumn(columns[0]);
		dtmMyOrders.addColumn(columns[1]);
		dtmMyOrders.addColumn(columns[2]);
		dtmMyOrders.addColumn(columns[3]);
		dtmMyOrders.addColumn(columns[4]);
		dtmMyOrders.addColumn(columns[5]);
		setOrders();
		
		ImageIcon refresh = new ImageIcon("photos/buttons/refresh.jpg");
		JButton btnRefresh = new JButton(refresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dtmDetails.setRowCount(0);
					setOrders();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(767, 426, 65, 64);
		contentPane.add(btnRefresh);
		
		scrollPaneDetails = new JScrollPane(tableDetails);
		scrollPaneDetails.setBounds(45, 426, 553, 144);
		contentPane.add(scrollPaneDetails);
		
		tableDetails = new JTable(dtmDetails);
		scrollPaneDetails.setViewportView(tableDetails);
		
		JScrollPane scrollPaneDeliveryTime = new JScrollPane();
		scrollPaneDeliveryTime.setBounds(643, 528, 261, 42);
		contentPane.add(scrollPaneDeliveryTime);
		
		textAreaDeliveryTime = new JTextArea();
		scrollPaneDeliveryTime.setViewportView(textAreaDeliveryTime);
		Object [] columnsD = {"Meal", "Price", "Quantity"};
		dtmDetails.addColumn(columnsD[0]);
		dtmDetails.addColumn(columnsD[1]);
		dtmDetails.addColumn(columnsD[2]);
		
		
		
		
	}


	protected void showDeliveryTime() {
		
			for(Order or : orders) {
				if(or.getIdOrder() == idOrder) {
					textAreaDeliveryTime.setText(or.getMessage());
					
				}
			}
		}


	protected void setDetails() {
		dtmDetails.setRowCount(0);
		
			for(Order or : orders) {
				if(or.getIdOrder() == idOrder) {
					textAreaDeliveryTime.setText(or.getMessage());
				List<MealOrder> mealOrders = or.getMealOrdersList();
				
					for(MealOrder mo : mealOrders ) {
						Object [] rowDetails = {mo.getMeal().getName(), mo.getMeal().getPrice(), mo.getQuantity()};
						dtmDetails.addRow(rowDetails);
					}
				}
			}
		}
		
	


	private void setOrders() throws ClassNotFoundException, IOException {
		TransferObject request = TransferObject.create(u, ConstantFc.ORDER, ConstantBl.GET_ALL_U);
		TransferObject response = FrontController.getInstance().execute(request);
		orders = (List<Order>) response.getResponse();
		
		dtmMyOrders.setRowCount(0);
		
		
			for(Order or : orders) {
				Object[]row = {or.getIdOrder(), or.getDate(), or.getTime(), or.getRestaurant().getName(), 
						 or.getAmount(), or.getStatus()};
				dtmMyOrders.addRow(row);
				
				/*if(or.getIdOrder() == idOrder) {
				List<MealOrder> mealOrders = or.getMealOrdersList();
					for(MealOrder mo : mealOrders ) {
						Object [] rowDetails = {mo.getMeal().getName(), mo.getAmount(), mo.getMeal().getPrice(), mo.getQuantity()};
						dtmDetails.addRow(rowDetails);
					}
				}*/
			}
		}
}
