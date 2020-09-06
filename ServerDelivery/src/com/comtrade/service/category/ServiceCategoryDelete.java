package com.comtrade.service.category;

import com.comtrade.broker.Broker;
import com.comtrade.domain.Category;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceCategoryDelete extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Category c = (Category) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.delete(c);
			transferObject.setMessage("Category with the ID "+c.getIdCategory()+" was successfully deleted");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
