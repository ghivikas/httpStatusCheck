package com.http.test;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;

import com.http.mail.SendMail;
public class TimerClass extends  TimerTask {


	public void setTimer()
	{
		MainClass tc=new MainClass();
		
		
		
	}
	public void run() {
		
		 SendMail sm=new SendMail();
		 //.SavePdf();
		 try {
			sm.SendpdfMail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
