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
import static com.songkhla.document.W5.Checknull;
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
import com.songkhla.document.W68;
import com.songkhla.document.W69;
import com.songkhla.document.W7;
import com.songkhla.document.W70;
import com.songkhla.document.W71;
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
import com.songkhla.document.W9;
import com.songkhla.document.W93;

import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
/**
 *
 * @author Petpilin
 */
public class SueCrimesFrom extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;
    DataCase dc =new DataCase();
    String person;
    String caseid,stSuspect,arrestDate;
    String dateF,dateTot,Court,StatusBail,RatePrison;
         String caseyear,casetype,caseno="",PoliceStaionName;

//    JDatePickerImpl SueSecDate,SueThirdDate,SueFourthDate,SueFifthDate,SueSixthDate,SueSevDate;
    /**
     * Creates new form SueCrimesFrom
     */
    public SueCrimesFrom(JFrame parrent,JSONObject datain) {
        super(parrent,true);
        initComponents();
//        DataLastSue();
        ImageIcon img = new ImageIcon("./Master/WD.png");
        setIconImage(img.getImage());
        setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES) BETA");
        ChargeName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        jLabel2.setVisible(false);
    closePrint();
    jButtonEdit.setEnabled(false);
          person=datain.get("NoPerson")+"";
            caseid=datain.get("caseIdPerson")+"";   
