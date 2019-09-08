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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;

/**
 *
 * @author Computer
 */
public class AccusedForm extends javax.swing.JDialog {
    Connection con=null;
    Connection con2=null;
     PreparedStatement pst=null;
     PreparedStatement pst2=null;
     boolean isInsert,isPerson;
     
     String noPerson,typeCase;
     JDatePickerImpl IssueDate,ExpiredDate,BirthDay;
     ArrayList<String> personname=new ArrayList<String>();
      
//     private JComboBox<String> comboBox;
    /**
     * Creates new form AccusedForm
     */
    public AccusedForm(JFrame parrent,JSONObject datain,JSONObject datacase) {
        super(parrent,true);
        initComponents();  
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
      
//     Occupation = new HintTextField("Another hint here");
     crimecaseno.setVisible(false);
     AnswerPerson.setVisible(false);
        jButtonInjuryOrDie.setVisible(false);
       CauseSendInjuredOrDie.setVisible(false);
       WhereSendInjuredOrDie.setVisible(false);
       TimeSendInjuredOrDie.setVisible(false);
       DateSendInjuredOrDie.setVisible(false);

     FullNamePerson.addCaretListener(new TextFieldCaretListener());
     comboBox.addActionListener(new ComboBoxActionListener());
     UtilDateModel model2 = new UtilDateModel();
//            model2.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
          JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         IssueDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
        IssueDate.setTextEditable(true);
        IssueDate.setBackground(Color.WHITE);
        jPanelIssueDate.setLayout(new FlowLayout());
        jPanelIssueDate.add(IssueDate); 
        
        UtilDateModel model3 = new UtilDateModel();
//            model3.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p);
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
        typeCase=datacase.get("TypeCase")+"";
               String[] ItemDead = {"","พยาน","บิดาผู้ตาย", "มารดาผู้ตาย", "บุตรผู้ตาย", "สามีผูตาย", "ภริยาผู้ตาย", "ผู้ปกครองผู้ตาย", "พี่ร่วมบิดามารดาของผู้ตาย",
                               "พี่ร่วมบิดาของผู้ตาย", "พี่ร่วมมารดาของผู้ตาย", "น้องร่วมบิดามารดาของผู้ตาย", "น้องร่วมบิดาของผู้ตาย", "น้องร่วมมารดาของผู้ตาย",
                                "ลุงผู้ตาย","ป้าผู้ตาย","น้าผู้ตาย","อาผู้ตาย","ปู่ผู้ตาย","ย่าผู้ตาย","ตาผู้ตาย","ยายผู้ตาย","หลานผู้ตาย","เหลนผู้ตาย","ผู้มีส่วนได้เสียกับผู้ตาย","พนักงานสอบสวนในคดี"};
       String[] ItemCrimes= {"","ผู้จับกุมผู้ต้องหาและยึดของกลาง", "ผู้จับกุมผู้ต้องหา", "ผู้พบการกระทำผิดและยึดของกลาง", "ผู้พบการกระทำผิด", "ผู้เสียหาย", "ผู้จัดการแทนผู้เสียหาย", "ผู้รับมอบอำนาจจากผู้เสียหาย","พนักงานสอบสวนในคดี"};
       if(typeCase.equals("ชันสูตร")){
           RelatedAccused.setModel(new DefaultComboBoxModel<>(ItemDead));

       }
        else {
           RelatedAccused.setModel(new DefaultComboBoxModel<>(ItemCrimes));

       }
          if(datain!=null){
            isInsert=false;
            noPerson=datain.get("NoPerson")+"";
            crimecaseno.setText(datain.get("crimecaseno")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            FullNamePerson.setText(datain.get("FullNamePerson")+"");
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
            Province.setText(datain.get("Province")+"");
            Race.setText(datain.get("Race")+"");
            Religion.setText(datain.get("Religion")+"");
            Tambon.setText(datain.get("Tambon")+"");
             PhonePerson.setText(datain.get("PhonePerson")+"");  
             Gender.setSelectedItem(datain.get("Gender"));
            OrderPerson.setText(datain.get("OrderPerson")+"");             
             ZipCode.setText(datain.get("ZipCode")+"");
            OtherName.setText(datain.get("OtherName")+"");
           OccupationPosition.setText(datain.get("OccupationPosition")+"");
            AnswerPerson.setText(datain.get("AnswerPerson")+"");
            RelatedAccused.setSelectedItem(datain.get("Related")+"");
           
            String statusInjure=datain.get("StatusInjuryOrDie")+"";
            if(statusInjure.equals("บาดเจ็บ")){
            jCheckInjured.setSelected(true);
            }
           else if(statusInjure.equals("ตาย")){
            jCheckDead.setSelected(true);
            }
            try{
            String ote=datain.get("TimeSendInjuredOrDie")+"";
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date timeSend = timeFormat.parse(ote);
                TimeSendInjuredOrDie.setValue(timeSend);
            }
            catch(Exception ex){
            
            }
            
           DateSendInjuredOrDie.setText(datain.get("DateSendInjuredOrDie")+"");   
           CauseSendInjuredOrDie.setText(datain.get("CauseSendInjuredOrDie")+"");
           WhereSendInjuredOrDie.setText(datain.get("WhereSendInjuredOrDie")+"");


       
//                    data.put("Gender", rs.getString("Gender"));


        }else{
              
           crimecaseno.setText(ListAccused.txtCaseNO.getText());
            isInsert=true;
          
        }
          FullNamePerson.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                         SetTextPerson();
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                          SetTextPerson();

                           }
             }
             );
        try {
              Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select FullNamePerson,PeopleRegistrationID from persondata ";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
             String name = res.getString("FullNamePerson");        
             personname.add(name);
//                System.out.println("Array : "+personname);  
        } 
       res.close();
        } catch (Exception e) {
        }
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
        
       JTextPopupMenu.addTo(OrderPerson);
       JTextPopupMenu.addTo(PeopleRegistrationID);
       JTextPopupMenu.addTo(ExpiredDate.getJFormattedTextField());
       JTextPopupMenu.addTo(IssueDate.getJFormattedTextField());
       JTextPopupMenu.addTo(PassportNumber);
       JTextPopupMenu.addTo(FullNamePerson);
       JTextPopupMenu.addTo(OtherName);
       JTextPopupMenu.addTo(FullNamePersonEn);
       JTextPopupMenu.addTo(BirthDay.getJFormattedTextField());
       JTextPopupMenu.addTo(Age);
       JTextPopupMenu.addTo(Religion);
       JTextPopupMenu.addTo(Nationality);
       JTextPopupMenu.addTo(Race);
       JTextPopupMenu.addTo(Height);
       JTextPopupMenu.addTo(Weight);
       JTextPopupMenu.addTo(Occupation);
       JTextPopupMenu.addTo(OccupationPosition);
       JTextPopupMenu.addTo(FatherFullName);
       JTextPopupMenu.addTo(MotherFullName);
       JTextPopupMenu.addTo(PhonePerson);
       JTextPopupMenu.addTo(HouseNumber);
       JTextPopupMenu.addTo(Moo);
       JTextPopupMenu.addTo(Tambon);
       JTextPopupMenu.addTo(Amphur);
       JTextPopupMenu.addTo(Province);
       JTextPopupMenu.addTo(ZipCode);

       
    }

    AccusedForm(ListAccused aThis, boolean b) {
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
        jLabel3 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PeopleRegistrationID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PassportNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        BtSaveAccused = new javax.swing.JButton();
        FullNamePerson = new javax.swing.JTextField();
        OtherName = new javax.swing.JTextField();
        FullNamePersonEn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Nationality = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Race = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        Occupation = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Religion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Weight = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        HouseNumber = new javax.swing.JTextField();
        FatherFullName = new javax.swing.JTextField();
        MotherFullName = new javax.swing.JTextField();
        PhonePerson = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Moo = new javax.swing.JTextField();
        Tambon = new javax.swing.JTextField();
        Amphur = new javax.swing.JTextField();
        ZipCode = new javax.swing.JTextField();
        Province = new javax.swing.JTextField();
        jPanelBirthDay = new javax.swing.JPanel();
        jPanelIssueDate = new javax.swing.JPanel();
        jPanelExpiredDate = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        OrderPerson = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        RelatedAccused = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        OccupationPosition = new javax.swing.JTextField();
        BloodGroup = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        AnswerPerson = new javax.swing.JTextField();
        jCheckInjured = new javax.swing.JCheckBox();
        jCheckDead = new javax.swing.JCheckBox();
        jButtonInjuryOrDie = new javax.swing.JButton();
        CauseSendInjuredOrDie = new javax.swing.JTextField();
        WhereSendInjuredOrDie = new javax.swing.JTextField();
        DateSendInjuredOrDie = new javax.swing.JTextField();
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        TimeSendInjuredOrDie = new javax.swing.JSpinner(sm3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ข้อมูลผู้กล่าวหา");

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        crimecaseno.setText("เลขคดี");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crimecaseno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(crimecaseno))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 32));

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });
        jPanel2.add(PeopleRegistrationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 223, 32));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, 32));

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เลขหนังสือเดินทาง");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 32));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, -1, 32));

        PassportNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(PassportNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 162, 32));

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, 32));

        BtSaveAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        BtSaveAccused.setText("บันทึก");
        BtSaveAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveAccusedActionPerformed(evt);
            }
        });
        jPanel2.add(BtSaveAccused, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 108, 32));

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(FullNamePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 50, 216, 32));

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(OtherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 226, 32));

        FullNamePersonEn.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(FullNamePersonEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 223, 32));

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("อายุ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, 32));

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("วันเกิด");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 82, 32));

        Age.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AgeKeyTyped(evt);
            }
        });
        jPanel2.add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, 66, 32));

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ชื่อภาษาอังกฤษ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 32));

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Nationality.setText("ไทย");
        jPanel2.add(Nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 223, 32));

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("สัญชาติ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 57, 32));

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("เชื้อชาติ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 82, 32));

        Race.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Race.setText("ไทย");
        Race.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaceActionPerformed(evt);
            }
        });
        jPanel2.add(Race, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 185, 32));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("อาชีพ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, -1, 32));

        Gender.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ชาย", "หญิง", "ไม่ระบุ" }));
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel2.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 185, 32));

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        //Occupation = new HintTextField("หากเป็นตำรวจ รับราชการตำรวจ");
        Occupation.setToolTipText("");
        jPanel2.add(Occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 290, 32));

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("เพศ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 82, 32));

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("สูง");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, -1, 32));

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Religion.setText("พุทธ");
        jPanel2.add(Religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 150, 170, 32));

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("น้ำหนัก");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, -1, 32));

        Height.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 66, 32));

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("ศาสนา");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, -1, 32));

        Weight.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 170, 32));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 104, 32));

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("หมู่โลหิต");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 32));

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setText("หมายเลขโทรศัพท์");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, -1, 32));

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("ชื่อบิดา");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 32));

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel29.setText("ชื่อมารดา");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 74, 32));

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("บ้านเลขที่");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 111, 32));

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, 32));

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("เขต/อำเภอ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, -1, 32));

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 107, 32));

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("จังหวัด");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, -1, 32));

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(HouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 121, 32));

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(FatherFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 223, 32));

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(MotherFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 185, 32));

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(PhonePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 290, 32));
        PhonePerson.getAccessibleContext().setAccessibleName("");

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("หมู่ที่");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, 32));

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Moo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 59, 32));

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Tambon, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 103, 32));

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Amphur, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 85, 32));

        ZipCode.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ZipCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipCodeActionPerformed(evt);
            }
        });
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZipCodeKeyTyped(evt);
            }
        });
        jPanel2.add(ZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 223, 32));

        Province.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Province.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProvinceActionPerformed(evt);
            }
        });
        jPanel2.add(Province, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 390, 290, 32));

        jPanelBirthDay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBirthDay.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelBirthDayLayout = new javax.swing.GroupLayout(jPanelBirthDay);
        jPanelBirthDay.setLayout(jPanelBirthDayLayout);
        jPanelBirthDayLayout.setHorizontalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelBirthDayLayout.setVerticalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelBirthDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 143, -1, -1));

        jPanelIssueDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelIssueDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelIssueDateLayout = new javax.swing.GroupLayout(jPanelIssueDate);
        jPanelIssueDate.setLayout(jPanelIssueDateLayout);
        jPanelIssueDateLayout.setHorizontalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelIssueDateLayout.setVerticalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 94, -1, -1));

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelExpiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 92, 216, -1));

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel19.setText("คนที่");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 13, -1, -1));

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel28.setText("ผู้กล่าวหา");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 13, -1, -1));

        OrderPerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(OrderPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 50, -1));

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 125, 185, 0));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("เกี่ยวข้องเป็น");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 107, 30));

        RelatedAccused.setEditable(true);
        RelatedAccused.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel2.add(RelatedAccused, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 219, 32));

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("ที่ทำงาน ตำแหน่ง หน้าที่");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 32));

        OccupationPosition.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        OccupationPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OccupationPositionActionPerformed(evt);
            }
        });
        jPanel2.add(OccupationPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 900, 32));

        BloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O", "A Rh-", "B Rh-", "AB Rh-", "O Rh-" }));
        jPanel2.add(BloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 223, 32));

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        jButton1.setText("คำให้การ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 50, -1, 32));

        AnswerPerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jPanel2.add(AnswerPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 60, 30));

        jCheckInjured.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckInjured.setText("บาดเจ็บ");
        jCheckInjured.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckInjuredItemStateChanged(evt);
            }
        });
        jCheckInjured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckInjuredActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckInjured, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 30));

        jCheckDead.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckDead.setText("ตาย");
        jCheckDead.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckDeadItemStateChanged(evt);
            }
        });
        jPanel2.add(jCheckDead, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, 30));

        jButtonInjuryOrDie.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonInjuryOrDie.setText("รายละเอียด");
        jButtonInjuryOrDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInjuryOrDieActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInjuryOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 30));
        jPanel2.add(CauseSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 20, -1));
        jPanel2.add(WhereSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 20, -1));
        jPanel2.add(DateSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 20, -1));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(TimeSendInjuredOrDie, "HH:mm");
        TimeSendInjuredOrDie.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        TimeSendInjuredOrDie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimeSendInjuredOrDieKeyReleased(evt);
            }
        });
        jPanel2.add(TimeSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jScrollPane1.setViewportView(jPanel2);
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PeopleRegistrationIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PeopleRegistrationIDKeyTyped
           char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
         if(PeopleRegistrationID.getText().length()>=13) {  
           evt.consume();
 }     // TODO add your handling code here:
    }//GEN-LAST:event_PeopleRegistrationIDKeyTyped

    private void AgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AgeKeyTyped
           char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }  // TODO add your handling code here:
    }//GEN-LAST:event_AgeKeyTyped

    private void ZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZipCodeKeyTyped
     char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }     
     
                  if(ZipCode.getText().length()>=5) {  
           evt.consume();
 }  // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeKeyTyped

    private void ZipCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeActionPerformed

    private void BtSaveAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveAccusedActionPerformed
 con=ConnectDatabase.connect();   
             SimpleDateFormat format = new SimpleDateFormat("HH:mm");
              String sendTime=format.format(InjuryOrDie.TimeSendInjuredOrDie.getValue());
        if(isInsert){    
         
        String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                        "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                        "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,caseIdPerson,OrderPerson,Related,AnswerPerson,OccupationPosition,"
                      + "CauseSendInjuredOrDie,WhereSendInjuredOrDie,DateSendInjuredOrDie,TimeSendInjuredOrDie,StatusInjuryOrDie)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        String sqlinsert = "INSERT INTO PersonData (FullNamePerson,Race) VALUES (?,?)";
         System.out.println("SQL : "+sql);
      try {
            pst=con.prepareStatement(sql);
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
                              pst.setString(25,"ผู้กล่าวหา");
                              pst.setString(26,Weight.getText());
                              pst.setString(27,ZipCode.getText());
                              pst.setString(28,crimecaseno.getText());
                              pst.setString(29,OrderPerson.getText());
                               pst.setString(30,RelatedAccused.getSelectedItem()+"");
                               pst.setString(31,AnswerPerson.getText());
                              pst.setString(32,OccupationPosition.getText());
                              pst.setString(33,CauseSendInjuredOrDie.getText());
                              pst.setString(34,WhereSendInjuredOrDie.getText());
                              pst.setString(35,DateSendInjuredOrDie.getText());
                              pst.setString(36,sendTime);
                              if(jCheckInjured.isSelected()){
                               pst.setString(37,jCheckInjured.getText());
                              }
                              else if(jCheckDead.isSelected()){
                              pst.setString(37,jCheckDead.getText());
                              }
                              
                                      
//                              --------------Insert Person---------------------------------
                      
                               
//                               JOptionPane.showMessageDialog(jPanel1,"ยืนยัน","บันทึกข้อมูล", JOptionPane.INFORMATION_MESSAGE);
                            
     int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
      InsertPerson();
         System.out.println("SQL : "+sql);
        setVisible(false); 

     } 
        } catch (Exception e) {
             JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);

             System.out.println("SQL : "+pst);
        }
        }
        else{
             String sqlUpdate="Update Person set Age=?,Amphur=?,BirthDay=?,\n" +
                                    "BloodGroup=?,ExpiredDate=?,FatherFullName=?,FullNamePerson=?,FullNamePersonEn=?,\n" +
                                    "Gender=?,Height=?,HouseNumber=?,IssueDate=?,Moo=?,MotherFullName=?,Nationality=?,Occupation=?,\n" +
                                    "OtherName=?,PassportNumber=?,PeopleRegistrationID=?,PhonePerson=?,Province=?,Race=?,Religion=?,\n" +
                                    "Tambon=?,TypePerson=?,Weight=?,ZipCode=? ,caseIdPerson=?,OrderPerson=?,Related=?,OccupationPosition=?,"
                                    + "AnswerPerson=?,CauseSendInjuredOrDie=?,WhereSendInjuredOrDie=?,DateSendInjuredOrDie=?,TimeSendInjuredOrDie=?,StatusInjuryOrDie=? \n"
                                   + "where NoPerson=? and TypePerson=?";
       
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
                              pst.setString(25,"ผู้กล่าวหา");
                              pst.setString(26,Weight.getText());
                              pst.setString(27,ZipCode.getText());
                              pst.setString(28,crimecaseno.getText());
                              pst.setString(29,OrderPerson.getText());
                               pst.setString(30,RelatedAccused.getSelectedItem()+"");
                              pst.setString(31,OccupationPosition.getText());
                              pst.setString(32,AnswerPerson.getText());
                              pst.setString(33,CauseSendInjuredOrDie.getText());
                              pst.setString(34,WhereSendInjuredOrDie.getText());
                              pst.setString(35,DateSendInjuredOrDie.getText());
                              pst.setString(36,sendTime);
                              if(jCheckInjured.isSelected()){
                               pst.setString(37,jCheckInjured.getText());
                              }
                              else if(jCheckDead.isSelected()){
                              pst.setString(37,jCheckDead.getText());
                              }
                              
                            
                              pst.setString(38,noPerson);
                              pst.setString(39,"ผู้กล่าวหา");
                         int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                             pst.executeUpdate(); 
                             pst.close();
                             System.out.println("SQL : "+sqlUpdate);
                            setVisible(false); 

                                } 
        } catch (Exception e) {
                               JOptionPane.showMessageDialog(jPanel1,  "Cannot Save", null,JOptionPane.INFORMATION_MESSAGE);

             System.out.println("SQL : "+pst);
        }
        
        
        
        }
          
                            

               // TODO add your handling code here:
    }//GEN-LAST:event_BtSaveAccusedActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void RaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RaceActionPerformed

    private void OccupationPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OccupationPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OccupationPositionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JSONObject type=new JSONObject();
        type.put("TypeCase", typeCase);
        type.put("TypePerson", "ผู้กล่าวหา");
         JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
    AnswerPersonForm rf =new AnswerPersonForm(in,type);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProvinceActionPerformed

    private void jButtonInjuryOrDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInjuryOrDieActionPerformed
        // TODO add your handling code here:
        JSONObject type=new JSONObject();
        type.put("TypeCase", typeCase);
        type.put("TypePerson", "ผู้กล่าวหา");
         JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
            InjuryOrDie rf =new InjuryOrDie(in,type);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_jButtonInjuryOrDieActionPerformed

    private void jCheckInjuredItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckInjuredItemStateChanged
        // TODO add your handling code here:
               
        if(jCheckInjured.isSelected()){
            jButtonInjuryOrDie.setVisible(true);

        }
        else{
        jButtonInjuryOrDie.setVisible(false);


        }
    }//GEN-LAST:event_jCheckInjuredItemStateChanged

    private void jCheckInjuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckInjuredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckInjuredActionPerformed

    private void jCheckDeadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckDeadItemStateChanged
        // TODO add your handling code here:
         if(jCheckDead.isSelected()){
            jButtonInjuryOrDie.setVisible(true);

        }
        else{
        jButtonInjuryOrDie.setVisible(false);


        }
          
    }//GEN-LAST:event_jCheckDeadItemStateChanged

    private void TimeSendInjuredOrDieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimeSendInjuredOrDieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeSendInjuredOrDieKeyReleased

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
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
  private class TextFieldCaretListener implements  CaretListener{
   public void caretUpdate(CaretEvent e){
    
       try{
        comboBox.removeAllItems();
        comboBox.hidePopup();
        jPanel2.remove(comboBox);
        
        if(e.getMark()>0){
            
        for(String string:personname){
           if(string.toLowerCase().startsWith(FullNamePerson.getText().toLowerCase())){
             jPanel2.add(comboBox);
             comboBox.addItem(string);
             comboBox.showPopup();
               }
	    }
         } 
        Connection c=null;
         c=ConnectDatabase.connect();
            String sqlId="Select * from PersonData where FullNamePerson='"+FullNamePerson.getText()+"'";

            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                PeopleRegistrationID.setText(rs.getString("PeopleRegistrationID")); 
                Age.setText(rs.getString("Age")); 
                Amphur.setText(rs.getString("Amphur")); 
                BloodGroup.setSelectedItem(rs.getString("BloodGroup")); 
                BirthDay.getJFormattedTextField().setText(rs.getString("BirthDay")); 
                FatherFullName.setText(rs.getString("FatherFullName")); 
                FullNamePersonEn.setText(rs.getString("FullNamePersonEn")); 
                Height.setText(rs.getString("Height")); 
                Weight.setText(rs.getString("Weight")); 
                Race.setText(rs.getString("Race")); 
                Religion.setText(rs.getString("Religion")); 
                Nationality.setText(rs.getString("Nationality")); 
                MotherFullName.setText(rs.getString("MotherFullName")); 
                Gender.setSelectedItem(rs.getString("Gender"));
                Occupation.setText(rs.getString("Occupation"));
                PhonePerson.setText(rs.getString("PhonePerson")); 
                MotherFullName.setText(rs.getString("MotherFullName")); 
                PassportNumber.setText(rs.getString("PassportNumber")); 

   
            }
        
        
  
       }
       catch(Exception e1){
       }
       if(e.getMark()<2){
       jPanel2.remove(comboBox);
       }
   }
  }

  private class ComboBoxActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        try{
            FullNamePerson.setText(comboBox.getSelectedItem().toString());
            comboBox.removeAllItems();
            comboBox.hidePopup();
            jPanel2.remove(comboBox);
             
        }
        catch(Exception any){
        
        }
        }
  
  }
  private void Dataperson(){
  
  try {

         Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select FullNamePerson from persondata";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
             String name = res.getString("FullNamePerson");
             personname.add(name);

	
	}
        res.close();
  }
