import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Register extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setIntHeader("Refresh", 5);
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        String a1=request.getParameter("ename");
        String a2=request.getParameter("cname");
        String a3=request.getParameter("reg");
        String a4=request.getParameter("date");
        
        
          try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "system";
                 String pass = "pass123";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
                 Statement stmt=con.createStatement();
                 
                 String Qs="insert into complaint values('"+a1+"','"+a2+"','"+a3+"','"+a4+"') ";
                 ResultSet rs=stmt.executeQuery(Qs);
                 con.commit();
                 con.close();
                 RequestDispatcher rd=request.getRequestDispatcher("Complaint.html");
                 rd.include(request, response);
                 
                 
                 out.println("<br>");
                 out.println("<center><h2>Complaint registered succefully </h2></center>");
                 out.println("<br><center><a href=\"Students.html\">Go back</a></center>");
                 
                 
            }catch(Exception exe){System.out.println("Exception caught");}
         
     
         
 
   
    
    
    
    
    
    
    
    
    
    
    
    
    }
}
    