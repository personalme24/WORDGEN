/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import com.songkhla.document.W1;
import com.songkhla.document.W11;
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
import com.songkhla.document.W54;
import com.songkhla.document.W55;
import com.songkhla.document.W56;
import com.songkhla.document.W57;
import com.songkhla.document.W58;
import com.songkhla.document.W59;
import com.songkhla.document.W6;
import com.songkhla.document.W60;
import com.songkhla.document.W61;
import com.songkhla.document.W62;
import com.songkhla.document.W63;
import com.songkhla.document.W64;
import com.songkhla.document.W65;
import com.songkhla.document.W66;
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
import com.songkhla.document.W79;
import com.songkhla.document.W8;
import com.songkhla.document.W80;
import com.songkhla.document.W9;
import com.songkhla.document.W93;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.json.JSONObject;

/**
 *
 * @author Computer
 */
public class LogInPage extends javax.swing.JFrame {

    /**
     * Creates new form LogInPage
     */
//    String username="",password="";
    public LogInPage() {
        initComponents();
          ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES)");
            setMaximumSize(new Dimension(1280, 760));
        setMinimumSize(new Dimension(1280, 760));
        setMaximizedBounds ( new Rectangle ( 1280, 760 ) );
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        
//        try{
//  
//
//        
//}
//catch (IOException ioe) {
//    ioe.printStackTrace();
//}

//try {
//    // Connect to the web server endpoint
//    URL serverUrl = new URL("http://httpbin.org/basic-auth/user/passwd");
//    HttpURLConnection urlConnection = (HttpURLConnection) serverUrl.openConnection();
// 
//    // Set HTTP method as GET
//    urlConnection.setRequestMethod("GET");
// 
//    // Include the HTTP Basic Authentication payload
//    urlConnection.addRequestProperty("Authorization", basicAuthPayload);
// 
//    // Read response from web server, which will trigger HTTP Basic Authentication request to be sent.
//    httpResponseReader =
//            new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//    String lineRead;
//    while((lineRead = httpResponseReader.readLine()) != null) {
//        System.out.println(lineRead);
//    }
// 
//} catch (IOException ioe) {
//    ioe.printStackTrace();
//} finally {
// 
//    if (httpResponseReader != null) {
//        try {
//            httpResponseReader.close();
//        } catch (IOException ioe) {
//            // Close quietly
//        }
//    }
//}
    }
private static void Login(){
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("ชื่อผู้ใช้   :");

        Username.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("รหัสผ่าน :");

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("เข้าสู่ระบบ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Password.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(Password)
                    .addComponent(jButton1))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Username)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(381, 381, 381))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        setVisible(false);
//        MainMenuWord d =new MainMenuWord();
//        d.setVisible(true);
          String  username=Username.getText();
       String password=Password.getPassword()+"";
         try { 
            
         String url=  "http://172.31.191.163:8383/wordgenauthen/?USER="+username+"&PASS="+password;
                  String fff =sendGET(url);
                   JSONObject myResponse = new JSONObject(fff);
                   String statusconnect=myResponse.getString("statusconnect");
                  if(statusconnect.equals("0")){
                    JOptionPane.showConfirmDialog(jPanel1, "Dont Use", "แจ้งเตือน",
                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);               
                  } 
                  else if(statusconnect.equals("5")){
                          yourAttemptActionPerformed();
                  }
                 
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInPage().setVisible(true);
            }
        });
    }
private static String sendGET(String GET_URL) throws IOException {
                String a="";
		URL serverUrl = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("Accept-Charset", "UTF-8");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
//			System.out.println(response.toString());
                        return response.toString();
		} else {
			System.out.println("GET request not worked");
                        return null;
		}
                
	}
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
							dialog.add(new JLabel("กำลังเชื่อมต่อข้อมูล..."), gbc);
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
       String  username=Username.getText();
       String password=Password.getPassword()+"";
        Connection con=null;
       PreparedStatement pst=null; 
        String statusconnect,idcard,fullname,firstname,lastname,rank,rankcode,position,email,positioncode;
        String stationname,orgcode,startdate,enddate,initialname,address,province,amphur,tambon,zipcode,bk,bh,birthday,age,mobilephone;
        try { 
             for (int i = 0; i < 20; i++) {
                
//                x = x - i;
            setProgress((int)((i*100)/20)+1);
            setProgress(i * (100 / 20));          
                    con = ConnectDatabase.connect();
             Statement stmt = con.createStatement();
            String sql ="Select * from User";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
            
             }
             else{
             String url=  "http://172.31.191.163:8383/wordgenauthen/?USER="+username+"&PASS="+password;
             String fff =sendGET(url);
             JSONObject myResponse = new JSONObject(fff);
//             String statusconnect=myResponse.getString("statusconnect"); 
                con=ConnectDatabase.connect();
     
              String insertPolice="INSERT INTO Police (IdPolice,IdCardPolice,RankPolice,FirstName,LastName,"
                      + "Birthday,Age,Tel,Position) "           
                      + "VALUES (?,?,?,?,?,?,?,?,?,?)";
//               String insertUser="INSERT INTO User (Username,Password,StatusLogin,DateLogin,FirstName,LastName)\n"        
//                      + "VALUES (?,?,?,?,?,?,?,?,?,?)";
//               String insertInvest="INSERT INTO InvestInformation (InvestCardID,InvestRankFull,InvestRank,DateLogin,FirstName,LastName)\n"        
//                      + "VALUES (?,?,?,?,?,?,?,?,?,?)";
               try {
                             pst=con.prepareStatement(insertPolice);
                              pst.setString(1,"1");
                              pst.setString(2,myResponse.getString("idcard"));
                              pst.setString(3,myResponse.getString("rank"));
//                              pst.setString(4,myResponse.getString("rank"));
                              pst.setString(4,myResponse.getString("firstname"));
                              pst.setString(5,myResponse.getString("lastname"));
                              pst.setString(6,myResponse.getString("birthday"));
                              pst.setString(7,myResponse.getString("age"));
                              pst.setString(8,myResponse.getString("mobilephone"));
                              pst.setString(9,myResponse.getString("position"));                             
                              pst.executeUpdate();                
                              pst.close();
                        
        } catch (Exception e) {
             JOptionPane.showMessageDialog(jPanel1, "Cannot Save",null, JOptionPane.INFORMATION_MESSAGE);
             System.out.println("SQL : "+pst);
        }
          
        
      
             }
            setProgress(i);
            Thread.sleep(10);
            Thread.sleep(SLEEP_TIME);// imitate a long-running task
             }
        } catch (Exception e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
  
                    setVisible(false);
                    MainMenuWord f=new MainMenuWord();
                    f.setVisible(true);
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}