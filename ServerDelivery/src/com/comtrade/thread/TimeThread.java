package com.comtrade.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class TimeThread extends Thread{
	private JLabel time;

	public TimeThread(JLabel time) {
		super();
		this.time = time;
	}

	public JLabel getTime() {
		return time;
	}

	public void setTime(JLabel time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
		while(true) {
			time.setText(sdfTime.format(new Date()));
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
