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

public class W75 {

public static void nw75() {
     
                 JSONObject bookmarkvalue = new JSONObject();  
               

                 
                bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("CC2","");
                bookmarkvalue.put("C3", "");
                bookmarkvalue.put("S2","");
                 
                    bookmarkvalue.put("PL7", "");
                    bookmarkvalue.put("PL22", "");
                    bookmarkvalue.put("PL23", "");
                    bookmarkvalue.put("PL24", "");
                    bookmarkvalue.put("PL25", "");
                    bookmarkvalue.put("PL26", "");
                    bookmarkvalue.put("PL104", "");
                    bookmarkvalue.put("PL105", "");
                    
                    bookmarkvalue.put("PY7", ""); 
                    bookmarkvalue.put("PY13", ""); 
                    bookmarkvalue.put("PY15", ""); 
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
                    bookmarkvalue.put("PY71", ""); 
                    bookmarkvalue.put("PY73", ""); 
                    bookmarkvalue.put("PY74", ""); 
                    
                    
                    bookmarkvalue.put("PY104", ""); 
                    bookmarkvalue.put("PY105", ""); 
                    
                    
                        bookmarkvalue.put("P02", "");
                        bookmarkvalue.put("P03", "");
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", "");
                    
                  
                  
                         
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w72.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/บันทึกการสอบถามเบื้องต้น(เด็ก).doc"));
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
             Logger.getLogger(W75.class.getName()).log(Level.SEVERE, null, ex);
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
}

