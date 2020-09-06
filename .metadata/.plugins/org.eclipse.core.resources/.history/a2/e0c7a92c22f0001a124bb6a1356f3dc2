package com.comtrade.frontcontroller;


import java.io.IOException;


import com.comtrade.communication.Communication;
import com.comtrade.domain.TransferObject;

public class FrontController {
	
	private static FrontController instance;

	
	private FrontController() {

	}
		
	public static FrontController getInstance() {
		if (instance == null){
			instance = new FrontController();
		}
		return instance;
	}
	public TransferObject execute(TransferObject transferObject) throws ClassNotFoundException, IOException {
		Communication.getInstance().send(transferObject);
		return Communication.getInstance().read();
		 
	}

}
