package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantUpdate extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Restaurant r = (Restaurant) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.update(r);
			transferObject.setMessage("Restaurant with the ID " + r.getIdRestaurant()+ " was successfully updated");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}
		
	}

}
