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
public class WriteExcelDemo
{
    public static  void crimebook()
    {   Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
     XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("สมุดคุมคดีอาญา");
         CellStyle style = workbook.createCellStyle();  
         Font newFont = workbook.createFont();
         newFont.setBold(true);
         newFont.setFontName("TH SarabunPSK");
//    XSSFCellStyle style = workbook.createCellStyle();
            style.setBorderBottom(BorderStyle.THIN);  
            style.setBorderRight(BorderStyle.THIN); 
            style.setBorderTop(BorderStyle.THIN);  
            style.setBorderLeft(BorderStyle.THIN);
            style.setWrapText(true);
            sheet.setColumnWidth(4, 7500);
          style.setFont(newFont);

//                        style.setTH SarabunPSK

      try {
         String sqlDataPoliceStation="SELECT * FROM PoliceStation";
         Statement spp = conn.createStatement();
         ResultSet rsp=spp.executeQuery(sqlDataPoliceStation);
      if(rsp.next()){
      Row tittle2 = sheet.createRow(1);    
    tittle2.createCell(7).setCellValue("ของ "+rsp.getString("PoliceStaionName")); 
                  }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
    Row tittle = sheet.createRow(0);    
    tittle.createCell(7).setCellValue("สมุดบันทึกคดีอาญา");
 
    Row header = sheet.createRow(2);
    header.createCell(0).setCellValue("คดีที่");
    header.createCell(1).setCellValue("ชื่อผู้กล่าวหา");
    header.createCell(2).setCellValue("ชื่อผู้ต้องหา");
    header.createCell(3).setCellValue("ชื่อผู้จับ");
    header.createCell(4).setCellValue("ข้อหา");
    header.createCell(5).setCellValue("วันเดือนปี สถานที่เกิดเหตุ");
    header.createCell(6).setCellValue("วันเวลาที่ถูกควบคุม");
    header.createCell(7).setCellValue("วันครบกำหนดควบคุม");
    header.createCell(8).setCellValue("การปล่อยชั่วคราว");
    header.createCell(9).setCellValue("การเสนอขอฝากขังต่อศาล");
    header.createCell(10).setCellValue("ผลการสอบสวน");
    header.createCell(11).setCellValue("เสนอต่อหน.พงส.เมื่อใด");
        header.createCell(12).setCellValue("หน.พงส.สั่งอย่างใด");
    header.createCell(13).setCellValue("เสนออัยการเมื่อใด");
    header.createCell(14).setCellValue("ผลคดีชั้นอัยการ");
    header.createCell(15).setCellValue("ผลคดีชั้นศาล");
    header.createCell(16).setCellValue("พงส.เจ้าของคดี");
    header.createCell(17).setCellValue("หมายเหตุ");
   
//    ----------------------------------------Set Style Cell--------------------------------------------
    header.getCell(0).setCellStyle(style);
    header.getCell(1).setCellStyle(style);
    header.getCell(2).setCellStyle(style);
    header.getCell(3).setCellStyle(style);
    header.getCell(4).setCellStyle(style);
    header.getCell(5).setCellStyle(style);
    header.getCell(6).setCellStyle(style);
    header.getCell(7).setCellStyle(style);
    header.getCell(8).setCellStyle(style);
    header.getCell(9).setCellStyle(style);
    header.getCell(10).setCellStyle(style);
    header.getCell(11).setCellStyle(style);
    header.getCell(12).setCellStyle(style);
    header.getCell(13).setCellStyle(style);
    header.getCell(14).setCellStyle(style);
    header.getCell(15).setCellStyle(style);
    header.getCell(16).setCellStyle(style);
    header.getCell(17).setCellStyle(style);

     try {
         String sqlCrimeCase="select crimecase.*,chargecase.ChargeCodeCase ChargeCase,chargecase.ChargeNameCase ChargeNameCase,ArrestDateTime from crimecase "
                + "left join chargecase on crimecase.CaseId=chargecase.ChargeCaseId "
                 + "left join person on crimecase.CaseId=person.caseIdPerson group by person.caseIdPerson";
                      Statement sp = conn.createStatement();
                  ResultSet rs=sp.executeQuery(sqlCrimeCase); 
                  
     for (int i = 3;rs.next(); i++) {
             Row dataRow = sheet.createRow(i);

    dataRow.createCell(0).setCellValue(rs.getString("crimecasenoyear"));
    dataRow.createCell(1).setCellValue(rs.getString("AccureandOther"));
    dataRow.createCell(2).setCellValue(rs.getString("SuspectandOther"));
    dataRow.createCell(3).setCellValue("");
    dataRow.createCell(4).setCellValue(rs.getString("ChargeNameCase"));
    dataRow.createCell(5).setCellValue("");
    dataRow.createCell(6).setCellValue(rs.getString("ArrestDateTime"));
    dataRow.createCell(7).setCellValue("");
    dataRow.createCell(8).setCellValue("");
    dataRow.createCell(9).setCellValue("");
    dataRow.createCell(10).setCellValue("");
    dataRow.createCell(11).setCellValue("");
    dataRow.createCell(12).setCellValue("");
    dataRow.createCell(13).setCellValue("");
    dataRow.createCell(14).setCellValue(rs.getString("Prosecutor_Result"));
    dataRow.createCell(15).setCellValue(rs.getString("CourtResult"));
    dataRow.createCell(16).setCellValue("");
    dataRow.createCell(17).setCellValue("");
    
    //    ----------------------------------------Set Style Cell--------------------------------------------

    dataRow.getCell(0).setCellStyle(style);
        dataRow.getCell(1).setCellStyle(style);
    dataRow.getCell(2).setCellStyle(style);
    dataRow.getCell(3).setCellStyle(style);
     dataRow.getCell(4).setCellStyle(style);
    dataRow.getCell(5).setCellStyle(style);
    dataRow.getCell(6).setCellStyle(style);
    dataRow.getCell(7).setCellStyle(style);
    dataRow.getCell(8).setCellStyle(style);
    dataRow.getCell(9).setCellStyle(style);
    dataRow.getCell(10).setCellStyle(style);
    dataRow.getCell(11).setCellStyle(style);
    dataRow.getCell(12).setCellStyle(style);
    dataRow.getCell(13).setCellStyle(style);
    dataRow.getCell(14).setCellStyle(style);
    dataRow.getCell(15).setCellStyle(style);
    dataRow.getCell(16).setCellStyle(style);
    dataRow.getCell(17).setCellStyle(style);


        }

            System.out.println("Excel with foumula cells written successfully");
             File f3=new File("./สมุดคุมคดี");
        f3.mkdirs();
        FileOutputStream fileOut = new FileOutputStream("./สมุดคุมคดี/สมุดคุมคดีอาญา.xlsx");
        workbook.write(fileOut);
        fileOut.close();
       Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
         dirToOpen = new File("./สมุดคุมคดี");
            desktop.open(dirToOpen);

          
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