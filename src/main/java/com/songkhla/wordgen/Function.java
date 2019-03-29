/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.sql.Connection;
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
    public static void setList(String buc){
        Connection conn=null;
        conn=ConnectDatabase.connect();
        DefaultTableModel mo=(DefaultTableModel)ListAccused.jTableAccure.getModel();
        while (mo.getRowCount()>0){
            mo.removeRow(0);
        }
        String sql="";
        if(buc.equals("")){
            sql=Sentencies.List;
            
        }else{
            sql="Select * from Person WHERE("
                +"FullNamePerson Like'"+buc+"%')";
        }
        String datos[]=new String[4];
        try {
               Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()){
            datos[0]=rs.getString("FullNamePerson");
            datos[1]=rs.getString("FullNamePerson");
            datos[2]=rs.getString("FullNamePerson");
            datos[3]=rs.getString("FullNamePerson");
            mo.addRow(datos);
        }
        } catch (SQLException ex) {
//            Logger.getLogger(Function.class.getName()).log(Level.SEVERE,null.ex);
        }
     
        
    }
    
}
