/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.CrimesCaseEdit.ChargeNameCase;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextAccused;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javafx.animation.Animation;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Locale;
import javax.swing.JRadioButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Computer
 */
public class SuspectForm extends javax.swing.JDialog {
    Connection con=null;
    Connection con2=null;
     PreparedStatement pst=null;
     boolean isInsert;
     String noPerson,caseid;
     JDatePickerImpl ArrestDateTime,IssueDate,ExpiredDate,BirthDay,RestoreDate,BailDate;
    /**
     * Creates new form AccusedForm
     */
    public SuspectForm(JFrame parrent,JSONObject datain) {
        super(parrent,true);     
        initComponents();  
            ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
//  ---------------------------------------------Date Filed----------------------------------------------
 UtilDateModel model = new UtilDateModel();
            model.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
         ArrestDateTime = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        ArrestDateTime.setTextEditable(true);
        ArrestDateTime.setBackground(Color.WHITE);
        jPanelDateArrest.setLayout(new FlowLayout());
        jPanelDateArrest.add(ArrestDateTime);  

        UtilDateModel model2 = new UtilDateModel();
            model2.setValue(Calendar.getInstance().getTime());
          JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         IssueDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
        IssueDate.setTextEditable(true);
        IssueDate.setBackground(Color.WHITE);
        jPanelIssueDate.setLayout(new FlowLayout());
        jPanelIssueDate.add(IssueDate); 
        
        UtilDateModel model3 = new UtilDateModel();
            model3.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p);
         ExpiredDate = new JDatePickerImpl(datePanel3,new DateLabelFormatter());
        ExpiredDate.setTextEditable(true);
        ExpiredDate.setBackground(Color.WHITE);
        jPanelExpiredDate.setLayout(new FlowLayout());
        jPanelExpiredDate.add(ExpiredDate);
//       
            UtilDateModel model4 = new UtilDateModel();
            model4.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel4 = new JDatePanelImpl(model4, p);
         BirthDay = new JDatePickerImpl(datePanel4,new DateLabelFormatter());
        BirthDay.setTextEditable(true);
        BirthDay.setBackground(Color.WHITE);
        jPanelBirthDay.setLayout(new FlowLayout());
        jPanelBirthDay.add(BirthDay);
//        
        UtilDateModel model5 = new UtilDateModel();
            model5.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel5 = new JDatePanelImpl(model5, p);
         RestoreDate = new JDatePickerImpl(datePanel5,new DateLabelFormatter());
        RestoreDate.setTextEditable(true);
        RestoreDate.setBackground(Color.WHITE);
        jPanelRestoreDate.setLayout(new FlowLayout());
        jPanelRestoreDate.add(RestoreDate);
        
           UtilDateModel model6 = new UtilDateModel();
            model6.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel6 = new JDatePanelImpl(model6, p);
         BailDate = new JDatePickerImpl(datePanel6,new DateLabelFormatter());
        BailDate.setTextEditable(true);
        BailDate.setBackground(Color.WHITE);
        jPanelBailDate.setLayout(new FlowLayout());
        jPanelBailDate.add(BailDate);
 //  ---------------------------------------------Date Filed----------------------------------------------
        
//        knowSuspect();
//        jRadioUnknowSuspect.setSelected(true);
//        if(jRadioUnknowSuspect.isSelected()){
//            PeopleRegistrationID.setEnabled(false);
//            FullNamePerson.setEnabled(false);
//            IssueDate.setEnabled(false);
//            OtherName.setEnabled(false);
//        }

        colseTextBox();
        
        

         ButtonGroup kno=new ButtonGroup();
        kno.add(jRadioUnknowSuspect);
        kno.add(jRadioKnowSuspect);
        
             ButtonGroup g=new ButtonGroup();
        g.add(jRadioSue);
        g.add(jRadioBail);
        g.add(jRadioResultImprison);
        g.add(jRadioResultRelease);
        g.add(jRadioCantCatch);
        g.add(jRadioVerbal);
        g.add(jRadioRestore);
        g.add(jRadioCatch);
        g.add(jRadioOther);
        
       
        
//             ArrestDateTimeEnd.setText(CalculateDateTime48(arrestDate));
 ArrestDateTime.getJFormattedTextField().getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                               
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
            String arrestTime = formatTime.format(jSpinnerArrTime.getValue());
            String arrestDate=ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime;
            
