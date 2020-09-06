package com.comtrade.service;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.RestCat;
import com.comtrade.domain.TransferObject;

public class ServiceRestaurantDeleteCat extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		RestCat restCat = (RestCat) transferObject.getRequest();
		try {
			broker.delete(restCat);
			transferObject.setMessage("Successfully deleted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
