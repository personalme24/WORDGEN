/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
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
        ImageIcon img = new ImageIcon("D://Master//WD.png");
        setIconImage(img.getImage());
        setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
       
//        jLabel2.setVisible(false);

          person=datain.get("NoPerson")+"";
            caseid=datain.get("caseIdPerson")+"";   
            dateF=datain.get("SueFirstDate")+"";
//        
//            UtilDateModel model = new UtilDateModel();
//            model.setValue(Calendar.getInstance().getTime());
//            Properties p = new Properties();
//            p.put("text.today", "Today");
//            p.put("text.month", "Month");
//            p.put("text.year", "Year");
//        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//         SueSecDate = new JDatePickerImpl(datePanel,new DateLabelFormatter());
//        SueSecDate.getComponent(1).setEnabled(false);
//        SueSecDate.setBackground(Color.WHITE);
//        jPanelSecDate.setLayout(new FlowLayout());
//        jPanelSecDate.add(SueSecDate);    
//        
//           UtilDateModel model2 = new UtilDateModel();
//            model2.setValue(Calendar.getInstance().getTime());
//         JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
//        SueThirdDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
//        SueThirdDate.setTextEditable(true);
//        SueThirdDate.setBackground(Color.WHITE);
//        jPanelThirdDate.setLayout(new FlowLayout());
//        jPanelThirdDate.add(SueThirdDate);
//        
//        UtilDateModel model3 = new UtilDateModel();
//            model3.setValue(Calendar.getInstance().getTime());
//         JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p);
//        SueFourthDate= new JDatePickerImpl(datePanel3,new DateLabelFormatter());
//        SueFourthDate.setTextEditable(true);
//        SueFourthDate.setBackground(Color.WHITE);
//        jPanelFourthDate.setLayout(new FlowLayout());
//        jPanelFourthDate.add(SueFourthDate);
//        
//         UtilDateModel model4 = new UtilDateModel();
//            model4.setValue(Calendar.getInstance().getTime());
//         JDatePanelImpl datePanel4 = new JDatePanelImpl(model4, p);
//        SueFifthDate= new JDatePickerImpl(datePanel4,new DateLabelFormatter());
//        SueFifthDate.setTextEditable(true);
//        SueFifthDate.setBackground(Color.WHITE);
//        jPanelFifthDate.setLayout(new FlowLayout());
//        jPanelFifthDate.add(SueFifthDate);
//        
//        UtilDateModel model5 = new UtilDateModel();
//            model5.setValue(Calendar.getInstance().getTime());
//         JDatePanelImpl datePanel5 = new JDatePanelImpl(model5, p);
//        SueSixthDate= new JDatePickerImpl(datePanel5,new DateLabelFormatter());
//        SueSixthDate.setTextEditable(true);
//        SueSixthDate.setBackground(Color.WHITE);
//        jPanelSixthDate.setLayout(new FlowLayout());
//        jPanelSixthDate.add(SueSixthDate);
//        
//        UtilDateModel model6 = new UtilDateModel();
//            model6.setValue(Calendar.getInstance().getTime());
//         JDatePanelImpl datePanel6 = new JDatePanelImpl(model6, p);
//        SueSevDate= new JDatePickerImpl(datePanel6,new DateLabelFormatter());
//        SueSevDate.setTextEditable(true);
//        SueSevDate.setBackground(Color.WHITE);
//        jPanelSevDate.setLayout(new FlowLayout());
//        jPanelSevDate.add(SueSevDate);
        if(datain != null){
            
         
            crimecaseno.setText(datain.get("crimecasenoyear")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            AccureandOther.setText(datain.get("AccureandOther")+"");
            FullNamePerson.setText(datain.get("FullNamePerson")+"");
            ChargeName.setText(datain.get("ChargeName")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            SueFirst.setText(datain.get("SueFirst")+"");
            SueFirstDate.setText(datain.get("SueFirstDate")+"");
   
            PlaceArrest.setText(datain.get("PlaceArrest")+"");
            DateArrest.setText(datain.get("ArrestDateTime")+"");
      
        } 
       
    


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
        jLabel2 = new javax.swing.JLabel();
        DateArrest = new javax.swing.JTextField();
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
        SueFirst = new javax.swing.JTextField();
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        SevDate = new javax.swing.JTextField();
        SixthDate = new javax.swing.JTextField();
        FifthDate = new javax.swing.JTextField();
        FourthDate = new javax.swing.JTextField();
        ThirdDate = new javax.swing.JTextField();
        SueSecDateT = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 720));

        jPanel3.setBackground(new java.awt.Color(46, 156, 202));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ผู้ต้องหาผัดฟ้องฝากขัง");

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
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addGap(185, 185, 185))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel30.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel30.setText("เลขคดีที่ ");

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        crimecaseno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        crimecaseno.setEnabled(false);

        jLabel31.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel31.setText("เลขประจำตัวบัตรประชาชน");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("ชื่อผู้ต้องหา");

        FullNamePerson.setEditable(false);
        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        PeopleRegistrationID.setEditable(false);
        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel7.setText("ชื่อผู้กล่าวหา");

        AccureandOther.setEditable(false);
        AccureandOther.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel6.setText("ข้อหา");

        ChargeName.setEditable(false);
        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel15.setText("สถานที่ควบคุม");

        PlaceArrest.setEditable(false);
        PlaceArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel2.setText("วันที่จับกุม");

        DateArrest.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
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
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AccureandOther))
                            .addComponent(PeopleRegistrationID)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlaceArrest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ChargeName)))
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
                    .addComponent(jLabel2)
                    .addComponent(DateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
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
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel5.setEnabled(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(SueFirstDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 50, 200, 30));

        SueFirstEnd.setEditable(false);
        SueFirstEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFirstEndActionPerformed(evt);
            }
        });
        jPanel5.add(SueFirstEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 50, 164, 30));

        SueFirstTotal.setText(" ");
        jPanel5.add(SueFirstTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 50, 98, 30));

        SueFirstRequest.setEditable(true);
        SueFirstRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(SueFirstRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 46, 291, 30));

        SueFirstCause.setEditable(true);
        SueFirstCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));
        jPanel5.add(SueFirstCause, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 46, 371, 29));

        SueFirst.setEditable(false);
        SueFirst.setBackground(new java.awt.Color(46, 156, 202));
        SueFirst.setForeground(new java.awt.Color(255, 255, 255));
        SueFirst.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel5.add(SueFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 50, 29));

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
                .addGap(260, 260, 260)
                .addComponent(jLabel12)
                .addGap(151, 151, 151))
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

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        SueSecTotal.setText(" ");
        jPanel5.add(SueSecTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 86, 98, 30));

        SueSecRequest.setEditable(true);
        SueSecRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(SueSecRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 88, 291, 30));

        SueSecEnd.setEditable(false);
        SueSecEnd.setText(" ");
        SueSecEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSecEndActionPerformed(evt);
            }
        });
        jPanel5.add(SueSecEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 86, 164, 30));

        SueSecCause.setEditable(true);
        SueSecCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));
        jPanel5.add(SueSecCause, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 88, 371, 34));

        SueThirdEnd.setEditable(false);
        SueThirdEnd.setText(" ");
        SueThirdEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueThirdEndActionPerformed(evt);
            }
        });
        jPanel5.add(SueThirdEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 123, 164, 29));

        SueThirdTotal.setText(" ");
        SueThirdTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueThirdTotalActionPerformed(evt);
            }
        });
        jPanel5.add(SueThirdTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 123, 98, 29));

        SueThirdRequest.setEditable(true);
        SueThirdRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(SueThirdRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 124, 291, 29));

        SueSevCause.setEditable(true);
        SueSevCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));
        jPanel5.add(SueSevCause, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 285, 371, 29));

        SueSevenEnd.setEditable(false);
        SueSevenEnd.setText(" ");
        SueSevenEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSevenEndActionPerformed(evt);
            }
        });
        jPanel5.add(SueSevenEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 284, 164, 30));

        SueSevenTotal.setText(" ");
        SueSevenTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSevenTotalActionPerformed(evt);
            }
        });
        jPanel5.add(SueSevenTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 284, 98, 30));

        SueSevRequest.setEditable(true);
        SueSevRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(SueSevRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 284, 291, 30));

        SueFourthEnd.setEditable(false);
        SueFourthEnd.setText(" ");
        SueFourthEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFourthEndActionPerformed(evt);
            }
        });
        jPanel5.add(SueFourthEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 164, 164, 30));

        SueFifthEnd.setEditable(false);
        SueFifthEnd.setText(" ");
        SueFifthEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFifthEndActionPerformed(evt);
            }
        });
        jPanel5.add(SueFifthEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 204, 164, 30));

        SueSixthEnd.setEditable(false);
        SueSixthEnd.setText(" ");
        SueSixthEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSixthEndActionPerformed(evt);
            }
        });
        jPanel5.add(SueSixthEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 244, 164, 30));

        SueFourthTotal.setText(" ");
        SueFourthTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFourthTotalActionPerformed(evt);
            }
        });
        jPanel5.add(SueFourthTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 164, 98, 30));

        SueFifthTotal.setText(" ");
        SueFifthTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueFifthTotalActionPerformed(evt);
            }
        });
        jPanel5.add(SueFifthTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 204, 98, 30));

        SueSixthTotal.setText(" ");
        SueSixthTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SueSixthTotalActionPerformed(evt);
            }
        });
        jPanel5.add(SueSixthTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(461, 244, 98, 30));

        SueFourthRequest.setEditable(true);
        SueFourthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(SueFourthRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 165, 291, 30));

        SueFifthRequest.setEditable(true);
        SueFifthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(SueFifthRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 204, 291, 30));

        SueSixthRequest.setEditable(true);
        SueSixthRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(SueSixthRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 244, 291, 30));

        SueThirdCause.setEditable(true);
        SueThirdCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));
        jPanel5.add(SueThirdCause, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 124, 371, 29));

        SueFourthCause.setEditable(true);
        SueFourthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));
        jPanel5.add(SueFourthCause, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 163, 371, 29));

        SueFifthCause.setEditable(true);
        SueFifthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));
        jPanel5.add(SueFifthCause, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 203, 371, 29));

        SueSixthCause.setEditable(true);
        SueSixthCause.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "สอบพยานอีก 5 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 4 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 3 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 2 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "สอบพยานอีก 1 ปาก และรอผลการตรวจสอบพิมพ์มือผู้ต้องหา", "รอผลการตรวจสอบพิมพ์มือผู้ต้องหา" }));
        jPanel5.add(SueSixthCause, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 245, 371, 29));

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 86, 51, 31));

        jButton3.setText("3");
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 123, 51, 31));

        jButton4.setText("4");
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 163, 51, 31));

        jButton5.setText("6");
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 243, 51, 31));

        jButton6.setText("5");
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 203, 51, 31));

        jButton7.setText("7");
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 284, 51, 31));

        SevDate.setText(" ");
        jPanel5.add(SevDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 284, 199, 31));

        SixthDate.setText("  ");
        jPanel5.add(SixthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 243, 199, 31));

        FifthDate.setText(" ");
        jPanel5.add(FifthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 203, 199, 31));

        FourthDate.setText(" ");
        jPanel5.add(FourthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 163, 199, 31));

        ThirdDate.setText(" ");
        jPanel5.add(ThirdDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 123, 199, 31));

        SueSecDateT.setText(" ");
        jPanel5.add(SueSecDateT, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 86, 199, 31));

        jButtonSave.setText("บันทึก");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButton1.setText("พิมพ์เอกสาร");

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
                        .addGap(8, 8, 8)
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 625, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
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
                pst.setString(2,SueFirstDate.getText());
                pst.setString(3,SueFirstEnd.getText());
                pst.setString(4,SueFirstTotal.getText());
                pst.setString(5,SueFirstRequest.getSelectedItem().toString());
                pst.setString(6,SueFirstCause.getSelectedItem().toString());
                pst.setString(7,"2");
                pst.setString(8,SueSecDateT.getText());
                pst.setString(9,SueSecEnd.getText());
                pst.setString(10,SueSecTotal.getText());
                pst.setString(11,SueSecRequest.getSelectedItem().toString());
                pst.setString(12,SueSecCause.getSelectedItem().toString());
                pst.setString(13,"3");
                pst.setString(14,ThirdDate.getText());
                pst.setString(15,SueThirdEnd.getText());
                pst.setString(16,SueThirdTotal.getText());
                pst.setString(17,SueThirdRequest.getSelectedItem().toString());
                pst.setString(18,SueThirdCause.getSelectedItem().toString());
                pst.setString(19,"4");
                pst.setString(20,FourthDate.getText());
                pst.setString(21,SueFourthEnd.getText());
                pst.setString(22,SueFourthTotal.getText());
                pst.setString(23,SueFourthRequest.getSelectedItem().toString());
                pst.setString(24,SueFourthCause.getSelectedItem().toString());
                pst.setString(25,"5");
                pst.setString(26,FifthDate.getText());
                pst.setString(27,SueFifthEnd.getText());
                pst.setString(28,SueFifthTotal.getText());
                pst.setString(29,SueFifthRequest.getSelectedItem().toString());
                pst.setString(30,SueFifthCause.getSelectedItem().toString());
                pst.setString(31,"6");
                pst.setString(32,SixthDate.getText());
                pst.setString(33,SueSixthEnd.getText());
                pst.setString(34,SueSixthTotal.getText());
                pst.setString(35,SueSixthRequest.getSelectedItem().toString());
                pst.setString(36,SueSixthCause.getSelectedItem().toString());
                pst.setString(37,"7");
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
//    String dateS=SueFirstDate.getText();
//    String a=SueFirstTotal.getText();
//        System.out.println("ssssssssssssssssss :"+dateF+dateTot);
    int addDate=Integer.parseInt(DateTotal);
    Calendar cal=null;
    String Dateend=null;
    
        try{
            Locale lc = new Locale("th","TH");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = sdf.parse(DateStart);
                         cal = Calendar.getInstance();
                        cal.setTime(date);                      
                        cal.add(Calendar.DAY_OF_MONTH,addDate);
                        System.out.println("DateEnd : "+cal.getTime());
                        Dateend=sdf.format(cal.getTime());
            } catch(Exception e){
                System.out.println(e);
            }
           return Dateend;
    
    }
    public void DataCase(){
          try{          
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
//        String a=txtCaseNO.getText();
      
           String sql= "select CaseId,PeopleRegistrationID,PlaceArrest,ArrestDateTime,crimecasenoyear,AccureandOther,ChargeName,FullNamePerson,PeopleRegistrationID,SueTimes,SueDate,SuePersonId,SueCaseId from Sue\n"+
                           "left join Person on Sue.SuePersonId=Person.NoPerson\n"+
                           "left join CrimeCase on Person.CaseIdPerson=CrimeCase.CaseId\n"+
                          "left join Charge on CrimeCase.ChargeCodeCase=Charge.ChargeCode Where CaseIdPerson='"+caseid+"' and NoPerson='"+person+"'";
            ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
          if(rs.next()){
          
           crimecaseno.setText(rs.getString("crimecasenoyear"));
        PeopleRegistrationID.setText(rs.getString("PeopleRegistrationID"));
        AccureandOther.setText(rs.getString("AccureandOther"));
        FullNamePerson.setText(rs.getString("FullNamePerson"));
        ChargeName.setText(rs.getString("ChargeName"));
        PlaceArrest.setText(rs.getString("PlaceArrest"));
        DateArrest.setText(rs.getString("ArrestDateTime"));

          }
    
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
       public void DataLastSue(){
          try{          
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
//        String a=txtCaseNO.getText();
      
           String sql= "select max(suetimes) sueTime,SueDate,SueEnd,SueStart  from Sue where suecaseid='"+caseid+"' and suepersonid='"+person+"'";
            ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
          if(rs.next()){
          
           NumberImprison.setText(rs.getString("sueTime"));
        SueStartLast.setText(rs.getString("SueStart"));
        SueEndLast.setText(rs.getString("SueEnd"));
              SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
              String dateStart = rs.getString("SueEnd");
                 String dateStop = rs.getString("SueStart");
     

    Date date1 = myFormat.parse(dateStart);
    Date date2 = myFormat.parse(dateStop);
    long diff = date2.getTime() - date1.getTime();
//    System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
//    String total=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS;
//    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//    TotalDate.setText(sql);
          }
    
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
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
    private javax.swing.JTextField ChargeName;
    private javax.swing.JTextField DateArrest;
    private javax.swing.JTextField FifthDate;
    private javax.swing.JTextField FourthDate;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField NumberImprison;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PlaceArrest;
    private javax.swing.JTextField SevDate;
    private javax.swing.JTextField SixthDate;
    private javax.swing.JTextField SueEndLast;
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
    private javax.swing.JComboBox<String> SueFourthCause;
    private javax.swing.JTextField SueFourthEnd;
    private javax.swing.JComboBox<String> SueFourthRequest;
    private javax.swing.JTextField SueFourthTotal;
    private javax.swing.JComboBox<String> SueSecCause;
    private javax.swing.JTextField SueSecDateT;
    private javax.swing.JTextField SueSecEnd;
    private javax.swing.JComboBox<String> SueSecRequest;
    private javax.swing.JTextField SueSecTotal;
    private javax.swing.JComboBox<String> SueSevCause;
    private javax.swing.JComboBox<String> SueSevRequest;
    private javax.swing.JTextField SueSevenEnd;
    private javax.swing.JTextField SueSevenTotal;
    private javax.swing.JComboBox<String> SueSixthCause;
    private javax.swing.JTextField SueSixthEnd;
    private javax.swing.JComboBox<String> SueSixthRequest;
    private javax.swing.JTextField SueSixthTotal;
    private javax.swing.JTextField SueStartLast;
    private javax.swing.JComboBox<String> SueThirdCause;
    private javax.swing.JTextField SueThirdEnd;
    private javax.swing.JComboBox<String> SueThirdRequest;
    private javax.swing.JTextField SueThirdTotal;
    private javax.swing.JTextField ThirdDate;
    private javax.swing.JTextField TotalDate;
    private javax.swing.JTextField crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
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
