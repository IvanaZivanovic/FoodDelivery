package com.comtrade.thread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerThread extends Thread {
	private int port;
	
	@Override
	public void run() {
		startServer();
		
	}

	private void startServer() {
		loadPort();
		try {
			ExecutorService executorService = Executors.newCachedThreadPool();
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Socket socket = serverSocket.accept();
				ClientThread clientThread = new ClientThread(socket);
				List<ClientThread> list = ControllerThread.getInstance().getClientList();
				if (!list.contains(clientThread)) {
					ControllerThread.getInstance().addClient(clientThread);
					executorService.execute(clientThread);
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void loadPort() {
		// TODO Auto-generated method stub
		File file = new File("socket.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String text = scanner.nextLine();
				String []array = text.split(";");
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
