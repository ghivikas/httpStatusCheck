<%@page import="com.http.bean.StatusBean"%>
<%@page import="com.http.bean.StatusResult"%>

<%@page import="com.http.status.HttpStatusResult"%>
<%@page import="com.http.dao.GetUrlInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.http.pdf.Httppdf"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result Page</title>
</head>
<body bgcolor=#f9eba9>
<%
   List<StatusBean> lst=new ArrayList<StatusBean>();
 GetUrlInfo gui=new GetUrlInfo();

   lst=(List<StatusBean>)request.getSession().getAttribute("Status");
   //lst=request.getSession().getAttribute("Status");
%>

<h2>&nbsp;&nbsp;&nbsp;&nbsp;Http Response Results</h2>
 
 <table width="862" height="348" border="1" cellpadding="2" cellspacing="2">
 <tr>
	<th >URL</th>
	<th >Application</th>
	<th >Status</th>
	</tr>
 <%   
 for(int i=0; i < lst.size();i++)
	{ %>

	
	<tr>
	<td>
<% 	out.println(lst.get(i).getUrl()); %>
	</td>
	<td>
<% 	out.println(gui.getStatus().get(i).getApp()); %>
	</td>
	<td>
	<%out.println(lst.get(i).getStatus());
	
	}%>
	
	</td>
 </tr>
 
 
  </table>
	<input type="button" name="Save as" onclick=
	<% 
	
	
	//hp.SavePdf();
	
	
 %>  > 

</body>

</html>