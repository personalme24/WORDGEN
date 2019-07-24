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
import java.awt.ItemSelectable;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
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
     JDatePickerImpl ArrestDateTime,IssueDate,ExpiredDate,BirthDay,RestoreDate,BailDate,AttachlDate;
      JDatePanelImpl datePanel3;
    /**
     * Creates new form AccusedForm
     */
    public SuspectForm(JFrame parrent,JSONObject datain) {
        super(parrent,true);     
        initComponents();  
         eventJRadioManage();
            ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES)");
//  ---------------------------------------------Date Filed----------------------------------------------
     UtilDateModel model = new UtilDateModel();
//            model.setValue(Calendar.getInstance().getTime()); 
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
//            model2.setValue(Calendar.getInstance().getTime());
          JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         IssueDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
        IssueDate.setTextEditable(true);
        IssueDate.setBackground(Color.WHITE);
        jPanelIssueDate.setLayout(new FlowLayout());
        jPanelIssueDate.add(IssueDate); 
        
        UtilDateModel model3 = new UtilDateModel();
//            model3.setValue(Calendar.getInstance().getTime());
         datePanel3 = new JDatePanelImpl(model3, p);
         ExpiredDate = new JDatePickerImpl(datePanel3,new DateLabelFormatter());
        ExpiredDate.setTextEditable(true);
        ExpiredDate.setBackground(Color.WHITE);
        jPanelExpiredDate.setLayout(new FlowLayout());
        jPanelExpiredDate.add(ExpiredDate);
//       
            UtilDateModel model4 = new UtilDateModel();
