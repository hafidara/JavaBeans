package myBean;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import java.sql.*;
/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    System.out.println("Mysql Connect example");
    Connection BD=null;
    String USER="";
    String PASS="";
    String strQuery="";
    Statement st=null;
    ResultSet rs=null;
    HttpSession session=request.getSession(true);
    try {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}catch(ClassNotFoundException e) {
    	}
    	try {
    	BD=DriverManager.getConnection("jdbc:mysql://localhost/user_register","root","SMI6");
    	System.out.println("Successful connexion!");}
    	catch(Exception ex) {
    		 JOptionPane.showMessageDialog(null,"Erreur de connection avec la base de donnees\n"+ex.getMessage());
    	}
    	if(request.getParameter("uName2")!=null && request.getParameter("uName2")!="" 
    			&&  request.getParameter("pWord2")!=null &&  request.getParameter("pWord2")!="" )
    	{
    		USER=request.getParameter("uName2").toString();
    		PASS=request.getParameter("pWord2").toString();
    		strQuery="select * from userregister where username='"+USER+"' and password='"+PASS+"'";
    		System.out.println(strQuery);
    		st=BD.createStatement();
    		rs=st.executeQuery(strQuery);
    		int count=0;
    		while(rs.next()) {
    			session.setAttribute("username", rs.getString(2));
    			count++;
    		}
    		if(count>0) {
    			response.sendRedirect("Welcome.jsp");
    		}else {
    			response.sendRedirect("login.jsp");
    		}
    		//BD.close();
    				
    	}
    }
    catch(Exception e) {
    	e.printStackTrace();
    }
}

}
