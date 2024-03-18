package com.javaServlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCServletConnection 
{
   public static void insert(TestServlet TS) throws SQLException
   {

	        Connection connection = null;
            PreparedStatement statement = null;
    
    
             String url="jdbc:mysql://192.168.0.125/CODEBEGUN_TEST_DB";
             String UserName = "root";
             String Password = "root";
             String insertQuery = "insert into Register (FirstName,LastName,Email,MobileNumber)"+"values (?,?,?,?)";
          try 
           {
             connection = DriverManager.getConnection(url,UserName,Password);
             statement = connection.prepareStatement(insertQuery);
             statement.setString(1,TS.getFirstName());
             statement.setString(2,TS.getLastName());
             statement.setString(3,TS.getEmail());
             statement.setString(4,TS.getMobileNumber());
             statement.execute();
           }
             catch (Exception e)
             {
        	     e.printStackTrace();
             }
     
           
    }
}
