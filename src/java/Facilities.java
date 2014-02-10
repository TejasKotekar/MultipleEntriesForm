/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;



public class Facilities extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        Connection con=null;
        Statement st=null;
        ResultSet rs;
       
        PrintWriter out = response.getWriter();
        
        try { 
               
                Class.forName("org.postgresql.Driver");
               
                String url="jdbc:postgresql://localhost:5432/Services";
                String user="postgres";
                String pass="tejas";
                
                
                con=DriverManager.getConnection(url,user,pass);
                
                String s2=request.getParameter("s1");
                String[] facChk=request.getParameterValues("facChk");
                String[] facNo=request.getParameterValues("facNo");
                String[] fac=request.getParameterValues("fac");
                if(s2.equals("Save")&&facChk!=null){
                    for(int i=0;i<facChk.length;i++){
                        
                        PreparedStatement pstmt;
                        pstmt=con.prepareStatement("insert into \"Facilities\" values(?,?)");
                        pstmt.setInt(1,Integer.parseInt(facNo[i]));
                        pstmt.setString(2,fac[i]);
                        pstmt.executeUpdate();
                    }
                    out.println("<center><h1>Records Inserted");
                  }
                    else if(s2.equals("Display")){
                    out.println("<center><h1>Records</h1></center>");
                    
                    rs = st.executeQuery("select * from \"Facilities\"");

                while(rs.next())
                {
                    int fNo=rs.getInt(1);
                    String faclity=rs.getString(2);
               
                    out.println("<center><table border=1 >" + "<tr>"+"<td>"+"<input type=checkbox>" +"<td>"+"<input type=text value='"+fNo+"' >"+ "<td>" +"<input type=text value='"+faclity+"' >"+"</tr>");
                    out.println("</table>"+"</center>");
                }   
                }
                else{
                out.println("<center><h1>One or more records are not selected!</h1></center>");
                }
            st.close();
            con.close();               

          }catch(SQLException se){
            out.println(se.getMessage());
        }
            catch(Exception e){
            e.getMessage();
        }
    

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
