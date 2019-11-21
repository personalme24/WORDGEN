/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.AccusedForm.CauseSendInjuredOrDie;
import static com.songkhla.wordgen.AccusedForm.DateSendInjuredOrDie;
import static com.songkhla.wordgen.AccusedForm.TimeSendInjuredOrDie;
import static com.songkhla.wordgen.AccusedForm.WhereSendInjuredOrDie;
import static com.songkhla.wordgen.CrimesCaseEdit.ChargeNameCase;
import static com.songkhla.wordgen.CrimesCaseEdit.Checknull;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
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
       PreparedStatement pst2=null;
     boolean isInsert,isPerson;
     String noPerson,caseid,typecase;
     JDatePickerImpl ArrestDateTime,IssueDate,ExpiredDate,BirthDay,RestoreDate,BailDate,AttachlDate;
      JDatePanelImpl datePanel3;
      
           ArrayList<String> personname=new ArrayList<String>();
    ButtonGroup g=new ButtonGroup();       
    /**
     * Creates new form AccusedForm
     */
    public SuspectForm(JFrame parrent,JSONObject datain,JSONObject datacase) {
        super(parrent,true);     
        initComponents();  
         eventJRadioManage();
            ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES) BETA");
                       jButtonBail.setVisible(false);
           jButtonSue.setVisible(false);
     jLabel36.setVisible(false);
          jLabel37.setVisible(false);

     jLabelNameArrest.setVisible(false);
     NameArrest.setVisible(false);
     AnswerPerson.setVisible(false);
      CauseSendInjuredOrDie.setVisible(false);
       WhereSendInjuredOrDie.setVisible(false);
       TimeSendInjuredOrDie.setVisible(false);
       DateSendInjuredOrDie.setVisible(false);
       jLabel40.setVisible(false);
       jLabel41.setVisible(false);
        jButtonInjuryOrDie.setVisible(false); 
//     jCheckInjured.setVisible(false);
//      jCheckDead.setVisible(false);
        StatusSuspectOther.setVisible(false);
          jLabelStatusSuspect.setVisible(false);
     typecase=datacase.get("TypeCase")+"";
//  ---------------------------------------------Date Filed----------------------------------------------
     UtilDateModel model = new UtilDateModel();
//            model.setValue(Calendar.getInstance().getTime()); 
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
         ArrestDateTime = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        ArrestDateTime.setPreferredSize(new Dimension(200,30));
    ArrestDateTime.getComponent(0).setPreferredSize(new Dimension(170,30)); //JFormattedTextField
    ArrestDateTime.getComponent(1).setPreferredSize(new Dimension(30,30));//JButton
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

        colseTextBox();
       
        g.add(jRadioSue);
        g.add(jRadioStatus1);
        g.add(jRadioCantCatch);
        g.add(jRadioStatus2);
        g.add(jRadioRestore);
        g.add(jRadioFreeze);
        g.add(jRadioWithdrawComplaint); 
        g.add(jRadioOther);
       g.add(jRadioRelease);
 ButtonGroup w=new ButtonGroup(); 
 
            w.add(jRadioButton1);
        w.add(jRadioButton2);
        w.add(jRadioButton3);
        w.add(jRadioButton4);
        w.add(jRadioButton5);      
           FullNamePerson.addCaretListener(new TextFieldSusListener());
          jComboBoxListName.addActionListener(new ComboBoxActionListener());
