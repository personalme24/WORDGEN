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
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.json.simple.JSONObject;

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
    /**
     * Creates new form AccusedForm
     */
    public SuspectForm(JFrame parrent,JSONObject datain) {
        super(parrent,true);     
        initComponents();  
        colseTextBox();
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
          
   
          if(datain!=null){
           eventJButtonManage();
            isInsert=false;
            String statusSus;
            statusSus=datain.get("StatusSuspect")+"";
            caseid=datain.get("caseIdPerson")+"";
            noPerson=datain.get("NoPerson")+"";
            crimecaseno.setText(datain.get("caseIdPerson")+"");
            PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
            FullNamePerson.setText(datain.get("FullNamePerson")+"");
            Age.setText(datain.get("Age")+"");
            Amphur.setText(datain.get("Amphur")+"");
            BirthDay.setText(datain.get("BirthDay")+"");
            BloodGroup.setText(datain.get("BloodGroup")+"");
            ExpiredDate.setText(datain.get("ExpiredDate")+"");
            FatherFullName.setText(datain.get("FatherFullName")+"");
            FullNamePersonEn.setText(datain.get("FullNamePersonEn")+"");
            Height.setText(datain.get("Height")+"");
            Weight.setText(datain.get("Weight")+"");
            HouseNumber.setText(datain.get("HouseNumber")+"");
            IssueDate.setText(datain.get("IssueDate")+"");
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
            ArrestDateTime.setText(datain.get("ArrestDateTime")+"");
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
        IssueDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ExpiredDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        OtherName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FullNamePersonEn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PassportNumber = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BirthDay = new javax.swing.JTextField();
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
        jLabel19 = new javax.swing.JLabel();
        NoPerson = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        ZipCode1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Gender1 = new javax.swing.JComboBox<>();
        ZipCode2 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
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
        ArrestDateTime = new javax.swing.JTextField();
        jLabelArrestPlace = new javax.swing.JLabel();
        PlaceArrest = new javax.swing.JTextField();
        jLabelArrestDate = new javax.swing.JLabel();
        jLabelRestoreDate = new javax.swing.JLabel();
        RestoreDate = new javax.swing.JTextField();
        jButtonSue = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonInsu = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jButtonSue2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jButtonInsu2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BtSaveAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        BtSaveAccused.setText("บันทึก");
        BtSaveAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveAccusedActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(77, 0, 0));
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

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jLabel31.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");

        IssueDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");

        ExpiredDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("ชื่อภาษาอังกฤษ");

        FullNamePersonEn.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel9.setText("เลขหนังสือเดินทาง");

        PassportNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel10.setText("วันเกิด");

        BirthDay.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel8.setText("อายุ");

        Age.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        Age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AgeKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel12.setText("สัญชาติ");

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("เชื้อชาติ");

        Race.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("ศาสนา");

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("สูง");

        Height.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("น้ำหนัก");

        Weight.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel20.setText("หมู่โลหิต");

        BloodGroup.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel15.setText("เพศ");

        Gender.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "หญิง", "ชาย", "ไม่ระบุ" }));

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("อาชีพ");

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel26.setText("ชื่อบิดา");

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel29.setText("ชื่อมารดา");

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel25.setText("หมายเลขโทรศัพท์");

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("บ้านเลขที่");

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel30.setText("หมู่ที่");

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel23.setText("เขต/อำเภอ");

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel27.setText("จังหวัด");

        Province.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");

        ZipCode.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZipCodeKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("ลำดับ");

        NoPerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel32.setText("เคยต้องโทษ");

        ZipCode1.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel33.setText("ผู้ต้องหาให้การ");

        Gender1.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        Gender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "รับสารภาพ", "ปฏิเสธ", "ภาคเสธ" }));

        ZipCode2.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel34.setText("ตำหนิรูปพรรณ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                            .addComponent(Occupation, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(Religion)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NoPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ExpiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel30))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel27)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel24)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel34))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(ZipCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Gender1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(ZipCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(NoPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ExpiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel24)
                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(ZipCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(Gender1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ZipCode2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PhonePerson.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel28.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("การจัดการผู้ต้องหา");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(174, 174, 174))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jRadioRestore.setBackground(new java.awt.Color(255, 255, 255));
        jRadioRestore.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioRestore.setText("ส่งฟื้นฟู");

        jRadioVerbal.setBackground(new java.awt.Color(255, 255, 255));
        jRadioVerbal.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioVerbal.setText("ฟ้องวาจา");

        jRadioCatch.setBackground(new java.awt.Color(255, 255, 255));
        jRadioCatch.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioCatch.setText("อายัดตัว");

        jRadioOther.setBackground(new java.awt.Color(255, 255, 255));
        jRadioOther.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioOther.setText("อื่นๆ");

        jRadioSue.setBackground(new java.awt.Color(255, 255, 255));
        jRadioSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioSue.setText("ผัดฟ้องฝากขัง");

        jRadioBail.setBackground(new java.awt.Color(255, 255, 255));
        jRadioBail.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioBail.setText("ประกัน");

        jRadioResultImprison.setBackground(new java.awt.Color(255, 255, 255));
        jRadioResultImprison.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioResultImprison.setText("แจ้งข้อหาฝากขัง");

        jRadioResultRelease.setBackground(new java.awt.Color(255, 255, 255));
        jRadioResultRelease.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioResultRelease.setText("แจ้งข้อหาปล่อยตัว");

        jRadioCantCatch.setBackground(new java.awt.Color(255, 255, 255));
        jRadioCantCatch.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jRadioCantCatch.setText("ไม่ได้ตัว");

        jLabelArrestPlace.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabelArrestPlace.setText("สถานที่จับกุม");

        jLabelArrestDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabelArrestDate.setText("วันที่จับกุม");

        jLabelRestoreDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabelRestoreDate.setText("วันที่ส่งฟื้นฟู");

        RestoreDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonSue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSueMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel3.setText("ผัดฟ้องฝากขัง");

        javax.swing.GroupLayout jButtonSueLayout = new javax.swing.GroupLayout(jButtonSue);
        jButtonSue.setLayout(jButtonSueLayout);
        jButtonSueLayout.setHorizontalGroup(
            jButtonSueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonSueLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jButtonSueLayout.setVerticalGroup(
            jButtonSueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jButtonInsu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonInsu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonInsuMouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel35.setText("ประกัน");

        javax.swing.GroupLayout jButtonInsuLayout = new javax.swing.GroupLayout(jButtonInsu);
        jButtonInsu.setLayout(jButtonInsuLayout);
        jButtonInsuLayout.setHorizontalGroup(
            jButtonInsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonInsuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel35)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jButtonInsuLayout.setVerticalGroup(
            jButtonInsuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioCantCatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioSue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioCatch, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jRadioBail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioOther, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioResultImprison)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioResultRelease))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jRadioVerbal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(RestoreDate))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabelArrestDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(7, 7, 7))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabelArrestPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(PlaceArrest, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                                            .addComponent(ArrestDateTime))))
                                .addGap(14, 14, 14))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButtonSue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jButtonInsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonInsu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioSue)
                    .addComponent(jRadioBail)
                    .addComponent(jRadioResultImprison)
                    .addComponent(jRadioResultRelease))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioCantCatch)
                    .addComponent(jRadioVerbal)
                    .addComponent(jRadioRestore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioCatch)
                    .addComponent(jRadioOther))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSue2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArrestPlace)
                    .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrestDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArrestDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtSaveAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(BtSaveAccused)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
        
        if(isInsert){
            String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
            "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
            "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,StatusSuspect,caseIdPerson,BailDate,ArrestDateTime,PlaceArrest)\n"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//           String sqlSueFirst="insert into sue (SueTimes,SueDate,)";
            System.out.println("SQL : "+sql);
            try {
                pst=con.prepareStatement(sql);
                pst.setString(1,Age.getText());
                pst.setString(2,Amphur.getText());
                pst.setString(3,BirthDay.getText());
                pst.setString(4,BloodGroup.getText());
                pst.setString(5,ExpiredDate.getText());
                pst.setString(6,FatherFullName.getText());
                pst.setString(7,FullNamePerson.getText());
                pst.setString(8,FullNamePersonEn.getText());
                pst.setString(9,Gender.getSelectedItem().toString());
                pst.setString(10,Height.getText());
                pst.setString(11,HouseNumber.getText());
                pst.setString(12,IssueDate.getText());
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
                pst.setString(31,ArrestDateTime.getText());
                pst.setString(32,PlaceArrest.getText());
               
                pst.executeUpdate();
                JOptionPane.showMessageDialog(jPanel1, "บันทึกข้อมูลแล้ว" ,null, JOptionPane.INFORMATION_MESSAGE);

                pst.close();
                
                System.out.println("SQL : "+sql);
            } catch (Exception e) {
              JOptionPane.showMessageDialog(jPanel1, "Cannaot Save" ,null, JOptionPane.INFORMATION_MESSAGE);

                System.out.println("SQL : "+pst);
            }
        }
        else{
            String sqlUpdate="Update Person set Age=?,Amphur=?,BirthDay=?,\n" +
            "BloodGroup=?,ExpiredDate=?,FatherFullName=?,FullNamePerson=?,FullNamePersonEn=?,\n" +
            "Gender=?,Height=?,HouseNumber=?,IssueDate=?,Moo=?,MotherFullName=?,Nationality=?,Occupation=?,\n" +
            "OtherName=?,PassportNumber=?,PeopleRegistrationID=?,PhonePerson=?,Province=?,Race=?,Religion=?,\n" +
            "Tambon=?,TypePerson=?,Weight=?,ZipCode=? ,caseIdPerson=?,StatusSuspect=? where NoPerson=? and TypePerson=?   ";

            try {
                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,Age.getText());
                pst.setString(2,Amphur.getText());
                pst.setString(3,BirthDay.getText());
                pst.setString(4,BloodGroup.getText());
                pst.setString(5,ExpiredDate.getText());
                pst.setString(6,FatherFullName.getText());
                pst.setString(7,FullNamePerson.getText());
                pst.setString(8,FullNamePersonEn.getText());
                pst.setString(9,Gender.getSelectedItem().toString());
                pst.setString(10,Height.getText());
                pst.setString(11,HouseNumber.getText());
                pst.setString(12,IssueDate.getText());
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
                  if(jRadioSue.isSelected()){ 
                    pst.setString(29,"ผัดฟ้องฝากขัง");       
                    
                }
                else if(jRadioBail.isSelected()){
                        pst.setString(29,"ประกัน");   
                }
                else if(jRadioResultImprison.isSelected()){
                        pst.setString(29,"แจ้งข้อหาฝากขัง");   
                }
                else if(jRadioResultRelease.isSelected()){
                        pst.setString(29,"แจ้งข้อหาปล่อยตัว");   
                }
                else if(jRadioCantCatch.isSelected()){
                        pst.setString(29,"ไม่ได้ตัว");   
                }

                else if(jRadioVerbal.isSelected()){
                        pst.setString(29,"ฟ้องวาจา");   
                }
                else if(jRadioRestore.isSelected()){
                        pst.setString(29,"ส่งฟื้นฟู");   
                }
                else if(jRadioCatch.isSelected()){
                        pst.setString(29,"อายัดตัว");   
                }
                 else if(jRadioOther.isSelected()){
                         pst.setString(29,"อื่นๆ");   
                }   
                pst.setString(30,noPerson);
              
                pst.setString(31,"ผู้ต้องหา");
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data Saved successfully");
                pst.close();
                System.out.println("SQL : "+sqlUpdate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }

        }

        setVisible(false);
    }//GEN-LAST:event_BtSaveAccusedActionPerformed

    private void jButtonSueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSueMouseClicked
        // TODO add your handling code here:
        
         String idCase=IdCase();
         String idPerson=IdPerson();
        
       

        JSONObject s = new JSONObject();
        s.put("SueCaseId",idCase );
        s.put("SuePersonId",idPerson );        

        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        SueCrimesFrom1 sa=new SueCrimesFrom1(fwit,s);
        sa.pack();
        sa.setLocationRelativeTo(null);
        sa.setVisible(true);
        
    }//GEN-LAST:event_jButtonSueMouseClicked

    private void jButtonInsuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInsuMouseClicked
        // TODO add your handling code here:
        String idCase=crimecaseno.getText();
        String personid=IdPerson();

        JSONObject s = new JSONObject();
        s.put("InsuCaseId",idCase );
        s.put("InsuPersonId",personid );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        BailCrimesAdd1 sa=new BailCrimesAdd1(fwit, s);
        sa.setVisible(true);
        
    }//GEN-LAST:event_jButtonInsuMouseClicked

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
  public void eventJButtonManage(){
      
     jRadioSue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioSue.isSelected()){
            jButtonSue2.setVisible(true);
            
            }
            else
              jButtonSue2.setVisible(false);  
            }
        }
        );
      jRadioBail.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioBail.isSelected()){ 
            jButtonInsu2.setVisible(true);         
            }
            else{               
             jButtonInsu2.setVisible(false);       
            }
            }
        }
        );
          jRadioRestore.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioRestore.isSelected()){ 
            jLabelRestoreDate.setVisible(true);
            RestoreDate.setVisible(true);
           
            
            }
            else{
              RestoreDate.setVisible(false);  
              jLabelRestoreDate.setVisible(false);  
              }
            }
        }
        );
   jRadioResultImprison.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioResultImprison.isSelected()){ 
            PlaceArrest.setVisible(true);
            ArrestDateTime.setVisible(true);
            jLabelArrestPlace.setVisible(true);
            jLabelArrestDate.setVisible(true);            
           
            
            }
            else{
              PlaceArrest.setVisible(false);  
              ArrestDateTime.setVisible(false);  
              jLabelArrestPlace.setVisible(false);
            jLabelArrestDate.setVisible(false);
              }
            }
        }
        );

  
  }   
    
    public void eventJRadioManage(){
    
       jRadioSue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioSue.isSelected()){
            jButtonSue.setVisible(true);
            
            }
            else
              jButtonSue.setVisible(false);  
            }
        }
        );
       jRadioRestore.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioRestore.isSelected()){ 
            jLabelRestoreDate.setVisible(true);
            RestoreDate.setVisible(true);
           
            
            }
            else{
              RestoreDate.setVisible(false);  
              jLabelRestoreDate.setVisible(false);  
              }
            }
        }
        );
   jRadioResultImprison.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioResultImprison.isSelected()){ 
            PlaceArrest.setVisible(true);
            ArrestDateTime.setVisible(true);
            jLabelArrestPlace.setVisible(true);
            jLabelArrestDate.setVisible(true);
           
            
            }
            else{
              PlaceArrest.setVisible(false);  
              ArrestDateTime.setVisible(false); 
            jLabelArrestPlace.setVisible(false);
            jLabelArrestDate.setVisible(false);              
              }
            }
        }
        );

      jRadioBail.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            if(jRadioBail.isSelected()){ 
            jButtonInsu.setVisible(true);         
            }
            else{               
             jButtonInsu.setVisible(false);       
            }
            }
        }
        );
               }
    public void colseTextBox(){
    RestoreDate.setVisible(false);  
    jLabelRestoreDate.setVisible(false); 
    jButtonSue.setVisible(false); 
    jButtonSue2.setVisible(false); 

//        jPanel8.setVisible(false); 
     jButtonInsu.setVisible(false);
    jButtonInsu2.setVisible(false);  

    jLabelArrestDate.setVisible(false);
     jLabelArrestPlace.setVisible(false);
    ArrestDateTime.setVisible(false);          
    PlaceArrest.setVisible(false); 
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    private javax.swing.JTextField ArrestDateTime;
    private javax.swing.JTextField BirthDay;
    private javax.swing.JTextField BloodGroup;
    private javax.swing.JButton BtSaveAccused;
    private javax.swing.JTextField ExpiredDate;
    private javax.swing.JTextField FatherFullName;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField FullNamePersonEn;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JComboBox<String> Gender1;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField HouseNumber;
    private javax.swing.JTextField IssueDate;
    private javax.swing.JTextField Moo;
    private javax.swing.JTextField MotherFullName;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField NoPerson;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField OtherName;
    private javax.swing.JTextField PassportNumber;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PhonePerson;
    private javax.swing.JTextField PlaceArrest;
    private javax.swing.JTextField Province;
    private javax.swing.JTextField Race;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField RestoreDate;
    private javax.swing.JTextField Tambon;
    private javax.swing.JTextField Weight;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JTextField ZipCode1;
    private javax.swing.JTextField ZipCode2;
    private javax.swing.JPanel jButtonInsu;
    private javax.swing.JPanel jButtonInsu2;
    private javax.swing.JPanel jButtonSue;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelArrestDate;
    private javax.swing.JLabel jLabelArrestPlace;
    private javax.swing.JLabel jLabelRestoreDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioBail;
    private javax.swing.JRadioButton jRadioCantCatch;
    private javax.swing.JRadioButton jRadioCatch;
    private javax.swing.JRadioButton jRadioOther;
    private javax.swing.JRadioButton jRadioRestore;
    private javax.swing.JRadioButton jRadioResultImprison;
    private javax.swing.JRadioButton jRadioResultRelease;
    private javax.swing.JRadioButton jRadioSue;
    private javax.swing.JRadioButton jRadioVerbal;
    // End of variables declaration//GEN-END:variables
}
