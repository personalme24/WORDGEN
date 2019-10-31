/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Computer
 */
public class ConnectDatabase {
    private static Connection conn = null;
      public static  Connection connect() 
      {
          if(conn==null){
            //Connection conn = null;
            try {
                 Class.forName("org.sqlite.JDBC");
                String url = "jdbc:sqlite:./WordGen.bat";
                // connection database
                conn = DriverManager.getConnection(url);
//               SQLiteConnection conns = new SQLiteConnection("Data Source=MyDatabase.sqlite;Version=3;");
//conn.SetPassword("password");
//conn.Open();
                 System.out.println("Create Database has been Complete.");
                System.out.println("Connection to Database has been Complete.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException ex) { 
                  Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
              }

             return conn;
          }else{
              return conn;
          }
    }
}
