package com.comtrade.service.address;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Address;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceAddressUpdate extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Address address = (Address) transferObject.getRequest();
		try {
			broker.update(address);
			transferObject.setMessage("Address was successfully updated");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
