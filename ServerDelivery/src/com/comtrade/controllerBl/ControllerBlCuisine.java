package com.comtrade.controllerBl;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;
import com.comtrade.service.cuisine.ServiceCuisineDelete;
import com.comtrade.service.cuisine.ServiceCuisineGetAll;
import com.comtrade.service.cuisine.ServiceCuisineSave;
import com.comtrade.service.cuisine.ServiceCuisineUpdate;

public class ControllerBlCuisine implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		BaseSystemOperation operation = null;
		if (transferObject.getConstantBl() == ConstantBl.POST) {
			operation = new ServiceCuisineSave();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ALL) {
			operation = new ServiceCuisineGetAll();
		} else if (transferObject.getConstantBl() == ConstantBl.PUT) {
			operation = new ServiceCuisineUpdate();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE) {
			operation = new ServiceCuisineDelete();
		} 
		operation.executeSystemOperation(transferObject);

	}

}
