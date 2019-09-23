/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Computer
 */
public class NewClass {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMotherboardSerial());
	}
	public static String getMotherboardSerial(){
		try
	    {
	        String result = null;
	        Process p = Runtime.getRuntime().exec("wmic baseboard get product,Manufacturer,version,serialnumber");
	               BufferedReader input
	                = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while ((line = input.readLine()) != null)
	        {
	        	result += line;
	        }
	        input.close();
	        return result;
	    } catch (IOException ex)
	    {
	        ex.printStackTrace();
	        return null;
	    }
	}
}
