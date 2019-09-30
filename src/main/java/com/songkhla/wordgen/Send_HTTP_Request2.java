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
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
                  call_me2();
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
 public static void call_me2() throws Exception {
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
}
