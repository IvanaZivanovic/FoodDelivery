package com.comtrade.service.meal;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Category;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceMeal4Cat extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Category category = (Category) transferObject.getRequest();
		try {
			transferObject.setResponse(broker.selectMeals4Cat(category));
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
