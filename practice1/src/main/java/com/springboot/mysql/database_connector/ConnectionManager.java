package com.springboot.mysql.database_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionManager {
    public static Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/backendgfg", "root", "vicky@0883");
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate("create table Student ( studentID int, LastName varchar(255), FirstNamestudent varchar(255), Address varchar(255), City varchar(255))");
            return con;
        }
        catch(Exception e){

        }
    return null;
    }
//    public static void main(String []args){
//        getConnection();
//    }
}
