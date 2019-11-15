/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
import com.songkhla.document.TestWord;
import com.songkhla.document.W11;
import com.songkhla.document.W1;
import com.songkhla.document.W12;
import com.songkhla.document.W13;
import com.songkhla.document.W14;
import com.songkhla.document.W15;
import com.songkhla.document.W16;
import com.songkhla.document.W17;
import com.songkhla.document.W18;
import com.songkhla.document.W19;
import com.songkhla.document.W2;
import com.songkhla.document.W20;
import com.songkhla.document.W21;
import com.songkhla.document.W22;
import com.songkhla.document.W23;
import com.songkhla.document.W24;
import com.songkhla.document.W25;
import com.songkhla.document.W26;
import com.songkhla.document.W27;
import com.songkhla.document.W28;
import com.songkhla.document.W29;
import com.songkhla.document.W3;
import com.songkhla.document.W30;
import com.songkhla.document.W31;
import com.songkhla.document.W32;
import com.songkhla.document.W33;
import com.songkhla.document.W34;
import com.songkhla.document.W35;
import com.songkhla.document.W36;
import com.songkhla.document.W37;
import com.songkhla.document.W38;
import com.songkhla.document.W39;
import com.songkhla.document.W4;
import com.songkhla.document.W40;
import com.songkhla.document.W41;
import com.songkhla.document.W42;
import com.songkhla.document.W43;
import com.songkhla.document.W44;
import com.songkhla.document.W45;
import com.songkhla.document.W46;
import com.songkhla.document.W47;
import com.songkhla.document.W48;
import com.songkhla.document.W49;
import com.songkhla.document.W5;
import com.songkhla.document.W50;
import com.songkhla.document.W51;
import com.songkhla.document.W52;
import com.songkhla.document.W53;
import com.songkhla.document.W6;
import com.songkhla.document.W61;
import com.songkhla.document.W62;
import com.songkhla.document.W63;
import com.songkhla.document.W64;
import com.songkhla.document.W65;
import com.songkhla.document.W66;
import com.songkhla.document.W67;
import com.songkhla.document.W68;
import com.songkhla.document.W69;
import com.songkhla.document.W7;
import com.songkhla.document.W70;
import com.songkhla.document.W71;
import com.songkhla.document.W72;
import com.songkhla.document.W73;
import com.songkhla.document.W74;
import com.songkhla.document.W75;
import com.songkhla.document.W76;
import com.songkhla.document.W77;
import com.songkhla.document.W78;
import com.songkhla.document.W8;
import com.songkhla.document.W80;
import com.songkhla.document.W9;
import com.songkhla.document.W93;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import org.json.simple.JSONObject;
/**
 *
 * @author Petpilin
 */
public class ReportforCrimesCase extends javax.swing.JDialog  {

