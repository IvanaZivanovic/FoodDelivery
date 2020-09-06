package com.comtrade.service.address;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Address;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.domain.User;
import com.comtrade.service.BaseSystemOperation;

public class ServiceAddressSelectAll4User extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		User user =  (User) transferObject.getRequest();
		try {
			transferObject.setResponse(broker.selectAllAddress4User(user));
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