//            model4.setValue(Calendar.getInstance().getTime());
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
//            model6.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel6 = new JDatePanelImpl(model6, p);
         BailDate = new JDatePickerImpl(datePanel6,new DateLabelFormatter());
        BailDate.setTextEditable(true);
        BailDate.setBackground(Color.WHITE);
        jPanelBailDate.setLayout(new FlowLayout());
        jPanelBailDate.add(BailDate);
        
         UtilDateModel model7 = new UtilDateModel();
            model7.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel7 = new JDatePanelImpl(model7, p);
         AttachlDate = new JDatePickerImpl(datePanel7,new DateLabelFormatter());
        AttachlDate.setTextEditable(true);
        AttachlDate.setBackground(Color.WHITE);
        jPanelAttachlDate.setLayout(new FlowLayout());
        jPanelAttachlDate.add(AttachlDate);
 //  ---------------------------------------------Date Filed----------------------------------------------
        

        colseTextBox();
        
         

         ButtonGroup kno=new ButtonGroup();
        kno.add(jRadioUnknowSuspect);
        kno.add(jRadioKnowSuspect);
        
             ButtonGroup g=new ButtonGroup();
        g.add(jRadioSue);
        g.add(jRadioResultImprison);
        g.add(jRadioResultRelease);
        g.add(jRadioCantCatch);
        g.add(jRadioVerbal);
        g.add(jRadioRestore);
        g.add(jRadioFreeze);
        g.add(jRadioWithdrawComplaint); 
        g.add(jRadioOther);
       
        eventJButtonManage();
                 

          if(datain!=null){
        
            isInsert=false;
            String statusSus,statusBail;
            statusSus=datain.get("StatusSuspect")+"";
             statusBail=datain.get("StatusBail")+"";
            CourtSuspect.setSelectedItem(datain.get("CourtSuspect"));
            Gender.setSelectedItem(datain.get("Gender"));               
            RatePrison.setSelectedItem(datain.get("RatePrison"));            
            caseid=datain.get("caseIdPerson")+"";
            noPerson=datain.get("NoPerson")+"";
            crimecaseno.setText(datain.get("caseIdPerson")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            String known=datain.get("FullNamePerson")+"";
            if(known.equals("ไม่รู้ตัว")){
            jRadioUnknowSuspect.setSelected(true);
            }
            else{jRadioKnowSuspect.setSelected(true);}
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
            PhonePerson.setText(datain.get("PhonePerson")+"");
            Province.setText(datain.get("Province")+"");
            Race.setText(datain.get("Race")+"");
            Religion.setText(datain.get("Religion")+"");
            Tambon.setText(datain.get("Tambon")+"");
            Religion.setText(datain.get("Religion")+"");
            SimpleDateFormat format=new SimpleDateFormat("d/MM/yyyy");
            String DateArr=(datain.get("ArrestDateTime")+"");
             ArrestDateTime.getJFormattedTextField().setText(datain.get("ArrestDateTime")+"");            
//            if(DateArr.equals("")||DateArr.equals(null)){  
//             ArrestDateTime.getJFormattedTextField().setText("");
//                 }
//            else{
//             Date d=null;     
//            try{
//             d=format.parse(DateArr);
//            }
//            catch(Exception e){
//            }
//             ArrestDateTime.getJFormattedTextField().setText(format.format(d));
//            }

            ArrestDateTimeEnd.setText(datain.get("ArrestDateTimeEnd")+"");
            BailDate.getJFormattedTextField().setText(datain.get("BailDate")+"");
            PlaceArrest.setText(datain.get("PlaceArrest")+"");
            if(statusSus.equals("ผัดฟ้องฝากขัง")||statusSus.equals("ผัดฟ้อง")||statusSus.equals("ฝากขัง")){
            jRadioSue.setSelected(true);
         
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
             jRadioFreeze.setSelected(true);  
                }   
              else if(statusSus.equals("อื่นๆ")){
             jRadioOther.setSelected(true);
                }  
            else if(statusSus.equals("ถอนคำร้องทุกข์")){
             jRadioWithdrawComplaint.setSelected(true);  
                } 
             if(statusBail.equals("ประกัน")){            
             jCheckBail.setSelected(true);
             }      

        }else{
           
           crimecaseno.setText(ListSuspect.txtCaseNO.getText());
             jRadioUnknowSuspect.setSelected(true);
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
        jPanelIssueDate = new javax.swing.JPanel();
        jPanelExpiredDate = new javax.swing.JPanel();
        jPanelBirthDay = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        Moo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        ZipCode = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        ZipCode1 = new javax.swing.JTextField();
        HouseNumber = new javax.swing.JTextField();
        Tambon = new javax.swing.JTextField();
        Amphur = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Identification = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        BtSaveAccused = new javax.swing.JButton();
        Gender1 = new javax.swing.JComboBox<>();
        Province = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jRadioRestore = new javax.swing.JRadioButton();
        jRadioVerbal = new javax.swing.JRadioButton();
        jRadioFreeze = new javax.swing.JRadioButton();
        jRadioWithdrawComplaint = new javax.swing.JRadioButton();
        jRadioSue = new javax.swing.JRadioButton();
        jRadioResultImprison = new javax.swing.JRadioButton();
        jRadioResultRelease = new javax.swing.JRadioButton();
        jRadioCantCatch = new javax.swing.JRadioButton();
        jLabelArrestPlace = new javax.swing.JLabel();
        PlaceArrest = new javax.swing.JTextField();
        jLabelArrestDate = new javax.swing.JLabel();
        jLabelRestoreDate = new javax.swing.JLabel();
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
        jCheckBail = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabelRate = new javax.swing.JLabel();
        jLabelRateNumber = new javax.swing.JLabel();
        RatePrison = new javax.swing.JComboBox<>();
        CourtSuspect = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jRadioUnknowSuspect = new javax.swing.JRadioButton();
        jRadioKnowSuspect = new javax.swing.JRadioButton();
        jRadioOther = new javax.swing.JRadioButton();
        jPanelAttachlDate = new javax.swing.JPanel();
        Attach = new javax.swing.JTextField();
        jLabelFreezeDate = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabelFreezeOrg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("TH SarabunPSK", 0, 11)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1180, 700));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
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
                .addContainerGap(1153, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(4, 93, 179));

        jLabel31.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ข้อมูลผู้ต้องหา");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        OtherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherNameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ชื่อภาษาอังกฤษ");

        FullNamePersonEn.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เลขหนังสือเดินทาง");

        PassportNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("วันเกิด");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("อายุ");

        Age.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeActionPerformed(evt);
            }
        });
        Age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AgeKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("สัญชาติ");

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Race.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("ศาสนา");

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("สูง");

        Height.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("น้ำหนัก");

        Weight.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("หมู่โลหิต");

        BloodGroup.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("เพศ");

        Gender.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ชาย", "หญิง", "ไม่ระบุ" }));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("อาชีพ");

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("ชื่อบิดา");

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel29.setText("ชื่อมารดา");

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setText("หมายเลขโทรศัพท์");

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jPanelIssueDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelIssueDateLayout = new javax.swing.GroupLayout(jPanelIssueDate);
        jPanelIssueDate.setLayout(jPanelIssueDateLayout);
        jPanelIssueDateLayout.setHorizontalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelIssueDateLayout.setVerticalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanelExpiredDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelExpiredDateLayout = new javax.swing.GroupLayout(jPanelExpiredDate);
        jPanelExpiredDate.setLayout(jPanelExpiredDateLayout);
        jPanelExpiredDateLayout.setHorizontalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanelExpiredDateLayout.setVerticalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanelBirthDay.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelBirthDayLayout = new javax.swing.GroupLayout(jPanelBirthDay);
        jPanelBirthDay.setLayout(jPanelBirthDayLayout);
        jPanelBirthDayLayout.setHorizontalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 189, Short.MAX_VALUE)
        );
        jPanelBirthDayLayout.setVerticalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel19.setText("เชื้อชาติ");

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("บ้านเลขที่");

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel34.setText("ตำหนิรูปพรรณ");

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel32.setText("เคยต้องโทษ");

        ZipCode.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZipCodeKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");

        ZipCode1.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");

        Identification.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("เขต/อำเภอ");

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel33.setText("ผู้ต้องหาให้การ");

        BtSaveAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        BtSaveAccused.setText("บันทึก");
        BtSaveAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveAccusedActionPerformed(evt);
            }
        });

        Gender1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Gender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "รับสารภาพ", "ปฏิเสธ", "ภาคเสธ" }));

        Province.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("จังหวัด");

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("หมู่ที่");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(BtSaveAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel21))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(46, 46, 46)
                                .addComponent(Amphur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel34))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ZipCode1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                    .addComponent(Identification))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Gender1, 0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                            .addComponent(jLabel2))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(OtherName))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanelIssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(PeopleRegistrationID))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(FatherFullName)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Nationality)
                                            .addComponent(PassportNumber)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(HouseNumber)
                                            .addComponent(PhonePerson))))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(100, 100, 100)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jPanelBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Age))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Religion))))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(5, 5, 5)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(FullNamePersonEn)))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel20)
                                                    .addComponent(jLabel29)
                                                    .addComponent(jLabel14))
                                                .addGap(6, 6, 6))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel22)
                                                .addGap(10, 10, 10)
                                                .addComponent(Tambon))
                                            .addComponent(MotherFullName)
                                            .addComponent(Occupation))))))
                        .addGap(50, 50, 50))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelIssueDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MotherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Tambon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZipCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gender1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Identification, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(BtSaveAccused)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PhonePerson.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(4, 93, 179));

        jLabel28.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("การจัดการผู้ต้องหา");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jRadioFreeze.setBackground(new java.awt.Color(255, 255, 255));
        jRadioFreeze.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioFreeze.setText("อายัดตัว");

        jRadioWithdrawComplaint.setBackground(new java.awt.Color(255, 255, 255));
        jRadioWithdrawComplaint.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioWithdrawComplaint.setText("ถอนคำร้องทุกข์");

        jRadioSue.setBackground(new java.awt.Color(255, 255, 255));
        jRadioSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioSue.setText("ผัดฟ้องฝากขัง");

        jRadioResultImprison.setBackground(new java.awt.Color(255, 255, 255));
        jRadioResultImprison.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioResultImprison.setText("แจ้งข้อหาฝากขัง");

        jRadioResultRelease.setBackground(new java.awt.Color(255, 255, 255));
        jRadioResultRelease.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioResultRelease.setText("แจ้งข้อหาปล่อยตัว");

        jRadioCantCatch.setBackground(new java.awt.Color(255, 255, 255));
        jRadioCantCatch.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioCantCatch.setText("ไม่ได้ตัว(หลบหนี)");

        jLabelArrestPlace.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestPlace.setText("สถานที่จับกุม");

        PlaceArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabelArrestDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestDate.setText("วันที่จับกุม");

        jLabelRestoreDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelRestoreDate.setText("วันที่ส่งฟื้นฟู");

        jPanelDateArrest.setBackground(new java.awt.Color(204, 204, 204));
        jPanelDateArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelDateArrestLayout = new javax.swing.GroupLayout(jPanelDateArrest);
        jPanelDateArrest.setLayout(jPanelDateArrestLayout);
        jPanelDateArrestLayout.setHorizontalGroup(
            jPanelDateArrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelDateArrestLayout.setVerticalGroup(
            jPanelDateArrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabelArrTime.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrTime.setText("เวลา");

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jSpinnerArrTime, "HH:mm");
        jSpinnerArrTime.setEditor(timeEditor);
        jSpinnerArrTime.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jSpinnerArrTime.setPreferredSize(new java.awt.Dimension(29, 25));

        jPanelRestoreDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelRestoreDateLayout = new javax.swing.GroupLayout(jPanelRestoreDate);
        jPanelRestoreDate.setLayout(jPanelRestoreDateLayout);
        jPanelRestoreDateLayout.setHorizontalGroup(
            jPanelRestoreDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRestoreDateLayout.setVerticalGroup(
            jPanelRestoreDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanelBailDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelBailDateLayout = new javax.swing.GroupLayout(jPanelBailDate);
        jPanelBailDate.setLayout(jPanelBailDateLayout);
        jPanelBailDateLayout.setHorizontalGroup(
            jPanelBailDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );
        jPanelBailDateLayout.setVerticalGroup(
            jPanelBailDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLabelBailDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelBailDate.setText("วันประกัน");

        jLabelArrestEnd.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestEnd.setText("วัน-เวลาที่สิ้นสุดการควบคุมตัว");

        ArrestDateTimeEnd.setEditable(false);
        ArrestDateTimeEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jCheckBail.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckBail.setText("ประกันตัว");
        jCheckBail.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("สถานะประกัน");

        jLabelRate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelRate.setText("อัตราโทษจำคุก");

        jLabelRateNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelRateNumber.setText("10 ปี");

        RatePrison.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        RatePrison.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "น้อยกว่า", "มากกว่า" }));

        CourtSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtSuspect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลแขวง", "ศาลอาญา", "ศาลเด็กและเยาวชน", "ศาลทหาร", " " }));

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("อำนาจศาล");

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("ผู้ต้องหา");

        jRadioUnknowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioUnknowSuspect.setText("ไม่รู้ตัว");

        jRadioKnowSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioKnowSuspect.setText("รู้ตัว");

        jRadioOther.setBackground(new java.awt.Color(255, 255, 255));
        jRadioOther.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioOther.setText("อื่นๆ");

        jPanelAttachlDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelAttachlDateLayout = new javax.swing.GroupLayout(jPanelAttachlDate);
        jPanelAttachlDate.setLayout(jPanelAttachlDateLayout);
        jPanelAttachlDateLayout.setHorizontalGroup(
            jPanelAttachlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelAttachlDateLayout.setVerticalGroup(
            jPanelAttachlDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        Attach.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabelFreezeDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelFreezeDate.setText("วันที่อายัดตัว");

        jLabel35.setText("jLabel35");

        jLabelFreezeOrg.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelFreezeOrg.setText("หน่วยงานที่อายัดตัว");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioSue)
                            .addComponent(jRadioFreeze, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioCantCatch))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioResultImprison, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioVerbal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioWithdrawComplaint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioResultRelease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelRate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RatePrison, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRateNumber))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel37))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jRadioUnknowSuspect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioKnowSuspect))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(CourtSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel35))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelArrestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanelDateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelArrTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelFreezeOrg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Attach, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelFreezeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanelAttachlDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelBailDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelBailDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelRestoreDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelArrestPlace)
                        .addGap(18, 18, 18)
                        .addComponent(PlaceArrest))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabelArrestEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ArrestDateTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioUnknowSuspect)
                    .addComponent(jRadioKnowSuspect))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourtSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioSue)
                            .addComponent(jRadioResultImprison))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioCantCatch)
                            .addComponent(jRadioVerbal)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioResultRelease)
                        .addGap(3, 3, 3)
                        .addComponent(jRadioRestore)))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioFreeze)
                    .addComponent(jRadioWithdrawComplaint)
                    .addComponent(jRadioOther))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBail)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRate)
                    .addComponent(RatePrison, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRateNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArrestPlace)
                    .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelArrestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelDateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinnerArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrestDateTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArrestEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBailDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelBailDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Attach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFreezeOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelAttachlDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFreezeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSaveAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveAccusedActionPerformed
        // TODO add your handling code here:
        con=ConnectDatabase.connect();
         SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String arrestTime = format.format(jSpinnerArrTime.getValue());

            String arrestDate=Checknull(ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime);                    
          String arrestDateEnd48=  CalculateDateTime48(arrestDate);
            ArrestDateTimeEnd.setText(CalculateDateTime48(arrestDate));
        if(isInsert){
            String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
            "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
            "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,StatusSuspect,"
            + "caseIdPerson,ArrestDateTime,PlaceArrest,CourtSuspect,BailDate,ArrestDateTimeEnd,StatusBail,RatePrison,Identification)\n"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                    String court=CourtSuspect.getSelectedItem().toString();
                    if(court.equals("ศาลแขวง") && jCheckBail.isSelected()){
                    pst.setString(28,"ผัดฟ้อง");       }
                    else if(court.equals("ศาลแขวง")){
                    pst.setString(28,"ผัดฟ้องฝากขัง");       }
                    else if(court.equals("ศาลอาญา")){
                    pst.setString(28,"ฝากขัง");       }
//                    else if(court.equals("ศาลอาญา")){
//                    pst.setString(28,"ฝากขัง");       }
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
                else if(jRadioFreeze.isSelected()){
                        pst.setString(28,"อายัดตัว");   
                }
                 else if(jRadioWithdrawComplaint.isSelected()){
                         pst.setString(28,"ถอนคำร้องทุกข์");   
                }   
                else if(jRadioOther.isSelected()){
                         pst.setString(28,"อื่นๆ");   
                }  
                pst.setString(29,crimecaseno.getText());
//                pst.setString(30,BailDate.getText());
                if(ArrestDateTime.getJFormattedTextField().getText().equals("")){
                arrestTime="";
                }
                pst.setString(30,ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime);
                pst.setString(31,PlaceArrest.getText());
                pst.setString(32,CourtSuspect.getSelectedItem().toString());
                pst.setString(33,BailDate.getJFormattedTextField().getText());
                if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jCheckBail.isSelected()){
                 pst.setString(34,"");
                }
                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jRadioResultRelease.isSelected()){
                 pst.setString(34,"");
                }
                  else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jRadioSue.isSelected()){
                 pst.setString(34,"");
                }
                   else if(CourtSuspect.getSelectedItem().toString().equals("ศาลเด็กและเยาวชน")){
                 pst.setString(34,CalculateDateTime24(arrestDate));
                }
                else{
                pst.setString(34,arrestDateEnd48);}
