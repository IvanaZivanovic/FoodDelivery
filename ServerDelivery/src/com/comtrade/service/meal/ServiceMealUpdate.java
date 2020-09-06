package com.comtrade.service.meal;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Meal;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceMealUpdate extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Meal meal = (Meal) transferObject.getRequest();
		try {
			broker.update(meal);
			transferObject.setMessage("The meal with the ID "+meal.getIdMeal()+" was successfully updated");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
