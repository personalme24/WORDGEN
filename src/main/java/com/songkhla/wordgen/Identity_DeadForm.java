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
public class Identity_DeadForm extends javax.swing.JDialog {
    Connection con=null;
    Connection con2=null;
     PreparedStatement pst=null;
     boolean isInsert;
     String noPerson,caseid;
     JDatePickerImpl IssueDate,ExpiredDate,BirthDay,DeadDate,FoundBodyDate;
      JDatePanelImpl datePanel3;
    /**
     * Creates new form AccusedForm
     */
    public Identity_DeadForm(JFrame parrent,JSONObject datain) {
        super(parrent,true);     
        initComponents();  
            ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES)");
           crimecaseno.setVisible(false);
//  ---------------------------------------------Date Filed----------------------------------------------
     UtilDateModel model = new UtilDateModel();
//            model.setValue(Calendar.getInstance().getTime()); 
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
         DeadDate = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        DeadDate.setTextEditable(true);
        DeadDate.setBackground(Color.WHITE);
       jPanelDeadDate.setLayout(new FlowLayout());
        jPanelDeadDate.add(DeadDate); 

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
        
                    UtilDateModel model5 = new UtilDateModel();
//            model4.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel5 = new JDatePanelImpl(model5, p);
         FoundBodyDate = new JDatePickerImpl(datePanel5,new DateLabelFormatter());
        FoundBodyDate.setTextEditable(true);
        FoundBodyDate.setBackground(Color.WHITE);
        jPanelFoundBody.setLayout(new FlowLayout());
        jPanelFoundBody.add(FoundBodyDate);
//        

 //  ---------------------------------------------Date Filed----------------------------------------------
        
