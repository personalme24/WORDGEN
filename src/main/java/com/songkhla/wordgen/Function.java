/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Computer
 */
public class Function {
     
    public static boolean isRegister(Sentencies s) {
        Connection conn=null;
        PreparedStatement ps=null;
        String sql=Sentencies.AddAccured;
        conn=ConnectDatabase.connect();
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, s.getPeopleRegistrationID());
            ps.setString(2, s.getFullNamePerson());
            ps.setString(3, s.getTypePerson());
            ps.setString(4, s.getCrimecaseno());
            ps.executeUpdate();
         return true;   
        } catch (SQLException ex) {
            return false;
//            Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void setList(String buc){
        Connection conn=null;
        conn=ConnectDatabase.connect();
        DefaultTableModel mo=(DefaultTableModel)ListAccused.jTableAccure.getModel();
        while (mo.getRowCount()>0){
            mo.removeRow(0);
        }
        String sql="";
        if(buc.equals("")){
            sql=Sentencies.ListAccured;
            
        }else{
            sql="Select * from Person WHERE("
                +"FullNamePerson Like'"+buc+"%')";
        }
        String datos[]=new String[4];
        try {
               Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            datos[0]=rs.getString("PeopleRegistrationID")+rs.getString("FullNamePerson");
            datos[1]=rs.getString("FullNamePerson");
            datos[2]=rs.getString("TypePerson");
            datos[3]=rs.getString("crimecaseno");
            mo.addRow(datos);
        }
        } catch (SQLException ex) {
//            Logger.getLogger(Function.class.getName()).log(Level.SEVERE,null.ex);
        }
     
        
    }
    
}
