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
import com.songkhla.document.W18;
import com.songkhla.document.W19;
import com.songkhla.document.W2;
import com.songkhla.document.W20;
import com.songkhla.document.W21;
import com.songkhla.document.W22;
import com.songkhla.document.W23;
import com.songkhla.document.W24;
import com.songkhla.document.W25;
import com.songkhla.document.W26;
import com.songkhla.document.W27;
import com.songkhla.document.W28;
import com.songkhla.document.W29;
import com.songkhla.document.W3;
import com.songkhla.document.W30;
import com.songkhla.document.W31;
import com.songkhla.document.W32;
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
import com.songkhla.document.W42;
import com.songkhla.document.W43;
import com.songkhla.document.W44;
import com.songkhla.document.W45;
import com.songkhla.document.W46;
import com.songkhla.document.W47;
import com.songkhla.document.W48;
import com.songkhla.document.W49;
import com.songkhla.document.W5;
import com.songkhla.document.W50;
import com.songkhla.document.W51;
import com.songkhla.document.W52;
import com.songkhla.document.W53;
import com.songkhla.document.W6;
import com.songkhla.document.W62;
import com.songkhla.document.W63;
import com.songkhla.document.W64;
import com.songkhla.document.W65;
import com.songkhla.document.W67;
import com.songkhla.document.W68;
import com.songkhla.document.W69;
import com.songkhla.document.W70;
import com.songkhla.document.W71;
import com.songkhla.document.W711;
import com.songkhla.document.W72;
import com.songkhla.document.W73;
import com.songkhla.document.W74;
import com.songkhla.document.W75;
import com.songkhla.document.W76;
import com.songkhla.document.W8;
import com.songkhla.document.W80;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
       String Province_name;
    String caseid,caseidLast,province;
     String caseyear,casetype,caseno,PoliceStaionName;
     ButtonGroup g;
JDatePickerImpl CaseRequestDateTime,CaseAcceptDate,OccuredDate,Invest_SendCaseDate;
    /**
     * Creates new form CrimesCaseEdit
     */
    public CrimesCaseEdit(JFrame parrent,JSONObject datain){
        super(parrent,true);

           initComponents(); 
            ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES)");
