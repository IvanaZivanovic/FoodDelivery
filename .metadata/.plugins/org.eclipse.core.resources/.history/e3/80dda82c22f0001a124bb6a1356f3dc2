package com.comtrade.communication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.comtrade.domain.TransferObject;

public class Communication {
	private static Communication instance;
	private Socket socket;
	private static int port;
	private String ipAddress;
	
	public int getPort() {
		return port;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	private Communication() {
		//socket = new Socket();
		loadData();
		try {
			socket = new Socket(ipAddress, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Communication getInstance() {
		if (instance == null) {
			instance = new Communication();
		} return instance;
	}
	
	public void send(TransferObject transferObject) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(transferObject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public TransferObject read () throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		return (TransferObject) objectInputStream.readObject();
	}

	private void loadData() {
			
		File file = new File("socket.txt");
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String text = scanner.nextLine();
				String []array = text.split(";");
				ipAddress = array[0];
				port = Integer.parseInt(array[1]);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
	

}
