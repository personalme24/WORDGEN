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
public class LoginAuthen {
    public static void main(String[] args) {
    Connection con=null;
    PreparedStatement pst=null;
    try{
        con = ConnectDatabase.connect();
             Statement stmt = con.createStatement();
            String sql ="Select * from User";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
             String st=rs.getString("StatusLogin");
             if(st.equals("0")){
             LogInPage lp=new LogInPage();
             lp.setVisible(true);
             
             }
             else{
             MainMenuWord mw=new MainMenuWord();
             mw.setVisible(true);
             }
             }
             else{
             LogInPage lp=new LogInPage();
             lp.setVisible(true);
             }
            }
    catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
