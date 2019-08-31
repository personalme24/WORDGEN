/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

/**
 *
 * @author Computer
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import javax.swing.text.JTextComponent;
import javax.swing.undo.*;


public class JTextPopupMenu {
    public static void addTo(JTextComponent txtField) 
    {
        JPopupMenu popup = new JPopupMenu();
//        UndoManager undoManager = new UndoManager();
//        txtField.getDocument().addUndoableEditListener(undoManager);

//        Action undoAction = new AbstractAction("Undo") {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                if (undoManager.canUndo()) {
//                    undoManager.undo();
//                }
//                else {
//                    JOptionPane.showMessageDialog(null,
//                            "Undoable: " + undoManager.canUndo() ,
//                            "Undo Status", 
//                            JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        };

       Action copyAction = new AbstractAction("Copy  Ctrl+C") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtField.copy();
            }
        };

//        Action cutAction = new AbstractAction("Cut") {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                txtField.cut();
//            }
//        };

        Action pasteAction = new AbstractAction("Paste  Ctrl+V") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtField.paste();
            }
        };

//        Action selectAllAction = new AbstractAction("Select All") {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                txtField.selectAll();
//            }
//        };

//        popup.add (undoAction);
//        popup.addSeparator();
//        popup.add (cutAction);
        popup.add (copyAction);
        popup.add (pasteAction);
//        popup.addSeparator();
//        popup.add (selectAllAction);

       txtField.setComponentPopupMenu(popup);
    }
      public static void addToTextArea(JTextArea txtArea) 
    {
        JPopupMenu popup = new JPopupMenu();
//

       Action copyAction = new AbstractAction("Copy  Ctrl+C") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtArea.copy();
            }
        };


        Action pasteAction = new AbstractAction("Paste  Ctrl+V") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtArea.paste();
            }
        };

        popup.add (copyAction);
        popup.add (pasteAction);


       txtArea.setComponentPopupMenu(popup);
    }
}