//           jRadioStatus1.setEnabled(false);
     
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
            
           
//---------------------------------------------------Data--------------------------------------------
          if(datain!=null){
            noPerson=datain.get("NoPerson")+"";
              CheckBail(noPerson);
            isInsert=false;
            String statusSus,statusBail;
            statusSus=datain.get("StatusSuspect")+"";
             statusBail=datain.get("StatusBail")+"";
            CourtSuspect.setSelectedItem(Checknull(datain.get("CourtSuspect")));
            Gender.setSelectedItem(Checknull(datain.get("Gender")));               
            RatePrison.setSelectedItem(Checknull(datain.get("RatePrison")));            
            caseid=datain.get("caseIdPerson")+"";
          
           
            jLabel37.setText(Checknull(datain.get("NoPerson"))+"");
            jLabel36.setText(Checknull(datain.get("caseIdPerson"))+"");
            PeopleRegistrationID.setText(Checknull(datain.get("PeopleRegistrationID"))+"");
            String known=datain.get("FullNamePerson")+"";
            Identification.setText(Checknull(datain.get("Identification"))+"");
            FullNamePerson.setText(Checknull(datain.get("FullNamePerson"))+"");
            OrderPerson.setText(Checknull(datain.get("OrderPerson"))+"");
            Age.setText(Checknull(datain.get("Age"))+"");
            Amphur.setText(Checknull(datain.get("Amphur"))+"");
            BirthDay.getJFormattedTextField().setText(Checknull(datain.get("BirthDay"))+"");
            BloodGroup.setSelectedItem(Checknull(datain.get("BloodGroup"))+"");
            ExpiredDate.getJFormattedTextField().setText(Checknull(datain.get("ExpiredDate"))+"");
            FatherFullName.setText(Checknull(datain.get("FatherFullName"))+"");
            FullNamePersonEn.setText(Checknull(datain.get("FullNamePersonEn"))+"");
            Height.setText(Checknull(datain.get("Height"))+"");
            Weight.setText(Checknull(datain.get("Weight"))+"");
            HouseNumber.setText(Checknull(datain.get("HouseNumber"))+"");
            IssueDate.getJFormattedTextField().setText(Checknull(datain.get("IssueDate"))+"");
            Moo.setText(Checknull(datain.get("Moo"))+"");
            MotherFullName.setText(Checknull(datain.get("MotherFullName"))+"");
            Nationality.setText(Checknull(datain.get("Nationality"))+"");
            Occupation.setText(Checknull(datain.get("Occupation"))+"");
            PassportNumber.setText(Checknull(datain.get("PassportNumber"))+"");
            PhonePerson.setText(Checknull(datain.get("PhonePerson"))+"");
            PlaceArrest.setText(Checknull(datain.get("PlaceArrest"))+"");
            Province.setText(Checknull(datain.get("Province"))+"");
             ZipCode.setText(Checknull(datain.get("ZipCode"))+""); 
             Road.setText(Checknull(datain.get("Road"))+"");
            Soi.setText(Checknull(datain.get("StatusSuspectOther"))+"");         
             OtherName.setText(Checknull(datain.get("OtherName"))+"");
            Race.setText(Checknull(datain.get("Race"))+"");
            Religion.setText(Checknull(datain.get("Religion"))+"");
            Tambon.setText(Checknull(datain.get("Tambon"))+"");
            AnswerPerson.setText(Checknull(datain.get("AnswerPerson"))+"");
            PlaceArrestTambon.setText(Checknull(datain.get("PlaceArrestTambon"))+"");
            PlaceArrestAmphur.setText(Checknull(datain.get("PlaceArrestAmphur"))+"");
            PlaceArrestProvince.setText(Checknull(datain.get("PlaceArrestProvince"))+"");
            OccupationPosition.setText(Checknull(datain.get("OccupationPosition"))+"");
            Religion.setText(Checknull(datain.get("Religion"))+"");
            NoArrestWarrant.setText(Checknull(datain.get("NoArrestWarrant"))+"");
            SusConfress.setSelectedItem(Checknull(datain.get("SusConfress")));
            StatusSuspectOther.setText(Checknull(datain.get("StatusSuspectOther"))+"");
            
             String statusInjure=datain.get("Soi")+"";
            if(statusInjure.equals("บาดเจ็บ")){
            jCheckInjured.setSelected(true);
            }
           else if(statusInjure.equals("ตาย")){
            jCheckDead.setSelected(true);
            }
             DateSendInjuredOrDie.setText(Checknull(datain.get("DateSendInjuredOrDie"))+"");   
           CauseSendInjuredOrDie.setText(Checknull(datain.get("CauseSendInjuredOrDie"))+"");
           WhereSendInjuredOrDie.setText(Checknull(datain.get("WhereSendInjuredOrDie"))+"");
           try{
            String ote=datain.get("TimeSendInjuredOrDie")+"";
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date timeSend = timeFormat.parse(ote);
                TimeSendInjuredOrDie.setValue(timeSend);
            }
            catch(Exception ex){
            
            }
            SimpleDateFormat format=new SimpleDateFormat("d/M/yyyy");
            SimpleDateFormat format2=new SimpleDateFormat("d/M/yyyy HH:mm");
           SimpleDateFormat formattime=new SimpleDateFormat("HH:mm");

            String DateArr=(Checknull(datain.get("ArrestDateTime"))+"");
             String TimeArr=(Checknull(datain.get("ArrestDateTime"))+"");

               System.out.println("dsssssss :"+DateArr+"aa");
               
//             ArrestDateTime.getJFormattedTextField().setText(datain.get("ArrestDateTime")+"");            
            if(DateArr.equals(" ")||DateArr.equals(null)||DateArr.equals("null")||DateArr.equals("")){  
             ArrestDateTime.getJFormattedTextField().setText("");
                 }
            else{
             Date d=null;   
             Date t=null;
             Date t2;

            try{
             d=format2.parse(DateArr);
             t=format2.parse(TimeArr);
            String t22=formattime.format(t);
            t2=formattime.parse(t22);

                System.out.println("dsssssss :"+t22+"tt");
                 System.out.println("dsssssss :"+format.format(d)+"dd");
             ArrestDateTime.getJFormattedTextField().setText(format.format(d));
             jSpinnerArrTime.setValue(t2);
            }
            catch(Exception e){
            }
//             
            }

            ArrestDateTimeEnd.setText(datain.get("ArrestDateTimeEnd")+"");
            BailDate.getJFormattedTextField().setText(Checknull(datain.get("BailDate"))+"");
            PlaceArrest.setText(Checknull(datain.get("PlaceArrest"))+"");
            String statuswar=datain.get("StatusWarrant")+"";
             if(statuswar.equals("รอคำสั่งศาล")){
            jRadioButton1.setSelected(true);
            }
            else if (statuswar.equals("ยกเลิก")){
                jRadioButton2.setSelected(true);
//             jRadioStatus2.setText("ผัดฟ้อง");
   
            }
            else if (statuswar.equals("รออนุมัติ")){
                 jRadioButton3.setSelected(true);
            }
             else if(statuswar.equals("ยกคำร้อง")){
             jRadioButton4.setSelected(true);
//             jRadioStatus2.setText("แจ้งข้อหาปล่อยตัว");
                }
                else if(statuswar.equals("ถอนประกาศสืบจับ")){
             jRadioButton5.setSelected(true);
                }
            if(statusSus.equals("ผัดฟ้องฝากขัง")){
            jRadioStatus1.setSelected(true);
             jRadioStatus1.setText("ผัดฟ้องฝากขัง");

            }
            else if (statusSus.equals("ผัดฟ้อง")){
                jRadioStatus2.setSelected(true);
//             jRadioStatus2.setText("ผัดฟ้อง");
   
            }
            else if (statusSus.equals("ฝากขัง")){
                 jRadioStatus1.setSelected(true);
             jRadioStatus1.setText("ฝากขัง");
            }
          
            
             else if(statusSus.equals("แจ้งข้อหาปล่อยตัว")){
             jRadioRelease.setSelected(true);
//             jRadioStatus2.setText("แจ้งข้อหาปล่อยตัว");
                }
                else if(statusSus.equals("หลบหนี")){
             jRadioCantCatch.setSelected(true);
                }
              else if(statusSus.equals("ฟ้องวาจา")){
             jRadioSue.setSelected(true);
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
             StatusSueAndPutInJail.setText(Checknull(datain.get("StatusSueAndPutInJail"))+"");
             String court=datain.get("CourtSuspect")+"";
               if(court.equals("ศาลอาญา/ศาลจังหวัด")){

                            jRadioStatus1.setText("ฝากขัง");
//                            jRadioStatus2.setText("แจ้งข้อหาปล่อยตัว");
//                            jRadioStatus2.setVisible(false);
                            jRadioSue.setVisible(false);
//                            jRadioRelease.setVisible(false);
                        }
                         else if(court.equals("ศาลแขวง")){
                            jRadioStatus1.setText("ผัดฟ้องฝากขัง");
//                            jRadioStatus2.setText("ผัดฟ้อง");
                            jRadioSue.setVisible(true);
                        }
                         else  if(court.equals("ศาลแขวง")&& jCheckBail.isSelected()){
                               jRadioStatus1.setText("ผัดฟ้องฝากขัง");
                                jRadioStatus1.setSelected(false);
//                            jRadioStatus2.setText("ผัดฟ้อง");
                            jRadioSue.setVisible(true);
                            jRadioStatus1.setEnabled(false);
                            jRadioCantCatch.setEnabled(false);   }
                     

        }else{

//           crimecaseno.setText(ListSuspect.txtCaseNO.getText());
            isInsert=true;
            jLabel36.setText(datacase.get("CaseId")+"");
            jLabel37.setText(idPerson());
    
        }
//          ------------------------------------Data------------------------------------------
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
                CourtSuspect.addItemListener(new ItemListener() {

                       public void itemStateChanged(ItemEvent arg0) {
                             if (arg0.getStateChange() == ItemEvent.SELECTED) {
                        String selectedValue = arg0.getItem().toString();
                         // do something with object
                         jCheckBail.setSelected(false);
                         
                         g.clearSelection();
//                         jRadioStatus1.setEnabled(true);
//                         jRadioStatus2.setEnabled(true);
//                         jRadioSue.setEnabled(true);
//                         jRadioWithdrawComplaint.setEnabled(true);
//                         jRadioRestore.setEnabled(true);
//                         jRadioCantCatch.setEnabled(true);
//                         jRadioFreeze.setEnabled(true);
//                         jRadioOther.setEnabled(true);                       
//                                 jRadioRelease.setEnabled(true);
                         if(selectedValue.equals("ศาลอาญา/ศาลจังหวัด")){

                            jRadioStatus1.setText("ฝากขัง");
//                            jRadioStatus2.setText("แจ้งข้อหาปล่อยตัว");
//                            jRadioStatus2.setVisible(false);
                            jRadioSue.setVisible(false);
//                            jRadioRelease.setVisible(false);
                        }
                         else if(selectedValue.equals("ศาลแขวง")){
                            jRadioStatus1.setText("ผัดฟ้องฝากขัง");
//                            jRadioStatus2.setText("ผัดฟ้อง");
                            jRadioSue.setVisible(true);
                        }
                         else  if(selectedValue.equals("ศาลแขวง")&& jCheckBail.isSelected()){
                               jRadioStatus1.setText("ผัดฟ้องฝากขัง");
                                jRadioStatus1.setSelected(false);
//                            jRadioStatus2.setText("ผัดฟ้อง");
                            jRadioSue.setVisible(true);
                            jRadioStatus1.setEnabled(false);
                            jRadioCantCatch.setEnabled(false);   }
                      }     
                       }
                   });
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
//            ------------------------------------------Right Ckick----------------------------------
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
       JTextPopupMenu.addTo(FatherFullName);
       JTextPopupMenu.addTo(MotherFullName);
       JTextPopupMenu.addTo(PhonePerson);
       JTextPopupMenu.addTo(HouseNumber);
       JTextPopupMenu.addTo(Moo);
       JTextPopupMenu.addTo(Tambon);
       JTextPopupMenu.addTo(Amphur);
       JTextPopupMenu.addTo(Province);
       JTextPopupMenu.addTo(ZipCode);
        JTextPopupMenu.addTo(StatusSueAndPutInJail);
        JTextPopupMenu.addTo(Identification);
        
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
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
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
        StatusSueAndPutInJail = new javax.swing.JTextField();
        HouseNumber = new javax.swing.JTextField();
        Tambon = new javax.swing.JTextField();
        Amphur = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Identification = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        BtSaveAccused = new javax.swing.JButton();
        SusConfress = new javax.swing.JComboBox<>();
        Province = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        OrderPerson = new javax.swing.JTextField();
        jComboBoxListName = new javax.swing.JComboBox<>();
        AnswerPerson = new javax.swing.JTextField();
        jLabelArrestEnd = new javax.swing.JLabel();
        ArrestDateTimeEnd = new javax.swing.JTextField();
        BloodGroup = new javax.swing.JComboBox<>();
        jLabelNameArrest = new javax.swing.JLabel();
        NameArrest = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        OccupationPosition = new javax.swing.JTextField();
        jCheckInjured = new javax.swing.JCheckBox();
        jCheckDead = new javax.swing.JCheckBox();
        jButtonInjuryOrDie = new javax.swing.JButton();
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        TimeSendInjuredOrDie = new javax.swing.JSpinner(sm3);
        CauseSendInjuredOrDie = new javax.swing.JTextField();
        DateSendInjuredOrDie = new javax.swing.JTextField();
        WhereSendInjuredOrDie = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PeopleRegistrationID = new javax.swing.JTextField();
        BtAddAnswer = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        Road = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        Soi = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButtonSue = new javax.swing.JButton();
        jButtonBail = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
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
        jCheckBail = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabelRate = new javax.swing.JLabel();
        RatePrison = new javax.swing.JComboBox<>();
        CourtSuspect = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanelAttachlDate = new javax.swing.JPanel();
        Attach = new javax.swing.JTextField();
        jLabelFreezeDate = new javax.swing.JLabel();
        jLabelFreezeOrg = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jRadioOther = new javax.swing.JRadioButton();
        jRadioFreeze = new javax.swing.JRadioButton();
        jRadioCantCatch = new javax.swing.JRadioButton();
        jRadioWithdrawComplaint = new javax.swing.JRadioButton();
        jRadioSue = new javax.swing.JRadioButton();
        jRadioRelease = new javax.swing.JRadioButton();
        StatusSuspectOther = new javax.swing.JTextField();
        jLabelStatusSuspect = new javax.swing.JLabel();
        jRadioStatus2 = new javax.swing.JRadioButton();
        jRadioRestore = new javax.swing.JRadioButton();
        jRadioStatus1 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabelBailDate = new javax.swing.JLabel();
        jLabelArrestTambon = new javax.swing.JLabel();
        jLabelArrestAmphur = new javax.swing.JLabel();
        jLabelArrestProvince = new javax.swing.JLabel();
        PlaceArrestTambon = new javax.swing.JTextField();
        PlaceArrestAmphur = new javax.swing.JTextField();
        PlaceArrestProvince = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        NoArrestWarrant = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel44 = new javax.swing.JLabel();

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

        jLabel36.setText("jLabel36");

        jLabel37.setText("jLabel37");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(53, 53, 53)
                .addComponent(jLabel36)
                .addGap(31, 31, 31)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addComponent(jLabel37))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(4, 93, 179));

        jLabel31.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("ข้อมูลผู้ต้องหา");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");

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

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelIssueDateLayout.setVerticalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelExpiredDate.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanelBirthDay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBirthDay.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelBirthDayLayout = new javax.swing.GroupLayout(jPanelBirthDay);
        jPanelBirthDay.setLayout(jPanelBirthDayLayout);
        jPanelBirthDayLayout.setHorizontalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        jPanelBirthDayLayout.setVerticalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel19.setText("เชื้อชาติ");

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("บ้านเลขที่");

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel34.setText("ตำหนิรูปพรรณ");

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel32.setText("เคยต้องโทษ");

        ZipCode.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZipCodeKeyTyped(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");

        StatusSueAndPutInJail.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Tambon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambonActionPerformed(evt);
            }
        });
        Tambon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TambonKeyReleased(evt);
            }
        });

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        Amphur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmphurKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");

        Identification.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

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

        SusConfress.setEditable(true);
        SusConfress.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        SusConfress.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "รับสารภาพ", "ปฏิเสธ", "ภาคเสธ" }));
        SusConfress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SusConfressActionPerformed(evt);
            }
        });

        Province.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("จังหวัด");

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("หมู่ที่");

        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel35.setText("ผู้ต้องหาคนที่");

        OrderPerson.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jComboBoxListName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelArrestEnd.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestEnd.setText("วัน-เวลาที่สิ้นสุดการควบคุมตัว");

        ArrestDateTimeEnd.setEditable(false);
        ArrestDateTimeEnd.setBackground(new java.awt.Color(255, 255, 255));
        ArrestDateTimeEnd.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        ArrestDateTimeEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArrestDateTimeEndActionPerformed(evt);
            }
        });

        BloodGroup.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        BloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "A", "B", "AB", "O", "A Rh-", "B Rh-", "AB Rh-", "O Rh-" }));

        jLabelNameArrest.setText("ผู้จับกุม");

        jLabel40.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel40.setText("วันที่ควบคุมตัว");

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel41.setText("เวลา");

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel38.setText("ที่ทำงาน ตำแหน่ง หน้าที่");

        OccupationPosition.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

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

        jCheckDead.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckDead.setText("ตาย");
        jCheckDead.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckDeadItemStateChanged(evt);
            }
        });

        jButtonInjuryOrDie.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonInjuryOrDie.setText("รายละเอียด");
        jButtonInjuryOrDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInjuryOrDieActionPerformed(evt);
            }
        });

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(TimeSendInjuredOrDie, "HH:mm");
        TimeSendInjuredOrDie.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        TimeSendInjuredOrDie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimeSendInjuredOrDieKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("อายุ");

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });

        BtAddAnswer.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        BtAddAnswer.setText("คำให้การ");
        BtAddAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAddAnswerActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel42.setText("ถนน");

        Road.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel43.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel43.setText("ซอย");

        Soi.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton1.setText("อ่านข้อมูลจากบัตร");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSue.setText("ผัดฟ้องฝากขัง");
        jButtonSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSueActionPerformed(evt);
            }
        });

        jButtonBail.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonBail.setText("ประกัน");
        jButtonBail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OtherName)
                                    .addComponent(jPanelIssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxListName, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(FullNamePersonEn))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jPanelBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Age))
                                    .addComponent(MotherFullName)
                                    .addComponent(Occupation)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Religion))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(18, 18, 18)
                                                .addComponent(Gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PeopleRegistrationID)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtAddAnswer)
                                .addGap(4, 4, 4))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(AnswerPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelArrestEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ArrestDateTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNameArrest)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(NameArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel40))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OrderPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckInjured)
                                .addGap(8, 8, 8)
                                .addComponent(jCheckDead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonInjuryOrDie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(WhereSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(DateSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(CauseSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TimeSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(OccupationPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel32)
                                        .addComponent(jLabel34))
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(StatusSueAndPutInJail, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel33))
                                        .addComponent(Identification, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addGap(46, 46, 46)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(Amphur)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel27)
                                            .addGap(18, 18, 18)
                                            .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)
                                            .addComponent(jLabel24))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Road, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel43)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Soi)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(554, 554, 554)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ZipCode)
                            .addComponent(SusConfress, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tambon)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BtSaveAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBail)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(OrderPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckInjured, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckDead, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonInjuryOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(WhereSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CauseSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimeSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtAddAnswer))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jComboBoxListName, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
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
                                .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jPanelIssueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Road, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Soi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(OccupationPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StatusSueAndPutInJail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SusConfress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Identification, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnswerPerson)
                    .addComponent(jLabelArrestEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ArrestDateTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNameArrest)
                    .addComponent(NameArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtSaveAccused, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PhonePerson.getAccessibleContext().setAccessibleName("");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabelArrestPlace.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestPlace.setText("สถานที่จับกุม");

        PlaceArrest.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PlaceArrest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaceArrestActionPerformed(evt);
            }
        });

        jLabelArrestDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestDate.setText("วันที่จับกุม");

        jLabelRestoreDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelRestoreDate.setText("วันที่ส่งฟื้นฟู");

        jPanelDateArrest.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDateArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelDateArrestLayout = new javax.swing.GroupLayout(jPanelDateArrest);
        jPanelDateArrest.setLayout(jPanelDateArrestLayout);
        jPanelDateArrestLayout.setHorizontalGroup(
            jPanelDateArrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 204, Short.MAX_VALUE)
        );
        jPanelDateArrestLayout.setVerticalGroup(
            jPanelDateArrestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jLabelArrTime.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrTime.setText("เวลา");

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(jSpinnerArrTime, "HH:mm");
        jSpinnerArrTime.setEditor(timeEditor);
        jSpinnerArrTime.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jSpinnerArrTime.setPreferredSize(new java.awt.Dimension(29, 30));

        jPanelRestoreDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRestoreDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelRestoreDateLayout = new javax.swing.GroupLayout(jPanelRestoreDate);
        jPanelRestoreDate.setLayout(jPanelRestoreDateLayout);
        jPanelRestoreDateLayout.setHorizontalGroup(
            jPanelRestoreDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        jPanelRestoreDateLayout.setVerticalGroup(
            jPanelRestoreDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jPanelBailDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBailDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelBailDateLayout = new javax.swing.GroupLayout(jPanelBailDate);
        jPanelBailDate.setLayout(jPanelBailDateLayout);
        jPanelBailDateLayout.setHorizontalGroup(
            jPanelBailDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelBailDateLayout.setVerticalGroup(
            jPanelBailDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jCheckBail.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckBail.setText("ประกันตัว");
        jCheckBail.setToolTipText("");
        jCheckBail.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBailItemStateChanged(evt);
            }
        });
        jCheckBail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("สถานะประกัน");

        jLabelRate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelRate.setText("อัตราโทษจำคุก");

        RatePrison.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        RatePrison.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ไม่เกิน 10 ปี", "ตั้งแต่ 10 ปีขึ้นไป" }));

        CourtSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        CourtSuspect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ศาลแขวง", "ศาลอาญา/ศาลจังหวัด", "ศาลเยาวชนและครอบครัว", "ศาลทหาร", " " }));
        CourtSuspect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CourtSuspectItemStateChanged(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("อำนาจศาล");

        jPanelAttachlDate.setBackground(new java.awt.Color(255, 255, 255));
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

        Attach.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabelFreezeDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelFreezeDate.setText("วันที่อายัดตัว");

        jLabelFreezeOrg.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelFreezeOrg.setText("หน่วยงานที่อายัดตัว");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder("")));
        jPanel8.setFont(new java.awt.Font("TH SarabunPSK", 0, 11)); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(390, 121));

        jRadioOther.setBackground(new java.awt.Color(255, 255, 255));
        jRadioOther.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioOther.setText("อื่นๆ");
        jRadioOther.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioOtherItemStateChanged(evt);
            }
        });
        jRadioOther.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioOtherMouseClicked(evt);
            }
        });

        jRadioFreeze.setBackground(new java.awt.Color(255, 255, 255));
        jRadioFreeze.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioFreeze.setText("อายัดตัว");
        jRadioFreeze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioFreezeMouseClicked(evt);
            }
        });

        jRadioCantCatch.setBackground(new java.awt.Color(255, 255, 255));
        jRadioCantCatch.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioCantCatch.setText("หลบหนี");
        jRadioCantCatch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioCantCatchItemStateChanged(evt);
            }
        });
        jRadioCantCatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioCantCatchMouseClicked(evt);
            }
        });

        jRadioWithdrawComplaint.setBackground(new java.awt.Color(255, 255, 255));
        jRadioWithdrawComplaint.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioWithdrawComplaint.setText("ถอนคำร้องทุกข์");
        jRadioWithdrawComplaint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioWithdrawComplaintMouseClicked(evt);
            }
        });
        jRadioWithdrawComplaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioWithdrawComplaintActionPerformed(evt);
            }
        });

        jRadioSue.setBackground(new java.awt.Color(255, 255, 255));
        jRadioSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioSue.setText("ฟ้องวาจา");
        jRadioSue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioSueMouseClicked(evt);
            }
        });

        jRadioRelease.setBackground(new java.awt.Color(255, 255, 255));
        jRadioRelease.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioRelease.setText("แจ้งข้อหาปล่อยตัว");
        jRadioRelease.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioReleaseItemStateChanged(evt);
            }
        });
        jRadioRelease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioReleaseMouseClicked(evt);
            }
        });
        jRadioRelease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioReleaseActionPerformed(evt);
            }
        });

        StatusSuspectOther.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabelStatusSuspect.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelStatusSuspect.setText("อื่นๆ");

        jRadioStatus2.setBackground(new java.awt.Color(255, 255, 255));
        jRadioStatus2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioStatus2.setText("ผัดฟ้อง");
        jRadioStatus2.setOpaque(false);
        jRadioStatus2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioStatus2ItemStateChanged(evt);
            }
        });
        jRadioStatus2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioStatus2MouseClicked(evt);
            }
        });

        jRadioRestore.setBackground(new java.awt.Color(255, 255, 255));
        jRadioRestore.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioRestore.setText("ส่งฟื้นฟู");
        jRadioRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioRestoreMouseClicked(evt);
            }
        });

        jRadioStatus1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioStatus1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioStatus1.setText("ผัดฟ้องฝากขัง");
        jRadioStatus1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioStatus1ItemStateChanged(evt);
            }
        });
        jRadioStatus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioStatus1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioRelease, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioCantCatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jRadioWithdrawComplaint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioFreeze, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jRadioStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioSue, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jRadioStatus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabelStatusSuspect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StatusSuspectOther)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jRadioSue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioCantCatch)
                    .addComponent(jRadioWithdrawComplaint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioRelease)
                    .addComponent(jRadioOther)
                    .addComponent(jRadioFreeze))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioStatus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioRestore)
                    .addComponent(jRadioStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatusSuspect, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(StatusSuspectOther, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
                .addGap(157, 157, 157)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jLabelBailDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelBailDate.setText("วันประกัน");

        jLabelArrestTambon.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestTambon.setText("ตำบล");

        jLabelArrestAmphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestAmphur.setText("อำเภอ");

        jLabelArrestProvince.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabelArrestProvince.setText("จังหวัด");

        PlaceArrestTambon.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PlaceArrestTambon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PlaceArrestTambonKeyReleased(evt);
            }
        });

        PlaceArrestAmphur.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        PlaceArrestAmphur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PlaceArrestAmphurKeyReleased(evt);
            }
        });

        PlaceArrestProvince.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel39.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel39.setText("เลขที่คำร้องขอหมายจับ");

        NoArrestWarrant.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jRadioButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioButton1.setText("รอคำสั่งศาล");

        jRadioButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioButton2.setText("ยกเลิก");

        jRadioButton3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioButton3.setText("รออนุมัติ");

        jRadioButton4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioButton4.setText("ยกคำร้อง");

        jRadioButton5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRadioButton5.setText("ถอนประกาศสืบจับ");

        jLabel44.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel44.setText("สถานะหมายจับ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CourtSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabelFreezeOrg)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Attach))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabelFreezeDate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(jPanelAttachlDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabelArrestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelDateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel39)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(NoArrestWarrant, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabelArrestTambon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(PlaceArrestTambon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelArrestAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(PlaceArrestAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelArrestProvince, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PlaceArrestProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jCheckBail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabelBailDate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanelBailDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelArrestPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(RatePrison, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PlaceArrest))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton5))
                    .addComponent(jLabel44))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(CourtSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBail)
                        .addComponent(jLabelBailDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelBailDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(NoArrestWarrant, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRate)
                    .addComponent(RatePrison, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelArrestPlace)
                    .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelArrestTambon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PlaceArrestTambon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelArrestAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PlaceArrestAmphur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelArrestProvince)
                        .addComponent(PlaceArrestProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelArrestDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDateArrest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinnerArrTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRestoreDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Attach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFreezeOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelFreezeDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAttachlDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtSaveAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveAccusedActionPerformed
        // TODO add your handling code here:
        con=ConnectDatabase.connect();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String arrestTime = format.format(jSpinnerArrTime.getValue());
        String sendTime=format.format(TimeSendInjuredOrDie.getValue());
        
        String arrestDate=Checknull(ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime);
        String arrestDateEnd48=  CalculateDateTime48(arrestDate);
        ArrestDateTimeEnd.setText(CalculateDateTime48(arrestDate));
        if(isInsert){
            String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
            "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
            "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,StatusSuspect,"
            + "caseIdPerson,ArrestDateTime,PlaceArrest,CourtSuspect,BailDate,ArrestDateTimeEnd,StatusBail,RatePrison,Identification,"
                    + "OrderPerson,SusConfress,StatusSueAndPutInJail,NoArrestWarrant,AnswerPerson,PlaceArrestTambon,PlaceArrestAmphur,PlaceArrestProvince,"
                    + "OccupationPosition,CauseSendInjuredOrDie,WhereSendInjuredOrDie,DateSendInjuredOrDie,TimeSendInjuredOrDie,StatusInjuryOrDie,Road,Soi,StatusWarrant,Noperson)\n"
            + " VALUES (?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

                if(jRadioStatus1.isSelected()){
                    pst.setString(28,jRadioStatus1.getText());
                }
                         
                else if(jRadioStatus2.isSelected()){
                    pst.setString(28,jRadioStatus2.getText());
                }
                else if(jRadioCantCatch.isSelected()){
                    pst.setString(28,"หลบหนี");
                }

                else if(jRadioSue.isSelected()){
                    pst.setString(28,"ฟ้องวาจา");
                }
                else if(jRadioRestore.isSelected()){
                    pst.setString(28,"ส่งฟื้นฟู");
                }
                else if(jRadioFreeze.isSelected()){
                    pst.setString(28,"อายัด");
                }
                else if(jRadioWithdrawComplaint.isSelected()){
                    pst.setString(28,"ถอนคำร้องทุกข์");
                }
                else if(jRadioOther.isSelected()){
                    pst.setString(28,StatusSuspectOther.getText());
                }
                 else if(jRadioRelease.isSelected()){
                    pst.setString(28,jRadioRelease.getText());
                }
                pst.setString(29,jLabel36.getText());
                //                pst.setString(30,BailDate.getText());
                if(ArrestDateTime.getJFormattedTextField().getText().equals("")){
                    arrestTime="";
                }
                pst.setString(30,ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime);
                pst.setString(31,PlaceArrest.getText());
                pst.setString(32,CourtSuspect.getSelectedItem().toString());
                pst.setString(33,BailDate.getJFormattedTextField().getText());
                if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา/ศาลจังหวัด") && jCheckBail.isSelected()){
                    pst.setString(34,"");
                }
                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา/ศาลจังหวัด") && jRadioStatus1.isSelected()){
                    pst.setString(34,arrestDateEnd48);
                }
