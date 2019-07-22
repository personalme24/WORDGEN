/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;



import com.songkhla.document.W1;
import com.songkhla.document.W11;
import com.songkhla.document.W12;
import com.songkhla.document.W13;
import com.songkhla.document.W14;
import com.songkhla.document.W15;
import com.songkhla.document.W16;
import com.songkhla.document.W17;
import com.songkhla.document.W19;
import com.songkhla.document.W2;
import com.songkhla.document.W20;
import com.songkhla.document.W21;
import com.songkhla.document.W25;
import com.songkhla.document.W26;
import com.songkhla.document.W27;
import com.songkhla.document.W28;
import com.songkhla.document.W29;
import com.songkhla.document.W3;
import com.songkhla.document.W30;
import com.songkhla.document.W31;
import com.songkhla.document.W33;
import com.songkhla.document.W34;
import com.songkhla.document.W35;
import com.songkhla.document.W36;
import com.songkhla.document.W37;
import com.songkhla.document.W38;
import com.songkhla.document.W39;
import com.songkhla.document.W4;
import com.songkhla.document.W40;
import com.songkhla.document.W41;
import com.songkhla.document.W43;
import com.songkhla.document.W46;
import com.songkhla.document.W47;
import com.songkhla.document.W48;
import com.songkhla.document.W49;
import com.songkhla.document.W5;
import com.songkhla.document.W50;
import com.songkhla.document.W51;
import com.songkhla.document.W53;
import com.songkhla.document.W6;
import com.songkhla.document.W62;
import com.songkhla.document.W67;
import com.songkhla.document.W69;
import com.songkhla.document.W70;
import com.songkhla.document.W71;
import com.songkhla.document.W8;
import com.songkhla.document.W9;
import com.songkhla.document.W93;
import static com.songkhla.wordgen.ListAccused.jTableAccure;
import static com.songkhla.wordgen.ListAccused.txtCaseNO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;

/**
 *
 * @author Petpilin
 */
public class CrimesCaseEdit extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;;
    boolean isInsert;
    String caseid,caseidLast;
     String caseyear,casetype,caseno,PoliceStaionName;
JDatePickerImpl CaseRequestDateTime,CaseAcceptDate,OccuredDate,Invest_SendCaseDate;
    /**
     * Creates new form CrimesCaseEdit
     */
    public CrimesCaseEdit(JFrame parrent,JSONObject datain){
        super(parrent,true);

           initComponents(); 
            ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
            jScrollPane1.getVerticalScrollBar().setUI(new CustomScrollBarUI());
            jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        ButtonGroup g=new ButtonGroup();
        g.add(jCheckDuringInvest);
        g.add(jCheckSue);
        g.add(jCheckNotSue);
        g.add(jCheckNoInvest);
        g.add(jCheckOtherInvest);

//====================================== Police==========================================
        try{
            
//            String sql="Select crimecasenoyear,crimecaseno,crimecaseyears,CaseType from CrimeCase where CaseId='"+caseid+"'";
//         Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery(sql);  
                
            con=ConnectDatabase.connect();
      
        String sqlDataPoliceStation="SELECT * FROM PoliceStation";
        Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery(sqlDataPoliceStation); 
                
        if(rs1.next()){
         
//             caseyear=rs.getString("crimecaseyears");
//             caseno=rs.getString("crimecaseno");
//             casetype=rs.getString("CaseType");
             PoliceStaionName=rs1.getString("PoliceStaionName");
//             casetype=rs.getString("CaseType");
                    }

        }
        catch(Exception e){
        e.printStackTrace();
        
        }
       
//  ---------------------------------------------Date Filed----------------------------------------------
           UtilDateModel model = new UtilDateModel();
            model.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();        
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
         CaseRequestDateTime = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        CaseRequestDateTime.setTextEditable(true);
        CaseRequestDateTime.setBackground(Color.WHITE);
        jPanel6.setLayout(new FlowLayout());
        jPanel6.add(CaseRequestDateTime);    
        
        UtilDateModel model2 = new UtilDateModel();
            model2.setValue(Calendar.getInstance().getTime());

         JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
        CaseAcceptDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
        CaseAcceptDate.setTextEditable(true);
        CaseAcceptDate.setBackground(Color.WHITE);
        jPanel7.setLayout(new FlowLayout());
        jPanel7.add(CaseAcceptDate);
        
         UtilDateModel model3 = new UtilDateModel();
            model3.setValue(Calendar.getInstance().getTime());
         JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p);
        OccuredDate = new JDatePickerImpl(datePanel3,new DateLabelFormatter());
        OccuredDate.setTextEditable(true);
        OccuredDate.setBackground(Color.WHITE);
        jPanel2.setLayout(new FlowLayout());
        jPanel2.add(OccuredDate);  
        
                UtilDateModel model4 = new UtilDateModel();
            model4.setValue(Calendar.getInstance().getTime());
         JDatePanelImpl datePanel4 = new JDatePanelImpl(model4, p);
        Invest_SendCaseDate = new JDatePickerImpl(datePanel4,new DateLabelFormatter());
        Invest_SendCaseDate.setTextEditable(true);
        Invest_SendCaseDate.setBackground(Color.WHITE);
        jPanelInvestSend.setLayout(new FlowLayout());
        jPanelInvestSend.add(Invest_SendCaseDate);   
//--------------------------------------Date Filed----------------------------------------------


      
       
