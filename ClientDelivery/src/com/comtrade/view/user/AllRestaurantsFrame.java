package com.comtrade.view.user;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class AllRestaurantsFrame extends JFrame {

	private JPanel contentPane;
	private Map<String, Set<Cuisine>>map = new HashMap<>();
	private User u;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private String restName;
	private JComboBox cbCuisine;
	private Set<Cuisine> cuisines = new LinkedHashSet<Cuisine>();
	private int idCuisine;
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public AllRestaurantsFrame(User user) throws ClassNotFoundException, IOException {
		u = user;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 969, 582);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		UserViewRestFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				restName = table.getModel().getValueAt(row, 0).toString();
			}
		});
		scrollPane.setBounds(28, 317, 730, 173);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				restName = table.getModel().getValueAt(row, 0).toString();
			}
		});
		scrollPane.setViewportView(table);
		Object [] columns = {"Restaurant", "Cuisines"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		
		JButton btnGo2Restaurant = new JButton("Go2 Restaurant");
		btnGo2Restaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					OrderCartFromAllFrame orderCartFromAllFrame = new OrderCartFromAllFrame(u, restName);
					orderCartFromAllFrame.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGo2Restaurant.setBounds(782, 422, 143, 23);
		contentPane.add(btnGo2Restaurant);
		
		JLabel lblChooseCuisine = new JLabel("Choose Cuisine:");
		lblChooseCuisine.setBounds(129, 254, 143, 14);
		contentPane.add(lblChooseCuisine);
		
		cbCuisine = new JComboBox();
		cbCuisine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Cuisine cu : cuisines) {
					if(cu.getName().equals(cbCuisine.getSelectedItem())) {
						idCuisine = cu.getIdCuisine();
					}
				}
			}
		});
		cbCuisine.setBounds(300, 251, 250, 20);
		contentPane.add(cbCuisine);
		TransferObject reqCuisine = TransferObject.create(null, ConstantFc.CUISINE, ConstantBl.GET_ALL);
		TransferObject responseCu = FrontController.getInstance().execute(reqCuisine);
		cuisines = (Set<Cuisine>) responseCu.getResponse();
		for (Cuisine cu : cuisines) {
			cbCuisine.addItem(cu.getName());
			
		}
		
		JButton btnShowRest = new JButton("Show Restaurants");
		btnShowRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				for (Map.Entry<String, Set<Cuisine>> me : map.entrySet()) {
		            Set<Cuisine> cuisines = me.getValue();
		            for (Cuisine cu : cuisines) {
		            	if(cu.getName().equals(cbCuisine.getSelectedItem().toString())) {
		            	Object [] row = {me.getKey(), cu.getName()};
		            	dtm.addRow(row);
		            }
		                
		        }
					}
			}
		});
		btnShowRest.setBounds(618, 250, 140, 23);
		contentPane.add(btnShowRest);
		TransferObject requestRest = TransferObject.create(null, ConstantFc.RESTAURANT, ConstantBl.GET_ALL_R);
		TransferObject response = FrontController.getInstance().execute(requestRest);
		map = (Map<String, Set<Cuisine>>) response.getResponse();
		
			
	}
}