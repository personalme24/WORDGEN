/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

/**
 *
 * @author Computer
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;
import javax.smartcardio.*;
import javax.smartcardio.CardTerminals.State;

//import com.project.model.ThaiCard;
//import com.project.model.ThaiCardDetail;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//import cdgs.moilib.MOIJni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadThaiCardService {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	public int status = 0;
	public boolean isread = false;
	public CardChannel channel;
	public Card card;
	String userDir;
	PrintStream printErr;
	String fileErr = "err.log";
	
	String pid;
	String cid;
	String thname;
	String thname0;
	String thname1;
	String thname3;
	String enname;
	String birthdate;
	String gender;
	String enname0;
	String enname1;
	String enname3;
	String addr;
	String issuedate;
	String expiredate;
	byte[] image = new byte['?'];
	List<Byte> image_list;
	String person_img = "";

	public ReadThaiCardService() {
		userDir = System.getProperty("user.dir");
		pid = "";
		cid = "";
		thname = "";
		thname0 = "";
		thname1 = "";
		thname3 = "";
		enname = "";
		birthdate = "";
		gender = "";
		enname0 = "";
		enname1 = "";
		enname3 = "";
		addr = "";
		issuedate = "";
		expiredate = "";
		image = new byte['?'];
		image_list = new ArrayList<Byte>();
		person_img = "";
		
		try {
			printErr = new PrintStream(new File(userDir+"\\"+fileErr));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			
			if(true) {
				ReadThaiCardService read = new ReadThaiCardService();
				read.check_read();
				read.read(0);
                                int st=read.getDataThaiCard().getStatus();
                                System.out.println(read.getDataThaiCard().getStatus());
                                if(st==1){
                                    System.out.println("Please Insert Card ");
                                }
                               else if(st==2){
                                    System.out.println("Please Insert Card");
                                }
                                else if(st==4){
                                 System.out.println(read.getDataThaiCard().getStatus());
                                  String str=read.getDataThaiCard().getThaiCardDetail().getThname(); 
                                String[] name=str.split("##",2);
                                String firstname=(name[0]+"").replace("#", "");
                                String n=firstname+" "+name[1];
                                 System.out.println(n);
				
                                System.out.println(DateCard(read.getDataThaiCard().getThaiCardDetail().getIssuedate()));
                                System.out.println(read.getDataThaiCard().getThaiCardDetail().getBirthdate());
                                
                                
                                }
                               

                                System.out.println(read.getDataThaiCard().getThaiCardDetail().getPid());
//				Thread.sleep(5000);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void clearTerminal() {
		try {
			/*Class pcscterminal = Class.forName("sun.security.smartcardio.PCSCTerminals");
		    Field contextId = pcscterminal.getDeclaredField("contextId");
		    contextId.setAccessible(true);
	
		    if(contextId.getLong(pcscterminal) != 0L)
		    {
		        Class pcsc = Class.forName("sun.security.smartcardio.PCSC");
		        Method SCardEstablishContext = pcsc.getDeclaredMethod(
		                                           "SCardEstablishContext",
		                                           new Class[] {Integer.TYPE }
		                                       );
		        SCardEstablishContext.setAccessible(true);
	
		        Field SCARD_SCOPE_USER = pcsc.getDeclaredField("SCARD_SCOPE_USER");
		        SCARD_SCOPE_USER.setAccessible(true);
	
		        long newId = ((Long)SCardEstablishContext.invoke(pcsc, 
		              new Object[] { Integer.valueOf(SCARD_SCOPE_USER.getInt(pcsc)) }
		              )).longValue();
		        contextId.setLong(pcscterminal, newId);
		    }*/
			
			Class pcscterminal = Class.forName("sun.security.smartcardio.PCSCTerminals");
	        Field contextId = pcscterminal.getDeclaredField("contextId");
	        contextId.setAccessible(true);

	        if(contextId.getLong(pcscterminal) != 0L)
	        {
	            // First get a new context value
	            Class pcsc = Class.forName("sun.security.smartcardio.PCSC");
	            Method SCardEstablishContext = pcsc.getDeclaredMethod(
	                                               "SCardEstablishContext",
	                                               new Class[] {Integer.TYPE }
	                                           );
	            SCardEstablishContext.setAccessible(true);

	            Field SCARD_SCOPE_USER = pcsc.getDeclaredField("SCARD_SCOPE_USER");
	            SCARD_SCOPE_USER.setAccessible(true);

	            long newId = ((Long)SCardEstablishContext.invoke(pcsc, 
	                    new Object[] { SCARD_SCOPE_USER.getInt(pcsc) }
	            ));
	            contextId.setLong(pcscterminal, newId);


	            // Then clear the terminals in cache
	            TerminalFactory factory = TerminalFactory.getDefault();
	            CardTerminals terminals = factory.terminals();
	            Field fieldTerminals = pcscterminal.getDeclaredField("terminals");
	            fieldTerminals.setAccessible(true);
	            Class classMap = Class.forName("java.util.Map");
	            Method clearMap = classMap.getDeclaredMethod("clear");

	            clearMap.invoke(fieldTerminals.get(terminals));
	        }
		}catch(Exception e) {
			//e.printStackTrace();
		}
	}

	public void check_read() {
		try {
			clearTerminal();
			// System.out.println("status "+status);
			// Display the list of terminals
			/*Security.addProvider(new Smartcardio());
			TerminalFactory factory = TerminalFactory.getInstance("PC/SC", null, Smartcardio.PROVIDER_NAME);*/
			
			//TerminalFactory factory =  TerminalFactory.getInstance("PC/SC", null, new Smartcardio());
			
			TerminalFactory factory = TerminalFactory.getDefault();
			//LOG.info(factory.terminals().toString());
			List<CardTerminal> terminals = factory.terminals().list(State.ALL);
			//LOG.info("Terminals: " + terminals);

			// Use the first terminal
			CardTerminal terminal = terminals.get(0);
			//terminal.waitForCardPresent(500);

			// Connect wit hthe card
			card = terminal.connect("*");//connect *
			//LOG.info("card: " + card);
			channel = card.getBasicChannel();
			//LOG.info("channel: " + channel);
			status = 3;
			isread = true;

			/*
			 * // Send Select Applet command byte[] aid = {(byte)0xA0, 0x00, 0x00, 0x00,
			 * 0x62, 0x03, 0x01, 0x0C, 0x06, 0x01}; ResponseAPDU answer =
			 * channel.transmit(new CommandAPDU(0x00, 0xA4, 0x04, 0x00, aid));
			 * System.out.println("answer: " + answer.toString());
			 * 
			 * // Send test command answer = channel.transmit(new CommandAPDU(0x00, 0x00,
			 * 0x00, 0x00)); System.out.println("answer: " + answer.toString()); byte r[] =
			 * answer.getData(); for (int i=0; i<r.length; i++)
			 * System.out.print((char)r[i]); System.out.println();
			 */

		}
		catch (CardNotPresentException e) {
			status = 2;
			isread = false;
			if(printErr != null) {
				e.printStackTrace(printErr);
			}
			//e.printStackTrace();
		}
		catch (IndexOutOfBoundsException e) {
			status = 1;
			isread = false;
			if(printErr != null) {
				e.printStackTrace(printErr);
			}
			//e.printStackTrace();
		}
		catch (CardException e) {
			status = 1;
			isread = false;
			if(printErr != null) {
				e.printStackTrace(printErr);
			}
			//e.printStackTrace();
		} catch (Exception e) {
			status = 0;
			isread = false;
			if(printErr != null) {
				e.printStackTrace(printErr);
			}
			//e.printStackTrace();
		}

	}
	

	public void read(int type) {
		if (isread == true) {
			StringBuilder dataRead = new StringBuilder();
			try {
				
				int i = 0;
				this.image[0] = 0;
				byte[] arrayOfByte1 = this.card.getATR().getBytes();
				if ((arrayOfByte1[0] == 59) && (arrayOfByte1[1] == 104)) {
					i = 2;
				} else if ((arrayOfByte1[0] == 59) && (arrayOfByte1[1] == 103)) {
					i = 1;
				}

				CommandAPDU[] arrayOfCommandAPDU = new CommandAPDU[100];
				ResponseAPDU[] arrayOfResponseAPDU = new ResponseAPDU[100];

				byte[] arrayOfByte2 = { 0, -92, 4, 0, 8, -96, 0, 0, 0, 84, 72, 0, 1, 0 };

				arrayOfCommandAPDU[0] = new CommandAPDU(arrayOfByte2);
				byte[] arrayOfByte3 = { Byte.MIN_VALUE, -80, 0, 0, 2, 0, 17 };

				arrayOfCommandAPDU[1] = new CommandAPDU(arrayOfByte3);
				byte[] arrayOfByte4 = { Byte.MIN_VALUE, -80, 0, 17, 2, 0, 50 };

				arrayOfCommandAPDU[2] = new CommandAPDU(arrayOfByte4);
				byte[] arrayOfByte5 = { Byte.MIN_VALUE, -80, 0, 117, 2, 0, 109 };

				arrayOfCommandAPDU[3] = new CommandAPDU(arrayOfByte5);
				byte[] arrayOfByte6 = { Byte.MIN_VALUE, -80, 21, 121, 2, 0, 100 };

				arrayOfCommandAPDU[4] = new CommandAPDU(arrayOfByte6);
				int j = 359;
				byte[] arrayOfByte7 = { Byte.MIN_VALUE, -80, (byte) (j >> 8), (byte) j, 2, 0, 18 };

				arrayOfCommandAPDU[5] = new CommandAPDU(arrayOfByte7);
				int n;
				for (int k = 0; k <= 20; k++) {
					int m = k * 254 + 379;
					n = k == 20 ? 38 : 254;
					byte[] arrayOfByte9 = { Byte.MIN_VALUE, -80, (byte) (m >> 8), (byte) m, 2, 0, (byte) n };

					arrayOfCommandAPDU[(6 + k)] = new CommandAPDU(arrayOfByte9);
				}

				byte[] arrayOfByte8;
				int index_card = 0;
				if(type == 0) {
					//without image
					index_card = 5;
				}
				else {
					// all
					index_card = 26;
				}

				for (int i1 = 0; i1 <= index_card; i1++) {
					int i2;
					int i3;
					arrayOfResponseAPDU[i1] = channel.transmit(arrayOfCommandAPDU[i1]);
					arrayOfByte8 = arrayOfResponseAPDU[i1].getBytes();
					dataRead.append("index "+i1+" : "+new String(arrayOfByte8,0, arrayOfByte8.length, "TIS-620"));

					switch (i1) {
					case 0:
						// System.out.println("img : " + arrayOfByte8);
						for (i2 = 0; i2 < this.image.length; i2++) {
							this.image[i2] = 0;
						}
						break;
					case 1:
						pid = new String(arrayOfByte8, 4, 13);
						break;
					case 2:
						thname = new String(arrayOfByte8, 0, 50, "TIS-620");
						thname = thname.trim();
						/*int n_thname = thname.lastIndexOf(" ");
						if (n_thname > 0) {
							//thname = thname.substring(0, n_thname);
						}*/
						String[] arrayOfString = thname.split("#");
						thname0 = arrayOfString[0];
						thname1 = arrayOfString[1];
						thname3 = arrayOfString[3];

						break;
					case 3:
						enname = new String(arrayOfByte8, 0, 50, "TIS-620");
						birthdate = new String(arrayOfByte8, 100, 8, "TIS-620");

						gender = new String(arrayOfByte8, 108, 1, "TIS-620");
						/*int n_en = enname.lastIndexOf(" ");
						if (n_en > 0) {
							enname = enname.substring(0, n_en);
						}*/
						enname = enname.trim();
						String[] arrayOfString_enname = enname.split("#");
						enname0 = arrayOfString_enname[0];
						enname1 = arrayOfString_enname[1];
						enname3 = arrayOfString_enname[3];

						break;
					case 4:
						addr = new String(arrayOfByte8, 0, 100, "TIS-620");
						int n_addr = addr.indexOf("      ");
						if (n_addr > 0) {
							addr = addr.substring(0, n_addr);
						}
						break;
					case 5:
						issuedate = new String(arrayOfByte8, 0, 8);
						expiredate = new String(arrayOfByte8, 8, 8);

						break;
					default:
						arrayOfByte8 = arrayOfResponseAPDU[i1].getBytes();
						i3 = (i1 - 6) * 254;
						int i4 = i1 - 6 == 20 ? 38 : 254;

						for (int i5 = 0; i5 < i4; i5++) {
							// System.out.println("put image index "+(i3 + i5));
							// System.out.println(arrayOfByte8[i5]);
							image_list.add(arrayOfByte8[i5]);

							// this.image[(i3 + i5)] = arrayOfByte8[i5];
						}
						if (i1 - 6 == 20) {
							byte[] byte_img = new byte[image_list.size()];
							int index = 0;
							for (byte b : image_list) {
								byte_img[index++] = b;
							}

							person_img = Base64.encode(byte_img);
							/*
							 * BufferedImage localBufferedImage = null; try { File localFile1 = new
							 * File(currentPath+"/pic"); if (!localFile1.exists()) { localFile1.mkdirs(); }
							 * File localFile2 = new File(localFile1 + "/picture.jpg"); FileOutputStream
							 * localFileOutputStream = new FileOutputStream(localFile2);
							 * 
							 * 
							 * 
							 * localFileOutputStream.write(byte_img, 0, byte_img.length);
							 * localFileOutputStream.close(); localBufferedImage = ImageIO.read(localFile2);
							 * } catch (Exception localException4) { localException4.printStackTrace(); }
							 */
						}
						break;
					}

				}
				isread = true;
				status = 4;
				
				
			} catch (CardException e) {
				//e.printStackTrace();
				if(printErr != null) {
					e.printStackTrace(printErr);
					printDataRead(dataRead.toString());
				}
				status = 5;
			} catch (Exception e) {
				//e.printStackTrace();
				if(printErr != null) {
					e.printStackTrace(printErr);				
					printDataRead(dataRead.toString());
				}
				status = 6;
			}
			finally
		    {
				try {
					card.disconnect(false);
					dataRead.setLength(0);
					//card.endExclusive();
				} catch (CardException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		    }
			
		} // end if

		// Disconnect the card
		// card.endExclusive();
	}// end method
	
	public void printDataRead(String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userDir+"\\"+fileErr,true), "UTF-8"));
			writer.write(data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally{
			
				try {
					if (writer != null)
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public ThaiCard getDataThaiCard() {
		ThaiCard obj = new ThaiCard();
		obj.setStatus(this.status);
		if (status == 4) {
			ThaiCardDetail objDetail = new ThaiCardDetail();
			objDetail.setAddr(this.addr);
			objDetail.setBirthdate(this.birthdate);
			objDetail.setCid(this.cid);
			objDetail.setEnname(this.enname);
			objDetail.setEnname0(this.enname0);
			objDetail.setEnname1(this.enname1);
			objDetail.setEnname3(this.enname3);
			objDetail.setExpiredate(this.expiredate);
			objDetail.setGender(this.gender);
			objDetail.setImage(this.image);
			objDetail.setImage_list(this.image_list);
			objDetail.setIssuedate(this.issuedate);
			objDetail.setPerson_img(this.person_img);
			objDetail.setPid(this.pid);
			objDetail.setThname(this.thname);
			objDetail.setThname0(this.thname0);
			objDetail.setThname1(this.thname1);
			objDetail.setThname3(this.thname3);

			try {
				String[] arrayOfString_addr = this.addr.split("#");
				objDetail.setAddrHS(arrayOfString_addr[0]);
				objDetail.setAddrMoo(arrayOfString_addr[1]);
				objDetail.setAddrTrk(arrayOfString_addr[2]);
				objDetail.setAddrSoi(arrayOfString_addr[3]);
				objDetail.setAddrStr(arrayOfString_addr[4]);
				objDetail.setAddrTmb(arrayOfString_addr[5]);
				objDetail.setAddrAmp(arrayOfString_addr[6]);
				objDetail.setAddrPrv(arrayOfString_addr[7]);
			} catch (Exception e) {
				//e.printStackTrace();
			}

			obj.setThaiCardDetail(objDetail);
		}

		return obj;
	}
	
	public String verifyPin()
	  {
	    StringBuilder detail = new StringBuilder();
	    MOIJni ap = new MOIJni();
	    String isInit = ap.jInitialize();
	    detail.append(isInit + "\n");
	    String listReader = ap.jListReader();
	    detail.append(listReader + "\n");
	    if (listReader.contains("TRUE"))
	    {
	      int i1 = listReader.indexOf("[");
	      int i2 = listReader.indexOf("]");
	      String readerName = listReader.substring(i1 + 1, i2);
	      detail.append("reader name : " + readerName + "\n");
	      
	      String status = ap.jOpenReader(readerName);
	      detail.append("openReader : " + status + "\n");
	      
	      String smPID = "";
	      String smCID = "";
	      if (status.indexOf("TRUE") != -1)
	      {
	        smPID = ap.jGetPID();
	        smCID = ap.jGetCID();
	        smCID = smCID.split(":")[1];
	        smPID = smPID.replace("TRUE:", "");
	        
	        String sts = ap.jVerifyPin2();
	       // this.LOG.info("jVerifyPin2 " + sts);
	        if (sts.equals("TRUE")) {
	          return "{'cid' : '" + smCID + "' , 'pid' : '" + smPID + "'}";
	        } else {
	          return "{'cid':'',pid:'','error' : 'PIN invalid'}";
	        }
	      }
	      else if (status.indexOf("NO LICENSE MANAGER") != -1)
	      {
	        //this.LOG.info("ยังไม่ได้เรียกใช้โปรแกรม LICENSE MANAGER");
	        ap.jUnInitialize();
	        return "{'cid':'',pid:'','error' : 'LM not found'}";
	      }
	      else
	      {
	        //this.LOG.info("ยังไม่ได้สอดบัตรประจำตัวประชาชน");
	        ap.jUnInitialize();
	        return "{'cid':'',pid:'','error' : 'Card not found'}";
	      }
	    }
	    else {
	    	 return "{'cid':'',pid:'','error' : 'Card reader not found'}";
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
}

