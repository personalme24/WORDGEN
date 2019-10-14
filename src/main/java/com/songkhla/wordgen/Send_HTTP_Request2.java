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
import static com.songkhla.wordgen.CaseSelectOverView.NewDate;
import static com.songkhla.wordgen.CaseSelectOverView.NewTime;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Date;

import org.xml.sax.InputSource;
//import org.json.simple.JSONObject;
//import org.json.JSONObject;
public class Send_HTTP_Request2 {
	public static void main(String[] args) {
     try {
//         Send_HTTP_Request2.call_me();
//           String url=  "http://172.31.191.163:8383/wordgenauthen/?USER=TNCTUK&PASS=12345678";
//                  String fff =sendGET(url);
//                  System.out.println(sendGET(url));
                 test();
        } catch (Exception e) {
         e.printStackTrace();
       }
     }
	   
public static void call_me() throws Exception {
     String statusconnect,idcard,fullname,firstname,lastname,rank,rankcode,position,email,positioncode;
        String stationname,orgcode,startdate,enddate,initialname,address,province,amphur,tambon,zipcode,bk,bh,birthday,age,mobilephone;
     String url = "http://172.31.191.163:8383/wordgenauthen/?USER=TNCTUK&PASS=12345678";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("GET");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     System.out.println("\nSending 'GET' request to URL : " + url);
     System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     System.out.println(response.toString());
     //Read JSON response and print
     JSONObject myResponse = new JSONObject(response.toString());
     System.out.println("result after Reading JSON Response");
     System.out.println("statusconnect- "+myResponse.getString("statusconnect"));
     System.out.println("statusMessage- "+myResponse.getString("idcard"));
//     System.out.println("ipAddress- "+myResponse.getString("ipAddress"));
//     System.out.println("countryCode- "+myResponse.getString("countryCode"));
//     System.out.println("countryName- "+myResponse.getString("countryName"));
//     System.out.println("regionName- "+myResponse.getString("regionName"));
//     System.out.println("cityName- "+myResponse.getString("cityName"));
//     System.out.println("zipCode- "+myResponse.getString("zipCode"));
//     System.out.println("latitude- "+myResponse.getString("latitude"));
//     System.out.println("longitude- "+myResponse.getString("longitude"));
//     System.out.println("timeZone- "+myResponse.getString("timeZone"));  
       

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
 public static void call_me22() throws Exception {
     URL url = new URL ("http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen/");
     HttpURLConnection con = (HttpURLConnection)url.openConnection();
     con.setRequestMethod("POST");
     con.setRequestProperty("Content-Type", "application/json; utf-8");
//     con.setRequestProperty("Accept", "application/json");
     con.setDoOutput(true);
     JSONObject jsonInput = new JSONObject();
     jsonInput.put("PersonalityID", "1100700943266");
//     jsonInput.put("caseno", "20");
//     jsonInput.put("caseyear", "20");
//     jsonInput.put("startaccept", "20");
//     jsonInput.put("endaccepr", "20");
//     jsonInput.put("personcard", "20");
     String j=jsonInput.toString();
     System.out.println(j);
//     String jsonInputString = "{"name": "Upendra", "job": "Programmer"}";
     try(OutputStream os = con.getOutputStream()) {
    byte[] input = j.getBytes("utf-8");
    os.write(input, 0, input.length);       
    try(BufferedReader in = new BufferedReader( new InputStreamReader(con.getInputStream(), "utf-8"))) {
	 String inputLine;
	 StringBuffer response = new StringBuffer();
	 while ((inputLine = in.readLine()) != null) {
	   response.append(inputLine);
	 }
         String str = response.toString();
	in.close();
        List<String> output = getFullNameFromXml(str, "isCapital");
String[] strarray = new String[output.size()];
output.toArray(strarray);
System.out.print("Response Array is "+Arrays.toString(strarray));
	//print in String
	// System.out.println(response.toString());
//        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//         .parse(new InputSource(new StringReader(response.toString())));
//	       NodeList errNodes = doc.getElementsByTagName("CrimeCases");
//        if (errNodes.getLength() > 0) {
//            Element err = (Element)errNodes.item(0);
//          System.out.println("raw_offset -"+err.getElementsByTagName("isCapital").item(0).getTextContent());
////	  System.out.println("dst_offset -"+err.getElementsByTagName("dst_offset").item(0).getTextContent());
////          System.out.println("time_zone_id -"+err.getElementsByTagName("time_zone_id").item(0).getTextContent());
////          System.out.println("time_zone_name -"+err.getElementsByTagName("time_zone_name").item(0).getTextContent());
//	} else { 
//		     // success
//         }
	} catch (Exception e) {
	   System.out.println(e);
	}
     }
 }
 public static Document loadXMLString(String response) throws Exception
{
    DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    InputSource is = new InputSource(new StringReader(response));

    return db.parse(is);
}

public static List<String> getFullNameFromXml(String response, String tagName) throws Exception {
    Document xmlDoc = loadXMLString(response);
    NodeList nodeList = xmlDoc.getElementsByTagName(tagName);
    List<String> ids = new ArrayList<String>(nodeList.getLength());
    for(int i=0;i<nodeList.getLength(); i++) {
        Node x = nodeList.item(i);
        ids.add(x.getFirstChild().getNodeValue());             
        System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
    }
    return ids;
}
public static void call_me2(){
     try {
                String url = "http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen_Import/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");

                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                            "   <soapenv:Header>\n" +
                            "      <exam:authentication>\n" +
                            "         <username>rtp</username>\n" +
                            "         <password>rtp</password>\n" +
                            "      </exam:authentication>\n" +
                            "   </soapenv:Header>\n" +
                            "   <soapenv:Body>\n" +
                            "      <exam:CrimesCaseDetail>\n" +
                            "         <INPUT>{CrimeCaseNo:\"100\",CrimeCaseYear:\"2562\",ORG_CODE:\"70317\",Usename:\"12TE06\",Idcard:\"3550900100443\",OrgName:\"สภ.จอหอ\"}</INPUT>\n" +
                            "      </exam:CrimesCaseDetail>\n" +
                            "   </soapenv:Body>\n" +
                            "</soapenv:Envelope>";
                System.out.println(xml);
                con.setDoOutput(true);
                        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("Person");        
 for (int temp = 0; temp < errNodes.getLength(); temp++) {

        Node nNode = errNodes.item(temp);
        
           
        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode; 
//            String insertCrime="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
//                              + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd)";
//            String insertPerson="insert into Person(OrderPerson,PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
//                              + "Age,TypePerson,ArrestDateTime)";            
//              String insertCharge="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
//                              + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd)";
//              String insertAction="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
//                              + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd)";
            System.out.println("Birthday : " + eElement.getElementsByTagName("Birthday").item(0).getTextContent());

        }
           }


                } catch (Exception e) {
                System.out.println(e);
                }
     
                }
 public static void test(){
     try {
        
                String url = "http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen_Import/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                        "   <soapenv:Header>\n" +
                        "      <exam:authentication>\n" +
                        "         <username>rtp</username>\n" +
                        "         <password>rtp</password>\n" +
                        "      </exam:authentication>\n" +
                        "   </soapenv:Header>\n" +
                        "   <soapenv:Body>\n" +
                        "      <exam:CrimesCaseDetail>\n" +
                        "         <INPUT>{\"CrimeCaseNo\":\"212\",\"CrimeCaseYear\":\"2561\",\"ORG_CODE\":\"99999\",\"Usename\":\"TNCTUK\",\"Idcard\":\"1111111111111\",\"OrgName\":\"ดเเกเก\"}</INPUT>\n" +
                        "      </exam:CrimesCaseDetail>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>";
                System.out.println(xml);
                con.setDoOutput(true);
                 DataOutputStream writer = new DataOutputStream(con.getOutputStream());
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("Person");
               	       NodeList errNodes2 = doc.getElementsByTagName("CrimeCase");
                        Connection conn=null;
               conn=ConnectDatabase.connect();
                       if (errNodes2.getLength() > 0) {
            Element err = (Element)errNodes2.item(0);
         String insertCrime="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
                       + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd)\n"
                       + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
       try {
                    
                         PreparedStatement pst=null;
                        
                        pst=conn.prepareStatement(insertCrime);
                        pst.setString(1, IdCase());
                        pst.setString(2, "คดีอาญา");
                        pst.setString(3, err.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
                        pst.setString(4,  err.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
                        pst.setString(5,  err.getElementsByTagName("CaseNo").item(0).getTextContent());
                        pst.setString(6, NewDate( err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(7,  NewTime(err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(8,  NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(9,   NewTime(err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(10,  NewDate( err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(11,  NewTime(err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(12,   NewDate( err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                        pst.setString(13,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
//                        pst.setString(6,  err.getElementsByTagName("Birthday").item(0).getTextContent()); 

                     pst.execute();
                     pst.close();   
                       System.out.println("success");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }
	} else { 
		     // success
         }
           for (int temp = 0; temp < errNodes.getLength(); temp++) {

        Node nNode = errNodes.item(temp);

        

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element p = (Element) nNode; 

    System.out.println("First Name : " +CheckNull(p.getElementsByTagName("PeopleRegistrationID").item(0)));
 String insertPerson="insert into Person(OrderPerson,PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                              + "Age,TypePerson,ArrestDateTime,CaseIdPerson)\n"
                                + "VALUES (?,?,?,?,?,?,?,?,?)";  
         try {
                        int order=temp+1;
                         PreparedStatement pst2=null;
                        
                        pst2=conn.prepareStatement(insertPerson);
                        pst2.setString(1, order+"");
                        pst2.setString(2,p.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
                        pst2.setString(3, p.getElementsByTagName("FullnameTH").item(0).getTextContent());
                        pst2.setString(4,  NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
                        pst2.setString(5, "");
                        pst2.setString(6, p.getElementsByTagName("Age").item(0).getTextContent()); 
                        pst2.setString(7,  ""); 
                        pst2.setString(8,  ""); 
                        pst2.setString(9,  IdCasePerson()); 

                     pst2.execute();
                     pst2.close();   
                      System.out.println("success Person");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }

        }
           }

                } catch (Exception e) {
                System.out.println(e);
                }
     
                }
 public static void test1(){
try {
Connection conn=null;
               conn=ConnectDatabase.connect();
                String url = "http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen_Import/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
               "   <soapenv:Header>\n" +
               "      <exam:authentication>\n" +
               "         <username>rtp</username>\n" +
               "         <password>rtp</password>\n" +
               "      </exam:authentication>\n" +
               "   </soapenv:Header>\n" +
               "   <soapenv:Body>\n" +
               "      <exam:CrimesCaseDetail>\n" +
               "         <INPUT>{\"CrimeCaseNo\":\"212\",\"CrimeCaseYear\":\"2561\",\"Username\":\"TNCTUK\",\"ORG_CODE\":\"99999\",\"Idcard\":\"1111111111111\",\"OrgName\":\"หน่วยงานบริการลูกค้าระบบ CRIMES\"}</INPUT>\n" +
               "      </exam:CrimesCaseDetail>\n" +
               "   </soapenv:Body>\n" +
               "</soapenv:Envelope>";
                System.out.println(xml);
                con.setDoOutput(true);
                        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
		       NodeList errNodes = doc.getElementsByTagName("Person");
               	       NodeList errNodes2 = doc.getElementsByTagName("CrimeCase");
//                        Connection conn=null;
               conn=ConnectDatabase.connect();
                       if (errNodes2.getLength() > 0) {
            Element err = (Element)errNodes2.item(0);
         String insertCrime="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
                       + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd)\n"
                       + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      
       try {
                    
                         PreparedStatement pst=null;
                        
                        pst=conn.prepareStatement(insertCrime);
                        pst.setString(1, IdCase());
                        pst.setString(2, "คดีอาญา");
                        pst.setString(3, err.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
                        pst.setString(4,  err.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
                        pst.setString(5,  err.getElementsByTagName("CaseNo").item(0).getTextContent());
                        pst.setString(6, NewDate( err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(7,  NewTime(err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(8,  NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(9,   NewTime(err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(10,  NewDate( err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(11,  NewTime(err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(12,   NewDate( err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                        pst.setString(13,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
//                        pst.setString(6,  err.getElementsByTagName("Birthday").item(0).getTextContent()); 

                     pst.execute();
                     pst.close();   
                       System.out.println("success");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }
	} else { 
		     // success
         }
                    for (int temp = 0; temp < errNodes.getLength(); temp++) {
                    Node nNode = errNodes.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element p = (Element) nNode; 

//    System.out.println("First Name : " +eElement.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
                    String insertPerson="insert into Person(PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                                                 + "Age,TypePerson,ArrestDateTime,CaseIdPerson)\n"
                                                   + "VALUES (?,?,?,?,?,?,?,?)";  
         try {
                        int order=temp+1;
                         PreparedStatement pst2=null;
                        
                        pst2=conn.prepareStatement(insertPerson);
                        pst2.setString(1,CheckNull(p.getElementsByTagName("PeopleRegistrationID").item(0)));
                        pst2.setString(2, p.getElementsByTagName("FullnameTH").item(0).getTextContent());
                        pst2.setString(3,  NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
                        pst2.setString(4, NewGender(p.getElementsByTagName("Gender").item(0).getTextContent()));
                        pst2.setString(5, p.getElementsByTagName("Age").item(0).getTextContent()); 
                        pst2.setString(6,  NewTypePerson(p.getElementsByTagName("StatusVictimOrSuspect").item(0).getTextContent())); 
                        pst2.setString(7,  ""); 
                        pst2.setString(8,  IdCasePerson()); 

                     pst2.execute();
                     pst2.close();   
                      System.out.println("success Person");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }

        }
           }

                } catch (Exception e) {
                System.out.println(e);
                }
     
}
public static void call_crime(){
     try {
                String url = "http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");

                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                    "   <soapenv:Header>\n" +
                    "      <exam:authentication>\n" +
                    "         <username>rtp</username>\n" +
                    "         <password>rtp</password>\n" +
                    "      </exam:authentication>\n" +
                    "   </soapenv:Header>\n" +
                    "   <soapenv:Body>\n" +
                    "      <exam:CrimesCaseDetail>\n" +
                    "         <INPUT>{CrimeCaseNo:\"100\",CrimeCaseYear:\"2562\",ORG_CODE:\"70317\",Usename:\"12TE06\",Idcard:\"3550900100443\",OrgName:\"สภ.จอหอ\"}</INPUT>\n" +
                    "      </exam:CrimesCaseDetail>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";
                con.setDoOutput(true);
                        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("Person");
           for (int temp = 0; temp < errNodes.getLength(); temp++) {

        Node nNode = errNodes.item(temp);

        

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode; 
//          if(eElement.getElementsByTagName("DisplaySuspectName")==null){
//          
//          
//          }
if(eElement.getElementsByTagName("DisplaySuspectName").item(0)==null){
 System.out.println("First Name : " +eElement.getElementsByTagName("DisplaySuspectName").item(0));
}
else{
    System.out.println("First Name : " +eElement.getElementsByTagName("DisplaySuspectName").item(0).getTextContent());
}
//            System.out.println("First Name : " +eElement.getElementsByTagName("DisplaySuspectName").item(0).getTextContent());
//            System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//            System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//            System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
        }
           }
//        if (errNodes.getLength() > 0) {
//            Element err = (Element)errNodes.item(0);
//          System.out.println("raw_offset -"+err.getElementsByTagName("CrimeLocationRoad").item(0).getTextContent());
////	  System.out.println("dst_offset -"+err.getElementsByTagName("dst_offset").item(0).getTextContent());
////          System.out.println("time_zone_id -"+err.getElementsByTagName("time_zone_id").item(0).getTextContent());
////          System.out.println("time_zone_name -"+err.getElementsByTagName("time_zone_name").item(0).getTextContent());
//	} else { 
//		     // success
//         }
//        NodeList errNodes2 = doc.getElementsByTagName("Person");
//        if (errNodes2.getLength() > 0) {
//            Element err = (Element)errNodes.item(0);
//          System.out.println("Person -"+err.getElementsByTagName("Birthday").item(0).getTextContent());
////	  System.out.println("dst_offset -"+err.getElementsByTagName("dst_offset").item(0).getTextContent());
////          System.out.println("time_zone_id -"+err.getElementsByTagName("time_zone_id").item(0).getTextContent());
////          System.out.println("time_zone_name -"+err.getElementsByTagName("time_zone_name").item(0).getTextContent());
//        Element err2 = (Element)errNodes.item(1);
//        System.out.println("Person -"+err2.getElementsByTagName("Birthday").item(1).getTextContent());
//	} 
                } catch (Exception e) {
                System.out.println(e);
                }
     
                }
     public static String NewDate(String dateold) throws Exception{
         Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("d/MM/yyyy",lc);
        Date date = inputFormat.parse(dateold);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
      }
        public static String NewTime(String dateold) throws Exception{
         Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm",lc);
        Date date = inputFormat.parse(dateold);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
      }
      public static String NewTypePerson(String type){
          String newType="";
         if(type.equals("Victim")){  
          newType="ผู้กล่าวหา";
         }
         if(type.equals("Suspect")){  
          newType="ผู้ต้องหา";
         }
               return newType;
      }
      public static String NewGender(String gender){
          String newGender="";
         if(gender.equals("Male")){  
          newGender="ชาย";
         }
          if(gender.equals("Female")){  
          newGender="หญิง";
         }
               return newGender;
      }
    
     public static void insert_crime(){
     try {
             Connection conn=null;
               conn=ConnectDatabase.connect();
                String url = "http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen_Import/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
               "   <soapenv:Header>\n" +
               "      <exam:authentication>\n" +
               "         <username>rtp</username>\n" +
               "         <password>rtp</password>\n" +
               "      </exam:authentication>\n" +
               "   </soapenv:Header>\n" +
               "   <soapenv:Body>\n" +
               "      <exam:CrimesCaseDetail>\n" +
               "         <INPUT>{CrimeCaseNo:\"100\",CrimeCaseYear:\"2562\",ORG_CODE:\"70317\",Usename:\"12TE06\",Idcard:\"3550900100443\",OrgName:\"สภ.จอหอ\"}</INPUT>\n" +
               "      </exam:CrimesCaseDetail>\n" +
               "   </soapenv:Body>\n" +
               "</soapenv:Envelope>";
                con.setDoOutput(true);
                        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("CrimeCase");       
        if (errNodes.getLength() > 0) {
            Element err = (Element)errNodes.item(0);
                     System.out.println("CaseAcceptDate: " +err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent());
//      String insertCrime="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
//                       + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd)"
//                       + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//      
//       try {
//                    
//                         PreparedStatement pst=null;
//                        
//                        pst=conn.prepareStatement(insertCrime);
//                        pst.setString(1, IdCase());
//                        pst.setString(2, "คดีอาญา");
//                        pst.setString(3, err.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
//                        pst.setString(4,  err.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
//                        pst.setString(5,  err.getElementsByTagName("CaseNo").item(0).getTextContent());
//                        pst.setString(6, NewDate( err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
//                        pst.setString(7,  NewTime(err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
//                        pst.setString(8,  NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
//                        pst.setString(9,   NewTime(err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
//                        pst.setString(10,  NewDate( err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
//                        pst.setString(11,  NewTime(err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
//                        pst.setString(12,   NewDate( err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
//                        pst.setString(13,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
////                        pst.setString(6,  err.getElementsByTagName("Birthday").item(0).getTextContent()); 
//
//                     pst.execute();
//                     pst.close();   
//                         System.out.println("insertCrime");
//        } catch (SQLException e) {
//                System.out.println("ddddd: "+e);
//            
//        }
	} else { 
		     // success
         }
        
//        NodeList nodePer = doc.getElementsByTagName("Person");
//         for (int temp = 0; temp < nodePer.getLength(); temp++) {
//
//        Node nNode = nodePer.item(temp);
//
//        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//            Element p = (Element) nNode;
//        String insertPerson="insert into Person(OrderPerson,PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
//                              + "Age,TypePerson,ArrestDateTime,CaseIdPerson)"
//                                + "VALUE (?,?,?,?,?,?,?,?,?)";  
//         try {
//                        int order=temp+1;
//                         PreparedStatement pst2=null;
//                        
//                        pst2=conn.prepareStatement(insertPerson);
//                        pst2.setString(1, order+"");
//                        pst2.setString(2,p.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
//                        pst2.setString(3, p.getElementsByTagName("FullnameTH").item(0).getTextContent());
//                        pst2.setString(4,  NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
//                        pst2.setString(5, "");
//                        pst2.setString(6, p.getElementsByTagName("Age").item(0).getTextContent()); 
//                        pst2.setString(7,  ""); 
//                        pst2.setString(8,  ""); 
//                        pst2.setString(9,  IdCasePerson()); 
//                        
//                     pst2.execute();
//                     pst2.close();   
//                     System.out.println("Success");
//        } catch (SQLException e) {
//                System.out.println("ddddd: "+e);
//            
//        }
////         System.out.println("First Name : " +eElement.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
//
//        }
//           }
                
     } catch (Exception e) {
                System.out.println(e);
                }
     
                }
   public static String IdCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("caseid"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
     public static String IdCasePerson(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("caseid"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
        public static String CheckNull(Object type){
          String newType="";
          String check=".getTextContent()";
         if(type==null){  
            return newType;
         }
         else{ return type+check;}
              
      }
}
