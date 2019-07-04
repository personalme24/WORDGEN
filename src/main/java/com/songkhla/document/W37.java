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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.docx4j.XmlUtils;
import org.docx4j.model.fields.merge.DataFieldName;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class W37 {
     public static void w37(String cc) {
     
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
             String ccYear;
             String PoliceStationName="";
             String StationAmphur="";
             String StationProvince="";
             String KK="";
             String BK="";
             String ProvincProsecutor="";
             String TelStation="";
             String RankPolice ="";
             String FirstName ="";
             String LastName ="";
             String Position ="";
             
             
            try {
//               
                    String sqlDataPoliceStation="SELECT * FROM PoliceStation";
                      Statement sp = conn.createStatement();
                  ResultSet rs=sp.executeQuery(sqlDataPoliceStation); 
                  while (rs.next()) {                    
                         PoliceStationName=rs.getString("PoliceStaionName");
                         KK=rs.getString("KK");
                         BK=rs.getString("BK");
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
                  
                   String sql="select crimecase.*,Charge.*,ActionsCase.*,Person.*\n" +
                               "from crimecase \n" +
                               "left join Charge on crimecase.ChargeCodeCase=Charge.ChargeCode\n" +
                                "left join Person on crimecase.CaseId=Person.caseIdPerson\n" +
                                "left join ActionsCase on crimecase.ActionCodeCase = ActionsCase.ActionCode\n"+
                                "where crimecase.CaseId='"+cc+"' and Person.TypePerson='ผู้ต้องหา'\n"+
                                "group by crimecase.CaseId";
                   
//                   pst=conn.prepareStatement(sql);
//           pst=PreparedStatement(sql);
                Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
                System.out.println(sql);
            while((s!=null) && (s.next()))
            {  String  
                    cs =s.getString("crimecaseno");
                    ccYear=s.getString("crimecaseyears");
//              
                 JSONObject bookmarkvalue = new JSONObject();
//                 bookmarkvalue.put("C1","Date");
//                 bookmarkvalue.put("S27","-");
		bookmarkvalue.put("C2",cs);
                
                bookmarkvalue.put("C3", ccYear);
                 bookmarkvalue.put("S2",PoliceStationName);
                 bookmarkvalue.put("S7", KK);
                 bookmarkvalue.put("S8", BK);
                 
                
                 bookmarkvalue.put("P7",  s.getString("FullNamePerson")); 
                 bookmarkvalue.put("P8",  s.getString("FullNamePersonEn")); 
                 bookmarkvalue.put("P9",  s.getString("OtherName"));
                 bookmarkvalue.put("P10",  s.getString("OtherSurname"));
                 bookmarkvalue.put("P11",  s.getString("BirthDay"));
                 bookmarkvalue.put("P12",  s.getString("FullNamePersonEn"));
                 bookmarkvalue.put("P13",  s.getString("Age"));
                 bookmarkvalue.put("P14",  s.getString("Race"));
                 bookmarkvalue.put("P15",  s.getString("Nationality"));
                 bookmarkvalue.put("P17",s.getString("Occupation"));
                 bookmarkvalue.put("P18",s.getString("Height"));
                 bookmarkvalue.put("P19",s.getString("Weight"));
                 bookmarkvalue.put("P20",s.getString("Weight"));
                 bookmarkvalue.put("P31",s.getString("FatherFullName"));
                 bookmarkvalue.put("P32",s.getString("MotherFullName"));
                 bookmarkvalue.put("P62",s.getString("FatherAddress"));
                 bookmarkvalue.put("P67",s.getString("MotherAddress"));
                 bookmarkvalue.put("P76",s.getString("Office"));
                 bookmarkvalue.put("P77",s.getString("SpouseFullName"));
                 bookmarkvalue.put("P79",s.getString("FriendAddress"));
                 bookmarkvalue.put("P80",s.getString("FavouritePlace"));
                  
                   
                      bookmarkvalue.put("A2", s.getString("ActionCrimes"));  
                      bookmarkvalue.put("B2", s.getString("ChargeName"));
                      
                      
                        bookmarkvalue.put("P02", RankPolice);
                        bookmarkvalue.put("P03", FirstName);
                        bookmarkvalue.put("P04", LastName);
                        bookmarkvalue.put("P05", Position);
                         
                            bookmarkvalue.put("C4", s.getString("OccuredDate"));
                            bookmarkvalue.put("C411", s.getString("OccuredTime"));
                            bookmarkvalue.put("C5", s.getString("CaseAcceptDate"));
                            bookmarkvalue.put("C511", s.getString("CaseAccepTime"));
                            bookmarkvalue.put("C6", s.getString("CaseRequestDate"));
                            bookmarkvalue.put("C611", s.getString("CaseRequestTime"));
                            bookmarkvalue.put("C8", s.getString("CrimeLocation"));
                            bookmarkvalue.put("C9", s.getString("CrimeLocationMoo"));
                            bookmarkvalue.put("C10", s.getString("CrimeLocationSoi"));
                            bookmarkvalue.put("C11", s.getString("CrimeLocationRoad"));
                            bookmarkvalue.put("C12", s.getString("CrimeLocationDistrict"));
                            bookmarkvalue.put("C13", s.getString("CrimeLocationAmphur"));
                            bookmarkvalue.put("C14", s.getString("CrimeLocationProvince"));
                            bookmarkvalue.put("C15", s.getString("DailyNumber"));
                            
                    
                   
    
			JSONArray tablecolumn = new JSONArray();
			tablecolumn.add("C2");
			tablecolumn.add("C3");
//			tablecolumn.add("SUSPECT");
//			tablecolumn.add("VICTIM");
//			tablecolumn.add("REMARK");
			JSONArray table1 = new JSONArray();
			JSONObject row1 = new JSONObject();
			row1.put("C2",cs);
			row1.put("C3", ccYear);
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
		tableobj.put("COLUMNS", tablecolumn);
		tableobj.put("TABLEDATA", table1);
			
		JSONArray TABLES = new JSONArray();
		TABLES.add(tableobj);
		bookmarkvalue.put("TABLES", TABLES);
		System.out.println(bookmarkvalue.toJSONString());
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("D:/TEMPLATE/w37.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("D:/เอกสารสำนวนคดี "+cc+"/ตำหนิรูปพรรณผู้กระทำความผิด "+cc+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
            } catch (Exception e) {
                e.printStackTrace();
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
    
    
}
