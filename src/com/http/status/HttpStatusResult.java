package com.http.status;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

import com.http.bean.Httpbean;
import com.http.bean.StatusBean;
import com.http.bean.StatusResult;
import com.http.dao.Credential;
import com.http.dao.GetUrlInfo;
import com.http.logging.LogHelper;

public class HttpStatusResult {

	
	@SuppressWarnings("deprecation")
	public List<StatusBean> HttpResponseResult(String Url) throws Exception
	{
		String Username="vikas.bhartiya";
		String password="cgi@2012";
	    String domain="bell";
		Httpbean hb=new Httpbean();
		Credential cr=new Credential();
		
		hb.setUserName(cr.getCred().get(0).getUserName());
		hb.setPassword(cr.getCred().get(0).getPassword());
		hb.setDomain(cr.getCred().get(0).getDomain());
		
		/*hb.setUserName(Username);
		hb.setPassword(password);
		hb.setDomain(domain);*/
		
		StatusBean sb=new StatusBean();
		
		GetUrlInfo gu=new GetUrlInfo();
		List<StatusResult> sr= new LinkedList<StatusResult>();
		
	     sr=gu.getStatus();
		
		List<StatusBean> result=new ArrayList<StatusBean>();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		HttpResponse response = null;
		HttpEntity entity;
		AuthCache authCache = new BasicAuthCache();
	
			
			
		HttpGet httpget = new HttpGet(Url); 
        
		NTCredentials creds = new NTCredentials(hb.getUserName(), hb.getPassword(), "WorkStation", hb.getDomain());
		httpclient.getCredentialsProvider().setCredentials(AuthScope.ANY, creds);
		
		 response = null;
		try {
			response = httpclient.execute(httpget, localContext);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 
		HttpUriRequest req = (HttpUriRequest) localContext.getAttribute(
		        ExecutionContext.HTTP_REQUEST);
	//	Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO, sr.get(i).getURL());
	//	LogHelper.debug(HttpStatusService.class.getClass(), "Looging " +sr.get(i).getApp());
		 entity = response.getEntity();
		  
		//	Logger.getLogger(HttpStatusService.class.getName()).log(Level.SEVERE, entity.toString());
		//	LogHelper.debug(HttpStatusService.class.getClass(), "Looging " + entity.toString());
			
	HttpHost target = (HttpHost) localContext.getAttribute( ExecutionContext.HTTP_TARGET_HOST);		
	//Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO, target.toString());
	    sb.setUrl(Url);
        sb.setStatus(response.getStatusLine().toString());
         result.add(sb);
       // Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO, response.getAllHeaders().toString());
        Logger.getLogger(HttpStatusService.class.getName()).log(Level.ALL, response.getProtocolVersion().toString());
		
         
        Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO, Url);
        Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO,response.getStatusLine().toString() );
    //    Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO,null, sr.size() );
       
        if( response.getEntity() != null ) {
            try {
				response.getEntity().consumeContent();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
     
		
			
			 return result;

		   
       
		
	}
	
}
