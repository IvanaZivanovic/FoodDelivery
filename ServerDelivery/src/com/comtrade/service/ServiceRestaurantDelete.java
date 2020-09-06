package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantDelete extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Restaurant r = (Restaurant) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.delete(r);
			transferObject.setMessage("Restaurant with the ID " + r.getIdRestaurant() + " was successfully deleted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}
		

	}

}
