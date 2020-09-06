package com.comtrade.view.user;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Icon;


public class UserViewRestFrame extends JFrame {

	private JPanel contentPane;
	private Set<Restaurant> restaurants = new LinkedHashSet<Restaurant>();
	private User u;
	private Restaurant r;
	
	private JButton btnTheSaint;
	private JButton btnWalter2;
	private JButton btnZapata;
	private JButton btnSolunac;
	private JButton btnPilePrase;
	private JButton btnNapoli;
	private JButton btnBuritoMadre;
	private JButton btnK2;
	private JButton btnZlatar;
	private JButton btnGrill51;
	private JButton btnHaosFood;
	private JButton btnFerdinand;
	
	private ImageIcon saint, buritoMadre, walter2, solunac, pilePrase, zapata;
	private ImageIcon ferdinand, haosFood, napoli, k2, zlatar, grill51; 
	
	private JLabel lblBuritoMadre, lblTheSaint, lblWalter2, lblPilePrase, lblSolunac;
	private JLabel lblZapata, lblNapoli, lblK2, lblZlatar, lblHaosFood, lblFerdinand, lblGrill51;
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public UserViewRestFrame(User user) throws ClassNotFoundException, IOException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1089, 699);
		contentPane = new JPanel(){  
            public void paintComponent(Graphics g) {  
                Image img = Toolkit.getDefaultToolkit().getImage(  
                		UserViewRestFrame.class.getResource("/images/user-background.png"));  
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
           }  
      };  
      	u = user;
      	TransferObject request = TransferObject.create(null, ConstantFc.RESTAURANT, ConstantBl.GET_ALL);
    	TransferObject response = FrontController.getInstance().execute(request);
    	restaurants = (Set<Restaurant>) response.getResponse();
      	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
								
		JButton btnMoreRestaurants = new JButton("More restaurants");
		btnMoreRestaurants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AllRestaurantsFrame arf = null;
				try {
					arf = new AllRestaurantsFrame(u);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				arf.setVisible(true);
			}
		});
		btnMoreRestaurants.setBounds(763, 615, 176, 23);
		contentPane.add(btnMoreRestaurants);
		
		setPhotos();
		
	}
	private void setPhotos() throws ClassNotFoundException, IOException {
     	for (Restaurant restaurant : restaurants) {
			String photo = restaurant.getPhoto();
			if (restaurant.getName().equalsIgnoreCase("The Saint")) {
				
				lblTheSaint = new JLabel(restaurant.getName());
				lblTheSaint.setBounds(32, 323, 119, 14);
				contentPane.add(lblTheSaint);
				
				saint = new ImageIcon(restaurant.getPhoto());
				btnTheSaint = new JButton(saint);
				btnTheSaint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkTime(restaurant);
					
				}
				});
				btnTheSaint.setBounds(159, 290, 80, 81);
				contentPane.add(btnTheSaint);
			} else if(restaurant.getName().equalsIgnoreCase("Walter 2")) {
				lblWalter2 = new JLabel(restaurant.getName());
				lblWalter2.setBounds(288, 323, 122, 14);
				contentPane.add(lblWalter2);
				
				walter2 = new ImageIcon(restaurant.getPhoto());
				btnWalter2 = new JButton(walter2);
				btnWalter2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					checkTime(restaurant);
				}
				});
				btnWalter2.setBounds(415, 290, 80, 81);
				contentPane.add(btnWalter2);
			} else if (restaurant.getName().equalsIgnoreCase("Napoli")) {
				lblNapoli = new JLabel(restaurant.getName());
				lblNapoli.setBounds(551, 431, 117, 14);
				contentPane.add(lblNapoli);
						
				napoli = new ImageIcon(restaurant.getPhoto());
				btnNapoli = new JButton(napoli);
				btnNapoli.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
				}
				});
				btnNapoli.setBounds(678, 398, 80, 81);
				contentPane.add(btnNapoli);
			} else if(restaurant.getName().equalsIgnoreCase("K2")) {
				lblK2 = new JLabel(restaurant.getName());
				lblK2.setBounds(288, 431, 117, 14);
				contentPane.add(lblK2);
				
				k2 = new ImageIcon(restaurant.getPhoto());
				btnK2 = new JButton(k2);
				btnK2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
				}
				});
				btnK2.setBounds(415, 398, 80, 81);
				contentPane.add(btnK2);
			} else if (restaurant.getName().equalsIgnoreCase("Zapata")) {
				lblZapata = new JLabel(restaurant.getName());
				lblZapata.setBounds(32, 431, 122, 14);
				contentPane.add(lblZapata);
				
				zapata = new ImageIcon(restaurant.getPhoto());
				btnZapata = new JButton(zapata);
				btnZapata.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
				}
				});
				btnZapata.setBounds(159, 398, 80, 81);
				contentPane.add(btnZapata);
			} else if (restaurant.getName().equalsIgnoreCase("Etno Restoran Zlatar")) {
				lblZlatar = new JLabel(restaurant.getName());
				lblZlatar.setBounds(32, 546, 122, 14);
				contentPane.add(lblZlatar);
				
				zlatar = new ImageIcon(restaurant.getPhoto());
				btnZlatar = new JButton(zlatar);
				btnZlatar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
					}
					});
				btnZlatar.setBounds(159, 513, 80, 81);
				contentPane.add(btnZlatar);
			} else if (restaurant.getName().equalsIgnoreCase("Pile&Prase")) {
				lblPilePrase = new JLabel(restaurant.getName());
				lblPilePrase.setBounds(807, 431, 117, 14);
				contentPane.add(lblPilePrase);
				
				pilePrase = new ImageIcon(restaurant.getPhoto());
				btnPilePrase = new JButton(pilePrase);
				btnPilePrase.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
				}
				});
				btnPilePrase.setBounds(934, 398, 80, 81);
				contentPane.add(btnPilePrase);
			} else if (restaurant.getName().equalsIgnoreCase("Solunac Terazije")) {
				lblSolunac = new JLabel(restaurant.getName());
				lblSolunac.setBounds(807, 546, 117, 14);
				contentPane.add(lblSolunac);
				
				solunac = new ImageIcon(restaurant.getPhoto());
				btnSolunac = new JButton(solunac);
				btnSolunac.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
				}
				});
				btnSolunac.setBounds(934, 513, 80, 81);
				contentPane.add(btnSolunac);
			} else if (restaurant.getName().equalsIgnoreCase("Burito Madre")) {
				lblBuritoMadre = new JLabel(restaurant.getName());
				lblBuritoMadre.setBounds(551, 546, 119, 14);
				contentPane.add(lblBuritoMadre);
				
				buritoMadre = new ImageIcon(restaurant.getPhoto());
				btnBuritoMadre = new JButton(buritoMadre);
				btnBuritoMadre.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
						OrderCartFrame orderCartFrame = null;
						try {
							orderCartFrame = new OrderCartFrame(u, restaurant);
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						orderCartFrame.setVisible(true);
					}
				});
				btnBuritoMadre.setBounds(678, 513, 80, 81);
				contentPane.add(btnBuritoMadre);
			} else if(restaurant.getName().equalsIgnoreCase("Haos Food")) {
				lblHaosFood = new JLabel(restaurant.getName());
				lblHaosFood.setBounds(288, 546, 117, 14);
				contentPane.add(lblHaosFood);
				
				haosFood = new ImageIcon(restaurant.getPhoto());
				btnHaosFood = new JButton(haosFood);
				btnHaosFood.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
					}
				});
				btnHaosFood.setBounds(415, 513, 80, 81);
				contentPane.add(btnHaosFood);
			} else if (restaurant.getName().equalsIgnoreCase("Grill 51")) {
				lblGrill51 = new JLabel(restaurant.getName());
				lblGrill51.setBounds(807, 323, 117, 14);
				contentPane.add(lblGrill51);
				
				grill51 = new ImageIcon(restaurant.getPhoto());
				btnGrill51 = new JButton(grill51);
				btnGrill51.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
					}
				});
				btnGrill51.setBounds(934, 290, 80, 81);
				contentPane.add(btnGrill51);
			} else if (restaurant.getName().equalsIgnoreCase("Ferdinand Knedle")) {
				lblFerdinand = new JLabel(restaurant.getName());
				lblFerdinand.setBounds(551, 323, 119, 14);
				contentPane.add(lblFerdinand);
				
				ferdinand = new ImageIcon(restaurant.getPhoto());
				btnFerdinand = new JButton(ferdinand);
				btnFerdinand.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						checkTime(restaurant);
					}
				});
				btnFerdinand.setBounds(678, 290, 80, 81);
				contentPane.add(btnFerdinand);
			}
      		
		}
		
	}
	protected void checkTime(Restaurant restaurant) {
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm");
		String timeNow = sdfTime.format(new Date()).toString();
	    String [] time = timeNow.split(":");
	    int hour = Integer.parseInt(time[0]);
	    int min = Integer.parseInt(time[1]);
	    LocalTime lTime = LocalTime.of(hour, min);
	    LocalTime rOpen = restaurant.getOpenTime();
	    LocalTime rclose = restaurant.getCloseTime();
	    //if (lTime.isAfter(rOpen) && lTime.isBefore(lTime)) {
	    
			OrderCartFrame orderCartFrame = null;
			try {
				orderCartFrame = new OrderCartFrame(u, restaurant);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			orderCartFrame.setVisible(true);
		} 
	//else JOptionPane.showMessageDialog(null, "Sorry, this restaurant is currently closed");
	}
	
		
	

