package com.comtrade.service.order;

import org.omg.CORBA.Request;

import com.comtrade.broker.Broker;
import com.comtrade.domain.MySqlException;
import com.comtrade.domain.Order;
import com.comtrade.domain.TransferObject;
import com.comtrade.service.BaseSystemOperation;

public class ServiceOrderSave extends BaseSystemOperation {

	@Override
	public void executeSpecificSystemOperation(TransferObject transferObject) {
		Broker broker = new Broker();
		Order order = (Order) transferObject.getRequest();
		try {
			broker.saveOrder(order);
			transferObject.setMessage("Order was sent to " + order.getRestaurant().getName() + ". Waiting for response");
		} catch (MySqlException e) {
			// TODO Auto-generated catch block
			transferObject.setMessage(e.toString());
		}

	}

}