        BirthDay.getJFormattedTextField().getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                Age.setText(CalculateData.calculateAge(BirthDay.getJFormattedTextField().getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                              Age.setText(CalculateData.calculateAge(BirthDay.getJFormattedTextField().getText()));

                           }
             }
             );
         Tambon.getDocument().addDocumentListener(new DocumentListener() {
             public void changedUpdate(DocumentEvent e) {
                  zp();
             }
             public void removeUpdate(DocumentEvent e) {

             }
             public void insertUpdate(DocumentEvent e) {
                  zp();
             }
                    public void zp() {
                        String provinceid="";
                           String loTam="",amp="",zp="",loAmphur="",pro="";
                          Connection con2 = ConnectDatabase.connect();
                          try {
                              Statement st2 = con2.createStatement();
                              String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
                              "where Tambon.NAMETAMBON='"+Tambon.getText()+"'";
                              ResultSet res2 = st2.executeQuery(a);
                              System.out.println("provinceid: "+a);
                          if(res2.next()){
                              zp=res2.getString("ZIPCODE");
                          provinceid=res2.getString("DOPA_CODE");
                         loTam= provinceid.substring(0, 4);
                            ZipCode.setText(zp);
                          }
                          }
                          catch(Exception ex){

                          }
                    }
                 });   
          if(datain!=null){
              Date timeDie=null;
                  Date timeFoundBody=null;
              try{
                  
            isInsert=false;
            String statusSus,statusBail;
            statusSus=datain.get("StatusSuspect")+"";
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                 timeDie = timeFormat.parse(datain.get("TimeOfDie")+"");
                 timeFoundBody = timeFormat.parse(datain.get("BodyFoundTime")+"");
              }catch(Exception ex){
              
              
              }
            Gender.setSelectedItem(datain.get("Gender"));               
            caseid=datain.get("caseIdPerson")+"";
            noPerson=datain.get("NoPerson")+"";
            crimecaseno.setText(datain.get("caseIdPerson")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            FullNamePerson.setText(datain.get("FullNamePerson")+"");
            OrderPerson.setText(datain.get("OrderPerson")+"");
            Age.setText(datain.get("Age")+"");
            Amphur.setText(datain.get("Amphur")+"");
            BirthDay.getJFormattedTextField().setText(datain.get("BirthDay")+"");
            BloodGroup.setSelectedItem(datain.get("BloodGroup")+"");
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
             ZipCode.setText(datain.get("ZipCode")+"");           
            Race.setText(datain.get("Race")+"");
            Religion.setText(datain.get("Religion")+"");
            Tambon.setText(datain.get("Tambon")+"");
            Religion.setText(datain.get("Religion")+"");
            Identification.setText(datain.get("Identification")+"");
            DeathLocation.setText(datain.get("DeathLocation")+"");
            FoundBodyDate.getJFormattedTextField().setText(datain.get("BodyFoundDate")+"");
            jSpinnerBodyFoundTime.setValue(timeFoundBody);
            DeadDate.getJFormattedTextField().setText(datain.get("DateOfDie")+"");
            jSpinnerDeadTime.setValue(timeDie);            
            OtherName.setText(datain.get("OtherName")+"");
            TambomDie.setText(datain.get("TambomDie")+"");
            AmphurDie.setText(datain.get("AmphurDie")+"");
            ProvinceDie.setText(datain.get("ProvinceDie")+"");
            TambomFoundBody.setText(datain.get("TambomFoundBody")+"");
            AmphurFoundBody.setText(datain.get("AmphurFoundBody")+"");
            ProvinceFoundBody.setText(datain.get("ProvinceFoundBody")+"");

            PlaceOfFoundBody.setText(datain.get("PlaceOfFoundBody")+"");
            SimpleDateFormat format=new SimpleDateFormat("d/MM/yyyy");

        }else{
           
//           crimecaseno.setText(ListSuspect.txtCaseNO.getText());
    
            isInsert=true;
            crimecaseno.setText(IdentityEdit.crimecaseid.getText());
            crimecaseno.setVisible(false);
    
        }
          
    }
    

    Identity_DeadForm(ListAccused aThis, boolean b) {
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
        crimecaseno = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PeopleRegistrationID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FullNamePerson = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        jLabel15 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        Occupation = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
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
        HouseNumber = new javax.swing.JTextField();
        Tambon = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Identification = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Province = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        OrderPerson = new javax.swing.JTextField();
        FatherFullName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Amphur = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jPanelFoundBody = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jSpinnerBodyFoundTime = new javax.swing.JSpinner();
        DeathLocation = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanelDeadDate = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        PlaceOfFoundBody = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jSpinnerDeadTime = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        TambomDie = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        AmphurDie = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        ProvinceDie = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        TambomFoundBody = new javax.swing.JTextField();
        ProvinceFoundBody = new javax.swing.JTextField();
        AmphurFoundBody = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        BloodGroup = new javax.swing.JComboBox<>();
        BtSaveAccused = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jLabel4.setText("ข้อมูลผู้ตาย");

        crimecaseno.setText("jLabel36");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(crimecaseno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addComponent(crimecaseno))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        OtherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherNameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ชื่อภาษาอังกฤษ");

        FullNamePersonEn.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เลขหนังสือเดินทาง");

        PassportNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("วันเกิด");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("อายุ");

        Age.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
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

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Nationality.setText("ไทย");

        Race.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Race.setText("ไทย");

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("ศาสนา");

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Religion.setText("พุทธ");

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("สูง");

        Height.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("น้ำหนัก");

        Weight.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("หมู่โลหิต");

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("เพศ");

        Gender.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ชาย", "หญิง", "ไม่ระบุ" }));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("อาชีพ");

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("ชื่อบิดา");

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel29.setText("ชื่อมารดา");

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setText("หมายเลขโทรศัพท์");

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jPanelIssueDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelIssueDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelIssueDateLayout = new javax.swing.GroupLayout(jPanelIssueDate);
        jPanelIssueDate.setLayout(jPanelIssueDateLayout);
        jPanelIssueDateLayout.setHorizontalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanelIssueDateLayout.setVerticalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanelExpiredDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelExpiredDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelExpiredDateLayout = new javax.swing.GroupLayout(jPanelExpiredDate);
        jPanelExpiredDate.setLayout(jPanelExpiredDateLayout);
        jPanelExpiredDateLayout.setHorizontalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelExpiredDateLayout.setVerticalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanelBirthDay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBirthDay.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelBirthDayLayout = new javax.swing.GroupLayout(jPanelBirthDay);
        jPanelBirthDay.setLayout(jPanelBirthDayLayout);
        jPanelBirthDayLayout.setHorizontalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
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
        jLabel32.setText("วันที่พบศพ");

        ZipCode.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZipCodeKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Tambon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TambonKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");

        Identification.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("เขต/อำเภอ");

        Province.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("จังหวัด");

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("หมู่ที่");

        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel35.setText("ผู้ตายคนที่");

        OrderPerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Amphur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmphurActionPerformed(evt);
            }
        });
        Amphur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmphurKeyReleased(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel33.setText("สถานที่ตาย");

        javax.swing.GroupLayout jPanelFoundBodyLayout = new javax.swing.GroupLayout(jPanelFoundBody);
        jPanelFoundBody.setLayout(jPanelFoundBodyLayout);
        jPanelFoundBodyLayout.setHorizontalGroup(
            jPanelFoundBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelFoundBodyLayout.setVerticalGroup(
            jPanelFoundBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel37.setText("เวลาที่พบศพ");

        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        jSpinnerBodyFoundTime = new javax.swing.JSpinner(sm3);
        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(jSpinnerBodyFoundTime, "HH:mm");
        jSpinnerBodyFoundTime.setEditor(timeEditor3);

        DeathLocation.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel38.setText("เวลาตาย");

        javax.swing.GroupLayout jPanelDeadDateLayout = new javax.swing.GroupLayout(jPanelDeadDate);
        jPanelDeadDate.setLayout(jPanelDeadDateLayout);
        jPanelDeadDateLayout.setHorizontalGroup(
            jPanelDeadDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );
        jPanelDeadDateLayout.setVerticalGroup(
            jPanelDeadDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel36.setText("สถานที่พบศพ");

        PlaceOfFoundBody.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel39.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel39.setText("วันที่ตาย");

        Date date=new Date();

        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        jSpinnerDeadTime = new javax.swing.JSpinner(sm);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jSpinnerDeadTime, "HH:mm");
        jSpinnerDeadTime.setEditor(timeEditor);

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("ตำบล");

        TambomDie.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        TambomDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambomDieActionPerformed(evt);
            }
        });
        TambomDie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TambomDieKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("อำเภอ");

        AmphurDie.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        AmphurDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmphurDieActionPerformed(evt);
            }
        });
        AmphurDie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmphurDieKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel28.setText("จังหวัด");

        ProvinceDie.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ProvinceDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProvinceDieActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("ตำบล");

        TambomFoundBody.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        TambomFoundBody.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambomFoundBodyActionPerformed(evt);
            }
        });
        TambomFoundBody.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TambomFoundBodyKeyReleased(evt);
            }
        });

        ProvinceFoundBody.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ProvinceFoundBody.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProvinceFoundBodyActionPerformed(evt);
            }
        });

        AmphurFoundBody.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        AmphurFoundBody.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmphurFoundBodyActionPerformed(evt);
            }
        });
        AmphurFoundBody.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmphurFoundBodyKeyReleased(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel40.setText("จังหวัด");

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel41.setText("อำเภอ");

        BloodGroup.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        BloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O", "A Rh-", "B Rh-", "AB Rh-", "O Rh-" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGap(49, 49, 49)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel27)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(MotherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel25)
                                .addGap(5, 5, 5)
                                .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(Occupation))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Identification, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PlaceOfFoundBody, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DeathLocation, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPanelFoundBody, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(HouseNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                            .addComponent(Province))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel24)
                                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22)
                                        .addGap(12, 12, 12)
                                        .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Amphur))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ZipCode)
                                            .addComponent(jSpinnerBodyFoundTime, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelDeadDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinnerDeadTime))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TambomDie, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(AmphurDie, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ProvinceDie, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel31)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TambomFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel41)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(AmphurFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel40)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ProvinceFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PassportNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                    .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanelBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(OrderPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanelIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel17)
                                .addGap(8, 8, 8)
                                .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addGap(7, 7, 7)
                                .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OrderPerson)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanelBirthDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(BloodGroup, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MotherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanelFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanelDeadDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinnerDeadTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jSpinnerBodyFoundTime, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeathLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TambomDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(AmphurDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(ProvinceDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(TambomFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41)
                        .addComponent(AmphurFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40)
                        .addComponent(ProvinceFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PlaceOfFoundBody, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Identification, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        PhonePerson.getAccessibleContext().setAccessibleName("");

        BtSaveAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        BtSaveAccused.setText("บันทึก");
        BtSaveAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveAccusedActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton2.setText("อ่านข้อมูลจากบัตร");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtSaveAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtSaveAccused)
                    .addComponent(jButton2))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSaveAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveAccusedActionPerformed
        // TODO add your handling code here:
        con=ConnectDatabase.connect();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String bodyfoundTime = format.format(jSpinnerBodyFoundTime.getValue());
         String TimeOfDead = format.format(jSpinnerDeadTime.getValue());

        if(isInsert){
            String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,DeathLocation,FullNamePerson,FullNamePersonEn,Gender,\n" +
            "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
            "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,"
            + "caseIdPerson,Identification,OrderPerson,PlaceOfFoundBody,BodyFoundDate,BodyFoundTime,DateOfDie,TimeOfDie,TambomDie,AmphurDie,ProvinceDie,"
                    + "TambomFoundBody,AmphurFoundBody,ProvinceFoundBody)\n"
            + " VALUES (?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //           String sqlSueFirst="insert into sue (SueTimes,SueDate,)";
            System.out.println("SQL : "+sql);
            try {
                pst=con.prepareStatement(sql);
                pst.setString(1,Age.getText());
                pst.setString(2,Amphur.getText());
                pst.setString(3,BirthDay.getJFormattedTextField().getText());
                pst.setString(4,BloodGroup.getSelectedItem().toString());
                pst.setString(5,ExpiredDate.getJFormattedTextField().getText());
                pst.setString(6,FatherFullName.getText());
                pst.setString(7,DeathLocation.getText());
                pst.setString(8,FullNamePerson.getText());
                pst.setString(9,FullNamePersonEn.getText());
                pst.setString(10,Gender.getSelectedItem().toString());
                pst.setString(11,Height.getText());
                pst.setString(12,HouseNumber.getText());
                pst.setString(13,IssueDate.getJFormattedTextField().getText());
                pst.setString(14,Moo.getText());
                pst.setString(15,MotherFullName.getText());
                pst.setString(16,Nationality.getText());
                pst.setString(17,Occupation.getText());
                pst.setString(18,OtherName.getText());
                pst.setString(19,PassportNumber.getText());
                pst.setString(20,PeopleRegistrationID.getText());
                pst.setString(21,PhonePerson.getText());
                pst.setString(22,Province.getText());
                pst.setString(23,Race.getText());
                pst.setString(24,Religion.getText());
                pst.setString(25,Tambon.getText());
                pst.setString(26,"ผู้ตาย");
                pst.setString(27,Weight.getText());
                pst.setString(28,ZipCode.getText());
                pst.setString(29,crimecaseno.getText());       
                pst.setString(30,Identification.getText());
                pst.setString(31,OrderPerson.getText());
                pst.setString(32,PlaceOfFoundBody.getText());
                pst.setString(33,FoundBodyDate.getJFormattedTextField().getText());
                pst.setString(34,bodyfoundTime);
                pst.setString(35,DeadDate.getJFormattedTextField().getText());
                 pst.setString(36,TimeOfDead);
                pst.setString(37,TambomDie.getText());
                pst.setString(38,AmphurDie.getText());
                pst.setString(39,ProvinceDie.getText());
                pst.setString(40,TambomFoundBody.getText());
                pst.setString(41,AmphurFoundBody.getText());
                pst.setString(42,ProvinceFoundBody.getText());



                int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    pst.close();
//                    System.out.println("SQL : "+sql);
                    InsertPerson();
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
            + "OrderPerson=?,"
            + "DeathLocation=?,"
            + "PlaceOfFoundBody=?,"
            + "BodyFoundDate=?,"
            + "BodyFoundTime=?,"
            + "DateOfDie=?,"
            + "TimeOfDie=?,"
             + "Identification=?,"
            + "TambomDie=?,"
            + "AmphurDie=?,"
            + "ProvinceDie=?,"
            + "TambomFoundBody=?,"
            + "AmphurFoundBody=?,"
            + "ProvinceFoundBody=?"                 
            + " where NoPerson=? and caseIdPerson=?   ";

            try {
                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,Age.getText());
                pst.setString(2,Amphur.getText());
                pst.setString(3,BirthDay.getJFormattedTextField().getText());
                pst.setString(4,BloodGroup.getSelectedItem().toString());
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
                pst.setString(25,"ผู้ตาย");
                pst.setString(26,Weight.getText());
                pst.setString(27,ZipCode.getText());
                pst.setString(28,OrderPerson.getText());
                pst.setString(29,DeathLocation.getText());
                pst.setString(30,PlaceOfFoundBody.getText());
                pst.setString(31,FoundBodyDate.getJFormattedTextField().getText());
                pst.setString(32,bodyfoundTime);
                pst.setString(33,DeadDate.getJFormattedTextField().getText());
                pst.setString(34,TimeOfDead);
                pst.setString(35,Identification.getText());
               pst.setString(36,TambomDie.getText());
                pst.setString(37,AmphurDie.getText());
                pst.setString(38,ProvinceDie.getText());
                pst.setString(39,TambomFoundBody.getText());
                pst.setString(40,AmphurFoundBody.getText());
                pst.setString(41,ProvinceFoundBody.getText());
                pst.setString(42,noPerson);
                pst.setString(43,crimecaseno.getText());
     
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

    private void AgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AgeKeyTyped
        char vChar = evt.getKeyChar();
        if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
        {
            evt.consume();
        }// TODO add your handling code here:
    }//GEN-LAST:event_AgeKeyTyped

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeActionPerformed

    private void OtherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OtherNameActionPerformed

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

    private void AmphurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmphurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmphurActionPerformed

    private void TambomDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambomDieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TambomDieActionPerformed

    private void AmphurDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmphurDieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmphurDieActionPerformed

    private void ProvinceDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProvinceDieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProvinceDieActionPerformed

    private void TambomFoundBodyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambomFoundBodyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TambomFoundBodyActionPerformed

    private void ProvinceFoundBodyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProvinceFoundBodyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProvinceFoundBodyActionPerformed

    private void AmphurFoundBodyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmphurFoundBodyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmphurFoundBodyActionPerformed

    private void TambonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TambonKeyReleased
        // TODO add your handling code here:
         String provinceid="";
         String loTam="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {
            Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.NAMETAMBON='"+Tambon.getText()+"'";
            ResultSet res2 = st2.executeQuery(a);
//            System.out.println("provinceid: "+CrimeLocationProvince.getSelectedItem());
        if(res2.next()){
            zp=res2.getString("ZIPCODE");
        provinceid=res2.getString("DOPA_CODE");
       loTam= provinceid.substring(0, 4);
          ZipCode.setText(zp);
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
         Amphur.setText(amp);
	
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
      Province.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
}
      
    }//GEN-LAST:event_TambonKeyReleased

    private void AmphurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmphurKeyReleased
        // TODO add your handling code here:
            String provinceid="";
         String loPro="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {

	Statement st = con2.createStatement();
        String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
                            "from Amphur\n" +
                            "where Amphur.NameAmphur = '"+Amphur.getText()+"';";
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
          ZipCode.setText(zp);
        }
        String c3 = "select nameprovince\n" +
                            "from province\n" +
                            "where provinceid = '"+loPro+"';";
            System.out.println("sddddddddd:"+c3);
        ResultSet res3 = st3.executeQuery(c3);
        if(res3.next())
	{
         
	 pro=res3.getString("nameprovince");
      Province.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
            }
    }//GEN-LAST:event_AmphurKeyReleased

    private void TambomDieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TambomDieKeyReleased
        // TODO add your handling code here:
         String provinceid="";
         String loTam="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {
            Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.NAMETAMBON='"+TambomDie.getText()+"'";
            ResultSet res2 = st2.executeQuery(a);
