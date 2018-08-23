package com.http.dao;
import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
public class GetUrlUtil {

	





	 private static SessionFactory GetUrlInfoSessionFactory = null;
	    public static SessionFactory getHttpInfoSessionFactory()
	    {
	        if (GetUrlInfoSessionFactory == null)
	        {
	            // Create the SessionFactory from hibernate.cfg.xml
	            final URL url = GetUrlUtil.class.getClassLoader().getResource("GetUrlInfo.hibernate.cfg.xml");
	            GetUrlInfoSessionFactory = getSessionFactory(url);
	        }
	        return GetUrlInfoSessionFactory;
	    }

	  
	    
	    public static SessionFactory getSessionFactory(final URL url)
	    {
	        SessionFactory factory = null;
	        try
	        {
	            if (url == null) {
	                throw new IllegalArgumentException("Invalid value for url parameter:" + url);
	            }
	            final Configuration configuration = new AnnotationConfiguration().configure(url);
	            factory = configuration.buildSessionFactory();
	        }
	        catch (final Throwable e)
	        {
	            // Make sure you log the exception, as it might be swallowed
	        	//Logger.
	        //   LogHelper.critical(HibernateUtil.class, "Initial SessionFactory creation failed.", e);
	           
	            throw new ExceptionInInitializerError(e);
	        }
	        return factory;
	    }
	    
	}
	


	
	

