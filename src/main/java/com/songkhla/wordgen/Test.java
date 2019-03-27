/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Computer
 */
public class Test {
    public static void main(String args[]) {
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
            
            try {
//                  String ch;
                   String sql="SELECT * from CrimeCase ";
//                   pst=conn.prepareStatement(sql);
//           pst=PreparedStatement(sql);
                Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
                System.out.println(sql);
            while((s!=null) && (s.next()))
            {  String  cs =s.getString("ChargeCode");
                System.out.print("ข้อหา :: "+s.getString("ChargeCode"));
                System.out.print(" - ");
          
            }
            } catch (Exception e) {
                 e.printStackTrace();
            }
    }
    
}
