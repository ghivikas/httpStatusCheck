/**
 * 
 */
package com.http.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
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
import com.http.logging.LogHelper;

/**
 * @author vikas.bhartiya
 *
 */
@WebService
public class HttpStatusService {

	@WebMethod
	public StatusBean[] httpstatus(String url,String UserName,String Password,String Domain)
	{
		
		Httpbean hb=new Httpbean();
		StatusBean sb=new StatusBean();
		hb.setURL(url);
		hb.setUserName(UserName);
		hb.setPassword(Password);
		hb.setDomain(Domain);
		List<StatusBean> result=new ArrayList<StatusBean>();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpContext localContext = new BasicHttpContext();
		
		AuthCache authCache = new BasicAuthCache();
		
		HttpGet httpget = new HttpGet(hb.getURL()); 

		NTCredentials creds = new NTCredentials(hb.getUserName(), hb.getPassword(), "WorkStation", hb.getDomain());
		httpclient.getCredentialsProvider().setCredentials(AuthScope.ANY, creds);
		
		HttpResponse response = null;
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
		Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO, url);
		LogHelper.debug(HttpStatusService.class.getClass(), "Looging " +url);
		HttpEntity entity = response.getEntity();
		  
			Logger.getLogger(HttpStatusService.class.getName()).log(Level.SEVERE, entity.toString());
			LogHelper.debug(HttpStatusService.class.getClass(), "Looging " + entity.toString());
			
	HttpHost target = (HttpHost) localContext.getAttribute( ExecutionContext.HTTP_TARGET_HOST);		
	Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO, target.toString());
	
        sb.setStatus(response.getStatusLine().toString());
        Logger.getLogger(HttpStatusService.class.getName()).log(Level.INFO, response.getAllHeaders().toString());
        Logger.getLogger(HttpStatusService.class.getName()).log(Level.ALL, response.getProtocolVersion().toString());
		
        sb.setUrl(url);
        result.add(sb);
		//return response.getStatusLine().toString();
        StatusBean[] Hwp = new StatusBean[result.size()];
		 result.toArray(Hwp);
		 if( response.getEntity() != null ) {
	            try {
					response.getEntity().consumeContent();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	         }
		 return Hwp;
        
	}
	
}
