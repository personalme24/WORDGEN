/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.text.DefaultEditorKit;
import org.json.simple.JSONObject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
/**
 *
 * @author Petpilin
 */
public class StationForm extends javax.swing.JDialog {
    
      Connection con=null;
    PreparedStatement pst=null;
    DataCase dc =new DataCase();
    boolean isInsert;

    /**
     * Creates new form StationForm
     */
    public StationForm(JFrame parrent,JSONObject datain) {
        super(parrent,true);
       initComponents();
        ImageIcon img = new ImageIcon("./Master/WD.png");
        setIconImage(img.getImage());
        setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES) BETA");
        PoliceStartionId.setVisible(false);
       if(datain != null)
       {
                    closeText();
                    PoliceStartionId.setText(Checknull(datain.get("PoliceStartionId"))+"");
                            PoliceStationCode.setText(Checknull(datain.get("PoliceStartionCode"))+"");
                            PoliceStationName.setText(Checknull(datain.get("PoliceStaionName"))+"");
                            PoliceStationShort.setText(Checknull(datain.get("PoliceStaionShort"))+"");
                            StationAddress.setText(Checknull(datain.get("StationAddress"))+"");
                            StationAmphur.setText(Checknull(datain.get("StationAmphur"))+"");
                            StationProvince.setText(Checknull(datain.get("StationProvince"))+"");
                            BK.setText(Checknull(datain.get("BK"))+"");
                            BH.setText(Checknull(datain.get("BH"))+"");
                            Fax.setText(Checknull(datain.get("Fax"))+"");
                            TelStation.setText(Checknull(datain.get("TelStation"))+"");
                            PhonePolice.setText(Checknull(datain.get("PhonePolice"))+"");
                            HeadName.setText(Checknull(datain.get("HeadName"))+"");
                            HeadPosition.setText(Checknull(datain.get("HeadPosition"))+"");
                            HeadWorkName.setText(Checknull(datain.get("HeadWorkName"))+"");
                            HeadWorkPosition.setText(Checknull(datain.get("HeadWorkPosition"))+"");
                            CriminalCourt.setText(Checknull(datain.get("CriminalCourt"))+"");
                            JuvenileCourt.setText(Checknull(datain.get("JuvenileCourt"))+"");
                            DistrictCourt.setText(Checknull(datain.get("DistrictCourt"))+"");
                            MilitaryCourt.setText(Checknull(datain.get("MilitaryCourt"))+"");
                            AssetCourt.setText(Checknull(datain.get("AssetCourt"))+"");
                            LocationOfD.setText(Checknull(datain.get("LocationOfDrug"))+"");
                            CheckGun.setText(Checknull(datain.get("CheckGun"))+"");
                            CheckDrug.setText(Checknull(datain.get("CheckDrug"))+"");
                            CheckOtherExhibit.setText(Checknull(datain.get("CheckOtherExhibit"))+"");
                            CauseSerious.setText(Checknull(datain.get("CauseSerious"))+"");
                            ProvincProsecutor.setText(Checknull(datain.get("ProvincProsecutor"))+"");
                            ProvincProsecutorCh.setText(Checknull(datain.get("ProvincProsecutorCh"))+"");
                            THNumBook.setText(Checknull(datain.get("THNumBook"))+"");
                            ProtectChild.setText(Checknull(datain.get("ProtectChild"))+"");
                            StationMoo.setText(Checknull(datain.get("StationMoo"))+"");
                            StationTambon.setText(Checknull(datain.get("StationTambon"))+"");
                            Postcode.setText(Checknull(datain.get("Postcode"))+"");
                            HeadRankFull.setText(Checknull(datain.get("HeadRankFull"))+"");
                            HeadRankShort.setText(Checknull(datain.get("HeadRankShort"))+"");
                            HeadWorkRankFull.setText(Checknull(datain.get("HeadWorkRankFull"))+"");
                            HeadWorkRankShort.setText(Checknull(datain.get("HeadWorkRankShort"))+"");
       }
       else{
       PoliceStartionId.setText(IdStation());
       jButtonEditStation.setEnabled(false);
       isInsert=true;
       }
       JTextPopupMenu.addTo(PoliceStationCode);
       JTextPopupMenu.addTo(PoliceStationName);
       JTextPopupMenu.addTo(PoliceStationShort);
       JTextPopupMenu.addTo(BK);
       JTextPopupMenu.addTo(BH);
       JTextPopupMenu.addTo(StationAddress);
       JTextPopupMenu.addTo(StationMoo);
       JTextPopupMenu.addTo(StationTambon);
       JTextPopupMenu.addTo(StationAmphur);
       JTextPopupMenu.addTo(StationProvince);
       JTextPopupMenu.addTo(Postcode);
       JTextPopupMenu.addTo(TelStation);
       JTextPopupMenu.addTo(PhonePolice);
       JTextPopupMenu.addTo(THNumBook);
       JTextPopupMenu.addTo(Fax);
       JTextPopupMenu.addTo(HeadName);
       JTextPopupMenu.addTo(HeadPosition);
       JTextPopupMenu.addTo(HeadWorkName);
       JTextPopupMenu.addTo(HeadWorkPosition);
       JTextPopupMenu.addTo(CriminalCourt);
       JTextPopupMenu.addTo(JuvenileCourt);
       JTextPopupMenu.addTo(DistrictCourt);
       JTextPopupMenu.addTo(MilitaryCourt);
       JTextPopupMenu.addTo(AssetCourt);
       JTextPopupMenu.addTo(CheckGun);
       JTextPopupMenu.addTo(LocationOfD);
       JTextPopupMenu.addTo(CheckOtherExhibit);
       JTextPopupMenu.addTo(CheckDrug);
       JTextPopupMenu.addTo(ProtectChild);
       JTextPopupMenu.addTo(ProvincProsecutor);
       JTextPopupMenu.addTo(ProvincProsecutorCh);
          JTextPopupMenu.addTo(HeadRankFull);
       JTextPopupMenu.addTo(HeadRankShort);
       JTextPopupMenu.addTo(HeadWorkRankFull);
       JTextPopupMenu.addTo(HeadWorkRankShort);
       JTextPopupMenu.addToTextArea(CauseSerious);
       




//          JPopupMenu menu = new JPopupMenu();
//        Action cut = new DefaultEditorKit.CutAction();
//        cut.putValue(Action.NAME, "Cut");
//        cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
//        menu.add( cut );

//        Action copy = new DefaultEditorKit.CopyAction();
//        copy.putValue(Action.NAME, "Copy");
//        copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
//        menu.add( copy );
//
//        Action paste = new DefaultEditorKit.PasteAction();
//        paste.putValue(Action.NAME, "Paste");
//        paste.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
//        menu.add( paste );
//        PoliceStationName.setComponentPopupMenu( menu );
//        PoliceStationShort.setComponentPopupMenu( menu );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PoliceStartionId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PoliceStationCode = new javax.swing.JTextField();
        PoliceStationName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PoliceStationShort = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        StationAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        StationMoo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BK = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        BH = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        StationTambon = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        StationAmphur = new javax.swing.JTextField();
        StationProvince = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Postcode = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TelStation = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        PhonePolice = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        HeadName = new javax.swing.JTextField();
        HeadPosition = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        HeadWorkName = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        HeadWorkPosition = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        CriminalCourt = new javax.swing.JTextField();
        JuvenileCourt = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        DistrictCourt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        MilitaryCourt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        AssetCourt = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        LocationOfD = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        CheckGun = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        CheckDrug = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        CheckOtherExhibit = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        ProtectChild = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        ProvincProsecutor = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        ProvincProsecutorCh = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        THNumBook = new javax.swing.JTextField();
        jButtonSaveStation = new javax.swing.JButton();
        Fax = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CauseSerious = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButtonEditStation = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        HeadRankShort = new javax.swing.JTextField();
        HeadWorkRankFull = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        HeadRankFull = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        HeadWorkRankShort = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ข้อมูลหน่วยงานและหน่วยงานที่เกี่ยวข้อง");
        setPreferredSize(new java.awt.Dimension(1264, 726));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ข้อมูลหน่วยงานและหน่วยงานที่เกี่ยวข้อง");

