package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantSave extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Restaurant restaurant = (Restaurant) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.insert(restaurant);
			transferObject.setMessage("A new restaurant was successfully inserted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}
		
	}

	

}
