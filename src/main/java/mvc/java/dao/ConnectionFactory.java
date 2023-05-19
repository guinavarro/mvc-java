/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    private Connection connection;
    private static String db_host;
    private static String db_name;
    private static String db_timeZone;
    private static String db_user;
    private static String db_pass;
    
    public ConnectionFactory(){
        db_host = "jdbc:mysql://localhost:3306/";
        db_name = "exemplomvc";
        db_timeZone = "?useTimeZone=true&serverTimeZone=UTC";
        db_user = "root";
        db_pass = "";       
    }

    public Connection getConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection connection = DriverManager.getConnection
                    (db_host + db_name + db_timeZone, db_user, db_pass);
            return connection;
            
        }catch(SQLException e){
            throw new RuntimeException (e);
        }
    }


}
