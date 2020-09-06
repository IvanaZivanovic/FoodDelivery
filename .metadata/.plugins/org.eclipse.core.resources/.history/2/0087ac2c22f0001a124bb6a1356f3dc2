package com.comtrade.proxy;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.ConstantFc;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.frontcontroller.FrontController;
import com.comtrade.view.restaurantadmin.MidAdminFrame;
import com.comtrade.view.superadmin.MidFrame;
import com.comtrade.view.user.UserHomeFrame;


public class ProxyLogin implements Proxy{

	@Override
	public void login(User user) {
		if(user.getStatus()!=0) {
			JOptionPane.showMessageDialog(null, "User does not exist");
		} else if (user.getStatus()==0 && user.getIdRole()==1) {
			MidFrame midFrame = new MidFrame();
			midFrame.setVisible(true);
			
		} else if (user.getStatus()==0 && user.getIdRole()==2) {
			Restaurant restaurant = new Restaurant();
			restaurant.setUser(user);
			TransferObject request = TransferObject.create(restaurant, ConstantFc.RESTAURANT, ConstantBl.GET_ONE);
			try {
				TransferObject response = FrontController.getInstance().execute(request);
				Restaurant restaurant2 = (Restaurant) response.getResponse();
				MidAdminFrame adminFrame = new MidAdminFrame(user, restaurant2);
				adminFrame.setVisible(true);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (user.getStatus()==0 && user.getIdRole()==3) {
			
			UserHomeFrame userHomeFrame = null;
			try {
				userHomeFrame = new UserHomeFrame(user);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userHomeFrame.setVisible(true);
			} else {JOptionPane.showMessageDialog(null, "Sorry, we can't find a user with this username and password. Please try again");}
		}
		
			
		}
		
	
	