            CalculateDateTime48(arrestDate);
                                 ArrestDateTimeEnd.setText(CalculateDateTime48(arrestDate));
                           }
                           public void removeUpdate(DocumentEvent e) {
                                                  
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
            String arrestTime = formatTime.format(jSpinnerArrTime.getValue());
            String arrestDate=ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime;
            
            CalculateDateTime48(arrestDate);
                                 ArrestDateTimeEnd.setText(CalculateDateTime48(arrestDate));

                           }
                           public void insertUpdate(DocumentEvent e) {
                                                  
            SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
            String arrestTime = formatTime.format(jSpinnerArrTime.getValue());
            String arrestDate=ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime;
            
            CalculateDateTime48(arrestDate);
                                ArrestDateTimeEnd.setText(CalculateDateTime48(arrestDate));

                           }
             }
             );
 jSpinnerArrTime.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
           SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm");
            String arrestTime = formatTime.format(jSpinnerArrTime.getValue());
            String arrestDate=ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime;
            
            CalculateDateTime48(arrestDate);
                                ArrestDateTimeEnd.setText(CalculateDateTime48(arrestDate));

        }
    });

          if(datain!=null){
           eventJButtonManage();
            isInsert=false;
            String statusSus;
            statusSus=datain.get("StatusSuspect")+"";
            caseid=datain.get("caseIdPerson")+"";
            noPerson=datain.get("NoPerson")+"";
            crimecaseno.setText(datain.get("caseIdPerson")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            String known=datain.get("FullNamePerson")+"";
            if(known.equals("ไม่รู้ตัว")){
            jRadioUnknowSuspect.setSelected(true);
            }
            FullNamePerson.setText(datain.get("FullNamePerson")+"");
            Age.setText(datain.get("Age")+"");
            Amphur.setText(datain.get("Amphur")+"");
            BirthDay.getJFormattedTextField().setText(datain.get("BirthDay")+"");
            BloodGroup.setText(datain.get("BloodGroup")+"");
            ExpiredDate.getJFormattedTextField().setText(datain.get("ExpiredDate")+"");
            FatherFullName.setText(datain.get("FatherFullName")+"");
            FullNamePersonEn.setText(datain.get("FullNamePersonEn")+"");
            Height.setText(datain.get("Height")+"");
            Weight.setText(datain.get("Weight")+"");
            HouseNumber.setText(datain.get("HouseNumber")+"");
            IssueDate.getJFormattedTextField().setText(datain.get("IssueDate")+"");
            Moo.setText(datain.get("Moo")+"");
            MotherFullName.setText(datain.get("MotherFullName")+"");
            Nationality.setText(datain.get("Nationality")+"");
            Occupation.setText(datain.get("Occupation")+"");
            PassportNumber.setText(datain.get("PassportNumber")+"");
            Province.setText(datain.get("Province")+"");
            Race.setText(datain.get("Race")+"");
            Religion.setText(datain.get("Religion")+"");
            Tambon.setText(datain.get("Tambon")+"");
            Religion.setText(datain.get("Religion")+"");
            SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            String DateArr=datain.get("ArrestDateTime")+"";
            Date d=null;
            try{
             d=format.parse(DateArr);}
            catch(Exception e){
            
            }
            ArrestDateTime.getJFormattedTextField().setText(format.format(d));
            PlaceArrest.setText(datain.get("PlaceArrest")+"");
            if(statusSus.equals("ผัดฟ้องฝากขัง")){
            jRadioSue.setSelected(true);
         
            }
             else if(statusSus.equals("ประกัน")){
              jRadioBail.setSelected(true);
              
                }
                else if(statusSus.equals("แจ้งข้อหาฝากขัง")){
             jRadioResultImprison.setSelected(true);
   
                }
                else if(statusSus.equals("แจ้งข้อหาปล่อยตัว")){
             jRadioResultRelease.setSelected(true);
   
                }
                else if(statusSus.equals("ไม่ได้ตัว")){
             jRadioCantCatch.setSelected(true);
   
                }
              else if(statusSus.equals("ฟ้องวาจา")){
             jRadioVerbal.setSelected(true);
   
                }
              else if(statusSus.equals("ส่งฟื้นฟู")){
             jRadioRestore.setSelected(true);
   
                } 
              else if(statusSus.equals("อายัดตัว")){
             jRadioCatch.setSelected(true);
   
                }   
              else if(statusSus.equals("อื่นๆ")){
             jRadioOther.setSelected(true);
   
                }  
                   

        }else{
            eventJRadioManage();
           crimecaseno.setText(ListSuspect.txtCaseNO.getText());
            isInsert=true;
    
        }
         
      
    }

    SuspectForm(ListAccused aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        BtSaveAccused = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PeopleRegistrationID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FullNamePerson = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        OtherName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FullNamePersonEn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PassportNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Nationality = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Race = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Religion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Weight = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        BloodGroup = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        Occupation = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        FatherFullName = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        MotherFullName = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        PhonePerson = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jRadioUnknowSuspect = new javax.swing.JRadioButton();
        jRadioKnowSuspect = new javax.swing.JRadioButton();
        jPanelIssueDate = new javax.swing.JPanel();
        jPanelExpiredDate = new javax.swing.JPanel();
        jPanelBirthDay = new javax.swing.JPanel();
        CourtSuspect = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jRadioRestore = new javax.swing.JRadioButton();
        jRadioVerbal = new javax.swing.JRadioButton();
        jRadioCatch = new javax.swing.JRadioButton();
        jRadioOther = new javax.swing.JRadioButton();
        jRadioSue = new javax.swing.JRadioButton();
        jRadioBail = new javax.swing.JRadioButton();
        jRadioResultImprison = new javax.swing.JRadioButton();
        jRadioResultRelease = new javax.swing.JRadioButton();
        jRadioCantCatch = new javax.swing.JRadioButton();
        jLabelArrestPlace = new javax.swing.JLabel();
        PlaceArrest = new javax.swing.JTextField();
        jLabelArrestDate = new javax.swing.JLabel();
        jLabelRestoreDate = new javax.swing.JLabel();
        jButtonSue2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jButtonInsu2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanelDateArrest = new javax.swing.JPanel();
        jLabelArrTime = new javax.swing.JLabel();
        Date date=new Date();

        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        jSpinnerArrTime = new javax.swing.JSpinner(sm);
        jPanelRestoreDate = new javax.swing.JPanel();
        jPanelBailDate = new javax.swing.JPanel();
        jLabelBailDate = new javax.swing.JLabel();
        jLabelArrestEnd = new javax.swing.JLabel();
        ArrestDateTimeEnd = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        HouseNumber = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Moo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Tambon = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Amphur = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        Province = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        ZipCode = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        ZipCode1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Gender1 = new javax.swing.JComboBox<>();
        ZipCode2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1180, 700));

        BtSaveAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        BtSaveAccused.setText("บันทึก");
        BtSaveAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveAccusedActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(46, 156, 202));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ข้อมูลผู้ต้องหา");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(46, 156, 202));

        jLabel31.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ข้อมูลผู้ต้องหา");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(276, 276, 276))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ชื่อภาษาอังกฤษ");

        FullNamePersonEn.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เลขหนังสือเดินทาง");

        PassportNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("วันเกิด");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("อายุ");

        Age.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        Age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AgeKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("สัญชาติ");

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("เชื้อชาติ");

        Race.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("ศาสนา");

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("สูง");

        Height.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("น้ำหนัก");

        Weight.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("หมู่โลหิต");

        BloodGroup.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("เพศ");

        Gender.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "หญิง", "ชาย", "ไม่ระบุ" }));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("อาชีพ");

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("ชื่อบิดา");

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel29.setText("ชื่อมารดา");

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setText("หมายเลขโทรศัพท์");

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel37.setText("ผู้ต้องหา");

        jRadioUnknowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioUnknowSuspect.setText("ไม่รู้ตัว");

        jRadioKnowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioKnowSuspect.setText("รู้ตัว");

        javax.swing.GroupLayout jPanelIssueDateLayout = new javax.swing.GroupLayout(jPanelIssueDate);
        jPanelIssueDate.setLayout(jPanelIssueDateLayout);
        jPanelIssueDateLayout.setHorizontalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );
        jPanelIssueDateLayout.setVerticalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelExpiredDateLayout = new javax.swing.GroupLayout(jPanelExpiredDate);
        jPanelExpiredDate.setLayout(jPanelExpiredDateLayout);
        jPanelExpiredDateLayout.setHorizontalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelExpiredDateLayout.setVerticalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelBirthDayLayout = new javax.swing.GroupLayout(jPanelBirthDay);
        jPanelBirthDay.setLayout(jPanelBirthDayLayout);
        jPanelBirthDayLayout.setHorizontalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        jPanelBirthDayLayout.setVerticalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        CourtSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtSuspect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลแขวง", "ศาลอาญา", "อุจฉกรรจ์" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioUnknowSuspect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioKnowSuspect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CourtSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7))
                                .addGap(12, 12, 12)
                                .addComponent(jPanelIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel11))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FullNamePersonEn, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                    .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanelBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MotherFullName))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PhonePerson))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(59, 59, 59)
                                .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Occupation)
                            .addComponent(Religion))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CourtSuspect, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRadioUnknowSuspect)
                        .addComponent(jRadioKnowSuspect)))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel6))
                            .addComponent(jPanelIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel18)
                                .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Occupation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)
                                .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(MotherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanelBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PhonePerson.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(46, 156, 202));

        jLabel28.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("การจัดการผู้ต้องหา");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(174, 174, 174))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jRadioRestore.setBackground(new java.awt.Color(255, 255, 255));
        jRadioRestore.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioRestore.setText("ส่งฟื้นฟู");

        jRadioVerbal.setBackground(new java.awt.Color(255, 255, 255));
        jRadioVerbal.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioVerbal.setText("ฟ้องวาจา");

        jRadioCatch.setBackground(new java.awt.Color(255, 255, 255));
        jRadioCatch.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioCatch.setText("อายัดตัว");

        jRadioOther.setBackground(new java.awt.Color(255, 255, 255));
        jRadioOther.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioOther.setText("อื่นๆ");

        jRadioSue.setBackground(new java.awt.Color(255, 255, 255));
        jRadioSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioSue.setText("ผัดฟ้องฝากขัง");

        jRadioBail.setBackground(new java.awt.Color(255, 255, 255));
        jRadioBail.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioBail.setText("ประกัน");

        jRadioResultImprison.setBackground(new java.awt.Color(255, 255, 255));
        jRadioResultImprison.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioResultImprison.setText("แจ้งข้อหาฝากขัง");

        jRadioResultRelease.setBackground(new java.awt.Color(255, 255, 255));
        jRadioResultRelease.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioResultRelease.setText("แจ้งข้อหาปล่อยตัว");

        jRadioCantCatch.setBackground(new java.awt.Color(255, 255, 255));
        jRadioCantCatch.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioCantCatch.setText("ไม่ได้ตัว");

        jLabelArrestPlace.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestPlace.setText("สถานที่จับกุม");

        jLabelArrestDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestDate.setText("วันที่จับกุม");

        jLabelRestoreDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelRestoreDate.setText("วันที่ส่งฟื้นฟู");

        jButtonSue2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSue2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSue2MouseClicked(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel36.setText("ผัดฟ้องฝากขัง");

        javax.swing.GroupLayout jButtonSue2Layout = new javax.swing.GroupLayout(jButtonSue2);
        jButtonSue2.setLayout(jButtonSue2Layout);
        jButtonSue2Layout.setHorizontalGroup(
            jButtonSue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonSue2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addContainerGap())
        );
        jButtonSue2Layout.setVerticalGroup(
            jButtonSue2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jButtonInsu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonInsu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonInsu2MouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel38.setText("ประกัน");

        javax.swing.GroupLayout jButtonInsu2Layout = new javax.swing.GroupLayout(jButtonInsu2);
        jButtonInsu2.setLayout(jButtonInsu2Layout);
        jButtonInsu2Layout.setHorizontalGroup(
            jButtonInsu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonInsu2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel38)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jButtonInsu2Layout.setVerticalGroup(
            jButtonInsu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPanelDateArrest.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanelDateArrestLayout = new javax.swing.GroupLayout(jPanelDateArrest);
        jPanelDateArrest.setLayout(jPanelDateArrestLayout);
        jPanelDateArrestLayout.setHorizontalGroup(
            jPanelDateArrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanelDateArrestLayout.setVerticalGroup(
            jPanelDateArrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabelArrTime.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrTime.setText("เวลา");

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jSpinnerArrTime, "HH:mm");
        jSpinnerArrTime.setEditor(timeEditor);
        jSpinnerArrTime.setPreferredSize(new java.awt.Dimension(29, 25));

        javax.swing.GroupLayout jPanelRestoreDateLayout = new javax.swing.GroupLayout(jPanelRestoreDate);
        jPanelRestoreDate.setLayout(jPanelRestoreDateLayout);
        jPanelRestoreDateLayout.setHorizontalGroup(
            jPanelRestoreDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );
        jPanelRestoreDateLayout.setVerticalGroup(
            jPanelRestoreDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelBailDateLayout = new javax.swing.GroupLayout(jPanelBailDate);
        jPanelBailDate.setLayout(jPanelBailDateLayout);
        jPanelBailDateLayout.setHorizontalGroup(
            jPanelBailDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );
        jPanelBailDateLayout.setVerticalGroup(
            jPanelBailDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabelBailDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelBailDate.setText("วันประกัน");

        jLabelArrestEnd.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestEnd.setText("วัน-เวลาที่สิ้นสุด");

        ArrestDateTimeEnd.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jRadioSue)
                        .addGap(0, 0, 0)
                        .addComponent(jRadioBail, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jRadioResultImprison)
                        .addGap(0, 0, 0)
                        .addComponent(jRadioResultRelease))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jRadioCantCatch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jRadioVerbal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jRadioRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jRadioCatch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jRadioOther, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonSue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInsu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabelArrestPlace)
                            .addGap(11, 11, 11)
                            .addComponent(PlaceArrest))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabelArrestEnd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ArrestDateTimeEnd))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabelArrestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(jPanelDateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(10, 10, 10)
                            .addComponent(jLabelArrTime)
                            .addGap(18, 18, 18)
                            .addComponent(jSpinnerArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelBailDate, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelBailDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioSue)
                    .addComponent(jRadioBail)
                    .addComponent(jRadioResultImprison)
                    .addComponent(jRadioResultRelease))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioCantCatch)
                    .addComponent(jRadioVerbal)
                    .addComponent(jRadioRestore))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioCatch)
                    .addComponent(jRadioOther))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSue2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelArrestPlace)
                    .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelArrestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelArrestEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(ArrestDateTimeEnd))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBailDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelBailDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("บ้านเลขที่");

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("หมู่ที่");

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("เขต/อำเภอ");

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("จังหวัด");

        Province.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");

        ZipCode.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZipCodeKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel32.setText("เคยต้องโทษ");

        ZipCode1.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel33.setText("ผู้ต้องหาให้การ");

        Gender1.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Gender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "รับสารภาพ", "ปฏิเสธ", "ภาคเสธ" }));

        ZipCode2.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel34.setText("ตำหนิรูปพรรณ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel30))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ZipCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Gender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ZipCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtSaveAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtSaveAccused)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel24)
                            .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(ZipCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(Gender1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ZipCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(123, 123, 123))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSaveAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveAccusedActionPerformed
        // TODO add your handling code here:
        con=ConnectDatabase.connect();
         SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String arrestTime = format.format(jSpinnerArrTime.getValue());
    
        if(isInsert){
            String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
            "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
            "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,StatusSuspect,caseIdPerson,ArrestDateTime,PlaceArrest,CourtSuspect,BailDate,ArrestDateTimeEnd)\n"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//           String sqlSueFirst="insert into sue (SueTimes,SueDate,)";
            System.out.println("SQL : "+sql);
            try {
                pst=con.prepareStatement(sql);
                pst.setString(1,Age.getText());
                pst.setString(2,Amphur.getText());
                pst.setString(3,BirthDay.getJFormattedTextField().getText());
                pst.setString(4,BloodGroup.getText());
                pst.setString(5,ExpiredDate.getJFormattedTextField().getText());
                pst.setString(6,FatherFullName.getText());
                if(jRadioUnknowSuspect.isSelected()){
               pst.setString(7,"ไม่รู้ตัว");             
                }else{
               pst.setString(7,FullNamePerson.getText());}
                
                pst.setString(8,FullNamePersonEn.getText());
                pst.setString(9,Gender.getSelectedItem().toString());
                pst.setString(10,Height.getText());
                pst.setString(11,HouseNumber.getText());
                pst.setString(12,IssueDate.getJFormattedTextField().getText());
                pst.setString(13,Moo.getText());
                pst.setString(14,MotherFullName.getText());
                pst.setString(15,Nationality.getText());
                pst.setString(16,Occupation.getText());
                pst.setString(17,OtherName.getText());
                pst.setString(18,PassportNumber.getText());
                pst.setString(19,PeopleRegistrationID.getText());
                pst.setString(20,PhonePerson.getText());
                pst.setString(21,Province.getText());
                pst.setString(22,Race.getText());
                pst.setString(23,Religion.getText());
                pst.setString(24,Tambon.getText());
                pst.setString(25,"ผู้ต้องหา");
                pst.setString(26,Weight.getText());
                pst.setString(27,ZipCode.getText());
          
                if(jRadioSue.isSelected()){ 
                    pst.setString(28,"ผัดฟ้องฝากขัง");       
                    
                }
                else if(jRadioBail.isSelected()){
                        pst.setString(28,"ประกัน");   
                }
                else if(jRadioResultImprison.isSelected()){
                        pst.setString(28,"แจ้งข้อหาฝากขัง");   
                }
                else if(jRadioResultRelease.isSelected()){
                        pst.setString(28,"แจ้งข้อหาปล่อยตัว");   
                }
                else if(jRadioCantCatch.isSelected()){
                        pst.setString(28,"ไม่ได้ตัว");   
                }

                else if(jRadioVerbal.isSelected()){
                        pst.setString(28,"ฟ้องวาจา");   
                }
                else if(jRadioRestore.isSelected()){
                        pst.setString(28,"ส่งฟื้นฟู");   
                }
                else if(jRadioCatch.isSelected()){
                        pst.setString(28,"อายัดตัว");   
                }
                 else if(jRadioOther.isSelected()){
                         pst.setString(28,"อื่นๆ");   
                }   
                pst.setString(29,crimecaseno.getText());
//                pst.setString(30,BailDate.getText());
                pst.setString(30,ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime);
                pst.setString(31,PlaceArrest.getText());
                pst.setString(32,CourtSuspect.getSelectedItem().toString());
                pst.setString(33,BailDate.getJFormattedTextField().getText());
                pst.setString(34,ArrestDateTimeEnd.getText());

               int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            pst.executeUpdate();             
                             pst.close();
                             System.out.println("SQL : "+sql);
                        } 
               
            } catch (Exception e) {
              JOptionPane.showMessageDialog(jPanel1, "Cannaot Save" ,null, JOptionPane.INFORMATION_MESSAGE);

                System.out.println("SQL : "+pst);
            }
        }
        else{
            String sqlUpdate="Update Person set "
                    + "Age=?,"
                    + "Amphur=?,"
                    + "BirthDay=?,\n" 
                    + "BloodGroup=?,"
                    + "ExpiredDate=?,"
                    + "FatherFullName=?,"
                    + "FullNamePerson=?,"
                    + "FullNamePersonEn=?,\n" 
                    +  "Gender=?,"
                    + "Height=?,"
                    + "HouseNumber=?,"
                    + "IssueDate=?,"
                    + "Moo=?,"
                    + "MotherFullName=?,"
                    + "Nationality=?,"
                    + "Occupation=?,\n"
                    + "OtherName=?,"
                    + "PassportNumber=?,"
                    + "PeopleRegistrationID=?,"
                    + "PhonePerson=?,"
                    + "Province=?,"
                    + "Race=?,"
                    + "Religion=?,\n" 
                    + "Tambon=?,"
                    + "TypePerson=?,"
                    + "Weight=?,"
                    + "ZipCode=? ,"
                    + "caseIdPerson=?,"
                    + "CourtSuspect=?,"    
                    + "ArrestDateTime=?,"
                    + "BailDate=?,"
                    + "ArrestDateTimeEnd=?,"

                    + "StatusSuspect=? where NoPerson=? and TypePerson=?   ";

            try {
                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,Age.getText());
                pst.setString(2,Amphur.getText());
                pst.setString(3,BirthDay.getJFormattedTextField().getText());
                pst.setString(4,BloodGroup.getText());
                pst.setString(5,ExpiredDate.getJFormattedTextField().getText());
                pst.setString(6,FatherFullName.getText());
                pst.setString(7,FullNamePerson.getText());
                pst.setString(8,FullNamePersonEn.getText());
                pst.setString(9,Gender.getSelectedItem().toString());
                pst.setString(10,Height.getText());
                pst.setString(11,HouseNumber.getText());
                pst.setString(12,IssueDate.getJFormattedTextField().getText());
                pst.setString(13,Moo.getText());
                pst.setString(14,MotherFullName.getText());
                pst.setString(15,Nationality.getText());
                pst.setString(16,Occupation.getText());
                pst.setString(17,OtherName.getText());
                pst.setString(18,PassportNumber.getText());
                pst.setString(19,PeopleRegistrationID.getText());
                pst.setString(20,PhonePerson.getText());
                pst.setString(21,Province.getText());
                pst.setString(22,Race.getText());
                pst.setString(23,Religion.getText());
                pst.setString(24,Tambon.getText());
                pst.setString(25,"ผู้ต้องหา");
                pst.setString(26,Weight.getText());
                pst.setString(27,ZipCode.getText());
                pst.setString(28,crimecaseno.getText());
                pst.setString(29,CourtSuspect.getSelectedItem().toString());
                pst.setString(30,ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime);
                pst.setString(31,BailDate.getJFormattedTextField().getText()+" "+arrestTime);
                pst.setString(32,ArrestDateTimeEnd.getText());

                  if(jRadioSue.isSelected()){ 
                    pst.setString(33,"ผัดฟ้องฝากขัง");       
                    
                }
                else if(jRadioBail.isSelected()){
                        pst.setString(33,"ประกัน");   
                }
                else if(jRadioResultImprison.isSelected()){
                        pst.setString(33,"แจ้งข้อหาฝากขัง");   
                }
                else if(jRadioResultRelease.isSelected()){
                        pst.setString(33,"แจ้งข้อหาปล่อยตัว");   
                }
                else if(jRadioCantCatch.isSelected()){
                        pst.setString(33,"ไม่ได้ตัว");   
                }

                else if(jRadioVerbal.isSelected()){
                        pst.setString(33,"ฟ้องวาจา");   
                }
                else if(jRadioRestore.isSelected()){
                        pst.setString(33,"ส่งฟื้นฟู");   
                }
                else if(jRadioCatch.isSelected()){
                        pst.setString(33,"อายัดตัว");   
                }
                 else if(jRadioOther.isSelected()){
                         pst.setString(33,"อื่นๆ");   
                }   
                pst.setString(34,noPerson);
              
                pst.setString(35,"ผู้ต้องหา");
                                         
                        int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            pst.executeUpdate();             
                             pst.close();
                             System.out.println("SQL : "+sqlUpdate);
                        } 
               
//                System.out.println("SQL : "+sqlUpdate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }

        }

        setVisible(false);
    }//GEN-LAST:event_BtSaveAccusedActionPerformed

    private void PeopleRegistrationIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PeopleRegistrationIDKeyTyped
     char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
         if(PeopleRegistrationID.getText().length()>=13) {  
           evt.consume();
 }        // TODO add your handling code here:
    }//GEN-LAST:event_PeopleRegistrationIDKeyTyped

    private void AgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AgeKeyTyped
         char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }// TODO add your handling code here:
    }//GEN-LAST:event_AgeKeyTyped

    private void ZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZipCodeKeyTyped
  char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }  
             if(ZipCode.getText().length()>=13) {  
           evt.consume();
 }  // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeKeyTyped

    private void jButtonInsu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInsu2MouseClicked
        // TODO add your handling code here:
        String idCase=crimecaseno.getText();
        String InsuName=FullNamePerson.getText();

        JSONObject s = new JSONObject();
        s.put("InsuCaseId",idCase );
        s.put("InsuName",InsuName );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        BailCrimesAdd sa=new BailCrimesAdd(fwit, s);
        sa.pack();
        sa.setLocationRelativeTo(null);
        sa.setVisible(true);
    }//GEN-LAST:event_jButtonInsu2MouseClicked

    private void jButtonSue2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSue2MouseClicked
        // TODO add your handling code here:
        try{
            Connection con = ConnectDatabase.connect();
            Statement stmt = con.createStatement();
            //        String a=txtCaseNO.getText();

            String sql= "select CaseId,PeopleRegistrationID,crimecasenoyear,AccureandOther,ChargeName,FullNamePerson,SueTimes,SueDate,SuePersonId,SueCaseId from Sue\n"+
            "left join Person on Sue.SuePersonId=Person.NoPerson\n"+
            "left join CrimeCase on Person.CaseIdPerson=CrimeCase.CaseId\n"+
            "left join Charge on CrimeCase.ChargeCodeCase=Charge.ChargeCode Where CaseIdPerson='"+caseid+"' and NoPerson='"+noPerson+"'";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("SQL : "+sql);
            JSONObject data = new JSONObject();
            data.put("CaseId", rs.getString("CaseId"));
            data.put("crimecasenoyear", rs.getString("crimecasenoyear"));
            data.put("AccureandOther", rs.getString("AccureandOther"));
            data.put("ChargeName", rs.getString("ChargeName"));
            data.put("FullNamePerson", rs.getString("FullNamePerson"));
            data.put("PeopleRegistrationID", rs.getString("PeopleRegistrationID"));
            data.put("SueCaseId", rs.getString("SueCaseId"));
            data.put("SuePersonId", rs.getString("SuePersonId"));

            JFrame frame = new JFrame();
            JDialog dialog = new JDialog(frame);//frame is owner
            JFrame fwit = (JFrame)(dialog.getParent());
            fwit.removeAll();
            SueCrimesFrom scf =new SueCrimesFrom(fwit,data);
            scf.pack();
            scf.setLocationRelativeTo(null);
            scf.setVisible(true);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        //                 String idCase=crimecaseno.getText();
        //
        //                JSONObject s = new JSONObject();
        //                s.put("SueCaseId",idCase );
        //                s.put("SuePersonId",noPerson );
        //
        //                JFrame frame = new JFrame();
        //                JDialog dialog = new JDialog(frame);//frame is owner
        //                JFrame fwit = (JFrame)(dialog.getParent());
        //                fwit.removeAll();
        //                SueCrimesFrom sa=new SueCrimesFrom(fwit, s);
        //                sa.setVisible(true);
    }//GEN-LAST:event_jButtonSue2MouseClicked
  public void eventJButtonManage(){
     
     jRadioSue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioSue.isSelected()){
    PlaceArrest.setVisible(true);
                  jLabelArrestPlace.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);
                 jLabelArrestEnd.setVisible(true);
            ArrestDateTimeEnd.setVisible(true);
            
            }
            else{
                   PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
                jPanelDateArrest.setVisible(false);
                jLabelArrestDate.setVisible(false);
                
              jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
                 jLabelArrestEnd.setVisible(false);
            ArrestDateTimeEnd.setVisible(false);  
            }
            }
        }
        );
      jRadioBail.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioBail.isSelected()){ 
                      PlaceArrest.setVisible(true);
                  jLabelArrestPlace.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);   
             jLabelBailDate.setVisible(true);
            jPanelBailDate.setVisible(true);   
                jLabelArrestEnd.setVisible(true);
            ArrestDateTimeEnd.setVisible(true);
         
            }
            else{               
               jLabelBailDate.setVisible(false);
            jPanelBailDate.setVisible(false);  
           PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
                jPanelDateArrest.setVisible(false);
                jLabelArrestDate.setVisible(false);
                   jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
                 jLabelArrestEnd.setVisible(false);
            ArrestDateTimeEnd.setVisible(false);  
    
            }
            }
        }
        );


  
  }   
    
    public void eventJRadioManage(){

//jRadioSue.addActionListener ( new ActionListener ( ) 
//     { 
//          @Override 
//          public void actionPerformed ( ActionEvent event ) 
//          { 
//               JRadioButton radioButton = ( JRadioButton ) event.getSource ( ); 
//
//               boolean isSelected = jRadioSue.isSelected (); 
//
//               if ( isSelected ) 
//               { 
//                                      PlaceArrest.setVisible(true);
//                  jLabelArrestPlace.setVisible(true);
//            jPanelDateArrest.setVisible(true);
//            jLabelArrestDate.setVisible(true);
//            jLabelArrTime.setVisible(true);
//            jSpinnerArrTime.setVisible(true);
//                 jLabelArrestEnd.setVisible(true);
//            ArrestDateTimeEnd.setVisible(true);
//               } 
//               else 
//               { 
//                  PlaceArrest.setVisible(false);
//                  jLabelArrestPlace.setVisible(false);
//                jPanelDateArrest.setVisible(false);
//                jLabelArrestDate.setVisible(false);
//                
//              jLabelArrTime.setVisible(false);
//            jSpinnerArrTime.setVisible(false);
//                 jLabelArrestEnd.setVisible(false);
//            ArrestDateTimeEnd.setVisible(false); 
//               } 
//          } 
//     } 
//);
//jRadioBail.addActionListener ( new ActionListener ( ) 
//     { 
//          @Override 
//          public void actionPerformed ( ActionEvent event ) 
//          { 
//               JRadioButton radioButton = ( JRadioButton ) event.getSource ( ); 
//
//               boolean isSelected = jRadioBail.isSelected (); 
//
//               if ( isSelected ) 
//               { 
//                                      PlaceArrest.setVisible(true);
//                  jLabelArrestPlace.setVisible(true);
//            jPanelDateArrest.setVisible(true);
//            jLabelArrestDate.setVisible(true);
//            jLabelArrTime.setVisible(true);
//            jSpinnerArrTime.setVisible(true);
//                 jLabelArrestEnd.setVisible(true);
//            ArrestDateTimeEnd.setVisible(true);
//               } 
//               else 
//               { 
//                  PlaceArrest.setVisible(false);
//                  jLabelArrestPlace.setVisible(false);
//                jPanelDateArrest.setVisible(false);
//                jLabelArrestDate.setVisible(false);
//                
//              jLabelArrTime.setVisible(false);
//            jSpinnerArrTime.setVisible(false);
//                 jLabelArrestEnd.setVisible(false);
//            ArrestDateTimeEnd.setVisible(false); 
//               } 
//          } 
//     } 
//);
       jRadioSue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioSue.isSelected()){
                  PlaceArrest.setVisible(true);
                  jLabelArrestPlace.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);
                 jLabelArrestEnd.setVisible(true);
            ArrestDateTimeEnd.setVisible(true);
            
            }
            else {
                  PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
                jPanelDateArrest.setVisible(false);
                jLabelArrestDate.setVisible(false);
                
              jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
                 jLabelArrestEnd.setVisible(false);
            ArrestDateTimeEnd.setVisible(false);

            }

            }
        }
        );
      
   jRadioBail.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioBail.isSelected()){ 
               PlaceArrest.setVisible(true);
                  jLabelArrestPlace.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);   
             jLabelBailDate.setVisible(true);
            jPanelBailDate.setVisible(true);   
                jLabelArrestEnd.setVisible(true);
            ArrestDateTimeEnd.setVisible(true);
            
            }
            else{
            jLabelBailDate.setVisible(false);
            jPanelBailDate.setVisible(false);  
           PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
                jPanelDateArrest.setVisible(false);
                jLabelArrestDate.setVisible(false);
                   jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
                 jLabelArrestEnd.setVisible(false);
            ArrestDateTimeEnd.setVisible(false);
              }
            }
        }
        );
       

               }
    public void colseTextBox(){
//    RestoreDate.setVisible(false);  
    jLabelRestoreDate.setVisible(false); 
    jButtonSue2.setVisible(false); 
    jButtonInsu2.setVisible(false);  
        jLabelArrTime.setVisible(false);
    jLabelArrestDate.setVisible(false);
     jLabelArrestPlace.setVisible(false);
     jPanelDateArrest.setVisible(false);
    jSpinnerArrTime.setVisible(false);          
    PlaceArrest.setVisible(false); 
    jPanelRestoreDate.setVisible(false);
     jLabelBailDate.setVisible(false);
     
            jPanelBailDate.setVisible(false);   
            jLabelArrestEnd.setVisible(false);
            ArrestDateTimeEnd.setVisible(false);
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
            java.util.logging.Logger.getLogger(SuspectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuspectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuspectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuspectForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        DataCase dcc=new DataCase();
//        labelCaseNo.setText("dfv");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//             AccusedForm aa=  new AccusedForm();
//                    aa.setVisible(true);
//                    aa.setSize ( 1024, 728 );
//                    aa.setMinimumSize ( new Dimension ( 1024, 728 ) );
//                    aa.setMaximizedBounds ( new Rectangle ( 1024, 728 ) );
      SuspectForm aa=  new SuspectForm(null,null);
     
            }
        });
    }
  public static String IdCase(){
         Connection c=null;
         c=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=c.createStatement();
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
   public static String IdPerson(){
         Connection cc=null;
         cc=ConnectDatabase.connect();
            String sqlperson="Select max(NoPerson) noperson from Person";
        int id=0;
        try {
            Statement s=cc.createStatement();
            ResultSet rs=s.executeQuery(sqlperson);
            
            if (rs.next()) {
                id=rs.getInt("noperson"); 
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
   public String CalculateDateTime48(String DateArrest){
      String ArrestEnd="";   
      Calendar cal;
       try{
     
               Locale lc = new Locale("th","TH");
                        SimpleDateFormat  format = new SimpleDateFormat("dd/MM/yyyy HH:mm",lc);  
                        Date dateArrest=null;
                          dateArrest=format.parse(DateArrest);
                        cal = Calendar.getInstance();
                        cal.setTime(dateArrest);                      
                        cal.add(Calendar.HOUR, +48);
                         ArrestEnd= format.format(cal.getTime());
                        System.out.println("Date48Hr : "+ArrestEnd);
                            
                    
       }catch(Exception e){
           e.printStackTrace();
       
       }
          return ArrestEnd;               
    
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    private javax.swing.JTextField ArrestDateTimeEnd;
    private javax.swing.JTextField BloodGroup;
    private javax.swing.JButton BtSaveAccused;
    private javax.swing.JComboBox<String> CourtSuspect;
    private javax.swing.JTextField FatherFullName;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField FullNamePersonEn;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JComboBox<String> Gender1;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField HouseNumber;
    private javax.swing.JTextField Moo;
    private javax.swing.JTextField MotherFullName;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField OtherName;
    private javax.swing.JTextField PassportNumber;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PhonePerson;
    private javax.swing.JTextField PlaceArrest;
    private javax.swing.JTextField Province;
    private javax.swing.JTextField Race;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField Tambon;
    private javax.swing.JTextField Weight;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JTextField ZipCode1;
    private javax.swing.JTextField ZipCode2;
    private javax.swing.JPanel jButtonInsu2;
    private javax.swing.JPanel jButtonSue2;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelArrTime;
    private javax.swing.JLabel jLabelArrestDate;
    private javax.swing.JLabel jLabelArrestEnd;
    private javax.swing.JLabel jLabelArrestPlace;
    private javax.swing.JLabel jLabelBailDate;
    private javax.swing.JLabel jLabelRestoreDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelBailDate;
    private javax.swing.JPanel jPanelBirthDay;
    private javax.swing.JPanel jPanelDateArrest;
    private javax.swing.JPanel jPanelExpiredDate;
    private javax.swing.JPanel jPanelIssueDate;
    private javax.swing.JPanel jPanelRestoreDate;
    private javax.swing.JRadioButton jRadioBail;
    private javax.swing.JRadioButton jRadioCantCatch;
    private javax.swing.JRadioButton jRadioCatch;
    private javax.swing.JRadioButton jRadioKnowSuspect;
    private javax.swing.JRadioButton jRadioOther;
    private javax.swing.JRadioButton jRadioRestore;
    private javax.swing.JRadioButton jRadioResultImprison;
    private javax.swing.JRadioButton jRadioResultRelease;
    private javax.swing.JRadioButton jRadioSue;
    private javax.swing.JRadioButton jRadioUnknowSuspect;
    private javax.swing.JRadioButton jRadioVerbal;
    private javax.swing.JSpinner jSpinnerArrTime;
    // End of variables declaration//GEN-END:variables
}
