/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;



import static com.songkhla.wordgen.CrimesCaseEdit.ActionCrimes;
import static com.songkhla.wordgen.CrimesCaseEdit.ChargeNameCase;
import static com.songkhla.wordgen.CrimesCaseEdit.IdCase;
import static com.songkhla.wordgen.CrimesCaseEdit.ListAsset;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelActionCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextAccused;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextSuspect;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextWitness;
import static com.songkhla.wordgen.TrafficEdit.crimecaseid;
import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Petpilin
 */
public class IdentityFrom extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;;
    boolean isInsert;
    String caseid;
    JDatePickerImpl CaseRequestDateTime,CaseAcceptDate,OccuredDate,Invest_SendCaseDate;
    
    /**
     * Creates new form IdentifyFrom
     */
    public IdentityFrom(JFrame parrent,JSONObject datain) {
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
        jPanel10.setLayout(new FlowLayout());
        jPanel10.add(OccuredDate);  
        
                UtilDateModel model4 = new UtilDateModel();
            model4.setValue(Calendar.getInstance().getTime());
         JDatePanelImpl datePanel4 = new JDatePanelImpl(model4, p);
        Invest_SendCaseDate = new JDatePickerImpl(datePanel4,new DateLabelFormatter());
        Invest_SendCaseDate.setTextEditable(true);
        Invest_SendCaseDate.setBackground(Color.WHITE);
      //  jPanelInvestSend.setLayout(new FlowLayout());
       // jPanelInvestSend.add(Invest_SendCaseDate);   
//--------------------------------------Date Filed----------------------------------------------
    jCheckDuringInvest.setSelected(true);
           if(datain!=null){
            try {
                String rt=datain.get("CaseRequestTime")+"";
                String at=datain.get("CaseAcceptTime")+"";
                String ot=datain.get("CaseAcceptTime")+"";
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
                Date timeReq = dateFormat.parse(rt);
                Date timeAcc = dateFormat.parse(at);
                Date timeOccu = dateFormat.parse(ot);
                isInsert=false;
                caseid= "" + datain.get("CaseId");
                crimecaseid.setText(datain.get("CaseId")+"");
//          ID.setText(datain.get("CaseId")+"");
            crimecaseno.setText(datain.get("crimecaseno")+"");
            crimecaseyear.setText(datain.get("crimecaseyears")+"");
            jLabelChargeCode.setText(datain.get("ChargeCode")+"");
            ChargeNameCase.setText(datain.get("ChargeName")+"");
            CaseRequestDateTime.getJFormattedTextField().setText(datain.get("CaseRequestDate")+"");
            jTextAccused.setText(datain.get("AccureandOther")+"");
            CourtType.setSelectedItem(datain.get("TypeCourt"));
            CrimeLocation.setText(datain.get("CrimeLocation")+"");
            CrimeLocationDistrict.setText(datain.get("CrimeLocationDistrict")+"");
            CrimeLocationAmphur.setText(datain.get("CrimeLocationAmphur")+"");
            CrimeLocationProvince.setText(datain.get("CrimeLocationProvince")+"");
            jTextPoliceName.setText(datain.get("PoliceNameCase")+"");
            jTextSuspect.setText(datain.get("SuspectandOther")+"");
            jTextWitness.setText(datain.get("WitnessandOther")+"");
            CaseRequestTimee.setValue(timeReq);
            CaseAcceptDate.getJFormattedTextField().setText(datain.get("CaseAcceptDate")+"");
            CaseAcceptTimee.setValue(timeAcc);
            DailyNumber.setText(datain.get("DailyNumber")+"");
            String investSta=datain.get("Investigator_Result")+"";
            OccuredDate.getJFormattedTextField().setText(datain.get("OccuredDate")+"");
            OccuredDateTime.setValue(timeOccu);
            if(investSta.equals("อยู่ระหว่างสอบสวน")){
                jCheckDuringInvest.setSelected(true);
            }
            if(investSta.equals("สั่งฟ้อง")){
                jCheckSue.setSelected(true);
            }
            if(investSta.equals("สั่งไม่ฟ้อง")){
                jCheckNotSue.setSelected(true);
            }
            if(investSta.equals("งดการสอบสวน")){
                jCheckNoInvest.setSelected(true);
            }
            if(investSta.equals("อื่นๆ")){
                jCheckOtherInvest.setSelected(true);
            }
            ListAsset.setText(datain.get("AssetList")+"");
            ActionCrimes.setText(datain.get("ActionCrimes")+"");
            jLabelActionCode.setText(datain.get("ActionCode")+"");
            } catch (ParseException ex) {
                Logger.getLogger(CrimesCaseEdit.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        else{
           crimecaseid.setText(IdCase());
            isInsert=true;
          
        }
    }

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
        jLabelActionCode = new javax.swing.JLabel();
        jLabelChargeCode = new javax.swing.JLabel();
        crimecaseid = new javax.swing.JLabel();
        jButtonSaveCase = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        crimecaseyear = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CourtType = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        ChargeName = new javax.swing.JTextField();
        jButtonCharge = new javax.swing.JButton();
        jButtonAction = new javax.swing.JButton();
        ActionCrimes = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCheckSuicide = new javax.swing.JRadioButton();
        jCheckAnimal = new javax.swing.JRadioButton();
        jCheckKill = new javax.swing.JRadioButton();
        jCheckAccident = new javax.swing.JRadioButton();
        jCheckUnknow = new javax.swing.JRadioButton();
        jCheckExtraordinary = new javax.swing.JRadioButton();
        jCheckControl = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        DailyNumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CircumstancesOfDeath = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jCheckDuringInvest = new javax.swing.JCheckBox();
        jCheckSue = new javax.swing.JCheckBox();
        jCheckNotSue = new javax.swing.JCheckBox();
        jCheckNoInvest = new javax.swing.JCheckBox();
        jCheckOtherInvest = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        jTextInvestSendtoDepartment = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextInvestigatorResult = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextCourtResult = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextPoliceName = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButtonAddInvest = new javax.swing.JButton();
        Date date=new Date();

        SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        CaseRequestTimee = new javax.swing.JSpinner(sm);
        Date date2=new Date();

        SpinnerDateModel sm2=new SpinnerDateModel(date2,null,null,Calendar.HOUR_OF_DAY);
        CaseAcceptTimee = new javax.swing.JSpinner(sm2);
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        OccuredDateTime = new javax.swing.JSpinner(sm3);
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextAccused = new javax.swing.JTextField();
        jButtonAccured = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextSuspect = new javax.swing.JTextField();
        jButtonSuspect = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextWitness = new javax.swing.JTextField();
        jButtonWitness = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        EvidenceRecordNumber = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        ListAsset = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        CrimeLocationProvince = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        CrimeLocation = new javax.swing.JTextField();
        CrimeLocationDistrict = new javax.swing.JTextField();
        CrimeLocationAmphur = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1270, 720));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("คดีชันสูตร");

        jLabelActionCode.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelActionCode.setText("jLabel22");

        jLabelChargeCode.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelChargeCode.setText("jLabel2");

        crimecaseid.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        crimecaseid.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crimecaseid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelChargeCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActionCode)
                .addContainerGap(1135, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(crimecaseid)
                        .addComponent(jLabelChargeCode)
                        .addComponent(jLabelActionCode))
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        jButtonSaveCase.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonSaveCase.setIcon(new javax.swing.ImageIcon("D:\\Master\\user.png")); // NOI18N
        jButtonSaveCase.setText("บันทึก");
        jButtonSaveCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCaseActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(170, 665));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("เลขคดี");

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setText("/");

        crimecaseyear.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("อำนาจศาล");

        CourtType.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลอาญา", "ศาลแขวง", "ศาลเยาวชน", "ศาลทหาร" }));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("ข้อหา");

        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jButtonCharge.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonCharge.setText("เพิ่ม");
        jButtonCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargeActionPerformed(evt);
            }
        });

        jButtonAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAction.setText("เพิ่ม");
        jButtonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionActionPerformed(evt);
            }
        });

        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("พฤติการณ์คดี");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("เหตุที่ตาย");

        jCheckSuicide.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckSuicide.setText("ฆ่าตัวตาย");

        jCheckAnimal.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckAnimal.setText("สัตว์ทำร้ายตาย");

        jCheckKill.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckKill.setText("ผู้อื่นทำให้ตาย");

        jCheckAccident.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckAccident.setText("อุบัติเหตุ");

        jCheckUnknow.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckUnknow.setText("มิปรากฎเหตุ");
        jCheckUnknow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckUnknowActionPerformed(evt);
            }
        });

        jCheckExtraordinary.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckExtraordinary.setText("ถูกเจ้าพนักงานทำให้ตาย(วิสามัญ)");

        jCheckControl.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckControl.setText("ระหว่างควบคุม");

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("วันที่รับแจ้ง");

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("เวลารับแจ้ง");

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("วันที่รับคำร้องทุกข์");

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("เวลารับคำร้องทุกข์");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("ปจว.ข้อ");

        DailyNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("ตายโดย");

        CircumstancesOfDeath.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("วันที่เกิดเหตุ");

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("เวลาที่เกิดเหตุ");

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel34.setText("ผลคดีชั้นพนักงานสอบสวน");

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

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel32.setText("ส่งสำนวนไปยัง");

        jTextInvestSendtoDepartment.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel33.setText("เลขที่ส่ง");

        jTextField25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel35.setText("วันเดือนปีที่ส่ง");

        jTextField26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel36.setText("ผลคดีชั้นอัยการ");

        jTextInvestigatorResult.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jTextCourtResult.setColumns(20);
        jTextCourtResult.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jTextCourtResult.setRows(5);
        jScrollPane1.setViewportView(jTextCourtResult);

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel37.setText("ผลคดีชั้นศาล");

        jTextField28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel38.setText("หมายเหตุ");

        jTextPoliceName.setEditable(false);
        jTextPoliceName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel40.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel40.setText("ชื่อพนักงานสอบสวน");

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel41.setText("บันทึกพนักงานสอบสวน");

        jTextField1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jButtonAddInvest.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAddInvest.setText("เพิ่ม");
        jButtonAddInvest.setActionCommand("พยาน");
        jButtonAddInvest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddInvestActionPerformed(evt);
            }
        });

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(CaseRequestTimee, "HH:mm");
        CaseRequestTimee.setEditor(timeEditor);
        //jSpinner1.setValue(new Date());
        CaseRequestTimee.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        JSpinner.DateEditor te = new JSpinner.DateEditor(CaseAcceptTimee, "HH:mm");
        CaseAcceptTimee.setEditor(te);
        //jSpinner1.setValue(new Date());
        CaseAcceptTimee.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CaseAcceptTimee.setPreferredSize(new java.awt.Dimension(29, 25));

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(OccuredDateTime, "HH:mm");
        OccuredDateTime.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        OccuredDateTime.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crimecaseyear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckAccident)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckUnknow)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckControl)
                                            .addComponent(jCheckKill)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckSuicide)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckAnimal))
                                    .addComponent(jCheckExtraordinary)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonCharge)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(CaseAcceptTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(OccuredDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CaseRequestTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jButtonAction)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(17, 17, 17)
                                            .addComponent(CourtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(CircumstancesOfDeath)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(DailyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextInvestigatorResult))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel40))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel34)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCheckDuringInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jCheckNoInvest))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCheckOtherInvest)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jCheckSue, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jCheckNotSue, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(143, 143, 143)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAddInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(crimecaseyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CourtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonAction, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCharge))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckSuicide, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckAccident, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckUnknow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckExtraordinary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CircumstancesOfDeath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckControl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCheckKill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(OccuredDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(7, 7, 7)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(CaseRequestTimee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CaseAcceptTimee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DailyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckDuringInvest)
                            .addComponent(jCheckSue)
                            .addComponent(jCheckNotSue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckOtherInvest)
                            .addComponent(jCheckNoInvest))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextInvestSendtoDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextInvestigatorResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPoliceName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddInvest, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ข้อมูลคดี", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1270, 626));

        jTextAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jTextAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAccusedActionPerformed(evt);
            }
        });

        jButtonAccured.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAccured.setText("เพิ่ม");
        jButtonAccured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccuredActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("ผู้กล่าวหา");

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("ผู้ต้องหา");

        jTextSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jButtonSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonSuspect.setText("เพิ่ม");
        jButtonSuspect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuspectActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("พยานและบุคคลอื่น");

        jTextWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jButtonWitness.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonWitness.setText("เพิ่ม");
        jButtonWitness.setActionCommand("พยาน");
        jButtonWitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWitnessActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("เลขบัญชีของกลาง");

        EvidenceRecordNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        EvidenceRecordNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvidenceRecordNumberActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("รายการทรัพย์");

        ListAsset.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jButton8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton8.setText("เพิ่ม");
        jButton8.setActionCommand("พยาน");

        CrimeLocationProvince.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("จังหวัด");

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("ตำบล");

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("สถานที่เกิดเหตุ");

        CrimeLocation.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        CrimeLocationDistrict.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        CrimeLocationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel19.setText("อำเภอ");

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("ต/อ/จ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(EvidenceRecordNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextWitness)
                            .addComponent(ListAsset)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextAccused))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CrimeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonSuspect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAccured, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonWitness, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(CrimeLocationDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(155, 155, 155))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSuspect))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextWitness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonWitness)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrimeLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CrimeLocationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrimeLocationDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrimeLocationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAccured)
                        .addComponent(jTextAccused, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EvidenceRecordNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addContainerGap(314, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ข้อมูลประกอบข้อมูลคดี", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSaveCase)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSaveCase)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCaseActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonSaveCaseActionPerformed

    private void jButtonAddInvestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddInvestActionPerformed
        //
        //         RecordInvestigatorForm ri =new RecordInvestigatorForm();
        //        ri.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddInvestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckUnknowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckUnknowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckUnknowActionPerformed

    private void jButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fa = (JFrame)(dialog.getParent());
        fa.removeAll();
        ActionPage ap =new ActionPage(fa,null,null);
        ap.pack();
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);
        
    }//GEN-LAST:event_jButtonActionActionPerformed

    private void jButtonChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargeActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        ChargePage cp=new ChargePage(fr,null,null);
         cp.pack();
        cp.setLocationRelativeTo(null);
        cp.setVisible(true);
    }//GEN-LAST:event_jButtonChargeActionPerformed

    private void jButtonWitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWitnessActionPerformed
        // TODO add your handling code here:
        String idWit=crimecaseid.getText();
        String typeW="ชันสูตร";
        JSONObject s = new JSONObject();
        s.put("CaseIdWit",idWit );
        s.put("TypeCaseW",typeW );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        ListWitness lw=new ListWitness(fwit,s);
         lw.pack();
        lw.setLocationRelativeTo(null);
        lw.setModal(true);
        lw.setVisible(true);
    }//GEN-LAST:event_jButtonWitnessActionPerformed

    private void jButtonSuspectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuspectActionPerformed
        // TODO add your handling code here:
        String idSus=crimecaseid.getText();
        String typeS="ชันสูตร";
        JSONObject s = new JSONObject();
        s.put("CaseIdSus",idSus );
        s.put("TypeCaseS",typeS );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
        facc.removeAll();
        ListSuspect ls=new ListSuspect(facc,s);
        ls.pack();
        ls.setLocationRelativeTo(null);
        ls.setModal(true);
        ls.setVisible(true);
    }//GEN-LAST:event_jButtonSuspectActionPerformed

    private void jButtonAccuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccuredActionPerformed
        // TODO add your handling code here:
        String aa=crimecaseid.getText();
        String type="ชันสูตร";
        JSONObject data = new JSONObject();
        data.put("CaseIdAcc",aa );
        data.put("TypeCase",type );

        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
        facc.removeAll();
        ListAccused la =new ListAccused(facc,data);
         la.pack();
        la.setLocationRelativeTo(null);
        la.setModal(true);
        la.setVisible(true);
    }//GEN-LAST:event_jButtonAccuredActionPerformed

    private void EvidenceRecordNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvidenceRecordNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EvidenceRecordNumberActionPerformed

    private void jTextAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAccusedActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jTextAccusedActionPerformed
    
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
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentityFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new IdentityFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActionCrimes;
    private javax.swing.JSpinner CaseAcceptTimee;
    private javax.swing.JSpinner CaseRequestTimee;
    private javax.swing.JTextField ChargeName;
    private javax.swing.JTextField CircumstancesOfDeath;
    private javax.swing.JComboBox<String> CourtType;
    private javax.swing.JTextField CrimeLocation;
    private javax.swing.JTextField CrimeLocationAmphur;
    private javax.swing.JTextField CrimeLocationDistrict;
    private javax.swing.JTextField CrimeLocationProvince;
    private javax.swing.JTextField DailyNumber;
    private javax.swing.JTextField EvidenceRecordNumber;
    private javax.swing.JTextField ListAsset;
    private javax.swing.JSpinner OccuredDateTime;
    private javax.swing.JLabel crimecaseid;
    private javax.swing.JTextField crimecaseno;
    private javax.swing.JTextField crimecaseyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    public static javax.swing.JButton jButtonAccured;
    private javax.swing.JButton jButtonAction;
    private javax.swing.JButton jButtonAddInvest;
    private javax.swing.JButton jButtonCharge;
    private javax.swing.JButton jButtonSaveCase;
    public static javax.swing.JButton jButtonSuspect;
    public static javax.swing.JButton jButtonWitness;
    private javax.swing.JRadioButton jCheckAccident;
    private javax.swing.JRadioButton jCheckAnimal;
    private javax.swing.JRadioButton jCheckControl;
    private javax.swing.JCheckBox jCheckDuringInvest;
    private javax.swing.JRadioButton jCheckExtraordinary;
    private javax.swing.JRadioButton jCheckKill;
    private javax.swing.JCheckBox jCheckNoInvest;
    private javax.swing.JCheckBox jCheckNotSue;
    private javax.swing.JCheckBox jCheckOtherInvest;
    private javax.swing.JCheckBox jCheckSue;
    private javax.swing.JRadioButton jCheckSuicide;
    private javax.swing.JRadioButton jCheckUnknow;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelActionCode;
    private javax.swing.JLabel jLabelChargeCode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextField jTextAccused;
    private javax.swing.JTextArea jTextCourtResult;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextInvestSendtoDepartment;
    private javax.swing.JTextField jTextInvestigatorResult;
    private javax.swing.JTextField jTextPoliceName;
    public static javax.swing.JTextField jTextSuspect;
    public static javax.swing.JTextField jTextWitness;
    // End of variables declaration//GEN-END:variables
}
