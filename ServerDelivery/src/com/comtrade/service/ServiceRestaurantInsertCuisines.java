package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantInsertCuisines extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Restaurant rest = (Restaurant) transferObject.getRequest();
		try {
			broker.insertRestCuisine(rest);
			transferObject.setMessage("Cuisines were successfully added to restaurant "+rest.getName());
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