catch (Exception d) {  //System.out.println(d);  
}
  }
  public void InsertPerson(){
       con=ConnectDatabase.connect();
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
                        "PhonePerson,Province,Race,Religion,Tambon,Weight,ZipCode,OccupationPosition)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
                                pst2.setString(27,OccupationPosition.getText());
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
    private void SetTextPerson(){
      try{
        Connection c=null;
         c=ConnectDatabase.connect();
            String sqlId="Select * from PersonData where FullNamePerson='"+FullNamePerson.getText()+"'";

            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                PeopleRegistrationID.setText(rs.getString("PeopleRegistrationID")); 
                IssueDate.getJFormattedTextField().setText(rs.getString("PassportNumber"));                 
                Age.setText(rs.getString("Age")); 
                Amphur.setText(rs.getString("Amphur")); 
                BloodGroup.setSelectedItem(rs.getString("BloodGroup")); 
                BirthDay.getJFormattedTextField().setText(rs.getString("BirthDay")); 
                FatherFullName.setText(rs.getString("FatherFullName")); 
                FullNamePersonEn.setText(rs.getString("FullNamePersonEn")); 
                Height.setText(rs.getString("Height")); 
                Weight.setText(rs.getString("Weight")); 
                Race.setText(rs.getString("Race")); 
                Religion.setText(rs.getString("Religion")); 
                Nationality.setText(rs.getString("Nationality")); 
                MotherFullName.setText(rs.getString("MotherFullName")); 
                Gender.setSelectedItem(rs.getString("Gender"));
                Occupation.setText(rs.getString("Occupation"));
                PhonePerson.setText(rs.getString("PhonePerson")); 
                MotherFullName.setText(rs.getString("MotherFullName")); 
                PassportNumber.setText(rs.getString("PassportNumber")); 
               ExpiredDate.getJFormattedTextField().setText(rs.getString("ExpiredDate")+"");
            HouseNumber.setText(rs.getString("HouseNumber")+"");
            Moo.setText(rs.getString("Moo")+"");
            Province.setText(rs.getString("Province"));
            Tambon.setText(rs.getString("Tambon")+"");
             ZipCode.setText(rs.getString("ZipCode")+"");
            OtherName.setText(rs.getString("OtherName")+"");

//
//   
            }
       }catch(Exception ex){}
    
    
    }
    class HintTextField extends JTextField implements FocusListener {

  private final String hint;
  private boolean showingHint;

  public HintTextField(final String hint) {
    super(hint);
    this.hint = hint;
    this.showingHint = true;
    super.addFocusListener(this);
  }

  @Override
  public void focusGained(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText("");
      showingHint = false;
    }
  }
  @Override
  public void focusLost(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText(hint);
      showingHint = true;
    }
  }

  @Override
  public String getText() {
    return showingHint ? "" : super.getText();
  }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    public static javax.swing.JTextField AnswerPerson;
    private javax.swing.JComboBox<String> BloodGroup;
    private javax.swing.JButton BtSaveAccused;
    public static javax.swing.JTextField CauseSendInjuredOrDie;
    public static javax.swing.JTextField DateSendInjuredOrDie;
    private javax.swing.JTextField FatherFullName;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField FullNamePersonEn;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField HouseNumber;
    private javax.swing.JTextField Moo;
    private javax.swing.JTextField MotherFullName;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField OccupationPosition;
    private javax.swing.JTextField OrderPerson;
    private javax.swing.JTextField OtherName;
    private javax.swing.JTextField PassportNumber;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PhonePerson;
    private javax.swing.JTextField Province;
    private javax.swing.JTextField Race;
    private javax.swing.JComboBox<String> RelatedAccused;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField Tambon;
    public static javax.swing.JSpinner TimeSendInjuredOrDie;
    private javax.swing.JTextField Weight;
    public static javax.swing.JTextField WhereSendInjuredOrDie;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonInjuryOrDie;
    private javax.swing.JCheckBox jCheckDead;
    private javax.swing.JCheckBox jCheckInjured;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelBirthDay;
    private javax.swing.JPanel jPanelExpiredDate;
    private javax.swing.JPanel jPanelIssueDate;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
