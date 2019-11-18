/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
import java.awt.Desktop;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Computer
 */
public class WriteExcelDemo1
{
    public static  void crimebook()
    {   Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
     XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("คดีอาญา");
         CellStyle style = workbook.createCellStyle();  
         Font newFont = workbook.createFont();
         newFont.setBold(true);
         newFont.setFontName("TH SarabunPSK");
//    XSSFCellStyle style = workbook.createCellStyle();
            style.setBorderBottom(BorderStyle.THIN);  
            style.setBorderRight(BorderStyle.THIN); 
            style.setBorderTop(BorderStyle.THIN);  
            style.setBorderLeft(BorderStyle.THIN);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setWrapText(true);
            sheet.setColumnWidth(4, 7500);
          style.setFont(newFont);

//                        style.setTH SarabunPSK

//      try {
//         String sqlDataPoliceStation="SELECT * FROM PoliceStation";
//         Statement spp = conn.createStatement();
//         ResultSet rsp=spp.executeQuery(sqlDataPoliceStation);
//      if(rsp.next()){
//      Row tittle2 = sheet.createRow(1);    
//    tittle2.createCell(7).setCellValue("ของ "+rsp.getString("PoliceStaionName")); 
//                  }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
            
    Row tittle = sheet.createRow(0);    
    tittle.createCell(1).setCellValue("รายงายการใช้ข้อหาแยกตามประเภทคดี");
 
    Row header = sheet.createRow(2);
    header.createCell(0).setCellValue("รหัสข้อหา");
    header.createCell(1).setCellValue("ข้อหา");
    header.createCell(2).setCellValue("จำนวน");
    header.createCell(3).setCellValue("วันที่");

   
//    ----------------------------------------Set Style Cell--------------------------------------------
    header.getCell(0).setCellStyle(style);
    header.getCell(1).setCellStyle(style);
    header.getCell(2).setCellStyle(style);
    header.getCell(3).setCellStyle(style);


     try {
         String sqlCrimeCase="select ChargeUse,count(ChargeUse) countCh,ChargeName,strftime('%Y%m', DateToday) daterep,DateToday from DataCharge\n" +
                                            "left join Charge on DataCharge.ChargeUse=Charge.ChargeCode\n" +
                                            "where TypeCaseCharge='คดีอาญา' and daterep='201910'\n" +
                                            "group by ChargeUse";
                      Statement sp = conn.createStatement();
                  ResultSet rs=sp.executeQuery(sqlCrimeCase); 
                  
     for (int i = 3;rs.next(); i++) {
             Row dataRow = sheet.createRow(i);

    dataRow.createCell(0).setCellValue(rs.getString("ChargeUse"));
    dataRow.createCell(1).setCellValue(rs.getString("ChargeName"));
    dataRow.createCell(2).setCellValue(rs.getString("countCh"));
    dataRow.createCell(3).setCellValue(rs.getString("DateToday"));

    
    //    ----------------------------------------Set Style Cell--------------------------------------------

    dataRow.getCell(0).setCellStyle(style);
        dataRow.getCell(1).setCellStyle(style);
    dataRow.getCell(2).setCellStyle(style);
    dataRow.getCell(3).setCellStyle(style);


        }

    
//        FileOutputStream out =  new FileOutputStream(new File("รายงายการใช้ข้อหาแยกตามประเภทคดี.xlsx"));
//        workbook.write(out);
//        out.close();
        System.out.println("Excel with foumula cells written successfully");
             File f3=new File("./สมุดคุมคดี");
        f3.mkdirs();
        FileOutputStream fileOut = new FileOutputStream("./สมุดคุมคดี/สมุดคุมคดีอาญา.xlsx");
        workbook.write(fileOut);
        fileOut.close();
       Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./สมุดคุมคดี");
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
     catch (SQLException e) {
        e.printStackTrace();
    }
    }
    static void formatDuplicates(Sheet sheet) {
    sheet.createRow(0).createCell(0).setCellValue("Code");
    sheet.createRow(1).createCell(0).setCellValue(4);
    sheet.createRow(2).createCell(0).setCellValue(3);
    sheet.createRow(3).createCell(0).setCellValue(6);
    sheet.createRow(4).createCell(0).setCellValue(3);
    sheet.createRow(5).createCell(0).setCellValue(5);
    sheet.createRow(6).createCell(0).setCellValue(8);
    sheet.createRow(7).createCell(0).setCellValue(0);
    sheet.createRow(8).createCell(0).setCellValue(2);
    sheet.createRow(9).createCell(0).setCellValue(8);
    sheet.createRow(10).createCell(0).setCellValue(6);
 
        SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();
 
    // Condition 1: Formula Is   =A2=A1   (White Font)
        ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule("COUNTIF($A$2:$A$11,A2)>1");
        FontFormatting font = rule1.createFontFormatting();
    font.setFontStyle(false, true);
    font.setFontColorIndex(IndexedColors.BLUE.index);
 
        CellRangeAddress[] regions = {
            CellRangeAddress.valueOf("A2:A11")
    };
 
    sheetCF.addConditionalFormatting(regions, rule1);
 
    sheet.getRow(2).createCell(1).setCellValue("<== Duplicates numbers in the column are highlighted.  " +
            "Condition: Formula Is =COUNTIF($A$2:$A$11,A2)>1   (Blue Font)");
}
}