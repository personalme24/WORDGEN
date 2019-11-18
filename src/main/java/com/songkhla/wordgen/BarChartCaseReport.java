/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFDrawing;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBarSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTCatAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTValAx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTScaling;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegend;
import org.openxmlformats.schemas.drawingml.x2006.chart.STAxPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STBarDir;
import org.openxmlformats.schemas.drawingml.x2006.chart.STOrientation;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.STTickLblPos;

public class BarChartCaseReport {
    public static void ReportCase(String YearDate) throws Exception {
     String namePolice="";
        
        Connection conn=ConnectDatabase.connect();  
         String sql="SELECT * From Police";
           Statement st = conn.createStatement();
            ResultSet rsp = st.executeQuery(sql);       
             if(rsp.next()){
                namePolice=rsp.getString("RankPolice")+rsp.getString("FirstName")+" "+rsp.getString("LastName");
             }
    Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("คดีอาญา");
        
        Row row;
        Cell cell;  
           row = sheet.createRow(0);
        row.createCell(0).setCellValue("รายงายการใช้ข้อหาแยกตามประเภทคดีอาญา ของ "+namePolice);
        row.createCell(1);
          row = sheet.createRow(1);
        row.createCell(0).setCellValue("ข้อหา");
        row.createCell(1).setCellValue("จำนวน");
    int a=0;
   try{
            Connection con=ConnectDatabase.connect();  
            String rowCo="SELECT COUNT(DISTINCT ChargeUse) row,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                         "where TypeCaseCharge='คดีอาญา' and daterep='"+YearDate+"'";
             String sqlDataPoliceStation="select ChargeUse,count(ChargeUse) countCh,ChargeName,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                                            "left join Charge on DataCharge.ChargeUse=Charge.ChargeCode\n" +
                                            "where TypeCaseCharge='คดีอาญา' and daterep='"+YearDate+"'\n" +
                                            "group by ChargeUse";
            
             System.out.println(sqlDataPoliceStation);
           Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery(sqlDataPoliceStation); 
             Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(rowCo); 
            int r=2;
            
            
           if(rs2.next()){
            int rw=rs2.getInt("row");
                System.out.println("sa"+a);
               a=rw+3;
           }
           
            while (rs.next()) {
          
            row = sheet.createRow(r);
            cell = row.createCell(0);
            cell.setCellValue(rs.getString("ChargeName"));
            cell = row.createCell(1);
             cell.setCellValue(Integer.parseInt(rs.getString("countCh")));
//            cell = row.createCell(2);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(3);
//            cell.setCellValue(new java.util.Random().nextDouble());
            r++;
           
       }
 
       
        }
        catch(Exception ex){
                System.out.println("error:"+ex);
        }
//        for (int r = 1; r < 5; r++) {
//            row = sheet.createRow(r);
//            cell = row.createCell(0);
//            cell.setCellValue("Serie " + r);
//            cell = row.createCell(1);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(2);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(3);
//            cell.setCellValue(new java.util.Random().nextDouble());
//        }

        XSSFDrawing drawing = (XSSFDrawing)sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 8, 20);

        XSSFChart chart = drawing.createChart(anchor);

        CTChart ctChart = ((XSSFChart)chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
        CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
        ctBoolean.setVal(true);
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);
        System.out.println("ggg"+a);
        for (int r = 3; r < a; r++) {
           CTBarSer ctBarSer = ctBarChart.addNewSer();
           CTSerTx ctSerTx = ctBarSer.addNewTx();
           CTStrRef ctStrRef = ctSerTx.addNewStrRef();
           ctStrRef.setF("คดีอาญา!$A$" + r);
           ctBarSer.addNewIdx().setVal(r-2);  
           CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();
           ctStrRef = cttAxDataSource.addNewStrRef();
//           ctStrRef.setF("Sheet1!$B$1:$D$1"); 
                      ctStrRef.setF("คดีอาญา!$B$1"); 

           CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();
           CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
//           ctNumRef.setF("Sheet1!$B$" + r + ":$D$" + r);
           ctNumRef.setF("คดีอาญา!$B$" + r );
           

           //at least the border lines in Libreoffice Calc ;-)
           ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] {0,0,0});   

        } 

        //telling the BarChart that it has axes and giving them Ids
        ctBarChart.addNewAxId().setVal(123456);
        ctBarChart.addNewAxId().setVal(123457);

        //cat axis
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx(); 
        ctCatAx.addNewAxId().setVal(123456); //id of the cat axis
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewDelete().setVal(false);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(123457); //id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //val axis
        CTValAx ctValAx = ctPlotArea.addNewValAx(); 
        ctValAx.addNewAxId().setVal(123457); //id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx.addNewDelete().setVal(false);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); //id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //legend
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);

        System.out.println(ctChart);
        
