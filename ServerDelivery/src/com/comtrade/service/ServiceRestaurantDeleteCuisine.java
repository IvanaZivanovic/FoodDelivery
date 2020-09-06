package com.comtrade.service;

import com.comtrade.broker.Broker;

import com.comtrade.domain.MySqlException;

import com.comtrade.domain.RestCuisine;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantDeleteCuisine extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		RestCuisine restCuisine = (RestCuisine) transferObject.getRequest();
		try {
			broker.delete(restCuisine);
			transferObject.setMessage("Deleted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
