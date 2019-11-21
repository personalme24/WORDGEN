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

public class W9 {
public static void w9(String cc) {
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
             String HeadName ="";
             String HeadPosition="";
             String HeadRankFull="";
             int OrderPerson=0;
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
                         HeadName=rs.getString("HeadName");
                         HeadPosition = rs.getString("HeadPosition");
                         HeadRankFull=rs.getString("HeadRankFull");
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

                   String sql="select crimecase.*,Person.*,ChargeCase.*,ActionsCaseData.*,InvestInformation.*\n" +
                              "from crimecase \n" +
                              "left join ChargeCase on crimecase.caseid=ChargeCase.ChargeCaseid\n" +
                              "left join Person on crimecase.CaseId=Person.caseIdPerson\n" +
                              "left join ActionsCaseData on crimecase.ActionCodeCase = ActionsCaseData.ActionCodeCase\n"+
                              "left join InvestInformation on crimecase.PoliceNameCase=InvestInformation.InvestId \n" +
                              "where crimecase.CaseId='"+cc+"'and Person.TypePerson='ผู้ต้องหา'\n" +
                              "group by crimecase.CaseId,Person.NoPerson";

                Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
                System.out.println(sql);
            while((s!=null) && (s.next()))
            {  String  cs =s.getString("crimecaseno");
                 ccYear=s.getString("crimecaseyears");
                 casetype =s.getString("casetype");
                 caseno  =s.getString("crimecasenoyear");
                 OrderPerson =s.getInt("OrderPerson");
                 
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
		bookmarkvalue.put("C2",Checknull(cs));
                bookmarkvalue.put("C3",Checknull(ccYear));
                 bookmarkvalue.put("CC2",Checknull(caseno));
                bookmarkvalue.put("S2",Checknull(PoliceStationName).substring(10));
                bookmarkvalue.put("S02",Checknull(PoliceStationName));
                bookmarkvalue.put("S5", Checknull(StationAmphur));
                bookmarkvalue.put("S6", Checknull(StationProvince));
                bookmarkvalue.put("S27",Checknull(ProvincProsecutor));
                bookmarkvalue.put("S10",Checknull(TelStation));
                bookmarkvalue.put("S13",Checknull(HeadName));
                bookmarkvalue.put("S14",Checknull(HeadPosition));
                bookmarkvalue.put("S34",Checknull(HeadRankFull));
                   
//                   ----------------------------ผู้กล่าวหา--------------------
               
                bookmarkvalue.put("PA7",Checknull(s.getString("AccureandOther")));
               
                 bookmarkvalue.put("A5", Checknull(s.getString("AnswerSuspectCase")));
                 bookmarkvalue.put("A3", Checknull(s.getString("ActionDetailCase")));
                
//                   ----------------------------ผู้ต้องหา--------------------
                    if ((OrderPerson) == 1)
                    {
                       bookmarkvalue.put("TYPS","ผู้ต้องหา"); 
                    }else {bookmarkvalue.put("TYPS","ผู้ต้องหาคนที่ "+OrderPerson); }
                    
                    bookmarkvalue.put("PS2", Checknull(s.getString("PeopleRegistrationID"))); 
                    bookmarkvalue.put("PS3",Checknull(ToDate(s.getString("IssueDate")))); 
                    bookmarkvalue.put("PS5",Checknull(s.getString("IssuedBy"))); 
                    bookmarkvalue.put("PS7", Checknull(s.getString("FullNamePerson"))); 
                    bookmarkvalue.put("PS13", Checknull(s.getString("Age")));
                    bookmarkvalue.put("PS14", Checknull(s.getString("Race")));
                    bookmarkvalue.put("PS15", Checknull(s.getString("Nationality")));
                    bookmarkvalue.put("PS16", Checknull(s.getString("Religion")));
                    bookmarkvalue.put("PS17", Checknull(s.getString("Occupation")));
                    bookmarkvalue.put("PS22", Checknull(s.getString("HouseNumber")));
                    bookmarkvalue.put("PS23", Checknull(s.getString("Moo")));
                    bookmarkvalue.put("PS24", Checknull(s.getString("Tambon")));
                    bookmarkvalue.put("PS25", Checknull(s.getString("Amphur")));
                    bookmarkvalue.put("PS26", Checknull(s.getString("Province")));
                    bookmarkvalue.put("PS28", Checknull(s.getString("PhonePerson"))); 
                    bookmarkvalue.put("PS29", Checknull(s.getString("HeadmanName")));
                    bookmarkvalue.put("PS30", Checknull(s.getString("SubHeadmanName")));
                    bookmarkvalue.put("PS31", Checknull(s.getString("FatherFullName")));
                    bookmarkvalue.put("PS32", Checknull(s.getString("MotherFullName")));
                    bookmarkvalue.put("PS33", Checknull(s.getString("TambonBirthday")));
                    bookmarkvalue.put("PS34", Checknull(s.getString("AmphurBirthday")));
                    bookmarkvalue.put("PS35", Checknull(s.getString("ProvinceBirthday")));
                    bookmarkvalue.put("PS75", Checknull(s.getString("TypePerson")));
                    bookmarkvalue.put("PS124", "");
                    bookmarkvalue.put("PS133", Checknull(s.getString("AnswerPerson")));
                    
                            bookmarkvalue.put("C4",Checknull(ToDate(s.getString("OccuredDate"))));
                            bookmarkvalue.put("C441", ReplaceCollon(s.getString("OccuredTime")));
                            bookmarkvalue.put("C5", Checknull(ToDate(s.getString("CaseAcceptDate"))));
                            bookmarkvalue.put("C551",Checknull(ReplaceCollon(s.getString("CaseAccepTime"))));
                            bookmarkvalue.put("C8", Checknull(s.getString("CrimeLocation")));
                            bookmarkvalue.put("C9", Checknull(s.getString("CrimeLocationMoo")));
                            bookmarkvalue.put("C10", Checknull(s.getString("CrimeLocationSoi")));
                            bookmarkvalue.put("C11", Checknull(s.getString("CrimeLocationRoad")));
                            bookmarkvalue.put("C12", Checknull(s.getString("CrimeLocationDistrict")));
                            bookmarkvalue.put("C13", Checknull(s.getString("CrimeLocationAmphur")));
                            bookmarkvalue.put("C14", Checknull(s.getString("CrimeLocationProvince")));
                    
                    
                    bookmarkvalue.put("PS001", Checknull(s.getString("CrimeLocation"))+" ต."+Checknull(s.getString("CrimeLocationDistrict"))+" อ."+Checknull(s.getString("CrimeLocationAmphur"))+" จ."+Checknull(s.getString("CrimeLocationProvince")));
                    bookmarkvalue.put("PS002", Checknull(ToDate(s.getString("OccuredDate")))+" เวลา "+ReplaceCollon(s.getString("OccuredTime"))+" น.");
                  
                      bookmarkvalue.put("B2", Checknull(s.getString("ChargeNameCase")));
                  
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
//			row1.put("P03","-");
//			row1.put("P02", ccYear);
//			row1.put("SUSPECT", "period1");
//			row1.put("VICTIM", "period1");
//			row1.put("REMARK", "period1");
			table1.add(row1);
			
//			JSONObject repl2 = new JSONObject();
//			repl2.put("CRIMESNO", "function1");
//			repl2.put("DESCRIPTION", "desc1");
//			repl2.put("SUSPECT", "period1");
//			repl2.put("VICTIM", "period1");
//			repl2.put("REMARK", "period1");
//			table1.add(repl2);
		JSONObject tableobj = new JSONObject();
//		tableobj.put("COLUMNS", tablecolumn);
//		tableobj.put("TABLEDATA", table1);
			
//		JSONArray TABLES = new JSONArray();
//		TABLES.add(tableobj);
//		bookmarkvalue.put("TABLES", TABLES);
		System.out.println(bookmarkvalue.toJSONString());
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w9.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/บันทึกคำให้การผู้ต้องหา "+s.getString("FullNamePerson")+"" +cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
              
	}
public static void nw9( ) {
        
                 JSONObject bookmarkvalue = new JSONObject();
//              
                bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("C3","");
                bookmarkvalue.put("CC2","");
                bookmarkvalue.put("S2","");
                bookmarkvalue.put("S02","");
                bookmarkvalue.put("S5","");
                bookmarkvalue.put("S6","");
                bookmarkvalue.put("S27","");
                bookmarkvalue.put("S10","");
                 bookmarkvalue.put("S13","");
                bookmarkvalue.put("S14","");
                bookmarkvalue.put("S34","");
                   
//                   ----------------------------ผู้กล่าวหา--------------------
               
                bookmarkvalue.put("PA7","");
               
                 bookmarkvalue.put("A3","");
                 bookmarkvalue.put("A5","");
                
//                   ----------------------------ผู้ต้องหา--------------------
                    bookmarkvalue.put("PS2", ""); 
                    bookmarkvalue.put("PS3",""); 
                    bookmarkvalue.put("PS5",""); 
                    bookmarkvalue.put("PS7",""); 
                    bookmarkvalue.put("PS13", "");
                    bookmarkvalue.put("PS14","");
                    bookmarkvalue.put("PS15","");
                    bookmarkvalue.put("PS16","");
                    bookmarkvalue.put("PS17","");
                    bookmarkvalue.put("PS22","");
                    bookmarkvalue.put("PS23","");
                    bookmarkvalue.put("PS24","");
                    bookmarkvalue.put("PS25","");
                    bookmarkvalue.put("PS26","");
                    bookmarkvalue.put("PS28","");
                    bookmarkvalue.put("PS29","");
                    bookmarkvalue.put("PS30","");
                    bookmarkvalue.put("PS31","");
                    bookmarkvalue.put("PS32","");
                    bookmarkvalue.put("PS33","");
                    bookmarkvalue.put("PS34","");
                    bookmarkvalue.put("PS35","");
                    bookmarkvalue.put("PS75","");
                    bookmarkvalue.put("PS124","");
                    bookmarkvalue.put("PS133","");
                    bookmarkvalue.put("PS001","");
                    bookmarkvalue.put("PS002","");
                     

                      bookmarkvalue.put("B2","");
                      
                        bookmarkvalue.put("P02", "");
                        bookmarkvalue.put("P03", "");
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", "");
                        bookmarkvalue.put("P012", "");
                        bookmarkvalue.put("P013", "");
                   
                            bookmarkvalue.put("C4","");
                            bookmarkvalue.put("C441", "");
                            bookmarkvalue.put("C12","");
                            bookmarkvalue.put("C5", "");
                            bookmarkvalue.put("C551","");
                            bookmarkvalue.put("C8","");
                            bookmarkvalue.put("C9","");
                            bookmarkvalue.put("C10","");
                            bookmarkvalue.put("C11","");
                            bookmarkvalue.put("C12","");
                            bookmarkvalue.put("C13","");
                            bookmarkvalue.put("C14","");
    
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w9.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/บันทึกคำให้การผู้ต้องหา.doc"));
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
             Logger.getLogger(W9.class.getName()).log(Level.SEVERE, null, ex);
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
      public static String ReplaceCollon(String inputTime){
                                        if(inputTime==null||inputTime==""||inputTime=="null") { return ""; }
					return  getThaiNumber(inputTime.replaceAll(":", "."));
					}
}