//                pst.setString(34,ArrestDateTimeEnd.getText());
                if(jCheckBail.isSelected()){
                pst.setString(35,"ประกัน");}
                else{pst.setString(35,"");}
                 pst.setString(36,RatePrison.getSelectedItem().toString());
                 pst.setString(37,Identification.getText());
                

               int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            pst.executeUpdate();             
                             pst.close();
                             System.out.println("SQL : "+sql);
                                     setVisible(false);
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
                    + "StatusSuspect=?,"            
                    + "StatusBail=?,"
                    + "RatePrison=? where NoPerson=? and TypePerson=?   ";

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
                   if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jCheckBail.isSelected()){
                 pst.setString(32,"");
                }
                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jRadioResultRelease.isSelected()){
                 pst.setString(32,"");
                }
                  else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jRadioSue.isSelected()){
                 pst.setString(32,"");
                }
                   else if(CourtSuspect.getSelectedItem().toString().equals("ศาลเด็กและเยาวชน")){
                 pst.setString(32,CalculateDateTime24(arrestDate));
                }
                else{
                pst.setString(32,arrestDateEnd48);}

                   if(jRadioSue.isSelected()){ 
                    String court=CourtSuspect.getSelectedItem().toString();
                    if(court.equals("ศาลแขวง") && jCheckBail.isSelected()){
                    pst.setString(33,"ผัดฟ้อง");       }
                    else if(court.equals("ศาลแขวง")){
                    pst.setString(33,"ผัดฟ้องฝากขัง");       }
                    else if(court.equals("ศาลอาญา")){
                    pst.setString(33,"ฝากขัง");       }
//                    else if(court.equals("ศาลอาญา")){
//                    pst.setString(28,"ฝากขัง");       }
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
                else if(jRadioFreeze.isSelected()){
                        pst.setString(33,"อายัดตัว");   
                }
                 else if(jRadioOther.isSelected()){
                         pst.setString(33,"อื่นๆ");   
                }   
                else if(jRadioWithdrawComplaint.isSelected()){
                         pst.setString(33,"ถอนคำร้องทุกข์");   
                } 
                if(jCheckBail.isSelected()){
                pst.setString(34,"ประกัน");}
                else{pst.setString(34,"");}
              
                pst.setString(35,RatePrison.getSelectedItem().toString());
                pst.setString(36,noPerson);
              
                pst.setString(37,"ผู้ต้องหา");
                                         
                        int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            pst.executeUpdate();             
                             pst.close();
                             System.out.println("SQL : "+sqlUpdate);
                                     setVisible(false);
                        } 
               
