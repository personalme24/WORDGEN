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
import static com.songkhla.document.W5.Checknull;
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

public class W23 {
public static void w23(String cc) {
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
            
            String ccYear;
            String casetype;
            String caseno;
             String PoliceStationName="";
             String StationAmphur="";
             String StationProvince="";
             String ProvincProsecutor="";
             String TelStation="";
             String RankPolice ="";
             String FirstName ="";
             String LastName ="";
             String Position ="";
            try {
                
                 String sqlDataPoliceStation="SELECT * FROM PoliceStation";
                      Statement sp = conn.createStatement();
                  ResultSet rs=sp.executeQuery(sqlDataPoliceStation); 
                  while (rs.next()) {                    
                         PoliceStationName=rs.getString("PoliceStaionName");
                         StationAmphur=rs.getString("StationAmphur");
                         StationProvince=rs.getString("StationProvince");
                         ProvincProsecutor=rs.getString("ProvincProsecutor");
                         TelStation=rs.getString("TelStation");
                      }
            
                    String sqlDataPolice="SELECT * FROM Police";
                      Statement sp1 = conn.createStatement();
                  ResultSet rs1=sp1.executeQuery(sqlDataPolice); 
                  while (rs1.next()) {                    
                         RankPolice =rs1.getString("RankPolice");
                         FirstName=rs1.getString("FirstName");
                         LastName=rs1.getString("LastName");
                         Position=rs1.getString("Position");
                      }
//                

                   String sql="select crimecase.*,Person.*,ChargeCase.*,InvestInformation.*\n" +
                              "from crimecase \n" +
                              "left join ChargeCase on crimecase.caseid=ChargeCase.ChargeCaseid\n" +
                              "left join Person on crimecase.CaseId=Person.caseIdPerson\n" +
                              "left join InvestInformation on crimecase.PoliceNameCase=InvestInformation.InvestId \n" +
                              "where crimecase.CaseId='"+cc+"'and Person.TypePerson='ผู้ตาย'\n" +
                              "group by crimecase.CaseId,Person.NoPerson";

                Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
                System.out.println(sql);
                
            while((s!=null) && (s.next()))
            {  String  cs =s.getString("crimecaseno");
                 ccYear=s.getString("crimecaseyears");
                 casetype=s.getString("casetype");
                 caseno  =s.getString("crimecasenoyear");
                String Date="";
                String Month="";
                String Year="";
                SimpleDateFormat sdfstart ;
                Calendar  calstart = Calendar.getInstance();
                sdfstart = new SimpleDateFormat("d", new Locale("th", "TH"));  
               Date =sdfstart.format(calstart.getTime());
              
               sdfstart = new SimpleDateFormat("MMMM", new Locale("th", "TH"));  
               Month=sdfstart.format(calstart.getTime());
               
               sdfstart = new SimpleDateFormat("yyyy", new Locale("th", "TH"));  
               Year=sdfstart.format(calstart.getTime());
                 
//                System.out.print("ข้อหา :: "+s.getString("ChargeCode"));
//                System.out.print(" - ");
                 JSONObject bookmarkvalue = new JSONObject();
//              
                bookmarkvalue.put("C1",Checknull(Date));
                bookmarkvalue.put("C01",Checknull(Month));
                bookmarkvalue.put("C001",Checknull(Year));
                 bookmarkvalue.put("CC2",Checknull(caseno));
		bookmarkvalue.put("C2",Checknull(cs));
                bookmarkvalue.put("C3", Checknull(ccYear));
                bookmarkvalue.put("S2",Checknull(PoliceStationName).substring(10));
                 bookmarkvalue.put("S5", Checknull(StationAmphur));
                 bookmarkvalue.put("S6", Checknull(StationProvince));
                 bookmarkvalue.put("S10",Checknull(TelStation));
                 bookmarkvalue.put("S27",Checknull(ProvincProsecutor));
                   
//              
//                   ----------------------------ผู้ตาย--------------------
                   
                    bookmarkvalue.put("PD7", Checknull(s.getString("FullNamePerson"))); 
                    bookmarkvalue.put("PD12", Checknull(s.getString("Gender")));
                    bookmarkvalue.put("PD13", Checknull(s.getString("Age")));
                    bookmarkvalue.put("PD14", Checknull(s.getString("Race")));
                    bookmarkvalue.put("PD15", Checknull(s.getString("Nationality")));
                    bookmarkvalue.put("PD16", Checknull(s.getString("Religion")));
                    bookmarkvalue.put("PD17", Checknull(s.getString("Occupation")));
                    bookmarkvalue.put("PD22", Checknull(s.getString("HouseNumber")));
                    bookmarkvalue.put("PD23", Checknull(s.getString("Moo")));
                    bookmarkvalue.put("PD24", Checknull(s.getString("Tambon")));
                    bookmarkvalue.put("PD25", Checknull(s.getString("Amphur")));
                    bookmarkvalue.put("PD26", Checknull(s.getString("Province")));
                    bookmarkvalue.put("PD29", Checknull(s.getString("HeadmanName")));
                    bookmarkvalue.put("PD30", Checknull(s.getString("SubHeadmanName")));
                    bookmarkvalue.put("PD31", Checknull(s.getString("FatherFullName")));
                    bookmarkvalue.put("PD32", Checknull(s.getString("MotherFullName")));
                    bookmarkvalue.put("PD45", Checknull(s.getString("DeathLocation")));
                    bookmarkvalue.put("PD46", Checknull(s.getString("TambomDie")));
                    bookmarkvalue.put("PD47", Checknull(s.getString("AmphurDie")));
                    bookmarkvalue.put("PD48", Checknull(s.getString("ProvinceDie")));
                    bookmarkvalue.put("PD49", Checknull(s.getString("PlaceOfFoundBody")));
                    bookmarkvalue.put("PD50", Checknull(s.getString("TambomFoundBody")));
                    bookmarkvalue.put("PD51", Checknull(s.getString("AmphurFoundBody")));
                    bookmarkvalue.put("PD52", Checknull(s.getString("ProvinceFoundBody")));
                    bookmarkvalue.put("PD53", "เหตุที่ตายคือ "+Checknull(s.getString("CauseDead")));
                    bookmarkvalue.put("PD83", Checknull(ToDate(s.getString("DateOfDie")))+" เวลา "+ReplaceCollon(s.getString("TimeOfDie")));
                    bookmarkvalue.put("PD84", Checknull(ToDate(s.getString("BodyFoundDate")))+" เวลา "+ReplaceCollon(s.getString("BodyFoundTime")));
                    

                       bookmarkvalue.put("C59","โดย "+Checknull(s.getString("CircumstancesOfDeath")));
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
                        

			JSONArray tablecolumn = new JSONArray();
//			tablecolumn.add("P03");
//			tablecolumn.add("P02");
//			tablecolumn.add("SUSPECT");
//			tablecolumn.add("VICTIM");
//			tablecolumn.add("REMARK");
			JSONArray table1 = new JSONArray();
			JSONObject row1 = new JSONObject();

			table1.add(row1);
			

		JSONObject tableobj = new JSONObject();

		System.out.println(bookmarkvalue.toJSONString());
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w23.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/รายงานการชันสูตรพลิกศพ"+s.getString("FullNamePerson")+"" +cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
              
	}
public static void nw23() {
        
                 JSONObject bookmarkvalue = new JSONObject();
//              
                bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
                bookmarkvalue.put("CC2","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("C3","");
                
                bookmarkvalue.put("S2","");
                bookmarkvalue.put("S5","");
                bookmarkvalue.put("S6","");
                bookmarkvalue.put("S27","");
                bookmarkvalue.put("S10","");
                
                bookmarkvalue.put("PA7","");
             
                    bookmarkvalue.put("PD2", ""); 
                    bookmarkvalue.put("PD3",""); 
                    bookmarkvalue.put("PD5", ""); 
                    bookmarkvalue.put("PD7", ""); 
                    bookmarkvalue.put("PD12", "");
                    bookmarkvalue.put("PD13", "");
                    bookmarkvalue.put("PD14","");
                    bookmarkvalue.put("PD15", "");
                    bookmarkvalue.put("PD16", "");
                    bookmarkvalue.put("PD17", "");
                    bookmarkvalue.put("PD22", "");
                    bookmarkvalue.put("PD23", "");
                    bookmarkvalue.put("PD24", "");
                    bookmarkvalue.put("PD25", "");
                    bookmarkvalue.put("PD26", "");
                    bookmarkvalue.put("PD29", "");
                    bookmarkvalue.put("PD30", "");
                    bookmarkvalue.put("PD31", "");
                    bookmarkvalue.put("PD32", "");
                    bookmarkvalue.put("PD45", "");
                    bookmarkvalue.put("PD46", "");
                    bookmarkvalue.put("PD47", "");
                    bookmarkvalue.put("PD48", "");
                    bookmarkvalue.put("PD49", "");
                    bookmarkvalue.put("PD50", "");
                    bookmarkvalue.put("PD51", "");
                    bookmarkvalue.put("PD52", "");
                    bookmarkvalue.put("PD53", "");
                    bookmarkvalue.put("PD83", "");
                    bookmarkvalue.put("PD84", "");

                       bookmarkvalue.put("C59","");
                     

                      bookmarkvalue.put("B2", "");
                      
                        bookmarkvalue.put("P02", "");
                        bookmarkvalue.put("P03", "");
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", "");
                        bookmarkvalue.put("P012", "");
                        bookmarkvalue.put("P013", "");
                    

		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w23.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/รายงานการชันสูตรพลิกศพ.doc"));
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
             Logger.getLogger(W23.class.getName()).log(Level.SEVERE, null, ex);
         }
               return ResultDate;
}
public static String Checknull(String input){
					if(input==null||input==""||input=="null") { return ""; }
					return getThaiNumber(input);
					}
      public static String ReplaceCollon(String inputTime){
                                        if(inputTime==null||inputTime==""||inputTime=="null") { return ""; }
					return  getThaiNumber(inputTime.replaceAll(":", "."));
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
}

