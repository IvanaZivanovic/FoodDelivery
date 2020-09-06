package com.comtrade.service.cuisine;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceCuisineSave extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Cuisine cuisine = (Cuisine) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.insert(cuisine);
			transferObject.setMessage("A new cuisine was successfully inserted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
