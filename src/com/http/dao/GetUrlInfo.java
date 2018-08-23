package com.http.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



import com.http.bean.StatusResult;
import com.http.logging.LogHelper;




public class GetUrlInfo {

	
	private static final SessionFactory sessionFactory = GetUrlUtil.getHttpInfoSessionFactory();

	
	public List<StatusResult> getStatus( ) throws SQLException{
		
		List<StatusResult> result =new ArrayList<StatusResult>();
		final Session session = sessionFactory.getCurrentSession();
		  session.beginTransaction();
		  
		  String query="select * from Multivu_URL ";  
		  
		  Connection conn=session.connection();
		  
		  
		  PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
		
		  ResultSet rs=statement.executeQuery();

		  
		  while(rs.next())
		  {
			 
			  StatusResult hwf=new StatusResult();
			  
			  hwf.setApp(rs.getString(1));
			  hwf.setURL(rs.getString(2));			  
			//  LogHelper.info(GetUrlInfo.class,"String Details"+ rs.getString(1)+rs.getString(2));
			  //System.out.println(rs.getString(1)+ " " +rs.getString(2));
			  result.add(hwf);
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
			e.getCause();
			 LogHelper.info(GetUrlInfo.class,"Exception Details"+ e.getMessage());
			 
		}
		finally
		{
		statement.close();	
		}
		  
		/*StatusResult[] Hwp = new StatusResult[result.size()];
		 result.toArray(Hwp);
		 return Hwp;*/
		return result;
	}
	
	
}