//            dateF=datain.get("SueFirstDate")+"";
         comboInvest();
           try{
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
          
//        String a=txtCaseNO.getText();
      try{   
          Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
           String sql= "select MAX(SueFirst,suesecond,SueThird,SueFourth,SueFifth,SueSixth,SueSeven) SueMax,"
                   + "MAX(ifnull(SueFirstEnd,0),ifnull(SueSecEnd,0),ifnull(SueThirdEnd,0),ifnull(SueFourthEnd,0),ifnull(SueFifthEnd,0),ifnull(SueSixthEnd,0),ifnull(SueSevenEnd,0)) DateEndMax,"
                   + "MAX(ifnull(SueFirstDate,0),ifnull(SueSecDate,0),ifnull(SueThirdDate,0),ifnull(SueFourthDate,0),ifnull(SueFifthDate,0),ifnull(SueSixthDate,0),ifnull(SueSevenDate,0)) DateStartMax"
                
                   + " from person where  NoPerson='"+person+"'";
            ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
          if(rs.next()){
          
           NumberImprison.setText(rs.getString("SueMax"));
           
            SueStartLast.setText(ChangFormatSQL(rs.getString("DateStartMax")));
        SueEndLast.setText(ChangFormatSQL(rs.getString("DateEndMax")));
        String a=CalculateDateExpr(ChangFormatSQL(rs.getString("DateEndMax")))+"";
           TotalDate.setText(a);
           
       
              
          }
    
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
   
//      ---------------------------------------------------Data-----------------------------------------------
        if(datain != null){
            
         try{
//              stSuspect=datain.get("StatusSuspect")+"";
//             StatusSuspect.setText(datain.get("StatusSuspect")+"");
//             Court=datain.get("CourtSuspect")+"";
           String sql;
            String sqlCase="Select caseid from crimecase where caseid='"+caseid+"'";
           Connection conc = ConnectDatabase.connect();
                Statement stmtc = conc.createStatement();
                ResultSet rsc = stmtc.executeQuery(sqlCase);
                if(rsc.next()){
                
                 sql="select CaseId,crimecasenoyear,AccureandOther,chargecase.ChargeCodeCase ChargeCase,chargecase.ChargeNameCase ChargeNameCase,crimecaseyears,crimecaseno,CaseType,Person.* from Person\n"+
                           "left join CrimeCase on Person.CaseIdPerson=CrimeCase.CaseId\n"+
                            "left join chargecase on crimecase.CaseId=chargecase.ChargeCaseId\n" +
                          " Where CaseId='"+caseid+"' and noperson='"+person+"'";
                }
                else{
                 sql="select Person.* from Person\n"+
                          " Where noperson='"+person+"'";  
                
                }
               
                    
                try{
             Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                    System.out.println(sql);
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    
                     stSuspect=rs.getString("StatusSuspect");
             StatusSuspect.setText(rs.getString("StatusSuspect"));
             Court=rs.getString("CourtSuspect");
              RatePrison=rs.getString("RatePrison");
                StatusBail=rs.getString("StatusBail");
              Block();
                     PlaceArrest.setText(Checknull(rs.getString("PlaceArrest")));
            DateArrest.setText(Checknull(rs.getString("ArrestDateTime")));
           String a=rs.getString("ArrestDateTimeEnd");
                    if(a == null || a.equals("null")|| a.equals("") )
                    { ArrestDateTimeEnd.setText("");
        //                SueFirstDate.setText("");
                 }   
                    else{
                     ArrestDateTimeEnd.setText(rs.getString("ArrestDateTimeEnd"));
                     SimpleDateFormat  format = new SimpleDateFormat("d/MM/yyyy");
                     Date aa=format.parse(a);
                     SueFirstDate.setText(format.format(aa)+"");
                     arrestDate=format.format(aa)+"";

                 }
            CourtSuspect.setText(rs.getString("CourtSuspect"));
            String firstsue=rs.getString("SueFirst");
            String sf=rs.getString("SueFirstDate");
//             System.out.println("ddddddddddddddddd:"+firstsue+":gggggggg");
//            System.out.println("ddddddddddddddddd:"+stSuspect+":gggggggg");
            if(firstsue==null){
            System.out.println("Status:LoopEE");
            }
     if(firstsue==null||firstsue.equals("null")||firstsue.equals("")||sf.equals("null")||sf==null||sf.equals(""))
            {
            System.out.println("Status:Loop");
                if(Court.equals("ศาลแขวง")&&(stSuspect.equals("ผัดฟ้องฝากขัง")||stSuspect.equals("ผัดฟ้อง"))){
                    System.out.println("Status:Loop1");
            SueFirst.setText("1");
            SueFirstDate.setText(arrestDate);
            SueFirstTotal.setText("6");
            SueFirstEnd.setText(CalculateDateEnd(SueFirstDate.getText(), SueFirstTotal.getText()));
            SueFirstRequest.setSelectedIndex(1);
            SueSecond.setText("2");
            SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
            SueSecTotal.setText("6");
            SueSecEnd.setText(CalculateDateEnd(SueSecDateT.getText(), SueSecTotal.getText()));
            SueSecRequest.setSelectedIndex(1);
            SueThird.setText("3");
            ThirdDate.setText(CalculateDateNextTimes(SueSecEnd.getText()));
            SueThirdTotal.setText("6");
            SueThirdEnd.setText(CalculateDateEnd(ThirdDate.getText(), SueThirdTotal.getText()));
            SueThirdRequest.setSelectedIndex(1);
            SueForth.setText("4");
            FourthDate.setText(CalculateDateNextTimes(SueThirdEnd.getText()));
            SueFourthTotal.setText("6");
            SueFourthEnd.setText(CalculateDateEnd(FourthDate.getText(), SueFourthTotal.getText()));
            SueFourthRequest.setSelectedIndex(1);
            SueFifth.setText("5");
            FifthDate.setText(CalculateDateNextTimes(SueFourthEnd.getText()));
            SueFifthTotal.setText("6");
            SueFifthEnd.setText(CalculateDateEnd(FifthDate.getText(), SueFifthTotal.getText()));
            SueFifthRequest.setSelectedIndex(1);
                }
                 if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&stSuspect.equals("ฝากขัง")&& RatePrison.equals("ไม่เกิน 10 ปี")){
            SueFirst.setText("1");
            SueFirstDate.setText(arrestDate);
            SueFirstTotal.setText("12");
            SueFirstEnd.setText(CalculateDateEnd(SueFirstDate.getText(), SueFirstTotal.getText()));
            SueFirstRequest.setSelectedIndex(1);
            SueSecond.setText("2");
            SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
            SueSecTotal.setText("12");
            SueSecEnd.setText(CalculateDateEnd(SueSecDateT.getText(), SueSecTotal.getText()));
            SueSecRequest.setSelectedIndex(1);
            SueThird.setText("3");
            ThirdDate.setText(CalculateDateNextTimes(SueSecEnd.getText()));
            SueThirdTotal.setText("12");
            SueThirdEnd.setText(CalculateDateEnd(ThirdDate.getText(), SueThirdTotal.getText()));
            SueThirdRequest.setSelectedIndex(1);
            SueForth.setText("4");
            FourthDate.setText(CalculateDateNextTimes(SueThirdEnd.getText()));
            SueFourthTotal.setText("12");
            SueFourthEnd.setText(CalculateDateEnd(FourthDate.getText(), SueFourthTotal.getText()));
            SueFourthRequest.setSelectedIndex(1);

                }
                    if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&stSuspect.equals("ฝากขัง")&& RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            SueFirst.setText("1");
            SueFirstDate.setText(arrestDate);
            SueFirstTotal.setText("12");
            SueFirstEnd.setText(CalculateDateEnd(SueFirstDate.getText(), SueFirstTotal.getText()));
            SueFirstRequest.setSelectedIndex(1);
            SueSecond.setText("2");
            SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
            SueSecTotal.setText("12");
            SueSecEnd.setText(CalculateDateEnd(SueSecDateT.getText(), SueSecTotal.getText()));
            SueSecRequest.setSelectedIndex(1);
            SueThird.setText("3");
            ThirdDate.setText(CalculateDateNextTimes(SueSecEnd.getText()));
            SueThirdTotal.setText("12");
            SueThirdEnd.setText(CalculateDateEnd(ThirdDate.getText(), SueThirdTotal.getText()));
            SueThirdRequest.setSelectedIndex(1);
            SueForth.setText("4");
            FourthDate.setText(CalculateDateNextTimes(SueThirdEnd.getText()));
            SueFourthTotal.setText("12");
            SueFourthEnd.setText(CalculateDateEnd(FourthDate.getText(), SueFourthTotal.getText()));
            SueFourthRequest.setSelectedIndex(1);
            SueFifth.setText("5");
            FifthDate.setText(CalculateDateNextTimes(SueFourthEnd.getText()));
            SueFifthTotal.setText("12");
            SueFifthEnd.setText(CalculateDateEnd(FifthDate.getText(), SueFifthTotal.getText()));
            SueFifthRequest.setSelectedIndex(1);
            SueSixth.setText("6");
            SixthDate.setText(CalculateDateNextTimes(SueFifthEnd.getText()));
            SueSixthTotal.setText("12");
            SueSixthEnd.setText(CalculateDateEnd(SixthDate.getText(), SueSixthTotal.getText()));
            SueSixthRequest.setSelectedIndex(1);
            SueSeventh.setText("7");
            SevDate.setText(CalculateDateNextTimes(SueSixthEnd.getText()));
            SueSevenTotal.setText("12");
            SueSevenEnd.setText(CalculateDateEnd(SevDate.getText(), SueSevenTotal.getText()));
            SueSevRequest.setSelectedIndex(1);
                }
                     if(Court.equals("ศาลเยาวชนและครอบครัว")&&(stSuspect.equals("ผัดฟ้องฝากขัง")||stSuspect.equals("ผัดฟ้อง"))){
            SueFirst.setText("1");
            SueFirstDate.setText(arrestDate);
            SueFirstTotal.setText("15");
            SueFirstEnd.setText(CalculateDateEnd(SueFirstDate.getText(), SueFirstTotal.getText()));
            SueFirstRequest.setSelectedIndex(1);
            SueSecond.setText("2");
            SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
            SueSecTotal.setText("15");
            SueSecEnd.setText(CalculateDateEnd(SueSecDateT.getText(), SueSecTotal.getText()));
            SueSecRequest.setSelectedIndex(1);
            
                }
                    
            }
             else{
//             closeText();
//                 String a=datain.get("ArrestDateTimeEnd")+"";
//            if(a == null || a.equals("null")|| a.equals("") )
//            { ArrestDateTimeEnd.setText("");
////                SueFirstDate.setText("");
//         }   
//            else{
//             ArrestDateTimeEnd.setText(datain.get("ArrestDateTimeEnd")+"");
//             SimpleDateFormat  format = new SimpleDateFormat("dd/MM/yyyy");
//             Date aa=format.parse(a);
//             SueFirstDate.setText(format.format(aa)+"");
//             arrestDate=format.format(aa)+"";
//            
//         }
        
             
                    SueFirst.setText(Checknull(rs.getString("SueFirst")));
            SueFirstDate.setText(ChangFormatSQL(Checknull(rs.getString("SueFirstDate"))));        
//            SueFirstEnd.setText(Checknull(datain.get("SueFirstEnd")));
            SueFirstEnd.setText(ChangFormatSQL(Checknull(rs.getString("SueFirstEnd"))));

          
          
            SueFirstTotal.setText(Checknull(rs.getString("SueFirstTotal")));
           SueFirstRequest.setSelectedItem(Checknull(rs.getString("SueFirstRequest")));
           SueFirstCause.setSelectedItem(Checknull(rs.getString("SueFirstCause")));
            SueSecond.setText(Checknull(rs.getString("SueSecond")));
            SueSecDateT.setText(ChangFormatSQL(Checknull(rs.getString("SueSecDate"))));        
            SueSecEnd.setText(ChangFormatSQL(Checknull(rs.getString("SueSecEnd"))));
            SueSecTotal.setText(Checknull(rs.getString("SueSecTotal")));
           SueSecRequest.setSelectedItem(Checknull(rs.getString("SueSecRequest")));
           SueSecCause.setSelectedItem(Checknull(rs.getString("SueSecCause")));
             SueThird.setText(Checknull(rs.getString("SueThird")));
            ThirdDate.setText(ChangFormatSQL(Checknull(rs.getString("SueThirdDate"))));        
            SueThirdEnd.setText(ChangFormatSQL(Checknull(rs.getString("SueThirdEnd"))));
            SueThirdTotal.setText(Checknull(rs.getString("SueThirdTotal")));
           SueThirdRequest.setSelectedItem(Checknull(rs.getString("SueThirdRequest")));
           SueThirdCause.setSelectedItem(Checknull(rs.getString("SueThirdCause")));
             SueForth.setText(Checknull(rs.getString("SueFourth")));
            FourthDate.setText(ChangFormatSQL(Checknull(rs.getString("SueFourthDate"))));        
            SueFourthEnd.setText(ChangFormatSQL(Checknull(rs.getString("SueFourthEnd"))));
            SueFourthTotal.setText(Checknull(rs.getString("SueFourthtotal")));
           SueFourthRequest.setSelectedItem(Checknull(rs.getString("SueFourthRequest")));
           SueFourthCause.setSelectedItem(Checknull(rs.getString("SueFourthCause")));
             SueFifth.setText(Checknull(rs.getString("SueFifth")));
            FifthDate.setText(ChangFormatSQL(Checknull(rs.getString("SueFifthDate"))));        
            SueFifthEnd.setText(ChangFormatSQL(Checknull(rs.getString("SueFifthEnd"))));
            SueFifthTotal.setText(Checknull(rs.getString("SueFifthTotal")));
           SueFifthRequest.setSelectedItem(Checknull(rs.getString("SueFifthRequest")));
           SueFifthCause.setSelectedItem(Checknull(rs.getString("SueFifthCause")));
              SueSixth.setText(Checknull(rs.getString("SueSixth")));
            SixthDate.setText(ChangFormatSQL(Checknull(rs.getString("SueSixthDate"))));        
            SueSixthEnd.setText(ChangFormatSQL(Checknull(rs.getString("SueSixthEnd"))));
            SueSixthTotal.setText(Checknull(rs.getString("SueSixthTotal")));
           SueSixthRequest.setSelectedItem(Checknull(rs.getString("SueSixthRequest")));
           SueSixthCause.setSelectedItem(Checknull(rs.getString("SueSixthCause")));       
               SueSeventh.setText(Checknull(rs.getString("SueSeven")));
            SevDate.setText(ChangFormatSQL(Checknull(rs.getString("SueSevenDate"))));        
            SueSevenEnd.setText(ChangFormatSQL(Checknull(rs.getString("SueSevenEnd"))));
            SueSevenTotal.setText(Checknull(rs.getString("SueSevenTotal")));
           SueSevRequest.setSelectedItem(Checknull(rs.getString("SueSevenRequest")));
           SueSevCause.setSelectedItem(Checknull(rs.getString("SueSevenCause")));        
                        
                     
             }     
                PeopleRegistrationID.setText(rs.getString("PeopleRegistrationID")+"");  
                FullNamePerson.setText(rs.getString("FullNamePerson")+"");
                 AccureandOther.setText(Checknull(rs.getString("AccureandOther"))+"");
             crimecaseno.setText(Checknull(rs.getString("crimecasenoyear")));
              ChargeName.setText(Checknull(rs.getString("ChargeNameCase")));
                 caseyear=rs.getString("crimecaseyears");
                caseno=rs.getString("crimecaseno");
                casetype=rs.getString("CaseType");
//            SueFirst.setText(datain.get("SueFirst")+"");
//            SueFirstDate.setText(datain.get("SueFirstDate")+"");   
                }

                }catch(Exception ex)
                {}               
//                  caseyear=datain.get("crimecaseyears")+"";
//                caseno=datain.get("crimecaseno")+"";
//                casetype=datain.get("CaseType")+"";
           

//            AccureandOther.setText(datain.get("AccureandOther")+"");

//            ChargeName.setText(datain.get("ChargeName")+"");
//            SueFirst.setText(datain.get("SueFirst")+"");
//            SueFirstDate.setText(datain.get("SueFirstDate")+"");   
           
         }  catch(Exception e)
         {e.printStackTrace();}
        }
    
         
     
       DateTotal();
