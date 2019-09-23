/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Computer
 */
public class Test22 {
    public static void main(String [] args) throws Exception {
        DefaultTableModel model = new DefaultTableModel(null, new String [] {"CheckMe", "Value"}) {
                                public Class getColumnClass(int c) {
                                  switch (c) {
                                    case 0: return Boolean.class;
                                    default: return String.class;
                                  }   
                                } };
        JTable table = new JTable(model);
    JFrame frame = new JFrame("CheckBox Test");
    frame.add(table);
    model.addRow(new Object [] {true, "This is true"});
    model.addRow(new Object [] {false, "This is false"});
    frame.pack(); frame.validate();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
