/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import com.google.gson.JsonObject;
import static com.songkhla.wordgen.ActionPageInsert.ActionCrimes;
import static com.songkhla.wordgen.ActionPageInsert.ActionDetail;
import static com.songkhla.wordgen.ActionPageInsert.ActionNote;
import static com.songkhla.wordgen.Send_HTTP_Request2.NewDate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JSpinner;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/**
 *
 * @author Petpilin
 */
public class CaseSelectOverView extends javax.swing.JDialog {

    /**
     * Creates new form CrimesCaseView
     */
 

    Connection con=null;
    PreparedStatement pst=null;
     JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
      JDatePickerImpl DateAcceptStart,DateAcceptEnd,DateReqStart,DateReqEnd,DateAcceptStartTC,DateAcceptEndTC;

    public CaseSelectOverView(JFrame parrent) {
                super(parrent,true);

        initComponents();
        pack();
        setLocationRelativeTo(null); 
        ImageIcon img = new ImageIcon("./Master/WD.png");
        setIconImage(img.getImage());
        setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
        jPanel7.setVisible(true);
        jPanel3.setVisible(false);
//        jButton2.setVisible(false);
//        jButton1.setVisible(false);
//        jLabelorgcode.setVisible(false);
jlabeltoken.setVisible(true);
    DataCase tt=new DataCase();
   jlabeltoken.setText(tt.getToken());
        idcardlabel.setVisible(false);
        usernamelabel.setVisible(false);
        orgnamelabel.setVisible(false);
        DataUser();
//    RefreshDataCrime();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      UtilDateModel model = new UtilDateModel();
            model.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();        
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
         DateAcceptStart = new JDatePickerImpl(datePanel,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,32));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptStart.setTextEditable(true);
        DateAcceptStart.setBackground(Color.WHITE);
        jPanelStAcc.setLayout(new FlowLayout());
        jPanelStAcc.add(DateAcceptStart);
        
          UtilDateModel model2 = new UtilDateModel();
            model2.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2,p);
         DateAcceptEnd = new JDatePickerImpl(datePane2,new DateLabelFormatter());
