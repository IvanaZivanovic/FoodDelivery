package com.comtrade.controllerBl;

import com.comtrade.controllerBl.CommandBase;
import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;
import com.comtrade.service.ServiceRestGetByName;
import com.comtrade.service.ServiceRestaurantCat;
import com.comtrade.service.ServiceRestaurantCuisine;
import com.comtrade.service.ServiceRestaurantDelete;
import com.comtrade.service.ServiceRestaurantDeleteCat;
import com.comtrade.service.ServiceRestaurantDeleteCuisine;
import com.comtrade.service.ServiceRestaurantDeleteMeal;
import com.comtrade.service.ServiceRestaurantGetAll;
import com.comtrade.service.ServiceRestaurantGetOne;
import com.comtrade.service.ServiceRestaurantInsertCat;
import com.comtrade.service.ServiceRestaurantInsertCuisines;
import com.comtrade.service.ServiceRestaurantInsertMeal;
import com.comtrade.service.ServiceRestaurantMeal;
import com.comtrade.service.ServiceRestaurantSave;
import com.comtrade.service.ServiceRestaurantUpdate;
import com.comtrade.service.ServiceSelectAllRestCu;

public class ControllerBlRestaurant implements CommandBase{

	@Override
	public void execute(TransferObject transferObject) {
		BaseSystemOperation operation = null;
		if(transferObject.getConstantBl() == ConstantBl.POST) {
			operation = new ServiceRestaurantSave();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ALL) {
			operation = new ServiceRestaurantGetAll();
		} else if (transferObject.getConstantBl() == ConstantBl.PUT) {
			operation = new ServiceRestaurantUpdate();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE) {
			operation = new ServiceRestaurantDelete();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ONE) {
			operation = new ServiceRestaurantGetOne();
		} else if (transferObject.getConstantBl() == ConstantBl.POST_R_CU) {
			operation = new ServiceRestaurantInsertCuisines();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE_R_CU) {
			operation = new ServiceRestaurantDeleteCuisine();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_R_CAT) {
			operation = new ServiceRestaurantCat();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_R_CU) {
			operation = new ServiceRestaurantCuisine();
		} else if(transferObject.getConstantBl() == ConstantBl.POST_R_CA) {
			operation = new ServiceRestaurantInsertCat();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE_R_CA) {
			operation = new ServiceRestaurantDeleteCat();
		} else if(transferObject.getConstantBl() == ConstantBl.POST_R_MEAL) {
			operation = new ServiceRestaurantInsertMeal();
		} else if(transferObject.getConstantBl() == ConstantBl.GET_R_MEAL) {
			operation = new ServiceRestaurantMeal();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE_R_MEAL) {
			operation = new ServiceRestaurantDeleteMeal();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ALL_R) {
			operation = new ServiceSelectAllRestCu();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ONE_R_NAME) {
			operation = new ServiceRestGetByName();
		}
		operation.executeSystemOperation(transferObject);
	}

}
