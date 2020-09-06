package com.comtrade.controllerBl;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;
import com.comtrade.service.category.ServiceCategory4Rest;
import com.comtrade.service.category.ServiceCategoryDelete;
import com.comtrade.service.category.ServiceCategoryGetAll;
import com.comtrade.service.category.ServiceCategorySave;
import com.comtrade.service.category.ServiceCategoryUpdate;

public class ControllerBlCategory implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		BaseSystemOperation operation = null;
		if (transferObject.getConstantBl() == ConstantBl.POST) {
			operation = new ServiceCategorySave();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ALL) {
			operation = new ServiceCategoryGetAll();
		} else if (transferObject.getConstantBl() == ConstantBl.PUT) {
			operation = new ServiceCategoryUpdate();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE) {
			operation = new ServiceCategoryDelete();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_R_CAT) {
			operation = new ServiceCategory4Rest();
		}
		
		operation.executeSystemOperation(transferObject);

	}

}
