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
import org.junit.internal.matchers.SubstringMatcher;

public class W711 {
	public static void w711(String cc) {
             Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
             
             String PoliceStationName="";
             String RankPolice ="";
             String FirstName ="";
             String LastName ="";
             String Position ="";
             
       
            String Date="";
            String Month="";
            String Year="";
            String Time="";
         
            
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
                    
                   String sql="select crimecase.*,Person.*,Charge.*,BailAsset.*\n" +
                              "from crimecase \n" +
                              "left join Person on crimecase.CaseId=Person.caseIdPerson\n" +
                              "left join Charge on crimecase.ChargeCodeCase=Charge.ChargeCode\n" +
                              "left join BailAsset on Person.caseIdPerson = BailAsset.BailCaseId\n" +
                              "where crimecase.CaseId='"+cc+"' and Person.Related='นายประกัน'\n" +
                              "group by crimecase.CaseId,Person.NoPerson,BailAsset.BailAssetId";
       
                   
            
            
            Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
            System.out.println(sql);
            
            JSONArray JSONArray = new JSONArray();
            while((s!=null) && (s.next()))
            {    
                    cs =s.getString("crimecaseno");
                    ccYear=s.getString("crimecaseyears");
                    casetype =s.getString("casetype");
            
                SimpleDateFormat sdfstart ;
                Calendar  calstart = Calendar.getInstance();
                sdfstart = new SimpleDateFormat("dd", new Locale("th", "TH"));  
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
                
		bookmarkvalue.put("C2",Checknull(cs));
                bookmarkvalue.put("C3",Checknull(ccYear));
                
                bookmarkvalue.put("S2",Checknull(PoliceStationName).substring(10));
                bookmarkvalue.put("S02",Checknull(PoliceStationName));
                
                bookmarkvalue.put("PA7",Checknull(s.getString("AccureandOther")));
                  
                bookmarkvalue.put("PS7",  Checknull(s.getString("SuspectandOther"))); 
               
                
                    bookmarkvalue.put("C12", Checknull(s.getString("CrimeLocationDistrict")));
                    bookmarkvalue.put("C13", Checknull(s.getString("CrimeLocationAmphur")));
                    bookmarkvalue.put("C14", Checknull(s.getString("CrimeLocationProvince")));
                    
                    
                bookmarkvalue.put("PB7",  Checknull(s.getString("FullNamePerson")));
                bookmarkvalue.put("PB13", Checknull(s.getString("Age")));
                bookmarkvalue.put("PB14", Checknull(s.getString("Nationality")));
                bookmarkvalue.put("PB15", Checknull(s.getString("Religion")));
                bookmarkvalue.put("PB22", Checknull(s.getString("HouseNumber"))); 
                bookmarkvalue.put("PB23", Checknull(s.getString("Moo"))); 
                bookmarkvalue.put("PB24", Checknull(s.getString("Tambon"))); 
                bookmarkvalue.put("PB25", Checknull(s.getString("Amphur"))); 
                bookmarkvalue.put("PB26", Checknull(s.getString("Province"))); 
                
                bookmarkvalue.put("B2", Checknull(s.getString("ChargeName")));
                      
                       bookmarkvalue.put("P02", Checknull(RankPolice));
                       bookmarkvalue.put("P03", Checknull(FirstName));
                       bookmarkvalue.put("P04", Checknull(LastName));
                       bookmarkvalue.put("P05", Checknull(Position));
                       
                       
                   ++BailAssetId ;
                   
               
                    
                     System.out.println(">>>>>"+BailAssetId);
			JSONArray tablecolumn = new JSONArray();
			tablecolumn.add("BA2");
			tablecolumn.add("BA3");
                        tablecolumn.add("BA4");
			tablecolumn.add("BA5");
                        tablecolumn.add("BA6");
			tablecolumn.add("BA7");
                       

			
			JSONObject row1 = new JSONObject();
			
			row1.put("BA2",Checknull(Integer.toString(BailAssetId)));
			row1.put("BA3",Checknull(s.getString("BailAssetDetail")));
                        row1.put("BA4",Checknull(s.getString("BailAssetBath")));
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

		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w71.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("C:/สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/คำร้องและสัญญาประกัน"+s.getString("FullNamePerson")+"" +cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
              
	}
public static void nw711() {
     
   
                 JSONObject bookmarkvalue = new JSONObject();
//              
                 bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("C3","");
                
                bookmarkvalue.put("S2","");
                 
                 bookmarkvalue.put("PA7","");
                 
                    bookmarkvalue.put("PS7",""); 
                   
                         
                    bookmarkvalue.put("B2","");
                     //ทรัพย์
                    
                    
                   
                    
                  bookmarkvalue.put("AS3","");
                  bookmarkvalue.put("AS4","");
                  bookmarkvalue.put("AS5","");
                  bookmarkvalue.put("AS6","");
                  bookmarkvalue.put("AS8","");
                  bookmarkvalue.put("AS9", "");
                  bookmarkvalue.put("AS10","");
                    
                    bookmarkvalue.put("AS331","");
                    bookmarkvalue.put("AS661","");
                    bookmarkvalue.put("AS1","");
                    
                    

			
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w11.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("C:/สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/บัญชีทรัพย์ของกลางคดีอาญา.doc"));
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
    	       SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));  
               SimpleDateFormat dateto  = new SimpleDateFormat("dd MMMM yyyy", new Locale("th", "TH"));  
               Date date=null;
               date = df.parse(strDate);               
               ResultDate=dateto.format(date.getTime());
         } catch (ParseException ex) {
             Logger.getLogger(W711.class.getName()).log(Level.SEVERE, null, ex);
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

