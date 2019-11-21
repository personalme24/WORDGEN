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
import com.songkhla.document.W61;
import com.songkhla.document.W62;
import com.songkhla.document.W63;
import com.songkhla.document.W64;
import com.songkhla.document.W65;
import com.songkhla.document.W66;
import com.songkhla.document.W67;
import com.songkhla.document.W69;
import com.songkhla.document.W7;
import com.songkhla.document.W70;
import com.songkhla.document.W71;
import com.songkhla.document.W711;
import com.songkhla.document.W72;
import com.songkhla.document.W73;
import com.songkhla.document.W74;
import com.songkhla.document.W75;
import com.songkhla.document.W76;
import com.songkhla.document.W77;
import com.songkhla.document.W78;
import com.songkhla.document.W79;
import com.songkhla.document.W8;
import com.songkhla.document.W80;
import com.songkhla.document.W812;
import com.songkhla.document.W9;
import com.songkhla.document.W93;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.ListAccused.jTableAccure;
import static com.songkhla.wordgen.ListAccused.txtCaseNO;
import static com.songkhla.wordgen.TrafficEdit.crimecaseid;
import static com.songkhla.wordgen.TrafficEdit.crimecaseno;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.json.simple.JSONObject;
import java.awt.Font;
/**
 *
 * @author Petpilin
 */
public class IdentityEdit1 extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;;
    boolean isInsert;
       String Province_name;
    String caseid,caseidLast,province,typeC;
     String caseyear,casetype,caseno,PoliceStaionName,CauseDead;
     ButtonGroup g;
JDatePickerImpl CaseRequestDateTime,CaseAcceptDate,OccuredDate,Invest_SendCaseDate,OccuredDateEnd;
    /**
     * Creates new form CrimesCaseEdit
     */
    public IdentityEdit1(JFrame parrent,JSONObject datain){
        super(parrent,true);

           initComponents(); 
            ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES) BETA");
            typeC="Dead";
            

//            JScrollBar hbar=new JScrollBar(JScrollBar.HORIZONTAL, 30, 20, 0, 500);
//            jScrollPane1.getVerticalScrollBar().setUI(new MyScrollBarUI());
//            jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
         g=new ButtonGroup();
        g.add(jCheckDuringInvest);
        g.add(jCheckSue);
        g.add(jCheckNotSue);
        g.add(jCheckNoInvest);
        g.add(jCheckOtherInvest);
        
      ButtonGroup ca=new ButtonGroup();
        ca.add(jCheckControl);
        ca.add(jCheckAnimal);
        ca.add(jCheckKill);
        ca.add(jCheckSuicide);
       ca.add(jCheckExtraordinary);
        ca.add(jCheckAccident);
        ca.add(jCheckUnknow);
       jCheckSue.setEnabled(false);
       jCheckNotSue.setEnabled(false);
       jLabel35.setVisible(false);
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
        
        UtilDateModel model5 = new UtilDateModel();
            model5.setValue(Calendar.getInstance().getTime());
         JDatePanelImpl datePanel5 = new JDatePanelImpl(model5, p);
        OccuredDateEnd = new JDatePickerImpl(datePanel5,new DateLabelFormatter());
//         OccuredDateEnd.setPreferredSize(new Dimension(220,30));
//    OccuredDateEnd.getComponent(0).setPreferredSize(new Dimension(190,30)); //JFormattedTextField
//    OccuredDateEnd.getComponent(1).setPreferredSize(new Dimension(30,30));//JButton
        OccuredDateEnd.setTextEditable(true);
        OccuredDateEnd.setBackground(Color.WHITE);
        jPanelOccuredDateEnd.setLayout(new FlowLayout());
        jPanelOccuredDateEnd.add(OccuredDateEnd);  
//--------------------------------------Date Filed----------------------------------------------


      
       
//        jTextPoliceName.setText(Data.getPolicName());
        jLabelActionCode.setVisible(false);
        jLabelChargeCode.setVisible(false);
        crimecaseid.setVisible(false);
 
         