//            JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
//            jScrollPane1.getVerticalScrollBar().setUI(new MyScrollBarUI());
//            jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
         g=new ButtonGroup();
        g.add(jCheckDuringInvest);
        g.add(jCheckSue);
        g.add(jCheckNotSue);
        g.add(jCheckNoInvest);
        g.add(jCheckOtherInvest);
       jLabel32.setVisible(false);
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
         
             PoliceStaionName=rs1.getString("PoliceStaionName");

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
        jLabelChargeCode.setVisible(false);
        crimecaseid.setVisible(false);
 
            comboInvest();
 comboProvince();
 
        if(datain!=null){
            try {
                CloseTextBox();
                jButtonSaveCase.setEnabled(false);
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
            CrimeLocationDistrict.setSelectedItem(datain.get("CrimeLocationDistrict")+"");
            CrimeLocationAmphur.setSelectedItem(datain.get("CrimeLocationAmphur")+"");
            CrimeLocationProvince.setSelectedItem(datain.get("CrimeLocationProvince")+"");
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
            jButtonEditCase.setEnabled(false);
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
        
           
//           CaseAcceptDate.setDate(date);
//           CaseRequestDateTime.setDate(date);
//           OccuredDate.setDate(date);
           isInsert=true;
          
        }
        String da=CaseAcceptDate.getJFormattedTextField().getText();
        String od=OccuredDate.getJFormattedTextField().getText();

//         System.out.println("dd ;"+CalculateDateArrest(od, da)+"");

//   OccuredDate.getJFormattedTextField().getDocument().addDocumentListener(new DocumentListener() {
//  public void changedUpdate(DocumentEvent e) {
////     if(CalculateDateArrest(OccuredDate.getJFormattedTextField().getText(), CaseAcceptDate.getJFormattedTextField().getText())<0){
////        JOptionPane.showConfirmDialog(jPanel1, "วันที่เกิดเหตุ", "ยืนยัน",
////        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
////         System.out.println("dd ;"+CalculateDateArrest(OccuredDate.getJFormattedTextField().getText(), CaseAcceptDate.getJFormattedTextField().getText())+"");
////    }
//  }
//  public void removeUpdate(DocumentEvent e) {
//  
//  }
//  public void insertUpdate(DocumentEvent e) {
////        JOptionPane.showMessageDialog(null, "Date Format Error!! using dd/MM/yyyy");
//      if(CalculateDateArrest(OccuredDate.getJFormattedTextField().getText(), CaseAcceptDate.getJFormattedTextField().getText())<0){
//    JOptionPane.showConfirmDialog(jPanel1, "วันที่เกิดเหตุ", "ยืนยัน",
//        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//     System.out.println("dd ;"+CalculateDateArrest(OccuredDate.getJFormattedTextField().getText(), CaseAcceptDate.getJFormattedTextField().getText())+"");
//    }
//  }
//  
//            
//   });
            
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
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
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
        CrimeLocationProvince = new javax.swing.JComboBox<>();
        CrimeLocationAmphur = new javax.swing.JComboBox<>();
        CrimeLocationDistrict = new javax.swing.JComboBox<>();
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
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jCheckW80 = new javax.swing.JCheckBox();
        jCheckW1 = new javax.swing.JCheckBox();
        jCheckW2 = new javax.swing.JCheckBox();
        jCheckW3 = new javax.swing.JCheckBox();
        jCheckW4 = new javax.swing.JCheckBox();
        jCheckW5 = new javax.swing.JCheckBox();
        jCheckW6 = new javax.swing.JCheckBox();
        jCheckW7 = new javax.swing.JCheckBox();
        jCheckW8 = new javax.swing.JCheckBox();
        jCheckW9 = new javax.swing.JCheckBox();
        jCheckW11 = new javax.swing.JCheckBox();
        jCheckW12 = new javax.swing.JCheckBox();
        jCheckW13 = new javax.swing.JCheckBox();
        jCheckW14 = new javax.swing.JCheckBox();
        jCheckW15 = new javax.swing.JCheckBox();
        jCheckW16 = new javax.swing.JCheckBox();
        jCheckW17 = new javax.swing.JCheckBox();
        jCheckW18 = new javax.swing.JCheckBox();
        jCheckW19 = new javax.swing.JCheckBox();
        jCheckW93 = new javax.swing.JCheckBox();
        jCheckW20 = new javax.swing.JCheckBox();
        jCheckW21 = new javax.swing.JCheckBox();
        jCheckW22 = new javax.swing.JCheckBox();
        jCheckW23 = new javax.swing.JCheckBox();
        jCheckW24 = new javax.swing.JCheckBox();
        jCheckW25 = new javax.swing.JCheckBox();
        jCheckW26 = new javax.swing.JCheckBox();
        jCheckW27 = new javax.swing.JCheckBox();
        jCheckW28 = new javax.swing.JCheckBox();
        jCheckW29 = new javax.swing.JCheckBox();
        jCheckW30 = new javax.swing.JCheckBox();
        jCheckW31 = new javax.swing.JCheckBox();
        jCheckW32 = new javax.swing.JCheckBox();
        jCheckW33 = new javax.swing.JCheckBox();
        jCheckW34 = new javax.swing.JCheckBox();
        jCheckW35 = new javax.swing.JCheckBox();
        jCheckW36 = new javax.swing.JCheckBox();
        jCheckW37 = new javax.swing.JCheckBox();
        jCheckW38 = new javax.swing.JCheckBox();
        jCheckW39 = new javax.swing.JCheckBox();
        jCheckW46 = new javax.swing.JCheckBox();
        jCheckW5445 = new javax.swing.JCheckBox();
        jCheckW44 = new javax.swing.JCheckBox();
        jCheckW43 = new javax.swing.JCheckBox();
        jCheckW42 = new javax.swing.JCheckBox();
        jCheckW41 = new javax.swing.JCheckBox();
        jCheckW53 = new javax.swing.JCheckBox();
        jCheckW54 = new javax.swing.JCheckBox();
        jCheckW56 = new javax.swing.JCheckBox();
        jCheckW55 = new javax.swing.JCheckBox();
        jCheckW57 = new javax.swing.JCheckBox();
        jCheckW58 = new javax.swing.JCheckBox();
        jCheckW59 = new javax.swing.JCheckBox();
        jCheckW60 = new javax.swing.JCheckBox();
        jCheckW61 = new javax.swing.JCheckBox();
        jCheckW7462 = new javax.swing.JCheckBox();
        jCheckW63 = new javax.swing.JCheckBox();
        jCheckW64 = new javax.swing.JCheckBox();
        jCheckW65 = new javax.swing.JCheckBox();
        jCheckW66 = new javax.swing.JCheckBox();
        jCheckW67 = new javax.swing.JCheckBox();
        jCheckW68 = new javax.swing.JCheckBox();
        jCheckW69 = new javax.swing.JCheckBox();
        jCheckW70 = new javax.swing.JCheckBox();
        jCheckW71 = new javax.swing.JCheckBox();
        jCheckW72 = new javax.swing.JCheckBox();
        jCheckW73 = new javax.swing.JCheckBox();
        jCheckW75 = new javax.swing.JCheckBox();
        jCheckW76 = new javax.swing.JCheckBox();
        jCheckW77 = new javax.swing.JCheckBox();
        jCheckW47 = new javax.swing.JCheckBox();
        jCheckW48 = new javax.swing.JCheckBox();
        jCheckW49 = new javax.swing.JCheckBox();
        jCheckW50 = new javax.swing.JCheckBox();
        jCheckW51 = new javax.swing.JCheckBox();
        jCheckW52 = new javax.swing.JCheckBox();
        jCheckW40 = new javax.swing.JCheckBox();
        jCheckW62 = new javax.swing.JCheckBox();
        jButtonPrintDoc = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jCheckW247 = new javax.swing.JCheckBox();
        jCheckW248 = new javax.swing.JCheckBox();
        jCheckW249 = new javax.swing.JCheckBox();
        jCheckW250 = new javax.swing.JCheckBox();
        jCheckW251 = new javax.swing.JCheckBox();
        jCheckW252 = new javax.swing.JCheckBox();
        jCheckW254 = new javax.swing.JCheckBox();
        jCheckW255 = new javax.swing.JCheckBox();
        jCheckW256 = new javax.swing.JCheckBox();
        jCheckW275 = new javax.swing.JCheckBox();
        jCheckW276 = new javax.swing.JCheckBox();
        jCheckW277 = new javax.swing.JCheckBox();
        jCheckW232 = new javax.swing.JCheckBox();
        jCheckW278 = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jCheckW201 = new javax.swing.JCheckBox();
        jCheckW202 = new javax.swing.JCheckBox();
        jCheckW203 = new javax.swing.JCheckBox();
        jCheckW204 = new javax.swing.JCheckBox();
        jCheckW205 = new javax.swing.JCheckBox();
        jCheckW206 = new javax.swing.JCheckBox();
        jCheckW207 = new javax.swing.JCheckBox();
        jCheckW208 = new javax.swing.JCheckBox();
        jCheckW209 = new javax.swing.JCheckBox();
        jCheckW226 = new javax.swing.JCheckBox();
        jCheckW225 = new javax.swing.JCheckBox();
        jCheckW216 = new javax.swing.JCheckBox();
        jCheckW293 = new javax.swing.JCheckBox();
        jCheckW227 = new javax.swing.JCheckBox();
        jCheckW238 = new javax.swing.JCheckBox();
        jCheckW239 = new javax.swing.JCheckBox();
        jCheckW231 = new javax.swing.JCheckBox();
        jCheckW229 = new javax.swing.JCheckBox();
        jCheckW230 = new javax.swing.JCheckBox();
        jCheckW280 = new javax.swing.JCheckBox();
        jCheckW262 = new javax.swing.JCheckBox();
        jCheckW263 = new javax.swing.JCheckBox();
        jCheckW264 = new javax.swing.JCheckBox();
        jCheckW220 = new javax.swing.JCheckBox();
        jCheckW219 = new javax.swing.JCheckBox();
        jCheckW218 = new javax.swing.JCheckBox();
        jCheckW217 = new javax.swing.JCheckBox();
        jCheckW237 = new javax.swing.JCheckBox();
        jCheckW266 = new javax.swing.JCheckBox();
        jCheckW233 = new javax.swing.JCheckBox();
        jCheckW261 = new javax.swing.JCheckBox();
        jCheckW228 = new javax.swing.JCheckBox();
        jCheckW253 = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jCheckW240 = new javax.swing.JCheckBox();
        jCheckW241 = new javax.swing.JCheckBox();
        jCheckW242 = new javax.swing.JCheckBox();
        jCheckW221 = new javax.swing.JCheckBox();
        jCheckW222 = new javax.swing.JCheckBox();
        jCheckW223 = new javax.swing.JCheckBox();
        jCheckW224 = new javax.swing.JCheckBox();
        jCheckW265 = new javax.swing.JCheckBox();
        jCheckW269 = new javax.swing.JCheckBox();
        jCheckW268 = new javax.swing.JCheckBox();
        jCheckW267 = new javax.swing.JCheckBox();
        jPanel16 = new javax.swing.JPanel();
        jCheckW246 = new javax.swing.JCheckBox();
        jCheckW245 = new javax.swing.JCheckBox();
        jCheckW244 = new javax.swing.JCheckBox();
        jCheckW243 = new javax.swing.JCheckBox();
        jCheckW215 = new javax.swing.JCheckBox();
        jCheckW213 = new javax.swing.JCheckBox();
        jCheckW214 = new javax.swing.JCheckBox();
        jCheckW212 = new javax.swing.JCheckBox();
        jCheckW234 = new javax.swing.JCheckBox();
        jCheckW257 = new javax.swing.JCheckBox();
        jCheckW258 = new javax.swing.JCheckBox();
        jCheckW273 = new javax.swing.JCheckBox();
        jCheckW272 = new javax.swing.JCheckBox();
        jCheckW270 = new javax.swing.JCheckBox();
        jCheckW271 = new javax.swing.JCheckBox();
        jCheckW236 = new javax.swing.JCheckBox();
        jCheckW235 = new javax.swing.JCheckBox();
        jCheckW260 = new javax.swing.JCheckBox();
        jCheckW259 = new javax.swing.JCheckBox();
        jCheckW211 = new javax.swing.JCheckBox();
        jCheckW274 = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        jButtonPrintDoc2 = new javax.swing.JButton();
        jLabelChargeCode = new javax.swing.JLabel();
        jButtonSaveCase = new javax.swing.JButton();
        jButtonEditCase = new javax.swing.JButton();

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
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 30));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("/");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, 30));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(OccuredDateTime, "HH:mm");
        OccuredDateTime.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        jPanel1.add(OccuredDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 100, 30));

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("สถานที่เกิดเหตุ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 90, 30));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("เวลาที่เกิดเหตุ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, 30));

        ChargeNameCase.setEditable(false);
        ChargeNameCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(ChargeNameCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 330, -1));

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("วันที่รับแจ้ง");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        JSpinner.DateEditor te = new JSpinner.DateEditor(CaseAcceptTimee, "HH:mm");
        CaseAcceptTimee.setEditor(te);
        //jSpinner1.setValue(new Date());
        CaseAcceptTimee.setPreferredSize(new java.awt.Dimension(29, 25));
        jPanel1.add(CaseAcceptTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 100, 32));

        CrimeLocation.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(CrimeLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 440, -1));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("ข้อหา");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("เวลารับคำร้องทุกข์");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, -1, 30));

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("วันที่เกิดเหตุ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(ActionCrimes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 330, -1));

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เวลารับแจ้ง");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, 30));

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(CaseRequestTimee, "HH:mm");
        CaseRequestTimee.setEditor(timeEditor);
        //jSpinner1.setValue(new Date());
        jPanel1.add(CaseRequestTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 100, 30));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("พฤติการณ์คดี");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 77, 30));

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("วันที่รับคำร้องทุกข์");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 30));

        DailyNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(DailyNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 110, -1));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("อำนาจศาล");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 70, 30));

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

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
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

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel28.setText("รายการทรัพย์");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 85, 30));

        EvidenceRecordCase.setEditable(false);
        EvidenceRecordCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel1.add(EvidenceRecordCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 82, -1));

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("ตำบล");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, 30));

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("อำเภอ");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 40, 30));

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("จังหวัด");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, 30));

        jLabel45.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
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

        jLabel46.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
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
        jPanel1.add(CrimeLocationRoad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 130, 30));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 220, -1));

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 220, -1));

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 220, -1));

        CrimeLocationProvince.setEditable(true);
        CrimeLocationProvince.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CrimeLocationProvince.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        CrimeLocationProvince.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CrimeLocationProvinceItemStateChanged(evt);
            }
        });
        CrimeLocationProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrimeLocationProvinceActionPerformed(evt);
            }
        });
        jPanel1.add(CrimeLocationProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 190, 30));

        CrimeLocationAmphur.setEditable(true);
        CrimeLocationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CrimeLocationAmphur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(CrimeLocationAmphur, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 150, 190, 30));

        CrimeLocationDistrict.setEditable(true);
        CrimeLocationDistrict.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CrimeLocationDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel1.add(CrimeLocationDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 190, 30));

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

        jPanelInvestSend.setBackground(new java.awt.Color(255, 255, 255));

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
        jPanel8.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckW80.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW80.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW80.setText("บัญชีสำนวนการสอบสวน");
        jPanel8.add(jCheckW80, new org.netbeans.lib.awtextra.AbsoluteConstraints(2020, 390, 570, -1));

        jCheckW1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW1.setText("บันทึกการตรวจสำนวนการสอบสวน");
        jCheckW1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW1ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckW1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 7, 405, -1));

        jCheckW2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW2.setText("หนังสือส่งสำนวนคดีที่เห็นควรงดหรือให้งดการสอบสวน");
        jCheckW2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW2ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckW2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 405, -1));

        jCheckW3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW3.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้อง แต่ยังไม่ได้ตัวผู้ต้องหา");
        jPanel8.add(jCheckW3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, 405, -1));

        jCheckW4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW4.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้องหรือไม่สั่งฟ้อง");
        jPanel8.add(jCheckW4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 106, 405, -1));

        jCheckW5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW5.setText("รายงานการสอบสวน");
        jPanel8.add(jCheckW5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 139, 405, -1));

        jCheckW6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW6.setText("รายงานการสอบสวนสำนวนคดีไม่ปรากฎว่าผู้ใดเป็นผู้กระทำผิด");
        jPanel8.add(jCheckW6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 172, 405, -1));

        jCheckW7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW7.setText("รายงานการสอบสวนสำนวนชันสูตรพลิกศพ");
        jPanel8.add(jCheckW7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 205, 405, -1));

        jCheckW8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW8.setText("บันทึกคำให้การผู้กล่าวหา หรือพยาน");
        jPanel8.add(jCheckW8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 238, 405, -1));

        jCheckW9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW9.setText("บันทึกคำให้การผู้ต้องหา");
        jPanel8.add(jCheckW9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 271, 405, -1));

        jCheckW11.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW11.setText("บัญชีของกลางคดีอาญา");
        jPanel8.add(jCheckW11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 304, 320, -1));

        jCheckW12.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW12.setText("บัญชีทรัพย์ถูกประทุษร้าย");
        jPanel8.add(jCheckW12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 340, 405, -1));

        jCheckW13.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW13.setText("บัญชีทรัพย์ถูกประทุษร้ายได้คืน");
        jPanel8.add(jCheckW13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 373, 405, -1));

        jCheckW14.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW14.setText("บัญชีทรัพย์ถูกประทุษร้ายไม่ได้คืน");
        jPanel8.add(jCheckW14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 406, 405, -1));

        jCheckW15.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW15.setText("บัญชีทรัพย์ที่ถูกเพลิงไหม้");
        jPanel8.add(jCheckW15, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 7, 350, -1));

        jCheckW16.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW16.setText("บันทึกพนักงานสอบสวน");
        jPanel8.add(jCheckW16, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 40, 350, -1));

        jCheckW17.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW17.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีอาญา");
        jPanel8.add(jCheckW17, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 73, 350, -1));

        jCheckW18.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW18.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีจราจร");
        jPanel8.add(jCheckW18, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 106, 350, -1));

        jCheckW19.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW19.setText("แผนที่สังเขปแสดงสถานที่เกิดเหตุ");
        jPanel8.add(jCheckW19, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 139, 350, -1));

        jCheckW93.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW93.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW93.setText("หมายจับ");
        jCheckW93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW93ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckW93, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 172, 350, -1));

        jCheckW20.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW20.setText("บันทึกการนำชี้ที่เกิดเหตุประกอบคำรับสารภาพ");
        jPanel8.add(jCheckW20, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 205, 350, -1));

        jCheckW21.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW21.setText("ใบนำส่งผู้บาดเจ็บหรือศพ");
        jPanel8.add(jCheckW21, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 238, 350, -1));

        jCheckW22.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW22.setText("หนังสือส่งผู้ต้องหาป่วยทางจิตตรวจวินิจฉัย");
        jPanel8.add(jCheckW22, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 271, 350, -1));

        jCheckW23.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW23.setText("รายงานชันสูตรพลิกศพ");
        jPanel8.add(jCheckW23, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 304, 350, -1));

        jCheckW24.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW24.setText("แบบรายงานพบศพไม่ทราบชื่อ");
        jPanel8.add(jCheckW24, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 337, 350, -1));

        jCheckW25.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW25.setText("หนังสือส่งของกลางไปตรวจพิสูจน์");
        jPanel8.add(jCheckW25, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 370, 350, -1));

        jCheckW26.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW26.setText("หนังสือส่งยาเสพติดของกลางไปตรวจพิสูจน์");
        jPanel8.add(jCheckW26, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 406, 350, -1));

        jCheckW27.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW27.setText("ฉลากปิดภาชนะบรรจุยาเสพติด");
        jPanel8.add(jCheckW27, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 7, 350, -1));

        jCheckW28.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW28.setText("บันทึกการตรวจสภาพสภาพรถยนต์");
        jPanel8.add(jCheckW28, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, 350, -1));

        jCheckW29.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW29.setText("บันทึกการชี้ตัวผู้ต้องหา");
        jPanel8.add(jCheckW29, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 73, 350, -1));

        jCheckW30.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW30.setText("บันทึกการชี้รูปผู้ต้องหา");
        jPanel8.add(jCheckW30, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 106, 350, -1));

        jCheckW31.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW31.setText("บันทึกการจับกุม");
        jPanel8.add(jCheckW31, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 139, 350, -1));

        jCheckW32.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW32.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW32.setText("บันทึกการจับกุมผู้ต้องหาที่เป็นเด็กหรือเยาวชน");
        jPanel8.add(jCheckW32, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 40, 350, -1));

        jCheckW33.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW33.setText("บันทึกการตรวจค้น");
        jPanel8.add(jCheckW33, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 172, 350, -1));

        jCheckW34.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW34.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้น");
        jCheckW34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW34ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckW34, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 205, 350, -1));

        jCheckW35.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW35.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW35.setText("บัญชีการตรวจค้นโดยไม่มีหมายค้น");
        jPanel8.add(jCheckW35, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 238, 350, -1));

        jCheckW36.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW36.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW36.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้นโดยไม่มีหมายค้น");
        jPanel8.add(jCheckW36, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 271, 350, -1));

        jCheckW37.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW37.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW37.setText("ตำหนิรูปพรรณผู้กระทำความผิด");
        jPanel8.add(jCheckW37, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 304, 350, -1));

        jCheckW38.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW38.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW38.setText("หมายเรียกผู้ต้องหา");
        jPanel8.add(jCheckW38, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 337, 350, -1));

        jCheckW39.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW39.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW39.setText("หมายเรียกพยาน");
        jCheckW39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW39ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckW39, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 370, 350, -1));

        jCheckW46.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW46.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW46.setText("หนังสือแจ้งการขอประกันสิ่งของไปดูแลรักษาหรือใช้ประโยชน์");
        jPanel8.add(jCheckW46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 205, 445, -1));

        jCheckW5445.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW5445.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW5445.setText("สัญญาประกันและรับมอบสิ่งของ");
        jPanel8.add(jCheckW5445, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 172, 445, -1));

        jCheckW44.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW44.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW44.setText("คำร้องขอคืนสิ่งของ");
        jPanel8.add(jCheckW44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 139, 445, -1));

        jCheckW43.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW43.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW43.setText("บันทึกเสนอสัญญาประกันสิ่งของ");
        jPanel8.add(jCheckW43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 106, 445, -1));

        jCheckW42.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW42.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW42.setText("บันทึกคำขอรับชดใช้ค่าใช้จ่ายเบื้องต้นอันเกิดจากการขนส่ง");
        jPanel8.add(jCheckW42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 73, 445, -1));

        jCheckW41.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW41.setText("บันทึกการตกลงค่าเสียหาย");
        jPanel8.add(jCheckW41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 40, 445, -1));

        jCheckW53.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW53.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW53.setText("หนังสือแจ้งความคืบหน้าการสอบสวน");
        jPanel8.add(jCheckW53, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 238, 445, -1));

        jCheckW54.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW54.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW54.setText("แบบแจ้งรูปพรรณคนหาย");
        jPanel8.add(jCheckW54, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 271, 445, -1));

        jCheckW56.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW56.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW56.setText("แบบแจ้งผลการได้ตัวคนหายคืน");
        jPanel8.add(jCheckW56, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 337, 445, -1));

        jCheckW55.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW55.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW55.setText("แบบการสืบสวนติดตามคนหาย");
        jPanel8.add(jCheckW55, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 304, 445, -1));

        jCheckW57.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW57.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW57.setText("ตำหนิรูปพรรณทรัพย์หาย");
        jPanel8.add(jCheckW57, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 370, 445, -1));

        jCheckW58.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW58.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW58.setText("ตำหนิรูปพรรณทรัพย์หายได้คืน");
        jCheckW58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW58ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckW58, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 403, 445, -1));

        jCheckW59.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW59.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW59.setText("แบบรูปพรรณรถยนต์หรือรถจักรยนต์ที่ถูกโจรกรรม");
        jPanel8.add(jCheckW59, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 7, 460, -1));

        jCheckW60.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW60.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW60.setText("แบบรายการรถยนต์หรือรถจักรยานยนต์ที่ได้คืน");
        jPanel8.add(jCheckW60, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 40, 460, -1));

        jCheckW61.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW61.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW61.setText("แผนประทุษกรรม");
        jPanel8.add(jCheckW61, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 73, 460, -1));

        jCheckW7462.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW7462.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW7462.setText("บันทึกการควบคุมผู้ต้องหา");
        jPanel8.add(jCheckW7462, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 106, 460, -1));

        jCheckW63.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW63.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW63.setText("คำร้องขอสืบพยานไว้ก่อน");
        jPanel8.add(jCheckW63, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 139, 460, -1));

        jCheckW64.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW64.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW64.setText("บันทึกการพบและปรึกษาทนาย");
        jPanel8.add(jCheckW64, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 172, 460, -1));

        jCheckW65.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW65.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW65.setText("คำร้องขอส่งตัวผู้ต้องหาไปควบคุมตัวเพื่อพิสูจน์การเสพหรือการติดยาเสพติด");
        jPanel8.add(jCheckW65, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 205, 460, -1));

        jCheckW66.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW66.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW66.setText("คำร้องขอตรวจสอบการจับ");
        jPanel8.add(jCheckW66, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 370, 460, -1));

        jCheckW67.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW67.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW67.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่ 1");
        jPanel8.add(jCheckW67, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 238, 460, -1));

        jCheckW68.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW68.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW68.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่....");
        jPanel8.add(jCheckW68, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 271, 460, -1));

        jCheckW69.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW69.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW69.setText("คำร้องขอฝากครั้ง");
        jPanel8.add(jCheckW69, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 304, 460, -1));

        jCheckW70.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW70.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW70.setText("บันทึกเสนอสัญญาประกัน");
        jPanel8.add(jCheckW70, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 337, 460, -1));

        jCheckW71.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW71.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW71.setText("คำร้องและสัญญาประกัน");
        jCheckW71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW71ActionPerformed(evt);
            }
        });
        jPanel8.add(jCheckW71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1556, 403, 460, -1));

        jCheckW72.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW72.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW72.setText("คำยินยอมกรณีผู้ให้สัญญาค้ำประกันมีคู่สมรส");
        jPanel8.add(jCheckW72, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 0, 460, -1));

        jCheckW73.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW73.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW73.setText("บันทึกรับรองการป็นโสด");
        jPanel8.add(jCheckW73, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 33, 460, -1));

        jCheckW75.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW75.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW75.setText("บันทึกการสอบถามเบื้องต้น(กรณีเด็กหรือเยาวชน)");
        jPanel8.add(jCheckW75, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 66, 460, -1));

        jCheckW76.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW76.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW76.setText("หนังสือแจ้งการดำเนินคดีเด็กหรือเยาวชนไปยังสถานพินิจ");
        jPanel8.add(jCheckW76, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 99, 465, -1));

        jCheckW77.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW77.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW77.setText("หนังสือแจ้งการจับกุมเด็กหรือเยาวชนไปยังสถานพินิจ");
        jPanel8.add(jCheckW77, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 132, 465, -1));

        jCheckW47.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW47.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW47.setText("หนังสือรายงานคนต่างด้าวเป็นผู้เสียหายในคดีอุกฉกรรจ์หรือตายโดยธรรมชาติ");
        jPanel8.add(jCheckW47, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 165, -1, -1));

        jCheckW48.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW48.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW48.setText("หนังสือรายงานคนต่างด้าวกระทำความผิดและถูกจับกุมตัวดำเนินคดี");
        jPanel8.add(jCheckW48, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 198, 465, -1));

        jCheckW49.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW49.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW49.setText("หนังสือขอส่งตัวคนต่างด้าว");
        jPanel8.add(jCheckW49, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 231, 465, -1));

        jCheckW50.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW50.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW50.setText("หนังสือขอส่งรายละเอียดเกี่ยวกับคนต่างด้าวถูกกักขังหรือกักขังแทนค่าปรับ");
        jPanel8.add(jCheckW50, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 264, 465, -1));

        jCheckW51.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW51.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW51.setText("หนังสือขอส่งตัวคนต่างด้าวหลบหนีเข้าเมืองมาเพื่อดำเนินการผลักดันออกไปนอกราชอาณาจักร");
        jPanel8.add(jCheckW51, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 297, 570, -1));

        jCheckW52.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW52.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW52.setText("หนังสือขอให้ตรวจสอบหนังสือเดินทางหรือเอกสารที่ใช้แทนการเดินทางของบุคคลต่างด้าว");
        jPanel8.add(jCheckW52, new org.netbeans.lib.awtextra.AbsoluteConstraints(2016, 330, 565, -1));

        jCheckW40.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW40.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW40.setText("บันทึกการแจ้งสิทธิตาม พ.ร.บ. ค่าตอบแทนผู้เสียหาย และค่าทดแทน \n");
        jPanel8.add(jCheckW40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 7, -1, -1));

        jCheckW62.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW62.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW62.setText("บันทึกการควบคุมผู้ต้องหา");
        jPanel8.add(jCheckW62, new org.netbeans.lib.awtextra.AbsoluteConstraints(2020, 360, 570, -1));

        jScrollPane1.setViewportView(jPanel8);

        jButtonPrintDoc.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonPrintDoc.setText("พิมพ์เอกสาร");
        jButtonPrintDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintDocActionPerformed(evt);
            }
        });

        jLabel32.setText("caseid");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPrintDoc)
                .addGap(73, 73, 73))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPrintDoc)
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("รายงาน", jPanel10);

        jScrollPane5.setOpaque(false);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารเกี่ยวกับต่างด้าว คนหายและเยาวชน", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N

        jCheckW247.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW247.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW247.setText("หนังสือรายงานคนต่างด้าวเป็นผู้เสียหายในคดีอุกฉกรรจ์หรือตายโดยธรรมชาติ");
        jCheckW247.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW248.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW248.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW248.setText("หนังสือรายงานคนต่างด้าวกระทำความผิดและถูกจับกุมตัวดำเนินคดี");
        jCheckW248.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW249.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW249.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW249.setText("หนังสือขอส่งตัวคนต่างด้าว");
        jCheckW249.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW250.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW250.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW250.setText("หนังสือขอส่งรายละเอียดเกี่ยวกับคนต่างด้าวถูกกักขังหรือกักขังแทนค่าปรับ");
        jCheckW250.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW251.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW251.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW251.setText("หนังสือขอส่งตัวคนต่างด้าวหลบหนีเข้าเมืองมาเพื่อดำเนินการผลักดันออกไปนอกราชอาณาจักร");
        jCheckW251.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW252.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW252.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW252.setText("หนังสือขอให้ตรวจสอบหนังสือเดินทางหรือเอกสารที่ใช้แทนการเดินทางของบุคคลต่างด้าว");
        jCheckW252.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW254.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW254.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW254.setText("แบบแจ้งรูปพรรณคนหาย");
        jCheckW254.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW255.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW255.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW255.setText("แบบการสืบสวนติดตามคนหาย");
        jCheckW255.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW256.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW256.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW256.setText("แบบแจ้งผลการได้ตัวคนหายคืน");
        jCheckW256.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW275.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW275.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW275.setText("บันทึกการสอบถามเบื้องต้น(กรณีเด็กหรือเยาวชน)");
        jCheckW275.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW276.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW276.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW276.setText("หนังสือแจ้งการดำเนินคดีเด็กหรือเยาวชนไปยังสถานพินิจ");
        jCheckW276.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW277.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW277.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW277.setText("หนังสือแจ้งการจับกุมเด็กหรือเยาวชนไปยังสถานพินิจ");
        jCheckW277.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW232.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW232.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW232.setText("บันทึกการจับกุมผู้ต้องหาที่เป็นเด็กหรือเยาวชน");
        jCheckW232.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW278.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW278.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW278.setText("หนังสือแจ้งการจับกุมเด็กหรือเยาวชนไปยังผู้ปกครอง");
        jCheckW278.setPreferredSize(new java.awt.Dimension(384, 33));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW249, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW250, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW252, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW247, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW248, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
                    .addComponent(jCheckW251, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW254, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW278, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW232, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW255, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW277, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW276, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW275, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW256, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jCheckW247, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW248, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW249, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW251, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW252, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jCheckW255, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW256, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW275, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW276, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW277, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckW254, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW278, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารเกี่ยวกับคดี", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckW201.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW201.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW201.setText("บันทึกการตรวจสำนวนการสอบสวน");
        jPanel14.add(jCheckW201, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 32, 384, -1));

        jCheckW202.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW202.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW202.setText("หนังสือส่งสำนวนคดีที่เห็นควรงดหรือให้งดการสอบสวน");
        jCheckW202.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW202ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW202, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, 384, -1));

        jCheckW203.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW203.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW203.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้อง แต่ยังไม่ได้ตัวผู้ต้องหา");
        jPanel14.add(jCheckW203, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, 384, -1));

        jCheckW204.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW204.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW204.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้องหรือไม่สั่งฟ้อง");
        jCheckW204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW204ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW204, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, 384, -1));

        jCheckW205.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW205.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW205.setText("รายงานการสอบสวน");
        jPanel14.add(jCheckW205, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 194, 384, -1));

        jCheckW206.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW206.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW206.setText("รายงานการสอบสวนสำนวนคดีไม่ปรากฎว่าผู้ใดเป็นผู้กระทำผิด");
        jCheckW206.setPreferredSize(new java.awt.Dimension(384, 33));
        jCheckW206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW206ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW206, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 161, -1, -1));

        jCheckW207.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW207.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW207.setText("รายงานการสอบสวนสำนวนชันสูตรพลิกศพ");
        jPanel14.add(jCheckW207, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 293, 384, -1));

        jCheckW208.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW208.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW208.setText("บันทึกคำให้การผู้กล่าวหา หรือพยาน");
        jPanel14.add(jCheckW208, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 227, 384, -1));

        jCheckW209.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW209.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW209.setText("บันทึกคำให้การผู้ต้องหา");
        jPanel14.add(jCheckW209, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 260, 384, -1));

        jCheckW226.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW226.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW226.setText("หนังสือส่งยาเสพติดของกลางไปตรวจพิสูจน์");
        jCheckW226.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW226ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW226, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 321, -1));

        jCheckW225.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW225.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW225.setText("หนังสือส่งของกลางไปตรวจพิสูจน์");
        jCheckW225.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW225ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW225, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 314, -1));

        jCheckW216.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW216.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW216.setText("บันทึกพนักงานสอบสวน");
        jPanel14.add(jCheckW216, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 326, 384, -1));

        jCheckW293.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW293.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW293.setText("หมายจับ");
        jPanel14.add(jCheckW293, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 314, -1));

        jCheckW227.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW227.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW227.setText("ฉลากปิดภาชนะบรรจุยาเสพติด");
        jCheckW227.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW227ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW227, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 321, -1));

        jCheckW238.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW238.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW238.setText("หมายเรียกผู้ต้องหา");
        jPanel14.add(jCheckW238, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 314, -1));

        jCheckW239.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW239.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW239.setText("หมายเรียกพยาน");
        jCheckW239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW239ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW239, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 314, -1));

        jCheckW231.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW231.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW231.setText("บันทึกการจับกุม");
        jPanel14.add(jCheckW231, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 314, -1));

        jCheckW229.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW229.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW229.setText("บันทึกการชี้ตัวผู้ต้องหา");
        jPanel14.add(jCheckW229, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 314, -1));

        jCheckW230.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW230.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW230.setText("บันทึกการชี้รูปผู้ต้องหา");
        jPanel14.add(jCheckW230, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 314, -1));

        jCheckW280.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW280.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW280.setText("บัญชีสำนวนการสอบสวน");
        jCheckW280.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW280ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW280, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 314, -1));

        jCheckW262.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW262.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW262.setText("บันทึกการควบคุมผู้ต้องหา");
        jCheckW262.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW262ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW262, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 330, -1));

        jCheckW263.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW263.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW263.setText("คำร้องขอสืบพยานไว้ก่อน");
        jPanel14.add(jCheckW263, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 330, -1));

        jCheckW264.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW264.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW264.setText("บันทึกการพบและปรึกษาทนาย");
        jPanel14.add(jCheckW264, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 330, -1));

        jCheckW220.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW220.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW220.setText("บันทึกการนำชี้ที่เกิดเหตุประกอบคำรับสารภาพ");
        jPanel14.add(jCheckW220, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 330, -1));

        jCheckW219.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW219.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW219.setText("แผนที่สังเขปแสดงสถานที่เกิดเหตุ");
        jPanel14.add(jCheckW219, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 330, -1));

        jCheckW218.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW218.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW218.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีจราจรทางบก");
        jPanel14.add(jCheckW218, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 330, -1));

        jCheckW217.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW217.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW217.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีอาญา");
        jPanel14.add(jCheckW217, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 330, -1));

        jCheckW237.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW237.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW237.setText("ตำหนิรูปพรรณผู้กระทำความผิด");
        jPanel14.add(jCheckW237, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 330, -1));

        jCheckW266.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW266.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW266.setText("คำร้องขอตรวจสอบการจับ");
        jPanel14.add(jCheckW266, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 330, -1));

        jCheckW233.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW233.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW233.setText("บันทึกการตรวจค้น");
        jPanel14.add(jCheckW233, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 359, 391, -1));

        jCheckW261.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW261.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW261.setText("แผนประทุษกรรม");
        jPanel14.add(jCheckW261, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 321, -1));

        jCheckW228.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW228.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW228.setText("บันทึกการตรวจสภาพสภาพรถยนต์");
        jPanel14.add(jCheckW228, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 259, -1));

        jCheckW253.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW253.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW253.setText("หนังสือแจ้งความคืบหน้าการสอบสวน");
        jCheckW253.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW253ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW253, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 314, -1));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารผัดฟ้องและอื่นๆ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N

        jCheckW240.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW240.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW240.setText("บันทึกการแจ้งสิทธิตาม พ.ร.บ. ค่าตอบแทนผู้เสียหาย และค่าทดแทน \n");

        jCheckW241.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW241.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW241.setText("บันทึกการตกลงค่าเสียหาย");

        jCheckW242.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW242.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW242.setText("บันทึกคำขอรับชดใช้ค่าใช้จ่ายเบื้องต้นอันเกิดจากการขนส่ง");

        jCheckW221.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW221.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW221.setText("ใบนำส่งผู้บาดเจ็บหรือศพ");

        jCheckW222.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW222.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW222.setText("หนังสือส่งผู้ต้องหาป่วยทางจิตตรวจวินิจฉัย");

        jCheckW223.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW223.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW223.setText("รายงานชันสูตรพลิกศพ");

        jCheckW224.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW224.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW224.setText("แบบรายงานพบศพไม่ทราบชื่อ");
        jCheckW224.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW224ActionPerformed(evt);
            }
        });

        jCheckW265.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW265.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW265.setText("คำร้องขอส่งตัวผู้ต้องหาไปควบคุมตัวเพื่อพิสูจน์การเสพหรือการติดยาเสพติด");

        jCheckW269.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW269.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW269.setText("คำร้องขอฝากขัง");
        jCheckW269.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW269ActionPerformed(evt);
            }
        });

        jCheckW268.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW268.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW268.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่....");

        jCheckW267.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW267.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW267.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่ 1");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW240)
                    .addComponent(jCheckW241, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW242, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW268, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW269, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW267, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW265, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW224, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW221, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW223, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW222, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jCheckW240)
                .addGap(0, 0, 0)
                .addComponent(jCheckW241)
                .addGap(0, 0, 0)
                .addComponent(jCheckW242)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckW265)
                .addGap(0, 0, 0)
                .addComponent(jCheckW267)
                .addGap(0, 0, 0)
                .addComponent(jCheckW268)
                .addGap(0, 0, 0)
                .addComponent(jCheckW269))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jCheckW221)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jCheckW223))
                    .addComponent(jCheckW222))
                .addGap(0, 0, 0)
                .addComponent(jCheckW224))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารทรัพย์ ประกัน", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N

        jCheckW246.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW246.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW246.setText("หนังสือแจ้งการขอประกันสิ่งของไปดูแลรักษาหรือใช้ประโยชน์");
        jCheckW246.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW246ActionPerformed(evt);
            }
        });

        jCheckW245.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW245.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW245.setText("สัญญาประกันและรับมอบสิ่งของ");

        jCheckW244.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW244.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW244.setText("คำร้องขอคืนสิ่งของ");

        jCheckW243.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW243.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW243.setText("บันทึกเสนอสัญญาประกันสิ่งของ");

        jCheckW215.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW215.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW215.setText("บัญชีทรัพย์ที่ถูกเพลิงไหม้");
        jCheckW215.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW215ActionPerformed(evt);
            }
        });

        jCheckW213.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW213.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW213.setText("บัญชีทรัพย์ถูกประทุษร้ายได้คืน");

        jCheckW214.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW214.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW214.setText("บัญชีทรัพย์ถูกประทุษร้ายไม่ได้คืน");
        jCheckW214.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW214ActionPerformed(evt);
            }
        });

        jCheckW212.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW212.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW212.setText("บัญชีทรัพย์ถูกประทุษร้าย");

        jCheckW234.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW234.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW234.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้น");
        jCheckW234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW234ActionPerformed(evt);
            }
        });

        jCheckW257.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW257.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW257.setText("ตำหนิรูปพรรณทรัพย์หาย");

        jCheckW258.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW258.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW258.setText("ตำหนิรูปพรรณทรัพย์หายได้คืน");
        jCheckW258.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW258ActionPerformed(evt);
            }
        });

        jCheckW273.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW273.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW273.setText("บันทึกรับรองการป็นโสด");

        jCheckW272.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW272.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW272.setText("คำยินยอมกรณีผู้ให้สัญญาค้ำประกันมีคู่สมรส");

        jCheckW270.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW270.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW270.setText("บันทึกเสนอสัญญาประกัน");

        jCheckW271.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW271.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW271.setText("คำร้องและสัญญาประกัน");
        jCheckW271.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW271ActionPerformed(evt);
            }
        });

        jCheckW236.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW236.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW236.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW235.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW235.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW235.setText("บัญชีการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW260.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW260.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW260.setText("แบบรายการรถยนต์หรือรถจักรยานยนต์ที่ได้คืน");

        jCheckW259.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW259.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW259.setText("แบบรูปพรรณรถยนต์หรือรถจักรยนต์ที่ถูกโจรกรรม");
        jCheckW259.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW259ActionPerformed(evt);
            }
        });

        jCheckW211.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW211.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW211.setText("บัญชีของกลางคดีอาญา");

        jCheckW274.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW274.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW274.setText("หนังสือแจ้งอายัดตั๋วฯ");
        jCheckW274.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW274ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW212, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW234, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckW235, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckW236, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckW215, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW214, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(jCheckW213, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW211, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW244, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW245, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW271, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW270, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW273, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckW246)
                    .addComponent(jCheckW243, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW272, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW260)
                    .addComponent(jCheckW259)
                    .addComponent(jCheckW258, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW257, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW274, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jCheckW260)
                                .addGap(99, 99, 99)
                                .addComponent(jCheckW211))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jCheckW259)
                                .addGap(99, 99, 99)))
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW213))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckW212)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jCheckW215))
                            .addComponent(jCheckW234))
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW214)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW235)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jCheckW236))))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckW257)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW258))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckW243)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW244, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW245)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW246)))
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckW272)
                    .addComponent(jCheckW274))
                .addGap(0, 0, 0)
                .addComponent(jCheckW273)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckW270)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckW271))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel12);

        jLabel33.setText("caseid");

        jButtonPrintDoc2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonPrintDoc2.setText("พิมพ์เอกสาร");
        jButtonPrintDoc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintDoc2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jButtonPrintDoc2)
                .addGap(85, 85, 85))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jButtonPrintDoc2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab4", jPanel11);

        jButtonSaveCase.setBackground(new java.awt.Color(0, 51, 102));
        jButtonSaveCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonSaveCase.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSaveCase.setText("บันทึก");
        jButtonSaveCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCaseActionPerformed(evt);
            }
        });

        jButtonEditCase.setBackground(new java.awt.Color(0, 51, 102));
        jButtonEditCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonEditCase.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditCase.setText("แก้ไข");
        jButtonEditCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditCaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelChargeCode)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonSaveCase, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditCase, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(151, 151, 151))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelChargeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSaveCase)
                    .addComponent(jButtonEditCase))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCaseActionPerformed
        // TODO add your handling code here:

        con=ConnectDatabase.connect();
         try{
         Statement st = con.createStatement();
        String sqlCheck="Select CaseId from CrimeCase where CaseId='"+crimecaseid.getText()+"'";
        System.out.println("Check : "+sqlCheck);
         ResultSet rc = st.executeQuery(sqlCheck);
        if(rc.next()){
        
        isInsert=false;
        }
        else{
         isInsert=true;
        }
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String requestTime = format.format(CaseRequestTimee.getValue());
        String acceptTime = format.format(CaseAcceptTimee.getValue());
        String orcuredTime=format.format(OccuredDateTime.getValue());


        if(isInsert){
            String sql="INSERT INTO CrimeCase (CaseType,crimecaseno,crimecaseyears,ChargeCodeCase,ActionCodeCase,CaseRequestDate,CaseRequestTime,"+
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
                pst.setString(17,CrimeLocationDistrict.getSelectedItem().toString());
                pst.setString(18,CrimeLocationAmphur.getSelectedItem().toString());
                pst.setString(19,CrimeLocationProvince.getSelectedItem().toString());
                
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
         jButtonSaveCase.setEnabled(false);
         jButtonEditCase.setEnabled(true);
         CloseTextBox();
//         JSONObject data=new JSONObject();
//         data.put("caseid", caseidLast);
//           JFrame frame = new JFrame();
//        JDialog dialog = new JDialog(frame);//frame is owner
//        JFrame fr = (JFrame)(dialog.getParent());
//        fr.removeAll();
//        ReportforCrimesCase n=new ReportforCrimesCase(fr,data);
//        n.pack();
//        n.setLocationRelativeTo(null);
//        n.setVisible(true);

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
                pst.setString(13,CrimeLocationDistrict.getSelectedItem().toString());
                pst.setString(14,CrimeLocationAmphur.getSelectedItem().toString());
                pst.setString(15,CrimeLocationProvince.getSelectedItem().toString());
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
                pst.setString(38,crimecaseid.getText());
                
               int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการแก้ไขข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
         jButtonSaveCase.setEnabled(false);
         jButtonEditCase.setEnabled(true);
         CloseTextBox();
         System.out.println("SQL : "+sqlUpdate);
//           JFrame frame = new JFrame();
//        JDialog dialog = new JDialog(frame);//frame is owner
//        JFrame fr = (JFrame)(dialog.getParent());
//        fr.removeAll();
//        JSONObject data=new JSONObject();
//         data.put("caseid", caseid);
//        ReportforCrimesCase n=new ReportforCrimesCase(fr,data);
//        n.pack();
//        n.setLocationRelativeTo(null);
//        n.setVisible(true);

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
 JSONObject data2 = new JSONObject();
             data2.put("caseid", crimecaseid.getText());     
             data2.put("typecase", "อาญา");

        if(ActionCrimes.getText().length()==0 || ActionCrimes.getText()==null|| ActionCrimes.getText().isEmpty()){
           
            ActionPage d = new ActionPage(fr,null,data2);
            d.pack();
            d.setLocationRelativeTo(null);
            d.setVisible(true);
        }
        else {

            try{
                //                String crimecaseno = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)+"";
                String actionCode=jLabelActionCode.getText();
                String sql="select * From ActionsCaseData where ActionsCaseData.ActionCodeCase='"+actionCode+"' and ActionCaseId="+crimecaseid.getText();
                                System.out.println("ExSql : "+sql);
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("ActionCodeCase", rs.getString("ActionCodeCase"));
                    data.put("ActionCrimesCase", rs.getString("ActionCrimesCase"));
                    data.put("ActionDetailCase", rs.getString("ActionDetailCase"));
                    data.put("AnswerSuspectCase", rs.getString("AnswerSuspectCase"));
                    data.put("AnswerAccuserCase", rs.getString("AnswerAccuserCase"));
                    data.put("ActionNoteCase", rs.getString("ActionNoteCase"));
                    data.put("ActionCaseId", rs.getString("ActionCaseId"));
                    

                    ActionPage d = new ActionPage(fr,data,data2);
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
            JSONObject data = new JSONObject();
            data.put("caseid",crimecaseid.getText());
            ChargePage d = new ChargePage(f,null,data);
            d.pack();
            d.setLocationRelativeTo(null);
            d.setVisible(true);
        }
        else {

            try{
                //                String crimecaseno = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0)+"";
                String chargeCode=jLabelChargeCode.getText();
                String sql="select * From ChargeCase where ChargeCase.ChargeCodeCase ='"+chargeCode+"' and ChargeCaseId="+crimecaseid.getText();
                System.out.println("ExSql : "+sql);
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("ChargeCodeCase", rs.getString("ChargeCodeCase"));
                    data.put("ChargeNameCase", rs.getString("ChargeNameCase"));
                    data.put("LawCase", rs.getString("LawCase"));
                    data.put("RateOfPenaltyCase", rs.getString("RateOfPenaltyCase"));
                    data.put("NoteCase", rs.getString("NoteCase"));
                    data.put("ChargeCaseId", rs.getString("ChargeCaseId"));
                    

                    ChargePage d = new ChargePage(f,data,null);
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
         String aa=crimecaseid.getText();
        String type="อาญา";
        JSONObject data = new JSONObject();
        data.put("CaseId",aa );
        data.put("TypeCase",type );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame asv = (JFrame)(dialog.getParent());
        asv.removeAll();
        AssetOverView as =new AssetOverView(asv,data);
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

    private void jButtonAddInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInvestActionPerformed
        String ci=crimecaseid.getText();
        JSONObject data = new JSONObject();
        data.put("CaseIdRec",ci );
         data.put("TypeCase","จราจร" );        
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

private void jButtonPrintDoc2ActionPerformed(java.awt.event.ActionEvent evt) {  
     String no=crimecaseid.getText();
          caseyear=crimecaseyear.getText();
           caseno=crimecaseno.getText();
           casetype=CaseType.getText();
        File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);

        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
        /// สำหรับ tab 4
           if(jCheckW201.isSelected()){
            W1.w1(no);
        }

                if(jCheckW202.isSelected()){
            W2.w2(no);

        }
        if(jCheckW203.isSelected()){
            W3.w3(no);
        }
        if(jCheckW204.isSelected()){
            W4.w4(no);
        }
        if(jCheckW205.isSelected()){
            W5.w5(no);
        }
        if(jCheckW206.isSelected()){
            W6.w6(no);
        }
        /*
        if(jCheckW207.isSelected()){
            W7.w7(no);
        }*/
        if(jCheckW208.isSelected()){
            W8.w8(no);
        }
        if(jCheckW209.isSelected()){
            W9.w9(no);
        }
        if(jCheckW211.isSelected()){
            W11.w11(no);
        }
        if(jCheckW212.isSelected()){
            W12.w12(no);
          }
        if(jCheckW213.isSelected()){
            W13.w13(no);
            }
         if(jCheckW214.isSelected()){
             W14.w14(no);
             }
                if(jCheckW215.isSelected()){
                        W15.w15(no);
                    }
               if(jCheckW216.isSelected()){
                        W16.w16(no);
                    }
               if(jCheckW217.isSelected()){
                        W17.w17(no);
                    }
              // if(jCheckW218.isSelected()){
                  //      W18.w18(no);
                  //  }
               if(jCheckW219.isSelected()){
                        W19.w19(no);
                    }
               if(jCheckW220.isSelected()){
                        W20.w20(no);
                    }
               
               if(jCheckW221.isSelected()){
                        W21.w21(no);
                    }
               if(jCheckW222.isSelected()){
                        W22.w22(no);
                    }
               if(jCheckW223.isSelected()){
                        W23.w23(no);
                    }
               if(jCheckW224.isSelected()){
                        W24.w24(no);
                    }
               if(jCheckW225.isSelected()){
                        W25.w25(no);
                    }
               
               if(jCheckW226.isSelected()){
                        W26.w26(no);
                    }
               if(jCheckW227.isSelected()){
                        W27.w27(no);
                    }
               if(jCheckW228.isSelected()){
                        W28.w28(no);
                    }
               if(jCheckW229.isSelected()){
                        W29.w29(no);
                    }
               if(jCheckW230.isSelected()){
                        W30.w30(no);
                    }
               if(jCheckW231.isSelected()){
                        W31.w31(no);
                    }
               if(jCheckW232.isSelected()){
                        W32.w32(no);
                    }
               if(jCheckW233.isSelected()){
                        W33.w33(no);
                    }
               if(jCheckW234.isSelected()){
                        W34.w34(no);
                    }
               if(jCheckW235.isSelected()){
                        W35.w35(no);
                    }
               if(jCheckW236.isSelected()){
                        W36.w36(no);
                    }
               if(jCheckW237.isSelected()){
                        W37.w37(no);
                    }
               if(jCheckW238.isSelected()){
                        W38.w38(no);
                    }
               if(jCheckW239.isSelected()){
                        W39.w39(no);
                    }
               if(jCheckW240.isSelected()){
                     W40.w40(no);
                  }
               if(jCheckW241.isSelected()){
                        W41.w41(no);
                    }
              if(jCheckW242.isSelected()){
                        W42.w42(no);
                    }
              if(jCheckW243.isSelected()){
                        W43.w43(no);
                    }
              if(jCheckW244.isSelected()){
                        W44.w44(no);
                    }
              if(jCheckW245.isSelected()){
                        W45.w45(no);
                    }
               if(jCheckW246.isSelected()){
                        W46.w46(no);
                    }
               if(jCheckW247.isSelected()){
                        W47.w47(no);
                    }
               if(jCheckW248.isSelected()){
                        W48.w48(no);
                    }
               if(jCheckW249.isSelected()){
                        W49.w49(no);
                    }
               if(jCheckW250.isSelected()){
                        W50.w50(no);
                    }
               if(jCheckW251.isSelected()){
                        W51.w51(no);
                    }
               if(jCheckW252.isSelected()){
                        W52.nw52();
                    }
               if(jCheckW253.isSelected()){
                        W53.w53(no);
                    }
               if(jCheckW262.isSelected()){
                        W62.w62(no);
                    }
               if(jCheckW263.isSelected()){
                        W63.w63(no);
                    }
               if(jCheckW264.isSelected()){
                        W64.w64(no);
                    }
               if(jCheckW265.isSelected()){
                        W65.w65(no);
                    }
               if(jCheckW266.isSelected()){
                        //W66.w66(no);
                    }
               if(jCheckW267.isSelected()){
                        W67.w67(no);
                    }
              if(jCheckW268.isSelected()){
                     // W68.w68(no);
                  }
               if(jCheckW269.isSelected()){
                        W69.w69(no);
                    }
               if(jCheckW270.isSelected()){
                        W70.w70(no);
                    }
               if(jCheckW271.isSelected()){
                        W71.w71(no);
                    }
               if(jCheckW272.isSelected()){
                        W72.nw72();
                    }
               if(jCheckW273.isSelected()){
                        W73.w73(no);
                    }
               if(jCheckW274.isSelected()){
                        W74.w74(no);
                    }
               if(jCheckW275.isSelected()){
                        W75.w75(no);
                    }
               if(jCheckW276.isSelected()){
                        W76.w76(no);
                    }
               if(jCheckW280.isSelected()){
                        W80.w80(no);
                    }
               if(jCheckW93.isSelected()){
                        W93.w93(no);
                    }
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }
    
}
    private void jButtonPrintDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintDocActionPerformed
        // TODO add your handling code here:
        String no=crimecaseid.getText();
          caseyear=crimecaseyear.getText();
           caseno=crimecaseno.getText();
           casetype=CaseType.getText();
        File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);

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
        if(jCheckW7.isSelected()){
            //W7.w7(no);
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
                if(jCheckW15.isSelected()){
                        W15.w15(no);
                    }
               if(jCheckW16.isSelected()){
                        W16.w16(no);
                    }
               if(jCheckW17.isSelected()){
                        W17.w17(no);
                    }
               if(jCheckW18.isSelected()){
                       W18.w18(no);
                   }
               if(jCheckW18.isSelected()){
                        W19.w19(no);
                    }
               if(jCheckW20.isSelected()){
                        W20.w20(no);
                    }
               
               if(jCheckW21.isSelected()){
                        W21.w21(no);
                    }
               if(jCheckW22.isSelected()){
                        W22.w22(no);
                    }
               if(jCheckW23.isSelected()){
                        W23.w23(no);
                    }
               if(jCheckW24.isSelected()){
                        W24.w24(no);
                    }
               if(jCheckW25.isSelected()){
                        W25.w25(no);
                    }
               if(jCheckW26.isSelected()){
                        W26.w26(no);
                    }
               if(jCheckW27.isSelected()){
                        W27.w27(no);
                    }
               if(jCheckW28.isSelected()){
                        W28.w28(no);
                    }
               if(jCheckW29.isSelected()){
                        W29.w29(no);
                    }
               if(jCheckW30.isSelected()){
                        W30.w30(no);
                    }
               if(jCheckW31.isSelected()){
                        W31.w31(no);
                    }
               if(jCheckW32.isSelected()){
                        W32.w32(no);
                    }
        
               if(jCheckW33.isSelected()){
                        W33.w33(no);
                    }
               if(jCheckW34.isSelected()){
                        W34.w34(no);
                    }
               if(jCheckW35.isSelected()){
                        W35.w35(no);
                    }
               if(jCheckW36.isSelected()){
                        W36.w36(no);
                    }
               if(jCheckW37.isSelected()){
                        W37.w37(no);
                    }
               if(jCheckW38.isSelected()){
                        W38.w38(no);
                    }
               if(jCheckW39.isSelected()){
                        W39.w39(no);
                    }
               if(jCheckW40.isSelected()){
                       W40.w40(no);
                   }
               if(jCheckW41.isSelected()){
                        W41.w41(no);
                    }
              if(jCheckW43.isSelected()){
                        W43.w43(no);
                    }
               if(jCheckW46.isSelected()){
                        W46.w46(no);
                    }
               if(jCheckW47.isSelected()){
                        W47.w47(no);
                    }
               if(jCheckW48.isSelected()){
                        W48.w48(no);
                    }
               if(jCheckW49.isSelected()){
                        W49.w49(no);
                    }
               if(jCheckW50.isSelected()){
                        W50.w50(no);
                    }
               if(jCheckW51.isSelected()){
                        W51.w51(no);
                    }
               if(jCheckW53.isSelected()){
                        W53.w53(no);
                    }
               if(jCheckW62.isSelected()){
                        W62.w62(no);
                    }
               if(jCheckW67.isSelected()){
                        W67.w67(no);
                    }
        //       if(jCheckW68.isSelected()){
            //            W68.w68(no);
            //        }
               if(jCheckW69.isSelected()){
                        W69.w69(no);
                    }
               if(jCheckW70.isSelected()){
                        W70.w70(no);
                    }
               if(jCheckW71.isSelected()){
                        W71.w71(no);
                    }
              /* if(jCheckW72.isSelected()){
                        W72.w72(no);
                    }
               if(jCheckW73.isSelected()){
                        W73.w73(no);
                    }
               if(jCheckW74.isSelected()){
                        W74.w74(no);
                    }
               */
               if(jCheckW80.isSelected()){
                        W80.w80(no);
                    }
               if(jCheckW93.isSelected()){
                        W93.w93(no);
                    }
               
              
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }

    }//GEN-LAST:event_jButtonPrintDocActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        closeAllDialogs();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CrimeLocationProvinceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CrimeLocationProvinceItemStateChanged
        // TODO add your handling code here:
        String provinceid="";
        Connection con2 = ConnectDatabase.connect();
        try {
            Statement st2 = con2.createStatement();
            String a="select Province.DOPA_CODE DOPA_CODE,Province.PROVINCEID PROVINCEID from Province\n"+
            "where Province.NAMEPROVINCE='"+CrimeLocationProvince.getSelectedItem()+"'";
                    	ResultSet res2 = st2.executeQuery(a);
System.out.println("provinceid: "+CrimeLocationProvince.getSelectedItem());
        if(res2.next()){
        provinceid=res2.getString("PROVINCEID");
        }
	Statement st = con2.createStatement();
        	String c = "select Amphur.NameAmphur NameAmphur\n" +
                            "from Amphur\n" +
                            "where Amphur.DOPA_CODE like '"+provinceid+"%';";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
//	           System.out.println("provinceid: "+provinceid);
CrimeLocationAmphur.removeAllItems();
	while(res.next())
	{
	CrimeLocationAmphur.addItem(res.getString("NameAmphur"));

	
	}
        }
        catch (Exception d) {  //System.out.println(d);  
}
    }//GEN-LAST:event_CrimeLocationProvinceItemStateChanged

    private void CrimeLocationProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrimeLocationProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CrimeLocationProvinceActionPerformed

    private void jButtonEditCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditCaseActionPerformed
        // TODO add your handling code here:
        jButtonSaveCase.setEnabled(true);
        openTextBox();
    }//GEN-LAST:event_jButtonEditCaseActionPerformed

    private void jCheckW2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW2ActionPerformed

    private void jCheckW93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW93ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW93ActionPerformed

    private void jCheckW39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW39ActionPerformed

    private void jCheckW58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW58ActionPerformed

    private void jCheckW71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW71ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW71ActionPerformed
