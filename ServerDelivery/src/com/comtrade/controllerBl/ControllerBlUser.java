package com.comtrade.controllerBl;

import com.comtrade.domain.ConstantBl;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;
import com.comtrade.service.user.ServiceUserRegisterUser;
import com.comtrade.service.user.ServiceUserGetAllRest;
import com.comtrade.service.user.ServiceUserGetAllUsers;
import com.comtrade.service.user.ServiceUserGetOne;
import com.comtrade.service.user.ServiceUserLogin;
import com.comtrade.service.user.ServiceUserRegisterRest;
import com.comtrade.service.user.ServiceUserUpdate;
import com.comtrade.service.user.ServiceUserUpdatePass;

public class ControllerBlUser implements CommandBase{

	@Override
	public void execute(TransferObject transferObject) {
		BaseSystemOperation operation = null;
		if(transferObject.getConstantBl() == ConstantBl.POST_LOGIN) {
			operation = new ServiceUserLogin();
		} else if (transferObject.getConstantBl() == ConstantBl.POST) {
			operation = new ServiceUserRegisterRest();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ALL_R) {
			operation = new ServiceUserGetAllRest();
		} else if (transferObject.getConstantBl() == ConstantBl.PUT) {
			operation = new ServiceUserUpdate();
		} else if (transferObject.getConstantBl() == ConstantBl.POST_USER) {
			operation = new ServiceUserRegisterUser();
		} else if(transferObject.getConstantBl() == ConstantBl.GET_ALL_U) {
			operation = new ServiceUserGetAllUsers();
		} else if (transferObject.getConstantBl() == ConstantBl.GET_ONE) {
			operation = new ServiceUserGetOne();
		} else if (transferObject.getConstantBl() == ConstantBl.PUT_PASS) {
			operation = new ServiceUserUpdatePass();
		}
			
		operation.executeSystemOperation(transferObject);
	}

}
