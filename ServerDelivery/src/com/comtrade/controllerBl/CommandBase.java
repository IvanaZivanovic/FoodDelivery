package com.comtrade.controllerBl;

import com.comtrade.domain.TransferObject;

public interface CommandBase {
	public void execute(TransferObject transferObject);

}