//                System.out.println("SQL : "+sqlUpdate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }

        }


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

    private void OtherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OtherNameActionPerformed

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeActionPerformed
  public void eventJButtonManage(){
 
   jRadioUnknowSuspect.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
             PeopleRegistrationID.setEnabled(false);
       FullNamePerson.setEnabled(false);
       OtherName.setEnabled(false);
       FullNamePersonEn.setEnabled(false);
       PassportNumber.setEnabled(false);
       Age.setEnabled(false);
       Nationality.setEnabled(false);
       Race.setEnabled(false);
       Religion.setEnabled(false);
       Height.setEnabled(false);
       Weight.setEnabled(false);
       BloodGroup.setEnabled(false);
       FatherFullName.setEnabled(false);
       MotherFullName.setEnabled(false);
       PhonePerson.setEnabled(false);
       Occupation.setEnabled(false);
       HouseNumber.setEnabled(false);
       Gender.setEnabled(false);
       Moo.setEnabled(false);
       Tambon.setEnabled(false);
       Amphur.setEnabled(false);
       Province.setEnabled(false);
       ZipCode1.setEnabled(false);
       Gender1.setEnabled(false);
       Identification.setEnabled(false);
       ExpiredDate.getComponent(1).setEnabled(false);
      ExpiredDate.getJFormattedTextField().setEnabled(false);
      IssueDate.getComponent(1).setEnabled(false);
       IssueDate.getJFormattedTextField().setEnabled(false);
       BirthDay.getComponent(1).setEnabled(false);
       BirthDay.getJFormattedTextField().setEnabled(false);
        jRadioSue.setEnabled(false);
        jRadioResultImprison.setEnabled(false);
        jRadioResultRelease.setEnabled(false);
        jRadioCantCatch.setEnabled(false);
        jRadioVerbal.setEnabled(false);
        jRadioRestore.setEnabled(false);
        jRadioFreeze.setEnabled(false);
        jRadioWithdrawComplaint.setEnabled(false);
        jRadioOther.setEnabled(false);
        jCheckBail.setEnabled(false);
          ZipCode.setEnabled(false);

            // do something when the button is selected
 
        } 
        else if (state == ItemEvent.DESELECTED) {
                      PeopleRegistrationID.setEnabled(true);
       FullNamePerson.setEnabled(true);
       OtherName.setEnabled(true);
       FullNamePersonEn.setEnabled(true);
       PassportNumber.setEnabled(true);
       Age.setEnabled(true);
       Nationality.setEnabled(true);
       Race.setEnabled(true);
       Religion.setEnabled(true);
       Height.setEnabled(true);
       Weight.setEnabled(true);
       BloodGroup.setEnabled(true);
       FatherFullName.setEnabled(true);
       MotherFullName.setEnabled(true);
       PhonePerson.setEnabled(true);
       Occupation.setEnabled(true);
       HouseNumber.setEnabled(true);
       Gender.setEnabled(true);
       Moo.setEnabled(true);
       Tambon.setEnabled(true);
       Amphur.setEnabled(true);
       Province.setEnabled(true);
       ZipCode1.setEnabled(true);
       Gender1.setEnabled(true);
       Identification.setEnabled(true);
      ExpiredDate.getComponent(1).setEnabled(true);
      ExpiredDate.getJFormattedTextField().setEnabled(true);
      IssueDate.getComponent(1).setEnabled(true);
       IssueDate.getJFormattedTextField().setEnabled(true);
     BirthDay.getComponent(1).setEnabled(true);
       BirthDay.getJFormattedTextField().setEnabled(true);
             jRadioSue.setEnabled(true);
        jRadioResultImprison.setEnabled(true);
        jRadioResultRelease.setEnabled(true);
        jRadioCantCatch.setEnabled(true);
        jRadioVerbal.setEnabled(true);
        jRadioRestore.setEnabled(true);
        jRadioFreeze.setEnabled(true);
        jRadioWithdrawComplaint.setEnabled(true);
        jRadioOther.setEnabled(true);
        jCheckBail.setEnabled(true);
  ZipCode.setEnabled(true);
            // do something else when the button is deselected
 
        }
    }
});
  }   
 
    public void eventJRadioManage(){
  jCheckBail.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {  
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
           jLabelBailDate.setVisible(true);
           jPanelBailDate.setVisible(true); 
//           ArrestDateTimeEnd.setVisible(false); 
            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
             jLabelBailDate.setVisible(false);
           jPanelBailDate.setVisible(false);
//           ArrestDateTimeEnd.setVisible(true);
            // do something else when the button is deselected
 
        }
    }
});


   
      jRadioFreeze.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
         jLabelFreezeOrg.setVisible(true);
         Attach.setVisible(true);
         jLabelFreezeDate.setVisible(true);
         jPanelAttachlDate.setVisible(true);
            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
             jLabelFreezeOrg.setVisible(false);
           Attach.setVisible(false);
            jLabelFreezeDate.setVisible(false);
         jPanelAttachlDate.setVisible(false);
            // do something else when the button is deselected
 
        }
    }
});
        jRadioSue.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
            PlaceArrest.setVisible(true);
                  jLabelArrestPlace.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);
