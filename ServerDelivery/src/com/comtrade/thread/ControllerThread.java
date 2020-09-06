package com.comtrade.thread;



import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ControllerThread {
	private volatile static ControllerThread instance;
	private List<ClientThread> clientList = new CopyOnWriteArrayList();
	
	private ControllerThread() {
	}
	
	public static ControllerThread getInstance() {
		if(instance == null) {
			synchronized (ControllerThread.class) {
				if (instance == null) {
				instance = new ControllerThread();
				}
			}
		}
		return instance;
	}
	
	public void addClient(ClientThread clientThread) {
		clientList.add(clientThread);
	}

	public List<ClientThread> getClientList() {
		return clientList;
	}
	
	
	
	
}