//       RefreshData(); 
//SueFirstTotal.addKeyListener(new TextFieldTotalListener());
   
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FullNamePerson = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AccureandOther = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ChargeName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        PlaceArrest = new javax.swing.JTextField();
        DateArrest = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ArrestDateTimeEnd = new javax.swing.JTextField();
        CourtSuspect1 = new javax.swing.JLabel();
        PeopleRegistrationID = new javax.swing.JTextField();
        CourtSuspect = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        StatusSuspect = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        NumberImprison = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SueEndLast = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TotalDate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        SueStartLast = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        SueFirstDate = new javax.swing.JTextField();
        SueFirstTotal = new javax.swing.JTextField();
        SueFirstRequest = new javax.swing.JComboBox<>();
        SueFirstCause = new javax.swing.JComboBox<>();
        SueSeventh = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        SueSecTotal = new javax.swing.JTextField();
        SueSecRequest = new javax.swing.JComboBox<>();
        SueSecCause = new javax.swing.JComboBox<>();
        SueThirdTotal = new javax.swing.JTextField();
        SueThirdRequest = new javax.swing.JComboBox<>();
        SueSevCause = new javax.swing.JComboBox<>();
        SueSevenTotal = new javax.swing.JTextField();
        SueSevRequest = new javax.swing.JComboBox<>();
        SueFourthTotal = new javax.swing.JTextField();
        SueFifthTotal = new javax.swing.JTextField();
        SueSixthTotal = new javax.swing.JTextField();
        SueFourthRequest = new javax.swing.JComboBox<>();
        SueFifthRequest = new javax.swing.JComboBox<>();
        SueSixthRequest = new javax.swing.JComboBox<>();
        SueThirdCause = new javax.swing.JComboBox<>();
        SueFourthCause = new javax.swing.JComboBox<>();
        SueFifthCause = new javax.swing.JComboBox<>();
        SueSixthCause = new javax.swing.JComboBox<>();
        SevDate = new javax.swing.JTextField();
        SixthDate = new javax.swing.JTextField();
        FifthDate = new javax.swing.JTextField();
        FourthDate = new javax.swing.JTextField();
        ThirdDate = new javax.swing.JTextField();
        SueSecDateT = new javax.swing.JTextField();
        Print1 = new javax.swing.JButton();
        Print3 = new javax.swing.JButton();
        Print4 = new javax.swing.JButton();
        Print5 = new javax.swing.JButton();
        Print6 = new javax.swing.JButton();
        Print7 = new javax.swing.JButton();
        Print2 = new javax.swing.JButton();
        SueSecond = new javax.swing.JTextField();
        SueThird = new javax.swing.JTextField();
        SueForth = new javax.swing.JTextField();
        SueFifth = new javax.swing.JTextField();
        SueSixth = new javax.swing.JTextField();
        SueSixthEnd = new javax.swing.JTextField();
        SueFifthEnd = new javax.swing.JTextField();
        SueSecEnd = new javax.swing.JTextField();
        SueThirdEnd = new javax.swing.JTextField();
        SueFourthEnd = new javax.swing.JTextField();
        SueSevenEnd = new javax.swing.JTextField();
        SueFirstEnd = new javax.swing.JTextField();
        SueFirst = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 720));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ผัดฟ้องฝากขัง");

        jButton4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("./Master/home.png"));
        jButton4.setText("เมนูหลัก");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addComponent(jButton4))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        jLabel24.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("ข้อมูลคดี");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(185, 185, 185))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel30.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("เลขคดีที่ ");

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        crimecaseno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        crimecaseno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        crimecaseno.setEnabled(false);

        jLabel31.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("เลขประจำตัวบัตรประชาชน");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อผู้ต้องหา");

        FullNamePerson.setEditable(false);
        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อผู้กล่าวหา");

        AccureandOther.setEditable(false);
        AccureandOther.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("ข้อหา");

        ChargeName.setEditable(false);
        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("สถานที่ควบคุม");

        PlaceArrest.setEditable(false);
        PlaceArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        DateArrest.setEditable(false);
        DateArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("วันที่จับกุม");

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("วันที่สิ้นสุดการควบคุม");

        ArrestDateTimeEnd.setEditable(false);
        ArrestDateTimeEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        CourtSuspect1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtSuspect1.setText("อำนาจศาล");

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        PeopleRegistrationID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PeopleRegistrationID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PeopleRegistrationID.setEnabled(false);

        CourtSuspect.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CourtSuspect.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CourtSuspect.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CourtSuspect.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel30))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(54, 54, 54)
                                .addComponent(AccureandOther, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CourtSuspect1)
                                .addGap(18, 18, 18)
                                .addComponent(CourtSuspect))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateArrest)
                            .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ArrestDateTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourtSuspect1)
                    .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CourtSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(AccureandOther, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(ArrestDateTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel7.setBackground(new java.awt.Color(0, 102, 204));
        jPanel7.setForeground(new java.awt.Color(102, 0, 0));

        jLabel25.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("ข้อมูลการ");

        StatusSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        StatusSuspect.setForeground(new java.awt.Color(255, 255, 255));
        StatusSuspect.setText("jLabel19");

        jLabel26.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("(ล่าสุด)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StatusSuspect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusSuspect)
                    .addComponent(jLabel26))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        NumberImprison.setEditable(false);
        NumberImprison.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("ครั้งที่");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("วันที่เริ่ม");

        SueEndLast.setEditable(false);
        SueEndLast.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("ระยะเวลาคงเหลือ");

        TotalDate.setEditable(false);
        TotalDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        TotalDate.setForeground(new java.awt.Color(255, 0, 0));

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("วัน");

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("วันที่สิ้นสุด");

        SueStartLast.setEditable(false);
        SueStartLast.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueStartLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueStartLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SueStartLast)
                    .addComponent(NumberImprison, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SueEndLast, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberImprison, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(TotalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(SueStartLast, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueEndLast, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(102, 102, 102))
        );

        jPanel5.setEnabled(false);

        SueFirstDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueFirstTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueFirstTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SueFirstTotalKeyReleased(evt);
            }
        });

        SueFirstRequest.setEditable(true);
        SueFirstRequest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueFirstRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueFirstCause.setEditable(true);
        SueFirstCause.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueFirstCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueSeventh.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSeventh.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel8.setBackground(new java.awt.Color(0, 102, 204));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ครั้งที่");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("วันผัดฟ้อง/ฝากขัง");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("รวมวัน");

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("วันสิ้นสุด");

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ผู้ร้อง");

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("เหตุผัดฟ้องฝากขัง");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addGap(86, 86, 86)
                .addComponent(jLabel8)
                .addGap(82, 82, 82)
                .addComponent(jLabel9)
                .addGap(181, 181, 181)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(219, 219, 219))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)))
        );

        SueSecTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSecTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SueSecTotalKeyReleased(evt);
            }
        });

        SueSecRequest.setEditable(true);
        SueSecRequest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSecRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueSecCause.setEditable(true);
        SueSecCause.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueSecCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueThirdTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueThirdTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SueThirdTotalKeyReleased(evt);
            }
        });

        SueThirdRequest.setEditable(true);
        SueThirdRequest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueThirdRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueSevCause.setEditable(true);
        SueSevCause.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueSevCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueSevenTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSevenTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SueSevenTotalKeyReleased(evt);
            }
        });

        SueSevRequest.setEditable(true);
        SueSevRequest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSevRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueFourthTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueFourthTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SueFourthTotalKeyReleased(evt);
            }
        });

        SueFifthTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueFifthTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SueFifthTotalKeyReleased(evt);
            }
        });

        SueSixthTotal.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSixthTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SueSixthTotalKeyReleased(evt);
            }
        });

        SueFourthRequest.setEditable(true);
        SueFourthRequest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueFourthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueFifthRequest.setEditable(true);
        SueFifthRequest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueFifthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueSixthRequest.setEditable(true);
        SueSixthRequest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSixthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueThirdCause.setEditable(true);
        SueThirdCause.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueThirdCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueFourthCause.setEditable(true);
        SueFourthCause.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueFourthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueFifthCause.setEditable(true);
        SueFifthCause.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueFifthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueSixthCause.setEditable(true);
        SueSixthCause.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueSixthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SevDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SixthDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        FifthDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        FourthDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        ThirdDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueSecDateT.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Print1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Print1.setText("พิมพ์");
        Print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print1ActionPerformed(evt);
            }
        });

        Print3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Print3.setText("พิมพ์");
        Print3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print3ActionPerformed(evt);
            }
        });

        Print4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Print4.setText("พิมพ์");
        Print4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print4ActionPerformed(evt);
            }
        });

        Print5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Print5.setText("พิมพ์");
        Print5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print5ActionPerformed(evt);
            }
        });

        Print6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Print6.setText("พิมพ์");
        Print6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print6ActionPerformed(evt);
            }
        });

        Print7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Print7.setText("พิมพ์");
        Print7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print7ActionPerformed(evt);
            }
        });

        Print2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Print2.setText("พิมพ์");
        Print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print2ActionPerformed(evt);
            }
        });

        SueSecond.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSecond.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        SueThird.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueThird.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        SueForth.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueForth.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        SueFifth.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueFifth.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        SueSixth.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        SueSixth.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        SueSixthEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueFifthEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueSecEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueThirdEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueFourthEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueSevenEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueFirstEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        SueFirst.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SueFirst.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SueFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SueFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(SueSecDateT, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueFifth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(FifthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueSixth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(SixthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(SueSeventh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SevDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueForth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(FourthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueThird, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(ThirdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SueFirstTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueSecTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueFifthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueSevenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueFourthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueThirdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueSixthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SueFirstEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueSecEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueFifthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueSixthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueSevenEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueFourthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SueThirdEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(SueSecRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(SueFifthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(SueSixthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(SueSevRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(SueThirdRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueFourthRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueFirstRequest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SueSecCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueSevCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueThirdCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueFifthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueFourthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SueSixthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SueFirstCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Print1)
                    .addComponent(Print2)
                    .addComponent(Print3)
                    .addComponent(Print4)
                    .addComponent(Print5)
                    .addComponent(Print7)
                    .addComponent(Print6))
                .addGap(15, 15, 15))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SueFirstDate, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(SueFirst))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SueSecDateT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(SueSecRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ThirdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueThird, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueThirdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueThirdEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(SueThirdRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FourthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueForth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueFourthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueFourthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueFourthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueFifth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FifthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SueFifthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SueFifthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SueFifthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SueFifthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Print5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueSixth, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SixthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SueSixthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SueSixthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SueSixthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SueSixthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Print6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SevDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueSeventh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueSevenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueSevenEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SueSevRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueSevCause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Print7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SueFirstEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueFirstRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueFirstCause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(SueSecEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(SueFirstTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(SueSecTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(SueSecCause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SueThirdCause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SueFourthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Print1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Print2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        jButtonSave.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonSave.setText("บันทึก");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("แก้ไข");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonEdit.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonEdit.setText("แก้ไข");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        con=ConnectDatabase.connect();
        String a=SueFirstDate.getText();
        String c=null;

        String sqlUpdate="Update Person set "
        + "SueFirst=?,"
        + "SueFirstDate=?,"
        + "SueFirstEnd=?,\n"
        + "SueFirstTotal=?,"
        + "SueFirstRequest=?,"
        + "SueFirstCause=?,"
        + "SueSecond=?,"
        + "SueSecDate=?,\n"
        +  "SueSecEnd=?,"
        + "SueSecTotal=?,"
        + "SueSecRequest=?,"
        + "SueSecCause=?,"
        + "SueThird=?,"
        + "SueThirdDate=?,"
        + "SueThirdEnd=?,"
        + "SueThirdTotal=?,\n"
        + "SueThirdRequest=?,"
        + "SueThirdCause=?,"
        + "SueFourth=?,"
        + "SueFourthDate=?,"
        + "SueFourthEnd=?,"
        + "SueFourthtotal=?,"
        + "SueFourthRequest=?,\n"
        + "SueFourthCause=?,\n"
        + "SueFifth=?,"
        + "SueFifthDate=?,"
        + "SueFifthEnd=?,"
        + "SueFifthTotal=?,"
        + "SueFifthRequest=?,\n"
        + "SueFifthCause=?,\n"
        + "SueSixth=?,"
        + "SueSixthDate=?,"
        + "SueSixthEnd=?,"
        + "SueSixthTotal=?,"
        + "SueSixthRequest=?,\n"
        + "SueSixthCause=?,\n"
        + "SueSeven=?,"
        + "SueSevenDate=?,"
        + "SueSevenEnd=?,"
        + "SueSevenTotal=?,"
        + "SueSevenRequest=?,\n"
        + "SueSevenCause=?\n"
        + "where NoPerson=? and CaseIdPerson=?   ";

        try {
            pst=con.prepareStatement(sqlUpdate);
            pst.setString(1,SueFirst.getText());
            pst.setString(2,ChangFormat(SueFirstDate.getText()));
            pst.setString(3,ChangFormat(SueFirstEnd.getText()));
            pst.setString(4,SueFirstTotal.getText());
            pst.setString(5,SueFirstRequest.getSelectedItem().toString());
            pst.setString(6,SueFirstCause.getSelectedItem().toString());
            pst.setString(7,SueSecond.getText());
            pst.setString(8,ChangFormat(SueSecDateT.getText()));
            pst.setString(9,ChangFormat(SueSecEnd.getText()));
            pst.setString(10,SueSecTotal.getText());
            pst.setString(11,SueSecRequest.getSelectedItem().toString());
            pst.setString(12,SueSecCause.getSelectedItem().toString());
            pst.setString(13,SueThird.getText());
            pst.setString(14,ChangFormat(ThirdDate.getText()));
            pst.setString(15,ChangFormat(SueThirdEnd.getText()));
            pst.setString(16,SueThirdTotal.getText());
            pst.setString(17,SueThirdRequest.getSelectedItem().toString());
            pst.setString(18,SueThirdCause.getSelectedItem().toString());
            pst.setString(19,SueForth.getText());
            pst.setString(20,ChangFormat(FourthDate.getText()));
            pst.setString(21,ChangFormat(SueFourthEnd.getText()));
            pst.setString(22,SueFourthTotal.getText());
            pst.setString(23,SueFourthRequest.getSelectedItem().toString());
            pst.setString(24,SueFourthCause.getSelectedItem().toString());
            pst.setString(25,SueFifth.getText());
            pst.setString(26,ChangFormat(FifthDate.getText()));
            pst.setString(27,ChangFormat(SueFifthEnd.getText()));
            pst.setString(28,SueFifthTotal.getText());
            pst.setString(29,SueFifthRequest.getSelectedItem().toString());
            pst.setString(30,SueFifthCause.getSelectedItem().toString());
            pst.setString(31,SueSixth.getText());
            pst.setString(32,ChangFormat(SixthDate.getText()));
            pst.setString(33,ChangFormat(SueSixthEnd.getText()));
            pst.setString(34,SueSixthTotal.getText());
            pst.setString(35,SueSixthRequest.getSelectedItem().toString());
            pst.setString(36,SueSixthCause.getSelectedItem().toString());
            pst.setString(37,SueSeventh.getText());
            pst.setString(38,ChangFormat(SevDate.getText()));
            pst.setString(39,ChangFormat(SueSevenEnd.getText()));
            pst.setString(40,SueSevenTotal.getText());
            pst.setString(41,SueSevRequest.getSelectedItem().toString());
            pst.setString(42,SueSevCause.getSelectedItem().toString());
            pst.setString(43,person);
            pst.setString(44,caseid);

            int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                pst.executeUpdate();
                pst.close();
                closeText();
                openPrint();
                jButtonEdit.setEnabled(true);
                System.out.println("SQL : "+sqlUpdate);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("SQL : "+pst);
        }

        //        setVisible(false);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void Print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print2ActionPerformed
        // TODO add your handling code here:
        if(SueSecond.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูลให้ครบถ้วน", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            yourAttemptActionPerformed2();
//  W68.w68(caseid,SueSecond.getText());
        }
    }//GEN-LAST:event_Print2ActionPerformed

    private void Print7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print7ActionPerformed
        // TODO add your handling code here:
        if(SueSeventh.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูลให้ครบถ้วน", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            yourAttemptActionPerformed7();
        }
    }//GEN-LAST:event_Print7ActionPerformed

    private void Print6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print6ActionPerformed
        // TODO add your handling code here:
        if(SueSixth.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูลให้ครบถ้วน", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            yourAttemptActionPerformed6();
        }
    }//GEN-LAST:event_Print6ActionPerformed

    private void Print5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print5ActionPerformed
        // TODO add your handling code here:
        if(SueFifth.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูลให้ครบถ้วน", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            yourAttemptActionPerformed5();
        }
    }//GEN-LAST:event_Print5ActionPerformed

    private void Print4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print4ActionPerformed
        // TODO add your handling code here:
        if(SueForth.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูลให้ครบถ้วน", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            yourAttemptActionPerformed4();
        }
    }//GEN-LAST:event_Print4ActionPerformed

    private void Print3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print3ActionPerformed
        // TODO add your handling code here:
        if(SueThird.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูล", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            yourAttemptActionPerformed3();
        }
    }//GEN-LAST:event_Print3ActionPerformed

    private void Print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print1ActionPerformed
        // TODO add your handling code here:
        if(caseno.equals("")||caseno==null){
        JOptionPane.showMessageDialog(jPanel1,"กรุณาบันทึกข้อมูลคดี","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
        }
       else if(SueFirst.getText().equals("")){
            JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูล","แจ้งเตือน" , JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            yourAttemptActionPerformed();
        }
    }//GEN-LAST:event_Print1ActionPerformed

    private void SueSixthTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SueSixthTotalKeyReleased
        // TODO add your handling code here:
        String text = SueSixthTotal.getText();
        int totaldate = Integer.parseInt(text);
        if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSixthTotal.setText("");
            }
        }
        if(Court.equals("ศาลแขวง")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSixthTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSixthTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
                SueSixthTotal.setText("");
            }
        }
    }//GEN-LAST:event_SueSixthTotalKeyReleased

    private void SueFifthTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SueFifthTotalKeyReleased
        // TODO add your handling code here:
        String text = SueFifthTotal.getText();
        int totaldate = Integer.parseInt(text);
        if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFifthTotal.setText("");
            }
        }
        if(Court.equals("ศาลแขวง")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFifthTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFifthTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
                SueFifthTotal.setText("");
            }
        }
    }//GEN-LAST:event_SueFifthTotalKeyReleased

    private void SueFourthTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SueFourthTotalKeyReleased
        // TODO add your handling code here:
        String text = SueFourthTotal.getText();
        int totaldate = Integer.parseInt(text);
        if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFourthTotal.setText("");
            }
        }
        if(Court.equals("ศาลแขวง")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFourthTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFourthTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
                SueFourthTotal.setText("");
            }
        }
    }//GEN-LAST:event_SueFourthTotalKeyReleased

    private void SueSevenTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SueSevenTotalKeyReleased
        // TODO add your handling code here:
        String text = SueSevenTotal.getText();
        int totaldate = Integer.parseInt(text);
        if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSevenTotal.setText("");
            }
        }
        if(Court.equals("ศาลแขวง")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSevenTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSevenTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
                SueSevenTotal.setText("");
            }
        }
    }//GEN-LAST:event_SueSevenTotalKeyReleased

    private void SueThirdTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SueThirdTotalKeyReleased
        // TODO add your handling code here:
        String text = SueThirdTotal.getText();
        int totaldate = Integer.parseInt(text);
        if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueThirdTotal.setText("");
            }
        }
        if(Court.equals("ศาลแขวง")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueThirdTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueThirdTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
                SueThirdTotal.setText("");
            }
        }
    }//GEN-LAST:event_SueThirdTotalKeyReleased

    private void SueSecTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SueSecTotalKeyReleased
        // TODO add your handling code here:

        String text = SueSecTotal.getText();
        int totaldate = Integer.parseInt(text);
        if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSecTotal.setText("");
            }
        }
        if(Court.equals("ศาลแขวง")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSecTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueSecTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
                SueSecTotal.setText("");
            }
        }
    }//GEN-LAST:event_SueSecTotalKeyReleased
