/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.document;

/**
 *
 * @author Computer
 */
import com.songkhla.wordgen.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class W76 {
     public static void w76(String cc) {
     
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
             
             String PoliceStationName="";
             String suspectName="";
             String THNumBook="";
             String TelStation="";
             String ProtectChild="";
             String RankPolice ="";
             String FirstName ="";
             String LastName ="";
             String Position ="";
             String caseno;
       
            String Date="";
            String Month="";
            String Year="";
            String Time="";
        
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
                         THNumBook=rs.getString("THNumBook");
                         TelStation=rs.getString("TelStation");
                         ProtectChild=rs.getString("ProtectChild");
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
             
                  
                   String sql="select crimecase.*,Person.*,ChargeCase.*,ActionsCaseData.*,InvestInformation.*\n" +
                              "from crimecase \n" +
                              "left join Person on crimecase.CaseId=Person.caseIdPerson\n" +
                              "left join ChargeCase on crimecase.caseid=ChargeCase.Chargecaseid\n" +
                              "left join ActionsCaseData on crimecase.ActionCodeCase = ActionsCaseData.ActionCodeCase\n"+
                              "left join InvestInformation on crimecase.PoliceNameCase=InvestInformation.InvestId \n" +
                              "where crimecase.CaseId='"+cc+"' and Person.TypePerson='ผู้ต้องหา' and Person.CourtSuspect='ศาลเยาวชนและครอบครัว'\n" +
                              "group by crimecase.CaseId,Person.NoPerson";
       
                   
            
            
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
                    suspectName = s.getString("FullNamePerson");
            
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
                bookmarkvalue.put("C38",Checknull(s.getString("Investigator_Number")));
                bookmarkvalue.put("C4",Checknull(ToDate(s.getString("OccuredDate"))));
                bookmarkvalue.put("C441", ReplaceCollon(s.getString("OccuredTime")));
                bookmarkvalue.put("C6", Checknull(ToDate(s.getString("CaseRequestDate"))));
                bookmarkvalue.put("C661", ReplaceCollon(s.getString("CaseRequestTime")));
                bookmarkvalue.put("C9", Checknull(s.getString("CrimeLocationMoo")));
                bookmarkvalue.put("C10", Checknull(s.getString("CrimeLocationSoi")));
                bookmarkvalue.put("C11", Checknull(s.getString("CrimeLocationRoad")));
                bookmarkvalue.put("C12", Checknull(s.getString("CrimeLocationDistrict")));
                bookmarkvalue.put("C13", Checknull(s.getString("CrimeLocationAmphur")));
                bookmarkvalue.put("C14", Checknull(s.getString("CrimeLocationProvince")));
                
                bookmarkvalue.put("A2", Checknull(s.getString("ActionCrimesCase"))); 
                bookmarkvalue.put("B2", Checknull(s.getString("ChargeNameCase")));
                
                bookmarkvalue.put("S2",Checknull(PoliceStationName).substring(10));
                bookmarkvalue.put("S02",Checknull(PoliceStationName));
                bookmarkvalue.put("S29",Checknull(THNumBook));
                bookmarkvalue.put("S12",Checknull(TelStation));
                bookmarkvalue.put("S30",Checknull(ProtectChild));
                
                   
                    
                    bookmarkvalue.put("PY7",  Checknull(s.getString("FullNamePerson")));
                    bookmarkvalue.put("PY11", Checknull(ToDate(s.getString("BirthDay"))));
                    bookmarkvalue.put("PY12", Checknull(s.getString("Gender")));
                    bookmarkvalue.put("PY13", Checknull(s.getString("Age")));
                    bookmarkvalue.put("PY15", Checknull(s.getString("Nationality"))); 
                    bookmarkvalue.put("PY16", Checknull(s.getString("Religion"))); 
                    bookmarkvalue.put("PY17", Checknull(s.getString("Occupation")));
                    bookmarkvalue.put("PL22", Checknull(s.getString("HouseNumber")));
                    bookmarkvalue.put("PL23", Checknull(s.getString("Moo")));
                    bookmarkvalue.put("PY24", Checknull(s.getString("Tambon"))); 
                    bookmarkvalue.put("PY25", Checknull(s.getString("Amphur")));
                    bookmarkvalue.put("PY26", Checknull(s.getString("Province")));
                    bookmarkvalue.put("PY31", Checknull(s.getString("FatherFullName")));
                    bookmarkvalue.put("PY32", Checknull(s.getString("MotherFullName")));
                    bookmarkvalue.put("PY33", Checknull(s.getString("TambonBirthday")));
                    bookmarkvalue.put("PY34", Checknull(s.getString("AmphurBirthday")));
                    bookmarkvalue.put("PY35", Checknull(s.getString("ProvinceBirthday")));
                    bookmarkvalue.put("PY40", Checknull(s.getString("PlaceBorn")));
                    bookmarkvalue.put("PY60", Checknull(s.getString("FatherCareer")));
                    bookmarkvalue.put("PY62", Checknull(s.getString("FatherAddress")));
                    bookmarkvalue.put("PY63", Checknull(s.getString("FatherPhone")));
                    bookmarkvalue.put("PY65", Checknull(s.getString("MotherCareer")));
                    bookmarkvalue.put("PY67", Checknull(s.getString("MotherAddress")));
                    bookmarkvalue.put("PY68", Checknull(s.getString("MotherPhone")));
                    bookmarkvalue.put("PY69", Checknull(s.getString("ParentName")));
                   
                    /*
                      
                       bookmarkvalue.put("P02", Checknull(RankPolice));
                       bookmarkvalue.put("P03", Checknull(FirstName));
                       bookmarkvalue.put("P04", Checknull(LastName));
                       bookmarkvalue.put("P05", Checknull(Position));
*/
                        bookmarkvalue.put("P02", Checknull(s.getString("InvestRank")));
                        bookmarkvalue.put("P03", Checknull(s.getString("InvestName")));
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", Checknull(s.getString("InvestPosition")));
                        bookmarkvalue.put("P012", Checknull(s.getString("InvestRankFull"))); //ยศเต็ม
                        bookmarkvalue.put("P013", Checknull(s.getString("InvestPosition"))); //ตำแหน่งเต็ม
                       
                            bookmarkvalue.put("C8", Checknull(s.getString("CrimeLocation")));
                            bookmarkvalue.put("C9", Checknull(s.getString("CrimeLocationMoo")));
                            bookmarkvalue.put("C10", Checknull(s.getString("CrimeLocationSoi")));
                            bookmarkvalue.put("C11", Checknull(s.getString("CrimeLocationRoad")));
                            bookmarkvalue.put("C12", Checknull(s.getString("CrimeLocationDistrict")));
                            bookmarkvalue.put("C13", Checknull(s.getString("CrimeLocationAmphur")));
                            bookmarkvalue.put("C14", Checknull(s.getString("CrimeLocationProvince")));
             
			JSONArray tablecolumn = new JSONArray();

			JSONArray table1 = new JSONArray();
			JSONObject row1 = new JSONObject();

			table1.add(row1);

		JSONObject tableobj = new JSONObject();

		System.out.println(bookmarkvalue.toJSONString());  
		
		
            }
            try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w76.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
                        processTABLE(bookmarkvalue,wordMLPackage);
                        
                       
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/หนังสือแจ้งการดำเนินคดีเด็ก ฯ-ว "+suspectName+""+ cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            } catch (Exception e) {
                e.printStackTrace();
            }
        
              
	}