//            System.out.println("provinceid: "+CrimeLocationProvince.getSelectedItem());
        if(res2.next()){
    
        provinceid=res2.getString("DOPA_CODE");
       loTam= provinceid.substring(0, 4);
        
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
         AmphurDie.setText(amp);
	
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
      ProvinceDie.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
        }
    }//GEN-LAST:event_TambomDieKeyReleased

    private void TambomFoundBodyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TambomFoundBodyKeyReleased
        // TODO add your handling code here:
           String provinceid="";
         String loTam="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {
            Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.NAMETAMBON='"+TambomFoundBody.getText()+"'";
            ResultSet res2 = st2.executeQuery(a);
//            System.out.println("provinceid: "+CrimeLocationProvince.getSelectedItem());
        if(res2.next()){
    
        provinceid=res2.getString("DOPA_CODE");
       loTam= provinceid.substring(0, 4);
        
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
         AmphurFoundBody.setText(amp);
	
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
      ProvinceFoundBody.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
        }
    }//GEN-LAST:event_TambomFoundBodyKeyReleased

    private void AmphurDieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmphurDieKeyReleased
        // TODO add your handling code here:
         String provinceid="";
         String loPro="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {

	Statement st = con2.createStatement();
        String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
                            "from Amphur\n" +
                            "where Amphur.NameAmphur = '"+AmphurDie.getText()+"';";
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
        
        Statement st3 = con2.createStatement();
     
        String c3 = "select nameprovince\n" +
                            "from province\n" +
                            "where provinceid = '"+loPro+"';";
            System.out.println("sddddddddd:"+c3);
        ResultSet res3 = st3.executeQuery(c3);
        if(res3.next())
	{
         
	 pro=res3.getString("nameprovince");
      ProvinceDie.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
}
    }//GEN-LAST:event_AmphurDieKeyReleased

    private void AmphurFoundBodyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmphurFoundBodyKeyReleased
        // TODO add your handling code here:
         String provinceid="";
         String loPro="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {

	Statement st = con2.createStatement();
        String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
                            "from Amphur\n" +
                            "where Amphur.NameAmphur = '"+AmphurFoundBody.getText()+"';";
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
        
        Statement st3 = con2.createStatement();
     
        String c3 = "select nameprovince\n" +
                            "from province\n" +
                            "where provinceid = '"+loPro+"';";
            System.out.println("sddddddddd:"+c3);
        ResultSet res3 = st3.executeQuery(c3);
        if(res3.next())
	{
         
	 pro=res3.getString("nameprovince");
      ProvinceFoundBody.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
}
    }//GEN-LAST:event_AmphurFoundBodyKeyReleased

   
 
 

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
            java.util.logging.Logger.getLogger(Identity_DeadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Identity_DeadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Identity_DeadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Identity_DeadForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//        DataCase dcc=new DataCase();
//        labelCaseNo.setText("dfv");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//             AccusedForm aa=  new AccusedForm();
//                    aa.setVisible(true);
//                    aa.setSize ( 1024, 728 );
//                    aa.setMinimumSize ( new Dimension ( 1024, 728 ) );
//                    aa.setMaximizedBounds ( new Rectangle ( 1024, 728 ) );
      Identity_DeadForm aa=  new Identity_DeadForm(null,null);
     
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
 public void InsertPerson(){
       con=ConnectDatabase.connect();
        PreparedStatement pst2;
        boolean isPerson;
      try {
              Statement st = con.createStatement();
           String sel="Select FullNamePerson,PeopleRegistrationID from persondata where FullNamePerson='"+FullNamePerson.getText()+"' and PeopleRegistrationID='"+PeopleRegistrationID.getText()+"'";
           ResultSet rc = st.executeQuery(sel);
        if(rc.next()){
        
        isPerson=false;
        }
        else{
         isPerson=true;
        }
        if(isPerson){    
        String sql2="INSERT INTO PersonData (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                        "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                        "PhonePerson,Province,Race,Religion,Tambon,Weight,ZipCode)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
         System.out.println("SQL : "+sql2);
      try {
            pst2=con.prepareStatement(sql2);
                              pst2.setString(1,Age.getText());
                              pst2.setString(2,Amphur.getText());
                              pst2.setString(3,BirthDay.getJFormattedTextField().getText());
                              pst2.setString(4,BloodGroup.getSelectedItem().toString());
                              pst2.setString(5,ExpiredDate.getJFormattedTextField().getText());
                              pst2.setString(6,FatherFullName.getText());
                              pst2.setString(7,FullNamePerson.getText());
                              pst2.setString(8,FullNamePersonEn.getText());
                              pst2.setString(9,Gender.getSelectedItem().toString());
                              pst2.setString(10,Height.getText());
                              pst2.setString(11,HouseNumber.getText());
                              pst2.setString(12,IssueDate.getJFormattedTextField().getText());
                              pst2.setString(13,Moo.getText());
                              pst2.setString(14,MotherFullName.getText());
                              pst2.setString(15,Nationality.getText());
                              pst2.setString(16,Occupation.getText());
                              pst2.setString(17,OtherName.getText());
                              pst2.setString(18,PassportNumber.getText());
                              pst2.setString(19,PeopleRegistrationID.getText());
                              pst2.setString(20,PhonePerson.getText());
                              pst2.setString(21,Province.getText());
                              pst2.setString(22,Race.getText());
                              pst2.setString(23,Religion.getText());
                              pst2.setString(24,Tambon.getText());                         
                              pst2.setString(25,Weight.getText());
                              pst2.setString(26,ZipCode.getText());
                                pst2.executeUpdate(); 
                                pst2.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);

//             System.out.println("SQL : "+pst2);
        }
        }
      } catch (Exception e) {
      }
  
  }
       public static String DateCard(String dateC) throws Exception{
     
     
      Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("d/MM/yyyy");
          if(dateC.equals("")){
              String a="";
        return   a;
        
        }
        else{
        Date date = inputFormat.parse(dateC);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
        }
     }