//                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jRadioSue.isSelected()){
//                    pst.setString(34,"");
//                }
                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลเยาวชนและครอบครัว")){
                    pst.setString(34,CalculateDateTime24(arrestDate));
                }
                else{
                    pst.setString(34,arrestDateEnd48);
                
                }
                //                pst.setString(34,ArrestDateTimeEnd.getText());
                if(jCheckBail.isSelected()){
                    pst.setString(35,"ประกัน");}
                else{pst.setString(35,"");}
                pst.setString(36,RatePrison.getSelectedItem().toString());
                pst.setString(37,Identification.getText());
                pst.setString(38,OrderPerson.getText());
                pst.setString(39,SusConfress.getSelectedItem().toString());
                pst.setString(40,StatusSueAndPutInJail.getText());
                pst.setString(41,NoArrestWarrant.getText());
               pst.setString(42,AnswerPerson.getText());
                pst.setString(43,PlaceArrestTambon.getText());
                pst.setString(44,PlaceArrestAmphur.getText());
                pst.setString(45,PlaceArrestProvince.getText());
                pst.setString(46,OccupationPosition.getText());
                    pst.setString(47,CauseSendInjuredOrDie.getText());
                              pst.setString(48,WhereSendInjuredOrDie.getText());
                              pst.setString(49,DateSendInjuredOrDie.getText());
                              pst.setString(50,sendTime);
                              if(jCheckInjured.isSelected()){
                               pst.setString(51,jCheckInjured.getText());
                              }
                              else if(jCheckDead.isSelected()){
                              pst.setString(51,jCheckDead.getText());
                              }
                 pst.setString(52,Road.getText());
                 pst.setString(53,Soi.getText());
                 if(jRadioButton1.isSelected()){
                     pst.setString(54,jRadioButton1.getText());
                        }
                  else if(jRadioButton2.isSelected()){
                      pst.setString(54,jRadioButton2.getText());
                         }
                  else if(jRadioButton3.isSelected()){
                      pst.setString(54,jRadioButton3.getText());
                         }
                  else if(jRadioButton4.isSelected()){
                      pst.setString(54,jRadioButton4.getText());
                         }
                  else if(jRadioButton5.isSelected()){
                      pst.setString(54,jRadioButton5.getText());
                         }
                 pst.setString(55,idPerson());
                int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    pst.close();
                    InsertPerson();
                    CheckBail(IdPersonLast());
