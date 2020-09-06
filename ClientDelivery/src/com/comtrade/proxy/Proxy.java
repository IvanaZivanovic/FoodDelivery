package com.comtrade.proxy;

import java.io.Serializable;

import com.comtrade.domain.User;

public interface Proxy extends Serializable{
	void login(User userCustomer);

}
