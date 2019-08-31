/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Computer
 */
public class CalculateData {

      public static String calculateAge(String birthDate)
   {
      int years = 0;
      String age="";
//      int months = 0;
//      int days = 0;
      //create calendar object for birth day
       try{
  //using Calendar Object
//  String s = "1994/06/23";
   Locale lc = new Locale("th","TH");
   SimpleDateFormat ch = new SimpleDateFormat("dd/MM/yyyy",lc);
   Date a = ch.parse(birthDate);
//    Calendar cal = Calendar.getInstance();
//          cal.setTime(a); 
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd",lc);
  String cc = sdf.format(a);
  Date d = sdf.parse(cc);
          
  Calendar c = Calendar.getInstance();
  c.setTime(d);
//   System.out.println("Date : "+d+"");
  int year = c.get(Calendar.YEAR);
  int month = c.get(Calendar.MONTH) + 1;
  int date = c.get(Calendar.DATE);
           LocalDate l1 = LocalDate.of(year, month, date);
  LocalDate now1 = LocalDate.now();
           Period diff1 = Period.between(l1, now1);
           age=diff1.getYears()+"";
//  System.out.println("age:" + diff1.getYears() + "years");
            return age;
       }catch(Exception e){
                 return null;
//           e.printStackTrace();
       
       }


   }
}