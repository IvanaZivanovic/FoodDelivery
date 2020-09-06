package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantGetAll extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		try {
			transferObject.setResponse(broker.selectAllRestaurant(new Restaurant()));
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