        PoliceStartionId.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(PoliceStartionId)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addComponent(PoliceStartionId))
        );

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel8.setText("รหัสสถานีตำรวจ");

        PoliceStationCode.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        PoliceStationCode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        PoliceStationCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoliceStationCodeActionPerformed(evt);
            }
        });
        PoliceStationCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PoliceStationCodeKeyTyped(evt);
            }
        });

        PoliceStationName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        PoliceStationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PoliceStationNameActionPerformed(evt);
            }
        });
        PoliceStationName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PoliceStationNameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PoliceStationNameKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel9.setText("ชื่อหน่วยงาน");

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel10.setText("ชื่อหน่วยงาน(ย่อ)");

        PoliceStationShort.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("ที่อยู่");

        StationAddress.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel12.setText("หมู่");

        StationMoo.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("กองบังคับการ ตร.ภ.จว.");

        BK.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("กองบัญชาการ ภาค");

        BH.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel15.setText("ตำบล/แขวง");

        StationTambon.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("อำเภอ/เขต");

        StationAmphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        StationProvince.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("จังหวัด");

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("รหัสไปรษณีย์");

        Postcode.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        Postcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PostcodeKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("เบอร์โทรศัพท์(สถานี)");

        TelStation.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        TelStation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TelStationKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel20.setText("เบอร์โทรศัพท์(มือถือ)");

        PhonePolice.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        PhonePolice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PhonePoliceKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("โทรสาร");

        HeadName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        HeadPosition.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel23.setText("ชื่อหัวหน้างาน");

        HeadWorkName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel24.setText("ตำแหน่งหัวหน้างาน");

        HeadWorkPosition.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel25.setText("ศาลจังหวัด/อาญา");

        CriminalCourt.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        JuvenileCourt.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel26.setText("ศาลเยาวชน");

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel27.setText("ศาลแขวง");

        DistrictCourt.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel28.setText("ศาลทหาร");

        MilitaryCourt.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        MilitaryCourt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MilitaryCourtActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel29.setText("ศาลทรัพย์สินทางปัญญาและการค้าระหว่างประเทศ");

        AssetCourt.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel30.setText("สถานที่ส่งยาเสพติดตรวจ ปืนกระสุน");

        LocationOfD.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        LocationOfD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationOfDActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel31.setText("สถานที่ี่ตรวจ ระเบิด");

        CheckGun.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel32.setText("สถานที่ตรวจสารคัดหลั่งในร่างกายตรวจหาสารเสพติด");

        CheckDrug.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel33.setText("สถานที่ส่่งตรวจของกลางอื่น");

        CheckOtherExhibit.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel34.setText("รายงานเหตุอุกฉกรรจ์หรือเหตุที่ต้องรายงาน ไปยัง");

        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel35.setText("สถานพินิจคุ้มครองเด็กและเยาวชน");

        ProtectChild.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel36.setText("อัยการจังหวัด");

        ProvincProsecutor.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel37.setText("อัยการจังหวัด(คดีเยาวชน)");

        ProvincProsecutorCh.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel38.setText("ตช เลขหนังสือ");

        THNumBook.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jButtonSaveStation.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSaveStation.setText("บันทึก");
        jButtonSaveStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveStationActionPerformed(evt);
            }
        });

        Fax.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        CauseSerious.setColumns(20);
        CauseSerious.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        CauseSerious.setLineWrap(true);
        CauseSerious.setRows(1);
        CauseSerious.setTabSize(1);
        jScrollPane1.setViewportView(CauseSerious);

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel3.setText("ข้อมูลหน่วยงานที่เกี่ยวข้อง");

        jButtonEditStation.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonEditStation.setText("แก้ไข");
        jButtonEditStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditStationActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel43.setText("ยศหัวหน้างานย่อ");

        jLabel44.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel44.setText("ยศหัวหน้างานเต็ม");

        HeadRankShort.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        HeadWorkRankFull.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel45.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel45.setText("ยศหัวหน้าหน่วยย่อ");

        HeadRankFull.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel39.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel39.setText("ชื่อหัวหน้าหน่วย");

        jLabel46.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel46.setText("ตำแหน่งหัวหน้าหน่วย");

        jLabel47.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel47.setText("ยศหัวหน้าหน่วยเต็ม");

        HeadWorkRankShort.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(HeadRankFull, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(HeadWorkRankFull))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(HeadRankShort, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel39))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(HeadWorkRankShort, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HeadWorkName, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(HeadName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HeadPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(HeadWorkPosition)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Fax, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(PoliceStationCode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PoliceStationShort, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(StationAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(StationMoo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(BK, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(20, 20, 20)
                                                        .addComponent(jLabel14)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(PoliceStationName)))
                                            .addComponent(jLabel15)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(352, 352, 352)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StationTambon, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TelStation, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(168, 168, 168)
                                        .addComponent(jLabel38))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(PhonePolice, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(StationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(StationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(THNumBook, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CheckDrug, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ProvincProsecutor, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ProvincProsecutorCh))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ProtectChild, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel34)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(LocationOfD))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AssetCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CheckGun, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addGap(18, 18, 18)
                                    .addComponent(CheckOtherExhibit, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSaveStation, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditStation, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(643, 643, 643)
                            .addComponent(JuvenileCourt))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(DistrictCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CriminalCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MilitaryCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(59, 59, 59))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PoliceStationCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PoliceStationName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PoliceStationShort, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StationAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StationMoo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StationAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StationProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(StationTambon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelStation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhonePolice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(THNumBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fax, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeadRankFull, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeadPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeadName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeadRankShort, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeadWorkName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeadWorkRankFull, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HeadWorkRankShort, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(HeadWorkPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CriminalCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JuvenileCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DistrictCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MilitaryCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AssetCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckGun, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LocationOfD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckOtherExhibit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckDrug, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProtectChild, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProvincProsecutorCh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProvincProsecutor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveStation)
                    .addComponent(jButtonEditStation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveStationActionPerformed
        con=ConnectDatabase.connect();
         try{
         Statement st = con.createStatement();
        String sqlCheck="Select PoliceStartionId from PoliceStation where PoliceStartionId='"+PoliceStartionId.getText()+"'";
        System.out.println("Check : "+sqlCheck);
         ResultSet rc = st.executeQuery(sqlCheck);
        if(rc.next()){
        
        isInsert=false;
        }
        else{
         isInsert=true;
        }
        }
        catch(Exception ex){
        ex.printStackTrace();
        }
           //Connection con = ConnectDatabase.connect();
      
              if(isInsert){
          try {  
              Statement stmt = con.createStatement();
     
        String sql="INSERT INTO PoliceStation (PoliceStartionCode,PoliceStaionName,PoliceStaionShort,StationAddress,StationAmphur,StationProvince,BK," +
        "BH,TelStation,PhonePolice,Fax,HeadName,HeadPosition,HeadWorkName,HeadWorkPosition,CriminalCourt,JuvenileCourt,DistrictCourt," +
        "MilitaryCourt,AssetCourt,LocationOfDrug,CheckGun,CheckDrug,CheckOtherExhibit,CauseSerious,ProvincProsecutor,ProvincProsecutorCh," +
        "THNumBook,ProtectChild,StationTambon,StationMoo,Postcode,HeadRankFull,HeadRankShort,HeadWorkRankFull,HeadWorkRankShort) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   pst=con.prepareStatement(sql);
            pst.setString(1,PoliceStationCode.getText());
            pst.setString(2,PoliceStationName.getText());
            pst.setString(3,PoliceStationShort.getText());
            pst.setString(4,StationAddress.getText());
            pst.setString(5,StationAmphur.getText());
            pst.setString(6,StationProvince.getText());
            pst.setString(7,BK.getText());
            pst.setString(8,BH.getText());
            pst.setString(9,TelStation.getText());
            pst.setString(10,PhonePolice.getText());
            pst.setString(11,Fax.getText());
            pst.setString(12,HeadName.getText());
            pst.setString(13,HeadPosition.getText());
            pst.setString(14,HeadWorkName.getText());
            pst.setString(15,HeadWorkPosition.getText());
            pst.setString(16,CriminalCourt.getText());
            pst.setString(17,JuvenileCourt.getText());
            pst.setString(18,DistrictCourt.getText());
            pst.setString(19,MilitaryCourt.getText());
            pst.setString(20,AssetCourt.getText());
            pst.setString(21,LocationOfD.getText());
            pst.setString(22,CheckGun.getText());
            pst.setString(23,CheckDrug.getText());
            pst.setString(24,CheckOtherExhibit.getText());
            pst.setString(25,CauseSerious.getText());
            pst.setString(26,ProvincProsecutor.getText());
            pst.setString(27,ProvincProsecutorCh.getText());
            pst.setString(28,THNumBook.getText());
            pst.setString(29,ProtectChild.getText());
            pst.setString(30,StationTambon.getText());
            pst.setString(31,StationMoo.getText());
            pst.setString(32,Postcode.getText());
              pst.setString(33,HeadRankFull.getText());
            pst.setString(34,HeadRankShort.getText());
            pst.setString(35,HeadWorkRankFull.getText());
            pst.setString(36,HeadWorkRankShort.getText());
            
             
              int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
               pst.executeUpdate(); 
               pst.close();
                closeText();
          jButtonEditStation.setEnabled(true);
           jButtonSaveStation.setEnabled(false);
//               System.out.println("SQLUP :"+sql);

          } 
              } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println("SQL : "+pst);
        }
              
              }
              else{
                     
         try{
         String sqlUpdate= "UPDATE PoliceStation Set\n "
        + "PoliceStartionCode=?,"
        + "PoliceStaionName=?,"
        + "PoliceStaionShort=?,"
        + "StationAddress=?,"
        + "StationAmphur=?,"
        + "StationProvince=?,"
        + "BK=?,"
        + "BH=?,"
        + "TelStation=?,"
        + "PhonePolice=?,"
        + "Fax=?,"
        + "HeadName=?,"
        + "HeadPosition=?,"
        + "HeadWorkName=?,"
        + "HeadWorkPosition=?,"
        + "CriminalCourt=?,"
        + "JuvenileCourt=?,"
        + "DistrictCourt=?,"
        + "MilitaryCourt=?,"
        + "AssetCourt=?,"
        + "LocationOfDrug=?,"
        + "CheckGun=?,"
        + "CheckDrug=?,"
        + "CheckOtherExhibit=?,"
        + "CauseSerious=?,"
        + "ProvincProsecutor=?,"
        + "ProvincProsecutorCh=?,"
        + "THNumBook=?,"
        + "ProtectChild=?,"
        + "StationTambon=?,"
        + "StationMoo=?,"
        + "HeadRankFull=?,"
        + "HeadRankShort=?,"
        + "HeadWorkRankFull=?,"
        + "HeadWorkRankShort=?,"            
        + "Postcode=? "
        + "Where PoliceStartionId=?";
      System.out.println("SQL : "+sqlUpdate);
            pst=con.prepareStatement(sqlUpdate);
            pst.setString(1,PoliceStationCode.getText());
            pst.setString(2,PoliceStationName.getText());
            pst.setString(3,PoliceStationShort.getText());
            pst.setString(4,StationAddress.getText());
            pst.setString(5,StationAmphur.getText());
            pst.setString(6,StationProvince.getText());
            pst.setString(7,BK.getText());
            pst.setString(8,BH.getText());
            pst.setString(9,TelStation.getText());
            pst.setString(10,PhonePolice.getText());
            pst.setString(11,Fax.getText());
            pst.setString(12,HeadName.getText());
            pst.setString(13,HeadPosition.getText());
            pst.setString(14,HeadWorkName.getText());
            pst.setString(15,HeadWorkPosition.getText());
            pst.setString(16,CriminalCourt.getText());
            pst.setString(17,JuvenileCourt.getText());
            pst.setString(18,DistrictCourt.getText());
            pst.setString(19,MilitaryCourt.getText());
            pst.setString(20,AssetCourt.getText());
            pst.setString(21,LocationOfD.getText());
            pst.setString(22,CheckGun.getText());
            pst.setString(23,CheckDrug.getText());
            pst.setString(24,CheckOtherExhibit.getText());
            pst.setString(25,CauseSerious.getText());
            pst.setString(26,ProvincProsecutor.getText());
            pst.setString(27,ProvincProsecutorCh.getText());
            pst.setString(28,THNumBook.getText());
            pst.setString(29,ProtectChild.getText());
            pst.setString(30,StationTambon.getText());
            pst.setString(31,StationMoo.getText());
            pst.setString(32,HeadRankFull.getText());
            pst.setString(33,HeadRankShort.getText());
            pst.setString(34,HeadWorkRankFull.getText());
            pst.setString(35,HeadWorkRankShort.getText());    
            pst.setString(36,Postcode.getText());
             pst.setString(37,PoliceStartionId.getText());
//             System.out.println("SQL : "+sqlUpdate);
              int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
               pst.executeUpdate(); 
               pst.close();
                    closeText();
          jButtonEditStation.setEnabled(true);
           jButtonSaveStation.setEnabled(false);
          } 
                    }
            
             catch (Exception e) {
           JOptionPane.showMessageDialog(null, "ไม่สามารถแก้ไขข้อมูลได้");
            System.out.println("SQL : "+pst);
            
        }
              
     
              }
    }//GEN-LAST:event_jButtonSaveStationActionPerformed

    private void LocationOfDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationOfDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocationOfDActionPerformed

    private void PoliceStationCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoliceStationCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PoliceStationCodeActionPerformed

    private void PoliceStationCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PoliceStationCodeKeyTyped
        char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
         if(PoliceStationCode.getText().length()>=5) {  
           evt.consume(); // TODO add your han
        }
  
    }//GEN-LAST:event_PoliceStationCodeKeyTyped

    private void PostcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PostcodeKeyTyped
         char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
        if(Postcode.getText().length()>=5) {  
            evt.consume();        
            }
    }//GEN-LAST:event_PostcodeKeyTyped

    private void PhonePoliceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhonePoliceKeyTyped

        if(PhonePolice.getText().length()>=10) {  
           evt.consume();  
         }// TODO add your handling code here:
    }//GEN-LAST:event_PhonePoliceKeyTyped

    private void TelStationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TelStationKeyTyped
       if(TelStation.getText().length()>=10) {  
           evt.consume();  
         } // TODO add your handling code here:
    }//GEN-LAST:event_TelStationKeyTyped

    private void jButtonEditStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditStationActionPerformed
        // TODO add your handling code here:
         openText();
        jButtonSaveStation.setEnabled(true);
    }//GEN-LAST:event_jButtonEditStationActionPerformed

    private void PoliceStationNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PoliceStationNameKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
    if((vChar == KeyEvent.VK_SPACE))
         {
                       evt.consume();  
         }
        
    }//GEN-LAST:event_PoliceStationNameKeyTyped

    private void PoliceStationNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PoliceStationNameKeyPressed
        // TODO add your handling code here:
