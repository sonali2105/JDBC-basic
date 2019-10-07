import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class JdbcEx extends HttpServlet {
		public void service(HttpServletRequest req,HttpServletResponse res) {
					PrintWriter out=null;
					try {
							res.setContentType("text/html");
							out=res.getWriter();
							String e=req.getParameter("Emailid");
							out.println("<html><body>");
							out.println("<h1>Jdbc Example</h1>");
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TESTDB","rA@dns123");
							Statement st=con.createStatement();
							ResultSet rs=st.executeQuery("select *from user_info where Email='"+e+"'");
							if(rs.next()) {
									out.println("Email:<b>"+e+"</b></br>");
									out.println("Name:<b>"+rs.getString("name")+"</b><br/>");
									out.println("Phone No:<b>"+rs.getString("phone")+"</b><br/>");
									out.println("Age:<b>"+rs.getInt("age")+"</b><br/>");
									}else {
											out.println("No user found!");
										}
										out.println("</body></html>");
						}catch(Exception ex){
							out.println(ex);
							}
				}
		}
		