public static String ChangeGender(String gender) throws Exception{
         
        if(gender.equals("1")){       
        return   "ชาย";
        }
        else{       
              return   "หญิง";
        }
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    private javax.swing.JTextField AmphurDie;
    private javax.swing.JTextField AmphurFoundBody;
    private javax.swing.JComboBox<String> BloodGroup;
    private javax.swing.JButton BtSaveAccused;
    private javax.swing.JTextField DeathLocation;
    private javax.swing.JTextField FatherFullName;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField FullNamePersonEn;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField HouseNumber;
    private javax.swing.JTextField Identification;
    private javax.swing.JTextField Moo;
    private javax.swing.JTextField MotherFullName;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField OrderPerson;
    private javax.swing.JTextField OtherName;
    private javax.swing.JTextField PassportNumber;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PhonePerson;
    private javax.swing.JTextField PlaceOfFoundBody;
    private javax.swing.JTextField Province;
    private javax.swing.JTextField ProvinceDie;
    private javax.swing.JTextField ProvinceFoundBody;
    private javax.swing.JTextField Race;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField TambomDie;
    private javax.swing.JTextField TambomFoundBody;
    private javax.swing.JTextField Tambon;
    private javax.swing.JTextField Weight;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JLabel crimecaseno;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBirthDay;
    private javax.swing.JPanel jPanelDeadDate;
    private javax.swing.JPanel jPanelExpiredDate;
    private javax.swing.JPanel jPanelFoundBody;
    private javax.swing.JPanel jPanelIssueDate;
    private javax.swing.JSpinner jSpinnerBodyFoundTime;
    private javax.swing.JSpinner jSpinnerDeadTime;
    // End of variables declaration//GEN-END:variables
}