/**/
    private void jCheckW202ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW202ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW202ActionPerformed

    private void jCheckW239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW239ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW239ActionPerformed

    private void jCheckW258ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW258ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW258ActionPerformed

    private void jCheckW271ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW271ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW271ActionPerformed

    private void jCheckW259ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW259ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW259ActionPerformed

    private void jCheckW234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW234ActionPerformed

    private void jCheckW214ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW214ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW214ActionPerformed

    private void jCheckW246ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW246ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW246ActionPerformed

    private void jCheckW215ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW215ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW215ActionPerformed

    private void jCheckW224ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW224ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW224ActionPerformed

    private void jCheckW206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW206ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW206ActionPerformed

    private void jCheckW269ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW269ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW269ActionPerformed

    private void jCheckW204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW204ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW204ActionPerformed

    private void jCheckW280ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW280ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW280ActionPerformed

    private void jCheckW226ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW226ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW226ActionPerformed

    private void jCheckW227ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW227ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW227ActionPerformed

    private void jCheckW225ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW225ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW225ActionPerformed

    private void jCheckW262ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW262ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW262ActionPerformed

    private void jCheckW274ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW274ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW274ActionPerformed

    private void jCheckW253ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW253ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW253ActionPerformed

    private void jCheckW34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW34ActionPerformed

    private void jCheckW1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW1ActionPerformed
/*
    private void jButtonPrintDoc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintDoc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPrintDoc2ActionPerformed
    */
    public static void closeAllDialogs()
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
    
      public void comboProvince(){
    
     try {

         Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select nameprovince,PROVINCEID from province";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
             int Province_id = Integer.parseInt(res.getString("PROVINCEID"));
              Province_name = res.getString("nameprovince"); 
	CrimeLocationProvince.addItem(res.getString("nameprovince"));
        

	
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
    
    public void openTextBox(){
//    RestoreDate.setVisible(false);  
  
  crimecaseno.setEnabled(true);
       crimecaseyear.setEnabled(true);
       jButtonAction.setEnabled(true);
       jButtonCharge.setEnabled(true);
       ActionCrimes.setEnabled(true);
       ChargeNameCase.setEnabled(true);
       OccuredDateTime.setEnabled(true);
       CaseRequestTimee.setEnabled(true);
       CaseAcceptTimee.setEnabled(true);
       CaseAcceptTimee.setEnabled(true);
            CaseAcceptDate.getComponent(1).setEnabled(true);
       CaseAcceptDate.getJFormattedTextField().setEnabled(true);
            CaseRequestDateTime.getComponent(1).setEnabled(true);
       CaseRequestDateTime.getJFormattedTextField().setEnabled(true);     
       OccuredDate.getComponent(1).setEnabled(true);
       OccuredDate.getJFormattedTextField().setEnabled(true);
        DailyNumber.setEnabled(true);
       CrimeLocation.setEnabled(true);
       CrimeLocationMoo.setEnabled(true);
       CrimeLocationSoi.setEnabled(true);
       CrimeLocationRoad.setEnabled(true);
       CrimeLocationProvince.setEnabled(true);
       CrimeLocationAmphur.setEnabled(true);
       CrimeLocationDistrict.setEnabled(true);
       jComboPoliceName.setEnabled(true);
       jButtonAccured.setEnabled(true);
         jButtonSuspect.setEnabled(true);
       jButtonWitness.setEnabled(true);
       jTextInvestSendtoDepartment.setEnabled(true);
       Investigator_Number.setEnabled(true);
        Invest_SendCaseDate.getComponent(1).setEnabled(true);
       Invest_SendCaseDate.getJFormattedTextField().setEnabled(true);
       CapitalCrimeCaseNumber.setEnabled(true);
         Prosecutor_Result.setEnabled(true);
       CourtResult.setEnabled(true);
  EvidenceRecordCase.setEnabled(true);
         ListAsset.setEnabled(true);
       jButtonAddAsset.setEnabled(true);
       RecordInvestCase.setEnabled(true);
       jButtonAddInvest.setEnabled(true);
        jTextAccused.setEnabled(true);
       jTextSuspect.setEnabled(true);
       jTextWitness.setEnabled(true);
       CourtType.setEnabled(true);
    }
   public void CloseTextBox(){
//    RestoreDate.setVisible(false);  
  
        crimecaseno.setEnabled(false);
       crimecaseyear.setEnabled(false);
       jButtonAction.setEnabled(false);
       jButtonCharge.setEnabled(false);
       ActionCrimes.setEnabled(false);
       ChargeNameCase.setEnabled(false);
       OccuredDateTime.setEnabled(false);
       CaseRequestTimee.setEnabled(false);
       CaseAcceptTimee.setEnabled(false);
       CaseAcceptTimee.setEnabled(false);
            CaseAcceptDate.getComponent(1).setEnabled(false);
       CaseAcceptDate.getJFormattedTextField().setEnabled(false);
            CaseRequestDateTime.getComponent(1).setEnabled(false);
       CaseRequestDateTime.getJFormattedTextField().setEnabled(false);     
       OccuredDate.getComponent(1).setEnabled(false);
       OccuredDate.getJFormattedTextField().setEnabled(false);
        DailyNumber.setEnabled(false);
       CrimeLocation.setEnabled(false);
       CrimeLocationMoo.setEnabled(false);
       CrimeLocationSoi.setEnabled(false);
       CrimeLocationRoad.setEnabled(false);
       CrimeLocationProvince.setEnabled(false);
       CrimeLocationAmphur.setEnabled(false);
       CrimeLocationDistrict.setEnabled(false);
       jComboPoliceName.setEnabled(false);
       jButtonAccured.setEnabled(false);
         jButtonSuspect.setEnabled(false);
       jButtonWitness.setEnabled(false);
       jTextInvestSendtoDepartment.setEnabled(false);
       Investigator_Number.setEnabled(false);
        Invest_SendCaseDate.getComponent(1).setEnabled(false);
       Invest_SendCaseDate.getJFormattedTextField().setEnabled(false);
       CapitalCrimeCaseNumber.setEnabled(false);
         Prosecutor_Result.setEnabled(false);
       CourtResult.setEnabled(false);
         CourtType.setEnabled(false);
       EvidenceRecordCase.setEnabled(false);
         ListAsset.setEnabled(false);
       jButtonAddAsset.setEnabled(false);
       RecordInvestCase.setEnabled(false);
       jButtonAddInvest.setEnabled(false);
        jTextAccused.setEnabled(false);
       jTextSuspect.setEnabled(false);
       jTextWitness.setEnabled(false);

//              g.setEnabled(false);

      


    }
    public int CalculateDateArrest(String DateOne,String DateTwo){
       int diffDays =0;   
       try{
     
               Locale lc = new Locale("th","TH");
           SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy",lc);
                        SimpleDateFormat  format = new SimpleDateFormat("d/MM/yyyy",lc);  
                        
                        Date dateone =null;
                        Date datetwo=null;
                        
                             dateone=format.parse(DateOne);
                          datetwo=format.parse(DateTwo);
                               System.out.println("dateone : "+dateone);
                        System.out.println("datetwo : "+datetwo);
                            long diff = datetwo.getTime() - dateone.getTime();
                             diffDays = (int)(diff / (24 * 60 * 60 * 1000));                          
                             System.out.println("Time in Day: " + diffDays + " Days."); 
                        
                
       }catch(Exception e){
        
           e.printStackTrace();
       
       }
          return diffDays;               
    
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
    private javax.swing.JComboBox<String> CrimeLocationAmphur;
    private javax.swing.JComboBox<String> CrimeLocationDistrict;
    private javax.swing.JTextField CrimeLocationMoo;
    private javax.swing.JComboBox<String> CrimeLocationProvince;
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAccured;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAddAsset;
    private javax.swing.JButton jButtonAddInvest;
    private javax.swing.JButton jButtonCharge;
    private javax.swing.JButton jButtonEditCase;
    private javax.swing.JButton jButtonPrintDoc;
    private javax.swing.JButton jButtonPrintDoc2;
    private javax.swing.JButton jButtonSaveCase;
    private javax.swing.JButton jButtonSuspect;
    private javax.swing.JButton jButtonWitness;
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
    private javax.swing.JCheckBox jCheckW18;
    private javax.swing.JCheckBox jCheckW19;
    private javax.swing.JCheckBox jCheckW2;
    private javax.swing.JCheckBox jCheckW20;
    private javax.swing.JCheckBox jCheckW201;
    private javax.swing.JCheckBox jCheckW202;
    private javax.swing.JCheckBox jCheckW203;
    private javax.swing.JCheckBox jCheckW204;
    private javax.swing.JCheckBox jCheckW205;
    private javax.swing.JCheckBox jCheckW206;
    private javax.swing.JCheckBox jCheckW207;
    private javax.swing.JCheckBox jCheckW208;
    private javax.swing.JCheckBox jCheckW209;
    private javax.swing.JCheckBox jCheckW21;
    private javax.swing.JCheckBox jCheckW211;
    private javax.swing.JCheckBox jCheckW212;
    private javax.swing.JCheckBox jCheckW213;
    private javax.swing.JCheckBox jCheckW214;
    private javax.swing.JCheckBox jCheckW215;
    private javax.swing.JCheckBox jCheckW216;
    private javax.swing.JCheckBox jCheckW217;
    private javax.swing.JCheckBox jCheckW218;
    private javax.swing.JCheckBox jCheckW219;
    private javax.swing.JCheckBox jCheckW22;
    private javax.swing.JCheckBox jCheckW220;
    private javax.swing.JCheckBox jCheckW221;
    private javax.swing.JCheckBox jCheckW222;
    private javax.swing.JCheckBox jCheckW223;
    private javax.swing.JCheckBox jCheckW224;
    private javax.swing.JCheckBox jCheckW225;
    private javax.swing.JCheckBox jCheckW226;
    private javax.swing.JCheckBox jCheckW227;
    private javax.swing.JCheckBox jCheckW228;
    private javax.swing.JCheckBox jCheckW229;
    private javax.swing.JCheckBox jCheckW23;
    private javax.swing.JCheckBox jCheckW230;
    private javax.swing.JCheckBox jCheckW231;
    private javax.swing.JCheckBox jCheckW232;
    private javax.swing.JCheckBox jCheckW233;
    private javax.swing.JCheckBox jCheckW234;
    private javax.swing.JCheckBox jCheckW235;
    private javax.swing.JCheckBox jCheckW236;
    private javax.swing.JCheckBox jCheckW237;
    private javax.swing.JCheckBox jCheckW238;
    private javax.swing.JCheckBox jCheckW239;
    private javax.swing.JCheckBox jCheckW24;
    private javax.swing.JCheckBox jCheckW240;
    private javax.swing.JCheckBox jCheckW241;
    private javax.swing.JCheckBox jCheckW242;
    private javax.swing.JCheckBox jCheckW243;
    private javax.swing.JCheckBox jCheckW244;
    private javax.swing.JCheckBox jCheckW245;
    private javax.swing.JCheckBox jCheckW246;
    private javax.swing.JCheckBox jCheckW247;
    private javax.swing.JCheckBox jCheckW248;
    private javax.swing.JCheckBox jCheckW249;
    private javax.swing.JCheckBox jCheckW25;
    private javax.swing.JCheckBox jCheckW250;
    private javax.swing.JCheckBox jCheckW251;
    private javax.swing.JCheckBox jCheckW252;
    private javax.swing.JCheckBox jCheckW253;
    private javax.swing.JCheckBox jCheckW254;
    private javax.swing.JCheckBox jCheckW255;
    private javax.swing.JCheckBox jCheckW256;
    private javax.swing.JCheckBox jCheckW257;
    private javax.swing.JCheckBox jCheckW258;
    private javax.swing.JCheckBox jCheckW259;
    private javax.swing.JCheckBox jCheckW26;
    private javax.swing.JCheckBox jCheckW260;
    private javax.swing.JCheckBox jCheckW261;
    private javax.swing.JCheckBox jCheckW262;
    private javax.swing.JCheckBox jCheckW263;
    private javax.swing.JCheckBox jCheckW264;
    private javax.swing.JCheckBox jCheckW265;
    private javax.swing.JCheckBox jCheckW266;
    private javax.swing.JCheckBox jCheckW267;
    private javax.swing.JCheckBox jCheckW268;
    private javax.swing.JCheckBox jCheckW269;
    private javax.swing.JCheckBox jCheckW27;
    private javax.swing.JCheckBox jCheckW270;
    private javax.swing.JCheckBox jCheckW271;
    private javax.swing.JCheckBox jCheckW272;
    private javax.swing.JCheckBox jCheckW273;
    private javax.swing.JCheckBox jCheckW274;
    private javax.swing.JCheckBox jCheckW275;
    private javax.swing.JCheckBox jCheckW276;
    private javax.swing.JCheckBox jCheckW277;
    private javax.swing.JCheckBox jCheckW278;
    private javax.swing.JCheckBox jCheckW28;
    private javax.swing.JCheckBox jCheckW280;
    private javax.swing.JCheckBox jCheckW29;
    private javax.swing.JCheckBox jCheckW293;
    private javax.swing.JCheckBox jCheckW3;
    private javax.swing.JCheckBox jCheckW30;
    private javax.swing.JCheckBox jCheckW31;
    private javax.swing.JCheckBox jCheckW32;
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
    private javax.swing.JCheckBox jCheckW42;
    private javax.swing.JCheckBox jCheckW43;
    private javax.swing.JCheckBox jCheckW44;
    private javax.swing.JCheckBox jCheckW46;
    private javax.swing.JCheckBox jCheckW47;
    private javax.swing.JCheckBox jCheckW48;
    private javax.swing.JCheckBox jCheckW49;
    private javax.swing.JCheckBox jCheckW5;
    private javax.swing.JCheckBox jCheckW50;
    private javax.swing.JCheckBox jCheckW51;
    private javax.swing.JCheckBox jCheckW52;
    private javax.swing.JCheckBox jCheckW53;
    private javax.swing.JCheckBox jCheckW54;
    private javax.swing.JCheckBox jCheckW5445;
    private javax.swing.JCheckBox jCheckW55;
    private javax.swing.JCheckBox jCheckW56;
    private javax.swing.JCheckBox jCheckW57;
    private javax.swing.JCheckBox jCheckW58;
    private javax.swing.JCheckBox jCheckW59;
    private javax.swing.JCheckBox jCheckW6;
    private javax.swing.JCheckBox jCheckW60;
    private javax.swing.JCheckBox jCheckW61;
    private javax.swing.JCheckBox jCheckW62;
    private javax.swing.JCheckBox jCheckW63;
    private javax.swing.JCheckBox jCheckW64;
    private javax.swing.JCheckBox jCheckW65;
    private javax.swing.JCheckBox jCheckW66;
    private javax.swing.JCheckBox jCheckW67;
    private javax.swing.JCheckBox jCheckW68;
    private javax.swing.JCheckBox jCheckW69;
    private javax.swing.JCheckBox jCheckW7;
    private javax.swing.JCheckBox jCheckW70;
    private javax.swing.JCheckBox jCheckW71;
    private javax.swing.JCheckBox jCheckW72;
    private javax.swing.JCheckBox jCheckW73;
    private javax.swing.JCheckBox jCheckW7462;
    private javax.swing.JCheckBox jCheckW75;
    private javax.swing.JCheckBox jCheckW76;
    private javax.swing.JCheckBox jCheckW77;
    private javax.swing.JCheckBox jCheckW8;
    private javax.swing.JCheckBox jCheckW80;
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
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JTextField jTextAccused;
    private javax.swing.JTextField jTextInvestSendtoDepartment;
    public static javax.swing.JTextField jTextSuspect;
    public static javax.swing.JTextField jTextWitness;
    // End of variables declaration//GEN-END:variables
}
