import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ViewComplaint extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Complaint Page</title>");
    out.println("<link rel=\"stylesheet\" href=\"total.css\">");
    out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
    out.println("</head>");
    out.println("<body>");
        try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                 String user = "system";
                 String pass = "pass123";
                 Connection con = DriverManager.getConnection(conURL, user, pass);
              
                 
                 response.setContentType("text/html");
                 
                 Statement stmt1 = con.createStatement();  
                 ResultSet rp = stmt1.executeQuery("select * from complaint"); 
                 
        
                 out.println("<center><h1>Complaints Details</h1></center>");
                 out.println("<br>");
                 out.println("<div>");
                 
                 out.println("<center>");
                 out.println("<table border=1 width=50% height=50%>");  
                 out.println("<tr><th>Name</th><th>Complaint</th><th>Registration No</th><th>Date</th>");  
                 while (rp.next()) 
                   {  
                    String n = rp.getString("name");  
                    String nm = rp.getString("cname");  
                    String cn = rp.getString("regno");
                    String co = rp.getString("c_date");
                    
                    out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + cn + "</td><td>"+co+"</td></tr>");   
                   }  
                 con.commit();
                 con.close(); 
                 out.println("</table>"); 
                 out.println("</center>");
                 out.print("</body>");
                 out.print("</html>"); 
             
             
            }    
        catch(Exception exe){System.out.println("Exception caught");}
        
       
    
    
    
    
    
    
    
    }
}
