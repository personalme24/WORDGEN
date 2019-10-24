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
import com.gembox.spreadsheet.*;
import com.gembox.spreadsheet.charts.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

class Program {

    public static void main(String[] args) throws java.io.IOException {
        // If using Professional version, put your serial key below.
        SpreadsheetInfo.setLicense("FREE-LIMITED-KEY");

        ExcelFile workbook = new ExcelFile();
        ExcelWorksheet worksheet = workbook.addWorksheet("Chart");

        int numberOfEmployees = 3;

        // Create Excel chart and select data for it.
        ExcelChart chart = worksheet.getCharts().add(ChartType.BAR, "D2", "M25");
        chart.selectData(worksheet.getCells().getSubrangeAbsolute(0, 0, numberOfEmployees, 1), true);

        // Add data which is used by the Excel chart.
        String[] names = new String[] { "John Doe", "Fred Nurk" };
//        java.util.Random random = new java.util.Random();
try{
            Connection con=ConnectDatabase.connect();            
             String sqlDataPoliceStation="select ChargeUse,count(ChargeUse) countCh,ChargeName,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                                            "left join Charge on DataCharge.ChargeUse=Charge.ChargeCode\n" +
                                            "where TypeCaseCharge='คดีอาญา' and daterep='201910'\n" +
                                            "group by ChargeUse";
           Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery(sqlDataPoliceStation); 
//            while(rs.next()){
                
                for (int i = 0; rs.next() ; i++) {
                   worksheet.getCell(i + 1, 0).setValue(rs.getString("ChargeName"));
                    worksheet.getCell(i + 1, 1).setValue(rs.getString("countCh"));   
//                }
          
                   
                    
                  } 
       
        }
        catch(Exception ex){
                System.out.println("error:"+ex);
        }
     

        // Set header row and formatting.
        worksheet.getCell(0, 0).setValue("ข้อหา");
        worksheet.getCell(0, 1).setValue("จำนวน");
        worksheet.getCell(0, 1).getStyle().getFont().setWeight(ExcelFont.BOLD_WEIGHT);
        worksheet.getCell(0, 0).getStyle().getFont().setWeight(ExcelFont.BOLD_WEIGHT);
        worksheet.getColumn(0).setWidth((int) LengthUnitConverter.convert(3, LengthUnit.CENTIMETER, LengthUnit.ZERO_CHARACTER_WIDTH_256_TH_PART));
        worksheet.getColumn(1).getStyle().setNumberFormat("\"$\"#,##0");

        workbook.save("Chart.xlsx");
    }
}