// comboProvince();
 
        if(datain!=null){
            try {
                jButtonOpenFolder.setVisible(true);
                CloseTextBox();
                jButtonSaveCase.setEnabled(false);
                String knowSus=datain.get("StatusKnowSuspect")+"";
                String rt=datain.get("CaseRequestTime")+"";
                String at=datain.get("CaseAcceptTime")+"";
                String ot=datain.get("OccuredTime")+"";
                String ote=datain.get("OccuredTimeEnd")+"";

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date timeReq = timeFormat.parse(rt);
                Date timeAcc = timeFormat.parse(at);
                Date timeOccu = timeFormat.parse(ot);
                Date timeOccuEnd = timeFormat.parse(ote);

                CauseDead=datain.get("CauseDead")+"";
                isInsert=false;
                caseid= "" + datain.get("CaseId");
                crimecaseid.setText(datain.get("CaseId")+"");
                caseyear=datain.get("crimecaseyears")+"";
                caseno=datain.get("crimecaseno")+"";
                casetype=datain.get("CaseType")+"";
//          ID.setText(datain.get("CaseId")+"");
            crimecaseno.setText(datain.get("crimecaseno")+"");
            crimecaseyear.setText(datain.get("crimecaseyears")+"");
            jLabelChargeCode.setText(datain.get("ChargeCodeCase")+"");
            String cn=datain.get("ChargeNameCase")+"";
            if(cn.equals("null")){
            ChargeNameCase.setText("");
            }
            else{
            ChargeNameCase.setText(datain.get("ChargeNameCase")+"");}
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
               jComboPoliceName.getModel().setSelectedItem(new ComboItem(datain.get("PoliceNameCase")+"", datain.get("PoliceNameCaseId")+""));
            comboInvest();
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
            CourtResult.setText(datain.get("CourtResult")+"");
              OccuredDateEnd.getJFormattedTextField().setText(datain.get("OccuredDateEnd")+"");
             OccuredDateTimeEnd.setValue(timeOccuEnd);
            if(CauseDead.equals("ระหว่างควบคุม")){
            jCheckControl.setSelected(true);
            
            }
            else if(CauseDead.equals("สัตว์ทำร้ายตาย")){
            jCheckAnimal.setSelected(true);
            
            }
            else if(CauseDead.equals("ผู้อื่นทำให้ตาย")){
            jCheckKill.setSelected(true);
            
            }
            else if(CauseDead.equals("ฆ่าตัวตาย")){
            jCheckSuicide.setSelected(true);
            
            }
            else if(CauseDead.equals("ถูกเจ้าพนักงานทำให้ตาย(วิสามัญ)")){
            jCheckExtraordinary.setSelected(true);
            
            }
            else if(CauseDead.equals("อุบัติเหตุ")){
            jCheckAccident.setSelected(true);
            
            }
             else if(CauseDead.equals("มิปรากฎเหตุ")){
            jCheckUnknow.setSelected(true);
            
            }
            CircumstancesOfDeath.setText(datain.get("CircumstancesOfDeath")+"");
            if(investSta.equals("อยู่ระหว่างสอบสวน")){
                jCheckDuringInvest.setSelected(true);
            }
//             else if(investSta.equals("สั่งฟ้อง")){
//                jCheckSue.setSelected(true);
//            }
//              else  if(investSta.equals("สั่งไม่ฟ้อง")){
//                jCheckNotSue.setSelected(true);
//            }
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
                Logger.getLogger(IdentityEdit1.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
        else{ 
             jButtonOpenFolder.setVisible(false);
            comboInvest();
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
            jCheckDuringInvest.setSelected(true);
           isInsert=true;
          
        }
        String da=CaseAcceptDate.getJFormattedTextField().getText();
        String od=OccuredDate.getJFormattedTextField().getText();

//         System.out.println("dd ;"+CalculateDateArrest(od, da)+"");
//ChangProvince();
//AutoCompleteDecorator.decorate(CrimeLocationProvince); 
RefreshData();
        RefreshDataAcc();
        RefreshDataWit();
//------------------------RightClick-------------------------------
JTextPopupMenu.addTo(crimecaseno);
JTextPopupMenu.addTo(crimecaseyear);
JTextPopupMenu.addTo(OccuredDate.getJFormattedTextField());
JTextPopupMenu.addTo(CaseAcceptDate.getJFormattedTextField());
JTextPopupMenu.addTo(CaseRequestDateTime.getJFormattedTextField());
JTextPopupMenu.addTo(DailyNumber);
JTextPopupMenu.addTo(CrimeLocation);
JTextPopupMenu.addTo(CrimeLocationMoo);
JTextPopupMenu.addTo(CrimeLocationSoi);
JTextPopupMenu.addTo(CrimeLocationRoad);
JTextPopupMenu.addTo(jTextInvestSendtoDepartment);
JTextPopupMenu.addTo(Investigator_Number);
JTextPopupMenu.addTo(Invest_SendCaseDate.getJFormattedTextField());
JTextPopupMenu.addTo(CapitalCrimeCaseNumber);
JTextPopupMenu.addTo(Prosecutor_Result);
JTextPopupMenu.addTo(CourtResult);
           JTextPopupMenu.addTo(CircumstancesOfDeath);
 
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
        jButtonOpenFolder = new javax.swing.JButton();
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
        jLabel14 = new javax.swing.JLabel();
        ChargeNameCase = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Date date2=new Date();

        SpinnerDateModel sm2=new SpinnerDateModel(date2,null,null,Calendar.HOUR_OF_DAY);
        CaseAcceptTimee = new javax.swing.JSpinner(sm2);
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
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jCheckSuicide = new javax.swing.JRadioButton();
        jCheckAnimal = new javax.swing.JRadioButton();
        jCheckKill = new javax.swing.JRadioButton();
        jCheckAccident = new javax.swing.JRadioButton();
        jCheckUnknow = new javax.swing.JRadioButton();
        jCheckExtraordinary = new javax.swing.JRadioButton();
        jCheckControl = new javax.swing.JRadioButton();
        CircumstancesOfDeath = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        CrimeLocation = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jButtonAddAsset = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        EvidenceRecordCase = new javax.swing.JTextField();
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
        jScrollPane7 = new javax.swing.JScrollPane();
        ListAsset = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CrimeLocationDistrict = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CrimeLocationProvince = new javax.swing.JTextField();
        CrimeLocationAmphur = new javax.swing.JTextField();
        Date date4=new Date();

        SpinnerDateModel sm4=new SpinnerDateModel(date4,null,null,Calendar.HOUR_OF_DAY);
        OccuredDateTimeEnd = new javax.swing.JSpinner(sm4);
        jLabel32 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanelOccuredDateEnd = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jTextAccused = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabelNumberAcc = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableAccure = new javax.swing.JTable();
        jButtonAddAccused1 = new javax.swing.JButton();
        jButtonEditAccured1 = new javax.swing.JButton();
        jButtonDeleteAccured1 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jTextSuspect = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabelNumberSus = new javax.swing.JLabel();
        jButtonDeleteAccured = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableSuspect = new javax.swing.JTable();
        jButtonAddAccused = new javax.swing.JButton();
        jButtonEditAccured = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextWitness = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabelNumberWitness = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableWitness = new javax.swing.JTable();
        jButtonAddAccused2 = new javax.swing.JButton();
        jButtonDeleteAccured2 = new javax.swing.JButton();
        jButtonEditAccured2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Investigator_Number = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        CourtResult = new javax.swing.JTextArea();
        jLabel41 = new javax.swing.JLabel();
        jTextInvestSendtoDepartment = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanelInvestSend = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jCheckDuringInvest = new javax.swing.JRadioButton();
        jCheckSue = new javax.swing.JRadioButton();
        jCheckNotSue = new javax.swing.JRadioButton();
        jCheckNoInvest = new javax.swing.JRadioButton();
        jCheckOtherInvest = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        CapitalCrimeCaseNumber = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Prosecutor_Result = new javax.swing.JTextArea();
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
        jCheckW204 = new javax.swing.JCheckBox();
        jCheckW206 = new javax.swing.JCheckBox();
        jCheckW207 = new javax.swing.JCheckBox();
        jCheckW208 = new javax.swing.JCheckBox();
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
        jCheckW279 = new javax.swing.JCheckBox();
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
        jLabel35 = new javax.swing.JLabel();
        jButtonPrintDoc2 = new javax.swing.JButton();
        jLabelChargeCode = new javax.swing.JLabel();
        jButtonSaveCase = new javax.swing.JButton();
        jButtonEditCase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" บันทึก/แก้ไข ข้อมูล");

        CaseType.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        CaseType.setForeground(new java.awt.Color(255, 255, 255));
        CaseType.setText("คดีชันสูตร");

        crimecaseid.setText("NoCaseId");

        jLabelActionCode.setText("jLabel2");

        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("./Master/home.png"));
        jButton2.setText("เมนูหลัก");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonOpenFolder.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonOpenFolder.setIcon(new javax.swing.ImageIcon("./Master/open.png"));
        jButtonOpenFolder.setText("เปิด");
        jButtonOpenFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CaseType)
                .addGap(0, 0, 0)
                .addComponent(crimecaseid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActionCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOpenFolder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CaseType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crimecaseid)
                    .addComponent(jLabelActionCode)
                    .addComponent(jButton2)
                    .addComponent(jButtonOpenFolder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jPanel1.add(jButtonCharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 110, -1));

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel1.add(crimecaseno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 60, 32));

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("ปจว.ข้อ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, 30));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("/");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, 30));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(OccuredDateTime, "HH:mm");
        OccuredDateTime.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        jPanel1.add(OccuredDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 100, 30));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("เวลาที่เกิดเหตุ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, 30));

        ChargeNameCase.setEditable(false);
        ChargeNameCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel1.add(ChargeNameCase, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 330, 32));

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("วันที่รับแจ้ง");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, 30));

        JSpinner.DateEditor te = new JSpinner.DateEditor(CaseAcceptTimee, "HH:mm");
        CaseAcceptTimee.setEditor(te);
        //jSpinner1.setValue(new Date());
        CaseAcceptTimee.setPreferredSize(new java.awt.Dimension(29, 25));
        jPanel1.add(CaseAcceptTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 100, 32));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("ข้อหา");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 30));

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("เวลารับคำร้องทุกข์");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, 30));

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("วันที่เกิดเหตุ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 30));

        ActionCrimes.setEditable(false);
        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel1.add(ActionCrimes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 330, 32));

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เวลารับแจ้ง");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, -1, 30));

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(CaseRequestTimee, "HH:mm");
        CaseRequestTimee.setEditor(timeEditor);
        //jSpinner1.setValue(new Date());
        jPanel1.add(CaseRequestTimee, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 100, 30));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("พฤติการณ์คดี");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 77, 30));

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("วันที่รับคำร้องทุกข์");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, 30));

        DailyNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel1.add(DailyNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 110, 32));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("อำนาจศาล");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 70, 30));

        crimecaseyear.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel1.add(crimecaseyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 70, 32));

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("เลขคดี");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        jButtonAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAction.setText("พฤติการณ์คดี");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAction, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 110, -1));

        CourtType.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลอาญา/ศาลจังหวัด" }));
        CourtType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourtTypeActionPerformed(evt);
            }
        });
        jPanel1.add(CourtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 200, -1));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 220, -1));

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

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 220, -1));

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 220, -1));

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel33.setText("เหตุที่ตาย");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jCheckSuicide.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckSuicide.setText("ฆ่าตัวตาย");
        jPanel1.add(jCheckSuicide, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jCheckAnimal.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckAnimal.setText("สัตว์ทำร้ายตาย");
        jPanel1.add(jCheckAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jCheckKill.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckKill.setText("ผู้อื่นทำให้ตาย");
        jPanel1.add(jCheckKill, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        jCheckAccident.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckAccident.setText("อุบัติเหตุ");
        jPanel1.add(jCheckAccident, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        jCheckUnknow.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckUnknow.setText("มิปรากฎเหตุ");
        jCheckUnknow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckUnknowActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckUnknow, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        jCheckExtraordinary.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckExtraordinary.setText("ถูกเจ้าพนักงานทำให้ตาย(วิสามัญ)");
        jPanel1.add(jCheckExtraordinary, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        jCheckControl.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckControl.setText("ระหว่างควบคุม");
        jPanel1.add(jCheckControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        CircumstancesOfDeath.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel1.add(CircumstancesOfDeath, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 450, 32));

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel34.setText("ตายโดย");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 90, 30));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("สถานที่เกิดเหตุ");

        CrimeLocation.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel29.setText("เลขบัญชีของกลาง");

        jButtonAddAsset.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddAsset.setIcon(new javax.swing.ImageIcon("./Master/edit (1).png"));
        jButtonAddAsset.setActionCommand("พยาน");
        jButtonAddAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAssetActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel28.setText("รายการทรัพย์");

        EvidenceRecordCase.setEditable(false);
        EvidenceRecordCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel45.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel45.setText("พนักงานสอบสวน");

        jButtonAddInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddInvest.setIcon(new javax.swing.ImageIcon("./Master/edit (1).png"));
        jButtonAddInvest.setActionCommand("พยาน");
        jButtonAddInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddInvestActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel46.setText("บันทึกพนักงานสอบสวน");

        RecordInvestCase.setEditable(false);
        RecordInvestCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jComboPoliceName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("ถนน");

        CrimeLocationRoad.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("หมู่ที่");

        CrimeLocationMoo.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CrimeLocationMoo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrimeLocationMooActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("ตรอก/ซอย");

        CrimeLocationSoi.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        ListAsset.setColumns(20);
        ListAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ListAsset.setLineWrap(true);
        ListAsset.setRows(2);
        ListAsset.setTabSize(1);
        jScrollPane7.setViewportView(ListAsset);

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("แขวง/ตำบล");

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("เขต/อำเภอ");

        CrimeLocationDistrict.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CrimeLocationDistrict.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CrimeLocationDistrictKeyReleased(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("จังหวัด");

        CrimeLocationProvince.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        CrimeLocationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CrimeLocationAmphur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CrimeLocationAmphurKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(CrimeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(63, 63, 63)
                        .addComponent(CrimeLocationMoo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel24)
                        .addGap(6, 6, 6)
                        .addComponent(CrimeLocationSoi, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addComponent(CrimeLocationRoad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel28))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(EvidenceRecordCase, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAddAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(47, 47, 47)
                                .addComponent(jComboPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(RecordInvestCase, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButtonAddInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CrimeLocationDistrict)
                            .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrimeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(CrimeLocationMoo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(CrimeLocationSoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(CrimeLocationRoad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CrimeLocationDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EvidenceRecordCase, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(RecordInvestCase, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, 500));

        JSpinner.DateEditor timeEditor4 = new JSpinner.DateEditor(OccuredDateTimeEnd, "HH:mm");
        OccuredDateTimeEnd.setEditor(timeEditor4);
        //jSpinner1.setValue(new Date());
        jPanel1.add(OccuredDateTimeEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 100, 30));

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel32.setText("เวลา");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 80, 30));

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel36.setText("ถึงวันที่");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, 30));

        jPanelOccuredDateEnd.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelOccuredDateEndLayout = new javax.swing.GroupLayout(jPanelOccuredDateEnd);
        jPanelOccuredDateEnd.setLayout(jPanelOccuredDateEndLayout);
        jPanelOccuredDateEndLayout.setHorizontalGroup(
            jPanelOccuredDateEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelOccuredDateEndLayout.setVerticalGroup(
            jPanelOccuredDateEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelOccuredDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 220, -1));

        jTabbedPane2.addTab("ข้อมูลคดี", jPanel1);

        jTextAccused.setEditable(false);
        jTextAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel37.setText("ผู้กล่าวหา");

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel38.setText("จำนวน");

        jLabel39.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel39.setText("คน");

        jLabelNumberAcc.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelNumberAcc.setText("0");

        jTableAccure.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jTableAccure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "เลขคดี", "เลขบัตรประชน", "ชื่อ-นามสกุล"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAccure.setGridColor(new java.awt.Color(255, 255, 255));
        jTableAccure.setRowHeight(25);
        jTableAccure.setRowMargin(2);
        jTableAccure.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTableAccure.getTableHeader().setOpaque(false);
        jScrollPane8.setViewportView(jTableAccure);

        jButtonAddAccused1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAddAccused1.setText("เพิ่ม");
        jButtonAddAccused1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAccused1ActionPerformed(evt);
            }
        });

        jButtonEditAccured1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonEditAccured1.setText("ดูข้อมูล/แก้ไข");
        jButtonEditAccured1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAccured1ActionPerformed(evt);
            }
        });

        jButtonDeleteAccured1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonDeleteAccured1.setText("ลบ");
        jButtonDeleteAccured1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccured1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jButtonAddAccused1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditAccured1)
                                .addGap(5, 5, 5)
                                .addComponent(jButtonDeleteAccured1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addGap(18, 18, 18)
                        .addComponent(jTextAccused, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNumberAcc)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel39)
                        .addGap(671, 671, 671))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38)
                        .addComponent(jLabelNumberAcc)
                        .addComponent(jLabel39)))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAddAccused1)
                        .addComponent(jButtonEditAccured1))
                    .addComponent(jButtonDeleteAccured1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("ผู้กล่าวหา", jPanel10);

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("ผู้ตาย");

        jTextSuspect.setEditable(false);
        jTextSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel40.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel40.setText("จำนวน");

        jLabel42.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel42.setText("คน");

        jLabelNumberSus.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelNumberSus.setText("0");

        jButtonDeleteAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonDeleteAccured.setText("ลบ");
        jButtonDeleteAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccuredActionPerformed(evt);
            }
        });

        jTableSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jTableSuspect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ชื่อ-นามสกุล", "เลขบัตรประชน", "เลขคดี"
            }
        ));
        jTableSuspect.setGridColor(new java.awt.Color(255, 255, 255));
        jTableSuspect.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTableSuspect.getTableHeader().setOpaque(false);
        jTableSuspect.setRowHeight(25);
        jTableSuspect.setRowMargin(2);
        jScrollPane9.setViewportView(jTableSuspect);

        jButtonAddAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAddAccused.setText("เพิ่ม");
        jButtonAddAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAccusedActionPerformed(evt);
            }
        });

        jButtonEditAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonEditAccured.setText("ดูข้อมูล/แก้ไข");
        jButtonEditAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAccuredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jButtonAddAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditAccured)
                        .addGap(3, 3, 3)
                        .addComponent(jButtonDeleteAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelNumberSus)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel42)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumberSus))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddAccused)
                    .addComponent(jButtonEditAccured)
                    .addComponent(jButtonDeleteAccured))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("ผู้ตาย", jPanel15);

        jLabel47.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel47.setText("พยานและบุคคลอื่น");

        jLabel48.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel48.setText("จำนวน");

        jTextWitness.setEditable(false);
        jTextWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel49.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel49.setText("คน");

        jLabelNumberWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelNumberWitness.setText("0");

        jTableWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jTableWitness.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "เลขคดี", "ชื่อ-นามสกุล", "เลขบัตรประชน"
            }
        ));
        jTableWitness.setGridColor(new java.awt.Color(255, 255, 255));
        jTableWitness.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTableWitness.getTableHeader().setOpaque(false);
        jTableWitness.setRowHeight(25);
        jTableWitness.setRowMargin(2);
        jScrollPane10.setViewportView(jTableWitness);

        jButtonAddAccused2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAddAccused2.setText("เพิ่ม");
        jButtonAddAccused2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAccused2ActionPerformed(evt);
            }
        });

        jButtonDeleteAccured2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonDeleteAccured2.setText("ลบ");
        jButtonDeleteAccured2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccured2ActionPerformed(evt);
            }
        });

        jButtonEditAccured2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonEditAccured2.setText("ดูข้อมูล/แก้ไข");
        jButtonEditAccured2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAccured2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNumberWitness)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel49))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButtonAddAccused2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditAccured2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeleteAccured2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabelNumberWitness)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddAccused2)
                    .addComponent(jButtonEditAccured2)
                    .addComponent(jButtonDeleteAccured2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("พยานและบุคคลอื่น", jPanel18);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        Investigator_Number.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        CourtResult.setColumns(20);
        CourtResult.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtResult.setLineWrap(true);
        CourtResult.setRows(3);
        CourtResult.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลคดีชั้นศาล", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 22))); // NOI18N
        jScrollPane2.setViewportView(CourtResult);

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel41.setText("วันเดือนปีที่ส่ง");

        jTextInvestSendtoDepartment.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        CapitalCrimeCaseNumber.setColumns(20);
        CapitalCrimeCaseNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CapitalCrimeCaseNumber.setLineWrap(true);
        CapitalCrimeCaseNumber.setRows(3);
        CapitalCrimeCaseNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "หมายเหตุ-เลขคดีอุกฉกรรจ์", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 22))); // NOI18N
        jScrollPane3.setViewportView(CapitalCrimeCaseNumber);

        Prosecutor_Result.setColumns(20);
        Prosecutor_Result.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Prosecutor_Result.setLineWrap(true);
        Prosecutor_Result.setRows(3);
        Prosecutor_Result.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ผลคดีชั้นอัยการ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 22))); // NOI18N
        jScrollPane4.setViewportView(Prosecutor_Result);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanelInvestSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Investigator_Number, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("ข้อมูลผลคดี", jPanel5);

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
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
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
        jPanel14.add(jCheckW201, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 384, -1));

        jCheckW202.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW202.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW202.setText("หนังสือส่งสำนวนคดีที่เห็นควรงดหรือให้งดการสอบสวน");
        jCheckW202.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW202ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW202, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 384, -1));

        jCheckW204.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW204.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW204.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้องหรือไม่สั่งฟ้อง");
        jCheckW204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW204ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW204, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 384, -1));

        jCheckW206.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW206.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW206.setText("รายงานการสอบสวนสำนวนคดีไม่ปรากฎว่าผู้ใดเป็นผู้กระทำผิด");
        jCheckW206.setPreferredSize(new java.awt.Dimension(384, 33));
        jCheckW206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW206ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW206, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jCheckW207.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW207.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW207.setText("รายงานการสอบสวนสำนวนชันสูตรพลิกศพ");
        jPanel14.add(jCheckW207, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 390, -1));

        jCheckW208.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW208.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW208.setText("บันทึกคำให้การผู้กล่าวหาหรือพยาน");
        jPanel14.add(jCheckW208, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 390, -1));

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
        jPanel14.add(jCheckW216, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 390, -1));

        jCheckW293.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW293.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW293.setText("คำร้องขอหมายจับ");
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
        jCheckW217.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดี");
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
        jPanel14.add(jCheckW233, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 210, -1));

        jCheckW261.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW261.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW261.setText("แผนประทุษกรรม");
        jPanel14.add(jCheckW261, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 321, -1));

        jCheckW228.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW228.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW228.setText("บันทึกการตรวจสภาพยานพาหนะ");
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
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารชันสูตรและอื่นๆ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N

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

        jCheckW279.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW279.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW279.setText("พิมพ์ลายนิ้วมือผู้ต้องหา");
        jCheckW279.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW279ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW240)
                    .addComponent(jCheckW241, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW242, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW265, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW224, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW221, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW223, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW222, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW279, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jCheckW240)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW241)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW242)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW265)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW279))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jCheckW221)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jCheckW223))
                            .addComponent(jCheckW222))
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW224)))
                .addGap(40, 40, 40))
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
        jCheckW273.setText("บันทึกรับรองการเป็นโสด");

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
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel12);

        jLabel35.setText("caseid");

        jButtonPrintDoc2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonPrintDoc2.setText("สร้างเอกสาร");
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
                .addComponent(jLabel35)
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
                    .addComponent(jLabel35)
                    .addComponent(jButtonPrintDoc2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("รายงาน", jPanel11);

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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelChargeCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonSaveCase, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditCase, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelChargeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveCase)
                    .addComponent(jButtonEditCase))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCaseActionPerformed
        // TODO add your handling code here:
  ComboItem item = (ComboItem) jComboPoliceName.getSelectedItem();
        String idpolice=item.getValue();
        System.out.println("Item :"+item.getValue());
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
         String occuredTimeEnd=format.format(OccuredDateTimeEnd.getValue());


        if(isInsert){
            String sql="INSERT INTO CrimeCase (CaseType,crimecaseno,crimecaseyears,ChargeCodeCase,ActionCodeCase,CaseRequestDate,CaseRequestTime,"+
            "CaseAcceptDate,CaseAccepTime,DailyNumber,OccuredDate,OccuredTime,CrimeLocation,CrimeLocationMoo,CrimeLocationSoi,CrimeLocationRoad,CrimeLocationDistrict,CrimeLocationAmphur,"+
            "CrimeLocationProvince,TypeCourt,AccureandOther,SuspectandOther,WitnessandOther,Investigator_Result,CourtResult,Invest_SendtoDepartment,"+
            "PoliceNameCase,AssetList,AssetCode,crimecasenoyear,RecordInvestCase,Investigator_Number,Invest_SendCaseDate,Prosecutor_Result,"
          + "CapitalCrimeCaseNumber,TotalAcc,TotalSus,TotalWitness,CauseDead,CircumstancesOfDeath,OccuredTimeEnd,OccuredDateEnd)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println(sql);
            try {

                pst=con.prepareStatement(sql);

                pst.setString(1,"คดีชันสูตร");
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
//                if(jCheckSue.isSelected()){
//                    pst.setString(24,"สั่งฟ้อง");
//                }
//                if(jCheckNotSue.isSelected()){
//                    pst.setString(24,"สั่งไม่ฟ้อง");
//                }
                if(jCheckNoInvest.isSelected()){
                    pst.setString(24,"งดการสอบสวน");
                }
                if(jCheckOtherInvest.isSelected()){
                    pst.setString(24,"อื่นๆ");
                }

                pst.setString(25,CourtResult.getText());
                pst.setString(26,jTextInvestSendtoDepartment.getText());
                pst.setString(27,idpolice);             
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
                if(jCheckControl.isSelected()){
                    pst.setString(39,jCheckControl.getText());
                }
                if(jCheckAnimal.isSelected()){
                    pst.setString(39,jCheckAnimal.getText());
                }
                if(jCheckKill.isSelected()){
                    pst.setString(39,jCheckKill.getText());
                }
                if(jCheckSuicide.isSelected()){
                    pst.setString(39,jCheckSuicide.getText());
                }
                if(jCheckExtraordinary.isSelected()){
                    pst.setString(39,jCheckExtraordinary.getText());
                }
                if(jCheckAccident.isSelected()){
                    pst.setString(39,jCheckAccident.getText());
                }
                if(jCheckUnknow.isSelected()){
                    pst.setString(39,jCheckUnknow.getText());
                }     
                    pst.setString(40,CircumstancesOfDeath.getText());
                    pst.setString(41,occuredTimeEnd);                
                pst.setString(42,OccuredDateEnd.getJFormattedTextField().getText());
               
//       JOptionPane.showMessageDialog(jPanel1,null, "Data Save", JOptionPane.INFORMATION_MESSAGE);

                
      int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  if (response == JOptionPane.YES_OPTION) {
//             con=ConnectDatabase.connect();
         pst.executeUpdate(); 
         pst.close();
         System.out.println("SQL : "+sql);
         insertChargeReport();
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
            +"TotalWitness=?,"
            +"CauseDead=?," 
            +"CircumstancesOfDeath=?," 
            +"OccuredDateEnd=?,"                     
            +"OccuredTimeEnd=?"                  
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
                pst.setString(26,idpolice);
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
                     if(jCheckControl.isSelected()){
                    pst.setString(38,jCheckControl.getText());
                }
                if(jCheckAnimal.isSelected()){
                    pst.setString(38,jCheckAnimal.getText());
                }
                if(jCheckKill.isSelected()){
                    pst.setString(38,jCheckKill.getText());
                }
                if(jCheckSuicide.isSelected()){
                    pst.setString(38,jCheckSuicide.getText());
                }
                if(jCheckExtraordinary.isSelected()){
                    pst.setString(38,jCheckExtraordinary.getText());
                }
                if(jCheckAccident.isSelected()){
                    pst.setString(38,jCheckAccident.getText());
                }
                if(jCheckUnknow.isSelected()){
                    pst.setString(38,jCheckUnknow.getText());
                }     
                pst.setString(39,CircumstancesOfDeath.getText());
                 pst.setString(40,OccuredDateEnd.getJFormattedTextField().getText());                
                pst.setString(41,occuredTimeEnd);      

                pst.setString(42,crimecaseid.getText());
                
               int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการแก้ไขข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
         insertChargeReport();
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
        data2.put("typecase", "ชันสูตร");
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
         JSONObject data2 = new JSONObject();
        data2.put("caseid", crimecaseid.getText());
        data2.put("typecase", "ชันสูตร");
        if(ChargeNameCase.getText().length()==0 || ChargeNameCase.getText()==null|| ChargeNameCase.getText().isEmpty()){
            JSONObject data = new JSONObject();
            data.put("caseid",crimecaseid.getText());
            ChargePage d = new ChargePage(f,null,data2);
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
                    

                    ChargePage d = new ChargePage(f,data,data2);
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
    private void jButtonAddAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAssetActionPerformed
        // TODO add your handling code here:
        String aa=crimecaseid.getText();
        String type="ชันสูตร";
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

    private void jButtonAddInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInvestActionPerformed
        String ci=crimecaseid.getText();
        
        JSONObject data = new JSONObject();
        data.put("CaseIdRec",ci );
         data.put("TypeCase","ชันสูตร" );
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        closeAllDialogs();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonEditCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditCaseActionPerformed
        // TODO add your handling code here:
        jButtonSaveCase.setEnabled(true);
        openTextBox();
    }//GEN-LAST:event_jButtonEditCaseActionPerformed

    private void jCheckUnknowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckUnknowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckUnknowActionPerformed

    private void jCheckW202ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW202ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW202ActionPerformed

    private void jCheckW204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW204ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW204ActionPerformed

    private void jCheckW206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW206ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW206ActionPerformed

    private void jCheckW226ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW226ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW226ActionPerformed

    private void jCheckW225ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW225ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW225ActionPerformed

    private void jCheckW227ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW227ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW227ActionPerformed

    private void jCheckW239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW239ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW239ActionPerformed

    private void jCheckW280ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW280ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW280ActionPerformed

    private void jCheckW262ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW262ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW262ActionPerformed

    private void jCheckW253ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW253ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW253ActionPerformed

    private void jCheckW224ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW224ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW224ActionPerformed

    private void jCheckW246ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW246ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW246ActionPerformed

    private void jCheckW215ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW215ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW215ActionPerformed

    private void jCheckW214ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW214ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW214ActionPerformed

    private void jCheckW234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW234ActionPerformed

    private void jCheckW258ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW258ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW258ActionPerformed

    private void jCheckW271ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW271ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW271ActionPerformed

    private void jCheckW259ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW259ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW259ActionPerformed

    private void jCheckW274ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW274ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW274ActionPerformed

    private void jButtonPrintDoc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintDoc2ActionPerformed
        // TODO add your handling code here:
        insertRep();
        yourAttemptActionPerformed();
    }//GEN-LAST:event_jButtonPrintDoc2ActionPerformed

    private void jCheckW279ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW279ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW279ActionPerformed

    private void jButtonOpenFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenFolderActionPerformed
        // TODO add your handling code here:
        File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }
    }//GEN-LAST:event_jButtonOpenFolderActionPerformed

    private void jButtonAddAccused1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAccused1ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
        facc.removeAll();
        JSONObject datacase=new JSONObject();
        datacase.put("TypeCase","ชันสูตร" );
        datacase.put("CaseId",crimecaseid.getText());
        //       if(typeC.equals("ชันสูตร")){
            //       Identity_AccusedForm ida=new Identity_AccusedForm(facc,null);
            //                  ida.pack();
            //        ida.setLocationRelativeTo(null);
            //       ida.setVisible(true);
            //       }
        //       else{
            AccusedForm accusedF=new AccusedForm(facc,null,datacase);
            accusedF.pack();
            accusedF.setLocationRelativeTo(null);
            accusedF.setVisible(true);

            //       }
        RefreshDataAcc();
    }//GEN-LAST:event_jButtonAddAccused1ActionPerformed

    private void jButtonEditAccured1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAccured1ActionPerformed
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame f = (JFrame)(dialog.getParent());
        f.removeAll();
        String crimecaseno = crimecaseid.getText();
        if(jTableAccure.getSelectedRow()>=0){

            try{
                JSONObject datacase=new JSONObject();
                datacase.put("TypeCase","ชันสูตร" );
                String Noperson = jTableAccure.getModel().getValueAt(jTableAccure.getSelectedRow(), 8)+"";
                String sql = "select NoPerson,Age,AnswerPerson,OccupationPosition,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                "Height,Weight,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                "PhonePerson,Province,Related,Race,OrderPerson,Religion,Tambon,TypePerson,ZipCode,caseIdPerson,CauseSendInjuredOrDie,WhereSendInjuredOrDie,DateSendInjuredOrDie,TimeSendInjuredOrDie,StatusInjuryOrDie"
                + " from person where Noperson='"+Noperson+ "' and caseIdPerson='"+crimecaseno+"' and TypePerson='ผู้กล่าวหา'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                //                System.out.println("dddddddddddddd:"+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("NoPerson", rs.getString("NoPerson"));
                    data.put("PeopleRegistrationID", rs.getString("PeopleRegistrationID"));
                    data.put("crimecaseno", rs.getString("caseIdPerson"));
                    data.put("Age", rs.getString("Age"));
                    data.put("Amphur", rs.getString("Amphur"));
                    data.put("BirthDay", rs.getString("BirthDay"));
                    data.put("BloodGroup", rs.getString("BloodGroup"));
                    data.put("ExpiredDate", rs.getString("ExpiredDate"));
                    data.put("FatherFullName", rs.getString("FatherFullName"));
                    data.put("FullNamePerson", rs.getString("FullNamePerson"));
                    data.put("FullNamePersonEn", rs.getString("FullNamePersonEn"));
                    data.put("Gender", rs.getString("Gender"));
                    data.put("Height", rs.getString("Height"));
                    data.put("Weight", rs.getString("Weight"));
                    data.put("HouseNumber", rs.getString("HouseNumber"));
                    data.put("IssueDate", rs.getString("IssueDate"));
                    data.put("Moo", rs.getString("Moo"));
                    data.put("MotherFullName", rs.getString("MotherFullName"));
                    data.put("Nationality", rs.getString("Nationality"));
                    data.put("Occupation", rs.getString("Occupation"));
                    data.put("PassportNumber", rs.getString("PassportNumber"));
                    data.put("PhonePerson", rs.getString("PhonePerson"));
                    data.put("Province", rs.getString("Province"));
                    data.put("Race", rs.getString("Race"));
                    data.put("Religion", rs.getString("Religion"));
                    data.put("Tambon", rs.getString("Tambon"));
                    data.put("ZipCode", rs.getString("ZipCode"));
                    data.put("OrderPerson", rs.getString("OrderPerson"));
                    data.put("OtherName", rs.getString("OtherName"));
                    data.put("Related", rs.getString("Related"));
                    data.put("AnswerPerson", rs.getString("AnswerPerson"));
                    data.put("OccupationPosition", rs.getString("OccupationPosition"));

                    data.put("StatusInjuryOrDie", rs.getString("StatusInjuryOrDie"));
                    data.put("DateSendInjuredOrDie", rs.getString("DateSendInjuredOrDie"));
                    data.put("TimeSendInjuredOrDie", rs.getString("TimeSendInjuredOrDie"));
                    data.put("CauseSendInjuredOrDie", rs.getString("CauseSendInjuredOrDie"));
                    data.put("WhereSendInjuredOrDie", rs.getString("WhereSendInjuredOrDie"));

                    AccusedForm accusedF=new AccusedForm(f,data,datacase);
                    accusedF.pack();
                    accusedF.setLocationRelativeTo(null);
                    accusedF.setVisible(true);
                }

                rs.close();
                stmt.close();
                RefreshDataAcc();
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else{

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditAccured1ActionPerformed

    private void jButtonDeleteAccured1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccured1ActionPerformed
        if(jTableAccure.getSelectedRow()>=0){

            try{
                String Noperson = jTableAccure.getModel().getValueAt(jTableAccure.getSelectedRow(), 8)+"";
                String PeopleRegistrationID = jTableAccure.getModel().getValueAt(jTableAccure.getSelectedRow(), 2)+"";
                String sql = "Delete from person WHERE Noperson='"+Noperson+ "' and  caseIdPerson='"+crimecaseid.getText()+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);

                System.out.println("SQL : "+sql);
                stmt.close();
                RefreshDataAcc();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteAccured1ActionPerformed

    private void jButtonDeleteAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccuredActionPerformed
        if(jTableSuspect.getSelectedRow()>=0){
            String aa=crimecaseid.getText();
            try{
                //                String crimecaseno = jTableSuspect.getModel().getValueAt(jTableSuspect.getSelectedRow(), 0)+"";
                String Noperson = jTableSuspect.getModel().getValueAt(jTableSuspect.getSelectedRow(), 7)+"";
                String sql = "Delete from person WHERE Noperson='"+Noperson+ "' and  caseIdPerson='"+aa+"' and (TypePerson='ผู้ต้องหา' or TypePerson='ผู้ตาย');\n"+
                "Delete from Deliverysuspect WHERE delipersonid='"+Noperson+"';\n"+
                "Delete from BailAsset WHERE BailPersonId='"+Noperson+"';";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                System.out.println("SQL : "+sql);
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteAccuredActionPerformed

    private void jButtonAddAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAccusedActionPerformed
        // TODO add your handling code here:
        JSONObject datacase=new JSONObject();
        datacase.put("TypeCase",typeC );
        datacase.put("CaseId",crimecaseid.getText() );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame s = (JFrame)(dialog.getParent());
        s.removeAll();
        if(typeC.equals("Dead")){
            Identity_DeadForm idd=new Identity_DeadForm(s,null);
            idd.pack();
            idd.setLocationRelativeTo(null);
            idd.setVisible(true);
        }

        else{
            SuspectForm susF=new SuspectForm(s,null,datacase);
            susF.pack();
            susF.setLocationRelativeTo(null);
            susF.setVisible(true);
        }

        RefreshData();
    }//GEN-LAST:event_jButtonAddAccusedActionPerformed

    private void jButtonEditAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAccuredActionPerformed
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame f = (JFrame)(dialog.getParent());
        f.removeAll();
        String crimecaseno = crimecaseid.getText();
        if(jTableSuspect.getSelectedRow()>=0){

            try{
                String Noperson = jTableSuspect.getModel().getValueAt(jTableSuspect.getSelectedRow(), 7)+"";
                String sql = "select NoPerson,TambomDie,AmphurDie,ProvinceDie,TambomFoundBody,AmphurFoundBody,ProvinceFoundBody,Identification,CurrentAddress,Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                "Height,Weight,HouseNumber,NoArrestWarrant,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                "PhonePerson,OrderPerson,StatusSuspect,StatusSuspectOther,BailDate,StatusBail,RatePrison,CourtSuspect,ArrestDateTimeEnd,Province,Race,Religion,Tambon,TypePerson,"
                + "ZipCode,caseIdPerson,ArrestDateTime,PlaceArrest,SusConfress,PlaceOfFoundBody,DeathLocation,StatusSueAndPutInJail,BodyFoundDate,BodyFoundTime,DateOfDie,TimeOfDie,Road,Soi,"
                + "AnswerPerson,PlaceArrestTambon,PlaceArrestAmphur,PlaceArrestProvince,OccupationPosition,CauseSendInjuredOrDie,WhereSendInjuredOrDie,DateSendInjuredOrDie,TimeSendInjuredOrDie,StatusInjuryOrDie,StatusWarrant\n"
                + "from person where noperson='"+Noperson+ "' and caseIdPerson='"+crimecaseno+"'";

                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("dddddddddddddd:"+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("StatusSuspect", rs.getString("StatusSuspect"));
                    data.put("NoPerson", rs.getString("NoPerson"));
                    data.put("PeopleRegistrationID", rs.getString("PeopleRegistrationID"));
                    data.put("crimecaseno", rs.getString("caseIdPerson"));
                    data.put("Identification", rs.getString("Identification"));
                    data.put("Age", rs.getString("Age"));
                    data.put("Amphur", rs.getString("Amphur"));
                    data.put("BirthDay", rs.getString("BirthDay"));
                    data.put("BloodGroup", rs.getString("BloodGroup"));
                    data.put("ExpiredDate", rs.getString("ExpiredDate"));
                    data.put("FatherFullName", rs.getString("FatherFullName"));
                    data.put("FullNamePerson", rs.getString("FullNamePerson"));
                    data.put("FullNamePersonEn", rs.getString("FullNamePersonEn"));
                    data.put("Gender", rs.getString("Gender"));
                    data.put("Height", rs.getString("Height"));
                    data.put("Weight", rs.getString("Weight"));
                    data.put("OrderPerson", rs.getString("OrderPerson"));
                    data.put("HouseNumber", rs.getString("HouseNumber"));
                    data.put("IssueDate", rs.getString("IssueDate"));
                    data.put("Moo", rs.getString("Moo"));
                    data.put("MotherFullName", rs.getString("MotherFullName"));
                    data.put("Nationality", rs.getString("Nationality"));
                    data.put("Occupation", rs.getString("Occupation"));
                    data.put("PassportNumber", rs.getString("PassportNumber"));
                    data.put("PhonePerson", rs.getString("PhonePerson"));
                    data.put("Province", rs.getString("Province"));
                    data.put("Race", rs.getString("Race"));
                    data.put("Religion", rs.getString("Religion"));
                    data.put("Tambon", rs.getString("Tambon"));
                    data.put("CurrentAddress", rs.getString("CurrentAddress"));
                    data.put("ArrestDateTime", rs.getString("ArrestDateTime"));
                    data.put("ArrestDateTimeEnd", rs.getString("ArrestDateTimeEnd"));
                    data.put("StatusBail", rs.getString("StatusBail"));
                    data.put("RatePrison", rs.getString("RatePrison"));
                    data.put("CourtSuspect", rs.getString("CourtSuspect"));
                    data.put("BailDate", rs.getString("BailDate"));
                    data.put("ZipCode", rs.getString("ZipCode"));
                    data.put("SusConfress", rs.getString("SusConfress"));
                    data.put("PlaceArrest", rs.getString("PlaceArrest"));
                    data.put("caseIdPerson", rs.getString("caseIdPerson"));
                    data.put("PlaceOfFoundBody", rs.getString("PlaceOfFoundBody"));
                    data.put("DeathLocation", rs.getString("DeathLocation"));
                    data.put("BodyFoundDate", rs.getString("BodyFoundDate"));
                    data.put("BodyFoundTime", rs.getString("BodyFoundTime"));
                    data.put("DateOfDie", rs.getString("DateOfDie"));
                    data.put("TimeOfDie", rs.getString("TimeOfDie"));
                    data.put("StatusSueAndPutInJail", rs.getString("StatusSueAndPutInJail"));
                    data.put("OtherName", rs.getString("OtherName"));
                    data.put("TambomDie", rs.getString("TambomDie"));
                    data.put("AmphurDie", rs.getString("AmphurDie"));
                    data.put("ProvinceDie", rs.getString("ProvinceDie"));
                    data.put("TambomFoundBody", rs.getString("TambomFoundBody"));
                    data.put("AmphurFoundBody", rs.getString("AmphurFoundBody"));
                    data.put("ProvinceFoundBody", rs.getString("ProvinceFoundBody"));
                    data.put("NoArrestWarrant", rs.getString("NoArrestWarrant"));
                    data.put("AnswerPerson", rs.getString("AnswerPerson"));
                    data.put("PlaceArrestTambon", rs.getString("PlaceArrestTambon"));
                    data.put("PlaceArrestAmphur", rs.getString("PlaceArrestAmphur"));
                    data.put("PlaceArrestProvince", rs.getString("PlaceArrestProvince"));
                    data.put("OccupationPosition", rs.getString("OccupationPosition"));

                    data.put("StatusInjuryOrDie", rs.getString("StatusInjuryOrDie"));
                    data.put("DateSendInjuredOrDie", rs.getString("DateSendInjuredOrDie"));
                    data.put("TimeSendInjuredOrDie", rs.getString("TimeSendInjuredOrDie"));
                    data.put("CauseSendInjuredOrDie", rs.getString("CauseSendInjuredOrDie"));
                    data.put("WhereSendInjuredOrDie", rs.getString("WhereSendInjuredOrDie"));
                    data.put("StatusSuspectOther", rs.getString("StatusSuspectOther"));
                    data.put("Road", rs.getString("Road"));
                    data.put("Soi", rs.getString("Soi"));
                    data.put("StatusWarrant", rs.getString("StatusWarrant"));

                    if(typeC.equals("Dead")){
                        Identity_DeadForm id=new Identity_DeadForm(f,data);
                        id.pack();
                        id.setLocationRelativeTo(null);
                        id.setVisible(true);
                    }else{
                        JSONObject datacase=new JSONObject();
                        datacase.put("TypeCase",typeC );
                        SuspectForm suspectF=new SuspectForm(f,data,datacase);
                        suspectF.pack();
                        suspectF.setLocationRelativeTo(null);
                        suspectF.setVisible(true);   }
                }

                rs.close();
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else{

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditAccuredActionPerformed

    private void jButtonAddAccused2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAccused2ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame s = (JFrame)(dialog.getParent());
        s.removeAll();
        JSONObject datacase=new JSONObject();
        datacase.put("TypeCase", "ชันสูตร");
        datacase.put("CaseId",crimecaseid.getText() );
        //       if(typeC.equals("ชันสูตร")){
            //       Identity_witnessForm idw=new Identity_witnessForm(s,null);
            //       idw.pack();
            //       idw.setLocationRelativeTo(null);
            //       idw.setVisible(true);
            //       }
        //       else{
            WitnessForm wf=new WitnessForm(s,null,datacase);
            wf.pack();
            wf.setLocationRelativeTo(null);
            wf.setVisible(true);
            //       }

        RefreshDataWit();
    }//GEN-LAST:event_jButtonAddAccused2ActionPerformed

    private void jButtonDeleteAccured2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccured2ActionPerformed
        if(jTableWitness.getSelectedRow()>=0){

            try{
                String crimecaseno = crimecaseid.getText();
                String Noperson = jTableWitness.getModel().getValueAt(jTableWitness.getSelectedRow(), 7)+"";
                String sql = "Delete from person WHERE Noperson='"+Noperson+ "' and  caseIdPerson='"+crimecaseno+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);

                System.out.println("SQL : "+sql);
                stmt.close();
                RefreshDataWit();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteAccured2ActionPerformed

    private void jButtonEditAccured2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAccured2ActionPerformed
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame f = (JFrame)(dialog.getParent());
        f.removeAll();
        String crimecaseno = crimecaseid.getText();
        if(jTableWitness.getSelectedRow()>=0){

            try{
                JSONObject datacase=new JSONObject();
                datacase.put("TypeCase","ชันสูตร" );
                String NoPerson = jTableWitness.getModel().getValueAt(jTableWitness.getSelectedRow(), 7)+"";
                String sql = "select NoPerson,Age,Amphur,BirthDay,AnswerPerson,OccupationPosition,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                "Height,Weight,HouseNumber,Related,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                "PhonePerson,Province,Race,OrderPerson,Religion,Tambon,TypePerson,ZipCode,caseIdPerson,CauseSendInjuredOrDie,WhereSendInjuredOrDie,DateSendInjuredOrDie,TimeSendInjuredOrDie,StatusInjuryOrDie"
                + " from person where TypePerson='พยานและบุคคลอื่นๆ' and NoPerson='"+NoPerson+ "' and caseIdPerson='"+crimecaseno+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                //                System.out.println("dddddddddddddd:"+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("NoPerson", rs.getString("NoPerson"));
                    data.put("PeopleRegistrationID", rs.getString("PeopleRegistrationID"));
                    data.put("caseIdPerson", rs.getString("caseIdPerson"));
                    data.put("Age", rs.getString("Age"));
                    data.put("Amphur", rs.getString("Amphur"));
                    data.put("BirthDay", rs.getString("BirthDay"));
                    data.put("BloodGroup", rs.getString("BloodGroup"));
                    data.put("ExpiredDate", rs.getString("ExpiredDate"));
                    data.put("FatherFullName", rs.getString("FatherFullName"));
                    data.put("FullNamePerson", rs.getString("FullNamePerson"));
                    data.put("FullNamePersonEn", rs.getString("FullNamePersonEn"));
                    data.put("Gender", rs.getString("Gender"));
                    data.put("Height", rs.getString("Height"));
                    data.put("Weight", rs.getString("Weight"));
                    data.put("HouseNumber", rs.getString("HouseNumber"));
                    data.put("IssueDate", rs.getString("IssueDate"));
                    data.put("Moo", rs.getString("Moo"));
                    data.put("MotherFullName", rs.getString("MotherFullName"));
                    data.put("Nationality", rs.getString("Nationality"));
                    data.put("Occupation", rs.getString("Occupation"));
                    data.put("PassportNumber", rs.getString("PassportNumber"));
                    data.put("PhonePerson", rs.getString("PhonePerson"));
                    data.put("Province", rs.getString("Province"));
                    data.put("Race", rs.getString("Race"));
                    data.put("Religion", rs.getString("Religion"));
                    data.put("Tambon", rs.getString("Tambon"));
                    data.put("ZipCode", rs.getString("ZipCode"));
                    data.put("OrderPerson", rs.getString("OrderPerson"));
                    data.put("Related", rs.getString("Related"));
                    data.put("OtherName", rs.getString("OtherName"));
                    data.put("AnswerPerson", rs.getString("AnswerPerson"));
                    data.put("OccupationPosition", rs.getString("OccupationPosition"));

                    data.put("StatusInjuryOrDie", rs.getString("StatusInjuryOrDie"));
                    data.put("DateSendInjuredOrDie", rs.getString("DateSendInjuredOrDie"));
                    data.put("TimeSendInjuredOrDie", rs.getString("TimeSendInjuredOrDie"));
                    data.put("CauseSendInjuredOrDie", rs.getString("CauseSendInjuredOrDie"));
                    data.put("WhereSendInjuredOrDie", rs.getString("WhereSendInjuredOrDie"));
                    WitnessForm wF=new WitnessForm(f,data,datacase);
                    wF.pack();
                    wF.setLocationRelativeTo(null);
                    wF.setVisible(true);
                }

                rs.close();
                stmt.close();
                RefreshDataWit();
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }else{

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditAccured2ActionPerformed

    private void CrimeLocationDistrictKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CrimeLocationDistrictKeyReleased
        // TODO add your handling code here:
        String provinceid="";
        String loTam="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {
            Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.NAMETAMBON='"+CrimeLocationDistrict.getText()+"'";
            ResultSet res2 = st2.executeQuery(a);
            //            System.out.println("provinceid: "+CrimeLocationProvince.getSelectedItem());
            if(res2.next()){
                zp=res2.getString("ZIPCODE");
                provinceid=res2.getString("DOPA_CODE");
                loTam= provinceid.substring(0, 4);
                //          ZipCode.setText(zp);
            }
            Statement st = con2.createStatement();
            String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
            "from Amphur\n" +
            "where Amphur.DOPA_CODE like '"+loTam+"%';";
            System.out.println("sddddddddd:"+c);

            ResultSet res = st.executeQuery(c);
            //Vector<Object> v=new Vector<Object>();
            //	           System.out.println("provinceid: "+provinceid);
            if(res.next())
            {

                amp=res.getString("NameAmphur");
                String ffa=res.getString("DOPA_CODE");
                loAmphur=ffa.substring(0, 2);
                CrimeLocationAmphur.setText(amp);

            }
            Statement st3 = con2.createStatement();
            String c3 = "select nameprovince\n" +
            "from province\n" +
            "where provinceid = '"+loAmphur+"';";
            System.out.println("sddddddddd:"+c3);
            ResultSet res3 = st3.executeQuery(c3);
            if(res3.next())
            {

                pro=res3.getString("nameprovince");
                CrimeLocationProvince.setText(pro);

            }

        }
        catch (Exception d) {  //System.out.println(d);
        }
    }//GEN-LAST:event_CrimeLocationDistrictKeyReleased

    private void CrimeLocationAmphurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CrimeLocationAmphurKeyReleased
        // TODO add your handling code here:
        String provinceid="";
        String loPro="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {

            Statement st = con2.createStatement();
            String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
            "from Amphur\n" +
            "where Amphur.NameAmphur = '"+CrimeLocationAmphur.getText()+"';";
            System.out.println("sddddddddd:"+c);

            ResultSet res = st.executeQuery(c);
            //Vector<Object> v=new Vector<Object>();
            //	           System.out.println("provinceid: "+provinceid);
            if(res.next())
            {

                String ffa=res.getString("DOPA_CODE");
                loAmphur=ffa.substring(0, 4);
                loPro=ffa.substring(0, 2);

            }

            Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.DOPA_CODE like '"+loAmphur+"%'";
            ResultSet res2 = st2.executeQuery(a);
            Statement st3 = con2.createStatement();
            if(res2.next()){
                zp=res2.getString("ZIPCODE");
                //          ZipCode.setText(zp);
            }
            String c3 = "select nameprovince\n" +
            "from province\n" +
            "where provinceid = '"+loPro+"';";
            System.out.println("sddddddddd:"+c3);
            ResultSet res3 = st3.executeQuery(c3);
            if(res3.next())
            {

                pro=res3.getString("nameprovince");
                CrimeLocationProvince.setText(pro);

            }

        }
        catch (Exception d) {  //System.out.println(d);
        }
    }//GEN-LAST:event_CrimeLocationAmphurKeyReleased
  
       private void yourAttemptActionPerformed() {


       
    new BackgroundWorker().execute();


    }
       
    public class BackgroundWorker extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
		private JDialog dialog;
//   public void Task() {
//       
//    }
//       public ProgressWorker(JProgressBar progress) {
//            this.progress = progress;
//        
            public BackgroundWorker() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
							dialog = new JDialog();
                                                        ImageIcon img = new ImageIcon("./Master/WD.png");
                                                           dialog.setIconImage(img.getImage());
							dialog.setTitle("Processing");
							dialog.setLayout(new GridBagLayout());
							dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							GridBagConstraints gbc = new GridBagConstraints();
							gbc.insets = new Insets(2, 2, 2, 2);
							gbc.weightx = 1;
							gbc.gridy = 0;
							dialog.add(new JLabel("Processing..."), gbc);
							pb = new JProgressBar();
							pb.setStringPainted(true);
                                                        pb.setMaximum(100);
                                                        pb.setMinimum(0);
                                                        
							gbc.gridy = 1;
							dialog.add(pb, gbc);
							dialog.pack();
							dialog.setLocationRelativeTo(null);
							dialog.setModal(true);
							JDialog.setDefaultLookAndFeelDecorated(true); 
							dialog.setVisible(true);
						}
						pb.setValue(getProgress());
					}
				}

			});
		}
    @Override
    public Void doInBackground() {
            String no=crimecaseid.getText();
            JCheckBox[] boxes = {jCheckW201,jCheckW202,jCheckW204,jCheckW206,jCheckW208,jCheckW211,jCheckW212,jCheckW213,jCheckW214};
        try { 
            for (int i = 0; i < boxes.length; i++) {
//                x = x - i;
            setProgress((int)((i*100)/boxes.length)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task
   
            caseyear=crimecaseyear.getText();
           caseno=crimecaseno.getText();
           casetype=CaseType.getText();     
        File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
   
        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
          if(jCheckW201.isSelected()){
            W1.w1(no);
        }

                if(jCheckW202.isSelected()){
            W2.w2(no);

        }
//        if(jCheckW203.isSelected()){
//            W3.w3(no);
//        }
        if(jCheckW204.isSelected()){
            W4.w4(no);
        }
//        if(jCheckW205.isSelected()){
//            W5.w5(no);
//        }
        if(jCheckW206.isSelected()){
            W6.w6(no);
        }
        
        if(jCheckW207.isSelected()){
            W7.w7(no);
        }
        if(jCheckW208.isSelected()){
            W8.w8(no);  
            W812.w812(no);
        }
       
//        if(jCheckW209.isSelected()){
//            W9.w9(no);
//        }
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
               if(jCheckW218.isSelected()){
                       W18.w18(no);
                   }
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
               if(jCheckW261.isSelected()){
                        W61.w61(no);
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
                        W66.w66(no);
                    }
//               if(jCheckW267.isSelected()){
////                        W67.w67(no);
//                    }
//            
//               if(jCheckW269.isSelected()){
//                        W69.w69(no);
//                    }
               if(jCheckW270.isSelected()){
                        W70.w70(no,null);
                    }
               if(jCheckW271.isSelected()){
                        W71.w71(no,null);
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
               if(jCheckW277.isSelected()){
                        W77.w77(no);
                    }
               if(jCheckW278.isSelected()){
                        W78.w78(no);
                    }
               if(jCheckW279.isSelected()){
                        W79.w79(no);
                    }
               if(jCheckW280.isSelected()){
                        W80.w80(no);
                    }
               if(jCheckW293.isSelected()){
                        W93.w93(no);
                    }
            }
        } catch (InterruptedException e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
             Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }
         jButtonOpenFolder.setVisible(true);
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
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
        	String c = "Select InvestId,InvestRank,InvestName from InvestInformation";
        	ResultSet res = st.executeQuery(c);
	
	while(res.next())
	{   String id=res.getString("InvestId");
        String category=res.getString("InvestRank")+res.getString("InvestName");

        Object[] itemData = new Object[] {id, category};

        jComboPoliceName.addItem(new ComboItem(category, id));

       
	}
//        else{jComboPoliceName.addItem("");}
	
}
catch (Exception d) {  //System.out.println(d);  
}
    }
    
//      public void comboProvince(){
//    
//     try {
//
//         Connection con2 = ConnectDatabase.connect();
//	Statement st = con2.createStatement();
//        	String c = "Select nameprovince,PROVINCEID from province";
//        	ResultSet res = st.executeQuery(c);
//	//Vector<Object> v=new Vector<Object>();
//	
//	while(res.next())
//	{
//             int Province_id = Integer.parseInt(res.getString("PROVINCEID"));
//              Province_name = res.getString("nameprovince"); 
//	CrimeLocationProvince.addItem(res.getString("nameprovince"));
//        
//
//	
//	}
//        
////        else{jComboPoliceName.addItem("");}
//	
//}
//catch (Exception d) {  //System.out.println(d);  
//}
//    }
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
            java.util.logging.Logger.getLogger(IdentityEdit1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentityEdit1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentityEdit1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentityEdit1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
//       jButtonAccured.setEnabled(true);
//         jButtonSuspect.setEnabled(true);
//       jButtonWitness.setEnabled(true);
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
         jCheckDuringInvest.setEnabled(true);
//       jCheckSue.setEnabled(true);
//       jCheckNotSue.setEnabled(true);
       jCheckNoInvest.setEnabled(true);
       jCheckOtherInvest.setEnabled(true);
           OccuredDateEnd.getComponent(1).setEnabled(true);
       OccuredDateEnd.getJFormattedTextField().setEnabled(true);
       OccuredDateTimeEnd.setEnabled(true);
       CircumstancesOfDeath.setEnabled(true);
          jCheckControl.setEnabled(true);
       jCheckAnimal.setEnabled(true);
       jCheckKill.setEnabled(true);
       jCheckSuicide.setEnabled(true);
       jCheckExtraordinary.setEnabled(true);
       jCheckAccident.setEnabled(true);
       jCheckUnknow.setEnabled(true);
        jButtonAddAccused.setEnabled(true);
       jButtonEditAccured.setEnabled(true);
       jButtonDeleteAccured.setEnabled(true);
       jButtonAddAccused1.setEnabled(true);
       jButtonEditAccured1.setEnabled(true);
       jButtonDeleteAccured1.setEnabled(true);
       jButtonAddAccused2.setEnabled(true);
       jButtonEditAccured2.setEnabled(true);
       jButtonDeleteAccured2.setEnabled(true);
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
//       jButtonAccured.setEnabled(false);
//         jButtonSuspect.setEnabled(false);
//       jButtonWitness.setEnabled(false);
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
        jCheckDuringInvest.setEnabled(false);
       jCheckSue.setEnabled(false);
       jCheckNotSue.setEnabled(false);
       jCheckNoInvest.setEnabled(false);
       jCheckOtherInvest.setEnabled(false);
           OccuredDateEnd.getComponent(1).setEnabled(false);
       OccuredDateEnd.getJFormattedTextField().setEnabled(false);
       OccuredDateTimeEnd.setEnabled(false);
       jCheckControl.setEnabled(false);
       jCheckAnimal.setEnabled(false);
       jCheckKill.setEnabled(false);
       jCheckSuicide.setEnabled(false);
       jCheckExtraordinary.setEnabled(false);
       jCheckAccident.setEnabled(false);
       jCheckUnknow.setEnabled(false);
        CircumstancesOfDeath.setEnabled(false);
         jButtonAddAccused.setEnabled(false);
       jButtonEditAccured.setEnabled(false);
       jButtonDeleteAccured.setEnabled(false);
       jButtonAddAccused1.setEnabled(false);
       jButtonEditAccured1.setEnabled(false);
       jButtonDeleteAccured1.setEnabled(false);
       jButtonAddAccused2.setEnabled(false);
       jButtonEditAccured2.setEnabled(false);
       jButtonDeleteAccured2.setEnabled(false);

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
//      public void ChangProvince(){
//        CrimeLocationProvince.addItemListener(new ItemListener() {
//        public void itemStateChanged(ItemEvent arg0) {
//            //Do Something
//            
//             String provinceid="";
//        Connection con2 = ConnectDatabase.connect();
//        try {
//            Statement st2 = con2.createStatement();
//            String a="select Province.DOPA_CODE DOPA_CODE,Province.PROVINCEID PROVINCEID from Province\n"+
//            "where Province.NAMEPROVINCE='"+CrimeLocationProvince.getSelectedItem()+"'";
//                    	ResultSet res2 = st2.executeQuery(a);
//            System.out.println("provinceid: "+CrimeLocationProvince.getSelectedItem());
//        if(res2.next()){
//        provinceid=res2.getString("PROVINCEID");
//        }
//	Statement st = con2.createStatement();
//        	String c = "select Amphur.NameAmphur NameAmphur\n" +
//                            "from Amphur\n" +
//                            "where Amphur.DOPA_CODE like '"+provinceid+"%';";
//        	ResultSet res = st.executeQuery(c);
//	//Vector<Object> v=new Vector<Object>();
////	           System.out.println("provinceid: "+provinceid);
//        CrimeLocationAmphur.removeAllItems();
//	while(res.next())
//	{
//	CrimeLocationAmphur.addItem(res.getString("NameAmphur"));
//
//	
//	}
//        }
//        catch (Exception d) {  //System.out.println(d);  
//}
//      
//        }
//    });
//      CrimeLocationAmphur.addItemListener(new ItemListener() {
//        public void itemStateChanged(ItemEvent arg0) {
//            //Do Something
//            String provinceid="";
//                  String amphurid="";
//
//        Connection con2 = ConnectDatabase.connect();
//        try {
//            Statement st2 = con2.createStatement();
//            Statement st3 = con2.createStatement();
//
//            String a="select Province.DOPA_CODE DOPA_CODE,Province.PROVINCEID PROVINCEID from Province\n"+
//            "where Province.NAMEPROVINCE='"+CrimeLocationProvince.getSelectedItem()+"'";
//             String b="select Amphur.LOC_CODE LOC_CODE from Amphur\n"+
//            "where Amphur.NAMEAMPHUR='"+CrimeLocationAmphur.getSelectedItem()+"'";
//                    	ResultSet res2 = st2.executeQuery(a);
//                        ResultSet res3 = st3.executeQuery(b);
//        if(res2.next()){
//        provinceid=res2.getString("PROVINCEID");
//        
//        }
////        System.out.println("provinceid: "+provinceid);
//        if(res3.next()){
//        amphurid=res3.getString("LOC_CODE");
//        }
//	Statement st = con2.createStatement();
//        	String c = "select Tambon.NAMETAMBON NAMETAMBON\n" +
//                            "from Tambon\n" +
//                            "where Tambon.DOPA_CODE like '"+provinceid+amphurid+"%';";
//        	ResultSet res = st.executeQuery(c);
//	//Vector<Object> v=new Vector<Object>();
////	           System.out.println("provinceid: "+c);
//         CrimeLocationDistrict.removeAllItems();
//	while(res.next())
//	{
//	CrimeLocationDistrict.addItem(res.getString("NAMETAMBON"));
//
//	
//	}
//        }
//        catch (Exception d) {  //System.out.println(d);  
//}
//        }
//    });      
//    }
       public void RefreshData(){
        try{
//         String type=null;
//         if(typeC.equals("อาญา")){
//            type="ผู้ต้องหา";
////             type="ผู้ตาย";
//            
//         }
//         else{
//             type="ผู้ตาย";
//            
//         }
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        String a=crimecaseid.getText();
        String type=null;
        if(typeC.equals("Dead")){
            type="ผู้ตาย";
        }
        else{
            type="ผู้ต้องหา";
        }
        String sql = "select NoPerson,Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                     "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                     "PhonePerson,OrderPerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,caseIdPerson from person where TypePerson='"+type+"'"
                + " and caseIdPerson='"+a+"' order by OrderPerson ASC";
      
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("OrderPerson"));            
            row.add(rs.getString("PeopleRegistrationID"));
            row.add(rs.getString("FullNamePerson"));
            row.add(rs.getString("Age"));
            row.add(rs.getString("Race"));
            row.add(rs.getString("Nationality"));
            row.add(rs.getString("Religion"));
            row.add(rs.getString("NoPerson"));

            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector();
        
         if(typeC.equals("Dead")){
         ColumnName.add("ลำดับผู้ตาย");
         }
         else{
         ColumnName.add("ลำดับผู้ต้องหา");}
         ColumnName.add("เลขบัตรประชาชน");
        ColumnName.add("ชื่อ-นามสกุล");
        ColumnName.add("อายุ");
        ColumnName.add("เชื้อชาติ");
        ColumnName.add("สัญชาติ");
        ColumnName.add("ศาสนา");
        ColumnName.add("เลขคน");
         System.out.println("SQL : "+sql);
     
        jTableSuspect.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
         jTableSuspect.getColumnModel().getColumn(7).setWidth(0);
        jTableSuspect.getColumnModel().getColumn(7).setMinWidth(0);
        jTableSuspect.getColumnModel().getColumn(7).setMaxWidth(0); 
                             System.out.println("SQL : "+sql);
        
   
    if(jTableSuspect.getRowCount()==1){
//             int rows = jTableAccure.getRowCount();
           
                 int rows = jTableSuspect.getRowCount();
             IdentityEdit1.jLabelNumberSus.setText(rows+"");
            IdentityEdit1.jTextSuspect.setText(jTableSuspect.getValueAt(0, 2).toString()); 
           
            }
     int rows = jTableSuspect.getRowCount();
        rows = jTableSuspect.getRowCount();
      if(jTableSuspect.getRowCount()<=0){
//             int rows = jTableAccure.getRowCount();
            IdentityEdit1.jLabelNumberSus.setText(rows+"");
            IdentityEdit1.jTextSuspect.setText(""); 
  
            }
            if(jTableSuspect.getRowCount()>1){
            
            
            
             IdentityEdit1.jLabelNumberSus.setText(rows+"");
            IdentityEdit1.jTextSuspect.setText(jTableSuspect.getValueAt(0, 2).toString()+"และพวก"); 
            
            }
    
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
           public void RefreshDataAcc(){
        try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        String a=crimecaseid.getText();
        String sql = "select Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                     "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                     "PhonePerson,NoPerson,Province,Race,Religion,OrderPerson,Tambon,TypePerson,Weight,ZipCode,caseIdPerson,Related from person where TypePerson='ผู้กล่าวหา' and"
                + " caseIdPerson='"+a+"' order by OrderPerson ASC";
      
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("OrderPerson"));
            row.add(rs.getString("PeopleRegistrationID"));
            row.add(rs.getString("FullNamePerson"));
            row.add(rs.getString("Age"));
            row.add(rs.getString("Race"));
            row.add(rs.getString("Nationality"));
            row.add(rs.getString("Religion"));
            row.add(rs.getString("Related"));
            
            row.add(rs.getString("NoPerson"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector();
         ColumnName.add("ลำดับผู้กล่าวหา");
         ColumnName.add("เลขบัตรประชาชน");
        ColumnName.add("ชื่อ-นามสกุล");
        ColumnName.add("อายุ");
        ColumnName.add("เชื้อชาติ");
        ColumnName.add("สัญชาติ");
        ColumnName.add("ศาสนา");
        ColumnName.add("เกี่ยวข้องเป็น");

        ColumnName.add("เลขคน");
         System.out.println("SQL : "+sql);
     
        jTableAccure.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
         jTableAccure.getColumnModel().getColumn(8).setWidth(0);
jTableAccure.getColumnModel().getColumn(8).setMinWidth(0);
jTableAccure.getColumnModel().getColumn(8).setMaxWidth(0); 
         if(jTableAccure.getRowCount()<=0){
//             int rows = jTableAccure.getRowCount();        
            IdentityEdit1.jTextAccused.setText("");           
            }
        else if(jTableAccure.getRowCount()==1){
//             int rows = jTableAccure.getRowCount();
                       
            IdentityEdit1.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString());           
            }
         else if(jTableAccure.getRowCount()>1){
                        
            IdentityEdit1.jTextAccused.setText(jTableAccure.getValueAt(0, 2).toString()+"และคนอื่นๆ"); 
        
            }
                    
             int rows = jTableAccure.getRowCount();
             IdentityEdit1.jLabelNumberAcc.setText(rows+"");  
   
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
             public void RefreshDataWit(){
        try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        String a=crimecaseid.getText();
        String sql = "select Age,Related,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                     "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                     "PhonePerson,Province,NoPerson,Race,Religion,Tambon,TypePerson,OrderPerson,Weight,ZipCode,caseIdPerson from person where TypePerson='พยานและบุคคลอื่นๆ' "
                + "and caseIdPerson='"+a+"' order by OrderPerson ASC";
      
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
             row.add(rs.getString("OrderPerson"));
            row.add(rs.getString("PeopleRegistrationID"));
            row.add(rs.getString("FullNamePerson"));
            row.add(rs.getString("Age"));
            row.add(rs.getString("Race"));
            row.add(rs.getString("Nationality"));
            row.add(rs.getString("Religion"));
            row.add(rs.getString("NoPerson"));
            row.add(rs.getString("Related"));

            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector();
         ColumnName.add("ลำดับพยาน");
         ColumnName.add("เลขบัตรประชาชน");
        ColumnName.add("ชื่อ-นามสกุล");
        ColumnName.add("อายุ");
        ColumnName.add("เชื้อชาติ");
        ColumnName.add("สัญชาติ");
        ColumnName.add("ศาสนา");
        ColumnName.add("เลขคน"); 
        ColumnName.add("เกี่ยวข้องเป็น");    
         System.out.println("SQL : "+sql);
     
        jTableWitness.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
                                  jTableWitness.getColumnModel().getColumn(7).setWidth(0);
jTableWitness.getColumnModel().getColumn(7).setMinWidth(0);
jTableWitness.getColumnModel().getColumn(7).setMaxWidth(0); 
           if(jTableWitness.getRowCount()<=0){
//             int rows = jTableAccure.getRowCount();
            
         
            IdentityEdit1.jTextWitness.setText(""); 
            
            }
    
        if(jTableWitness.getRowCount()==1){
//             int rows = jTableAccure.getRowCount();
           
        
            IdentityEdit1.jTextWitness.setText(jTableWitness.getValueAt(0, 2).toString()); 
            
            }
        if(jTableWitness.getRowCount()>1){
            
            
             
            IdentityEdit1.jTextWitness.setText(jTableWitness.getValueAt(0, 2).toString()+"และพวก"); 
            
            }
   
            int rows = jTableWitness.getRowCount();
                       IdentityEdit1.jLabelNumberWitness.setText(rows+"");
            
          
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
                    public static void insertChargeReport(){
      
      try{
          String datereport;
          SimpleDateFormat newdate=new SimpleDateFormat("yyyy-MM-dd HH:mm");
          Date d=new Date();
          datereport=newdate.format(d);
          Connection c=ConnectDatabase.connect();
          String sqlinsert="insert into DataCharge(TypeCaseCharge,ChargeUse,DateToday) VALUES (?,?,?)";
          PreparedStatement ps=c.prepareStatement(sqlinsert);
             ps.setString(1, "คดีชันสูตร");
           ps.setString(2, jLabelChargeCode.getText());
           ps.setString(3, datereport);
             ps.execute();
              ps.close();

      }
      catch(Exception x){
          System.out.println(""+x);
      
      }
      
      }
  public static void insertDataReport(String nameReport){
      
      try{
          String datereport;
          SimpleDateFormat newdate=new SimpleDateFormat("yyyy-MM-dd HH:mm");
          Date d=new Date();
          datereport=newdate.format(d);
          Connection c=ConnectDatabase.connect();
          String sqlinsert="insert into DataForm(TypeCaseReport,NameReport,DateToday) VALUES (?,?,?)";
          System.out.println("Dead:"+sqlinsert);
          PreparedStatement ps=c.prepareStatement(sqlinsert);
             ps.setString(1, "คดีชันสูตร");
           ps.setString(2, nameReport);
           ps.setString(3, datereport);
             ps.execute();
              ps.close();

      }
      catch(Exception x){
          System.out.println(""+x);
      
      }
      
      }
  public void insertRep(){
      
       if(jCheckW201.isSelected()){
            insertDataReport(jCheckW201.getText());
        }
         if(jCheckW202.isSelected()){
            insertDataReport(jCheckW202.getText());
        }
   
        if(jCheckW206.isSelected()){
             insertDataReport(jCheckW206.getText());          
           
        }
        if(jCheckW207.isSelected()){
           insertDataReport(jCheckW207.getText());   
          
        }
        if(jCheckW208.isSelected()){
           insertDataReport(jCheckW208.getText());   
//            W812.w812(no);
        }
      
      
        if(jCheckW211.isSelected()){
           insertDataReport(jCheckW211.getText()); 
        }
        if(jCheckW212.isSelected()){
         insertDataReport(jCheckW212.getText()); 
          }
        if(jCheckW213.isSelected()){
          insertDataReport(jCheckW213.getText()); 
            }
         if(jCheckW214.isSelected()){
           insertDataReport(jCheckW214.getText());
             }
                if(jCheckW215.isSelected()){
                   insertDataReport(jCheckW215.getText());
                    }
               if(jCheckW216.isSelected()){
                   insertDataReport(jCheckW216.getText());
                    }
               if(jCheckW217.isSelected()){
                    insertDataReport(jCheckW217.getText());
                    }
               if(jCheckW218.isSelected()){
                   insertDataReport(jCheckW218.getText());
                     }
               if(jCheckW219.isSelected()){
                   insertDataReport(jCheckW219.getText());
                    }
               if(jCheckW220.isSelected()){
                   insertDataReport(jCheckW220.getText());
                    }
               
               if(jCheckW221.isSelected()){
                  insertDataReport(jCheckW221.getText());
                    }
               if(jCheckW222.isSelected()){
                   insertDataReport(jCheckW221.getText());
                    }
               if(jCheckW223.isSelected()){
                  insertDataReport(jCheckW223.getText());
                    }
               if(jCheckW224.isSelected()){
                   insertDataReport(jCheckW224.getText());
                    }
               if(jCheckW225.isSelected()){
                 insertDataReport(jCheckW225.getText());
                    }
               
               if(jCheckW226.isSelected()){
                  insertDataReport(jCheckW226.getText());
                    }
               if(jCheckW227.isSelected()){
                 insertDataReport(jCheckW227.getText());
                    }
               if(jCheckW228.isSelected()){
                 insertDataReport(jCheckW228.getText());
                    }
               if(jCheckW229.isSelected()){
                  insertDataReport(jCheckW229.getText());
                    }
               if(jCheckW230.isSelected()){
                 insertDataReport(jCheckW230.getText());
                    }
               if(jCheckW231.isSelected()){
                  insertDataReport(jCheckW231.getText());
                    }
               if(jCheckW232.isSelected()){
                   insertDataReport(jCheckW232.getText());
                    }
               if(jCheckW233.isSelected()){
                     insertDataReport(jCheckW233.getText());
                    }
               if(jCheckW234.isSelected()){
                      insertDataReport(jCheckW234.getText());
                    }
               if(jCheckW235.isSelected()){
                    insertDataReport(jCheckW235.getText());
                    }
               if(jCheckW236.isSelected()){
                      insertDataReport(jCheckW236.getText());
                    }
               if(jCheckW237.isSelected()){
                      insertDataReport(jCheckW237.getText());
                    }
               if(jCheckW238.isSelected()){
                       insertDataReport(jCheckW238.getText());
                    }
               if(jCheckW239.isSelected()){
                      insertDataReport(jCheckW239.getText());
                    }
               if(jCheckW240.isSelected()){
                       insertDataReport(jCheckW240.getText());
                  }
               if(jCheckW241.isSelected()){
                       insertDataReport(jCheckW241.getText());
                    }
              if(jCheckW242.isSelected()){
                     insertDataReport(jCheckW242.getText());
                    }
              if(jCheckW243.isSelected()){
                       insertDataReport(jCheckW243.getText());
                    }
              if(jCheckW244.isSelected()){
                     insertDataReport(jCheckW244.getText());
                    }
              if(jCheckW245.isSelected()){
                     insertDataReport(jCheckW245.getText());
                    }
               if(jCheckW246.isSelected()){
                   insertDataReport(jCheckW246.getText());
                    }
               if(jCheckW247.isSelected()){
                       insertDataReport(jCheckW247.getText());
                    }
               if(jCheckW248.isSelected()){
                      insertDataReport(jCheckW248.getText());
                    }
               if(jCheckW249.isSelected()){
                     insertDataReport(jCheckW249.getText());
                    }
               if(jCheckW250.isSelected()){
                        insertDataReport(jCheckW250.getText());
                    }
               if(jCheckW251.isSelected()){
                       insertDataReport(jCheckW251.getText());
                    }
               if(jCheckW252.isSelected()){
                         insertDataReport(jCheckW252.getText());
                    }
               if(jCheckW253.isSelected()){
                       insertDataReport(jCheckW253.getText());
                    }
                if(jCheckW254.isSelected()){
                      insertDataReport(jCheckW254.getText());
                    }
                if(jCheckW255.isSelected()){
                    insertDataReport(jCheckW255.getText());
                    }
                if(jCheckW256.isSelected()){
                      insertDataReport(jCheckW256.getText());
                    }
                if(jCheckW257.isSelected()){
                     insertDataReport(jCheckW257.getText());
                    }
                if(jCheckW258.isSelected()){
                    insertDataReport(jCheckW258.getText());
                    }
                if(jCheckW259.isSelected()){
                  insertDataReport(jCheckW259.getText());
                    }
                if(jCheckW260.isSelected()){
                   insertDataReport(jCheckW260.getText());
                    }
               if(jCheckW261.isSelected()){
                   insertDataReport(jCheckW261.getText());
                    }
               if(jCheckW262.isSelected()){
                  insertDataReport(jCheckW262.getText());
                    }
               if(jCheckW263.isSelected()){
                  insertDataReport(jCheckW263.getText());
                    }
               if(jCheckW264.isSelected()){
                 insertDataReport(jCheckW264.getText());
                    }
               if(jCheckW265.isSelected()){
                 insertDataReport(jCheckW265.getText());
                    }
               if(jCheckW266.isSelected()){
                 insertDataReport(jCheckW266.getText());
                    }
//               if(jCheckW267.isSelected()){
////                        W67.w67(no);
//                    }
//     
//               if(jCheckW269.isSelected()){
//                        W69.w69(no);
//                    }
               if(jCheckW270.isSelected()){
                  insertDataReport(jCheckW270.getText());
                    }
               if(jCheckW271.isSelected()){
                   insertDataReport(jCheckW271.getText());
                    }
               if(jCheckW272.isSelected()){
                  insertDataReport(jCheckW272.getText());
                    }
               if(jCheckW273.isSelected()){
                   insertDataReport(jCheckW273.getText());
                    }
               if(jCheckW274.isSelected()){
                    insertDataReport(jCheckW274.getText());
                    }
               if(jCheckW275.isSelected()){
                     insertDataReport(jCheckW275.getText());
                    }
               if(jCheckW276.isSelected()){
                    insertDataReport(jCheckW276.getText());
                    }
               if(jCheckW277.isSelected()){
                    insertDataReport(jCheckW277.getText());
                    }
               if(jCheckW278.isSelected()){
                   insertDataReport(jCheckW278.getText());
                    }
               if(jCheckW279.isSelected()){
                    insertDataReport(jCheckW279.getText());
                    }
               if(jCheckW280.isSelected()){
                   insertDataReport(jCheckW280.getText());
                    }
               if(jCheckW293.isSelected()){
                   insertDataReport(jCheckW293.getText());
                    }
      }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ActionCrimes;
    private javax.swing.JTextArea CapitalCrimeCaseNumber;
    private javax.swing.JSpinner CaseAcceptTimee;
    private javax.swing.JSpinner CaseRequestTimee;
    private javax.swing.JLabel CaseType;
    public static javax.swing.JTextField ChargeNameCase;
    private javax.swing.JTextField CircumstancesOfDeath;
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
    public static javax.swing.JTextArea ListAsset;
    private javax.swing.JSpinner OccuredDateTime;
    private javax.swing.JSpinner OccuredDateTimeEnd;
    private javax.swing.JTextArea Prosecutor_Result;
    public static javax.swing.JTextField RecordInvestCase;
    public static javax.swing.JLabel crimecaseid;
    public static javax.swing.JTextField crimecaseno;
    private javax.swing.JTextField crimecaseyear;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAddAccused;
    private javax.swing.JButton jButtonAddAccused1;
    private javax.swing.JButton jButtonAddAccused2;
    private javax.swing.JButton jButtonAddAsset;
    private javax.swing.JButton jButtonAddInvest;
    private javax.swing.JButton jButtonCharge;
    private javax.swing.JButton jButtonDeleteAccured;
    private javax.swing.JButton jButtonDeleteAccured1;
    private javax.swing.JButton jButtonDeleteAccured2;
    private javax.swing.JButton jButtonEditAccured;
    private javax.swing.JButton jButtonEditAccured1;
    private javax.swing.JButton jButtonEditAccured2;
    private javax.swing.JButton jButtonEditCase;
    private javax.swing.JButton jButtonOpenFolder;
    private javax.swing.JButton jButtonPrintDoc2;
    private javax.swing.JButton jButtonSaveCase;
    private javax.swing.JRadioButton jCheckAccident;
    private javax.swing.JRadioButton jCheckAnimal;
    private javax.swing.JRadioButton jCheckControl;
    private javax.swing.JRadioButton jCheckDuringInvest;
    private javax.swing.JRadioButton jCheckExtraordinary;
    private javax.swing.JRadioButton jCheckKill;
    private javax.swing.JRadioButton jCheckNoInvest;
    private javax.swing.JRadioButton jCheckNotSue;
    private javax.swing.JRadioButton jCheckOtherInvest;
    private javax.swing.JRadioButton jCheckSue;
    private javax.swing.JRadioButton jCheckSuicide;
    private javax.swing.JRadioButton jCheckUnknow;
    private javax.swing.JCheckBox jCheckW201;
    private javax.swing.JCheckBox jCheckW202;
    private javax.swing.JCheckBox jCheckW204;
    private javax.swing.JCheckBox jCheckW206;
    private javax.swing.JCheckBox jCheckW207;
    private javax.swing.JCheckBox jCheckW208;
    private javax.swing.JCheckBox jCheckW211;
    private javax.swing.JCheckBox jCheckW212;
    private javax.swing.JCheckBox jCheckW213;
    private javax.swing.JCheckBox jCheckW214;
    private javax.swing.JCheckBox jCheckW215;
    private javax.swing.JCheckBox jCheckW216;
    private javax.swing.JCheckBox jCheckW217;
    private javax.swing.JCheckBox jCheckW218;
    private javax.swing.JCheckBox jCheckW219;
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
    private javax.swing.JCheckBox jCheckW260;
    private javax.swing.JCheckBox jCheckW261;
    private javax.swing.JCheckBox jCheckW262;
    private javax.swing.JCheckBox jCheckW263;
    private javax.swing.JCheckBox jCheckW264;
    private javax.swing.JCheckBox jCheckW265;
    private javax.swing.JCheckBox jCheckW266;
    private javax.swing.JCheckBox jCheckW270;
    private javax.swing.JCheckBox jCheckW271;
    private javax.swing.JCheckBox jCheckW272;
    private javax.swing.JCheckBox jCheckW273;
    private javax.swing.JCheckBox jCheckW274;
    private javax.swing.JCheckBox jCheckW275;
    private javax.swing.JCheckBox jCheckW276;
    private javax.swing.JCheckBox jCheckW277;
    private javax.swing.JCheckBox jCheckW278;
    private javax.swing.JCheckBox jCheckW279;
    private javax.swing.JCheckBox jCheckW280;
    private javax.swing.JCheckBox jCheckW293;
    private javax.swing.JComboBox<Object> jComboPoliceName;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelInvestSend;
    private javax.swing.JPanel jPanelOccuredDateEnd;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    public static javax.swing.JTable jTableAccure;
    public static javax.swing.JTable jTableSuspect;
    public static javax.swing.JTable jTableWitness;
    public static javax.swing.JTextField jTextAccused;
    private javax.swing.JTextField jTextInvestSendtoDepartment;
    public static javax.swing.JTextField jTextSuspect;
    public static javax.swing.JTextField jTextWitness;
    // End of variables declaration//GEN-END:variables
}