public void closePrint(){
Print1.setEnabled(false);
Print2.setEnabled(false);
Print3.setEnabled(false);
Print4.setEnabled(false);
Print5.setEnabled(false);
Print6.setEnabled(false);
Print7.setEnabled(false);


}
public void openPrint(){
Print1.setEnabled(true);
Print2.setEnabled(true);
Print3.setEnabled(true);
Print4.setEnabled(true);
Print5.setEnabled(true);
Print6.setEnabled(true);
Print7.setEnabled(true);
}
public void closeText(){
SueFirst.setEnabled(false);
SueFirstDate.setEnabled(false);
SueFirstTotal.setEnabled(false);
SueFirstEnd.setEnabled(false);
SueFirstRequest.setEnabled(false);
SueFirstCause.setEnabled(false);
 SueSecond.setEnabled(false);
            SueSecDateT.setEnabled(false);      
            SueSecEnd.setEnabled(false);
            SueSecTotal.setEnabled(false);
           SueSecRequest.setEnabled(false);
           SueSecCause.setEnabled(false);
             SueThird.setEnabled(false);
            ThirdDate.setEnabled(false);        
            SueThirdEnd.setEnabled(false);
            SueThirdTotal.setEnabled(false);
           SueThirdRequest.setEnabled(false);
           SueThirdCause.setEnabled(false);
             SueForth.setEnabled(false);
            FourthDate.setEnabled(false);        
            SueFourthEnd.setEnabled(false);
            SueFourthTotal.setEnabled(false);
           SueFourthRequest.setEnabled(false);
           SueFourthCause.setEnabled(false);
             SueFifth.setEnabled(false);
            FifthDate.setEnabled(false);      
            SueFifthEnd.setEnabled(false);
            SueFifthTotal.setEnabled(false);
           SueFifthRequest.setEnabled(false);
           SueFifthCause.setEnabled(false);
              SueSixth.setEnabled(false);
            SixthDate.setEnabled(false);       
            SueSixthEnd.setEnabled(false);
            SueSixthTotal.setEnabled(false);
           SueSixthRequest.setEnabled(false);
           SueSixthCause.setEnabled(false);       
               SueSeventh.setEnabled(false);
            SevDate.setEnabled(false);  
            SueSevenEnd.setEnabled(false);
            SueSevenTotal.setEnabled(false);
           SueSevRequest.setEnabled(false);
           SueSevCause.setEnabled(false);  

}
public void openText(){
SueFirst.setEnabled(true);
SueFirstDate.setEnabled(true);
SueFirstTotal.setEnabled(true);
SueFirstEnd.setEnabled(true);
SueFirstRequest.setEnabled(true);
SueFirstCause.setEnabled(true);
 SueSecond.setEnabled(true);
            SueSecDateT.setEnabled(true);      
            SueSecEnd.setEnabled(true);
            SueSecTotal.setEnabled(true);
           SueSecRequest.setEnabled(true);
           SueSecCause.setEnabled(true);
             SueThird.setEnabled(true);
            ThirdDate.setEnabled(true);        
            SueThirdEnd.setEnabled(true);
            SueThirdTotal.setEnabled(true);
           SueThirdRequest.setEnabled(true);
           SueThirdCause.setEnabled(true);
             SueForth.setEnabled(true);
            FourthDate.setEnabled(true);        
            SueFourthEnd.setEnabled(true);
            SueFourthTotal.setEnabled(true);
           SueFourthRequest.setEnabled(true);
           SueFourthCause.setEnabled(true);
             SueFifth.setEnabled(true);
            FifthDate.setEnabled(true);      
            SueFifthEnd.setEnabled(true);
            SueFifthTotal.setEnabled(true);
           SueFifthRequest.setEnabled(true);
           SueFifthCause.setEnabled(true);
              SueSixth.setEnabled(true);
            SixthDate.setEnabled(true);       
            SueSixthEnd.setEnabled(true);
            SueSixthTotal.setEnabled(true);
           SueSixthRequest.setEnabled(true);
           SueSixthCause.setEnabled(true);       
               SueSeventh.setEnabled(true);
            SevDate.setEnabled(true);  
            SueSevenEnd.setEnabled(true);
            SueSevenTotal.setEnabled(true);
           SueSevRequest.setEnabled(true);
           SueSevCause.setEnabled(true);  

}
    private void SueFirstTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SueFirstTotalKeyReleased
        // TODO add your handling code here:

        String text = SueFirstTotal.getText();
        int totaldate = Integer.parseInt(text);
        if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFirstTotal.setText("");
            }
        }
        if(Court.equals("ศาลแขวง")){
            if(totaldate>6){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFirstTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
                SueFirstTotal.setText("");
            }
        }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){
            if(totaldate>12){
                JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
                SueFirstTotal.setText("");
            }
        }
    }//GEN-LAST:event_SueFirstTotalKeyReleased

    private void SueStartLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueStartLastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueStartLastActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        MainMenuWord.closeAllDialogs();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        openText();
        closePrint();
    }//GEN-LAST:event_jButtonEditActionPerformed
       public void Block(){
       if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน"))
       {
       SueSeventh.setEnabled(false);
       SevDate.setEnabled(false);
       SueSevenEnd.setEnabled(false);
       SueSevenTotal.setEnabled(false);
       SueSevRequest.setEnabled(false);
       SueSevCause.setEnabled(false);
       Print7.setEnabled(false);
        SueSixth.setEnabled(false);
       SixthDate.setEnabled(false);
       SueSixthEnd.setEnabled(false);
       SueSixthTotal.setEnabled(false);
       SueSixthRequest.setEnabled(false);
       SueSixthCause.setEnabled(false);
       Print6.setEnabled(false);
       }
        if(Court.equals("ศาลแขวง"))
       {
       SueSeventh.setEnabled(false);
       SevDate.setEnabled(false);
       SueSevenEnd.setEnabled(false);
       SueSevenTotal.setEnabled(false);
       SueSevRequest.setEnabled(false);
       SueSevCause.setEnabled(false);
       Print7.setEnabled(false);
        SueSixth.setEnabled(false);
       SixthDate.setEnabled(false);
       SueSixthEnd.setEnabled(false);
       SueSixthTotal.setEnabled(false);
       SueSixthRequest.setEnabled(false);
       SueSixthCause.setEnabled(false);
       Print6.setEnabled(false);
       }
        if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี"))
       {
       SueSeventh.setEnabled(false);
       SevDate.setEnabled(false);
       SueSevenEnd.setEnabled(false);
       SueSevenTotal.setEnabled(false);
       SueSevRequest.setEnabled(false);
       SueSevCause.setEnabled(false);
       Print7.setEnabled(false);
       SueSixth.setEnabled(false);
       SixthDate.setEnabled(false);
       SueSixthEnd.setEnabled(false);
       SueSixthTotal.setEnabled(false);
       SueSixthRequest.setEnabled(false);
       SueSixthCause.setEnabled(false);
       Print6.setEnabled(false);
          SueFifth.setEnabled(false);
       FifthDate.setEnabled(false);
       SueFifthEnd.setEnabled(false);
       SueFifthTotal.setEnabled(false);
       SueFifthRequest.setEnabled(false);
       SueFifthCause.setEnabled(false);
       Print5.setEnabled(false);
       }
        if(Court.equals("ศาลเยาวชนและครอบครัว"))
       {
       SueSeventh.setEnabled(false);
       SevDate.setEnabled(false);
       SueSevenEnd.setEnabled(false);
       SueSevenTotal.setEnabled(false);
       SueSevRequest.setEnabled(false);
       SueSevCause.setEnabled(false);
       Print7.setEnabled(false);
       SueSixth.setEnabled(false);
       SixthDate.setEnabled(false);
       SueSixthEnd.setEnabled(false);
       SueSixthTotal.setEnabled(false);
       SueSixthRequest.setEnabled(false);
       SueSixthCause.setEnabled(false);
       Print6.setEnabled(false);
          SueFifth.setEnabled(false);
       FifthDate.setEnabled(false);
       SueFifthEnd.setEnabled(false);
       SueFifthTotal.setEnabled(false);
       SueFifthRequest.setEnabled(false);
       SueFifthCause.setEnabled(false);
       Print5.setEnabled(false);
       SueForth.setEnabled(false);
       FourthDate.setEnabled(false);
       SueFourthTotal.setEnabled(false);
       SueFourthEnd.setEnabled(false);
       SueFourthRequest.setEnabled(false);
       SueFourthCause.setEnabled(false);
       Print4.setEnabled(false);
       SueThird.setEnabled(false);
       ThirdDate.setEnabled(false);
       SueThirdTotal.setEnabled(false);
       SueThirdEnd.setEnabled(false);
       SueThirdRequest.setEnabled(false);
       SueThirdCause.setEnabled(false);
       Print3.setEnabled(false);
       }
 
//   try{
//     Connection con = ConnectDatabase.connect();
//        Statement stmt = con.createStatement();
////        String a=txtCaseNO.getText();
//        String sql;
//                sql= "select SueTimes,SueDate,SueStart,SueEnd,SueTotal,\n"+ 
//                    "SueCause,SueRequest from Sue Where SuePersonId='"+person+"' and SueCaseId='"+caseid+"'";
//            ResultSet rs = stmt.executeQuery(sql);}
//   catch(Exception e){}
       
   }
   public void CheckDateTotal(String DateTotal){
   
       int totaldate=Integer.parseInt(DateTotal);
       if(Court.equals("ศาลแขวง")&&StatusBail.equals("ประกัน")){      
           if(totaldate>6){ 
                  
            JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 6 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE);
            
           }      
       }
          if(Court.equals("ศาลแขวง")){      
           if(totaldate>6){  
                     
            JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 6 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE); 
            
           }      
       }
            if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ตั้งแต่ 10 ปีขึ้นไป")){      
           if(totaldate>12){
            JOptionPane.showMessageDialog(jPanel1, "ไม่เกิน 12 วัน","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE); 
           }      
       }
           if(Court.equals("ศาลอาญา/ศาลจังหวัด")&&RatePrison.equals("ไม่เกิน 10 ปี")){      
           if(totaldate>12){
            JOptionPane.showMessageDialog(jPanel1,"ไม่เกิน 12 วัน","แจ้งเตือน",  JOptionPane.INFORMATION_MESSAGE); 
           }      
       }
     
