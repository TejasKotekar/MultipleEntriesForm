/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;


public class Facilities extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try { 
        Connection con=null;
        Class.forName(null);
        con=DriverManager.getConnection(null);
        String s2=request.getParameter("s1");
        String[] facChk=request.getParameterValues("facChk");
        String[] facNo=request.getParameterValues("facNo");
        String[] fac=request.getParameterValues("fac");
        if(s2.equals("Save")&&facChk!=null){
            for(int i=0;i<facChk.length;i++){
                PreparedStatement pstmt;
                pstmt=con.prepareStatement(s2);
                pstmt=con.prepareStatement(s2);
                pstmt.executeUpdate();
            }
        }
  
            
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