public static void nw76() {
     
                 JSONObject bookmarkvalue = new JSONObject();  
               

                 
                bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("CC2","");
                bookmarkvalue.put("C3", "");
                bookmarkvalue.put("S2","");
                            bookmarkvalue.put("C4","");
                            bookmarkvalue.put("C441","");
                            bookmarkvalue.put("C6", "");
                            bookmarkvalue.put("C661", "");
                            bookmarkvalue.put("C9", "");
                            bookmarkvalue.put("C10", "");
                            bookmarkvalue.put("C11", "");
                            bookmarkvalue.put("C12", "");
                            bookmarkvalue.put("C13", "");
                            bookmarkvalue.put("C14", "");
                            bookmarkvalue.put("C16", "");
                            
                    bookmarkvalue.put("A2", "");  
                    bookmarkvalue.put("B2", "");
                    
                    bookmarkvalue.put("PY7", ""); 
                    bookmarkvalue.put("PY13", ""); 
                    bookmarkvalue.put("PY15", ""); 
                    bookmarkvalue.put("PY16", "");
                    bookmarkvalue.put("PY17", "");
                    bookmarkvalue.put("PY24", ""); 
                    bookmarkvalue.put("PY25", ""); 
                    bookmarkvalue.put("PY26", "");
                    bookmarkvalue.put("PY31", "");
                    bookmarkvalue.put("PY32", "");
                    bookmarkvalue.put("PY33", "");
                    bookmarkvalue.put("PY34", ""); 
                    bookmarkvalue.put("PY35", ""); 
                    bookmarkvalue.put("PY40", ""); 
                    bookmarkvalue.put("PY60", ""); 
                    bookmarkvalue.put("PY62", ""); 
                    bookmarkvalue.put("PY63", ""); 
                    bookmarkvalue.put("PY65", ""); 
                    bookmarkvalue.put("PY67", ""); 
                    bookmarkvalue.put("PY68", ""); 
                    bookmarkvalue.put("PY69", ""); 
                    
                    
                    bookmarkvalue.put("PY104", ""); 
                    bookmarkvalue.put("PY105", ""); 
                    
                    
                        bookmarkvalue.put("P02", "");
                        bookmarkvalue.put("P03", "");
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", "");
                        bookmarkvalue.put("P012", "");
                        bookmarkvalue.put("P013", "");
                    
                  
                  
                         
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w76.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/หนังสือแจ้งการดำเนินคดีเด็ก ฯ-ว .doc"));
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
             Logger.getLogger(W76.class.getName()).log(Level.SEVERE, null, ex);
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
     public static String ChangFormat(String DateSue){
        String newFormatDate=null;
       try{   Calendar cal;
       Locale lc = new Locale("th","TH");
        SimpleDateFormat formatdate =new SimpleDateFormat("yyyy/MM/dd");     
        if(DateSue != null && !"".equals(DateSue)){
        Date b=formatdate.parse(DateSue);
         cal = Calendar.getInstance();
          cal.setTime(b); 
          System.out.println("fffffff : "+cal.getTime());
           SimpleDateFormat dateformat =new SimpleDateFormat("dd/MM/yyyy");   
         newFormatDate=dateformat.format(cal.getTime()); 
        
        }
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    
    }
       public static String ReplaceCollon(String inputTime){
                                        if(inputTime==null||inputTime==""||inputTime=="null") { return ""; }
					return  getThaiNumber(inputTime.replaceAll(":", "."));
					}
}

