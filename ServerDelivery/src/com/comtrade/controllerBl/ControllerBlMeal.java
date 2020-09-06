package com.comtrade.controllerBl;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;
import com.comtrade.service.meal.ServiceMeal4Cat;
import com.comtrade.service.meal.ServiceMealDelete;
import com.comtrade.service.meal.ServiceMealFromRest;
import com.comtrade.service.meal.ServiceMealGetAll;
import com.comtrade.service.meal.ServiceMealRestSave;
import com.comtrade.service.meal.ServiceMealSave;
import com.comtrade.service.meal.ServiceMealUpdate;

public class ControllerBlMeal implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		BaseSystemOperation operation = null;
		if (transferObject.getConstantBl() == ConstantBl.POST) {
			operation = new ServiceMealSave();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ALL) {
			operation = new ServiceMealGetAll();
		} else if (transferObject.getConstantBl() == ConstantBl.PUT) {
			operation = new ServiceMealUpdate();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE) {
			operation = new ServiceMealDelete();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_MEALS_4_CAT) {
			operation = new ServiceMeal4Cat();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_R_MEAL) {
			operation = new ServiceMealFromRest();
		} else if (transferObject.getConstantBl() == ConstantBl.POST_R_MEAL) {
			operation = new ServiceMealRestSave();
		}
		operation.executeSystemOperation(transferObject);
	}

}