    /**
     * Creates new form ReportforCrimesCase
     */
    String caseid,caseyear,casetype,caseno,PoliceStaionName,noperson,pageBail;
    Connection con=null;
    PreparedStatement pst=null;;
    public ReportforCrimesCase(JFrame parrent,JSONObject datain) {
                super(parrent,true);
                
        initComponents();
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
            caseidreport.setVisible(false);
         //jCheckW5.setSelected(true);
         //jCheckW6.setSelected(true);
//        crimecaseno.setVisible(false);
        
        if(datain != null){
        caseid=datain.get("caseid")+"";
        noperson=datain.get("personid")+"";
        caseidreport.setText(caseid);
      
        pageBail=datain.get("pageBail")+"";
        if(pageBail.equals("Bail")){
        jCheckW270.setSelected(true);
       jCheckW271.setSelected(true);

        
        }
        else{
        jCheckW270.setSelected(false);
       jCheckW271.setSelected(false);
        
        }
        
        con=ConnectDatabase.connect();

        try{
        String sql="Select crimecasenoyear,crimecaseno,crimecaseyears,CaseType from CrimeCase where CaseId='"+caseid+"'";
         Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);  
                
        String sqlDataPoliceStation="SELECT * FROM PoliceStation";
        Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery(sqlDataPoliceStation); 
                
        if(rs.next()){
         
             caseyear=rs.getString("crimecaseyears");
             caseno=rs.getString("crimecaseno");
             casetype=rs.getString("CaseType");
//           
                    }
        if(rs1.next()){
          PoliceStaionName=rs1.getString("PoliceStaionName");
        }
        
        System.out.println("ffffffffffffffff : "+PoliceStaionName);
            rs1.close();
            rs.close();
        }
        catch(Exception e){
        e.printStackTrace();
        
        }
    
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jCheckW247 = new javax.swing.JCheckBox();
        jCheckW248 = new javax.swing.JCheckBox();
        jCheckW249 = new javax.swing.JCheckBox();
        jCheckW250 = new javax.swing.JCheckBox();
        jCheckW251 = new javax.swing.JCheckBox();
        jCheckW252 = new javax.swing.JCheckBox();
        jCheckW254 = new javax.swing.JCheckBox();
        jCheckW255 = new javax.swing.JCheckBox();
        jCheckW256 = new javax.swing.JCheckBox();
        jCheckW275 = new javax.swing.JCheckBox();
        jCheckW276 = new javax.swing.JCheckBox();
        jCheckW277 = new javax.swing.JCheckBox();
        jCheckW232 = new javax.swing.JCheckBox();
        jCheckW278 = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jCheckW201 = new javax.swing.JCheckBox();
        jCheckW202 = new javax.swing.JCheckBox();
        jCheckW203 = new javax.swing.JCheckBox();
        jCheckW204 = new javax.swing.JCheckBox();
        jCheckW205 = new javax.swing.JCheckBox();
        jCheckW206 = new javax.swing.JCheckBox();
        jCheckW207 = new javax.swing.JCheckBox();
        jCheckW208 = new javax.swing.JCheckBox();
        jCheckW209 = new javax.swing.JCheckBox();
        jCheckW226 = new javax.swing.JCheckBox();
        jCheckW225 = new javax.swing.JCheckBox();
        jCheckW216 = new javax.swing.JCheckBox();
        jCheckW293 = new javax.swing.JCheckBox();
        jCheckW227 = new javax.swing.JCheckBox();
        jCheckW238 = new javax.swing.JCheckBox();
        jCheckW239 = new javax.swing.JCheckBox();
        jCheckW231 = new javax.swing.JCheckBox();
        jCheckW229 = new javax.swing.JCheckBox();
        jCheckW230 = new javax.swing.JCheckBox();
        jCheckW280 = new javax.swing.JCheckBox();
        jCheckW262 = new javax.swing.JCheckBox();
        jCheckW263 = new javax.swing.JCheckBox();
        jCheckW264 = new javax.swing.JCheckBox();
        jCheckW220 = new javax.swing.JCheckBox();
        jCheckW219 = new javax.swing.JCheckBox();
        jCheckW218 = new javax.swing.JCheckBox();
        jCheckW217 = new javax.swing.JCheckBox();
        jCheckW237 = new javax.swing.JCheckBox();
        jCheckW266 = new javax.swing.JCheckBox();
        jCheckW233 = new javax.swing.JCheckBox();
        jCheckW261 = new javax.swing.JCheckBox();
        jCheckW228 = new javax.swing.JCheckBox();
        jCheckW253 = new javax.swing.JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jCheckW240 = new javax.swing.JCheckBox();
        jCheckW241 = new javax.swing.JCheckBox();
        jCheckW242 = new javax.swing.JCheckBox();
        jCheckW221 = new javax.swing.JCheckBox();
        jCheckW222 = new javax.swing.JCheckBox();
        jCheckW223 = new javax.swing.JCheckBox();
        jCheckW224 = new javax.swing.JCheckBox();
        jCheckW265 = new javax.swing.JCheckBox();
        jCheckW269 = new javax.swing.JCheckBox();
        jCheckW267 = new javax.swing.JCheckBox();
        jPanel16 = new javax.swing.JPanel();
        jCheckW246 = new javax.swing.JCheckBox();
        jCheckW245 = new javax.swing.JCheckBox();
        jCheckW244 = new javax.swing.JCheckBox();
        jCheckW243 = new javax.swing.JCheckBox();
        jCheckW215 = new javax.swing.JCheckBox();
        jCheckW213 = new javax.swing.JCheckBox();
        jCheckW214 = new javax.swing.JCheckBox();
        jCheckW212 = new javax.swing.JCheckBox();
        jCheckW234 = new javax.swing.JCheckBox();
        jCheckW257 = new javax.swing.JCheckBox();
        jCheckW258 = new javax.swing.JCheckBox();
        jCheckW273 = new javax.swing.JCheckBox();
        jCheckW272 = new javax.swing.JCheckBox();
        jCheckW270 = new javax.swing.JCheckBox();
        jCheckW271 = new javax.swing.JCheckBox();
        jCheckW236 = new javax.swing.JCheckBox();
        jCheckW235 = new javax.swing.JCheckBox();
        jCheckW260 = new javax.swing.JCheckBox();
        jCheckW259 = new javax.swing.JCheckBox();
        jCheckW211 = new javax.swing.JCheckBox();
        jCheckW274 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        caseidreport = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1270, 728));

        jPanel2.setBackground(new java.awt.Color(4, 93, 179));

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("แบบฟอร์ม");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setOpaque(false);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารเกี่ยวกับต่างด้าว คนหายและเยาวชน", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N

        jCheckW247.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW247.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW247.setText("หนังสือรายงานคนต่างด้าวเป็นผู้เสียหายในคดีอุกฉกรรจ์หรือตายโดยธรรมชาติ");
        jCheckW247.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW248.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW248.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW248.setText("หนังสือรายงานคนต่างด้าวกระทำความผิดและถูกจับกุมตัวดำเนินคดี");
        jCheckW248.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW249.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW249.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW249.setText("หนังสือขอส่งตัวคนต่างด้าว");
        jCheckW249.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW250.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW250.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW250.setText("หนังสือขอส่งรายละเอียดเกี่ยวกับคนต่างด้าวถูกกักขังหรือกักขังแทนค่าปรับ");
        jCheckW250.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW251.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW251.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW251.setText("หนังสือขอส่งตัวคนต่างด้าวหลบหนีเข้าเมืองมาเพื่อดำเนินการผลักดันออกไปนอกราชอาณาจักร");
        jCheckW251.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW252.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW252.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW252.setText("หนังสือขอให้ตรวจสอบหนังสือเดินทางหรือเอกสารที่ใช้แทนการเดินทางของบุคคลต่างด้าว");
        jCheckW252.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW254.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW254.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW254.setText("แบบแจ้งรูปพรรณคนหาย");
        jCheckW254.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW255.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW255.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW255.setText("แบบการสืบสวนติดตามคนหาย");
        jCheckW255.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW256.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW256.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW256.setText("แบบแจ้งผลการได้ตัวคนหายคืน");
        jCheckW256.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW275.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW275.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW275.setText("บันทึกการสอบถามเบื้องต้น(กรณีเด็กหรือเยาวชน)");
        jCheckW275.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW276.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW276.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW276.setText("หนังสือแจ้งการดำเนินคดีเด็กหรือเยาวชนไปยังสถานพินิจ");
        jCheckW276.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW277.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW277.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW277.setText("หนังสือแจ้งการจับกุมเด็กหรือเยาวชนไปยังสถานพินิจ");
        jCheckW277.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW232.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW232.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW232.setText("บันทึกการจับกุมผู้ต้องหาที่เป็นเด็กหรือเยาวชน");
        jCheckW232.setPreferredSize(new java.awt.Dimension(384, 33));

        jCheckW278.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW278.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW278.setText("หนังสือแจ้งการจับกุมเด็กหรือเยาวชนไปยังผู้ปกครอง");
        jCheckW278.setPreferredSize(new java.awt.Dimension(384, 33));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW249, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW250, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW252, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW247, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW248, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
                    .addComponent(jCheckW251, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW254, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW278, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW232, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW255, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW277, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW276, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW275, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW256, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jCheckW247, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW248, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW249, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW250, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW251, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW252, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jCheckW255, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW256, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW275, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW276, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW277, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW232, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckW254, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW278, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารเกี่ยวกับคดี", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckW201.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW201.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW201.setText("บันทึกการตรวจสำนวนการสอบสวน");
        jPanel14.add(jCheckW201, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 32, 384, -1));

        jCheckW202.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW202.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW202.setText("หนังสือส่งสำนวนคดีที่เห็นควรงดหรือให้งดการสอบสวน");
        jCheckW202.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW202ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW202, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 62, 384, -1));

        jCheckW203.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW203.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW203.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้อง แต่ยังไม่ได้ตัวผู้ต้องหา");
        jPanel14.add(jCheckW203, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, 384, -1));

        jCheckW204.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW204.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW204.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้องหรือไม่สั่งฟ้อง");
        jCheckW204.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW204ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW204, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 128, 384, -1));

        jCheckW205.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW205.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW205.setText("รายงานการสอบสวน");
        jPanel14.add(jCheckW205, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 194, 384, -1));

        jCheckW206.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW206.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW206.setText("รายงานการสอบสวนสำนวนคดีไม่ปรากฎว่าผู้ใดเป็นผู้กระทำผิด");
        jCheckW206.setPreferredSize(new java.awt.Dimension(384, 33));
        jCheckW206.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW206ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW206, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 161, -1, -1));

        jCheckW207.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW207.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW207.setText("รายงานการสอบสวนสำนวนชันสูตรพลิกศพ");
        jPanel14.add(jCheckW207, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 293, 384, -1));

        jCheckW208.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW208.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW208.setText("บันทึกคำให้การผู้กล่าวหา หรือพยาน");
        jPanel14.add(jCheckW208, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 227, 384, -1));

        jCheckW209.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW209.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW209.setText("บันทึกคำให้การผู้ต้องหา");
        jPanel14.add(jCheckW209, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 260, 384, -1));

        jCheckW226.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW226.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW226.setText("หนังสือส่งยาเสพติดของกลางไปตรวจพิสูจน์");
        jCheckW226.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW226ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW226, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 321, -1));

        jCheckW225.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW225.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW225.setText("หนังสือส่งของกลางไปตรวจพิสูจน์");
        jCheckW225.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW225ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW225, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 314, -1));

        jCheckW216.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW216.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW216.setText("บันทึกพนักงานสอบสวน");
        jPanel14.add(jCheckW216, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 326, 384, -1));

        jCheckW293.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW293.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW293.setText("หมายจับ");
        jPanel14.add(jCheckW293, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 314, -1));

        jCheckW227.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW227.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW227.setText("ฉลากปิดภาชนะบรรจุยาเสพติด");
        jCheckW227.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW227ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW227, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 321, -1));

        jCheckW238.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW238.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW238.setText("หมายเรียกผู้ต้องหา");
        jPanel14.add(jCheckW238, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 314, -1));

        jCheckW239.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW239.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW239.setText("หมายเรียกพยาน");
        jCheckW239.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW239ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW239, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 314, -1));

        jCheckW231.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW231.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW231.setText("บันทึกการจับกุม");
        jPanel14.add(jCheckW231, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 314, -1));

        jCheckW229.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW229.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW229.setText("บันทึกการชี้ตัวผู้ต้องหา");
        jPanel14.add(jCheckW229, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 314, -1));

        jCheckW230.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW230.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW230.setText("บันทึกการชี้รูปผู้ต้องหา");
        jPanel14.add(jCheckW230, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 314, -1));

        jCheckW280.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW280.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW280.setText("บัญชีสำนวนการสอบสวน");
        jCheckW280.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW280ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW280, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 314, -1));

        jCheckW262.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW262.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW262.setText("บันทึกการควบคุมผู้ต้องหา");
        jCheckW262.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW262ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW262, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 330, -1));

        jCheckW263.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW263.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW263.setText("คำร้องขอสืบพยานไว้ก่อน");
        jPanel14.add(jCheckW263, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 330, -1));

        jCheckW264.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW264.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW264.setText("บันทึกการพบและปรึกษาทนาย");
        jPanel14.add(jCheckW264, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 330, -1));

        jCheckW220.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW220.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW220.setText("บันทึกการนำชี้ที่เกิดเหตุประกอบคำรับสารภาพ");
        jPanel14.add(jCheckW220, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 330, -1));

        jCheckW219.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW219.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW219.setText("แผนที่สังเขปแสดงสถานที่เกิดเหตุ");
        jPanel14.add(jCheckW219, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 330, -1));

        jCheckW218.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW218.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW218.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีจราจรทางบก");
        jPanel14.add(jCheckW218, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 330, -1));

        jCheckW217.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW217.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW217.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีอาญา");
        jPanel14.add(jCheckW217, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 330, -1));

        jCheckW237.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW237.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW237.setText("ตำหนิรูปพรรณผู้กระทำความผิด");
        jPanel14.add(jCheckW237, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 250, 330, -1));

        jCheckW266.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW266.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW266.setText("คำร้องขอตรวจสอบการจับ");
        jPanel14.add(jCheckW266, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 280, 330, -1));

        jCheckW233.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW233.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW233.setText("บันทึกการตรวจค้น");
        jPanel14.add(jCheckW233, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 359, 391, -1));

        jCheckW261.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW261.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW261.setText("แผนประทุษกรรม");
        jPanel14.add(jCheckW261, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 321, -1));

        jCheckW228.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW228.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW228.setText("บันทึกการตรวจสภาพสภาพรถยนต์");
        jPanel14.add(jCheckW228, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 310, 259, -1));

        jCheckW253.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW253.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW253.setText("หนังสือแจ้งความคืบหน้าการสอบสวน");
        jCheckW253.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW253ActionPerformed(evt);
            }
        });
        jPanel14.add(jCheckW253, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 314, -1));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารผัดฟ้องและอื่นๆ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N

        jCheckW240.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW240.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW240.setText("บันทึกการแจ้งสิทธิตาม พ.ร.บ. ค่าตอบแทนผู้เสียหาย และค่าทดแทน \n");

        jCheckW241.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW241.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW241.setText("บันทึกการตกลงค่าเสียหาย");

        jCheckW242.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW242.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW242.setText("บันทึกคำขอรับชดใช้ค่าใช้จ่ายเบื้องต้นอันเกิดจากการขนส่ง");

        jCheckW221.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW221.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW221.setText("ใบนำส่งผู้บาดเจ็บหรือศพ");

        jCheckW222.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW222.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW222.setText("หนังสือส่งผู้ต้องหาป่วยทางจิตตรวจวินิจฉัย");

        jCheckW223.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW223.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW223.setText("รายงานชันสูตรพลิกศพ");

        jCheckW224.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW224.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW224.setText("แบบรายงานพบศพไม่ทราบชื่อ");
        jCheckW224.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW224ActionPerformed(evt);
            }
        });

        jCheckW265.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW265.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW265.setText("คำร้องขอส่งตัวผู้ต้องหาไปควบคุมตัวเพื่อพิสูจน์การเสพหรือการติดยาเสพติด");

        jCheckW269.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW269.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW269.setText("คำร้องขอฝากขัง");
        jCheckW269.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW269ActionPerformed(evt);
            }
        });

        jCheckW267.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW267.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW267.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่ 1");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW240)
                    .addComponent(jCheckW241, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW242, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW269, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW267, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW265, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW224, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW221, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW223, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW222, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jCheckW240)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW241)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW242)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW265)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW267))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jCheckW221)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jCheckW223))
                            .addComponent(jCheckW222))
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW224)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckW269)
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "เอกสารทรัพย์ ประกัน", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("TH SarabunPSK", 1, 24))); // NOI18N

        jCheckW246.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW246.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW246.setText("หนังสือแจ้งการขอประกันสิ่งของไปดูแลรักษาหรือใช้ประโยชน์");
        jCheckW246.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW246ActionPerformed(evt);
            }
        });

        jCheckW245.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW245.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW245.setText("สัญญาประกันและรับมอบสิ่งของ");

        jCheckW244.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW244.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW244.setText("คำร้องขอคืนสิ่งของ");

        jCheckW243.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW243.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW243.setText("บันทึกเสนอสัญญาประกันสิ่งของ");

        jCheckW215.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW215.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW215.setText("บัญชีทรัพย์ที่ถูกเพลิงไหม้");
        jCheckW215.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW215ActionPerformed(evt);
            }
        });

        jCheckW213.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW213.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW213.setText("บัญชีทรัพย์ถูกประทุษร้ายได้คืน");

        jCheckW214.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW214.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW214.setText("บัญชีทรัพย์ถูกประทุษร้ายไม่ได้คืน");
        jCheckW214.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW214ActionPerformed(evt);
            }
        });

        jCheckW212.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW212.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW212.setText("บัญชีทรัพย์ถูกประทุษร้าย");

        jCheckW234.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW234.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW234.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้น");
        jCheckW234.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW234ActionPerformed(evt);
            }
        });

        jCheckW257.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW257.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW257.setText("ตำหนิรูปพรรณทรัพย์หาย");

        jCheckW258.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW258.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW258.setText("ตำหนิรูปพรรณทรัพย์หายได้คืน");
        jCheckW258.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW258ActionPerformed(evt);
            }
        });

        jCheckW273.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW273.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW273.setText("บันทึกรับรองการเป็นโสด");

        jCheckW272.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW272.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW272.setText("คำยินยอมกรณีผู้ให้สัญญาค้ำประกันมีคู่สมรส");

        jCheckW270.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW270.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW270.setText("บันทึกเสนอสัญญาประกัน");

        jCheckW271.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW271.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW271.setText("คำร้องและสัญญาประกัน");
        jCheckW271.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW271ActionPerformed(evt);
            }
        });

        jCheckW236.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW236.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW236.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW235.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW235.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW235.setText("บัญชีการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW260.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW260.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW260.setText("แบบรายการรถยนต์หรือรถจักรยานยนต์ที่ได้คืน");

        jCheckW259.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW259.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW259.setText("แบบรูปพรรณรถยนต์หรือรถจักรยนต์ที่ถูกโจรกรรม");
        jCheckW259.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW259ActionPerformed(evt);
            }
        });

        jCheckW211.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW211.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW211.setText("บัญชีของกลางคดีอาญา");

        jCheckW274.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW274.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW274.setText("หนังสือแจ้งอายัดตั๋วฯ");
        jCheckW274.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW274ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW212, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW234, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckW235, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckW236, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckW215, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW214, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(jCheckW213, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW211, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW244, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW245, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW271, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW270, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW273, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckW246)
                    .addComponent(jCheckW243, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW272, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW260)
                    .addComponent(jCheckW259)
                    .addComponent(jCheckW258, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW257, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW274, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jCheckW260)
                                .addGap(99, 99, 99)
                                .addComponent(jCheckW211))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jCheckW259)
                                .addGap(99, 99, 99)))
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW213))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckW212)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jCheckW215))
                            .addComponent(jCheckW234))
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW214)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW235)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jCheckW236))))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckW257)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW258))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jCheckW243)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW244, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jCheckW245)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckW246)))
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckW272)
                    .addComponent(jCheckW274))
                .addGap(0, 0, 0)
                .addComponent(jCheckW273)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckW270)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckW271))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel12);

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("สร้างเอกสาร");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        caseidreport.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(caseidreport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caseidreport))
                .addGap(0, 73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckW202ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW202ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW202ActionPerformed

    private void jCheckW204ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW204ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW204ActionPerformed

    private void jCheckW206ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW206ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW206ActionPerformed

    private void jCheckW226ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW226ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW226ActionPerformed

    private void jCheckW225ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW225ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW225ActionPerformed

    private void jCheckW227ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW227ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW227ActionPerformed

    private void jCheckW239ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW239ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW239ActionPerformed

    private void jCheckW280ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW280ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW280ActionPerformed

    private void jCheckW262ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW262ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW262ActionPerformed

    private void jCheckW253ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW253ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW253ActionPerformed

    private void jCheckW224ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW224ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW224ActionPerformed

    private void jCheckW269ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW269ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW269ActionPerformed

    private void jCheckW246ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW246ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW246ActionPerformed

    private void jCheckW215ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW215ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW215ActionPerformed

    private void jCheckW214ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW214ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW214ActionPerformed

    private void jCheckW234ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW234ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW234ActionPerformed

    private void jCheckW258ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW258ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW258ActionPerformed

    private void jCheckW271ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW271ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW271ActionPerformed

    private void jCheckW259ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW259ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW259ActionPerformed

    private void jCheckW274ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW274ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW274ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        yourAttemptActionPerformed();
    }//GEN-LAST:event_jButton1ActionPerformed

         private void yourAttemptActionPerformed() {


       
    new BackgroundWorker().execute();


    }
       
    public class BackgroundWorker extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
		private JDialog dialog;
