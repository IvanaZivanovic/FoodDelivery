package com.comtrade.service.cuisine;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceCuisineDelete extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Cuisine cuisine = (Cuisine) transferObject.getRequest();
		try {
			broker.delete(cuisine);
			transferObject.setMessage("Cuisine with the ID "+ cuisine.getIdCuisine() + " was successfully deleted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