//                    System.out.println("SQL : "+sql);
//                    setVisible(false);
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
            + "RatePrison=?,"
            + "SusConfress=?," 
           + "PlaceArrest=?," 
            +"StatusSueAndPutInJail=?,"
            +"Identification=?,"
             +"NoArrestWarrant=?,"
             +"AnswerPerson=?,"
             +"PlaceArrestTambon=?,"
             +"PlaceArrestAmphur=?,"
             +"PlaceArrestProvince=?,"
             +"OccupationPosition=?,"
             +"CauseSendInjuredOrDie=?,WhereSendInjuredOrDie=?,DateSendInjuredOrDie=?,TimeSendInjuredOrDie=?,StatusInjuryOrDie=?,"       
            + "OrderPerson=?,Road=?,Soi=?,StatusWarrant=? "
            + "where NoPerson=? and TypePerson=?   ";

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
                pst.setString(25,"ผู้ต้องหา");
                pst.setString(26,Weight.getText());
                pst.setString(27,ZipCode.getText());
                pst.setString(28,jLabel36.getText());
                pst.setString(29,CourtSuspect.getSelectedItem().toString());
                pst.setString(30,ArrestDateTime.getJFormattedTextField().getText()+" "+arrestTime);
                pst.setString(31,BailDate.getJFormattedTextField().getText());
                if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jCheckBail.isSelected()){
                    pst.setString(32,"");
                }
                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jRadioStatus1.isSelected()){
                    pst.setString(32,"");
                }
                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลอาญา") && jRadioSue.isSelected()){
                    pst.setString(32,"");
                }
                else if(CourtSuspect.getSelectedItem().toString().equals("ศาลเยาวชนและครอบครัว")){
                    pst.setString(32,CalculateDateTime24(arrestDate));
                }
                else{
                    pst.setString(32,arrestDateEnd48);}

               if(jRadioStatus1.isSelected()){
                    pst.setString(33,jRadioStatus1.getText());
                }
                         
                else if(jRadioStatus2.isSelected()){
                    pst.setString(33,jRadioStatus2.getText());
                }
                else if(jRadioCantCatch.isSelected()){
                    pst.setString(33,"หลบหนี");
                }

                else if(jRadioSue.isSelected()){
                    pst.setString(33,"ฟ้องวาจา");
                }
                else if(jRadioRestore.isSelected()){
                    pst.setString(33,"ส่งฟื้นฟู");
                }
                else if(jRadioFreeze.isSelected()){
                    pst.setString(33,"อายัดตัว");
                }
                else if(jRadioOther.isSelected()){
                    pst.setString(33,StatusSuspectOther.getText());
                }
                else if(jRadioWithdrawComplaint.isSelected()){
                    pst.setString(33,"ถอนคำร้องทุกข์");
                }
               else if(jRadioRelease.isSelected()){
                    pst.setString(33,jRadioRelease.getText());
                }
                if(jCheckBail.isSelected()){
                    pst.setString(34,"ประกัน");}
                else{pst.setString(34,"");}

                pst.setString(35,RatePrison.getSelectedItem().toString());
                pst.setString(36,SusConfress.getSelectedItem().toString());
                pst.setString(37,PlaceArrest.getText());
                pst.setString(38,StatusSueAndPutInJail.getText());
                pst.setString(39,Identification.getText());
                pst.setString(40,NoArrestWarrant.getText()); 
                pst.setString(41,AnswerPerson.getText()); 
                pst.setString(42,PlaceArrestTambon.getText()); 
                pst.setString(43,PlaceArrestAmphur.getText()); 
                pst.setString(44,PlaceArrestProvince.getText()); 
                pst.setString(45,OccupationPosition.getText()); 
               pst.setString(46,CauseSendInjuredOrDie.getText());
                              pst.setString(47,WhereSendInjuredOrDie.getText());
                              pst.setString(48,DateSendInjuredOrDie.getText());
                              pst.setString(49,sendTime);
                              if(jCheckInjured.isSelected()){
                               pst.setString(50,jCheckInjured.getText());
                              }
                              else if(jCheckDead.isSelected()){
                              pst.setString(50,jCheckDead.getText());
                              }
                pst.setString(51,OrderPerson.getText());
                pst.setString(52,Road.getText());
                pst.setString(53,Soi.getText());
                 if(jRadioButton1.isSelected()){
                     pst.setString(54,jRadioButton1.getText());
                        }
                  else if(jRadioButton2.isSelected()){
                      pst.setString(54,jRadioButton2.getText());
                         }
                  else if(jRadioButton3.isSelected()){
                      pst.setString(54,jRadioButton3.getText());
                         }
                  else if(jRadioButton4.isSelected()){
                      pst.setString(54,jRadioButton4.getText());
                         }
                  else if(jRadioButton5.isSelected()){
                      pst.setString(54,jRadioButton5.getText());
                         }
                pst.setString(55,noPerson);

                pst.setString(56,"ผู้ต้องหา");

                int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    pst.close();
                    CheckBail(noPerson);

                    System.out.println("SQL : "+sqlUpdate);
