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
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import org.json.JSONObject;
//import org.json.simple.JSONObject;
//import org.json.JSONObject;
public class Send_HTTP_Request2 {
	public static void main(String[] args) {
     try {
         Send_HTTP_Request2.call_me();
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
}