package com.http.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.http.bean.StatusBean;
import com.http.bean.StatusResult;
import com.http.dao.GetUrlInfo;
import com.http.pdf.Httppdf;
import com.http.status.HttpStatusResult;

/**
 * Servlet implementation class HttpStatusControl
 */
public class HttpStatusControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpStatusControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	GetUrlInfo gui=new GetUrlInfo();

	HttpStatusResult hsr=new HttpStatusResult();
	Httppdf hp=new Httppdf();
	//StatusBean[] sre =hsr.HttpResponseResult();
	 List<StatusBean> lst=new ArrayList<StatusBean>();
			
		List<StatusResult> st=new ArrayList<StatusResult>();
		List<StatusResult> st1=new ArrayList<StatusResult>();
			try {
				for(int i=0;i<gui.getStatus().size();i++)
				{
				lst.addAll(hsr.HttpResponseResult(gui.getStatus().get(i).getURL()));
					
			
                st.get(i).setApp(gui.getStatus().get(i).getApp());	
            	 //st.addAll(gui.getStatus().get(i).getApp()); 
                
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st1.addAll(st);
			StatusBean sb [];
			
			request.setAttribute("Status", lst);
			request.setAttribute("App", st1);
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/Result.jsp");
			rd.forward(request, response);
			
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