//       ---------------------------------------------------------คดีจราจร-------------------------------------------------------
            Sheet sheet2 = wb.createSheet("คดีจราจร");

        Row row2;
        Cell cel2;  
           row2 = sheet2.createRow(0);
        row2.createCell(0).setCellValue("รายงายการใช้ข้อหาแยกตามประเภทคดีจราจร ของ "+namePolice);
        row2.createCell(1);
          row2 = sheet2.createRow(1);
        row2.createCell(0).setCellValue("ข้อหา");
        row2.createCell(1).setCellValue("จำนวน");
//        row.creatseCell(2).setCellValue("HEADER 2");
//        row.createCell(3).setCellValue("HEADER 3");
    int a2=0;
   try{
            Connection con2=ConnectDatabase.connect();  
            String rowCo2="SELECT COUNT(DISTINCT ChargeUse) row,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                         "where TypeCaseCharge='คดีจราจร' and daterep='"+YearDate+"'";
             String sqlDataPoliceStation2="select ChargeUse,count(ChargeUse) countCh,ChargeName,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                                            "left join Charge on DataCharge.ChargeUse=Charge.ChargeCode\n" +
                                            "where TypeCaseCharge='คดีจราจร' and daterep='"+YearDate+"'\n" +
                                            "group by ChargeUse";
            
             System.out.println(sqlDataPoliceStation2);
           Statement stmt2 = con2.createStatement();
            ResultSet rst = stmt2.executeQuery(rowCo2); 
             Statement stmt3 = con2.createStatement();
            ResultSet rs3 = stmt3.executeQuery(sqlDataPoliceStation2); 
            int r2=2;
            
            
           if(rst.next()){
            int rw2=rst.getInt("row");
                System.out.println("sa2"+rw2);
               a2=rw2+3;
           }
           
            while (rs3.next()) {
          
            row2 = sheet2.createRow(r2);
            cel2 = row2.createCell(0);
            cel2.setCellValue(rs3.getString("ChargeName"));
            cel2 = row2.createCell(1);
             cel2.setCellValue(Integer.parseInt(rs3.getString("countCh")));
//            cell = row.createCell(2);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(3);
//            cell.setCellValue(new java.util.Random().nextDouble());
            r2++;
           
       }
 
       
        }
        catch(Exception ex){
                System.out.println("error:"+ex);
        }
