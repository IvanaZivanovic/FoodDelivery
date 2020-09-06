package com.comtrade.service.order;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Restaurant;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceOrderSelect4Rest extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Restaurant restaurant = (Restaurant) transferObject.getRequest();
		try {
			transferObject.setResponse(broker.getOrders4Rest(restaurant));
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
