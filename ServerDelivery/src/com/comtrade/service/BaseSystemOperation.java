package com.comtrade.service;

import com.comtrade.connection.MyConnection;
import com.comtrade.domain.TransferObject;

public abstract class BaseSystemOperation {
	public void executeSystemOperation(TransferObject transferObject) {
		try{
			startTransaction();
			executeSpecificSystemOperation(transferObject);
			confirmTransaction();
		}catch (Exception e) {
			e.printStackTrace();
			cancelTransaction();
		} finally {
			closeConnection();
		}
		
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		MyConnection.getInstance().closeConnectionMy();
	}

	public void cancelTransaction() {
		// TODO Auto-generated method stub
		MyConnection.getInstance().cancelTransaction();
	}

	public void confirmTransaction() {
		// TODO Auto-generated method stub
		MyConnection.getInstance().confirmTransaction();
	}

	public abstract void executeSpecificSystemOperation(TransferObject transferObject);

	public void startTransaction() {
		// TODO Auto-generated method stub
		MyConnection.getInstance().startTransaction();
		
	}

}
