/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.sql.*;
import javax.servlet.*;
/**
 *
 * @author Pushpane Choudhary
 */
public class form extends GenericServlet{

    public void service(ServletRequest req,ServletResponse res)throws IOException,ServletException{
		res.setContentType("Text/Html");
		String name=req.getParameter("name");
		String enroll=req.getParameter("enroll");
		String mobile=req.getParameter("mobile");
		String program=req.getParameter("program");
		String sem=req.getParameter("sem");
		String domain=req.getParameter("domain");
		PrintWriter pw=res.getWriter();
		try{
			Class.forName("com.mysql.jdbc.driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","9876");
			if(con!=null){
				PreparedStatement ps=con.prepareStatement("insert into form values(?,?,?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,enroll);
				ps.setString(3,mobile);
				ps.setString(4,program);
				ps.setString(5,sem);
				ps.setString(6,domain);
				int i=ps.executeUpdate();
				if(i>0)
					pw.println("Data Successfully Saved");
				else
					pw.println("Data not Saved");
			}
			else
				pw.println("Connection not made");
		}catch(Exception e){}
		pw.close();
	}
    
}