//                 jLabelArrestEnd.setVisible(true);
//            ArrestDateTimeEnd.setVisible(true);
                  jLabelRate.setVisible(true);
            jLabelRateNumber.setVisible(true);
             RatePrison.setVisible(true);
            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
                 PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
                jPanelDateArrest.setVisible(false);
                jLabelArrestDate.setVisible(false);
              jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
//                 jLabelArrestEnd.setVisible(false);
//            ArrestDateTimeEnd.setVisible(false);
      jLabelRate.setVisible(false);
            jLabelRateNumber.setVisible(false);
             RatePrison.setVisible(false);
            // do something else when the button is deselected
 
        }
    }
});
        jRadioRestore.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
                    jLabelRestoreDate.setVisible(true);
                  jPanelRestoreDate.setVisible(true);     
            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
                 jLabelRestoreDate.setVisible(false);
                  jPanelRestoreDate.setVisible(false);
            // do something else when the button is deselected
 
        }
    }
});
         jRadioResultRelease.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
      if (state == ItemEvent.SELECTED) {
              PlaceArrest.setVisible(true);
                  jLabelArrestPlace.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);

            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
                PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
            jPanelDateArrest.setVisible(false);
            jLabelArrestDate.setVisible(false);
            jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);

            // do something else when the button is deselected
 
        }
    }
});

 
       

               } 
    public void colseTextBox(){
//    RestoreDate.setVisible(false);  
    jLabelRestoreDate.setVisible(false); 
        jLabelArrTime.setVisible(false);
    jLabelArrestDate.setVisible(false);
     jLabelArrestPlace.setVisible(false);
     jPanelDateArrest.setVisible(false);
    jSpinnerArrTime.setVisible(false);          
    PlaceArrest.setVisible(false); 
    jPanelRestoreDate.setVisible(false);
//     jLabelBailDate.setVisible(false);
//     
//            jPanelBailDate.setVisible(false);   
            jLabelArrestEnd.setVisible(false);
            ArrestDateTimeEnd.setVisible(false);
            jLabelRate.setVisible(false);
            jLabelRateNumber.setVisible(false);
             RatePrison.setVisible(false);
           jLabelBailDate.setVisible(false);
           jPanelBailDate.setVisible(false);
   jLabelFreezeOrg.setVisible(false);
           Attach.setVisible(false);
            jLabelFreezeDate.setVisible(false);
         jPanelAttachlDate.setVisible(false);
         
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
                        SimpleDateFormat  format = new SimpleDateFormat("d/MM/yyyy HH:mm",lc);  
                        Date dateArrest=null;
                       if(DateArrest.equals(" ")){
                       
                       ArrestEnd=ArrestEnd;
                       }
                       else{
                          dateArrest=format.parse(DateArrest);
                        cal = Calendar.getInstance();
                        cal.setTime(dateArrest);                      
                        cal.add(Calendar.HOUR, +48);
                         ArrestEnd= format.format(cal.getTime());
                        System.out.println("Date48Hr : "+ArrestEnd);}
                            
                    
       }catch(Exception e){
           e.printStackTrace();
       
       }
          return Checknull(ArrestEnd);               
    
    }
     public String CalculateDateTime24(String DateArrest){
      String ArrestEnd="";   
      Calendar cal;
       try{
     
               Locale lc = new Locale("th","TH");
                        SimpleDateFormat  format = new SimpleDateFormat("d/MM/yyyy HH:mm",lc);  
                        Date dateArrest=null;
                       if(DateArrest.equals(" ")){
                       
                       ArrestEnd=ArrestEnd;
                       }
                       else{
                          dateArrest=format.parse(DateArrest);
                        cal = Calendar.getInstance();
                        cal.setTime(dateArrest);                      
                        cal.add(Calendar.HOUR, +24);
                         ArrestEnd= format.format(cal.getTime());
                        System.out.println("Date24Hr : "+ArrestEnd);}
                            
                    
       }catch(Exception e){
           e.printStackTrace();
       
       }
          return Checknull(ArrestEnd);               
    
    }
    public static String Checknull(String input){
					if(input==null||input==""||input=="null") { return ""; }
					return input;
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    private javax.swing.JTextField ArrestDateTimeEnd;
    private javax.swing.JTextField Attach;
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
    private javax.swing.JTextField Identification;
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
    private javax.swing.JComboBox<String> RatePrison;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField Tambon;
    private javax.swing.JTextField Weight;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JTextField ZipCode1;
    private javax.swing.JCheckBox jCheckBail;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
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
    private javax.swing.JLabel jLabelFreezeDate;
    private javax.swing.JLabel jLabelFreezeOrg;
    private javax.swing.JLabel jLabelRate;
    private javax.swing.JLabel jLabelRateNumber;
    private javax.swing.JLabel jLabelRestoreDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelAttachlDate;
    private javax.swing.JPanel jPanelBailDate;
    private javax.swing.JPanel jPanelBirthDay;
    private javax.swing.JPanel jPanelDateArrest;
    private javax.swing.JPanel jPanelExpiredDate;
    private javax.swing.JPanel jPanelIssueDate;
    private javax.swing.JPanel jPanelRestoreDate;
    private javax.swing.JRadioButton jRadioCantCatch;
    private javax.swing.JRadioButton jRadioFreeze;
    private javax.swing.JRadioButton jRadioKnowSuspect;
    private javax.swing.JRadioButton jRadioOther;
    private javax.swing.JRadioButton jRadioRestore;
    private javax.swing.JRadioButton jRadioResultImprison;
    private javax.swing.JRadioButton jRadioResultRelease;
    private javax.swing.JRadioButton jRadioSue;
    private javax.swing.JRadioButton jRadioUnknowSuspect;
    private javax.swing.JRadioButton jRadioVerbal;
    private javax.swing.JRadioButton jRadioWithdrawComplaint;
    private javax.swing.JSpinner jSpinnerArrTime;
    // End of variables declaration//GEN-END:variables
}