//        jTextPoliceName.setText(Data.getPolicName());
        jLabelActionCode.setVisible(false);
        jLabelChargeCode.setVisible(true);
        crimecaseid.setVisible(false);
 
            comboInvest();
 
        if(datain!=null){
            try {
                String knowSus=datain.get("StatusKnowSuspect")+"";
                String rt=datain.get("CaseRequestTime")+"";
                String at=datain.get("CaseAcceptTime")+"";
                String ot=datain.get("CaseAcceptTime")+"";
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
                Date timeReq = timeFormat.parse(rt);
                Date timeAcc = timeFormat.parse(at);
                Date timeOccu = timeFormat.parse(ot);
                isInsert=false;
                caseid= "" + datain.get("CaseId");
                crimecaseid.setText(datain.get("CaseId")+"");
                caseyear=datain.get("crimecaseyears")+"";
                caseno=datain.get("crimecaseno")+"";
                casetype=datain.get("CaseType")+"";
//          ID.setText(datain.get("CaseId")+"");
            crimecaseno.setText(datain.get("crimecaseno")+"");
            crimecaseyear.setText(datain.get("crimecaseyears")+"");
            jLabelChargeCode.setText(datain.get("ChargeCode")+"");
            String cn=datain.get("ChargeName")+"";
            if(cn.equals("null")){
            ChargeNameCase.setText("");
            }
            else{
            ChargeNameCase.setText(datain.get("ChargeName")+"");}
//            CaseRequestDateTime.setText(datain.get("CaseRequestDate")+"");
            jTextAccused.setText(datain.get("AccureandOther")+"");
            CourtType.setSelectedItem(datain.get("TypeCourt"));
            CrimeLocation.setText(datain.get("CrimeLocation")+"");
            CrimeLocationDistrict.setText(datain.get("CrimeLocationDistrict")+"");
            CrimeLocationAmphur.setText(datain.get("CrimeLocationAmphur")+"");
            CrimeLocationProvince.setText(datain.get("CrimeLocationProvince")+"");
            CrimeLocationMoo.setText(datain.get("CrimeLocationMoo")+"");
            CrimeLocationRoad.setText(datain.get("CrimeLocationRoad")+"");
            CrimeLocationSoi.setText(datain.get("CrimeLocationSoi")+"");            
            jComboPoliceName.setSelectedItem(datain.get("PoliceNameCase"));
            jTextSuspect.setText(datain.get("SuspectandOther")+"");
            jTextWitness.setText(datain.get("WitnessandOther")+"");
            CaseRequestDateTime.getJFormattedTextField().setText(datain.get("CaseRequestDate")+"");
            CaseRequestTimee.setValue(timeReq);
            CaseAcceptDate.getJFormattedTextField().setText(datain.get("CaseAcceptDate")+"");
            CaseAcceptTimee.setValue(timeAcc);
            DailyNumber.setText(datain.get("DailyNumber")+"");
            String investSta=datain.get("Investigator_Result")+"";
            OccuredDate.getJFormattedTextField().setText(datain.get("OccuredDate")+"");
            OccuredDateTime.setValue(timeOccu);
            jLabelActionCode.setText(datain.get("ActionCode")+"");
            Prosecutor_Result.setText(datain.get("Prosecutor_Result")+"");
            jTextInvestSendtoDepartment.setText(datain.get("Invest_SendtoDepartment")+"");
            Investigator_Number.setText(datain.get("Investigator_Number")+"");
            Invest_SendCaseDate.getJFormattedTextField().setText(datain.get("Invest_SendCaseDate")+"");
            CapitalCrimeCaseNumber.setText(datain.get("CapitalCrimeCaseNumber")+"");
            RecordInvestCase.setText(datain.get("RecordInvestCase")+"");
            if(investSta.equals("อยู่ระหว่างสอบสวน")){
                jCheckDuringInvest.setSelected(true);
            }
             else if(investSta.equals("สั่งฟ้อง")){
                jCheckSue.setSelected(true);
            }
              else  if(investSta.equals("สั่งไม่ฟ้อง")){
                jCheckNotSue.setSelected(true);
            }
              else  if(investSta.equals("งดการสอบสวน")){
                jCheckNoInvest.setSelected(true);
            }
              else  if(investSta.equals("อื่นๆ")){
                jCheckOtherInvest.setSelected(true);
            }
          
            ListAsset.setText(datain.get("AssetList")+"");
             EvidenceRecordCase.setText(datain.get("AssetCode")+"");
           
            String ac=datain.get("ActionCrimes")+"";
            if(ac.equals("null")){
            ActionCrimes.setText("");
            }
            else{
            ActionCrimes.setText(datain.get("ActionCrimes")+"");}
            
            jLabelNumberAcc.setText(datain.get("TotalAcc")+"");
            jLabelNumberSus.setText(datain.get("TotalSus")+"");
            jLabelNumberWitness.setText(datain.get("TotalWitness")+"");
            

            } catch (ParseException ex) {
                Logger.getLogger(CrimesCaseEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
        else{
              jTabbedPane2.setEnabledAt(jTabbedPane2.getTabCount()-1, false);
//            Date date2=new Date();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//            Date date = dateFormat.parse(date2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date date = new Date();
        dateFormat.format(date);
//	System.out.println(dateFormat.format(date));
            caseidLast=IdCase();
           crimecaseid.setText(IdCase());
           caseyear=crimecaseyear.getText();
           caseno=crimecaseno.getText();
           
//           CaseAcceptDate.setDate(date);
//           CaseRequestDateTime.setDate(date);
//           OccuredDate.setDate(date);
           isInsert=true;
          
        }
    
            
    }
//   private class CloseListener implements ActionListener{
//
//    public void actionPerformed(ActionEvent e) {
//        Window win = SwingUtilities.getWindowAncestor((Component) e.getSource());
//        win.dispose();
//    System.out.println("Frame Closed. ");
//    }
//}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CaseType = new javax.swing.JLabel();
        crimecaseid = new javax.swing.JLabel();
        jLabelActionCode = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonCharge = new javax.swing.JButton();
        crimecaseno = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        OccuredDateTime = new javax.swing.JSpinner(sm3);
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ChargeNameCase = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Date date2=new Date();

        SpinnerDateModel sm2=new SpinnerDateModel(date2,null,null,Calendar.HOUR_OF_DAY);
        CaseAcceptTimee = new javax.swing.JSpinner(sm2);
        CrimeLocation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ActionCrimes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Date date=new Date();

        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        CaseRequestTimee = new javax.swing.JSpinner(sm);
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DailyNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        crimecaseyear = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButtonAction = new javax.swing.JButton();
        CourtType = new javax.swing.JComboBox<>();
        ListAsset = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jButtonAddAsset = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        EvidenceRecordCase = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CrimeLocationAmphur = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CrimeLocationProvince = new javax.swing.JTextField();
        CrimeLocationDistrict = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButtonAddInvest = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        RecordInvestCase = new javax.swing.JTextField();
        jComboPoliceName = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CrimeLocationRoad = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        CrimeLocationMoo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        CrimeLocationSoi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextAccused = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButtonAccured = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jTextSuspect = new javax.swing.JTextField();
        jButtonSuspect = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jButtonWitness = new javax.swing.JButton();
        jTextWitness = new javax.swing.JTextField();
        Investigator_Number = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        CourtResult = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jTextInvestSendtoDepartment = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanelInvestSend = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabelNumberAcc = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jCheckDuringInvest = new javax.swing.JRadioButton();
        jCheckSue = new javax.swing.JRadioButton();
        jCheckNotSue = new javax.swing.JRadioButton();
        jCheckNoInvest = new javax.swing.JRadioButton();
        jCheckOtherInvest = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CapitalCrimeCaseNumber = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Prosecutor_Result = new javax.swing.JTextArea();
        jLabelNumberSus = new javax.swing.JLabel();
        jLabelNumberWitness = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jButtonPrintDoc = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jCheckW93 = new javax.swing.JCheckBox();
        jCheckBox64 = new javax.swing.JCheckBox();
        jCheckW34 = new javax.swing.JCheckBox();
        jCheckW38 = new javax.swing.JCheckBox();
        jCheckW53 = new javax.swing.JCheckBox();
        jCheckW4 = new javax.swing.JCheckBox();
        jCheckW6 = new javax.swing.JCheckBox();
        jCheckW43 = new javax.swing.JCheckBox();
        jCheckW20 = new javax.swing.JCheckBox();
        jCheckW5 = new javax.swing.JCheckBox();
        jCheckW29 = new javax.swing.JCheckBox();
        jCheckW14 = new javax.swing.JCheckBox();
        jCheckW1 = new javax.swing.JCheckBox();
        jCheckW41 = new javax.swing.JCheckBox();
        jCheckW8 = new javax.swing.JCheckBox();
        jCheckW71 = new javax.swing.JCheckBox();
        jCheckW62 = new javax.swing.JCheckBox();
        jCheckW51 = new javax.swing.JCheckBox();
        jCheckW50 = new javax.swing.JCheckBox();
        jCheckW16 = new javax.swing.JCheckBox();
        jCheckW17 = new javax.swing.JCheckBox();
        jCheckW11 = new javax.swing.JCheckBox();
        jCheckW69 = new javax.swing.JCheckBox();
        jCheckW47 = new javax.swing.JCheckBox();
        jCheckW9 = new javax.swing.JCheckBox();
        jCheckW59 = new javax.swing.JCheckBox();
        jCheckW70 = new javax.swing.JCheckBox();
        jCheckW3 = new javax.swing.JCheckBox();
        jCheckW48 = new javax.swing.JCheckBox();
        jCheckW21 = new javax.swing.JCheckBox();
        jCheckW15 = new javax.swing.JCheckBox();
        jCheckW2 = new javax.swing.JCheckBox();
        jCheckW26 = new javax.swing.JCheckBox();
        jCheckW40 = new javax.swing.JCheckBox();
        jCheckW28 = new javax.swing.JCheckBox();
        jCheckW30 = new javax.swing.JCheckBox();
        jCheckW67 = new javax.swing.JCheckBox();
        jCheckW36 = new javax.swing.JCheckBox();
        jCheckW31 = new javax.swing.JCheckBox();
        jCheckW46 = new javax.swing.JCheckBox();
        jCheckW37 = new javax.swing.JCheckBox();
        jCheckW35 = new javax.swing.JCheckBox();
        jCheckW39 = new javax.swing.JCheckBox();
        jCheckW13 = new javax.swing.JCheckBox();
        jCheckW49 = new javax.swing.JCheckBox();
        jCheckW25 = new javax.swing.JCheckBox();
        jCheckW33 = new javax.swing.JCheckBox();
        jCheckW19 = new javax.swing.JCheckBox();
        jCheckW68 = new javax.swing.JCheckBox();
        jCheckBox50 = new javax.swing.JCheckBox();
        jCheckW27 = new javax.swing.JCheckBox();
        jCheckW12 = new javax.swing.JCheckBox();
        jLabelChargeCode = new javax.swing.JLabel();
        jButtonSaveCase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1214, 720));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("บันทึก/แก้ไข ข้อมูล");

        CaseType.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        CaseType.setForeground(new java.awt.Color(255, 255, 255));
        CaseType.setText("คดีอาญา");

        crimecaseid.setText("NoCaseId");

        jLabelActionCode.setText("jLabel2");

        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\Master\\home.png")); // NOI18N
        jButton2.setText("เมนูหลัก");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CaseType)
                .addGap(18, 18, 18)
                .addComponent(crimecaseid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActionCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(67, 67, 67))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CaseType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crimecaseid)
                    .addComponent(jLabelActionCode)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jTabbedPane2.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCharge.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonCharge.setText("ข้อหา");
        jButtonCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargeActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 110, -1));

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(crimecaseno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 60, -1));

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("ปจว.ข้อ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 30));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("/");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, 30));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(OccuredDateTime, "HH:mm");
        OccuredDateTime.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        jPanel1.add(OccuredDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 100, 30));

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("สถานที่เกิดเหตุ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 90, 30));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("เวลาที่เกิดเหตุ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, -1, 30));

        ChargeNameCase.setEditable(false);
        ChargeNameCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(ChargeNameCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 330, -1));

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("วันที่รับแจ้ง");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        JSpinner.DateEditor te = new JSpinner.DateEditor(CaseAcceptTimee, "HH:mm");
        CaseAcceptTimee.setEditor(te);
        //jSpinner1.setValue(new Date());
        CaseAcceptTimee.setPreferredSize(new java.awt.Dimension(29, 25));
        jPanel1.add(CaseAcceptTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 100, 32));

        CrimeLocation.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(CrimeLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 440, -1));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("ข้อหา");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("เวลารับคำร้องทุกข์");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, 30));

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("วันที่เกิดเหตุ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 30));

        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(ActionCrimes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 330, -1));

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เวลารับแจ้ง");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, 30));

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(CaseRequestTimee, "HH:mm");
        CaseRequestTimee.setEditor(timeEditor);
        //jSpinner1.setValue(new Date());
        jPanel1.add(CaseRequestTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 100, 30));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("พฤติการณ์คดี");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 77, 30));

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("วันที่รับคำร้องทุกข์");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        DailyNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(DailyNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 110, -1));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("อำนาจศาล");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 50, 30));

        crimecaseyear.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(crimecaseyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 70, -1));

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("เลขคดี");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        jButtonAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAction.setText("พฤติการณ์คดี");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 110, -1));

        CourtType.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลอาญา", "ศาลแขวง", "ศาลเยาวชน", "ศาลทหาร" }));
        CourtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourtTypeActionPerformed(evt);
            }
        });
        jPanel1.add(CourtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 200, -1));

        ListAsset.setEditable(false);
        ListAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ListAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListAssetActionPerformed(evt);
            }
        });
        jPanel1.add(ListAsset, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 190, -1));

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel29.setText("เลขบัญชีของกลาง");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, -1, 30));

        jButtonAddAsset.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddAsset.setIcon(new javax.swing.ImageIcon("D:\\Master\\edit (1).png")); // NOI18N
        jButtonAddAsset.setActionCommand("พยาน");
        jButtonAddAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAssetActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddAsset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1093, 240, 40, 30));

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel28.setText("รายการทรัพย์");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 85, 30));

        EvidenceRecordCase.setEditable(false);
        EvidenceRecordCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(EvidenceRecordCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 82, -1));

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton1.setText("ต/อ/จ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 180, 70, -1));

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("ตำบล");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, 30));

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("อำเภอ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, -1, 30));

        CrimeLocationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(CrimeLocationAmphur, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 200, -1));

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("จังหวัด");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, 30));

        CrimeLocationProvince.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(CrimeLocationProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 363, -1));

        CrimeLocationDistrict.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(CrimeLocationDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 194, -1));

        jLabel45.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel45.setText("พนักงานสอบสวน");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, -1, 30));

        jButtonAddInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddInvest.setIcon(new javax.swing.ImageIcon("D:\\Master\\edit (1).png")); // NOI18N
        jButtonAddInvest.setActionCommand("พยาน");
        jButtonAddInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddInvestActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddInvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 320, 40, 30));

        jLabel46.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel46.setText("บันทึกพนักงานสอบสวน");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 139, -1));

        RecordInvestCase.setEditable(false);
        RecordInvestCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(RecordInvestCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 320, 328, 32));

        jComboPoliceName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jComboPoliceName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));
        jPanel1.add(jComboPoliceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 330, 30));

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("ถนน");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, -1, -1));

        CrimeLocationRoad.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(CrimeLocationRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 130, 31));

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("หมู่ที่");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        CrimeLocationMoo.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CrimeLocationMoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrimeLocationMooActionPerformed(evt);
            }
        });
        jPanel1.add(CrimeLocationMoo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 71, 29));

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("ตรอก/ซอย");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        CrimeLocationSoi.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(CrimeLocationSoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 128, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 220, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 220, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 220, -1));

        jTabbedPane2.addTab("ข้อมูลคดี", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTextAccused.setEditable(false);
        jTextAccused.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel19.setText("ผู้กล่าวหา");

        jButtonAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAccured.setIcon(new javax.swing.ImageIcon("D:\\Master\\edit (1).png")); // NOI18N
        jButtonAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccuredActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("ผู้ต้องหา");

        jTextSuspect.setEditable(false);
        jTextSuspect.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSuspect.setIcon(new javax.swing.ImageIcon("D:\\Master\\edit (1).png")); // NOI18N
        jButtonSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuspectActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setText("พยานและบุคคลอื่น");

        jButtonWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonWitness.setIcon(new javax.swing.ImageIcon("D:\\Master\\edit (1).png")); // NOI18N
        jButtonWitness.setActionCommand("พยาน");
        jButtonWitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWitnessActionPerformed(evt);
            }
        });

        jTextWitness.setEditable(false);
        jTextWitness.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        Investigator_Number.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        CourtResult.setColumns(20);
        CourtResult.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CourtResult.setLineWrap(true);
        CourtResult.setRows(3);
        CourtResult.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลคดีชั้นศาล", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 22))); // NOI18N
        jScrollPane2.setViewportView(CourtResult);

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel41.setText("วันเดือนปีที่ส่ง");

        jTextInvestSendtoDepartment.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel43.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel43.setText("ส่งสำนวนไปยัง");

        jLabel44.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel44.setText("เลขที่ส่ง");

        javax.swing.GroupLayout jPanelInvestSendLayout = new javax.swing.GroupLayout(jPanelInvestSend);
        jPanelInvestSend.setLayout(jPanelInvestSendLayout);
        jPanelInvestSendLayout.setHorizontalGroup(
            jPanelInvestSendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelInvestSendLayout.setVerticalGroup(
            jPanelInvestSendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("จำนวน");

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("จำนวน");

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("จำนวน");

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("คน");

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("คน");

        jLabelNumberAcc.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelNumberAcc.setText("0");

        jPanel9.setBackground(java.awt.Color.white);
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลคดีชั้นพนักงานสอบสวน", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 22))); // NOI18N

        jCheckDuringInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckDuringInvest.setText("อยู่ระหว่างสอบสวน");

        jCheckSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckSue.setText("สั่งฟ้อง");

        jCheckNotSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckNotSue.setText("สั่งไม่ฟ้อง");

        jCheckNoInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckNoInvest.setText("งดการสอบสวน");

        jCheckOtherInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckOtherInvest.setText("อื่นๆ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckDuringInvest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckNoInvest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckSue)
                    .addComponent(jCheckOtherInvest))
                .addGap(73, 73, 73)
                .addComponent(jCheckNotSue)
                .addGap(38, 38, 38))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckDuringInvest)
                    .addComponent(jCheckSue)
                    .addComponent(jCheckNotSue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckNoInvest)
                    .addComponent(jCheckOtherInvest))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("คน");

        CapitalCrimeCaseNumber.setColumns(20);
        CapitalCrimeCaseNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CapitalCrimeCaseNumber.setLineWrap(true);
        CapitalCrimeCaseNumber.setRows(3);
        CapitalCrimeCaseNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "หมายเหตุ-เลขคดีอุกฉกรรจ์", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 22))); // NOI18N
        jScrollPane3.setViewportView(CapitalCrimeCaseNumber);

        Prosecutor_Result.setColumns(20);
        Prosecutor_Result.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Prosecutor_Result.setLineWrap(true);
        Prosecutor_Result.setRows(3);
        Prosecutor_Result.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลคดีชั้นอัยการ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 22))); // NOI18N
        jScrollPane4.setViewportView(Prosecutor_Result);

        jLabelNumberSus.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelNumberSus.setText("0");

        jLabelNumberWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelNumberWitness.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextSuspect, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(jTextAccused))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNumberAcc))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNumberSus)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButtonWitness))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel31))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(Investigator_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelInvestSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNumberWitness)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel27))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(43, 43, 43))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextAccused, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(jLabelNumberAcc)
                                .addComponent(jLabel31))
                            .addComponent(jButtonAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel30)
                                .addComponent(jLabelNumberSus))
                            .addComponent(jButtonSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26)
                                .addComponent(jLabelNumberWitness)
                                .addComponent(jLabel27))
                            .addComponent(jButtonWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelInvestSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Investigator_Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane2.addTab("ข้อมูลประกอบสำนวนคดี", jPanel5);

        jScrollPane1.setOpaque(false);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jButtonPrintDoc.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonPrintDoc.setText("พิมพ์เอกสาร");
        jButtonPrintDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintDocActionPerformed(evt);
            }
        });

        jLabel32.setText("jLabel32");

        jCheckW93.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW93.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW93.setText("หมายจับ");
        jCheckW93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW93ActionPerformed(evt);
            }
        });

        jCheckBox64.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox64.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckBox64.setText("บัญชีสำนวนการสอบสวน");

        jCheckW34.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW34.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้น");

        jCheckW38.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW38.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW38.setText("หมายเรียกผู้ต้องหา");

        jCheckW53.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW53.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW53.setText("หนังสือแจ้งความคืบหน้าคดีอาญา");

        jCheckW4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW4.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้องหรือไม่สั่งฟ้อง");

        jCheckW6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW6.setText("รายงานการสอบสวนสำนวนคดีไม่ปรากฎว่าผู้ใดเป็นผู้กระทำผิด");

        jCheckW43.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW43.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW43.setText("บันทึกเสนอสัญญาประกันสิ่งของ");

        jCheckW20.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckW20.setText("บันทึกการนำชี้ที่เกิดเหตุประกอบคำรับสารภาพ");

        jCheckW5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW5.setText("รายงานการสอบสวน");

        jCheckW29.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW29.setText("บันทึกการชี้ตัวผู้ต้องหา");

        jCheckW14.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW14.setText("บัญชีทรัพย์ถูกประทุษร้ายไม่ได้คืน");

        jCheckW1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW1.setText("บันทึกการตรวจสำนวนการสอบสวน");
        jCheckW1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckW1MouseClicked(evt);
            }
        });
        jCheckW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW1ActionPerformed(evt);
            }
        });

        jCheckW41.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW41.setText("บันทึกการตกลงค่าเสียหาย");
        jCheckW41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW41ActionPerformed(evt);
            }
        });

        jCheckW8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW8.setText("บันทึกคำให้การผู้กล่าวหา หรือพยาน");

        jCheckW71.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW71.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckW71.setText("คำร้องและสัญญาประกัน");

        jCheckW62.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW62.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW62.setText("บันทึกการควบคุมผู้ต้องหา");

        jCheckW51.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW51.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW51.setText("หนังสือขอส่งตัวคนต่างด้าวผลักดันฯ");

        jCheckW50.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW50.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW50.setText("หนังสือขอส่งรายละเอียดเกี่ยวกับคนต่างด้าวถูกกักขังหรือกักขังแทนค่าปรับ");

        jCheckW16.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW16.setText("บันทึกพนักงานสอบสวน");

        jCheckW17.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW17.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีอาญา");

        jCheckW11.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW11.setText("บัญชีของกลางคดีอาญา");

        jCheckW69.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW69.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW69.setText("คำร้องขอฝากขัง");
        jCheckW69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW69ActionPerformed(evt);
            }
        });

        jCheckW47.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW47.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW47.setText("หนังสือรายงานคนต่างด้าวเป็นผู้เสียหายในคดีอุกฉกรรจ์หรือตายโดยธรรมชาติ");

        jCheckW9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW9.setText("บันทึกคำให้การผู้ต้องหา");

        jCheckW59.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW59.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW59.setText("แบบรูปพรรณรถยนต์หรือรถจักรยานยนต์ที่ถูกโจรกรรม");

        jCheckW70.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW70.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckW70.setText("บันทึกเสนอสัญญาประกัน");

        jCheckW3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW3.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้อง แต่ยังไม่ได้ตัวผู้ต้องหา");

        jCheckW48.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW48.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW48.setText("หนังสือรายงานคนต่างด้าวกระทำความผิดและถูกจับกุมตัวดำเนินคดี");

        jCheckW21.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW21.setText("ใบนำส่งผู้บาดเจ็บหรือศพ");

        jCheckW15.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW15.setText("บัญชีทรัพย์ที่ถูกเพลิงไหม้");

        jCheckW2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW2.setText("หนังสือส่งสำนวนคดีที่เห็นควรงดหรือให้งดการสอบสวน");
        jCheckW2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckW2MouseClicked(evt);
            }
        });

        jCheckW26.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW26.setText("หนังสือส่งยาเสพติดของกลางไปตรวจพิสูจน์");

        jCheckW40.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW40.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW40.setText("บันทึกการแจ้งสิทธิ์ตามพระราชบัญญติค่าตอบแทนผู้เสียหาย และค่าทดแทน \n");
        jCheckW40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW40ActionPerformed(evt);
            }
        });

        jCheckW28.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW28.setText("บันทึกการตรวจสภาพสภาพรถยนต์");

        jCheckW30.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW30.setText("บันทึกการชี้รูปผู้ต้องหา");

        jCheckW67.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW67.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW67.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่ 1");

        jCheckW36.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW36.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW36.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW31.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW31.setText("บันทึกการจับกุม");

        jCheckW46.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW46.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW46.setText("หนังสือแจ้งการขอประกันสิ่งของไปดูแลรักษาหรือใช้ประโยชน์");

        jCheckW37.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW37.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jCheckW37.setText("ตำหนิรูปพรรณผู้กระทำความผิด");
        jCheckW37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW37ActionPerformed(evt);
            }
        });

        jCheckW35.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW35.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW35.setText("บัญชีการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW39.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW39.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW39.setText("หมายเรียกพยาน");

        jCheckW13.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW13.setText("บัญชีทรัพย์ถูกประทุษร้ายได้คืน");

        jCheckW49.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW49.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW49.setText("หนังสือขอส่งตัวคนต่างด้าว");

        jCheckW25.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW25.setText("หนังสือส่งของกลางไปตรวจพิสูจน์");

        jCheckW33.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW33.setText("บันทึกการตรวจค้น");

        jCheckW19.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW19.setText("แผนที่สังเขปแสดงสถานที่เกิดเหตุ");
        jCheckW19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckW19MouseClicked(evt);
            }
        });
        jCheckW19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW19ActionPerformed(evt);
            }
        });

        jCheckW68.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW68.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW68.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่.....");
        jCheckW68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW68ActionPerformed(evt);
            }
        });

        jCheckBox50.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox50.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckBox50.setText("หนังสือขอให้ตรวจสอบหนังสือเดินทางฯ ของบุคคลต่างด้าว");

        jCheckW27.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW27.setText("ฉลากปิดภาชนะบรรจุยาเสพติด");

        jCheckW12.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW12.setText("บัญชีทรัพย์ถูกประทุษร้าย");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckW2)
                            .addComponent(jCheckW3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW43))
                            .addComponent(jCheckW41)
                            .addComponent(jCheckW27))
                        .addGap(128, 128, 128)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckW59)
                            .addComponent(jCheckW46, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW40))
                        .addContainerGap(415, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckW6)
                            .addComponent(jCheckW5, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW8)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCheckW13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckW12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckW11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckW9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCheckW16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckW15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckW14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckW4, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW39, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckW33)
                            .addComponent(jCheckW26)
                            .addComponent(jCheckW28)
                            .addComponent(jCheckW29)
                            .addComponent(jCheckW30)
                            .addComponent(jCheckW31)
                            .addComponent(jCheckW36)
                            .addComponent(jCheckW38)
                            .addComponent(jCheckW35)
                            .addComponent(jCheckW34)
                            .addComponent(jCheckW93, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckW50)
                            .addComponent(jCheckW51)
                            .addComponent(jCheckW48, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox50)
                            .addComponent(jCheckW53, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW62, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW49)
                            .addComponent(jCheckW17, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW19, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckW21)
                            .addComponent(jCheckW47))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckW71)
                                    .addComponent(jCheckBox64)
                                    .addComponent(jCheckW37)
                                    .addComponent(jCheckW20)
                                    .addComponent(jCheckW69, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckW67, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckW70, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckW68))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPrintDoc)
                                .addGap(41, 41, 41))))))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jCheckW1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1273, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckW27)
                            .addComponent(jCheckW59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckW2)
                            .addComponent(jCheckW41)
                            .addComponent(jCheckW40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckW3)
                            .addComponent(jCheckW43)
                            .addComponent(jCheckW46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jCheckW4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jCheckW28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW29))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(jCheckW8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jCheckW5)
                                                    .addComponent(jCheckW30)))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jCheckW9)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW11)
                                            .addComponent(jCheckW31))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW12)
                                            .addComponent(jCheckW35))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW13)
                                            .addComponent(jCheckW36))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW14)
                                            .addComponent(jCheckW34))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW15)
                                            .addComponent(jCheckW38))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW16)
                                            .addComponent(jCheckW93))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckW39)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckW33)
                                        .addComponent(jButtonPrintDoc)
                                        .addComponent(jLabel32))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckW47)
                                    .addComponent(jCheckW25))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckW26)
                                        .addComponent(jCheckW48))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jCheckW50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW51)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW53)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW49)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckW17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW19))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jCheckW71)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckBox64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW70)))
                .addGap(0, 0, 0))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jCheckW1)
                    .addContainerGap(476, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel8);

        jTabbedPane2.addTab("รายงาน", jScrollPane1);

        jButtonSaveCase.setBackground(new java.awt.Color(0, 51, 102));
        jButtonSaveCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonSaveCase.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSaveCase.setText("บันทึก");
        jButtonSaveCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelChargeCode)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButtonSaveCase, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(151, 151, 151))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelChargeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSaveCase)
                .addContainerGap(288, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCaseActionPerformed
        // TODO add your handling code here:

        con=ConnectDatabase.connect();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String requestTime = format.format(CaseRequestTimee.getValue());
        String acceptTime = format.format(CaseAcceptTimee.getValue());
        String orcuredTime=format.format(OccuredDateTime.getValue());


        if(isInsert){
            String sql="INSERT OR REPLACE INTO CrimeCase (CaseType,crimecaseno,crimecaseyears,ChargeCodeCase,ActionCodeCase,CaseRequestDate,CaseRequestTime,"+
            "CaseAcceptDate,CaseAccepTime,DailyNumber,OccuredDate,OccuredTime,CrimeLocation,CrimeLocationMoo,CrimeLocationSoi,CrimeLocationRoad,CrimeLocationDistrict,CrimeLocationAmphur,"+
            "CrimeLocationProvince,TypeCourt,AccureandOther,SuspectandOther,WitnessandOther,Investigator_Result,CourtResult,Invest_SendtoDepartment,"+
            "PoliceNameCase,AssetList,AssetCode,crimecasenoyear,RecordInvestCase,Investigator_Number,Invest_SendCaseDate,Prosecutor_Result,"
          + "CapitalCrimeCaseNumber,TotalAcc,TotalSus,TotalWitness)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println(sql);
            try {

                pst=con.prepareStatement(sql);

                pst.setString(1,"คดีอาญา");
                pst.setString(2,crimecaseno.getText());
                pst.setString(3,crimecaseyear.getText());
                pst.setString(4,jLabelChargeCode.getText());
                pst.setString(5,jLabelActionCode.getText());
                pst.setString(6,CaseRequestDateTime.getJFormattedTextField().getText());
                pst.setString(7,requestTime);
                pst.setString(8,CaseAcceptDate.getJFormattedTextField().getText());
                pst.setString(9,acceptTime);
                pst.setString(10,DailyNumber.getText());
                pst.setString(11,OccuredDate.getJFormattedTextField().getText());
                pst.setString(12,orcuredTime);
                pst.setString(13,CrimeLocation.getText());
                pst.setString(14,CrimeLocationMoo.getText());
                pst.setString(15,CrimeLocationSoi.getText());
                pst.setString(16,CrimeLocationRoad.getText());
                pst.setString(17,CrimeLocationDistrict.getText());
                pst.setString(18,CrimeLocationAmphur.getText());
                pst.setString(19,CrimeLocationProvince.getText());
                
                pst.setString(20,CourtType.getSelectedItem().toString());
                pst.setString(21,jTextAccused.getText());
                pst.setString(22,jTextSuspect.getText());
                pst.setString(23,jTextWitness.getText());
                if(jCheckDuringInvest.isSelected()){
                    pst.setString(24,"อยู่ระหว่างสอบสวน");
                }
                if(jCheckSue.isSelected()){
                    pst.setString(24,"สั่งฟ้อง");
                }
                if(jCheckNotSue.isSelected()){
                    pst.setString(24,"สั่งไม่ฟ้อง");
                }
                if(jCheckNoInvest.isSelected()){
                    pst.setString(24,"งดการสอบสวน");
                }
                if(jCheckOtherInvest.isSelected()){
                    pst.setString(24,"อื่นๆ");
                }

                pst.setString(25,CourtResult.getText());
                pst.setString(26,jTextInvestSendtoDepartment.getText());
                pst.setString(27,jComboPoliceName.getSelectedItem().toString());             
                pst.setString(28,ListAsset.getText());
                pst.setString(29,EvidenceRecordCase.getText());
                pst.setString(30,crimecaseno.getText()+"/"+crimecaseyear.getText());
             
                pst.setString(31,RecordInvestCase.getText());
                pst.setString(32,Investigator_Number.getText());
                pst.setString(33,Invest_SendCaseDate.getJFormattedTextField().getText());
                pst.setString(34,Prosecutor_Result.getText());
                pst.setString(35,CapitalCrimeCaseNumber.getText());
                pst.setString(36,jLabelNumberAcc.getText());
                pst.setString(37,jLabelNumberSus.getText());
                pst.setString(38,jLabelNumberWitness.getText());                
                

       
         
               
//       JOptionPane.showMessageDialog(jPanel1,null, "Data Save", JOptionPane.INFORMATION_MESSAGE);

                
      int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  if (response == JOptionPane.YES_OPTION) {
//             con=ConnectDatabase.connect();
         pst.executeUpdate(); 
         pst.close();
         System.out.println("SQL : "+sql);
         JSONObject data=new JSONObject();
         data.put("caseid", caseidLast);
           JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        ReportforCrimesCase n=new ReportforCrimesCase(fr,data);
        n.pack();
        n.setLocationRelativeTo(null);
        n.setVisible(true);

    } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }
        }
        else{
            String sqlUpdate="UPDATE CrimeCase SET crimecaseno = ?,"
            +"crimecaseyears = ?,"
            +"ChargeCodeCase = ?,"
            +"ActionCodeCase = ?,"
            +"CaseRequestDate = ?,"
            +"CaseRequestTime = ?,"
            +"CaseAcceptDate = ?,"
            +"CaseAccepTime = ?,"
            +"DailyNumber = ?,"
            +"OccuredDate = ?,"
            +"OccuredTime = ?,"
            +"CrimeLocation = ?,"
            +"CrimeLocationDistrict = ?,"
            +"CrimeLocationAmphur = ?,"
            +"CrimeLocationProvince = ?,"
            +"AccureandOther = ?,"
            +"SuspectandOther = ?,"
            +"WitnessandOther = ?,"
            +"TypeCourt = ?,"
            +"AssetList = ?,"
            +"AssetCode = ?,"
            +"Investigator_Result=?,"
            +"crimecasenoyear=?," 
            +"CourtResult=?,"
            +"Invest_SendtoDepartment=?,"
            +"PoliceNameCase=?,"
            +"CrimeLocationMoo=?,"
            +"CrimeLocationSoi=?,"
            +"CrimeLocationRoad=?," 
            +"RecordInvestCase=?,"
            +"Investigator_Number=?,"
            +"Invest_SendCaseDate=?,"
            +"Prosecutor_Result=?," 
            +"CapitalCrimeCaseNumber=?,"
            +"TotalAcc=?,"
            +"TotalSus=?," 
            +"TotalWitness=?"                     
            +" WHERE  CaseId = ?";
            System.out.println("SQL : "+sqlUpdate);
            try {

                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,crimecaseno.getText());
                pst.setString(2,crimecaseyear.getText());
                pst.setString(3,jLabelChargeCode.getText());
                pst.setString(4,jLabelActionCode.getText());
                pst.setString(5,CaseRequestDateTime.getJFormattedTextField().getText());
                pst.setString(6,requestTime);
                pst.setString(7,CaseAcceptDate.getJFormattedTextField().getText());
                pst.setString(8,acceptTime);
                pst.setString(9,DailyNumber.getText());
                pst.setString(10,OccuredDate.getJFormattedTextField().getText());
                pst.setString(11,orcuredTime);
                pst.setString(12,CrimeLocation.getText());
                pst.setString(13,CrimeLocationDistrict.getText());
                pst.setString(14,CrimeLocationAmphur.getText());
                pst.setString(15,CrimeLocationProvince.getText());
                pst.setString(16,jTextAccused.getText());
                pst.setString(17,jTextSuspect.getText());
                pst.setString(18,jTextWitness.getText());
                pst.setString(19,CourtType.getSelectedItem().toString());
                pst.setString(20,ListAsset.getText());
                pst.setString(21,EvidenceRecordCase.getText());
             
                   if(jCheckDuringInvest.isSelected()){
                    pst.setString(22,"อยู่ระหว่างสอบสวน");
                }
                if(jCheckSue.isSelected()){
                    pst.setString(22,"สั่งฟ้อง");
                }
                if(jCheckNotSue.isSelected()){
                    pst.setString(22,"สั่งไม่ฟ้อง");
                }
                if(jCheckNoInvest.isSelected()){
                    pst.setString(22,"งดการสอบสวน");
                }
                if(jCheckOtherInvest.isSelected()){
                    pst.setString(22,"อื่นๆ");
                }
                 pst.setString(23,crimecaseno.getText()+"/"+crimecaseyear.getText());
                pst.setString(24,CourtResult.getText());
                pst.setString(25,jTextInvestSendtoDepartment.getText());
                pst.setString(26,jComboPoliceName.getSelectedItem().toString());
                pst.setString(27,CrimeLocationMoo.getText());
                pst.setString(28,CrimeLocationSoi.getText());
                pst.setString(29,CrimeLocationRoad.getText());
                pst.setString(30,RecordInvestCase.getText());
                pst.setString(31,Investigator_Number.getText());
                pst.setString(32,Invest_SendCaseDate.getJFormattedTextField().getText());
                pst.setString(33,Prosecutor_Result.getText());
                pst.setString(34,CapitalCrimeCaseNumber.getText());
                pst.setString(35,jLabelNumberAcc.getText());
                pst.setString(36,jLabelNumberSus.getText());
                pst.setString(37,jLabelNumberWitness.getText());                
                pst.setString(38,caseid);
                
               int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการแก้ไขข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
         System.out.println("SQL : "+sqlUpdate);
           JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        JSONObject data=new JSONObject();
         data.put("caseid", caseid);
        ReportforCrimesCase n=new ReportforCrimesCase(fr,data);
        n.pack();
        n.setLocationRelativeTo(null);
        n.setVisible(true);

    } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }
        }

        //        setVisible(false);
         jTabbedPane2.setEnabledAt(jTabbedPane2.getTabCount()-1, true);
      
    }//GEN-LAST:event_jButtonSaveCaseActionPerformed

    private void CourtTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourtTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourtTypeActionPerformed

    private void jButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();

        if(ActionCrimes.getText().length()==0 || ActionCrimes.getText()==null|| ActionCrimes.getText().isEmpty()){
            ActionPage d = new ActionPage(fr,null);
            d.pack();
            d.setLocationRelativeTo(null);
            d.setVisible(true);
        }
        else {

            try{
                //                String crimecaseno = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)+"";
                String actionCode=jLabelActionCode.getText();
                String sql="select * From ActionsCase where ActionsCase.ActionCode ='"+actionCode+"'";
                //                System.out.println("ExSql : "+sql);
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("ActionCode", rs.getString("ActionCode"));
                    data.put("ActionCrimes", rs.getString("ActionCrimes"));
                    data.put("ActionDetail", rs.getString("ActionDetail"));
                    data.put("ActionNote", rs.getString("ActionNote"));

                    ActionPage d = new ActionPage(fr,data);
                    d.pack();
                    d.setLocationRelativeTo(null);
                    d.setVisible(true);

                }

                rs.close();
                stmt.close();

            }catch(Exception ex){
                ex.printStackTrace();

            }

        }
    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jButtonChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargeActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame f = (JFrame)(dialog.getParent());
        f.removeAll();
        if(ChargeNameCase.getText().length()==0 || ChargeNameCase.getText()==null|| ChargeNameCase.getText().isEmpty()){
            ChargePage d = new ChargePage(f,null);
            d.pack();
            d.setLocationRelativeTo(null);
            d.setVisible(true);
        }
        else {

            try{
                //                String crimecaseno = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)+"";
                String chargeCode=jLabelChargeCode.getText();
                String sql="select * From Charge where Charge.ChargeCode ='"+chargeCode+"'";
                System.out.println("ExSql : "+sql);
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("ChargeCode", rs.getString("ChargeCode"));
                    data.put("ChargeName", rs.getString("ChargeName"));
                    data.put("Law", rs.getString("Law"));
                    data.put("RateOfPenalty", rs.getString("RateOfPenalty"));
                    data.put("Note", rs.getString("Note"));

                    ChargePage d = new ChargePage(f,data);
                    d.pack();
                    d.setLocationRelativeTo(null);
                    d.setVisible(true);

                }

                rs.close();
                stmt.close();

            }catch(Exception ex){
                ex.printStackTrace();

            }

        }
    }//GEN-LAST:event_jButtonChargeActionPerformed
    public void RefreshDataRec(){
    
     try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        String sql = "select Max(IdRecord) IdRecord,DateRecord,NameInguiry,"
                + "DetailRecord,CaseIdRecord from RecordInquiry where CaseIdRecord='"+caseid+"'";
      
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);

        if(rs.next()){
            RecordInvestCase.setText(rs.getString("DateRecord")+","+rs.getString("DetailRecord"));
        }
        rs.close();
        stmt.close();

       
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void ListAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListAssetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListAssetActionPerformed

    private void jButtonAddAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAssetActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame asv = (JFrame)(dialog.getParent());
        asv.removeAll();
        AssetOverView as =new AssetOverView(asv);
        as.pack();
        as.setLocationRelativeTo(null);
        as.setVisible(true);
    }//GEN-LAST:event_jButtonAddAssetActionPerformed

    private void jButtonAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccuredActionPerformed
        // TODO add your handling code here:
        String aa=crimecaseid.getText();
        String type="อาญา";
        JSONObject data = new JSONObject();
        data.put("CaseIdAcc",aa );
        data.put("TypeCase",type );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
        facc.removeAll();
        ListAccused la =new ListAccused(facc,data);
        la.pack();
        la.setLocationRelativeTo(null);
        la.setVisible(true);
    }//GEN-LAST:event_jButtonAccuredActionPerformed

    private void jButtonSuspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuspectActionPerformed
        // TODO add your handling code here:
        String idSus=crimecaseid.getText();
        String caseNumber=crimecaseno.getText()+crimecaseyear.getText();
        String typeS="อาญา";
        JSONObject s = new JSONObject();
        s.put("CaseIdSus",idSus );
        s.put("TypeCaseS",typeS );
        s.put("CaseNumber",caseNumber );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
        facc.removeAll();
        ListSuspect ls=new ListSuspect(facc,s);
        ls.pack();
        ls.setLocationRelativeTo(null);
        ls.setVisible(true);
    }//GEN-LAST:event_jButtonSuspectActionPerformed

    private void jButtonWitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWitnessActionPerformed
        // TODO add your handling code here:
        String idWit=crimecaseid.getText();
        String typeW="อาญา";
        JSONObject s = new JSONObject();
        s.put("CaseIdWit",idWit );
        s.put("TypeCaseW",typeW );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        ListWitness lw=new ListWitness(fwit,s);
        lw.pack();
        lw.setLocationRelativeTo(null);
        lw.setVisible(true);
    }//GEN-LAST:event_jButtonWitnessActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAddInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInvestActionPerformed
        String ci=crimecaseid.getText();

        JSONObject data = new JSONObject();
        data.put("CaseIdRec",ci );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame a = (JFrame)(dialog.getParent());
        a.removeAll();
        RecordInvestigatorView ri =new RecordInvestigatorView(a,data);
        ri.pack();
        ri.setLocationRelativeTo(null);
        ri.setVisible(true);
