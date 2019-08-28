/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
/**
 *
 * @author Computer
 */
public class Test2 {
  public JComponent makeUI() {
    JPanel p = new JPanel(new GridLayout(2, 1));
//      p.add(makePanel("Default ButtonGroup", new ButtonGroup()));
      p.add(makePanel("Custom ButtonGroup", new ButtonGroup() {
          private ButtonModel prevModel;
          private boolean isAdjusting = false;
          @Override public void setSelected(ButtonModel m, boolean b) {
              if (isAdjusting) {
                  return;
              }
              if (m.equals(prevModel)) {
                  isAdjusting = true;
                  clearSelection();
                  isAdjusting = false;
              } else {
                  super.setSelected(m, b);
              }
              prevModel = getSelection();
          }
      }));
    return p;
  }
  private JComponent makePanel(String title, ButtonGroup g) {
    JPanel p = new JPanel();
    p.setBorder(BorderFactory.createTitledBorder(title));
    for (String s: Arrays.asList("aaa", "bbb", "ccc")) {
      AbstractButton r = new JRadioButton(s);
      //AbstractButton r = new JToggleButton(s);
      p.add(r);
//      g.add(r);
    }
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new Test2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}