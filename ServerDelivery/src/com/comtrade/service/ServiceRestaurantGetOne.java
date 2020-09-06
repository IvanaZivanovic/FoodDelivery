package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantGetOne extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Restaurant restaurant = (Restaurant) transferObject.getRequest();
		try {
			transferObject.setResponse(broker.selectOneRestaurant(restaurant));
			Restaurant restaurant2 = (Restaurant) transferObject.getResponse();
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
