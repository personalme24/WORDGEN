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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
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
     URL url = new URL ("http://172.17.4.163:8383/ws-doc/CrimeCaseService_Wordgen?wsdl");
     HttpURLConnection con = (HttpURLConnection)url.openConnection();
     con.setRequestMethod("POST");
     con.setRequestProperty("Content-Type", "application/json; utf-8");
     con.setRequestProperty("Accept", "application/json");
     con.setDoOutput(true);
     JSONObject jsonInput = new JSONObject();
     jsonInput.put("orgcode", "myName");
     jsonInput.put("caseno", "20");
     jsonInput.put("caseyear", "20");
     jsonInput.put("startaccept", "20");
     jsonInput.put("endaccepr", "20");
     jsonInput.put("personcard", "20");
     String j=jsonInput.toString();
     System.out.println(j);
//     String jsonInputString = "{"name": "Upendra", "job": "Programmer"}";
     try(OutputStream os = con.getOutputStream()) {
    byte[] input = j.getBytes("utf-8");
    os.write(input, 0, input.length);       
try(BufferedReader br = new BufferedReader( new InputStreamReader(con.getInputStream(), "utf-8"))) {
    StringBuilder response = new StringBuilder();
    String responseLine = null;
    while ((responseLine = br.readLine()) != null) {
        response.append(responseLine.trim());
    }
    System.out.println(response.toString());
}    
}
//	    URL url = new URL("https://httpbin.org/post");
//	    Map params = new LinkedHashMap<>();
//	    params.put("name", "Jinu Jawad");
//	    params.put("email", "helloworld@gmail.com");
//	    params.put("CODE", 1111);
//	    params.put("message", "Hello Post Test success");
//	    StringBuilder postData = new StringBuilder();
//	    for (Map.Entry param : params.entrySet()) {
//	        if (postData.length() != 0) postData.append('&');
//	        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//	        postData.append('=');
//	        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//	    }
//	    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//	    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//	    conn.setRequestMethod("POST");
//	    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//	    conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
//	    conn.setDoOutput(true);
//	    conn.getOutputStream().write(postDataBytes);
//	    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//	    StringBuilder sb = new StringBuilder();
//	    for (int c; (c = in.read()) >= 0;)
//	        sb.append((char)c);
//	    String response = sb.toString();
//	    System.out.println(response);
//	    JSONObject myResponse = new JSONObject(response.toString());
//	    System.out.println("result after Reading JSON Response");
//	    System.out.println("origin- "+myResponse.getString("origin"));
//	    System.out.println("url- "+myResponse.getString("url"));
//	    JSONObject form_data = myResponse.getJSONObject("form");
//	    System.out.println("CODE- "+form_data.getString("CODE"));
//	    System.out.println("email- "+form_data.getString("email"));
//	    System.out.println("message- "+form_data.getString("message"));
//	    System.out.println("name"+form_data.getString("name"));
	}

}
