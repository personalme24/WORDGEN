/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Computer
 */public class DateTest {
    public static void main(String[] args) {
    try{
        String dateAccept="10/10/2562";
        String timeAccept="11:40";
          Locale lc = new Locale("english","ENGLISH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = inputFormat.parse(dateAccept);
       
        String formattedDate = outputFormat.format(date);
        System.out.println(formattedDate);
    }
    catch(Exception ec){
    
    }
    }
    
}