//        for (int r = 1; r < 5; r++) {
//            row = sheet.createRow(r);
//            cell = row.createCell(0);
//            cell.setCellValue("Serie " + r);
//            cell = row.createCell(1);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(2);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(3);
//            cell.setCellValue(new java.util.Random().nextDouble());
//        }

        XSSFDrawing drawing2 = (XSSFDrawing)sheet2.createDrawingPatriarch();
        ClientAnchor anchor2 = drawing2.createAnchor(0, 0, 0, 0, 0, 5, 8, 20);

        XSSFChart chart2 = drawing2.createChart(anchor2);

        CTChart ctChart2 = ((XSSFChart)chart2).getCTChart();
        CTPlotArea ctPlotArea2 = ctChart2.getPlotArea();
        CTBarChart ctBarChart2 = ctPlotArea2.addNewBarChart();
        CTBoolean ctBoolean2 = ctBarChart2.addNewVaryColors();
        ctBoolean2.setVal(true);
        ctBarChart2.addNewBarDir().setVal(STBarDir.COL);
        System.out.println("ggg"+a2);
        for (int r = 3; r < a2; r++) {
           CTBarSer ctBarSer2 = ctBarChart2.addNewSer();
           CTSerTx ctSerTx2 = ctBarSer2.addNewTx();
           CTStrRef ctStrRef2 = ctSerTx2.addNewStrRef();
           ctStrRef2.setF("คดีจราจร!$A$" + r);
           ctBarSer2.addNewIdx().setVal(r-2);  
           CTAxDataSource cttAxDataSource2 = ctBarSer2.addNewCat();
           ctStrRef2 = cttAxDataSource2.addNewStrRef();
           ctStrRef2.setF("คดีจราจร!$B$1"); 
           CTNumDataSource ctNumDataSource2 = ctBarSer2.addNewVal();
           CTNumRef ctNumRef2 = ctNumDataSource2.addNewNumRef();
           ctNumRef2.setF("คดีจราจร!$B$" + r);

           //at least the border lines in Libreoffice Calc ;-)
           ctBarSer2.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] {0,0,0});   

        } 

        //telling the BarChart that it has axes and giving them Ids
        ctBarChart2.addNewAxId().setVal(123456);
        ctBarChart2.addNewAxId().setVal(123457);

        //cat axis
        CTCatAx ctCatAx2 = ctPlotArea2.addNewCatAx(); 
        ctCatAx2.addNewAxId().setVal(123456); //id of the cat axis
        CTScaling ctScaling2 = ctCatAx2.addNewScaling();
        ctScaling2.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx2.addNewDelete().setVal(false);
        ctCatAx2.addNewAxPos().setVal(STAxPos.B);
        ctCatAx2.addNewCrossAx().setVal(123457); //id of the val axis
        ctCatAx2.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //val axis
        CTValAx ctValAx2 = ctPlotArea2.addNewValAx(); 
        ctValAx2.addNewAxId().setVal(123457); //id of the val axis
        ctScaling2 = ctValAx2.addNewScaling();
        ctScaling2.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx2.addNewDelete().setVal(false);
        ctValAx2.addNewAxPos().setVal(STAxPos.L);
        ctValAx2.addNewCrossAx().setVal(123456); //id of the cat axis
        ctValAx2.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //legend
        CTLegend ctLegend2 = ctChart2.addNewLegend();
        ctLegend2.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend2.addNewOverlay().setVal(false);

        System.out.println(ctChart2);

//       ---------------------------------------------------------คดีชันสูตร-------------------------------------------------------
            Sheet sheet3 = wb.createSheet("คดีชันสูตร");

        Row row3;
        Cell cel3;  
           row3 = sheet3.createRow(0);
        row3.createCell(0).setCellValue("รายงายการใช้ข้อหาแยกตามประเภทคดีชันสูตรของ "+namePolice);
        row3.createCell(1);
          row3= sheet3.createRow(1);
        row3.createCell(0).setCellValue("ข้อหา");
        row3.createCell(1).setCellValue("จำนวน");
//        row.creatseCell(2).setCellValue("HEADER 2");
//        row.createCell(3).setCellValue("HEADER 3");
    int a3=0;
   try{
            Connection con3=ConnectDatabase.connect();  
            String rowCo3="SELECT COUNT(DISTINCT ChargeUse) row,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                         "where TypeCaseCharge='คดีชันสูตร' and daterep='"+YearDate+"'";
             String sqlDataPoliceStation3="select ChargeUse,count(ChargeUse) countCh,ChargeName,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                                            "left join Charge on DataCharge.ChargeUse=Charge.ChargeCode\n" +
                                            "where TypeCaseCharge='คดีชันสูตร' and daterep='"+YearDate+"'\n" +
                                            "group by ChargeUse";
            
             System.out.println(sqlDataPoliceStation3);
           Statement stmt3 = con3.createStatement();
            ResultSet dr1 = stmt3.executeQuery(rowCo3); 
             Statement stmt4 = con3.createStatement();
            ResultSet dr2 = stmt4.executeQuery(sqlDataPoliceStation3); 
            int r3=2;
            
            
           if(dr1.next()){
            int rw2=dr1.getInt("row");
                System.out.println("sa2"+a2);
               a3=rw2+3;
           }
           
            while (dr2.next()) {
          
            row3 = sheet3.createRow(r3);
            cel3 = row3.createCell(0);
            cel3.setCellValue(dr2.getString("ChargeName"));
            cel3 = row3.createCell(1);
             cel3.setCellValue(Integer.parseInt(dr2.getString("countCh")));
//            cell = row.createCell(2);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(3);
//            cell.setCellValue(new java.util.Random().nextDouble());
            r3++;
           
       }
 
       
        }
        catch(Exception ex){
                System.out.println("error:"+ex);
        }
