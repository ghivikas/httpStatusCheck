package com.http.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;

import com.http.bean.StatusBean;
import com.http.bean.StatusResult;
import com.http.dao.Credential;
import com.http.dao.GetUrlInfo;
import com.http.mail.SendMail;
import com.http.pdf.Httppdf;
import com.http.status.HttpResultTest;
import com.http.status.HttpStatusResult;

public class MainClass {

	public static void main(String []args) throws Exception
	{
		 /*GetUrlInfo gui=new GetUrlInfo();
		 HttpStatusResult hsr=new HttpStatusResult();
		 HttpResultTest rst=new HttpResultTest();
		 Credential cr=new Credential();
		 Httppdf hp=new Httppdf();
		 StatusBean[] sre;;
		 cr.getCred();*/
		 SendMail sm=new SendMail();
		 //sre=hsr.HttpResponseResult();
		 List<StatusBean> lst=new ArrayList<StatusBean>();
		
		/*
		for(int i=0;i<gui.getStatus().size();i++)
		{
		lst.addAll(hsr.HttpResponseResult(gui.getStatus().get(i).getURL()));
			
		    System.out.println(  lst.get(i).getUrl() );
	        System.out.println(lst.get(i).getStatus());
		  
		   
		}
		
	    System.out.println(gui.getStatus().get(i).getURL());
		System.out.println(sre[i].getStatus());
	    System.out.println(gui.getStatus().size());
		 System.out.println(lst.size());
		for(int i=0;i<gui.getStatus().size();i++)
		{
      
         System.out.println(  lst.get(i).getUrl());
         System.out.println(lst.get(i).getStatus());
     //   hp.SavePdf(lst.get(i).getUrl(), gui.getStatus().get(i).getApp(), lst.get(i).getStatus());
    	
		}
		 hp.SavePdf();
		 sm.SendpdfMail();
		//StatusResult sre1=new StatusResult();
	
		/*System.out.println(cr.getCred().get(0).getUserName());
		System.out.println(cr.getCred().get(0).getPassword());
		System.out.println(cr.getCred().get(0).getDomain());
		*/
		
		 
		 Timer timer = new Timer();
		 
		 TimerClass tc=new TimerClass();
		 
		// timer.schedule(tc,0,24000);
		timer.schedule(tc,  200);
	}
	public void settimer() throws MessagingException{
		 //Httppdf hp=new Httppdf();
		 
		 SendMail sm=new SendMail();
		 //hp.SavePdf();
		 sm.SendpdfMail();
	}
	
}