//   public void Task() {
//       
//    }
//       public ProgressWorker(JProgressBar progress) {
//            this.progress = progress;
//        
            public BackgroundWorker() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
							dialog = new JDialog();
                                                        ImageIcon img = new ImageIcon("./Master/WD.png");
                                                           dialog.setIconImage(img.getImage());
							dialog.setTitle("Processing");
							dialog.setLayout(new GridBagLayout());
							dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							GridBagConstraints gbc = new GridBagConstraints();
							gbc.insets = new Insets(2, 2, 2, 2);
							gbc.weightx = 1;
							gbc.gridy = 0;
							dialog.add(new JLabel("Processing..."), gbc);
							pb = new JProgressBar();
							pb.setStringPainted(true);
//                                                        pb.setForeground(Color.blue);]
                                               
                                                        pb.setMaximum(100);
                                                        pb.setMinimum(0);
                                                        
							gbc.gridy = 1;
							dialog.add(pb, gbc);
							dialog.pack();
							dialog.setLocationRelativeTo(null);
							dialog.setModal(true);
							JDialog.setDefaultLookAndFeelDecorated(true); 
							dialog.setVisible(true);
						}
						pb.setValue(getProgress());
					}
				}

			});
		}
    @Override
    public Void doInBackground() {
            String no=caseidreport.getText();
            JCheckBox[] boxes = {jCheckW201,jCheckW202,jCheckW203,jCheckW204,jCheckW205,jCheckW206,jCheckW208,jCheckW209,jCheckW211,jCheckW212,jCheckW213,jCheckW214};
        try { 
            for (int i = 0; i < boxes.length; i++) {
//                x = x - i;
            setProgress((int)((i*100)/boxes.length)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task
   
//            caseyear=crimecaseyear.getText();
//           caseno=crimecaseno.getText();
//           casetype=CaseType.getText();   
           
        File f3=new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
   
        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
          if(jCheckW201.isSelected()){
            W1.w1(no);
        }

                if(jCheckW202.isSelected()){
            W2.w2(no);

        }
        if(jCheckW203.isSelected()){
            W3.w3(no);
        }
        if(jCheckW204.isSelected()){
            W4.w4(no);
        }
        if(jCheckW205.isSelected()){
            W5.w5(no);
        }
        if(jCheckW206.isSelected()){
            W6.w6(no);
        }
        if(jCheckW207.isSelected()){
           W7.w7(no);
        }
        if(jCheckW208.isSelected()){
            W8.w8(no);
        }
        if(jCheckW209.isSelected()){
            W9.w9(no);
        }
        if(jCheckW211.isSelected()){
            W11.w11(no);
        }
        if(jCheckW212.isSelected()){
            W12.w12(no);
          }
        if(jCheckW213.isSelected()){
            W13.w13(no);
            }
         if(jCheckW214.isSelected()){
             W14.w14(no);
             }
                if(jCheckW215.isSelected()){
                        W15.w15(no);
                    }
               if(jCheckW216.isSelected()){
                        W16.w16(no);
                    }
               if(jCheckW217.isSelected()){
                        W17.w17(no);
                    }
               if(jCheckW218.isSelected()){
                      W18.w18(no);
                     }
               if(jCheckW219.isSelected()){
                        W19.w19(no);
                    }
               if(jCheckW220.isSelected()){
                        W20.w20(no);
                    }
               
               if(jCheckW221.isSelected()){
                        W21.w21(no);
                    }
               if(jCheckW222.isSelected()){
                        W22.w22(no);
                    }
               if(jCheckW223.isSelected()){
                        W23.w23(no);
                    }
               if(jCheckW224.isSelected()){
                        W24.w24(no);
                    }
               if(jCheckW225.isSelected()){
                        W25.w25(no);
                    }
               
               if(jCheckW226.isSelected()){
                        W26.w26(no);
                    }
               if(jCheckW227.isSelected()){
                        W27.w27(no);
                    }
               if(jCheckW228.isSelected()){
                        W28.w28(no);
                    }
               if(jCheckW229.isSelected()){
                        W29.w29(no);
                    }
               if(jCheckW230.isSelected()){
                        W30.w30(no);
                    }
               if(jCheckW231.isSelected()){
                        W31.w31(no);
                    }
               if(jCheckW232.isSelected()){
                        W32.w32(no);
                    }
               if(jCheckW233.isSelected()){
                        W33.w33(no);
                    }
               if(jCheckW234.isSelected()){
                        W34.w34(no);
                    }
               if(jCheckW235.isSelected()){
                        W35.w35(no);
                    }
               if(jCheckW236.isSelected()){
                        W36.w36(no);
                    }
               if(jCheckW237.isSelected()){
                        W37.w37(no);
                    }
               if(jCheckW238.isSelected()){
                        W38.w38(no);
                    }
               if(jCheckW239.isSelected()){
                        W39.w39(no);
                    }
               if(jCheckW240.isSelected()){
                     W40.w40(no);
                  }
               if(jCheckW241.isSelected()){
                        W41.w41(no);
                    }
              if(jCheckW242.isSelected()){
                        W42.w42(no);
                    }
              if(jCheckW243.isSelected()){
                        W43.w43(no);
                    }
              if(jCheckW244.isSelected()){
                        W44.w44(no);
                    }
              if(jCheckW245.isSelected()){
                        W45.w45(no);
                    }
               if(jCheckW246.isSelected()){
                        W46.w46(no);
                    }
               if(jCheckW247.isSelected()){
                        W47.w47(no);
                    }
               if(jCheckW248.isSelected()){
                        W48.w48(no);
                    }
               if(jCheckW249.isSelected()){
                        W49.w49(no);
                    }
               if(jCheckW250.isSelected()){
                        W50.w50(no);
                    }
               if(jCheckW251.isSelected()){
                        W51.w51(no);
                    }
               if(jCheckW252.isSelected()){
                        W52.nw52();
                    }
               if(jCheckW253.isSelected()){
                        W53.w53(no);
                    }
               if(jCheckW261.isSelected()){
                        W61.w61(no);
                    }
               if(jCheckW262.isSelected()){
                        W62.w62(no);
                    }
               if(jCheckW263.isSelected()){
                        W63.w63(no);
                    }
               if(jCheckW264.isSelected()){
                        W64.w64(no);
                    }
               if(jCheckW265.isSelected()){
                        W65.w65(no);
                    }
               if(jCheckW266.isSelected()){
                        W66.w66(no);
                    }
               if(jCheckW267.isSelected()){
//                        W67.w67(no);
                    }
     
               if(jCheckW269.isSelected()){
                        W69.w69(no);
                    }
               if(jCheckW270.isSelected()){
                        W70.w70(no,noperson);
                    }
               if(jCheckW271.isSelected()){
                        W71.w71(no,noperson);
                    }
               if(jCheckW272.isSelected()){
                        W72.w72(no);
                    }
               if(jCheckW273.isSelected()){
                        W73.w73(no);
                    }
               if(jCheckW274.isSelected()){
                        W74.w74(no);
                    }
               if(jCheckW275.isSelected()){
                        W75.w75(no);
                    }
               if(jCheckW276.isSelected()){
                        W76.w76(no);
                    }
               if(jCheckW277.isSelected()){
                        W77.w77(no);
                    }
               if(jCheckW278.isSelected()){
                        W78.w78(no);
                    }
               
               if(jCheckW280.isSelected()){
                        W80.w80(no);
                    }
               if(jCheckW293.isSelected()){
                        W93.w93(no);
                    }
            }
        } catch (InterruptedException e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
             Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+"/"+casetype+caseno+"-"+caseyear);
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/
    private static File OpenFile(String PoliceStaionName,String caseyear,String caseno,String FileName){
    
     Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {    
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/คดีอาญา"+caseno+"-"+caseyear+"/"+FileName);
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found");
        }
        return dirToOpen;
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
            java.util.logging.Logger.getLogger(ReportforCrimesCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportforCrimesCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportforCrimesCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportforCrimesCase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ReportforCrimesCase().setVisible(true);
            }
        });
      

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel caseidreport;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckW201;
    private javax.swing.JCheckBox jCheckW202;
    private javax.swing.JCheckBox jCheckW203;
    private javax.swing.JCheckBox jCheckW204;
    private javax.swing.JCheckBox jCheckW205;
    private javax.swing.JCheckBox jCheckW206;
    private javax.swing.JCheckBox jCheckW207;
    private javax.swing.JCheckBox jCheckW208;
    private javax.swing.JCheckBox jCheckW209;
    private javax.swing.JCheckBox jCheckW211;
    private javax.swing.JCheckBox jCheckW212;
    private javax.swing.JCheckBox jCheckW213;
    private javax.swing.JCheckBox jCheckW214;
    private javax.swing.JCheckBox jCheckW215;
    private javax.swing.JCheckBox jCheckW216;
    private javax.swing.JCheckBox jCheckW217;
    private javax.swing.JCheckBox jCheckW218;
    private javax.swing.JCheckBox jCheckW219;
    private javax.swing.JCheckBox jCheckW220;
    private javax.swing.JCheckBox jCheckW221;
    private javax.swing.JCheckBox jCheckW222;
    private javax.swing.JCheckBox jCheckW223;
    private javax.swing.JCheckBox jCheckW224;
    private javax.swing.JCheckBox jCheckW225;
    private javax.swing.JCheckBox jCheckW226;
    private javax.swing.JCheckBox jCheckW227;
    private javax.swing.JCheckBox jCheckW228;
    private javax.swing.JCheckBox jCheckW229;
    private javax.swing.JCheckBox jCheckW230;
    private javax.swing.JCheckBox jCheckW231;
    private javax.swing.JCheckBox jCheckW232;
    private javax.swing.JCheckBox jCheckW233;
    private javax.swing.JCheckBox jCheckW234;
    private javax.swing.JCheckBox jCheckW235;
    private javax.swing.JCheckBox jCheckW236;
    private javax.swing.JCheckBox jCheckW237;
    private javax.swing.JCheckBox jCheckW238;
    private javax.swing.JCheckBox jCheckW239;
    private javax.swing.JCheckBox jCheckW240;
    private javax.swing.JCheckBox jCheckW241;
    private javax.swing.JCheckBox jCheckW242;
    private javax.swing.JCheckBox jCheckW243;
    private javax.swing.JCheckBox jCheckW244;
    private javax.swing.JCheckBox jCheckW245;
    private javax.swing.JCheckBox jCheckW246;
    private javax.swing.JCheckBox jCheckW247;
    private javax.swing.JCheckBox jCheckW248;
    private javax.swing.JCheckBox jCheckW249;
    private javax.swing.JCheckBox jCheckW250;
    private javax.swing.JCheckBox jCheckW251;
    private javax.swing.JCheckBox jCheckW252;
    private javax.swing.JCheckBox jCheckW253;
    private javax.swing.JCheckBox jCheckW254;
    private javax.swing.JCheckBox jCheckW255;
    private javax.swing.JCheckBox jCheckW256;
    private javax.swing.JCheckBox jCheckW257;
    private javax.swing.JCheckBox jCheckW258;
    private javax.swing.JCheckBox jCheckW259;
    private javax.swing.JCheckBox jCheckW260;
    private javax.swing.JCheckBox jCheckW261;
    private javax.swing.JCheckBox jCheckW262;
    private javax.swing.JCheckBox jCheckW263;
    private javax.swing.JCheckBox jCheckW264;
    private javax.swing.JCheckBox jCheckW265;
    private javax.swing.JCheckBox jCheckW266;
    private javax.swing.JCheckBox jCheckW267;
    private javax.swing.JCheckBox jCheckW269;
    private javax.swing.JCheckBox jCheckW270;
    private javax.swing.JCheckBox jCheckW271;
    private javax.swing.JCheckBox jCheckW272;
    private javax.swing.JCheckBox jCheckW273;
    private javax.swing.JCheckBox jCheckW274;
    private javax.swing.JCheckBox jCheckW275;
    private javax.swing.JCheckBox jCheckW276;
    private javax.swing.JCheckBox jCheckW277;
    private javax.swing.JCheckBox jCheckW278;
    private javax.swing.JCheckBox jCheckW280;
    private javax.swing.JCheckBox jCheckW293;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
