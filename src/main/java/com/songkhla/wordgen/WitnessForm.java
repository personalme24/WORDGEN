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
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;
import java.util.Date;

/**
 *
 * @author Computer
 */
public class WitnessForm extends javax.swing.JDialog {
    Connection con=null;
    Connection con2=null;
     PreparedStatement pst=null;
     PreparedStatement pst2=null;
     boolean isInsert,isPerson;
     String noPerson,typeCase;
          ArrayList<String> personname=new ArrayList<String>();

          JDatePickerImpl IssueDate,ExpiredDate,BirthDay;

    /**
     * Creates new form AccusedForm
     */
    public WitnessForm(JFrame parrent,JSONObject datain,JSONObject datacase) {
        super(parrent,true);
        initComponents();  
          ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
            crimecaseno.setVisible(false);
            AnswerPerson.setVisible(false);
        jButtonInjuryOrDie.setVisible(false);
       CauseSendInjuredOrDie.setVisible(false);
       WhereSendInjuredOrDie.setVisible(false);
       TimeSendInjuredOrDie.setVisible(false);
       DateSendInjuredOrDie.setVisible(false);
      UtilDateModel model2 = new UtilDateModel();
            model2.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
          JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         IssueDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
    IssueDate.setPreferredSize(new Dimension(237,30));
    IssueDate.getComponent(0).setPreferredSize(new Dimension(207,30)); //JFormattedTextField
    IssueDate.getComponent(1).setPreferredSize(new Dimension(30,30));//JButton
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
                 BirthDay.setPreferredSize(new Dimension(247,30));
    BirthDay.getComponent(0).setPreferredSize(new Dimension(217,30)); //JFormattedTextField
    BirthDay.getComponent(1).setPreferredSize(new Dimension(30,30));//JButton
        BirthDay.setTextEditable(true);
        BirthDay.setBackground(Color.WHITE);
        jPanelBirthDay.setLayout(new FlowLayout());
        jPanelBirthDay.add(BirthDay);
//        
  FullNamePerson.addCaretListener(new TextFieldCaretListener());
     jComboBoxListName.addActionListener(new ComboBoxActionListener());
        String[] ItemDead = {"","พยาน","บิดาผู้ตาย", "มารดาผู้ตาย", "บุตรผู้ตาย", "สามีผูตาย", "ภรรยาผู้ตาย", "ผู้ปกครองผู้ตาย", "พี่ร่วมบิดามารดาของผู้ตาย",
                               "พี่ร่วมบิดาของผู้ตาย", "พี่ร่วมมารดาของผู้ตาย", "น้องร่วมบิดามารดาของผู้ตาย", "น้องร่วมบิดาของผู้ตาย", "น้องร่วมมารดาของผู้ตาย",
                                "ลุงผู้ตาย","ป้าผู้ตาย","น้าผู้ตาย","อาผู้ตาย","ปู่ผู้ตาย","ย่าผู้ตาย","ตาผู้ตาย","ยายผู้ตาย","หลานผู้ตาย","เหลนผู้ตาย","ผู้มีส่วนได้เสียกับผู้ตาย","พนักงานสอบสวนในคดี"};
           String[] ItemWitness = {"","ผู้พบการกระทำผิด", "พยาน", "ผู้แจ้ง", "ญาติ", "นายประกัน", "บิดาผู้ต้องหา", "มารดาผู้ต้องหา","ผู้ปกครองหรือผู้ดูแลผู้ต้องหา","เจ้าหน้าที่สืบสวน"
                                   ,"พนักงานสอบสวนในคดี","ล่าม","ไม่ระบุ"};
     typeCase=datacase.get("TypeCase")+"";
  if(typeCase.equals("ชันสูตร")){
     Related.setModel(new DefaultComboBoxModel<>(ItemDead));
   
     }
     else{
      Related.setModel(new DefaultComboBoxModel<>(ItemWitness));
     
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
          if(datain!=null){
            isInsert=false;
            noPerson=datain.get("NoPerson")+"";
            crimecaseno.setText(datain.get("caseIdPerson")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            FullNamePerson.setText(datain.get("FullNamePerson")+"");
            Related.setSelectedItem(datain.get("Related"));
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
             ZipCode.setText(datain.get("ZipCode")+"");
            Race.setText(datain.get("Race")+"");
            Religion.setText(datain.get("Religion")+"");
            Tambon.setText(datain.get("Tambon")+"");
            PhonePerson.setText(datain.get("PhonePerson")+"");   
            Gender.setSelectedItem(datain.get("Gender"));
            OrderPerson.setText(datain.get("OrderPerson")+"");       
            OtherName.setText(datain.get("OtherName")+""); 
             OccupationPosition.setText(datain.get("OccupationPosition")+"");       
            AnswerPerson.setText(datain.get("AnswerPerson")+"");
//                    data.put("Gender", rs.getString("Gender"));
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

        }else{
           crimecaseno.setText(ListWitness.txtCaseNO.getText());
            isInsert=true;
          
        }
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
          
//       --------------------------------Right Click----------------------------------------------------
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
       JTextPopupMenu.addTo(OccupationPosition);
       JTextPopupMenu.addTo(Occupation);
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
            
    WitnessForm(ListAccused aThis, boolean b) {
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
        OccupationPosition = new javax.swing.JTextField();
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
        Related = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jPanelBirthDay = new javax.swing.JPanel();
        jPanelIssueDate = new javax.swing.JPanel();
        jPanelExpiredDate = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        OrderPerson = new javax.swing.JTextField();
        jComboBoxListName = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        Occupation = new javax.swing.JTextField();
        BloodGroup = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        AnswerPerson = new javax.swing.JTextField();
        WhereSendInjuredOrDie = new javax.swing.JTextField();
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        TimeSendInjuredOrDie = new javax.swing.JSpinner(sm3);
        jCheckInjured = new javax.swing.JCheckBox();
        jCheckDead = new javax.swing.JCheckBox();
        CauseSendInjuredOrDie = new javax.swing.JTextField();
        DateSendInjuredOrDie = new javax.swing.JTextField();
        jButtonInjuryOrDie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ข้อมูลพยานและบุคคลอื่นๆ");

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        crimecaseno.setText("เลขคดี");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(1157, 850));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 50, -1, 32));

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });
        jPanel2.add(PeopleRegistrationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 52, 189, 32));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 102, -1, 32));

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เลขหนังสือเดินทาง");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 51, -1, 32));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 98, -1, 32));

        PassportNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(PassportNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 52, 202, 32));

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 51, -1, -1));

        BtSaveAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        BtSaveAccused.setText("บันทึก");
        BtSaveAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveAccusedActionPerformed(evt);
            }
        });
        jPanel2.add(BtSaveAccused, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 492, 108, 32));

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(FullNamePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 51, 231, 33));

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(OtherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 103, 189, 32));

        FullNamePersonEn.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(FullNamePersonEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 151, 189, 32));

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("อายุ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 148, -1, 32));

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("วันเกิด");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 154, -1, -1));

        Age.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AgeKeyTyped(evt);
            }
        });
        jPanel2.add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 149, 85, 32));

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ชื่อภาษาอังกฤษ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 111, 32));

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Nationality.setText("ไทย");
        jPanel2.add(Nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 211, 189, 32));

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("สัญชาติ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 111, 32));

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("เชื้อชาติ");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 210, -1, 32));

        Race.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Race.setText("ไทย");
        jPanel2.add(Race, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 211, 247, 32));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("ที่ทำงาน ตำแหน่ง หน้าที่");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 307, -1, -1));

        Gender.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ชาย", "หญิง", "ไม่ระบุ" }));
        jPanel2.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 264, 250, 32));

        OccupationPosition.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(OccupationPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 307, 830, 32));

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("เพศ");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 264, 40, 32));

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("สูง");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 199, -1, 32));

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        Religion.setText("พุทธ");
        jPanel2.add(Religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 149, 93, 32));

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("น้ำหนัก");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(818, 199, -1, 32));

        Height.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 200, 83, 30));

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("ศาสนา");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 148, -1, 32));

        Weight.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 200, 93, 32));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, 111, 32));

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("หมู่โลหิต");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 261, 111, 32));

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setText("หมายเลขโทรศัพท์");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 347, -1, 32));

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("ชื่อบิดา");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 347, 82, 32));

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel29.setText("ชื่อมารดา");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 347, -1, 32));

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("บ้านเลขที่");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 387, 87, 32));

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 387, -1, 32));

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("เขต/อำเภอ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 387, -1, 32));

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 387, -1, 32));

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("จังหวัด");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 387, -1, 32));

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(HouseNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 387, 80, 32));

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(FatherFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 347, 189, 32));

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(MotherFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 347, 247, 34));

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PhonePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhonePersonActionPerformed(evt);
            }
        });
        jPanel2.add(PhonePerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 347, 220, 33));
        PhonePerson.getAccessibleContext().setAccessibleName("");

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("หมู่ที่");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 387, -1, 32));

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Moo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 387, 62, 32));

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Tambon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TambonKeyReleased(evt);
            }
        });
        jPanel2.add(Tambon, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 387, 89, 32));

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Amphur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmphurKeyReleased(evt);
            }
        });
        jPanel2.add(Amphur, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 387, 85, 32));

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
        jPanel2.add(ZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 387, 70, 32));

        Province.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Province, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 387, 156, 32));

        Related.setEditable(true);
        Related.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Related, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 427, 190, 32));

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("เกี่ยวข้องเป็น");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 427, -1, 32));

        jPanelBirthDay.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelBirthDayLayout = new javax.swing.GroupLayout(jPanelBirthDay);
        jPanelBirthDay.setLayout(jPanelBirthDayLayout);
        jPanelBirthDayLayout.setHorizontalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 247, Short.MAX_VALUE)
        );
        jPanelBirthDayLayout.setVerticalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelBirthDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 150, -1, -1));

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
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelIssueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 102, 237, -1));

        jPanelExpiredDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelExpiredDate.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelExpiredDateLayout = new javax.swing.GroupLayout(jPanelExpiredDate);
        jPanelExpiredDate.setLayout(jPanelExpiredDateLayout);
        jPanelExpiredDateLayout.setHorizontalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );
        jPanelExpiredDateLayout.setVerticalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanel2.add(jPanelExpiredDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 98, -1, -1));

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setText("พยานและบุคคลอื่นคนที่");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, 31));

        OrderPerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(OrderPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 14, 56, 29));

        jComboBoxListName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxListName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListNameActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxListName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel28.setText("อาชีพ");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 253, -1, -1));

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.add(Occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(734, 253, 220, 32));

        BloodGroup.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        BloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O", "A Rh-", "B Rh-", "AB Rh-", "O Rh-" }));
        jPanel2.add(BloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 264, 189, 32));

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("คำให้การ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(963, 51, -1, -1));
        jPanel2.add(AnswerPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 427, 163, 32));
        jPanel2.add(WhereSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 21, 20, -1));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(TimeSendInjuredOrDie, "HH:mm");
        TimeSendInjuredOrDie.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        TimeSendInjuredOrDie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimeSendInjuredOrDieKeyReleased(evt);
            }
        });
        jPanel2.add(TimeSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(539, 21, -1, -1));

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
        jPanel2.add(jCheckInjured, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 13, -1, 30));

        jCheckDead.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckDead.setText("ตาย");
        jCheckDead.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckDeadItemStateChanged(evt);
            }
        });
        jPanel2.add(jCheckDead, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 13, -1, 30));
        jPanel2.add(CauseSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 21, 20, -1));
        jPanel2.add(DateSendInjuredOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 21, 20, -1));

        jButtonInjuryOrDie.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonInjuryOrDie.setText("รายละเอียด");
        jButtonInjuryOrDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInjuryOrDieActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInjuryOrDie, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 13, -1, 30));

        jScrollPane1.setViewportView(jPanel2);
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSaveAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveAccusedActionPerformed
        // TODO add your handling code here:
               con=ConnectDatabase.connect();
               SimpleDateFormat format = new SimpleDateFormat("HH:mm");
              String sendTime=format.format(TimeSendInjuredOrDie.getValue());
        if(isInsert){    
        String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                        "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                        "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,caseIdPerson,Related,OrderPerson,AnswerPerson,"
                + "OccupationPosition,CauseSendInjuredOrDie,WhereSendInjuredOrDie,DateSendInjuredOrDie,TimeSendInjuredOrDie,StatusInjuryOrDie)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
                              pst.setString(25,"พยานและบุคคลอื่นๆ");
                              pst.setString(26,Weight.getText());
                              pst.setString(27,ZipCode.getText());
                              pst.setString(28,crimecaseno.getText());
                              pst.setString(29,Related.getSelectedItem().toString());
                              pst.setString(30,OrderPerson.getText());
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
             JOptionPane.showMessageDialog(null, e); 
             System.out.println("SQL : "+pst);
        }
        }
        else{
             String sqlUpdate="Update Person set Age=?,Amphur=?,BirthDay=?,\n" +
                                    "BloodGroup=?,ExpiredDate=?,FatherFullName=?,FullNamePerson=?,FullNamePersonEn=?,\n" +
                                    "Gender=?,Height=?,HouseNumber=?,IssueDate=?,Moo=?,MotherFullName=?,Nationality=?,Occupation=?,\n" +
                                    "OtherName=?,PassportNumber=?,PeopleRegistrationID=?,PhonePerson=?,Province=?,Race=?,Religion=?,\n" +
                                    "Tambon=?,TypePerson=?,Weight=?,ZipCode=? ,caseIdPerson=?,OrderPerson=?,Related=?,AnswerPerson=?,OccupationPosition=?,"
                                     + "CauseSendInjuredOrDie=?,WhereSendInjuredOrDie=?,DateSendInjuredOrDie=?,TimeSendInjuredOrDie=?,StatusInjuryOrDie=? where NoPerson=? and TypePerson=?   ";
       
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
                              pst.setString(25,"พยานและบุคคลอื่นๆ");
                              pst.setString(26,Weight.getText());
                              pst.setString(27,ZipCode.getText());
                              pst.setString(28,crimecaseno.getText());
                              pst.setString(29,OrderPerson.getText());
                              pst.setString(30,Related.getSelectedItem().toString());
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
                              pst.setString(38,noPerson);
                              pst.setString(39,"พยานและบุคคลอื่นๆ");
                           int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                            pst.executeUpdate();
                              pst.close();
                              System.out.println("SQL : "+sqlUpdate);
                            setVisible(false); 

                                } 
        } catch (Exception e) {
                JOptionPane.showMessageDialog(jPanel1, "บันทึกข้อมูลไม่สำเร็จ" ,null, JOptionPane.INFORMATION_MESSAGE);

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
 }  // TODO add your handling code here:
    }//GEN-LAST:event_PeopleRegistrationIDKeyTyped

    private void ZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZipCodeKeyTyped
        char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
            if(ZipCode.getText().length()>=5) {  
           evt.consume();
 }  // TODO add your han// TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeKeyTyped

    private void AgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AgeKeyTyped
        char vChar = evt.getKeyChar();
        if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
        if(Age.getText().length()>=3) {  
           evt.consume();
 }  // TODO add your han        // TODO add your handling code here:
    }//GEN-LAST:event_AgeKeyTyped

    private void ZipCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeActionPerformed

    private void jComboBoxListNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxListNameActionPerformed

    private void PhonePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhonePersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhonePersonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JSONObject type=new JSONObject();
        type.put("TypeCase", typeCase);
        type.put("TypePerson", "พยานและบุคคลอื่น");
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
    AnswerPersonForm rf =new AnswerPersonForm(in,type);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jButtonInjuryOrDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInjuryOrDieActionPerformed
        // TODO add your handling code here:
        JSONObject type=new JSONObject();
        type.put("TypeCase", typeCase);
        type.put("TypePerson", "พยานและบุคคลอื่น");
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
        InjuryOrDie rf =new InjuryOrDie(in,type);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_jButtonInjuryOrDieActionPerformed

    private void TimeSendInjuredOrDieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimeSendInjuredOrDieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeSendInjuredOrDieKeyReleased

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
            java.util.logging.Logger.getLogger(WitnessForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WitnessForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WitnessForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WitnessForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        DataCase dcc=new DataCase();
//        labelCaseNo.setText("dfv");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                    
            }
        });
    }
      private class ComboBoxActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        try{
            FullNamePerson.setText(jComboBoxListName.getSelectedItem().toString());
            jComboBoxListName.removeAllItems();
            jComboBoxListName.hidePopup();
            jPanel2.remove(jComboBoxListName);
        }
        catch(Exception any){
        
        }
        }
  
  }
    private class TextFieldCaretListener implements  CaretListener{
   public void caretUpdate(CaretEvent e){
    
       try{
        jComboBoxListName.removeAllItems();
        jComboBoxListName.hidePopup();
        jPanel2.remove(jComboBoxListName);
        
        if(e.getMark()>0){
            
        for(String string:personname){
           if(string.toLowerCase().startsWith(FullNamePerson.getText().toLowerCase())){
             jPanel2.add(jComboBoxListName);
             jComboBoxListName.addItem(string);
             jComboBoxListName.showPopup();
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

   
            }
        
        
  
       }
       catch(Exception e1){
       }
       if(e.getMark()<2){
       jPanel2.remove(jComboBoxListName);
       }
   }
  

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

                     
//                          
                               
         pst2.executeUpdate(); 
         pst2.close();
         System.out.println("SQL : "+sql2);


      
        } catch (Exception e) {
             JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);

             System.out.println("SQL : "+pst2);
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
//
//   
            }
       }catch(Exception ex){}
    
    
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
    private javax.swing.JComboBox<String> Related;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField Tambon;
    public static javax.swing.JSpinner TimeSendInjuredOrDie;
    private javax.swing.JTextField Weight;
    public static javax.swing.JTextField WhereSendInjuredOrDie;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JLabel crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonInjuryOrDie;
    private javax.swing.JCheckBox jCheckDead;
    private javax.swing.JCheckBox jCheckInjured;
    private javax.swing.JComboBox<String> jComboBoxListName;
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
