/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Computer
 */public class DateTest {
    public static void main(String[] args) {
    try{
        String dateAccept="10/10/2562 11:40";  
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat inputFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        
           Date date = inputFormat.parse(dateAccept);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR, -543);
            Date newDate = c.getTime();
        System.out.println("aaa"+newDate); 
            String ass=inputFormat2.format(newDate);
        Date date2 = inputFormat.parse(ass);      
        String formattedDate = outputFormat.format(date2);
        System.out.println(formattedDate);
    }
    catch(Exception ec){
    
    }
    }
    
}

