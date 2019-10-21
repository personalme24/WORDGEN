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

public class MOIJni
{
  public native String jInitialize();
  
  public native String jUnInitialize();
  
  public native String jListReader();
  
  public native String jOpenReader(String paramString);
  
  public native String jGetPID();
  
  public native String jGetCID();
  
  public native String jBin2Str(String paramString, int paramInt);
  
  public native String jGetMatchStatus(String paramString);
  
  public native String jVerifyPin2();
  
  public native byte[] jStr2Bin(String paramString, int paramInt);
  
  public native String jInternalAuthen(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public native String jRequestRandom(String paramString1, String paramString2, String paramString3);
  
  public native String jSearchData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public native byte[] jSearchDataByte(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  static
  {
    System.setProperty("java.library.path", "C:\\Windows\\System32");
    System.loadLibrary("MOIForjava");
  }
}

