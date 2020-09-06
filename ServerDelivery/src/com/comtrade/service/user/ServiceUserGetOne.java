package com.comtrade.service.user;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.service.BaseSystemOperation;

public class ServiceUserGetOne extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		User user = (User) transferObject.getRequest();
		try {
			transferObject.setResponse(broker.selectOneUser(user));
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}
	}

}
