/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 *
 * @author Computer
 */
public class LoginAuthen {
    public static void main(String[] args) {
    Connection con=null;
    PreparedStatement pst=null;
        System.out.println(getMotherboardSerial());
    try{
        con = ConnectDatabase.connect();
             Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();

            String sql ="Select * from User";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                 if(rs.getString("StatusLogin").equals("0")){
                  LogInPage aa=new LogInPage();
                 SwingUtilities.updateComponentTreeUI(aa);
                    aa.pack();
                 aa.setVisible(true);
                 
                 }
                 else{
                 String sql2="Select * from User where serialnum='"+getMotherboardSerial()+"' and statuslogin='1'";
                 ResultSet rs2 = stmt2.executeQuery(sql2);
                 if(rs2.next()){
                 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                   
                  MainMenuWord mw=new MainMenuWord(); 
                  SwingUtilities.updateComponentTreeUI(mw);
                    mw.pack();
                  mw.setLocationRelativeTo(null);
                  mw.setVisible(true);
                  
                 
                 }
                 else{
//                 LogInPage.Username.setText(rs.getString("username"));
                 LogInPage aa=new LogInPage();
                 SwingUtilities.updateComponentTreeUI(aa);
                    aa.pack();
                 aa.setVisible(true);
                 
                 }
                 }
//             String st=rs.getString("StatusLogin");
//             if(st.equals("0")){
//             LogInPage lp=new LogInPage();
//             lp.setVisible(true);
//             
//             }
//             else{
//             MainMenuWord mw=new MainMenuWord();
//             mw.setVisible(true);
//             }
             }
             else{
             LogInPage lp=new LogInPage();
             SwingUtilities.updateComponentTreeUI(lp);
             lp.setVisible(true);
             }
            }
    catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
        public static String getMotherboardSerial(){
		try
	    {
	        String result = null;
                 String nline = null;

	        Process p = Runtime.getRuntime().exec("wmic baseboard get product,Manufacturer,version,serialnumber");
	               BufferedReader input
	                = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
	        String line;
	        while ((line = input.readLine()) != null)
	        {
	        	nline += line;
	        }
                  result= nline.replace(" ","");
        System.out.println("aa "+result);
	        input.close();
	        return result;
	    } catch (IOException ex)
	    {
	        ex.printStackTrace();
	        return null;
	    }
	}
}
