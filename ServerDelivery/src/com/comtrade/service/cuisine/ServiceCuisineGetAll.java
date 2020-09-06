package com.comtrade.service.cuisine;

import java.util.List;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Cuisine;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceCuisineGetAll extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		try {
			transferObject.setResponse(broker.selectAll(new Cuisine()));
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}
		
		

	}

}
