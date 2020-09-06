package com.comtrade.service.meal;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Meal;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceMealDelete extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Meal meal = (Meal) transferObject.getRequest();
		try {
			broker.delete(meal);
			transferObject.setMessage("Meal with the ID "+meal.getIdMeal()+" was successfully deleted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