//       return totalDate;
   }

    
    public void DateTotal(){
     SueFirstTotal.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                         
                                SueFirstEnd.setText(CalculateDateEnd(SueFirstDate.getText(), SueFirstTotal.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {    
                         
//                                SueFirstEnd.setText(CalculateDateEnd(SueFirstDate.getText(), SueFirstTotal.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                        
                                SueFirstEnd.setText(CalculateDateEnd(SueFirstDate.getText(), SueFirstTotal.getText()));

                           }
             }
             );
       SueFirstEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));

                           }
             }
             );
                
              SueSecTotal.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueSecEnd.setText(CalculateDateEnd(SueSecDateT.getText(), SueSecTotal.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueSecEnd.setText(CalculateDateEnd(SueSecDateT.getText(), SueSecTotal.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueSecEnd.setText(CalculateDateEnd(SueSecDateT.getText(), SueSecTotal.getText()));
                           }
             }
             );
            SueSecEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                 ThirdDate.setText(CalculateDateNextTimes(SueSecEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                  ThirdDate.setText(CalculateDateNextTimes(SueSecEnd.getText()));

                           }
             }
             );
    SueThirdTotal.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueThirdEnd.setText(CalculateDateEnd(ThirdDate.getText(), SueThirdTotal.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueThirdEnd.setText(CalculateDateEnd(ThirdDate.getText(), SueThirdTotal.getText()));

                           }
             }
             );
      SueThirdEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                 FourthDate.setText(CalculateDateNextTimes(SueThirdEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                  FourthDate.setText(CalculateDateNextTimes(SueThirdEnd.getText()));

                           }
             }
             );
       SueFourthTotal.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueFourthEnd.setText(CalculateDateEnd(FourthDate.getText(), SueFourthTotal.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueFourthEnd.setText(CalculateDateEnd(FourthDate.getText(), SueFourthTotal.getText()));

                           }
             }
             );
             SueFourthEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                 FifthDate.setText(CalculateDateNextTimes(SueFourthEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                  FifthDate.setText(CalculateDateNextTimes(SueFourthEnd.getText()));

                           }
             }
             );
        SueFifthTotal.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueFifthEnd.setText(CalculateDateEnd(FifthDate.getText(), SueFifthTotal.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueFifthEnd.setText(CalculateDateEnd(FifthDate.getText(), SueFifthTotal.getText()));

                           }
             }
             );
        SueFifthEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                 SixthDate.setText(CalculateDateNextTimes(SueFifthEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                  SixthDate.setText(CalculateDateNextTimes(SueFifthEnd.getText()));

                           }
             }
             );
         SueSixthTotal.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueSixthEnd.setText(CalculateDateEnd(SixthDate.getText(), SueSixthTotal.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueSixthEnd.setText(CalculateDateEnd(SixthDate.getText(), SueSixthTotal.getText()));

                           }
             }
             );
          SueSixthEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                 SevDate.setText(CalculateDateNextTimes(SueSixthEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                  SevDate.setText(CalculateDateNextTimes(SueSixthEnd.getText()));

                           }
             }
             );
           SueSevenTotal.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueSevenEnd.setText(CalculateDateEnd(SevDate.getText(), SueSevenTotal.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueSevenEnd.setText(CalculateDateEnd(SevDate.getText(), SueSevenTotal.getText()));

                           }
             }
             );

    }
    public static String ChangFormat(String DateSue){
        String newFormatDate=null;
       try{   Calendar cal;
        SimpleDateFormat formatdate =new SimpleDateFormat("d/MM/yyyy");  
         if(DateSue == null || DateSue.equals("null")|| DateSue.equals("0")|| DateSue.equals("")){
            newFormatDate="";
        }
         else{
        Date b=formatdate.parse(DateSue);
         cal = Calendar.getInstance();
          cal.setTime(b); 
           SimpleDateFormat dateformat =new SimpleDateFormat("yyyy/MM/d");   
         newFormatDate=dateformat.format(cal.getTime());
         }
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    
    }
     private void yourAttemptActionPerformed() {


       
    new BackgroundWorker().execute();


    }
          private void yourAttemptActionPerformed2() {


       
    new BackgroundWorker2().execute();


    }  
          private void yourAttemptActionPerformed3() {


       
    new BackgroundWorker3().execute();


    } 
              private void yourAttemptActionPerformed4() {


       
    new BackgroundWorker4().execute();
//

    } 
    private void yourAttemptActionPerformed5() {


       
    new BackgroundWorker5().execute();


    } 
     private void yourAttemptActionPerformed6() {


       
    new BackgroundWorker6().execute();


    } 
      private void yourAttemptActionPerformed7() {


       
    new BackgroundWorker7().execute();


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
//                                                        pb.setForeground(Color.blue);]
                                               
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
  File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
   
        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
//            JCheckBox[] boxes = {};
        try { 
            for (int i = 0; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task

            if(Print1.isEnabled()){
              W67.w67(caseid,StatusSuspect.getText(),person);
            }
//             if(Print2.isEnabled() && !"".equals(SueSecond.getText())){
//              W68.w68(caseid,SueSecond.getText());
//            }
//             if(Print3.isEnabled()&& !"".equals(SueSecond.getText())){
//             W68.w68(caseid,SueThird.getText());
//            }
//             if(Print4.isEnabled()&& !"".equals(SueSecond.getText())){
//             W68.w68(caseid,SueForth.getText());
//            }
//              if(Print5.isEnabled()&& !"".equals(SueSecond.getText())){
//             W68.w68(caseid,SueFifth.getText());
//            }
//              if(Print6.isEnabled()&& !"".equals(SueSecond.getText())){
//             W68.w68(caseid,SueSixth.getText());
//            }
//              if(Print7.isEnabled()&& !"".equals(SueSecond.getText())){
//             W68.w68(caseid,SueSeventh.getText());
//            }
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
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
     public class BackgroundWorker2 extends SwingWorker<Void, Void> {

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
            public BackgroundWorker2() {
           
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
//                                                        pb.setForeground(Color.blue);]
                                               
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
  File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
   
        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
//            JCheckBox[] boxes = {};
        try { 
            for (int i = 0; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
				Thread.sleep(10);

              W68.w68(caseid,SueSecond.getText(),StatusSuspect.getText(),person);
            
            
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
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
       public class BackgroundWorker3 extends SwingWorker<Void, Void> {

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
            public BackgroundWorker3() {
           
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
//                                                        pb.setForeground(Color.blue);]
                                               
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
  File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
   
        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
//            JCheckBox[] boxes = {};
        try { 
            for (int i = 0; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task

            
             
              W68.w68(caseid,SueThird.getText(),StatusSuspect.getText(),person);
            
            
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
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
       public class BackgroundWorker4 extends SwingWorker<Void, Void> {

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
            public BackgroundWorker4() {
           
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
//                                                        pb.setForeground(Color.blue);]
                                               
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
  
//            JCheckBox[] boxes = {};
        try { 
            for (int i = 0; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task

                           W68.w68(caseid,SueForth.getText(),StatusSuspect.getText(),person);


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
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
       public class BackgroundWorker5 extends SwingWorker<Void, Void> {

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
            public BackgroundWorker5() {
           
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
//                                                        pb.setForeground(Color.blue);]
                                               
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
  
//            JCheckBox[] boxes = {};
        try { 
            for (int i = 0; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task

            W68.w68(caseid,SueFifth.getText(),StatusSuspect.getText(),person);


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
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
       public class BackgroundWorker6 extends SwingWorker<Void, Void> {

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
            public BackgroundWorker6() {
           
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
//                                                        pb.setForeground(Color.blue);]
                                               
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
  
//            JCheckBox[] boxes = {};
        try { 
            for (int i = 0; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task


              
             W68.w68(caseid,SueSixth.getText(),StatusSuspect.getText(),person);
            

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
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
       public class BackgroundWorker7 extends SwingWorker<Void, Void> {

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
            public BackgroundWorker7() {
           
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
//                                                        pb.setForeground(Color.blue);]
                                               
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
  
//            JCheckBox[] boxes = {};
        try { 
            for (int i = 0; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task


             
             W68.w68(caseid,SueSeventh.getText(),StatusSuspect.getText(),person);
            
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
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
        public void comboInvest(){
    
     try {

         Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select InvestRank,InvestName from InvestInformation";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
	SueFirstRequest.addItem(res.getString("InvestRank")+res.getString("InvestName"));
        SueSecRequest.addItem(res.getString("InvestRank")+res.getString("InvestName"));
        SueThirdRequest.addItem(res.getString("InvestRank")+res.getString("InvestName"));
        SueFourthRequest.addItem(res.getString("InvestRank")+res.getString("InvestName"));
        SueFifthRequest.addItem(res.getString("InvestRank")+res.getString("InvestName"));
        SueSixthRequest.addItem(res.getString("InvestRank")+res.getString("InvestName"));
        SueSevRequest.addItem(res.getString("InvestRank")+res.getString("InvestName"));

	
	}
//        else{jComboPoliceName.addItem("");}
	
}
catch (Exception d) {  //System.out.println(d);  
}
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SueCrimesFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SueCrimesFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SueCrimesFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SueCrimesFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new SueCrimesFrom().setVisible(true);
            }
        });
    }
      

    public String CalculateDateEnd(String DateStart,String DateTotal) {

    String DateEnd="";
    int totalDate=Integer.parseInt(DateTotal);
    int totalNew=totalDate-1;
        try{
            Calendar cal;
            Locale lc = new Locale("th","TH");
                        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
                        Date dateS = sdf.parse(DateStart);
                        cal=Calendar.getInstance();
                        cal.setTime(dateS);
                        cal.add(Calendar.DATE, totalNew);
                        DateEnd=sdf.format(cal.getTime());
//                        Date dateE=sdf.parse(DateEnd);
//                long diff = dateE.getTime() - dateS.getTime();
//                int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
//                DateTotal=diffDays+"";
//                 System.out.println("DaysTotallllllllll : "+DateTotal);
            } catch(Exception e){
                System.out.println(e);
            }
           return DateEnd;
    
    }
     public String CalculateDateAdd(String DateEnd) {

    String DateNextDay="";
//    int totalDate=Integer.parseInt(DateTotal);
        try{
            Calendar cal;
            Locale lc = new Locale("th","TH");
                        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
                        Date dateS = sdf.parse(DateEnd);
                        cal=Calendar.getInstance();
                        cal.setTime(dateS);
                        cal.add(Calendar.DAY_OF_MONTH, 1);
                        DateNextDay=sdf.format(cal.getTime());
                        
//                        Date dateE=sdf.parse(DateEnd);
//                long diff = dateE.getTime() - dateS.getTime();
//                int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
//                DateTotal=diffDays+"";
//                 System.out.println("DaysTotallllllllll : "+DateTotal); 
            return DateNextDay;
            } catch(Exception e){
                            return null;
//                System.out.println(e);
            }
       
    
    }
     public static String Checknull(Object input){
         String a="";
        
		if(input==null||input==""||input=="null") { return ""; } 
                a=input+"";
		return a;
		}
    
     public static String ChangFormatSQL(String DateSue){
        String newFormatDate=null;
       try{   Calendar cal;
       Locale lc = new Locale("th","TH");
        SimpleDateFormat formatdate =new SimpleDateFormat("yyyy/MM/d");     
        if(DateSue == null || DateSue.equals("null")|| DateSue.equals("0")){
            newFormatDate="";
        }
        else{       
            Date b=formatdate.parse(DateSue);
         cal = Calendar.getInstance();
          cal.setTime(b); 
          System.out.println("fffffff : "+cal.getTime());
           SimpleDateFormat dateformat =new SimpleDateFormat("d/MM/yyyy");   
         newFormatDate=dateformat.format(cal.getTime()); 
       
        }
        
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    
    }

  public String CalculateDateNextTimes(String DateEnd) {

    String DateNextTime="";
//    int totalDate=Integer.parseInt(DateTotal);
        try{
             Calendar c = Calendar.getInstance();
    // Set the calendar to monday of the current week
//    c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

    // Print dates of the current week starting on Monday to Friday
//    DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
   
//        System.out.println(df.format(c.getTime()));
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//        if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday skip to Monday
//            c.add(Calendar.DATE, 2);
//        } else {
//            c.add(Calendar.DATE, 1);
//        }

     
            Calendar cal;
            Locale lc = new Locale("th","TH");
                        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy",lc);
                         SimpleDateFormat newdf = new SimpleDateFormat("EEE d/MM/yyyy",lc);
                        Date dateS = sdf.parse(DateEnd);
//                        CalculateDateExpr(DateEnd);
                    String datenew;
                    datenew=newdf.format(dateS);
                    Date daten=newdf.parse(datenew);
//                 System.out.println("DaysTotallllllllll : "+dateS);   
                         
                        cal=Calendar.getInstance();
                        cal.setTime(daten);
//                                System.out.println(newdf.format(cal.getTime()));
//                        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//                        System.out.println(dayOfWeek);
//                         if (dayOfWeek == Calendar.FRIDAY) { // If it's Friday so skip to Monday
//                            cal.add(Calendar.DATE, 3);
//                        } else if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday skip to Monday
//                            cal.add(Calendar.DATE, 2);
//                        } else {
//                            cal.add(Calendar.DATE, 1);
//                        }
                            cal.add(Calendar.DAY_OF_MONTH, 1);

//                       cal.add(Calendar.DAY_OF_MONTH, 1);
                        DateNextTime=sdf.format(cal.getTime());                  
//                        Date dateE=sdf.parse(DateEnd);
//                long diff = dateE.getTime() - dateS.getTime();
//                int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
//                DateTotal=diffDays+"";
//                 System.out.println("DaysTotallllllllll : "+DateTotal);
                return DateNextTime;
            } catch(Exception e){
                return null;
//                System.out.println(e);
            }
          
    
    }
            public int CalculateDateExpr(String DateEnd){
       int diffDays =0;   
       try{
     if(DateEnd != null && !"".equals(DateEnd)){
               Locale lc = new Locale("th","TH");
           SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy",lc);
                        SimpleDateFormat  format = new SimpleDateFormat("d/MM/yyyy",lc);  
                        String d2Day=dateFormat.format(new Date());
                        Date dateTo =null;
                        Date dateArrEnd=null;
                         dateTo=format.parse(d2Day);
                          dateArrEnd=format.parse(DateEnd);
                            long diff = dateArrEnd.getTime() - dateTo.getTime();
                             diffDays = (int)(diff / (24 * 60 * 60 * 1000)); 
                             if(diffDays<0){
                             diffDays=0;
                             }
                             System.out.println("Time in Day: " + diffDays + " Days."); 
     }
                    
       }catch(Exception e){
           e.printStackTrace();
       
       }
          return diffDays;               
    
    }
  public String CalculateDateExpir(String DateEnd) {

    String DateNextTime="";
//    int totalDate=Integer.parseInt(DateTotal);
        try{
            Calendar cal;
            Locale lc = new Locale("th","TH");
                        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
                        Date dateS = sdf.parse(DateEnd);
                        cal=Calendar.getInstance();
                        cal.setTime(dateS);
                        cal.add(Calendar.DATE, 1);
                        DateNextTime=sdf.format(cal.getTime());
//                        Date dateE=sdf.parse(DateEnd);
//                long diff = dateE.getTime() - dateS.getTime();
//                int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
//                DateTotal=diffDays+"";
//                 System.out.println("DaysTotallllllllll : "+DateTotal);
            } catch(Exception e){
                System.out.println(e);
            }
           return DateNextTime;
    
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccureandOther;
    private javax.swing.JTextField ArrestDateTimeEnd;
    private javax.swing.JTextField ChargeName;
    private javax.swing.JTextField CourtSuspect;
    private javax.swing.JLabel CourtSuspect1;
    private javax.swing.JTextField DateArrest;
    private javax.swing.JTextField FifthDate;
    private javax.swing.JTextField FourthDate;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField NumberImprison;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PlaceArrest;
    private javax.swing.JButton Print1;
    private javax.swing.JButton Print2;
    private javax.swing.JButton Print3;
    private javax.swing.JButton Print4;
    private javax.swing.JButton Print5;
    private javax.swing.JButton Print6;
    private javax.swing.JButton Print7;
    private javax.swing.JTextField SevDate;
    private javax.swing.JTextField SixthDate;
    private javax.swing.JLabel StatusSuspect;
    private javax.swing.JTextField SueEndLast;
    private javax.swing.JTextField SueFifth;
    private javax.swing.JComboBox<String> SueFifthCause;
    private javax.swing.JTextField SueFifthEnd;
    private javax.swing.JComboBox<String> SueFifthRequest;
    private javax.swing.JTextField SueFifthTotal;
    private javax.swing.JTextField SueFirst;
    private javax.swing.JComboBox<String> SueFirstCause;
    private javax.swing.JTextField SueFirstDate;
    private javax.swing.JTextField SueFirstEnd;
    private javax.swing.JComboBox<String> SueFirstRequest;
    private javax.swing.JTextField SueFirstTotal;
    private javax.swing.JTextField SueForth;
    private javax.swing.JComboBox<String> SueFourthCause;
    private javax.swing.JTextField SueFourthEnd;
    private javax.swing.JComboBox<String> SueFourthRequest;
    private javax.swing.JTextField SueFourthTotal;
    private javax.swing.JComboBox<String> SueSecCause;
    private javax.swing.JTextField SueSecDateT;
    private javax.swing.JTextField SueSecEnd;
    private javax.swing.JComboBox<String> SueSecRequest;
    private javax.swing.JTextField SueSecTotal;
    private javax.swing.JTextField SueSecond;
    private javax.swing.JComboBox<String> SueSevCause;
    private javax.swing.JComboBox<String> SueSevRequest;
    private javax.swing.JTextField SueSevenEnd;
    private javax.swing.JTextField SueSevenTotal;
    private javax.swing.JTextField SueSeventh;
    private javax.swing.JTextField SueSixth;
    private javax.swing.JComboBox<String> SueSixthCause;
    private javax.swing.JTextField SueSixthEnd;
    private javax.swing.JComboBox<String> SueSixthRequest;
    private javax.swing.JTextField SueSixthTotal;
    private javax.swing.JTextField SueStartLast;
    private javax.swing.JTextField SueThird;
    private javax.swing.JComboBox<String> SueThirdCause;
    private javax.swing.JTextField SueThirdEnd;
    private javax.swing.JComboBox<String> SueThirdRequest;
    private javax.swing.JTextField SueThirdTotal;
    private javax.swing.JTextField ThirdDate;
    private javax.swing.JTextField TotalDate;
    private javax.swing.JTextField crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonSave;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
