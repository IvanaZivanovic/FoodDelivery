package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.RestMeal;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantDeleteMeal extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		RestMeal restMeal = (RestMeal) transferObject.getRequest();
		try {
			broker.delete(restMeal);
			transferObject.setMessage("Successfully deleted meal(s)");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
