/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Computer
 */
public class ConnectDatabase {
      public static  Connection connect() {
        Connection conn = null;
        try {
            
            String url = "jdbc:sqlite:D://db/DocElec.db";
            // connection database
            conn = DriverManager.getConnection(url);
             System.out.println("Create Database has been Complete.");
            System.out.println("Connection to Database has been Complete.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
         return conn;
    }
}
