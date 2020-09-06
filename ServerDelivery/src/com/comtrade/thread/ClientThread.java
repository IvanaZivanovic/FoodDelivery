package com.comtrade.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.comtrade.controllerBl.CommandBase;
import com.comtrade.controllerBl.ControllerBlAddress;
import com.comtrade.controllerBl.ControllerBlCategory;
import com.comtrade.controllerBl.ControllerBlCuisine;
import com.comtrade.controllerBl.ControllerBlMeal;
import com.comtrade.controllerBl.ControllerBlOrder;
import com.comtrade.controllerBl.ControllerBlRestaurant;
import com.comtrade.controllerBl.ControllerBlUser;
import com.comtrade.domain.TransferObject;

public class ClientThread extends Thread{
	private Socket socket;

	public ClientThread(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {
	while(true) {
			ObjectInputStream objectInputStream;
			try {
				objectInputStream = new ObjectInputStream(socket.getInputStream()); 
				TransferObject transferObject = (TransferObject) objectInputStream.readObject();
				processData(transferObject);
				
			} 
			catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
	}
	
	
	private void processData(TransferObject transferObject) {
		CommandBase commandBase = null;
		switch (transferObject.getConstantFc()) {
		case RESTAURANT:
			commandBase = new ControllerBlRestaurant();
			break;
		case CUISINE:
			commandBase = new ControllerBlCuisine();
			break;
		case CATEGORY:
			commandBase = new ControllerBlCategory();
			break;
		case MEAL:
			commandBase = new ControllerBlMeal();
			break;
		case USER:
			commandBase = new ControllerBlUser();
			break;
		case ADDRESS:
			commandBase = new ControllerBlAddress();
			break;
		case ORDER:
			commandBase = new ControllerBlOrder();
			break;
		default:
			break;
		}
		commandBase.execute(transferObject);
		send(transferObject);
	}
	private void send(TransferObject transferObject) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
