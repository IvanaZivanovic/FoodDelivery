package com.comtrade.domain;

import java.io.Serializable;

public class TransferObject implements Serializable{
	private Object request;
	private Object response;
	private ConstantBl constantBl;
	private ConstantFc constantFc;
	private String message;
	public Object getRequest() {
		return request;
	}
	public void setRequest(Object request) {
		this.request = request;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public ConstantBl getConstantBl() {
		return constantBl;
	}
	public void setConstantBl(ConstantBl constantBl) {
		this.constantBl = constantBl;
	}
	public ConstantFc getConstantFc() {
		return constantFc;
	}
	public void setConstantFc(ConstantFc constantFc) {
		this.constantFc = constantFc;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public static TransferObject create(Object request, ConstantFc constantFc, ConstantBl constantBl) {
		TransferObject transferObject = new TransferObject();
		transferObject.setRequest(request);
		transferObject.setConstantFc(constantFc);
		transferObject.setConstantBl(constantBl);
		
		return transferObject;
	}
	
	
	

}