//           DateAcceptEnd.setPreferredSize(new Dimension(220,30));
//    DateAcceptEnd.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptEnd.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptEnd.setTextEditable(true);
        DateAcceptEnd.setBackground(Color.WHITE);
        jPanelEnAcc.setLayout(new FlowLayout());
        jPanelEnAcc.add(DateAcceptEnd);    
        
        UtilDateModel model3 = new UtilDateModel();
            model3.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane3 = new JDatePanelImpl(model3,p);
         DateAcceptStartTC = new JDatePickerImpl(datePane3,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptStartTC.setTextEditable(true);
        DateAcceptStartTC.setBackground(Color.WHITE);
        jPanel4.setLayout(new FlowLayout());
        jPanel4.add(DateAcceptStartTC);    
        
        UtilDateModel model4 = new UtilDateModel();
            model4.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane4 = new JDatePanelImpl(model4,p);
         DateAcceptEndTC = new JDatePickerImpl(datePane4,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptEndTC.setTextEditable(true);
        DateAcceptEndTC.setBackground(Color.WHITE);
        jPanel5.setLayout(new FlowLayout());
        jPanel5.add(DateAcceptEndTC);  
        
          UtilDateModel model5 = new UtilDateModel();
            model5.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane5 = new JDatePanelImpl(model5,p);
         DateReqStart= new JDatePickerImpl(datePane5,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateReqStart.setTextEditable(true);
        DateReqStart.setBackground(Color.WHITE);
        jPanelReg.setLayout(new FlowLayout());
        jPanelReg.add(DateReqStart);  
        
          UtilDateModel model6 = new UtilDateModel();
            model6.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane6 = new JDatePanelImpl(model6,p);
         DateReqEnd = new JDatePickerImpl(datePane6,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateReqEnd.setTextEditable(true);
        DateReqEnd.setBackground(Color.WHITE);
        jPanelReg2.setLayout(new FlowLayout());
        jPanelReg2.add(DateReqEnd);  
        
       
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idcardlabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        orgnamelabel = new javax.swing.JLabel();
        jlabeltoken = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        casenocc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanelStAcc = new javax.swing.JPanel();
        jPanelEnAcc = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabelorgcode = new javax.swing.JLabel();
        caseyearscc = new javax.swing.JTextField();
        jPanelReg = new javax.swing.JPanel();
        jPanelReg2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCrime = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        TotalCase = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTraffic = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 93, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMaximumSize(new Dimension(1280, 720));
        jPanel1.setMinimumSize(new Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ข้อมูลคดีระบบ CRIMES ในความรับผิดชอบ");

        idcardlabel.setText("jLabel13");

        usernamelabel.setText("jLabel12");

        orgnamelabel.setText("jLabel12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(idcardlabel)
                .addGap(32, 32, 32)
                .addComponent(usernamelabel)
                .addGap(156, 156, 156)
                .addComponent(orgnamelabel)
                .addGap(126, 126, 126)
                .addComponent(jlabeltoken, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idcardlabel)
                    .addComponent(usernamelabel)
                    .addComponent(orgnamelabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlabeltoken, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("เลขคดี");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("ปี");

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("วันที่รับคดี");

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ถึงวันที่");

        jPanelStAcc.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanelStAccLayout = new javax.swing.GroupLayout(jPanelStAcc);
        jPanelStAcc.setLayout(jPanelStAccLayout);
        jPanelStAccLayout.setHorizontalGroup(
            jPanelStAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanelStAccLayout.setVerticalGroup(
            jPanelStAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanelEnAcc.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout jPanelEnAccLayout = new javax.swing.GroupLayout(jPanelEnAcc);
        jPanelEnAcc.setLayout(jPanelEnAccLayout);
        jPanelEnAccLayout.setHorizontalGroup(
            jPanelEnAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        jPanelEnAccLayout.setVerticalGroup(
            jPanelEnAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("รหัสสถานี");

        jLabelorgcode.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabelorgcode.setText("jLabel12");

        jPanelReg.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout jPanelRegLayout = new javax.swing.GroupLayout(jPanelReg);
        jPanelReg.setLayout(jPanelRegLayout);
        jPanelRegLayout.setHorizontalGroup(
            jPanelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanelRegLayout.setVerticalGroup(
            jPanelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jPanelReg2.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout jPanelReg2Layout = new javax.swing.GroupLayout(jPanelReg2);
        jPanelReg2.setLayout(jPanelReg2Layout);
        jPanelReg2Layout.setHorizontalGroup(
            jPanelReg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelReg2Layout.setVerticalGroup(
            jPanelReg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("วันที่ร้องทุกข์");

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("ถึงวันที่");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelorgcode, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(casenocc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(caseyearscc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelStAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelReg2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelEnAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(caseyearscc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelorgcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanelEnAcc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelStAcc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(casenocc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelReg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTableCrime.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jTableCrime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "เลือก", "เลขคดี", "วันที่รับแจ้ง", "วันที่รับคำร้องทุกข์", "ข้อหา", "ชื่อผู้กล่าวหา"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCrime.setRowHeight(25);
        jTableCrime.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTableCrime.getTableHeader().setOpaque(false);
        jScrollPane2.setViewportView(jTableCrime);

        jButton3.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jButton3.setText("ตกลง");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TotalCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        TotalCase.setText("0");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jLabel13.setText("คดี");

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jLabel12.setText("จำนวนคดีทั้งหมด");

        jButton5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton5.setText("เชื่อมต่อข้อมูล");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TotalCase)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel13)
                                .addGap(101, 101, 101)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(TotalCase)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("คดีอาญา", jPanel6);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขคดี");

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("ปี");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setText("วันที่รับคดี");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("รหัสสถานี");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("ถึง");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTableTraffic.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jTableTraffic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "เลขคดี", "วันที่รับแจ้ง", "วันที่รับคำร้องทุกข์", "ข้อหา", "ชื่อผู้กล่าวหา"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableTraffic.setRowHeight(25);
        jTableTraffic.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTableTraffic.getTableHeader().setOpaque(false);
        jScrollPane1.setViewportView(jTableTraffic);

        jButton4.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jButton4.setText("ตกลง");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(1104, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(31, 31, 31))
        );

        jTabbedPane1.addTab("คดีจราจร", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
        for (int i = 0; i < jTableCrime.getRowCount(); i++) {
	Boolean chked = Boolean.valueOf(jTableCrime.getValueAt(i, 0)
			.toString());
	String casno = jTableCrime.getValueAt(i, 2).toString();
        String casyear = jTableCrime.getValueAt(i, 3).toString();
        String orgcode=jLabelorgcode.getText();
         String user=usernamelabel.getText();
         String idcard=idcardlabel.getText();
        String nameor=orgnamelabel.getText();
//        String newnameor="";
//        try{
//         newnameor=URLEncoder.encode(nameor, "UTF-8");
//        }
//        catch(Exception e){
//        
//        }
//            System.out.println("aa:"+nameor);

	if (chked) {
            try{
              Connection c=null;
             c=ConnectDatabase.connect();
            String sqlId="Select caseid,crimecaseno,crimecaseyears,crimecasenoyear from CrimeCase where crimecaseno='"+casno+"' and crimecaseyears='"+casyear+"' and crimecasenoyear='"+casno+"/"+casyear+"'";

            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                String cid=rs.getString("caseid");
               int response = JOptionPane.showConfirmDialog(jPanel6, "คดีที่ "+casno+"/"+casyear+" มีข้อมูลคดีนี้แล้วต้องการบันทึกข้อมูลซ้ำหรือไม่", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
//             con=ConnectDatabase.connect();
         JsonObject jsonInput = new JsonObject();
         jsonInput.addProperty("CrimeCaseNo",casno);
         jsonInput.addProperty("CrimeCaseYear",casyear);
         jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
         jsonInput.addProperty("Usename","98UT01");
         jsonInput.addProperty("PasswordWordgen","eZS5PPB/9zCElUbubieWKoD9pctqrANqhXqK49z");
         jsonInput.addProperty("OrgName",orgnamelabel.getText()); 
         jsonInput.addProperty("Serial","QL789456"); 
         String j=jsonInput.toString();
        update_crime(jsonInput,cid);
     System.out.println(j);

    } 
            }
            else{
              JsonObject jsonInput = new JsonObject();
         jsonInput.addProperty("CrimeCaseNo",casno);
         jsonInput.addProperty("CrimeCaseYear",casyear);
         jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
         jsonInput.addProperty("Usename","98UT01");
         jsonInput.addProperty("PasswordWordgen","eZS5PPB/9zCElUbubieWKoD9pctqrANqhXqK49z");
         jsonInput.addProperty("OrgName",orgnamelabel.getText()); 
         jsonInput.addProperty("Serial","QL789456"); 
         String j=jsonInput.toString();
//         String replaced = j.replace("\"", "\\\"");
//String n="{\"CrimeCaseNo\":\""+casno+"\",\"CrimeCaseYear\":\""+casyear+"\",\"ORG_CODE\":\""+orgcode+"\",\"Usename\":\""+user+"\",\"Idcard\":\""+idcard+"\",\"OrgName\":\""+nameor+"\"}";
//String n="{\"CrimeCaseNo\":\""+casno+"\",\"CrimeCaseYear\":\""+casyear+"\",\"ORG_CODE\":\""+jLabelorgcode.getText()+"\",\"Usename\":\""+usernamelabel.getText()+"\",\"Idcard\":\""+idcardlabel.getText()+"\",\"OrgName\":\""+orgname.getText()+"\"}";

        insert_crime(jsonInput);
//         String j=jsonInput.toString();
     System.out.println(j);
            
            }
            
            }
            catch(Exception ex){
      
            }
//       		JOptionPane.showMessageDialog(null, "ดึงข้อมูลเรียบร้อยแล้ว");
    
           
//		JOptionPane.showMessageDialog(null, dataCol1);
	}
}
         		JOptionPane.showMessageDialog(null, "ดึงข้อมูลเรียบร้อยแล้ว");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
     
            System.out.println("Token:"+MainMenuWord.tk);
            String aa="";
            aa=MainMenuWord.tk;
        

            if(aa == null){
            System.out.println("empty:");
             JFrame frame = new JFrame();
                    JDialog dialog = new JDialog(frame);//frame is owner
                    JFrame asv = (JFrame)(dialog.getParent());
                    asv.removeAll();
               LogInConfirm lc=new LogInConfirm(asv);
                     lc.pack();
                    lc.setLocationRelativeTo(null);
                    lc.setVisible(true);   
                    aa=MainMenuWord.tk;
                System.out.println("new--------"+aa);  
              
          
             jlabeltoken.setText(aa);
                       String timeStart="00:00";
         String timeEnd="23:59";
         JsonObject jsonInput = new JsonObject();
         jsonInput.addProperty("CrimeCaseNo",casenocc.getText());
         jsonInput.addProperty("CrimeCaseYear",caseyearscc.getText());
//         jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
         jsonInput.addProperty("ORG_CODE","");
         jsonInput.addProperty("PasswordWordgen",aa);         
         jsonInput.addProperty("StatusMagenta","Magenta_inActive");
         jsonInput.addProperty("CaseRequestDate","");
         jsonInput.addProperty("CaseRequestDateTo",""); 
         jsonInput.addProperty("CaseAcceptDate",AcceptDate(DateAcceptStart.getJFormattedTextField().getText(),timeStart));
         jsonInput.addProperty("CaseAcceptDateTo",AcceptDate(DateAcceptEnd.getJFormattedTextField().getText(),timeEnd)); 
         
        call_me2(jsonInput);
        TotalCase.setText(jTableCrime.getRowCount()+"");
        }
   try { 
            
         String url=  "http://172.31.191.171:8989/wordgenchecktoken/?PASSWORDWORDGEN="+aa;
             System.out.println("url:"+url);
                  String fff =sendGET(url);
                   JSONObject myResponse = new JSONObject(fff);
                   String statuspasswordgen=myResponse.getString("statuspasswordgen");
                  if(statuspasswordgen.equals("1")){
                                            JFrame frame = new JFrame();
                                          JDialog dialog = new JDialog(frame);//frame is owner
                                          JFrame lcf = (JFrame)(dialog.getParent());
                                          lcf.removeAll();
                                        LogInConfirm lc=new LogInConfirm(lcf);
                                         lc.pack();
                                        lc.setLocationRelativeTo(null);
                                        lc.setVisible(true);  
                                        aa=MainMenuWord.tk;
                  } 
      else if(statuspasswordgen.equals("2")){
          String timeStart="00:00";
         String timeEnd="23:59";
         JsonObject jsonInput = new JsonObject();
         jsonInput.addProperty("CrimeCaseNo",casenocc.getText());
         jsonInput.addProperty("CrimeCaseYear",caseyearscc.getText());
//         jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
         jsonInput.addProperty("ORG_CODE","70028");
         jsonInput.addProperty("PasswordWordgen",aa);         
         jsonInput.addProperty("StatusMagenta","Magenta_inActive");
         jsonInput.addProperty("CaseRequestDate","");
         jsonInput.addProperty("CaseRequestDateTo",""); 
         jsonInput.addProperty("CaseAcceptDate",AcceptDate(DateAcceptStart.getJFormattedTextField().getText(),timeStart));
         jsonInput.addProperty("CaseAcceptDateTo",AcceptDate(DateAcceptEnd.getJFormattedTextField().getText(),timeEnd)); 
         
        call_me2(jsonInput);
        TotalCase.setText(jTableCrime.getRowCount()+"");
                  }
                 
        } catch (Exception e) {
        }
//         String timeStart="00:00";
//         String timeEnd="23:59";
//         JsonObject jsonInput = new JsonObject();
//         jsonInput.addProperty("CrimeCaseNo",casenocc.getText());
//         jsonInput.addProperty("CrimeCaseYear",caseyearscc.getText());
////         jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
//         jsonInput.addProperty("ORG_CODE","70028");
//
////         jsonInput.addProperty("PasswordWordgen",jlabeltoken.getText());
//         jsonInput.addProperty("PasswordWordgen","eZS5PPB/9zCElUbubieWKoD9pctqrANqhXqK49z");         
//         jsonInput.addProperty("StatusMagenta","Magenta_inActive");
//         jsonInput.addProperty("CaseRequestDate","");
//         jsonInput.addProperty("CaseRequestDateTo",""); 
//         jsonInput.addProperty("CaseAcceptDate",AcceptDate(DateAcceptStart.getJFormattedTextField().getText(),timeStart));
//         jsonInput.addProperty("CaseAcceptDateTo",AcceptDate(DateAcceptEnd.getJFormattedTextField().getText(),timeEnd)); 
//         
//        call_me2(jsonInput);
//        TotalCase.setText(jTableCrime.getRowCount()+"");
    }//GEN-LAST:event_jButton5ActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        Change look Jtable From Nimbus to Windows
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                CrimesCaseOverView aa=  new CrimesCaseOverView();
//                    aa.setVisible(true);
//                    aa.setSize ( 1264, 728 );
//        aa.setMinimumSize ( new Dimension ( 1264, 728 ) );
//        aa.setMaximizedBounds ( new Rectangle ( 1264, 728 ) );
            }
        });
        
    }
    public void DataUser(){
    
     try{
              
         con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        Statement stmt2 = con.createStatement();

        String sql = "select * from user";
        String sqlOrg = "select PoliceStartionCode,PoliceStaionShort from PoliceStation";

        ResultSet rs = stmt.executeQuery(sql);
        ResultSet rs2 = stmt2.executeQuery(sqlOrg);
          System.out.println("SQL : "+sql);

        if(rs.next()){
            usernamelabel.setText(rs.getString("Username"));
            idcardlabel.setText(rs.getString("PeopleCard"));
            jlabeltoken.setText(rs.getString("Token"));

        }  
      
        if(rs2.next()){
          jLabelorgcode.setText(rs2.getString("PoliceStartionCode"));
          orgnamelabel.setText(rs2.getString("PoliceStaionShort"));
        } 
        rs.close();
        stmt.close();
        rs2.close();
        stmt2.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static String AcceptDate(String acdate,String actime){
    String formattedDate=null;
     try{
        String dateAccept=acdate+" "+actime;  
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat inputFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        
           Date date = inputFormat.parse(dateAccept);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR, -543);
            Date newDate = c.getTime();
        System.out.println("aaa"+newDate); 
            String ass=inputFormat2.format(newDate);
        Date date2 = inputFormat.parse(ass);      
         formattedDate = outputFormat.format(date2);
        System.out.println(formattedDate);
    }
    catch(Exception ec){
    
    }
    
    return formattedDate;
    
    
    }
    public static String ChangDate(String date){
        String newFormatDate=null;
       try{   Calendar cal;
        SimpleDateFormat formatdate =new SimpleDateFormat("d/MM/yyyy");  
         if(date == null || date.equals("null")|| date.equals("0")){
            newFormatDate="";
        }
         else{
        Date b=formatdate.parse(date);
         cal = Calendar.getInstance();
          cal.setTime(b); 
           SimpleDateFormat dateformat =new SimpleDateFormat("yyyyMMdd");   
         newFormatDate=dateformat.format(cal.getTime());
         }
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    

}
    public void call_me2(JsonObject json){
     try {
                String url = "http://172.31.191.171:8989/ws/CrimeCaseService_Wordgen/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                                "   <soapenv:Header>\n" +
                                "      <exam:authentication>\n" +
                                "         <username>rtp</username>\n" +
                                "         <password>rtp</password>\n" +
                                "      </exam:authentication>\n" +
                                "   </soapenv:Header>\n" +
                                "   <soapenv:Body>\n" +
                                "      <exam:getlist_Crimescase>\n" +
                                "         <INPUT>"+json+"</INPUT>\n" +
                                "      </exam:getlist_Crimescase>\n" +
                                "   </soapenv:Body>\n" +
                                "</soapenv:Envelope>";
                System.out.println("xml:"+xml);
                con.setDoOutput(true);
                     DataOutputStream writer = new DataOutputStream(con.getOutputStream());
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                        
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
             Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
              .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("CrimeCases"); 
               Vector<Vector> tabledata = new Vector<Vector>();
           for (int temp = 0; temp < errNodes.getLength(); temp++) {
        Node nNode = errNodes.item(temp);
//        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode; 
       
//        while(rs.next()){
            Vector row = new Vector();
//          
           
             row.add(false);
               if(eElement.getElementsByTagName("CaseNo").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CaseNo").item(0).getTextContent());
               }
        if(eElement.getElementsByTagName("CrimeCaseNo").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
               }
            if(eElement.getElementsByTagName("CrimeCaseYear").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
               }
              if(eElement.getElementsByTagName("CaseRequestDate").item(0)==null){
               row.add("");
               }
               else{
                    row.add(NewDate(eElement.getElementsByTagName("CaseRequestDate").item(0).getTextContent()));
               }
               if(eElement.getElementsByTagName("DisplayCharge").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplayCharge").item(0).getTextContent());
               }
           
             if(eElement.getElementsByTagName("DisplaySuspectName").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplaySuspectName").item(0).getTextContent());
               }
             if(eElement.getElementsByTagName("DisplayVictimsname").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplayVictimsname").item(0).getTextContent());
               }
                   if(eElement.getElementsByTagName("RecievePoliceOfficer").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("RecievePoliceOfficer").item(0).getTextContent());
               }
                
             tabledata.add(row);
             
//            System.out.println("First Name : " + eElement.getElementsByTagName("DisplaySuspectName").item(0).getTextContent());
        }   
           }
              Vector ColumnName = new Vector();
        ColumnName.add("เลือก");
        ColumnName.add("คดีที่/ปี");
        ColumnName.add("เลขคดี");
        ColumnName.add("ปี");
         ColumnName.add("วันที่รับคำร้องทุกข์");
         ColumnName.add("ข้อหา");
        ColumnName.add("ผู้ต้องหา");
        ColumnName.add("ผู้กล่าวหา");
         ColumnName.add("ผู้รับผิดชอบ");

        


           jTableCrime.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

                } catch (Exception e) {
                System.out.println(e);
                }
     
                }

    public static void insert_crime(JsonObject a){
     try {
             
                
                 String url = "http://172.31.191.171:8989/ws/CrimeCaseService_Wordgen_Import/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml;charset=UTF-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                "   <soapenv:Header>\n" +
                "      <exam:authentication>\n" +
                "         <username>rtp</username>\n" +
                "         <password>rtp</password>\n" +
                "      </exam:authentication>\n" +
                "   </soapenv:Header>\n" +
                "   <soapenv:Body>\n" +
                "      <exam:CrimesCaseDetail>\n" +
                "         <INPUT>"+a+"</INPUT>\n" +
                "      </exam:CrimesCaseDetail>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
                System.out.println(xml);
                    con.setDoOutput(true);
                  DataOutputStream writer = new DataOutputStream(con.getOutputStream());
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("Person");
               	       NodeList errNodes2 = doc.getElementsByTagName("CrimeCase");
                        Connection conn=null;
                                                Connection conn2=null;

               conn=ConnectDatabase.connect();
                              conn2=ConnectDatabase.connect();

                       if (errNodes2.getLength() > 0) {
            Element err = (Element)errNodes2.item(0);
         String insertCrime="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
                       + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd,ActionCodeCase,ChargeCodeCase)\n"
                       + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
         String insertCharge="insert into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note)\n"
                       + "VALUES (?,?,?,?,?)";
          String insertChargeCase="insert into ChargeCase(ChargeCodeCase,ChargeNameCase,LawCase,RateOfPenaltyCase,NoteCase,ChargeCaseId)\n"
                       + "VALUES (?,?,?,?,?,?)";
        
      String insertActionsCase="insert into ActionsCase(ActionCode,ActionCrimes,ActionDetail,ActionNote)\n"
                       + "VALUES (?,?,?,?)";
          String insertActionsCaseData="insert into ActionsCaseData(ActionCodeCase,ActionCrimesCase,ActionDetailCase,ActionNoteCase,ActionCaseId)\n"
                       + "VALUES (?,?,?,?,?)";
       try {
                    
                         PreparedStatement pst=null;
                         PreparedStatement pst1=null;
                         PreparedStatement pst2=null;
                          PreparedStatement pst3=null;
                         PreparedStatement pst4=null;


                        pst=conn.prepareStatement(insertCrime);
                        pst.setString(1, IdCase());
                        pst.setString(2, "คดีอาญา");
                        pst.setString(3, err.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
                        pst.setString(4,  err.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
                        pst.setString(5,  err.getElementsByTagName("CaseNo").item(0).getTextContent());
                        pst.setString(6, NewDate( err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(7,  NewTime(err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(8,  NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(9,   NewTime(err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(10,  NewDate( err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(11,  NewTime(err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(12,   NewDate( err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                        pst.setString(13,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                         pst.setString(14,  idAction()); 
                          pst.setString(15,  idCharge()); 
//                        pst.setString(6,  err.getElementsByTagName("Birthday").item(0).getTextContent()); 
                     pst.execute();
                     pst.close(); 
                     
                        pst1=conn2.prepareStatement(insertActionsCase);
                        pst1.setString(1, idAction());
                        pst1.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst1.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst1.setString(4, "");     
                                      System.out.println("addddddddddddd:"+idAction());  

                        pst1.execute();
                     pst1.close(); 
                     
                     pst2=conn.prepareStatement(insertActionsCaseData);
                        pst2.setString(1, idActionCase());
                        pst2.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst2.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst2.setString(4, "");
                         pst2.setString(5, IdCasePerson());  
                        pst2.execute();
                     pst2.close(); 
                     
                      pst3=conn.prepareStatement(insertCharge);
                        pst3.setString(1, idCharge());
                        pst3.setString(2, err.getElementsByTagName("DisplayCharge").item(0).getTextContent().replace("1) ", ""));
                        pst3.setString(3, "");
                        pst3.setString(4, "");
                         pst3.setString(5, "");  
                        pst3.execute();
                     pst3.close(); 
                     
                     pst4=conn.prepareStatement(insertChargeCase);
                        pst4.setString(1, idChargeCase());
                        pst4.setString(2, err.getElementsByTagName("DisplayCharge").item(0).getTextContent().replace("1) ", ""));
                        pst4.setString(3, "");
                        pst4.setString(4, "");
                         pst4.setString(5, ""); 
                        pst4.setString(6, IdCasePerson());  

                        pst4.execute();
                     pst4.close(); 
                     
                       System.out.println("success");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }
	} else { 
		     // success
         }
           for (int temp = 0; temp < errNodes.getLength(); temp++) {

        Node nNode = errNodes.item(temp);

        

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element p = (Element) nNode; 

//    System.out.println("First Name : " +eElement.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
       String insertPerson="insert into Person(PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                              + "Age,TypePerson,FatherFullName,MotherFullName,Race,Religion,Nationality,Occupation,ArrestDateTime,CaseIdPerson)\n"
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
         try {
                        int order=temp+1;
                         PreparedStatement pst2=null;
                        
                        pst2=conn.prepareStatement(insertPerson);
//               if(p.getElementsByTagName("PeopleRegistrationID").item(0)==null){
//               pst2.setString(1,"");
//               }
//               else{
//                    pst2.setString(1,p.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
//               }
                pst2.setString(1,CheckNull(p, "PeopleRegistrationID"));
                 pst2.setString(2,CheckNull(p, "FullNamePerson"));
                 if(p.getElementsByTagName("Birthday").item(0)==null){
               pst2.setString(3,"");
               }
               else{
                    pst2.setString(3,NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
               }

                if(p.getElementsByTagName("Gender").item(0)==null){
               pst2.setString(4,"");
               }
               else{
                    pst2.setString(4,NewGender(p.getElementsByTagName("Gender").item(0).getTextContent()));
               }
              pst2.setString(5,CheckNull(p, "Age"));
              pst2.setString(6,NewTypePerson(CheckNull(p, "StatusVictimOrSuspect")));
              pst2.setString(7,CheckNull(p, "FatherName"));
              pst2.setString(8,CheckNull(p, "MotherName"));
              pst2.setString(9,CheckNull(p, "Race"));
              pst2.setString(10,CheckNull(p, "Religion"));
              pst2.setString(11,CheckNull(p, "Nationality"));
              pst2.setString(12,NewOccupation(CheckNull(p, "Occupation")));
               if(p.getElementsByTagName("ArrestedDate").item(0)==null){
               pst2.setString(13,"");
               }
               else{
                    pst2.setString(13,NewDateTime(p.getElementsByTagName("ArrestedDate").item(0).getTextContent()));
               }  
               pst2.setString(14,  IdCasePerson()); 

                     pst2.execute();
                     pst2.close();   
                      System.out.println("success Person");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }

        }
           }

                } catch (Exception e) {
                System.out.println(e);
                }
     
                }
    public static void update_crime(JsonObject a,String caseid){
     try {
             
                
                 String url = "http://172.31.191.171:8989/ws/CrimeCaseService_Wordgen_Import/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml;charset=UTF-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                "   <soapenv:Header>\n" +
                "      <exam:authentication>\n" +
                "         <username>rtp</username>\n" +
                "         <password>rtp</password>\n" +
                "      </exam:authentication>\n" +
                "   </soapenv:Header>\n" +
                "   <soapenv:Body>\n" +
                "      <exam:CrimesCaseDetail>\n" +
                "         <INPUT>"+a+"</INPUT>\n" +
                "      </exam:CrimesCaseDetail>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
                System.out.println(xml);
                    con.setDoOutput(true);
                  DataOutputStream writer = new DataOutputStream(con.getOutputStream());
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("Person");
               	       NodeList errNodes2 = doc.getElementsByTagName("CrimeCase");
                        Connection conn=null;
                                                Connection conn2=null;

               conn=ConnectDatabase.connect();
                              conn2=ConnectDatabase.connect();

                       if (errNodes2.getLength() > 0) {
            Element err = (Element)errNodes2.item(0);
            String sql = "DELETE FROM CrimeCase WHERE CrimeCase.CaseId='"+caseid+"';\n"+
                             "DELETE FROM RecordInquiry WHERE caseidrecord='"+caseid+"';\n"+
                             "DELETE FROM Person WHERE caseidperson='"+caseid+"';\n"+
                             "DELETE FROM ChargeCase WHERE ChargeCaseId='"+caseid+"';\n"+
                             "DELETE FROM RecordInquiry WHERE CaseIdRecord='"+caseid+"';\n"+
                             "DELETE FROM ActionsCaseData WHERE ActionCaseId='"+caseid+"';";

       try {               
           Connection cond = ConnectDatabase.connect();
//                System.out.println("Delete:"+sql);
                Statement  stmt = cond.createStatement();
                      stmt.executeUpdate(sql);
                    stmt.close();
                    
                         PreparedStatement pst=null;
                         PreparedStatement pst1=null;
                         PreparedStatement pst2=null;
                          PreparedStatement pst3=null;
                         PreparedStatement pst4=null;


//                        pst=conn.prepareStatement(insertActionsCase);
//                        pst.setString(1, "คดีอาญา");
//                        pst.setString(2, err.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
//                        pst.setString(3,  err.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
//                        pst.setString(4,  err.getElementsByTagName("CaseNo").item(0).getTextContent());
//                        pst.setString(5, NewDate( err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
//                        pst.setString(6,  NewTime(err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
//                        pst.setString(7,  NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
//                        pst.setString(8,   NewTime(err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
//                        pst.setString(9,  NewDate( err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
//                        pst.setString(10,  NewTime(err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
//                        pst.setString(11,   NewDate( err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
//                        pst.setString(12,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
//                         pst.setString(13,  idAction()); 
//                         pst.setString(14,  idCharge()); 
//                        pst.setString(6,  err.getElementsByTagName("Birthday").item(0).getTextContent()); 
//                     pst.execute();
//                     pst.close(); 
                     
//                        pst1=conn2.prepareStatement(insertActionsCase);
//                        pst1.setString(1, idAction());
//                        pst1.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst1.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst1.setString(4, "");     
//                                      System.out.println("addddddddddddd:"+idAction());  
//
//                        pst1.execute();
//                     pst1.close(); 
//                     
//                     pst2=conn.prepareStatement(insertActionsCaseData);
//                        pst2.setString(1, idActionCase());
//                        pst2.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst2.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst2.setString(4, "");
//                         pst2.setString(5, IdCasePerson());  
//                        pst2.execute();
//                     pst2.close(); 
//                     
//                      pst3=conn.prepareStatement(insertCharge);
//                        pst3.setString(1, idCharge());
//                        pst3.setString(2, err.getElementsByTagName("DisplayCharge").item(0).getTextContent().replace("1) ", ""));
//                        pst3.setString(3, "");
//                        pst3.setString(4, "");
//                         pst3.setString(5, "");  
//                        pst3.execute();
//                     pst3.close(); 
//                     
//                     pst4=conn.prepareStatement(insertChargeCase);
//                        pst4.setString(1, idChargeCase());
//                        pst4.setString(2, err.getElementsByTagName("DisplayCharge").item(0).getTextContent().replace("1) ", ""));
//                        pst4.setString(3, "");
//                        pst4.setString(4, "");
//                         pst4.setString(5, ""); 
//                        pst4.setString(6, IdCasePerson());  
//
//                        pst4.execute();
//                     pst4.close(); 
                     
                       System.out.println("success");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }
	} else { 
		     // success
         }
           for (int temp = 0; temp < errNodes.getLength(); temp++) {

        Node nNode = errNodes.item(temp);

        

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element p = (Element) nNode; 

//    System.out.println("First Name : " +eElement.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
       String insertPerson="insert into Person(PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                              + "Age,TypePerson,FatherFullName,MotherFullName,Race,Religion,Nationality,Occupation,ArrestDateTime,CaseIdPerson)\n"
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
         try {
                        int order=temp+1;
                         PreparedStatement pst2=null;
                        
                        pst2=conn.prepareStatement(insertPerson);
               if(p.getElementsByTagName("PeopleRegistrationID").item(0)==null){
               pst2.setString(1,"");
               }
               else{
                    pst2.setString(1,p.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
               }
               if(p.getElementsByTagName("FullNamePerson").item(0)==null){
               pst2.setString(2,"");
               }
               else{
                    pst2.setString(2,p.getElementsByTagName("FullNamePerson").item(0).getTextContent());
               }
               if(p.getElementsByTagName("Birthday").item(0)==null){
               pst2.setString(3,"");
               }
               else{
                    pst2.setString(3,NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
               }
                if(p.getElementsByTagName("Gender").item(0)==null){
               pst2.setString(4,"");
               }
               else{
                    pst2.setString(4,NewGender(p.getElementsByTagName("Gender").item(0).getTextContent()));
               }
                 if(p.getElementsByTagName("Age").item(0)==null){
               pst2.setString(5,"");
               }
               else{
                    pst2.setString(5,p.getElementsByTagName("Age").item(0).getTextContent());
               }
                 if(p.getElementsByTagName("StatusVictimOrSuspect").item(0)==null){
               pst2.setString(6,"");
               }
               else{
                    pst2.setString(6,NewTypePerson(p.getElementsByTagName("StatusVictimOrSuspect").item(0).getTextContent()));
               }   
                   if(p.getElementsByTagName("FatherName").item(0)==null){
               pst2.setString(7,"");
               }
               else{
                    pst2.setString(7,p.getElementsByTagName("FatherName").item(0).getTextContent());
               }  
                    if(p.getElementsByTagName("MotherName").item(0)==null){
               pst2.setString(8,"");
               }
               else{
                    pst2.setString(8,p.getElementsByTagName("MotherName").item(0).getTextContent());
               }      
                    if(p.getElementsByTagName("Race").item(0)==null){
               pst2.setString(9,"");
               }
               else{
                    pst2.setString(9,p.getElementsByTagName("Race").item(0).getTextContent());
               } 
                     if(p.getElementsByTagName("Religion").item(0)==null){
               pst2.setString(10,"");
               }
               else{
                    pst2.setString(10,p.getElementsByTagName("Religion").item(0).getTextContent());
               }  
               if(p.getElementsByTagName("Nationality").item(0)==null){
               pst2.setString(11,"");
               }
               else{
                    pst2.setString(11,p.getElementsByTagName("Nationality").item(0).getTextContent());
               }  
               if(p.getElementsByTagName("Occupation").item(0)==null){
               pst2.setString(12,"");
               }
               else{
                    pst2.setString(12,NewOccupation(p.getElementsByTagName("Occupation").item(0).getTextContent()));
               }  
               if(p.getElementsByTagName("ArrestedDate").item(0)==null){
               pst2.setString(13,"");
               }
               else{
                    pst2.setString(14,NewDateTime(p.getElementsByTagName("ArrestedDate").item(0).getTextContent()));
               }  
                        pst2.setString(14,  IdCasePerson()); 

                     pst2.execute();
                     pst2.close();   
                      System.out.println("success Person");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }

        }
           }

                } catch (Exception e) {
                System.out.println(e);
                }
     
                }
   public static String IdCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("caseid"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
     public static String IdCasePerson(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("caseid"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
       public static String idChargeCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ChargeCode) chargeid from Charge";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("chargeid"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
        public static String idCharge(){
     
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ChargeCode) chargeid from Charge";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("chargeid"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
         public static String idActionCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ActionCode) accid from ActionsCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("accid"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
         public static String idAction(){
     
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ActionCode) accid from ActionsCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("accid"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
     public static String NewDateTime(String datetimee) throws Exception{
         Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("d/MM/yyyy HH:mm",lc);
          if(datetimee.equals("")){
              String a="";
        return   a;
        
        }
        else{
        Date date = inputFormat.parse(datetimee);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
        }
      }
     public static String NewDate(String dateold) throws Exception{
         Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("d/MM/yyyy",lc);
          if(dateold.equals("")){
              String a="";
        return   a;
        
        }
        else{
        Date date = inputFormat.parse(dateold);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
        }
      }
       public static String NewTime(String dateold) throws Exception{
         Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm",lc);
        if(dateold.equals("")){
        return   "";
        
        }
        else{
        Date date = inputFormat.parse(dateold);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
        }
      }
         public static String DateSend(String dateacc) throws Exception{
         Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm",lc);
        if(dateacc.equals("")){
        return   "";
        
        }
        else{
        Date date = inputFormat.parse(dateacc);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
        }
      }
           public static String NewTypePerson(String type){
          String newType="";
         if(type.equals("Victim")){  
          newType="ผู้กล่าวหา";
         }
         if(type.equals("Suspect")){  
          newType="ผู้ต้องหา";
         }
               return newType;
      }
           public static String NewOccupation(String occ){

         if(occ.equals("ตำรวจ")){  
          return "รับราชการตำรวจ";
         }
         else{return occ;}
//               return newType;
      }
      public static String NewGender(String gender){
          String newGender="";
          if(newGender.equals("")){
          return newGender;
          }
          else{
         if(gender.equals("Male")){  
          newGender="ชาย";
         }
          if(gender.equals("Female")){  
          newGender="หญิง";
         }
          return newGender;
          }
//               return newGender;
      }
 public static String CheckNull(Element nd,String type){
          String newType="";
//           Element p = (Element) nd; 
           System.out.println(type);
//           String newType2="";   
Object a=nd.getElementsByTagName(type).item(0);
System.out.println("sasa:"+a);
          String check=".getTextContent()";
         if(a != null){ 
         
           String newType2=a+check; 
           System.out.println("asdasdasd:"+nd.getElementsByTagName(type).item(0).getTextContent()); 
            return nd.getElementsByTagName(type).item(0).getTextContent();
         }
         else{ 
             System.out.println("ssssssssss:"+newType);        
            return newType;
            
          
                 
         }
      
      }
    private static String sendGET(String GET_URL) throws IOException {
                String a="";
		URL serverUrl = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("Accept-Charset", "UTF-8");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
//			System.out.println(response.toString());
                        return response.toString();
		} else {
			System.out.println("GET request not worked");
                        return null;
		}
                
	}  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalCase;
    private javax.swing.JTextField casenocc;
    private javax.swing.JTextField caseyearscc;
    private javax.swing.JLabel idcardlabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelorgcode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelEnAcc;
    private javax.swing.JPanel jPanelReg;
    private javax.swing.JPanel jPanelReg2;
    private javax.swing.JPanel jPanelStAcc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCrime;
    private javax.swing.JTable jTableTraffic;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    public static javax.swing.JLabel jlabeltoken;
    private javax.swing.JLabel orgnamelabel;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
