package com.comtrade.controllerBl;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;
import com.comtrade.service.address.ServiceAddressDelete;
import com.comtrade.service.address.ServiceAddressSave;
import com.comtrade.service.address.ServiceAddressSelectAll4User;
import com.comtrade.service.address.ServiceAddressUpdate;

public class ControllerBlAddress implements CommandBase{

	@Override
	public void execute(TransferObject transferObject) {
		BaseSystemOperation operation = null;
		if(transferObject.getConstantBl() == ConstantBl.POST) {
			operation = new ServiceAddressSave();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ALL_U) {
			operation = new ServiceAddressSelectAll4User();
		} else if(transferObject.getConstantBl() == ConstantBl.PUT) {
			operation = new ServiceAddressUpdate();
		} else if (transferObject.getConstantBl() == ConstantBl.DELETE) {
			operation = new ServiceAddressDelete();
		}
		operation.executeSystemOperation(transferObject);
	}

}
