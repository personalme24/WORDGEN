/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
import static com.songkhla.document.W5.Checknull;
import com.songkhla.document.W67;
import com.songkhla.document.W68;

import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.ImageIcon;
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
    String caseid;
    String dateF,dateTot;
//    JDatePickerImpl SueSecDate,SueThirdDate,SueFourthDate,SueFifthDate,SueSixthDate,SueSevDate;
    /**
     * Creates new form SueCrimesFrom
     */
    public SueCrimesFrom(JFrame parrent,JSONObject datain) {
        super(parrent,true);
        initComponents();
//        DataLastSue();
        ImageIcon img = new ImageIcon("D://Master//WD.png");
        setIconImage(img.getImage());
        setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
       
//        jLabel2.setVisible(false);

          person=datain.get("NoPerson")+"";
            caseid=datain.get("caseIdPerson")+"";   
            dateF=datain.get("SueFirstDate")+"";
         comboInvest();
//        String a=txtCaseNO.getText();
      try{   
          Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
           String sql= "select MAX(SueFirst,suesecond,SueThird,SueFourth,SueFifth,SueSixth,SueSeven) SueMax,"
                   + "MAX(ifnull(SueFirstEnd,0),ifnull(SueSecEnd,0),ifnull(SueThirdEnd,0),ifnull(SueFourthEnd,0),ifnull(SueFifthEnd,0),ifnull(SueSixthEnd,0),ifnull(SueSevenEnd,0)) DateEndMax,"
                   + "MAX(SueFirstDate,SueSecDate,SueThirdDate,SueFourthDate,SueFifthDate,SueSixthDate,SueSevenDate) DateStartMax"
                   + " from person where caseIdPerson='"+caseid+"' and NoPerson='"+person+"'";
            ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
          if(rs.next()){
          
           NumberImprison.setText(rs.getString("SueMax"));
        SueStartLast.setText(rs.getString("DateStartMax"));
        SueEndLast.setText(rs.getString("DateEndMax"));
        String a=CalculateDateExpr(rs.getString("DateEndMax"))+"";
              TotalDate.setText(a);
//              SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
//              String dateStart = rs.getString("SueEnd");
//                 String dateStop = rs.getString("DateEndMax");
//               
//     
//
//    Date date1 = myFormat.parse(dateStart);
//    Date date2 = myFormat.parse(dateStop);
//    long diff = date2.getTime() - date1.getTime();
          }
    
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
        if(datain != null){
            
         try{
            crimecaseno.setText(datain.get("crimecasenoyear")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            AccureandOther.setText(datain.get("AccureandOther")+"");
            FullNamePerson.setText(datain.get("FullNamePerson")+"");
            ChargeName.setText(datain.get("ChargeName")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
//            SueFirst.setText(datain.get("SueFirst")+"");
//            SueFirstDate.setText(datain.get("SueFirstDate")+"");   
            PlaceArrest.setText(datain.get("PlaceArrest")+"");
            DateArrest.setText(datain.get("ArrestDateTime")+"");
            ArrestDateTimeEnd.setText(datain.get("ArrestDateTimeEnd")+"");
            
            SueFirst.setText(Checknull(datain.get("SueFirst")));
            SueFirstDate.setText(Checknull(datain.get("SueFirstDate")));        
            SueFirstEnd.setText(Checknull(datain.get("SueFirstEnd")));
          
                 SueFirstEnd.setText(Checknull(datain.get("SueFirstEnd")));
          
            SueFirstTotal.setText(Checknull(datain.get("SueFirstTotal")));
           SueFirstRequest.setSelectedItem(Checknull(datain.get("SueFirstRequest")));
           SueFirstCause.setSelectedItem(Checknull(datain.get("SueFirstCause")));
            SueSecond.setText(Checknull(datain.get("SueSecond")));
            SueSecDateT.setText(Checknull(datain.get("SueSecDate")));        
            SueSecEnd.setText(Checknull(datain.get("SueSecEnd")));
            SueSecTotal.setText(Checknull(datain.get("SueSecTotal")));
           SueSecRequest.setSelectedItem(Checknull(datain.get("SueSecRequest")));
           SueSecCause.setSelectedItem(Checknull(datain.get("SueSecCause")));
             SueThird.setText(Checknull(datain.get("SueThird")));
            ThirdDate.setText(Checknull(datain.get("SueThirdDate")));        
            SueThirdEnd.setText(Checknull(datain.get("SueThirdEnd")));
            SueThirdTotal.setText(Checknull(datain.get("SueThirdTotal")));
           SueThirdRequest.setSelectedItem(Checknull(datain.get("SueThirdRequest")));
           SueThirdCause.setSelectedItem(Checknull(datain.get("SueThirdCause")));
             SueForth.setText(Checknull(datain.get("SueFourth")));
            FourthDate.setText(Checknull(datain.get("SueFourthDate")));        
            SueFourthEnd.setText(Checknull(datain.get("SueFourthEnd")));
            SueFourthTotal.setText(Checknull(datain.get("SueFourthtotal")));
           SueFourthRequest.setSelectedItem(Checknull(datain.get("SueFourthRequest")));
           SueFourthCause.setSelectedItem(Checknull(datain.get("SueFourthCause")));
             SueFifth.setText(Checknull(datain.get("SueFifth")));
            FifthDate.setText(Checknull(datain.get("SueFifthDate")));        
            SueFifthEnd.setText(Checknull(datain.get("SueFifthEnd")));
            SueFifthTotal.setText(Checknull(datain.get("SueFifthTotal")));
           SueFifthRequest.setSelectedItem(Checknull(datain.get("SueFifthRequest")));
           SueFifthCause.setSelectedItem(Checknull(datain.get("SueFifthCause")));
              SueSixth.setText(Checknull(datain.get("SueSixth")));
            SixthDate.setText(Checknull(datain.get("SueSixthDate")));        
            SueSixthEnd.setText(Checknull(datain.get("SueSixthEnd")));
            SueSixthTotal.setText(Checknull(datain.get("SueSixthTotal")));
           SueSixthRequest.setSelectedItem(Checknull(datain.get("SueSixthRequest")));
           SueSixthCause.setSelectedItem(Checknull(datain.get("SueSixthCause")));       
               SueSeventh.setText(Checknull(datain.get("SueSeven")));
            SevDate.setText(Checknull(datain.get("SueSevenDate")));        
            SueSevenEnd.setText(Checknull(datain.get("SueSevenEnd")));
            SueSevenTotal.setText(Checknull(datain.get("SueSevenTotal")));
           SueSevRequest.setSelectedItem(Checknull(datain.get("SueSevenRequest")));
           SueSevCause.setSelectedItem(Checknull(datain.get("SueSevenCause")));        
       
            
            String a=datain.get("ArrestDateTimeEnd")+"";
             SimpleDateFormat  format = new SimpleDateFormat("dd/MM/yyyy");
             Date aa=format.parse(a);
            SueFirstDate.setText(format.format(aa)+"");
         }
         catch(Exception e)
         {e.printStackTrace();}
        } 
       DateTotal();
           
     

        RefreshData(); 
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
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FullNamePerson = new javax.swing.JTextField();
        PeopleRegistrationID = new javax.swing.JTextField();
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
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
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
        SueFirstEnd = new javax.swing.JTextField();
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
        SueSecEnd = new javax.swing.JTextField();
        SueSecCause = new javax.swing.JComboBox<>();
        SueThirdEnd = new javax.swing.JTextField();
        SueThirdTotal = new javax.swing.JTextField();
        SueThirdRequest = new javax.swing.JComboBox<>();
        SueSevCause = new javax.swing.JComboBox<>();
        SueSevenEnd = new javax.swing.JTextField();
        SueSevenTotal = new javax.swing.JTextField();
        SueSevRequest = new javax.swing.JComboBox<>();
        SueFourthEnd = new javax.swing.JTextField();
        SueFifthEnd = new javax.swing.JTextField();
        SueSixthEnd = new javax.swing.JTextField();
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
        Print8 = new javax.swing.JButton();
        Print2 = new javax.swing.JButton();
        SueFirst = new javax.swing.JTextField();
        SueSecond = new javax.swing.JTextField();
        SueThird = new javax.swing.JTextField();
        SueForth = new javax.swing.JTextField();
        SueFifth = new javax.swing.JTextField();
        SueSixth = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 720));

        jPanel3.setBackground(new java.awt.Color(46, 156, 202));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ผัดฟ้องฝากขัง");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        jLabel24.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("ข้อมูลคดี");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
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

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        crimecaseno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        crimecaseno.setEnabled(false);

        jLabel31.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("เลขประจำตัวบัตรประชาชน");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อผู้ต้องหา");

        FullNamePerson.setEditable(false);
        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        PeopleRegistrationID.setEditable(false);
        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อผู้กล่าวหา");

        AccureandOther.setEditable(false);
        AccureandOther.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("ข้อหา");

        ChargeName.setEditable(false);
        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("สถานที่ควบคุม");

        PlaceArrest.setEditable(false);
        PlaceArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        DateArrest.setEditable(false);

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("วันที่จับกุม");

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("วันที่สิ้นสุดการจับกุม");

        ArrestDateTimeEnd.setEditable(false);
        ArrestDateTimeEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FullNamePerson))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel31)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PeopleRegistrationID)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AccureandOther))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChargeName))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(DateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(5, 5, 5)
                        .addComponent(ArrestDateTimeEnd)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(crimecaseno)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(AccureandOther, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(ArrestDateTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jPanel7.setBackground(new java.awt.Color(0, 102, 204));
        jPanel7.setForeground(new java.awt.Color(102, 0, 0));

        jLabel25.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ข้อมูลการผัดฟ้อง/ฝากขัง(ล่าสุด)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(253, 253, 253))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        NumberImprison.setEditable(false);

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("ครั้งที่ผัดฟ้องฝากขัง");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("วันที่เริ่ม");

        SueEndLast.setEditable(false);
        SueEndLast.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("ระยะเวลาคงเหลือ");

        TotalDate.setEditable(false);
        TotalDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        TotalDate.setForeground(new java.awt.Color(255, 0, 0));

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("วัน");

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("วันที่สิ้นสุด");

        SueStartLast.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NumberImprison))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SueStartLast))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TotalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SueEndLast, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberImprison, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(SueEndLast, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SueStartLast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(TotalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setEnabled(false);

        SueFirstDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFirstDateActionPerformed(evt);
            }
        });

        SueFirstEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFirstEndActionPerformed(evt);
            }
        });

        SueFirstRequest.setEditable(true);
        SueFirstRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueFirstCause.setEditable(true);
        SueFirstCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueSeventh.setBackground(new java.awt.Color(46, 156, 202));
        SueSeventh.setForeground(new java.awt.Color(255, 255, 255));
        SueSeventh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueSeventh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSeventhActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(0, 102, 204));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ครั้งที่");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("วันผัดฝาก");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("รวมวัน");

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("วันสิ้นสุด");

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ผู้ร้อง");

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("เหตุผัดฟ้องฝากขัง");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(97, 97, 97)
                .addComponent(jLabel4)
                .addGap(127, 127, 127)
                .addComponent(jLabel9)
                .addGap(111, 111, 111)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(195, 195, 195)
                .addComponent(jLabel12)
                .addGap(216, 216, 216))
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

        SueSecTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSecTotalActionPerformed(evt);
            }
        });

        SueSecRequest.setEditable(true);
        SueSecRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueSecEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSecEndActionPerformed(evt);
            }
        });

        SueSecCause.setEditable(true);
        SueSecCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueThirdEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueThirdEndActionPerformed(evt);
            }
        });

        SueThirdTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueThirdTotalActionPerformed(evt);
            }
        });

        SueThirdRequest.setEditable(true);
        SueThirdRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueSevCause.setEditable(true);
        SueSevCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueSevenEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSevenEndActionPerformed(evt);
            }
        });

        SueSevenTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSevenTotalActionPerformed(evt);
            }
        });

        SueSevRequest.setEditable(true);
        SueSevRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueFourthEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFourthEndActionPerformed(evt);
            }
        });

        SueFifthEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFifthEndActionPerformed(evt);
            }
        });

        SueSixthEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSixthEndActionPerformed(evt);
            }
        });

        SueFourthTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFourthTotalActionPerformed(evt);
            }
        });

        SueFifthTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFifthTotalActionPerformed(evt);
            }
        });

        SueSixthTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSixthTotalActionPerformed(evt);
            }
        });

        SueFourthRequest.setEditable(true);
        SueFourthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueFifthRequest.setEditable(true);
        SueFifthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueSixthRequest.setEditable(true);
        SueSixthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        SueThirdCause.setEditable(true);
        SueThirdCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueFourthCause.setEditable(true);
        SueFourthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueFifthCause.setEditable(true);
        SueFifthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        SueSixthCause.setEditable(true);
        SueSixthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));

        FifthDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FifthDateActionPerformed(evt);
            }
        });

        Print1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print1.setText("พิมพ์");
        Print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print1ActionPerformed(evt);
            }
        });

        Print3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print3.setText("พิมพ์");
        Print3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print3ActionPerformed(evt);
            }
        });

        Print4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print4.setText("พิมพ์");

        Print5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print5.setText("พิมพ์");

        Print6.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print6.setText("พิมพ์");

        Print7.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print7.setText("พิมพ์");

        Print8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print8.setText("พิมพ์");

        Print2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Print2.setText("พิมพ์");
        Print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print2ActionPerformed(evt);
            }
        });

        SueFirst.setBackground(new java.awt.Color(46, 156, 202));
        SueFirst.setForeground(new java.awt.Color(255, 255, 255));
        SueFirst.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        SueSecond.setBackground(new java.awt.Color(46, 156, 202));
        SueSecond.setForeground(new java.awt.Color(255, 255, 255));
        SueSecond.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueSecond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSecondActionPerformed(evt);
            }
        });

        SueThird.setBackground(new java.awt.Color(46, 156, 202));
        SueThird.setForeground(new java.awt.Color(255, 255, 255));
        SueThird.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueThird.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueThirdActionPerformed(evt);
            }
        });

        SueForth.setBackground(new java.awt.Color(46, 156, 202));
        SueForth.setForeground(new java.awt.Color(255, 255, 255));
        SueForth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueForth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueForthActionPerformed(evt);
            }
        });

        SueFifth.setBackground(new java.awt.Color(46, 156, 202));
        SueFifth.setForeground(new java.awt.Color(255, 255, 255));
        SueFifth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueFifth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFifthActionPerformed(evt);
            }
        });

        SueSixth.setBackground(new java.awt.Color(46, 156, 202));
        SueSixth.setForeground(new java.awt.Color(255, 255, 255));
        SueSixth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SueSixth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSixthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(SueFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(SueFirstEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueFirstTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(SueFirstRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(SueSecDateT, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SueSecEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueSecTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(SueSecRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueFifth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(FifthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(SueFifthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueFifthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueFifthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueSixth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(SixthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(SueSixthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueSixthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueSixthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(SueSeventh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SevDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(SueSevenEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueSevenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueSevRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueForth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(FourthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SueFourthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueFourthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(SueFourthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueThird, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(ThirdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SueThirdEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SueThirdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(SueThirdRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueFirstCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(Print1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueSecCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(Print2))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueFifthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(Print5))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueSixthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(Print6))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueSevCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Print7)
                                    .addComponent(Print8)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueFourthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(Print4))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(SueThirdCause, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(Print3)))))
                .addGap(10, 10, 10))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(SueFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueFirstEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueFirstTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SueFirstRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SueSecDateT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueSecEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueSecTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(SueSecRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ThirdDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueThird, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SueThirdEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueThirdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(SueThirdRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(FourthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SueForth, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(SueFourthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(SueFourthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(SueFourthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueFifth, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(FifthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueFifthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueFifthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueFifthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueSixth, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(SixthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueSixthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueSixthTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(SueSixthRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SevDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SueSeventh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SueSevenEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueSevenTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SueSevRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueFirstCause, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueSecCause, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueThirdCause, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueFourthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueFifthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueSixthCause, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SueSevCause, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Print8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jButtonSave.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jButtonSave.setText("บันทึก");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void SueSecEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSecEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSecEndActionPerformed
  
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
         con=ConnectDatabase.connect();
         String a=null;
         try{
        SimpleDateFormat formatdate =new SimpleDateFormat("yyyy-MM-dd");
        Date b=formatdate.parse(SueFirstDate.getText());
         a=formatdate.format(b);
         }
         catch(Exception e){
         
         }
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
                pst.setString(2,a);
                pst.setString(3,SueFirstEnd.getText());
                pst.setString(4,SueFirstTotal.getText());
                pst.setString(5,SueFirstRequest.getSelectedItem().toString());
                pst.setString(6,SueFirstCause.getSelectedItem().toString());
                pst.setString(7,SueSecond.getText());
                pst.setString(8,SueSecDateT.getText());
                pst.setString(9,SueSecEnd.getText());
                pst.setString(10,SueSecTotal.getText());
                pst.setString(11,SueSecRequest.getSelectedItem().toString());
                pst.setString(12,SueSecCause.getSelectedItem().toString());
                pst.setString(13,SueThird.getText());
                pst.setString(14,ThirdDate.getText());
                pst.setString(15,SueThirdEnd.getText());
                pst.setString(16,SueThirdTotal.getText());
                pst.setString(17,SueThirdRequest.getSelectedItem().toString());
                pst.setString(18,SueThirdCause.getSelectedItem().toString());
                pst.setString(19,SueForth.getText());
                pst.setString(20,FourthDate.getText());
                pst.setString(21,SueFourthEnd.getText());
                pst.setString(22,SueFourthTotal.getText());
                pst.setString(23,SueFourthRequest.getSelectedItem().toString());
                pst.setString(24,SueFourthCause.getSelectedItem().toString());
                pst.setString(25,SueFifth.getText());
                pst.setString(26,FifthDate.getText());
                pst.setString(27,SueFifthEnd.getText());
                pst.setString(28,SueFifthTotal.getText());
                pst.setString(29,SueFifthRequest.getSelectedItem().toString());
                pst.setString(30,SueFifthCause.getSelectedItem().toString());
                pst.setString(31,SueSixth.getText());
                pst.setString(32,SixthDate.getText());
                pst.setString(33,SueSixthEnd.getText());
                pst.setString(34,SueSixthTotal.getText());
                pst.setString(35,SueSixthRequest.getSelectedItem().toString());
                pst.setString(36,SueSixthCause.getSelectedItem().toString());
                pst.setString(37,SueSeventh.getText());
                pst.setString(38,SevDate.getText());
                pst.setString(39,SueSevenEnd.getText());
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
                System.out.println("SQL : "+sqlUpdate);
                } 
             
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }

        

//        setVisible(false);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void SueFirstEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueFirstEndActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_SueFirstEndActionPerformed

    private void SueThirdEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueThirdEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueThirdEndActionPerformed

    private void SueFourthEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueFourthEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueFourthEndActionPerformed

    private void SueFifthEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueFifthEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueFifthEndActionPerformed

    private void SueSixthEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSixthEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSixthEndActionPerformed

    private void SueSevenEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSevenEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSevenEndActionPerformed

    private void SueThirdTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueThirdTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueThirdTotalActionPerformed

    private void SueFourthTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueFourthTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueFourthTotalActionPerformed

    private void SueFifthTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueFifthTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueFifthTotalActionPerformed

    private void SueSixthTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSixthTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSixthTotalActionPerformed

    private void SueSevenTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSevenTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSevenTotalActionPerformed

    private void SueSeventhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSeventhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSeventhActionPerformed

    private void SueSecondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSecondActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSecondActionPerformed

    private void Print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print1ActionPerformed
        // TODO add your handling code here:
        if(SueFirst.getText().equals("")){
                 JOptionPane.showMessageDialog(jPanel1,"แจ้งเตือน", "กรุณากรอกข้อมูล", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        W67.w67(caseid);
        
    }//GEN-LAST:event_Print1ActionPerformed

    private void SueThirdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueThirdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueThirdActionPerformed

    private void SueForthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueForthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueForthActionPerformed

    private void SueFifthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueFifthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueFifthActionPerformed

    private void SueSixthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSixthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSixthActionPerformed

    private void SueFirstDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueFirstDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueFirstDateActionPerformed

    private void SueSecTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SueSecTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SueSecTotalActionPerformed

    private void FifthDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FifthDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FifthDateActionPerformed

    private void Print3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print3ActionPerformed
        // TODO add your handling code here:
        if(SueThird.getText().equals("")){
         JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูล", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
         W68.w68(caseid,SueThird.getText());
    }//GEN-LAST:event_Print3ActionPerformed

    private void Print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print2ActionPerformed
        // TODO add your handling code here:
          if(SueSecond.getText().equals("")){
           JOptionPane.showMessageDialog(jPanel1,"กรุณากรอกข้อมูล", "แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
        }
           W68.w68(caseid,SueSecond.getText());
          
    }//GEN-LAST:event_Print2ActionPerformed
    public void DateTotal(){
     SueFirstEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueFirstTotal.setText(CalculateDateTotal(SueFirstDate.getText(), SueFirstEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
                                                       SueFirstTotal.setText(CalculateDateTotal(SueFirstDate.getText(), SueFirstEnd.getText()));

                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueFirstTotal.setText(CalculateDateTotal(SueFirstDate.getText(), SueFirstEnd.getText()));
                           }
             }
             );
              SueSecEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueSecTotal.setText(CalculateDateTotal(SueSecDateT.getText(), SueSecEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
                                SueSecTotal.setText(CalculateDateTotal(SueSecDateT.getText(), SueSecEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueSecTotal.setText(CalculateDateTotal(SueSecDateT.getText(), SueSecEnd.getText()));

                           }
             }
             );
    SueThirdEnd.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                               SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));

                           }
             }
             );
    }
      public int CalculateDateExpr(String DateEnd){
       int diffDays =0;   
       try{
     
               Locale lc = new Locale("th","TH");
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy",lc);
                        SimpleDateFormat  format = new SimpleDateFormat("dd/MM/yyyy",lc);  
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
                    
       }catch(Exception e){
           e.printStackTrace();
       
       }
          return diffDays;               
    
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
//     public void DataLastSue(){
//          try{          
//        Connection con = ConnectDatabase.connect();
//        Statement stmt = con.createStatement();
////        String a=txtCaseNO.getText();
//      
//           String sql= "select MAX(ifnull(SueFirst,0),ifnull(suesecond,0),ifnull(SueThird,0),ifnull(SueFourth,0),ifnull(SueFifth,0),ifnull(SueSixth,0),ifnull(SueSeven,0)) SueMax,"
//                   + "MAX(SueFirstEnd,SueSecEnd,SueThirdEnd,SueFourthEnd,SueFifthEnd,SueSixthEnd,SueSevenEnd) DateEndMax,"
//                   + "MAX(SueFirstDate,SueSecDate,SueThirdDate,SueFourthDate,SueFifthDate,SueSixthDate,SueSevenDate) DateStartMax"
//                   + " from person where caseIdPerson='"+caseid+"' and NoPerson='"+person+"'";
//            ResultSet rs = stmt.executeQuery(sql);
//          System.out.println("SQL : "+sql);
//          if(rs.next()){
//          
//           NumberImprison.setText(rs.getString("SueMax"));
//        SueStartLast.setText(rs.getString("DateStartMax"));
//        SueEndLast.setText(rs.getString("DateEndMax"));
////              SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
////              String dateStart = rs.getString("SueEnd");
////                 String dateStop = rs.getString("DateEndMax");
////               
////     
////
////    Date date1 = myFormat.parse(dateStart);
////    Date date2 = myFormat.parse(dateStop);
////    long diff = date2.getTime() - date1.getTime();
//          }
//    
//     
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }
    public String CalculateDateTotal(String DateStart,String DateEnd) {

    String DateTotal="";
    
        try{
            Locale lc = new Locale("th","TH");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dateS = sdf.parse(DateStart);
                        Date dateE=sdf.parse(DateEnd);
                long diff = dateE.getTime() - dateS.getTime();
                int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
                DateTotal=diffDays+"";
                 System.out.println("DaysTotallllllllll : "+DateTotal);
            } catch(Exception e){
                System.out.println(e);
            }
           return DateTotal;
    
    }
     public static String Checknull(Object input){
         String a="";
        
		if(input==null||input==""||input=="null") { return ""; } 
                a=input+"";
		return a;
		}
    
//    public void DataCase(){
//          try{          
//        Connection con = ConnectDatabase.connect();
//        Statement stmt = con.createStatement();
////        String a=txtCaseNO.getText();
//      
//           String sql= "select CaseId,PeopleRegistrationID,PlaceArrest,ArrestDateTime,crimecasenoyear,AccureandOther,ChargeName,FullNamePerson,PeopleRegistrationID,SueTimes,SueDate,SuePersonId,SueCaseId from Sue\n"+
//                           "left join Person on Sue.SuePersonId=Person.NoPerson\n"+
//                           "left join CrimeCase on Person.CaseIdPerson=CrimeCase.CaseId\n"+
//                          "left join Charge on CrimeCase.ChargeCodeCase=Charge.ChargeCode Where CaseIdPerson='"+caseid+"' and NoPerson='"+person+"'";
//            ResultSet rs = stmt.executeQuery(sql);
//          System.out.println("SQL : "+sql);
//          if(rs.next()){
//          
//           crimecaseno.setText(rs.getString("crimecasenoyear"));
//        PeopleRegistrationID.setText(rs.getString("PeopleRegistrationID"));
//        AccureandOther.setText(rs.getString("AccureandOther"));
//        FullNamePerson.setText(rs.getString("FullNamePerson"));
//        ChargeName.setText(rs.getString("ChargeName"));
//        PlaceArrest.setText(rs.getString("PlaceArrest"));
//        DateArrest.setText(rs.getString("ArrestDateTime"));
//
//          }
//    
//     
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }
      
   public void RefreshData(){
      try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
//        String a=txtCaseNO.getText();
        String sql;
                sql= "select SueTimes,SueDate,SueStart,SueEnd,SueTotal,\n"+ 
                    "SueCause,SueRequest from Sue Where SuePersonId='"+person+"' and SueCaseId='"+caseid+"'";
            ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("SueTimes"));
            row.add(rs.getString("SueDate"));
            row.add(rs.getString("SueStart"));
            row.add(rs.getString("SueEnd"));
            row.add(rs.getString("SueTotal"));
            row.add(rs.getString("SueCause"));
            row.add(rs.getString("SueRequest"));
 
//            row.add(rs.getString("Age"));
//            row.add(rs.getString("Race"));
//            row.add(rs.getString("Nationality"));
//            row.add(rs.getString("Religion"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector(); 
    
         ColumnName.add("ครั้งที่");    
         ColumnName.add("วันฝาก");
         ColumnName.add("นับแต่");   
         ColumnName.add("ถึงวันที่");
         ColumnName.add("รวมวัน");
         ColumnName.add("ผู้ร้อง");
         ColumnName.add("เหตุผัดฟ้องฝากขัง");
//         ColumnName.add("ครบ 2 เดือน");
         

         System.out.println("SQL : "+sql);
     
//        jTableSue.setModel(new javax.swing.table.DefaultTableModel(
//            tabledata,
//            ColumnName
//        ) {
//            Class[] types = new Class [] {
//                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
//     
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccureandOther;
    private javax.swing.JTextField ArrestDateTimeEnd;
    private javax.swing.JTextField ChargeName;
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
    private javax.swing.JButton Print8;
    private javax.swing.JTextField SevDate;
    private javax.swing.JTextField SixthDate;
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
