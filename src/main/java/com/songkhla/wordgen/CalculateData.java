/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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

       try{

   Locale lc = new Locale("th","TH");
   SimpleDateFormat ch = new SimpleDateFormat("dd/MM/yyyy",lc);
   Date a = ch.parse(birthDate);
//    Calendar cal = Calendar.getInstance();
//          cal.setTime(a); 
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy",lc);
   SimpleDateFormat formonth = new SimpleDateFormat("MM",lc);
   SimpleDateFormat fordate= new SimpleDateFormat("dd",lc);
  String cc = sdf.format(a);
  String mBd=formonth.format(a);
    String dBd=fordate.format(a);
 System.out.println("d1"+dBd);
  int  yearBd=Integer.valueOf(cc);
  int  monthBd=Integer.valueOf(mBd);
  int  dateBd=Integer.valueOf(dBd);

           System.out.println("ss"+cc);
           String y2Day=sdf.format(new Date());
           String m2Day=formonth.format(new Date());
           String d2Day=fordate.format(new Date());
 System.out.println("d2"+d2Day);

            System.out.println("toyear"+y2Day);
             int  thisyear=Integer.valueOf(y2Day);
                int  thismonth=Integer.valueOf(m2Day);
                int  thisday=Integer.valueOf(d2Day);
                int calM=thismonth-monthBd;
                 int agenew=thisyear-yearBd;
                int calD=thisday-dateBd;

                if(calM<0){
                
                age=(agenew-1)+"";
                }
                else if(calD < 0 && calM<=0&& agenew>=0  ){
                
                age=(agenew-1)+"";
                }
                else if(calM==0 && calD == 0&& agenew == 0){
                
                age="0";
                }
                else{
                 age=agenew+"";

                }
                        System.out.println(calD+"D"+calM+"M "+agenew);
            return age;
       }catch(Exception e){
                 return null;
//           e.printStackTrace();
       
       }


   }
}