package com.comtrade.service.category;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Category;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceCategorySave extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Category c = (Category) transferObject.getRequest();
		try {
			broker.insert(c);
			transferObject.setMessage("A new category has been successfully inserted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