//                    setVisible(false);ใใใใใใใใใใใ
                }

                //                System.out.println("SQL : "+sqlUpdate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }

        }
//        if(FullNamePerson.getText().equals(""))
//        {
//         JOptionPane.showMessageDialog(jPanel1, "กรุณากรอกชื่อ","แจ้งเตือน", JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_BtSaveAccusedActionPerformed
  private class ComboBoxActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        try{
            FullNamePerson.setText(jComboBoxListName.getSelectedItem().toString());
            jComboBoxListName.removeAllItems();
            jComboBoxListName.hidePopup();
            jPanel4.remove(jComboBoxListName);
        }
        catch(Exception any){
        
        }
        }
  
  }
    private class TextFieldSusListener implements  CaretListener{
   public void caretUpdate(CaretEvent e){
    
       try{
        jComboBoxListName.removeAllItems();
        jComboBoxListName.hidePopup();
        jPanel4.remove(jComboBoxListName);
        
        if(e.getMark()>0){
            
        for(String string:personname){
           if(string.toLowerCase().startsWith(FullNamePerson.getText().toLowerCase())){
             jPanel4.add(jComboBoxListName);
             jComboBoxListName.addItem(string);
             jComboBoxListName.showPopup();
               }
	    }
         }
     
       }
       catch(Exception e1){
       }
       if(e.getMark()<2){
       jPanel4.remove(jComboBoxListName);
       
       }
      
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
                  PeopleRegistrationID.setText(Checknull(rs.getString("PeopleRegistrationID"))); 
                IssueDate.getJFormattedTextField().setText(Checknull(rs.getString("PassportNumber")));                 
                Age.setText(Checknull(rs.getString("Age"))); 
                Amphur.setText(Checknull(rs.getString("Amphur"))); 
                BloodGroup.setSelectedItem(Checknull(rs.getString("BloodGroup"))); 
                BirthDay.getJFormattedTextField().setText(Checknull(rs.getString("BirthDay"))); 
                FatherFullName.setText(Checknull(rs.getString("FatherFullName"))); 
                FullNamePersonEn.setText(Checknull(rs.getString("FullNamePersonEn"))); 
                Height.setText(Checknull(rs.getString("Height"))); 
                Weight.setText(Checknull(rs.getString("Weight"))); 
                Race.setText(Checknull(rs.getString("Race"))); 
                Religion.setText(Checknull(rs.getString("Religion"))); 
                Nationality.setText(Checknull(rs.getString("Nationality"))); 
                MotherFullName.setText(Checknull(rs.getString("MotherFullName"))); 
                Gender.setSelectedItem(Checknull(rs.getString("Gender")));
                Occupation.setText(Checknull(rs.getString("Occupation")));
                PhonePerson.setText(Checknull(rs.getString("PhonePerson"))); 
                MotherFullName.setText(Checknull(rs.getString("MotherFullName"))); 
                PassportNumber.setText(Checknull(rs.getString("PassportNumber"))); 
               ExpiredDate.getJFormattedTextField().setText(Checknull(rs.getString("ExpiredDate"))+"");
            HouseNumber.setText(Checknull(rs.getString("HouseNumber"))+"");
            Moo.setText(Checknull(rs.getString("Moo"))+"");
            Province.setText(Checknull(rs.getString("Province")));
            Tambon.setText(Checknull(rs.getString("Tambon"))+"");
             ZipCode.setText(Checknull(rs.getString("ZipCode"))+"");
            OtherName.setText(Checknull(rs.getString("OtherName"))+"");
            Road.setText(Checknull(rs.getString("Road"))+"");
            Soi.setText(Checknull(rs.getString("Soi"))+"");
//
//   
            }
       }catch(Exception ex){}
    
    
    }
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

    private void jRadioWithdrawComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioWithdrawComplaintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioWithdrawComplaintActionPerformed

    private void jCheckBailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBailActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jCheckBailActionPerformed

    private void jCheckBailItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBailItemStateChanged
        // TODO add your handling code here:
  
        String court =CourtSuspect.getSelectedItem().toString();
        if(court.equals("ศาลแขวง")&&jCheckBail.isSelected()){
            jRadioStatus1.setEnabled(false);
            jRadioCantCatch.setEnabled(false);
        }
        else{
                    jRadioStatus1.setEnabled(true);
                     jRadioCantCatch.setEnabled(true);

        }
    }//GEN-LAST:event_jCheckBailItemStateChanged

    private void jRadioCantCatchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioCantCatchItemStateChanged
        // TODO add your handling code here:
        if(jRadioCantCatch.isSelected()){
        jCheckBail.setSelected(false);
        jCheckBail.setEnabled(false);
        }
        else{
         jCheckBail.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioCantCatchItemStateChanged

    private void CourtSuspectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CourtSuspectItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CourtSuspectItemStateChanged

    private void ArrestDateTimeEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArrestDateTimeEndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ArrestDateTimeEndActionPerformed

    private void jRadioStatus1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioStatus1ItemStateChanged
        // TODO add your handling code here:
        String a=jRadioStatus1.getText().toString();
        if(jRadioStatus1.isSelected()&&CourtSuspect.getSelectedItem().equals("ศาลแขวง")||CourtSuspect.getSelectedItem().equals("ศาลทหาร")||CourtSuspect.getSelectedItem().equals("ศาลเยาวชนและครอบครัว")){
          PlaceArrest.setVisible(true);
          jLabelArrestPlace.setVisible(true);
          jPanelDateArrest.setVisible(true);
          jLabelArrestDate.setVisible(true);
          jLabelArrTime.setVisible(true);
          jSpinnerArrTime.setVisible(true);
          jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);

                 
        
        }
        else if(jRadioStatus1.isSelected()&&CourtSuspect.getSelectedItem().equals("ศาลอาญา/ศาลจังหวัด") ){
             PlaceArrest.setVisible(true);
          jLabelArrestPlace.setVisible(true);
          jPanelDateArrest.setVisible(true);
          jLabelArrestDate.setVisible(true);
          jLabelArrTime.setVisible(true);
          jSpinnerArrTime.setVisible(true);
          jLabelRate.setVisible(true);
          RatePrison.setVisible(true);
            jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);
          
        
        }
        else{
        
              PlaceArrest.setVisible(false);
          jLabelArrestPlace.setVisible(false);
            jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
          jPanelDateArrest.setVisible(false);
          jLabelArrestDate.setVisible(false);
          jLabelArrTime.setVisible(false);
          jSpinnerArrTime.setVisible(false);
          jLabelRate.setVisible(false);
          RatePrison.setVisible(false);

        
        }
    }//GEN-LAST:event_jRadioStatus1ItemStateChanged

    private void PlaceArrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceArrestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlaceArrestActionPerformed

    private void jRadioStatus2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioStatus2ItemStateChanged
        // TODO add your handling code here:
              if(jRadioStatus2.isSelected()&&CourtSuspect.getSelectedItem().equals("ศาลแขวง") ||CourtSuspect.getSelectedItem().equals("ศาลทหาร")||CourtSuspect.getSelectedItem().equals("ศาลเยาวชนและครอบครัว")){
          PlaceArrest.setVisible(true);
          jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);
          jLabelArrestPlace.setVisible(true);
          jPanelDateArrest.setVisible(true);
          jLabelArrestDate.setVisible(true);
          jLabelArrTime.setVisible(true);
          jSpinnerArrTime.setVisible(true);
                 
        
        }
        else if(jRadioStatus2.isSelected()&&CourtSuspect.getSelectedItem().equals("ศาลอาญา/ศาลจังหวัด") ){
             PlaceArrest.setVisible(true);
          jLabelArrestPlace.setVisible(true);
             jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);
          jPanelDateArrest.setVisible(true);
          jLabelArrestDate.setVisible(true);
          jLabelArrTime.setVisible(true);
          jSpinnerArrTime.setVisible(true);

        }
        else{
        
              PlaceArrest.setVisible(false);
          jLabelArrestPlace.setVisible(false);
             jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
          jPanelDateArrest.setVisible(false);
          jLabelArrestDate.setVisible(false);
          jLabelArrTime.setVisible(false);
          jSpinnerArrTime.setVisible(false);
 
        
        }
    }//GEN-LAST:event_jRadioStatus2ItemStateChanged

    private void SusConfressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SusConfressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SusConfressActionPerformed

    private void jRadioStatus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioStatus1MouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
            if (jRadioStatus1.isSelected()) {

        if (++clickCount % 2 == 0) {

            g.clearSelection();
        }
    }
    }//GEN-LAST:event_jRadioStatus1MouseClicked

    private void jRadioStatus2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioStatus2MouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
        if (jRadioStatus2.isSelected()) {

        if (++clickCount % 2 == 0) {

            g.clearSelection();
        }
    }
    }//GEN-LAST:event_jRadioStatus2MouseClicked

    private void jRadioSueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioSueMouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
        if (jRadioSue.isSelected()) {

        if (++clickCount % 2 == 0) {

            g.clearSelection();
        }
    }
    }//GEN-LAST:event_jRadioSueMouseClicked

    private void jRadioCantCatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioCantCatchMouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
        if (jRadioCantCatch.isSelected()) {

        if (++clickCount % 2 == 0) {

            g.clearSelection();
        }
    }
    }//GEN-LAST:event_jRadioCantCatchMouseClicked

    private void jRadioWithdrawComplaintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioWithdrawComplaintMouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
        if (jRadioWithdrawComplaint.isSelected()) {

        if (++clickCount % 2 == 0) {

            jRadioWithdrawComplaint.setSelected(false);
        }
    }
    }//GEN-LAST:event_jRadioWithdrawComplaintMouseClicked

    private void jRadioRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioRestoreMouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
         if (jRadioRestore.isSelected()) {

        if (++clickCount % 2 == 0) {

            g.clearSelection();
        }
    }
    }//GEN-LAST:event_jRadioRestoreMouseClicked

    private void jRadioFreezeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioFreezeMouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
        if (jRadioFreeze.isSelected()) {

        if (++clickCount % 2 == 0) {

            g.clearSelection();
        }
    }
    }//GEN-LAST:event_jRadioFreezeMouseClicked

    private void jRadioOtherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioOtherMouseClicked
        // TODO add your handling code here:
         int clickCount = 0;
         if (jRadioOther.isSelected()) {

        if (++clickCount % 2 == 0) {

            g.clearSelection();
        }
    }
    }//GEN-LAST:event_jRadioOtherMouseClicked

    private void jRadioReleaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioReleaseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioReleaseMouseClicked

    private void jRadioReleaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioReleaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioReleaseActionPerformed

    private void BtAddAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAddAnswerActionPerformed
        // TODO add your handling code here:
          JSONObject type=new JSONObject();
        type.put("TypeCase", typecase);
        type.put("TypePerson", "ผู้ต้องหา");
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
    AnswerPersonForm rf =new AnswerPersonForm(in,type);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_BtAddAnswerActionPerformed

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
        type.put("TypeCase", typecase);
        type.put("TypePerson", "ผู้ต้องหา");
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

    private void jRadioOtherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioOtherItemStateChanged
        // TODO add your handling code here:
         
        if(jRadioOther.isSelected()){
          StatusSuspectOther.setVisible(true);
          jLabelStatusSuspect.setVisible(true);
          PlaceArrest.setVisible(true);
          jLabelArrestPlace.setVisible(true);
          jPanelDateArrest.setVisible(true);
          jLabelArrestDate.setVisible(true);
          jLabelArrTime.setVisible(true);
          jSpinnerArrTime.setVisible(true);
          jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);

                 
        
        }
   
        else{
        StatusSuspectOther.setVisible(false);
          jLabelStatusSuspect.setVisible(false);
              PlaceArrest.setVisible(false);
          jLabelArrestPlace.setVisible(false);
            jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
          jPanelDateArrest.setVisible(false);
          jLabelArrestDate.setVisible(false);
          jLabelArrTime.setVisible(false);
          jSpinnerArrTime.setVisible(false);
          jLabelRate.setVisible(false);
          RatePrison.setVisible(false);

        
        }
    }//GEN-LAST:event_jRadioOtherItemStateChanged

    private void jRadioReleaseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioReleaseItemStateChanged
        // TODO add your handling code here:
         if(jRadioRelease.isSelected()){
        
          PlaceArrest.setVisible(true);
          jLabelArrestPlace.setVisible(true);
          jPanelDateArrest.setVisible(true);
          jLabelArrestDate.setVisible(true);
          jLabelArrTime.setVisible(true);
          jSpinnerArrTime.setVisible(true);
          jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);

                 
        
        }
   
        else{
       
              PlaceArrest.setVisible(false);
          jLabelArrestPlace.setVisible(false);
            jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
          jPanelDateArrest.setVisible(false);
          jLabelArrestDate.setVisible(false);
          jLabelArrTime.setVisible(false);
          jSpinnerArrTime.setVisible(false);
          jLabelRate.setVisible(false);
          RatePrison.setVisible(false);

        
        }
    }//GEN-LAST:event_jRadioReleaseItemStateChanged

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

    private void PlaceArrestTambonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlaceArrestTambonKeyReleased
        // TODO add your handling code here:
           String provinceid="";
         String loTam="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {
            Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.NAMETAMBON='"+PlaceArrestTambon.getText()+"'";
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
         PlaceArrestAmphur.setText(amp);
	
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
      PlaceArrestProvince.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
        }
    }//GEN-LAST:event_PlaceArrestTambonKeyReleased

    private void PlaceArrestAmphurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlaceArrestAmphurKeyReleased
        // TODO add your handling code here:
           String provinceid="";
         String loPro="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {

	Statement st = con2.createStatement();
        String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
                            "from Amphur\n" +
                            "where Amphur.NameAmphur = '"+PlaceArrestAmphur.getText()+"';";
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
      PlaceArrestProvince.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
}
    }//GEN-LAST:event_PlaceArrestAmphurKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     try {
			
			if(true) {
				ReadThaiCardService read = new ReadThaiCardService();
				read.check_read();
				read.read(0);
                               int st=read.getDataThaiCard().getStatus();
                                if(st==1){
                                    JOptionPane.showMessageDialog(null, "กรุณาเสียบบัตร");
                                }
                                else if(st==2){
                                    JOptionPane.showMessageDialog(null, "กรุณาเสียบบัตร");
                                }
                                else if(st==4){
                                String str=read.getDataThaiCard().getThaiCardDetail().getThname(); 
                                String[] name=str.split("##",2);
                                String firstname=(name[0]+"").replace("#", "");
                                String n=firstname+" "+name[1];
                                String stren=read.getDataThaiCard().getThaiCardDetail().getEnname(); 
                                String[] nameen=stren.split("##",2);
                                String firstnameen=(nameen[0]+"").replace("#", "");
                                String nen=firstnameen+" "+nameen[1];
//                                String name2=name.replace("##", " ");
                                PeopleRegistrationID.setText(read.getDataThaiCard().getThaiCardDetail().getPid());
                                FullNamePerson.setText(n);
                                IssueDate.getJFormattedTextField().setText(DateCard(read.getDataThaiCard().getThaiCardDetail().getIssuedate()));
                                  ExpiredDate.getJFormattedTextField().setText(DateCard(read.getDataThaiCard().getThaiCardDetail().getExpiredate()));
                                BirthDay.getJFormattedTextField().setText(DateCard(read.getDataThaiCard().getThaiCardDetail().getBirthdate()));
                                HouseNumber.setText(read.getDataThaiCard().getThaiCardDetail().getAddrHS());
                                Moo.setText(read.getDataThaiCard().getThaiCardDetail().getAddrMoo().replace("หมู่ที่ ", ""));
                                FullNamePersonEn.setText(nen);
//                                Road.setText(read.getDataThaiCard().getThaiCardDetail().getAdd);
                                Soi.setText(read.getDataThaiCard().getThaiCardDetail().getAddrSoi());
                                Tambon.setText(read.getDataThaiCard().getThaiCardDetail().getAddrTmb().replace("ตำบล",""));
                                Amphur.setText(read.getDataThaiCard().getThaiCardDetail().getAddrAmp().replace("อำเภอ",""));
                                Province.setText(read.getDataThaiCard().getThaiCardDetail().getAddrPrv().replace("จังหวัด",""));
                                Gender.setSelectedItem(ChangeGender(read.getDataThaiCard().getThaiCardDetail().getGender()));
				System.out.println(read.getDataThaiCard().getStatusMsg());
                                System.out.println(ChangeGender(read.getDataThaiCard().getThaiCardDetail().getGender()));
                                System.out.println(read.getDataThaiCard().getThaiCardDetail().getAddrTrk());
                                System.out.println(read.getDataThaiCard().getThaiCardDetail().getEnname());

                                System.out.println(read.getDataThaiCard().getThaiCardDetail().getAddrStr());
             
                                System.out.println(read.getDataThaiCard().getThaiCardDetail().getThname().toString()+"hhh");
                                }

//				Thread.sleep(5000);
			}
