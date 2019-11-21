/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.document;

/**
 *
 * @author Petpilin
 */
import com.songkhla.wordgen.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.docx4j.XmlUtils;
import org.docx4j.model.fields.merge.DataFieldName;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Body;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class W71 {
    public static void w71(String cc,String noperson) {
     
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
             
             String PoliceStationName="";
             String HeadPosition ="";
             String HeadName="";
             String RankPolice ="";
             String FirstName ="";
             String LastName ="";
             String Position ="";
             String caseno;
             String suspectName ="";

       
            String Date="";
            String Month="";
            String Year="";
            String Time="";
         
            int SumValue=0;
            int BailAssetId=0;
            int DeliOrderID=0;
            JSONObject bookmarkvalue = new JSONObject();
            JSONObject bookmarkvalue1 = new JSONObject();
            
            try {
             String ccYear="";
             String casetype="";
             String cs="";
                    String sqlDataPoliceStation="SELECT * FROM PoliceStation";
                      Statement sp = conn.createStatement();
                  ResultSet rs=sp.executeQuery(sqlDataPoliceStation); 
                  while (rs.next()) {                    
                         PoliceStationName=rs.getString("PoliceStaionName");
                         HeadName =rs.getString("HeadName");
                         HeadPosition =rs.getString("HeadPosition");
                      }
                    rs.close();
                    String sqlDataPolice="SELECT * FROM Police";
                      Statement sp1 = conn.createStatement();
                  ResultSet rs1=sp1.executeQuery(sqlDataPolice); 
                  while (rs1.next()) {                    
                         RankPolice =rs1.getString("RankPolice");
                         FirstName=rs1.getString("FirstName");
                         LastName=rs1.getString("LastName");
                         Position=rs1.getString("Position");
                      }
                    rs1.close();
                    
            ////////////////////////////ตารางการนัดส่งตัว//////////////////////////////        
                  String sqlDataDeliverySuspect ="select DeliverySuspect.*\n" +
                                            "FROM DeliverySuspect\n" +
                                            "left join Person on  DeliverySuspect.DeliPersonId = Person.NoPerson \n" +
                                            "left join CrimeCase on Person.caseIdPerson =crimecase.CaseId \n" +
                                            "where crimecase.CaseId='"+cc+"' and Person.NoPerson='"+noperson+"'";
                  
                  Statement sp2 = conn.createStatement();
                  ResultSet rs2=sp2.executeQuery(sqlDataDeliverySuspect); 
                  System.out.println(sqlDataDeliverySuspect);
                  JSONArray JSONArray1 = new JSONArray();
                  
                  while ((rs2!=null) && (rs2.next())) { 
                       
                      ++DeliOrderID;
                   
                    JSONArray tablecolumn1 = new JSONArray();
                    System.out.println("<<<<<<"+DeliOrderID);
			tablecolumn1.add("D1");
			tablecolumn1.add("D2");
                        tablecolumn1.add("D3");
			tablecolumn1.add("D4");
                        

			
			JSONObject row2 = new JSONObject();
			row2.put("D1",Checknull(Integer.toString(DeliOrderID)));
			row2.put("D2",Checknull(ToDate(rs2.getString("DeliDate"))));
                        row2.put("D3",ReplaceCollon(rs2.getString("DeliTimes")));
			row2.put("D4",Checknull(rs2.getString("DeliPlace")));
                 
			JSONArray1.add(row2);
                        

		JSONObject tableobj1 = new JSONObject();
		tableobj1.put("COLUMNS", tablecolumn1);
		tableobj1.put("TABLEDATA", JSONArray1);
			
		JSONArray TABLES1 = new JSONArray();
		TABLES1.add(tableobj1);

		bookmarkvalue1.put("TABLES1", TABLES1);
		System.out.println(bookmarkvalue1.toJSONString());
		
                      }

          ////////////////////////////////ข้อมูลการประกันและทรัพย์สิน/////////////////////////////////////         
                  
                   String sql="select crimecase.*,Person.FullNamePerson suspectName,P2.*,ChargeCase.*,BailAsset.*\n" +
                                "from Person\n" +
                                "inner join( \n" +
                                "SELECT Person.*\n" +
                                "FROM Person where Person.Related='นายประกัน' and Person.caseIdPerson='"+cc+"' and Person.ownerbail='"+noperson+"')P2 \n" +
                                "left join CrimeCase on Person.caseidperson=CrimeCase.caseid\n" +
                                "left join ChargeCase on crimecase.caseid=ChargeCase.ChargeCaseid\n" +
                                "left join BailAsset on Person.noperson = BailAsset.BailpersonId\n" +
                                "where Person.StatusBail='ประกัน' and CrimeCase.caseid='"+cc+"' and Person.Noperson='"+noperson+"'" ;
     
            Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
            System.out.println(sql);
            
            JSONArray JSONArray = new JSONArray();
            while((s!=null) && (s.next()))
            {    
                    cs =s.getString("crimecaseno");
                    ccYear=s.getString("crimecaseyears");
                    casetype =s.getString("casetype");
                    caseno  =s.getString("crimecasenoyear");
                    suspectName= s.getString("suspectName");
            
                SimpleDateFormat sdfstart ;
                Calendar  calstart = Calendar.getInstance();
                sdfstart = new SimpleDateFormat("d", new Locale("th", "TH"));  
               Date =sdfstart.format(calstart.getTime());
              
               sdfstart = new SimpleDateFormat("MMMM", new Locale("th", "TH"));  
               Month=sdfstart.format(calstart.getTime());
               
               sdfstart = new SimpleDateFormat("yyyy", new Locale("th", "TH"));  
               Year=sdfstart.format(calstart.getTime());

               sdfstart = new SimpleDateFormat("HH:mm", new Locale("th", "TH"));  
               Time=sdfstart.format(calstart.getTime());
               
                 
//              
                bookmarkvalue.put("C1",Checknull(Date));
                bookmarkvalue.put("C01",Checknull(Month));
                bookmarkvalue.put("C001",Checknull(Year));
                bookmarkvalue.put("C0011",ReplaceCollon(Time));
                 bookmarkvalue.put("CC2",Checknull(caseno));
		bookmarkvalue.put("C2",Checknull(cs));
                bookmarkvalue.put("C3",Checknull(ccYear));
                
                bookmarkvalue.put("S2",Checknull(PoliceStationName).substring(10));
                bookmarkvalue.put("S02",Checknull(PoliceStationName));
                bookmarkvalue.put("S13",Checknull(HeadName));
                bookmarkvalue.put("S14",Checknull(HeadPosition));
                
                bookmarkvalue.put("PA7",Checknull(s.getString("AccureandOther")));
                  
                bookmarkvalue.put("PS7", Checknull(suspectName )); 
               
                
                    bookmarkvalue.put("C12", Checknull(s.getString("CrimeLocationDistrict")));
                    bookmarkvalue.put("C13", Checknull(s.getString("CrimeLocationAmphur")));
                    bookmarkvalue.put("C14", Checknull(s.getString("CrimeLocationProvince")));
                    
                    
                bookmarkvalue.put("PB7",  Checknull(s.getString("FullNamePerson")));
                bookmarkvalue.put("PB13", Checknull(s.getString("Age")));
                bookmarkvalue.put("PB14", Checknull(s.getString("Race")));
                bookmarkvalue.put("PB15", Checknull(s.getString("Nationality")));
                bookmarkvalue.put("PB22", Checknull(s.getString("HouseNumber"))); 
                bookmarkvalue.put("PB23", Checknull(s.getString("Moo"))); 
                bookmarkvalue.put("PB24", Checknull(s.getString("Tambon"))); 
                bookmarkvalue.put("PB25", Checknull(s.getString("Amphur"))); 
                bookmarkvalue.put("PB26", Checknull(s.getString("Province"))); 
                
                bookmarkvalue.put("B2", Checknull(s.getString("ChargeNameCase")));
                      /*
                       bookmarkvalue.put("P02", Checknull(RankPolice));
                       bookmarkvalue.put("P03", Checknull(FirstName));
                       bookmarkvalue.put("P04", Checknull(LastName));
                       bookmarkvalue.put("P05", Checknull(Position));

                        bookmarkvalue.put("P02", Checknull(s.getString("InvestRank")));
                        bookmarkvalue.put("P03", Checknull(s.getString("InvestName")));
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", Checknull(s.getString("InvestPosition")));
                        bookmarkvalue.put("P012", Checknull(s.getString("InvestRankFull"))); //ยศเต็ม
                        bookmarkvalue.put("P013", Checknull(s.getString("InvestPosition"))); //ตำแหน่งเต็ม
*/
                
                String[]   BailAssetTotal1 = s.getString("BailAssetTotal").split(" ");
                System.out.println(">>>>>"+Arrays.toString(BailAssetTotal1));
                String a=BailAssetTotal1[0];
                
                String   BailAssetTotal = a.replace (",", "");
               System.out.println(">>>>>"+BailAssetTotal);
                 if ((BailAssetTotal) != null)
                    {
                    
                    SumValue = SumValue+Integer.parseInt(BailAssetTotal);
                    } 
                   bookmarkvalue.put("BA661",Checknull(regexCommafy(Integer.toString(SumValue))));
                   bookmarkvalue.put("BA6611",Checknull(ThaiBaht(Integer.toString(SumValue))));
                     ++BailAssetId ;
                     
                     
                      System.out.println(">>>>>"+BailAssetId);

			JSONArray tablecolumn = new JSONArray();
			tablecolumn.add("BA2");
			tablecolumn.add("BA3");
                        tablecolumn.add("BA9");
			tablecolumn.add("BA5");
                        tablecolumn.add("BA6");
			tablecolumn.add("BA7");

			
			JSONObject row1 = new JSONObject();
                        
			row1.put("BA2",Checknull(Integer.toString(BailAssetId)));
			row1.put("BA3",Checknull(s.getString("BailAssetDetail")));
                        row1.put("BA9",Checknull(s.getString("BailAssetBath")));
                        row1.put("BA5",Checknull(s.getString("BailAmount")));
                        row1.put("BA6",Checknull(s.getString("BailAssetTotal")));
			row1.put("BA7",Checknull(s.getString("BailAssetRemark")));

			JSONArray.add(row1);
                        

		JSONObject tableobj = new JSONObject();
		tableobj.put("COLUMNS", tablecolumn);
		tableobj.put("TABLEDATA", JSONArray);
			
		JSONArray TABLES = new JSONArray();
		TABLES.add(tableobj);

		bookmarkvalue.put("TABLES", TABLES);
		System.out.println(bookmarkvalue.toJSONString());
		
		
            }
            try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w71.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
                        processTABLE(bookmarkvalue,wordMLPackage);
                        processTABLE1(bookmarkvalue1,wordMLPackage);
                       
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/คำร้องและสัญญาประกัน "+suspectName+""+ cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            } catch (Exception e) {
                e.printStackTrace();
            }
        
              
	}
 public static void nw71() {
     
         
                 JSONObject bookmarkvalue = new JSONObject();
//              
                bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
                bookmarkvalue.put("C0011","");
                bookmarkvalue.put("CC2","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("C3","");
                
                bookmarkvalue.put("S2","");
                bookmarkvalue.put("S02","");
                
                bookmarkvalue.put("PA7","");
                  
                bookmarkvalue.put("PS7", ""); 
               
                
                    bookmarkvalue.put("C12", "");
                    bookmarkvalue.put("C13", "");
                    bookmarkvalue.put("C14", "");
                    
                    
                bookmarkvalue.put("PB7", "");
                bookmarkvalue.put("PB13", "");
                bookmarkvalue.put("PB14", "");
                bookmarkvalue.put("PB15", "");
                bookmarkvalue.put("PB22", ""); 
                bookmarkvalue.put("PB23", ""); 
                bookmarkvalue.put("PB24", ""); 
                bookmarkvalue.put("PB25", ""); 
                bookmarkvalue.put("PB26", ""); 
                
                
                bookmarkvalue.put("B2", "");
                      
                       bookmarkvalue.put("P02", "");
                        bookmarkvalue.put("P03", "");
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", "");
                        bookmarkvalue.put("P012", "");
                        bookmarkvalue.put("P013", "");
                   
                    bookmarkvalue.put("BA2","");
                  
                    bookmarkvalue.put("BA3","");
                    
                    bookmarkvalue.put("BA4","");
                   
                    bookmarkvalue.put("BA5","");
                   
                    bookmarkvalue.put("BA6", "");
                    bookmarkvalue.put("BA661", "");
                    bookmarkvalue.put("BA6611", "");
                    bookmarkvalue.put("BA7","");
                  
                        
                    
                       bookmarkvalue.put("D1","");
                       
                      
                       bookmarkvalue.put("D2","");
                       
                      
                       bookmarkvalue.put("D3","");
                      
                       bookmarkvalue.put("D4","");
                    
                   
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w71.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/คำร้องและสัญญาประกัน.doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
	public static void processVariable(JSONObject inputdata,WordprocessingMLPackage wordMLPackage) throws Exception {
		Object KEYSET[] = inputdata.keySet().toArray();
		Map<DataFieldName, String> map = new HashMap<DataFieldName, String>();
		for(int i=0;i<KEYSET.length;i++) {
			String KEY = (String)KEYSET[i];
			if(KEY.equals("TABLES")) { continue; }
			map.put(new DataFieldName(KEY), inputdata.get(KEY)+"");
		}
		org.docx4j.model.fields.merge.MailMerger.performMerge(wordMLPackage, map, true);
	}
	
	public static void processTABLE(JSONObject inputdata,WordprocessingMLPackage wordMLPackage) throws Exception {
		

		JSONArray TABLES = (JSONArray)inputdata.get("TABLES");
		if(TABLES!=null) {
			for(int i=0;i<TABLES.size();i++) {
				JSONObject table  =(JSONObject)TABLES.get(i);
				if(table.get("COLUMNS")==null) {
					System.out.println("FOUND NULL COLUMNS");
					continue;
				}
				if(table.get("TABLEDATA")==null) {
					System.out.println("FOUND NULL TABLEDATA");
					continue;
				}
				replaceTable((JSONArray)table.get("COLUMNS"), (JSONArray)table.get("TABLEDATA"), wordMLPackage);
			}
		}else {
			System.out.println("FOUND NULL TABLES");
		}

	}
	public static void processTABLE1(JSONObject inputdata,WordprocessingMLPackage wordMLPackage) throws Exception {
		

		JSONArray TABLES = (JSONArray)inputdata.get("TABLES1");
		if(TABLES!=null) {
			for(int i=0;i<TABLES.size();i++) {
				JSONObject table  =(JSONObject)TABLES.get(i);
				if(table.get("COLUMNS")==null) {
					System.out.println("FOUND NULL COLUMNS");
					continue;
				}
				if(table.get("TABLEDATA")==null) {
					System.out.println("FOUND NULL TABLEDATA");
					continue;
				}
				replaceTable((JSONArray)table.get("COLUMNS"), (JSONArray)table.get("TABLEDATA"), wordMLPackage);
			}
		}else {
			System.out.println("FOUND NULL TABLES");
		}

	}
	
	
	private static Tbl getTemplateTable(List<Object> tables, String templateKey) throws Docx4JException, JAXBException {
		for (Iterator<Object> iterator = tables.iterator(); iterator.hasNext();) {
			Object tbl = iterator.next();
			List<?> textElements = getAllElementFromObject(tbl, Text.class);
			for (Object text : textElements) {
				Text textElement = (Text) text;
				if (textElement.getValue() != null && textElement.getValue().equals(templateKey))
					return (Tbl) tbl;
			}
		}
		return null;
	}
	
	private static void addRowToTable(Tbl reviewtable, Tr templateRow, JSONObject datarow) {
		Tr workingRow = (Tr) XmlUtils.deepCopy(templateRow);
		List<?> textElements = getAllElementFromObject(workingRow, Text.class);
		for (Object object : textElements) {
			Text text = (Text) object;
			String replacementValue = (String) datarow.get(text.getValue());
			if (replacementValue != null) {
				text.setValue(replacementValue);
			}
		}

		reviewtable.getContent().add(workingRow);
	}
	
	private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
		List<Object> result = new ArrayList<Object>();
		if (obj instanceof JAXBElement) obj = ((JAXBElement<?>) obj).getValue();
		
		if (obj==null) {
			return result;
		}
		if (obj.getClass().equals(toSearch))
			result.add(obj);
		else if (obj instanceof ContentAccessor) {
			List<?> children = ((ContentAccessor) obj).getContent();
			for (Object child : children) {
				result.addAll(getAllElementFromObject(child, toSearch));
			}
		}
		return result;
	}
        
	private static void replaceTable(JSONArray placeholders, JSONArray data,
			WordprocessingMLPackage template) throws Docx4JException, JAXBException {
		List<Object> tables = getAllElementFromObject(template.getMainDocumentPart(), Tbl.class);

		// 1. find the table
		Tbl tempTable = getTemplateTable(tables, (String)placeholders.get(0));
		List<Object> rows = getAllElementFromObject(tempTable, Tr.class);

		// first row is header, second row is content
		if (rows.size() == 2) {
			// this is our template row
			System.out.println("Found Table!! "+(String)placeholders.get(0));
			Tr templateRow = (Tr) rows.get(1);
			
			for(int i=0;i<data.size();i++) {
				// 2 and 3 are done in this method
				JSONObject datarow=(JSONObject)data.get(i);
				addRowToTable(tempTable, templateRow, datarow);
			}

			// 4. remove the template row
			tempTable.getContent().remove(templateRow);
		}
	}
        private static String ToDate(String strDate){
               String ResultDate="";
         try {
    	       if(strDate==null||strDate.equals("")||strDate.equals("null")) { return ""; }else{
    	       SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy", new Locale("th", "TH"));  
               SimpleDateFormat dateto  = new SimpleDateFormat("d MMMM yyyy", new Locale("th", "TH"));  
               Date date=null;
               
               date = df.parse(strDate);               
               ResultDate=dateto.format(date.getTime());}
         } catch (ParseException ex) {
             Logger.getLogger(W71.class.getName()).log(Level.SEVERE, null, ex);
         }
               return ResultDate;
}
      public static String Checknull(String input){
					if(input==null||input==""||input=="null") { return ""; }
					return getThaiNumber(input);
					}
    
    private static String getThaiNumber(String amount) {  
        if(amount == null || amount.isEmpty()) return "";
        String[] DIGIT_TH = { "๐", "๑", "๒", "๓", "๔", "๕", "๖", "๗", "๘", "๙" };
        StringBuilder sb = new StringBuilder();
        for(char c : amount.toCharArray()){
            if(Character.isDigit(c)){
                String index = DIGIT_TH[Character.getNumericValue(c)].toString();
                sb.append(index);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();  
    }  
        
  public static String ThaiBaht(String txt) {
  String bahtTxt, n, bahtTH = "";
  Double amount;
  try {
   amount = Double.parseDouble(txt);
  } catch (Exception ex) {
   amount = 0.00;
  }

  try {
      DecimalFormat df = new DecimalFormat("####.00");
   bahtTxt = df.format(amount);
   String Valnum="";
   String Valrank="";
   String[] num = { "ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า",
     "หก", "เจ็ด", "แปด", "เก้า", "สิบ" };
   String[] rank = { "", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน", "ล้าน" };
   String[] temp = bahtTxt.split("[.]");
   String intVal = temp[0];
   String decVal = temp[1];
   if (Double.parseDouble(bahtTxt) == 0)
    bahtTH = "ศูนย์บาทถ้วน";
   else {
    for (int i = 0; i < intVal.length(); i++) {
     n = intVal.substring(i, i + 1);
     if (n != "0") {
      if ((i == (intVal.length() - 1)) && (n == "1"))
       bahtTH += "เอ็ด";
      else if ((i == (intVal.length() - 2)) && (n == "2"))
       bahtTH += "ยี่";
      else if ((i == (intVal.length() - 2)) && (n == "1"))
       bahtTH += "";
      else
            Valnum=num[Integer.parseInt(n)];
            if (Valnum!="ศูนย์" && !Valnum.equals("ศูนย์")){
                  bahtTH += Valnum;
                  bahtTH += rank[(intVal.length() - i) - 1];
            }
     }
    }
    bahtTH += "บาท";
       System.out.println("decVal>>"+decVal);
    if (decVal == null || decVal == "00"|| decVal.equals("00"))
     bahtTH += "ถ้วน";
    else {
     for (int i = 0; i < decVal.length(); i++) {
      n = decVal.substring(i, i + 1);
      if (n != "0") {
       if ((i == decVal.length() - 1) && (n == "1"))
        bahtTH += "เอ็ด";
       else if ((i == (decVal.length() - 2)) && (n == "2"))
        bahtTH += "ยี่";
       else if ((i == (decVal.length() - 2)) && (n == "1"))
        bahtTH += "";
       else
            Valnum=num[Integer.parseInt(n)]; 
            Valrank=rank[(decVal.length() - i) - 1];
            if(Valnum !="ศูนย์" && !Valnum.equals("ศูนย์")){
                bahtTH += Valnum;
                bahtTH += Valrank;
            } 
       System.out.println("Stang Valnum>>"+Valnum+" : Valrank>>"+Valrank);
      }
     }
     bahtTH += "สตางค์";
    }
   }
  
  } catch (Exception exe) {

   System.out.print(exe.getMessage());
  }
  return bahtTH;

 }
    public static String ReplaceCollon(String inputTime){
                                        if(inputTime==null||inputTime==""||inputTime=="null") { return ""; }
					return  getThaiNumber(inputTime.replaceAll(":", "."));
					}
  private static String regexCommafy(String inputNum)
    {
        String regex = "(\\d)(?=(\\d{3})+$)";
        String [] splittedNum = inputNum.split("\\.");
        if(splittedNum.length==2)
        {
            return splittedNum[0].replaceAll(regex, "$1,")+"."+splittedNum[1];
        }
        else
        {
            return inputNum.replaceAll(regex, "$1,");
        }
    }
         
}