//        for (int r = 1; r < 5; r++) {
//            row = sheet.createRow(r);
//            cell = row.createCell(0);
//            cell.setCellValue("Serie " + r);
//            cell = row.createCell(1);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(2);
//            cell.setCellValue(new java.util.Random().nextDouble());
//            cell = row.createCell(3);
//            cell.setCellValue(new java.util.Random().nextDouble());
//        }

        XSSFDrawing drawing3 = (XSSFDrawing)sheet3.createDrawingPatriarch();
        ClientAnchor anchor3 = drawing3.createAnchor(0, 0, 0, 0, 0, 5, 8, 20);

        XSSFChart chart3 = drawing3.createChart(anchor3);

        CTChart ctChart3 = ((XSSFChart)chart3).getCTChart();
        CTPlotArea ctPlotArea3 = ctChart3.getPlotArea();
        CTBarChart ctBarChart3 = ctPlotArea3.addNewBarChart();
        CTBoolean ctBoolean3 = ctBarChart3.addNewVaryColors();
        ctBoolean3.setVal(true);
        ctBarChart3.addNewBarDir().setVal(STBarDir.COL);
        System.out.println("ggg"+a3);
        for (int r = 3; r < a3; r++) {
           CTBarSer ctBarSer3 = ctBarChart3.addNewSer();
           CTSerTx ctSerTx3 = ctBarSer3.addNewTx();
           CTStrRef ctStrRef3 = ctSerTx3.addNewStrRef();
           ctStrRef3.setF("คดีชันสูตร!$A$" + r);
           ctBarSer3.addNewIdx().setVal(r-2);  
           CTAxDataSource cttAxDataSource3 = ctBarSer3.addNewCat();
           ctStrRef3 = cttAxDataSource3.addNewStrRef();
           ctStrRef3.setF("คดีชันสูตร!$B$1"); 
           CTNumDataSource ctNumDataSource3 = ctBarSer3.addNewVal();
           CTNumRef ctNumRef3 = ctNumDataSource3.addNewNumRef();
           ctNumRef3.setF("คดีชันสูตร!$B$" + r);

           //at least the border lines in Libreoffice Calc ;-)
           ctBarSer3.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[] {0,0,0});   

        } 

        //telling the BarChart that it has axes and giving them Ids
        ctBarChart3.addNewAxId().setVal(123456);
        ctBarChart3.addNewAxId().setVal(123457);

        //cat axis
        CTCatAx ctCatAx3 = ctPlotArea3.addNewCatAx(); 
        ctCatAx3.addNewAxId().setVal(123456); //id of the cat axis
        CTScaling ctScaling3 = ctCatAx3.addNewScaling();
        ctScaling3.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx3.addNewDelete().setVal(false);
        ctCatAx3.addNewAxPos().setVal(STAxPos.B);
        ctCatAx3.addNewCrossAx().setVal(123457); //id of the val axis
        ctCatAx3.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //val axis
        CTValAx ctValAx3 = ctPlotArea3.addNewValAx(); 
        ctValAx3.addNewAxId().setVal(123457); //id of the val axis
        ctScaling3 = ctValAx3.addNewScaling();
        ctScaling3.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx3.addNewDelete().setVal(false);
        ctValAx3.addNewAxPos().setVal(STAxPos.L);
        ctValAx3.addNewCrossAx().setVal(123456); //id of the cat axis
        ctValAx3.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //legend
        CTLegend ctLegend3 = ctChart3.addNewLegend();
        ctLegend3.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend3.addNewOverlay().setVal(false);

        System.out.println(ctChart3);
//       ---------------------------------------------------------open file-------------------------------------------------------


         File f3=new File("./รายงานสถิติ");
        f3.mkdirs();
        FileOutputStream fileOut = new FileOutputStream("./รายงานสถิติ/รายงายการใช้ข้อหาแยกตามประเภทคดี-"+YearDate+".xlsx");
        wb.write(fileOut);
        fileOut.close();
       Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./รายงานสถิติ");
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }
    } 
    public static void main(String[] args) throws Exception {
        
    }
}