//                        else{
//                            System.out.println("ErrorCard:");
//                        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TambonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambonActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_TambonActionPerformed

    private void jButtonSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSueActionPerformed
   // TODO add your handling code here:
       JSONObject js =new JSONObject();
           js.put("caseIdPerson",jLabel36.getText() );
        js.put("NoPerson",jLabel37.getText() );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        SueCrimesFrom su=new SueCrimesFrom(fr,js);
        su.pack();
        su.setLocationRelativeTo(null);
        su.setVisible(true);
    }//GEN-LAST:event_jButtonSueActionPerformed

    private void jButtonBailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBailActionPerformed
        // TODO add your handling code here:
        JSONObject js =new JSONObject();
           js.put("CaseId",jLabel36.getText() );
        js.put("NoPerson",jLabel37.getText() );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        BailCrimesAdd baa=new BailCrimesAdd(fr,js);
        baa.pack();
        baa.setLocationRelativeTo(null);
        baa.setVisible(true);

    }//GEN-LAST:event_jButtonBailActionPerformed

   
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
                 PlaceArrest.setVisible(true);
             jLabelArrestPlace.setVisible(true);
              jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);
         jLabelFreezeOrg.setVisible(true);
         Attach.setVisible(true);
         jLabelFreezeDate.setVisible(true);
         jPanelAttachlDate.setVisible(true);
            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
                 PlaceArrest.setVisible(false);
             jLabelArrestPlace.setVisible(false);
              jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
            jPanelDateArrest.setVisible(false);
            jLabelArrestDate.setVisible(false);
            jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
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
                  jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);
          
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);
             
            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
                 PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
                   jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
                jPanelDateArrest.setVisible(false);
                jLabelArrestDate.setVisible(false);
              jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
    
            // do something else when the button is deselected
 
        }
    }
});
        jRadioRestore.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
                PlaceArrest.setVisible(true);
                  jLabelArrestPlace.setVisible(true);
                  jLabelArrestTambon.setVisible(true);
          PlaceArrestTambon.setVisible(true);
          jLabelArrestAmphur.setVisible(true);
          PlaceArrestAmphur.setVisible(true);
          jLabelArrestProvince.setVisible(true);
          PlaceArrestProvince.setVisible(true);
            jPanelDateArrest.setVisible(true);
            jLabelArrestDate.setVisible(true);
            jLabelArrTime.setVisible(true);
            jSpinnerArrTime.setVisible(true);
                    jLabelRestoreDate.setVisible(true);
                  jPanelRestoreDate.setVisible(true);     
            // do something when the button is selected
 
        } else if (state == ItemEvent.DESELECTED) {
               PlaceArrest.setVisible(false);
                  jLabelArrestPlace.setVisible(false);
                  jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
                jPanelDateArrest.setVisible(false);
                jLabelArrestDate.setVisible(false);
              jLabelArrTime.setVisible(false);
            jSpinnerArrTime.setVisible(false);
                 jLabelRestoreDate.setVisible(false);
                  jPanelRestoreDate.setVisible(false);
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
    jLabelArrestTambon.setVisible(false);
          PlaceArrestTambon.setVisible(false);
          jLabelArrestAmphur.setVisible(false);
          PlaceArrestAmphur.setVisible(false);
          jLabelArrestProvince.setVisible(false);
          PlaceArrestProvince.setVisible(false);
    jPanelRestoreDate.setVisible(false);

//     
//            jPanelBailDate.setVisible(false);   
            jLabelArrestEnd.setVisible(false);
            ArrestDateTimeEnd.setVisible(false);
            jLabelRate.setVisible(false);
          
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
      SuspectForm aa=  new SuspectForm(null,null,null);
     
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
   public static String IdPersonLast(){
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
     private void showbutton(){
       con=ConnectDatabase.connect();
       try{Statement st = con.createStatement();
           String sqlSue="Select StatusBail,StatusSuspect from person where Noperson=";
           ResultSet rc = st.executeQuery(sqlSue);
           if(rc.next()){
               String sue=rc.getString("StatusSuspect"),bail=rc.getString("StatusSuspect");
//                if(rc.)
           
           }
           
       }
       catch(Exception a){
           System.out.println("err:"+a);
       }
     
     
     }
    public static String Checknull(String input){
					if(input==null||input==""||input=="null") { return ""; }
					return input;
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
                        "PhonePerson,Province,Race,Religion,Tambon,Weight,ZipCode,Road,Soi)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
                              pst2.setString(27,Road.getText());
                              pst2.setString(28,Soi.getText());
                             
                     
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
public static String Checknull(Object input){
					if(input==null||input==""||input=="null") { return ""; }
					return input+"";
}
  public static String idPerson(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(NoPerson) NoPerson from Person";
          int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("NoPerson"); 
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
 public void CheckBail(String idper){
       con=ConnectDatabase.connect();
      try {
              Statement st = con.createStatement();
          String sel="Select StatusSuspect,StatusBail from Person where Noperson='"+idper+"'";
          System.out.println("ssssssss"+sel);
           ResultSet rc = st.executeQuery(sel);
        if(rc.next()){
        if(rc.getString("StatusBail").equals("ประกัน")){
        jButtonBail.setVisible(true);
        }
        else{
          jButtonBail.setVisible(false);
        }
        if(rc.getString("StatusSuspect").equals("ผัดฟ้อง")||rc.getString("StatusSuspect").equals("ฝากขัง")||rc.getString("StatusSuspect").equals("ผัดฟ้องฝากขัง"))
        { jButtonSue.setVisible(true);
        }
        else{
          jButtonSue.setVisible(false);
        }
      }
    
      } catch (Exception e) {
      }
  
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    public static javax.swing.JTextField AnswerPerson;
    private javax.swing.JTextField ArrestDateTimeEnd;
    private javax.swing.JTextField Attach;
    private javax.swing.JComboBox<String> BloodGroup;
    private javax.swing.JButton BtAddAnswer;
    private javax.swing.JButton BtSaveAccused;
    public static javax.swing.JTextField CauseSendInjuredOrDie;
    private javax.swing.JComboBox<String> CourtSuspect;
    public static javax.swing.JTextField DateSendInjuredOrDie;
    private javax.swing.JTextField FatherFullName;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField FullNamePersonEn;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField HouseNumber;
    private javax.swing.JTextField Identification;
    private javax.swing.JTextField Moo;
    private javax.swing.JTextField MotherFullName;
    private javax.swing.JTextField NameArrest;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField NoArrestWarrant;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField OccupationPosition;
    private javax.swing.JTextField OrderPerson;
    private javax.swing.JTextField OtherName;
    private javax.swing.JTextField PassportNumber;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PhonePerson;
    private javax.swing.JTextField PlaceArrest;
    private javax.swing.JTextField PlaceArrestAmphur;
    private javax.swing.JTextField PlaceArrestProvince;
    private javax.swing.JTextField PlaceArrestTambon;
    private javax.swing.JTextField Province;
    private javax.swing.JTextField Race;
    private javax.swing.JComboBox<String> RatePrison;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField Road;
    private javax.swing.JTextField Soi;
    private javax.swing.JTextField StatusSueAndPutInJail;
    private javax.swing.JTextField StatusSuspectOther;
    private javax.swing.JComboBox<String> SusConfress;
    private javax.swing.JTextField Tambon;
    public static javax.swing.JSpinner TimeSendInjuredOrDie;
    private javax.swing.JTextField Weight;
    public static javax.swing.JTextField WhereSendInjuredOrDie;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBail;
    private javax.swing.JButton jButtonInjuryOrDie;
    private javax.swing.JButton jButtonSue;
    private javax.swing.JCheckBox jCheckBail;
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
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelArrTime;
    private javax.swing.JLabel jLabelArrestAmphur;
    private javax.swing.JLabel jLabelArrestDate;
    private javax.swing.JLabel jLabelArrestEnd;
    private javax.swing.JLabel jLabelArrestPlace;
    private javax.swing.JLabel jLabelArrestProvince;
    private javax.swing.JLabel jLabelArrestTambon;
    private javax.swing.JLabel jLabelBailDate;
    private javax.swing.JLabel jLabelFreezeDate;
    private javax.swing.JLabel jLabelFreezeOrg;
    private javax.swing.JLabel jLabelNameArrest;
    private javax.swing.JLabel jLabelRate;
    private javax.swing.JLabel jLabelRestoreDate;
    private javax.swing.JLabel jLabelStatusSuspect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelAttachlDate;
    private javax.swing.JPanel jPanelBailDate;
    private javax.swing.JPanel jPanelBirthDay;
    private javax.swing.JPanel jPanelDateArrest;
    private javax.swing.JPanel jPanelExpiredDate;
    private javax.swing.JPanel jPanelIssueDate;
    private javax.swing.JPanel jPanelRestoreDate;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioCantCatch;
    private javax.swing.JRadioButton jRadioFreeze;
    private javax.swing.JRadioButton jRadioOther;
    private javax.swing.JRadioButton jRadioRelease;
    private javax.swing.JRadioButton jRadioRestore;
    private javax.swing.JRadioButton jRadioStatus1;
    private javax.swing.JRadioButton jRadioStatus2;
    private javax.swing.JRadioButton jRadioSue;
    private javax.swing.JRadioButton jRadioWithdrawComplaint;
    private javax.swing.JSpinner jSpinnerArrTime;
    // End of variables declaration//GEN-END:variables
}
