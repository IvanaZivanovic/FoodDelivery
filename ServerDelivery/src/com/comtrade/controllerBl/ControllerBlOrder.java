package com.comtrade.controllerBl;

import com.comtrade.domain.BaseDomain;
import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;
import com.comtrade.service.order.ServiceOrderEdit;
import com.comtrade.service.order.ServiceOrderSave;
import com.comtrade.service.order.ServiceOrderSelect4Rest;
import com.comtrade.service.order.ServiceOrderSelect4User;

public class ControllerBlOrder implements CommandBase{

	@Override
	public void execute(TransferObject transferObject) {
		BaseSystemOperation operation = null;
		if(transferObject.getConstantBl() == ConstantBl.POST) {
			operation = new ServiceOrderSave();
		} else if(transferObject.getConstantBl() == ConstantBl.GET_ALL_U) {
			operation = new ServiceOrderSelect4User();
		} else if(transferObject.getConstantBl() == ConstantBl.GET_ALL_R) {
			operation = new ServiceOrderSelect4Rest();
		} else if (transferObject.getConstantBl() == ConstantBl.PUT) {
			operation = new ServiceOrderEdit();
		}
		operation.executeSystemOperation(transferObject);
	}

}
