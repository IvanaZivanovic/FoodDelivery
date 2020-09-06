package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantInsertCat extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		Restaurant r = (Restaurant) transferObject.getRequest();
		try {
			broker.insertRestCat(r);
			transferObject.setMessage("Categories were successfully added");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}
		

	}

}
