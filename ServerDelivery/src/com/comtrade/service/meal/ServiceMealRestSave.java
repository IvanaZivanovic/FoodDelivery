package com.comtrade.service.meal;


import com.comtrade.broker.Broker;
import com.comtrade.domain.DtoMealRest;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceMealRestSave extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		DtoMealRest dtoMealRest = (DtoMealRest) transferObject.getRequest();
		try {
			broker.insertMeal(dtoMealRest);
			transferObject.setMessage("Meal was successfully added");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}
	

	}

}