//              evt.getKeyCode();
       
    }//GEN-LAST:event_PoliceStationNameKeyPressed

    private void MilitaryCourtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MilitaryCourtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MilitaryCourtActionPerformed

    private void PoliceStationNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PoliceStationNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PoliceStationNameActionPerformed
private void data() 
{
            String sql= "select * from PoliceStation";
            Connection con = ConnectDatabase.connect();
            try {  Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
              if(rs.next()){
                  
                            
                            PoliceStationCode.setText(rs.getString("PoliceStartionCode"));
                            PoliceStationName.setText(rs.getString("PoliceStaionName"));
                            PoliceStationShort.setText(rs.getString("PoliceStaionShort"));
                            StationAddress.setText(rs.getString("StationAddress"));
                            StationAmphur.setText(rs.getString("StationAmphur"));
                            StationProvince.setText(rs.getString("StationProvince"));
                            BK.setText(rs.getString("BK"));
                            BH.setText(rs.getString("BH"));
                            Fax.setText(rs.getString("Fax"));
                            TelStation.setText(rs.getString("TelStation"));
                            PhonePolice.setText(rs.getString("PhonePolice"));
                            HeadName.setText(rs.getString("HeadName"));
                            HeadPosition.setText(rs.getString("HeadPosition"));
                            HeadWorkName.setText(rs.getString("HeadWorkName"));
                            HeadWorkPosition.setText(rs.getString("HeadWorkPosition"));
                            CriminalCourt.setText(rs.getString("CriminalCourt"));
                            JuvenileCourt.setText(rs.getString("JuvenileCourt"));
                            DistrictCourt.setText(rs.getString("DistrictCourt"));
                            MilitaryCourt.setText(rs.getString("MilitaryCourt"));
                            AssetCourt.setText(rs.getString("AssetCourt"));
                            LocationOfD.setText(rs.getString("LocationOfDrug"));
                            CheckGun.setText(rs.getString("CheckGun"));
                            CheckDrug.setText(rs.getString("CheckDrug"));
                            CheckOtherExhibit.setText(rs.getString("CheckOtherExhibit"));
                            CauseSerious.setText(rs.getString("CauseSerious"));
                            ProvincProsecutor.setText(rs.getString("ProvincProsecutor"));
                            ProvincProsecutorCh.setText(rs.getString("ProvincProsecutorCh"));
                            THNumBook.setText(rs.getString("THNumBook"));
                            ProtectChild.setText(rs.getString("ProtectChild"));
                            StationMoo.setText(rs.getString("StationMoo"));
                            StationTambon.setText(rs.getString("StationTambon"));
                            Postcode.setText(rs.getString("Postcode"));
                            HeadRankFull.setText(rs.getString("HeadRankFull"));
                            HeadRankShort.setText(rs.getString("HeadRankShort"));
                            HeadWorkRankFull.setText(rs.getString("HeadWorkRankFull"));
                            HeadWorkRankShort.setText(rs.getString("HeadWorkRankShort"));
                
            }
    } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(StationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new StationForm().setVisible(true);
            }
        });
    }
      private void openText(){
    PoliceStationCode.setEnabled(true);
        PoliceStationName.setEnabled(true);
    PoliceStationShort.setEnabled(true);
    BK.setEnabled(true);
    BH.setEnabled(true);
    StationAddress.setEnabled(true);
    StationMoo.setEnabled(true);
    StationTambon.setEnabled(true);
    StationAmphur.setEnabled(true);
    StationProvince.setEnabled(true);
    Postcode.setEnabled(true);
    TelStation.setEnabled(true);
    PhonePolice.setEnabled(true);
    THNumBook.setEnabled(true);
    Fax.setEnabled(true);
    HeadName.setEnabled(true);
    HeadPosition.setEnabled(true);
    HeadWorkName.setEnabled(true);
    HeadWorkPosition.setEnabled(true);
    CriminalCourt.setEnabled(true);
    JuvenileCourt.setEnabled(true);
    DistrictCourt.setEnabled(true);
    MilitaryCourt.setEnabled(true);
    AssetCourt.setEnabled(true);
    CheckGun.setEnabled(true);
    LocationOfD.setEnabled(true);
    CheckOtherExhibit.setEnabled(true);
    CheckDrug.setEnabled(true);
    ProtectChild.setEnabled(true);
    ProvincProsecutor.setEnabled(true);
    ProvincProsecutorCh.setEnabled(true);
    CauseSerious.setEnabled(true);
     HeadRankFull.setEnabled(true);
     HeadRankShort.setEnabled(true);
    HeadWorkRankFull.setEnabled(true);
    HeadWorkRankShort.setEnabled(true);
    }
    private void closeText(){
    PoliceStationCode.setEnabled(false);
        PoliceStationName.setEnabled(false);
    PoliceStationShort.setEnabled(false);
    BK.setEnabled(false);
    BH.setEnabled(false);
    StationAddress.setEnabled(false);
    StationMoo.setEnabled(false);
    StationTambon.setEnabled(false);
    StationAmphur.setEnabled(false);
    StationProvince.setEnabled(false);
    Postcode.setEnabled(false);
    TelStation.setEnabled(false);
    PhonePolice.setEnabled(false);
    THNumBook.setEnabled(false);
    Fax.setEnabled(false);
    HeadName.setEnabled(false);
    HeadPosition.setEnabled(false);
    HeadWorkName.setEnabled(false);
    HeadWorkPosition.setEnabled(false);
    CriminalCourt.setEnabled(false);
    JuvenileCourt.setEnabled(false);
    DistrictCourt.setEnabled(false);
    MilitaryCourt.setEnabled(false);
    AssetCourt.setEnabled(false);
    CheckGun.setEnabled(false);
    LocationOfD.setEnabled(false);
    CheckOtherExhibit.setEnabled(false);
    CheckDrug.setEnabled(false);
    ProtectChild.setEnabled(false);
    ProvincProsecutor.setEnabled(false);
    ProvincProsecutorCh.setEnabled(false);
    CauseSerious.setEnabled(false);
    HeadRankFull.setEnabled(false);
     HeadRankShort.setEnabled(false);
    HeadWorkRankFull.setEnabled(false);
    HeadWorkRankShort.setEnabled(false);

    
    }
      public static String Checknull(Object input){
					if(input==null||input==""||input=="null") { return ""; }
					return input+"";
					}
     public static String IdStation(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(PoliceStartionId) IdSatation from PoliceStation";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("IdSatation"); 
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
    private javax.swing.JTextField AssetCourt;
    private javax.swing.JTextField BH;
    private javax.swing.JTextField BK;
    private javax.swing.JTextArea CauseSerious;
    private javax.swing.JTextField CheckDrug;
    private javax.swing.JTextField CheckGun;
    private javax.swing.JTextField CheckOtherExhibit;
    private javax.swing.JTextField CriminalCourt;
    private javax.swing.JTextField DistrictCourt;
    private javax.swing.JTextField Fax;
    private javax.swing.JTextField HeadName;
    private javax.swing.JTextField HeadPosition;
    private javax.swing.JTextField HeadRankFull;
    private javax.swing.JTextField HeadRankShort;
    private javax.swing.JTextField HeadWorkName;
    private javax.swing.JTextField HeadWorkPosition;
    private javax.swing.JTextField HeadWorkRankFull;
    private javax.swing.JTextField HeadWorkRankShort;
    private javax.swing.JTextField JuvenileCourt;
    private javax.swing.JTextField LocationOfD;
    private javax.swing.JTextField MilitaryCourt;
    private javax.swing.JTextField PhonePolice;
    private javax.swing.JLabel PoliceStartionId;
    private javax.swing.JTextField PoliceStationCode;
    private javax.swing.JTextField PoliceStationName;
    private javax.swing.JTextField PoliceStationShort;
    private javax.swing.JTextField Postcode;
    private javax.swing.JTextField ProtectChild;
    private javax.swing.JTextField ProvincProsecutor;
    private javax.swing.JTextField ProvincProsecutorCh;
    private javax.swing.JTextField StationAddress;
    private javax.swing.JTextField StationAmphur;
    private javax.swing.JTextField StationMoo;
    private javax.swing.JTextField StationProvince;
    private javax.swing.JTextField StationTambon;
    private javax.swing.JTextField THNumBook;
    private javax.swing.JTextField TelStation;
    private javax.swing.JButton jButtonEditStation;
    private javax.swing.JButton jButtonSaveStation;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
