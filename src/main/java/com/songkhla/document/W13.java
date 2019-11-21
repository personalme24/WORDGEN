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

public class W13 {
    public static void w13(String cc) {
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
            String ccYear;
            String casetype;
            String caseno;
            String PoliceStationName="";
            
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
            
//                String ch;
//                   String sql="SELECT * from CrimeCase Where crimecaseno = '"+cc+"'";
                   String sql="select crimecase.*,ChargeCase.*,Asset.*,P1.*,P2.*,InvestInformation.*\n" +
                                "from crimecase inner join(\n" +
                                "SELECT  min(Person.NoPerson),Person.FullNamePerson AccuredName,Person.Age AgeAccured,Person.Race AccuredRace,Person.Nationality AccuredNati "
                            +   "FROM Person where Person.TypePerson='ผู้กล่าวหา'\n" +
                                ")P1\n" +
                                "inner join(\n" +
                                "SELECT min(Person.NoPerson),Person.FullNamePerson suspectName,Person.Age suspectAge,Person.Amphur suspectAmp,Person.Race suspectRace\n"+
                                "FROM Person where Person.TypePerson='ผู้ต้องหา'\n" +
                                ")P2\n" +
                                "left join ChargeCase on crimecase.caseid=ChargeCase.Chargecaseid\n" +
                                "left join Person on crimecase.CaseId=Person.caseIdPerson\n" +
                                "left join Asset  on crimecase.CaseId=Asset.caseIdAsset\n" +
                                "left join InvestInformation on crimecase.PoliceNameCase=InvestInformation.InvestId \n" +
                                "where crimecase.CaseId='"+cc+"' and Asset.StatusAsset='ได้คืน'\n" +
                                "group by crimecase.CaseId,Asset.NoAsset";
//                   pst=conn.prepareStatement(sql);
//           pst=PreparedStatement(sql);
                Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
                System.out.println(sql);
          
            int OrderAsset=0;
            int SumValue=0;
            JSONArray JSONArray = new JSONArray();
            
            
            
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
                 

                 JSONObject bookmarkvalue = new JSONObject();
//              
                bookmarkvalue.put("C1",Checknull(Date));
                bookmarkvalue.put("C01",Checknull(Month));
                bookmarkvalue.put("C001",Checknull(Year));
                bookmarkvalue.put("CC2",Checknull(caseno));
		bookmarkvalue.put("C2",Checknull(cs));
                bookmarkvalue.put("C3",Checknull(ccYear));
                bookmarkvalue.put("S2",Checknull(PoliceStationName).substring(10));
                 
                 bookmarkvalue.put("PA7",Checknull(s.getString("AccureandOther")));
                 
                    bookmarkvalue.put("PS7",Checknull(s.getString("SuspectandOther"))); 
                   
                         
                    bookmarkvalue.put("B2",Checknull((s.getString("ChargeNameCase"))));
                    /*
                     //ทรัพย์
                    VarAS1=VarAS1+"\n\r"+s.getString("EvidenceRecordNumber");
                    bookmarkvalue.put("AS1",Checknull(VarAS1));
                   
                    
                    ++OrderAsset ;
                    VarAS3=VarAS3+"\n\r"+(OrderAsset);
                    bookmarkvalue.put("AS3",Checknull(VarAS3));
                    
                    
                    VarAS4=VarAS4+"\n\r"+s.getString("Name");
                    bookmarkvalue.put("AS4",Checknull(VarAS4));
                    VarAS5=VarAS5+"\n\r"+s.getString("Amount");
                    bookmarkvalue.put("AS5",Checknull(VarAS5));
                    
                    
                    VarAS6=VarAS6+"\n\r"+s.getString("Value");
                    bookmarkvalue.put("AS6",Checknull(VarAS6));
                    if (s.getString("Value") != null)
                    {
                    SumValue = SumValue+s.getInt("Value");
                    } 
                    VarAS8=VarAS8+"\n\r"+s.getString("OccupantName");
                    bookmarkvalue.put("AS8", Checknull(VarAS8));
                    VarAS9=VarAS9+"\n\r"+s.getString("DateSequester");
                    bookmarkvalue.put("AS9", Checknull(VarAS9));
                    VarAS10=VarAS10+"\n\r"+s.getString("Remark");
                    bookmarkvalue.put("AS10",Checknull(VarAS10));
                    bookmarkvalue.put("AS331",Checknull(Integer.toString(OrderAsset)));
                    bookmarkvalue.put("AS661",Checknull(Integer.toString(SumValue)));
                    
                    */
         ++OrderAsset ;
                   
                String[]   Value1 = s.getString("Value").split(" ");
                System.out.println(">>>>>"+Arrays.toString(Value1));
                String a=Value1[0];
                
                String   Value = a.replace (",", "");
                System.out.println(">>>>>"+Value);
                   
                    if ((Value) != null){
                        if (Value.equals("")){
                            Value="0";
                        }
                    SumValue = SumValue+Integer.parseInt(Value);
                    } 
                    bookmarkvalue.put("AS331",Checknull(Integer.toString(OrderAsset)));
                    bookmarkvalue.put("AS661",Checknull(regexCommafy(Integer.toString(SumValue))));
                    bookmarkvalue.put("AS1",Checknull(s.getString("EvidenceRecordNumber")));
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
			System.out.println(">>>>"+OrderAsset);
			tablecolumn.add("AS3");
                        tablecolumn.add("AS4");
			tablecolumn.add("AS5");
                        tablecolumn.add("AS6");
			tablecolumn.add("AS8");
                        tablecolumn.add("AS9");
			tablecolumn.add("AS10");
                       

			JSONObject row1 = new JSONObject();
			
			
			row1.put("AS3",Checknull(Integer.toString(OrderAsset)));
                        row1.put("AS4",Checknull(s.getString("Name")));
                        row1.put("AS5",Checknull(s.getString("Amount")));
                        row1.put("AS6",Checknull(s.getString("Value")));
                        row1.put("AS8",Checknull(s.getString("OccupantName")));
                        row1.put("AS9",Checknull(ToDate(s.getString("DateSequester"))));
                        row1.put("AS10",Checknull(s.getString("Remark")));
                        
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
					.load(new java.io.File("./TEMPLATE/w13.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/บัญชีทรัพย์ถูกประทุษร้ายได้คืน" +cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
              
	}
public static void nw13() {
     
   
                 JSONObject bookmarkvalue = new JSONObject();
//              
                 bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
                bookmarkvalue.put("CC2","");
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
                    
                       bookmarkvalue.put("P02", "");
                       bookmarkvalue.put("P03", "");
                       bookmarkvalue.put("P04", "");
                       bookmarkvalue.put("P05", "");
                       bookmarkvalue.put("P012", "");
                       bookmarkvalue.put("P013", "");

		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w13.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/บัญชีทรัพย์ถูกประทุษร้ายได้คืน.doc"));
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
             Logger.getLogger(W13.class.getName()).log(Level.SEVERE, null, ex);
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
