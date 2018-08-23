package com.http.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.http.bean.Httpbean;
import com.http.bean.StatusResult;

public class Credential {

	

	private static final SessionFactory sessionFactory = CredUtil.getCredInfoSessionFactory();

	public List<Httpbean> getCred()
	{
		List<Httpbean> result2 =new ArrayList<Httpbean>();
		final Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  
		  String query="select * from Credential where pein=? ";  
		  
		  Connection conn=session.connection();
		  try {
		  
		   PreparedStatement statement = null ;
		   String PEIN="R7439";
		   statement = conn.prepareStatement(query);
		   statement.setString(1, PEIN);
		
			
		
		  ResultSet rs=statement.executeQuery();

		  
		  while(rs.next())
		  {
			 Httpbean hb=new Httpbean();
			  
			  hb.setUserName(rs.getString(1));
			  hb.setPassword(rs.getString(2));
			  hb.setDomain(rs.getString(3));
			  
			//  LogHelper.info(HardwareInfoDao.class,"Output Details"+ rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
			  
			  result2.add(hb);
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result2;
		 
	}
	
}