//        RefreshDataRec();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddInvestActionPerformed

    private void CrimeLocationMooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrimeLocationMooActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CrimeLocationMooActionPerformed

    private void jCheckW68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW68ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW68ActionPerformed

    private void jCheckW19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW19ActionPerformed

    private void jCheckW19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckW19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW19MouseClicked

    private void jCheckW37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW37ActionPerformed

    private void jCheckW40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW40ActionPerformed

    private void jCheckW2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckW2MouseClicked
        // TODO add your handling code here:
        /*
        String no=crimecaseno.getText();
        File f3=new File("D:/สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/คดีอาญา"+caseno+"-"+caseyear);

        f3.mkdirs();
        W2.w2(no);
        System.out.print(f3);
        System.out.print("folder created");
        OpenFile(PoliceStaionName, caseyear, caseno,"บันทึกการตรวจสำนวนการสอบสวน.doc");
        */
    }//GEN-LAST:event_jCheckW2MouseClicked

    private void jCheckW1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckW1MouseClicked
        // TODO add your handling code here:
        /*
        String no=crimecaseno.getText();
        File f3=new File("D:/สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/คดีอาญา"+caseno+"-"+caseyear);

        f3.mkdirs();
        W1.w1(no);
        System.out.print(f3);
        System.out.print("folder created");
        OpenFile(PoliceStaionName, caseyear, caseno,"บันทึกการตรวจสำนวนการสอบสวน.doc");
        */
    }//GEN-LAST:event_jCheckW1MouseClicked

    private void jCheckW93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW93ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW93ActionPerformed

    private void jButtonPrintDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintDocActionPerformed
        // TODO add your handling code here:
        String no=crimecaseid.getText();
        
        File f3=new File("D:/สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+caseno+"-"+caseyear);

        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
        if(jCheckW1.isSelected()){
            W1.w1(no);
        }

        if(jCheckW2.isSelected()){
            W2.w2(no);

        }
        if(jCheckW3.isSelected()){
            W3.w3(no);
        }
        if(jCheckW4.isSelected()){
            W4.w4(no);
        }
        if(jCheckW5.isSelected()){
            W5.w5(no);
        }
        if(jCheckW6.isSelected()){
            W6.w6(no);
        }
        if(jCheckW8.isSelected()){
            W8.w8(no);
        }
        if(jCheckW9.isSelected()){
            W9.w9(no);
        }
        if(jCheckW11.isSelected()){
            W11.w11(no);
        }
        if(jCheckW12.isSelected()){
            W12.w12(no);
          }
        if(jCheckW13.isSelected()){
            W13.w13(no);
            }
         if(jCheckW14.isSelected()){
             W14.w14(no);
             }
        //        if(jCheckW15.isSelected()){
            //            W15.w15(no);
            //        }
        //       if(jCheckW16.isSelected()){
            //            W16.w16(no);
            //        }
        //       if(jCheckW17.isSelected()){
            //            W17.w17(no);
            //        }
        //      // if(jCheckW18.isSelected()){
            //      //      W18.w18(no);
            //      //  }
        //       if(jCheckW19.isSelected()){
            //            W19.w19(no);
            //        }
        //       if(jCheckW20.isSelected()){
            //            W20.w20(no);
            //        }
        //       if(jCheckW21.isSelected()){
            //            W21.w21(no);
            //        }
        //       if(jCheckW25.isSelected()){
            //            W25.w25(no);
            //        }
        //       if(jCheckW26.isSelected()){
            //            W26.w26(no);
            //        }
        //       if(jCheckW27.isSelected()){
            //            W27.w27(no);
            //        }
        //       if(jCheckW28.isSelected()){
            //            W28.w28(no);
            //        }
        //       if(jCheckW29.isSelected()){
            //            W29.w29(no);
            //        }
        //       if(jCheckW30.isSelected()){
            //            W30.w30(no);
            //        }
        //       if(jCheckW31.isSelected()){
            //            W31.w31(no);
            //        }
        //
        //       if(jCheckW33.isSelected()){
            //            W33.w33(no);
            //        }
        //       if(jCheckW34.isSelected()){
            //            W34.w34(no);
            //        }
        //       if(jCheckW35.isSelected()){
            //            W35.w35(no);
            //        }
        //       if(jCheckW36.isSelected()){
            //            W36.w36(no);
            //        }
        //       if(jCheckW37.isSelected()){
            //            W37.w37(no);
            //        }
        //       if(jCheckW38.isSelected()){
            //            W38.w38(no);
            //        }
        //       if(jCheckW39.isSelected()){
            //            W39.w39(no);
            //        }
        //       if(jCheckW40.isSelected()){
            //            W40.w40(no);
            //        }
        //       if(jCheckW41.isSelected()){
            //            W41.w41(no);
            //        }
        //      if(jCheckW43.isSelected()){
            //            W43.w43(no);
            //        }
        //       if(jCheckW46.isSelected()){
            //            W46.w46(no);
            //        }
        //       if(jCheckW47.isSelected()){
            //            W47.w47(no);
            //        }
        //       if(jCheckW48.isSelected()){
            //            W48.w48(no);
            //        }
        //       if(jCheckW49.isSelected()){
            //            W49.w49(no);
            //        }
        //       if(jCheckW50.isSelected()){
            //            W50.w50(no);
            //        }
        //       if(jCheckW51.isSelected()){
            //            W51.w51(no);
            //        }
        //       if(jCheckW53.isSelected()){
            //            W53.w53(no);
            //        }
        //       if(jCheckW62.isSelected()){
            //            W62.w62(no);
            //        }
        //       if(jCheckW67.isSelected()){
            //            W67.w67(no);
            //        }
        ////       if(jCheckW68.isSelected()){
            ////            W68.w68(no);
            ////        }
        //       if(jCheckW69.isSelected()){
            //            W69.w69(no);
            //        }
        //       if(jCheckW70.isSelected()){
            //            W70.w70(no);
            //        }
        //       if(jCheckW71.isSelected()){
            //            W71.w71(no);
            //        }
        //       if(jCheckW93.isSelected()){
            //            W93.w93(no);
            //        }
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("D:/สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+caseno+"-"+caseyear);
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found");
        }

    }//GEN-LAST:event_jButtonPrintDocActionPerformed

    private void jCheckW69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW69ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW69ActionPerformed

    private void jCheckW41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW41ActionPerformed

    private void jCheckW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        closeAllDialogs();
    }//GEN-LAST:event_jButton2ActionPerformed
     private void closeAllDialogs()
{
    Window[] windows = getWindows();

    for (Window window : windows)
    {
        if (window instanceof JDialog)
        {
            window.dispose();
        }
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
    public void comboInvest(){
    
     try {

         Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select InvestRank,InvestName from InvestInformation";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
	jComboPoliceName.addItem(res.getString("InvestRank")+res.getString("InvestName"));

	
	}
//        else{jComboPoliceName.addItem("");}
	
}
catch (Exception d) {  //System.out.println(d);  
}
    }
    public static JComponent makeExamplePane() {
     JPanel text = new JPanel();
    JScrollPane scroll = new JScrollPane(text);
    return scroll;
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrimesCaseEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
//                   jScrollPane2.getVerticalScrollBar().setUI(new MyScrollBarUI());
//                  JComponent before = makeExamplePane();
//                   UIManager.put("ScrollBarUI", "MyMetalScrollBarUI");
// 
//                    JComponent after = makeExamplePane();
// 
     
                
//        aa.setMinimumSize ( new Dimension ( 1264, 728 ) );
//         Container c = aa.getContentPane();
//            c.add(before);
//            c.add(after);   
 
//        aa.setMaximizedBounds ( new Rectangle ( 1264, 728 ) );
            }
        });
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ActionCrimes;
    private javax.swing.JTextArea CapitalCrimeCaseNumber;
    private javax.swing.JSpinner CaseAcceptTimee;
    private javax.swing.JSpinner CaseRequestTimee;
    private javax.swing.JLabel CaseType;
    public static javax.swing.JTextField ChargeNameCase;
    private javax.swing.JTextArea CourtResult;
    private javax.swing.JComboBox<String> CourtType;
    private javax.swing.JTextField CrimeLocation;
    private javax.swing.JTextField CrimeLocationAmphur;
    private javax.swing.JTextField CrimeLocationDistrict;
    private javax.swing.JTextField CrimeLocationMoo;
    private javax.swing.JTextField CrimeLocationProvince;
    private javax.swing.JTextField CrimeLocationRoad;
    private javax.swing.JTextField CrimeLocationSoi;
    private javax.swing.JTextField DailyNumber;
    public static javax.swing.JTextField EvidenceRecordCase;
    private javax.swing.JTextField Investigator_Number;
    public static javax.swing.JTextField ListAsset;
    private javax.swing.JSpinner OccuredDateTime;
    private javax.swing.JTextArea Prosecutor_Result;
    public static javax.swing.JTextField RecordInvestCase;
    public static javax.swing.JLabel crimecaseid;
    public static javax.swing.JTextField crimecaseno;
    private javax.swing.JTextField crimecaseyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAccured;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAddAsset;
    private javax.swing.JButton jButtonAddInvest;
    private javax.swing.JButton jButtonCharge;
    private javax.swing.JButton jButtonPrintDoc;
    private javax.swing.JButton jButtonSaveCase;
    private javax.swing.JButton jButtonSuspect;
    private javax.swing.JButton jButtonWitness;
    private javax.swing.JCheckBox jCheckBox50;
    private javax.swing.JCheckBox jCheckBox64;
    private javax.swing.JRadioButton jCheckDuringInvest;
    private javax.swing.JRadioButton jCheckNoInvest;
    private javax.swing.JRadioButton jCheckNotSue;
    private javax.swing.JRadioButton jCheckOtherInvest;
    private javax.swing.JRadioButton jCheckSue;
    private javax.swing.JCheckBox jCheckW1;
    private javax.swing.JCheckBox jCheckW11;
    private javax.swing.JCheckBox jCheckW12;
    private javax.swing.JCheckBox jCheckW13;
    private javax.swing.JCheckBox jCheckW14;
    private javax.swing.JCheckBox jCheckW15;
    private javax.swing.JCheckBox jCheckW16;
    private javax.swing.JCheckBox jCheckW17;
    private javax.swing.JCheckBox jCheckW19;
    private javax.swing.JCheckBox jCheckW2;
    private javax.swing.JCheckBox jCheckW20;
    private javax.swing.JCheckBox jCheckW21;
    private javax.swing.JCheckBox jCheckW25;
    private javax.swing.JCheckBox jCheckW26;
    private javax.swing.JCheckBox jCheckW27;
    private javax.swing.JCheckBox jCheckW28;
    private javax.swing.JCheckBox jCheckW29;
    private javax.swing.JCheckBox jCheckW3;
    private javax.swing.JCheckBox jCheckW30;
    private javax.swing.JCheckBox jCheckW31;
    private javax.swing.JCheckBox jCheckW33;
    private javax.swing.JCheckBox jCheckW34;
    private javax.swing.JCheckBox jCheckW35;
    private javax.swing.JCheckBox jCheckW36;
    private javax.swing.JCheckBox jCheckW37;
    private javax.swing.JCheckBox jCheckW38;
    private javax.swing.JCheckBox jCheckW39;
    private javax.swing.JCheckBox jCheckW4;
    private javax.swing.JCheckBox jCheckW40;
    private javax.swing.JCheckBox jCheckW41;
    private javax.swing.JCheckBox jCheckW43;
    private javax.swing.JCheckBox jCheckW46;
    private javax.swing.JCheckBox jCheckW47;
    private javax.swing.JCheckBox jCheckW48;
    private javax.swing.JCheckBox jCheckW49;
    private javax.swing.JCheckBox jCheckW5;
    private javax.swing.JCheckBox jCheckW50;
    private javax.swing.JCheckBox jCheckW51;
    private javax.swing.JCheckBox jCheckW53;
    private javax.swing.JCheckBox jCheckW59;
    private javax.swing.JCheckBox jCheckW6;
    private javax.swing.JCheckBox jCheckW62;
    private javax.swing.JCheckBox jCheckW67;
    private javax.swing.JCheckBox jCheckW68;
    private javax.swing.JCheckBox jCheckW69;
    private javax.swing.JCheckBox jCheckW70;
    private javax.swing.JCheckBox jCheckW71;
    private javax.swing.JCheckBox jCheckW8;
    private javax.swing.JCheckBox jCheckW9;
    private javax.swing.JCheckBox jCheckW93;
    private javax.swing.JComboBox<String> jComboPoliceName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelActionCode;
    public static javax.swing.JLabel jLabelChargeCode;
    public static javax.swing.JLabel jLabelNumberAcc;
    public static javax.swing.JLabel jLabelNumberSus;
    public static javax.swing.JLabel jLabelNumberWitness;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelInvestSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JTextField jTextAccused;
    private javax.swing.JTextField jTextInvestSendtoDepartment;
    public static javax.swing.JTextField jTextSuspect;
    public static javax.swing.JTextField jTextWitness;
    // End of variables declaration//GEN-END:variables
}
