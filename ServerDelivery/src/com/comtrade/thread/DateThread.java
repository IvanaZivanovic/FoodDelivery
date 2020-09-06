package com.comtrade.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.swing.JLabel;

public class DateThread extends Thread{
	private JLabel date;

	public DateThread(JLabel date) {
		super();
		this.date = date;
	}

	public JLabel getDate() {
		return date;
	}

	public void setDate(JLabel date) {
		this.date = date;
	}
	
	@Override
	public void run() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("E, dd. MMMM yyyy.");
		while (true) {
			date.setText(sdfDate.format(new Date()));
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
