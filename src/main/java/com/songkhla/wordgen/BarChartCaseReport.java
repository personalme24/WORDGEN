/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
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

    public static void main(String[] args) throws Exception {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");

        Row row;
        Cell cell;  
        row = sheet.createRow(0);
        row.createCell(0);
        row.createCell(1).setCellValue("คดีอาญา");
//        row.creatseCell(2).setCellValue("HEADER 2");
//        row.createCell(3).setCellValue("HEADER 3");
    int a=0;
   try{
            Connection con=ConnectDatabase.connect();  
            String rowCo="SELECT COUNT(DISTINCT ChargeUse) row,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                         "where TypeCaseCharge='คดีอาญา' and daterep='201911'";
             String sqlDataPoliceStation="select ChargeUse,count(ChargeUse) countCh,ChargeName,strftime('%Y%m', DateToday) daterep from DataCharge\n" +
                                            "left join Charge on DataCharge.ChargeUse=Charge.ChargeCode\n" +
                                            "where TypeCaseCharge='คดีอาญา' and daterep='201911'\n" +
                                            "group by ChargeUse";
            
             System.out.println(sqlDataPoliceStation);
           Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery(sqlDataPoliceStation); 
             Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(rowCo); 
            int r=1;
            
            
           if(rs2.next()){
            int rw=rs2.getInt("row");
                System.out.println("sa"+a);
               a=rw+2;
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
        for (int r = 2; r < a; r++) {
           CTBarSer ctBarSer = ctBarChart.addNewSer();
           CTSerTx ctSerTx = ctBarSer.addNewTx();
           CTStrRef ctStrRef = ctSerTx.addNewStrRef();
           ctStrRef.setF("Sheet1!$A$" + r);
           ctBarSer.addNewIdx().setVal(r-2);  
           CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();
           ctStrRef = cttAxDataSource.addNewStrRef();
           ctStrRef.setF("Sheet1!$B$1:$D$1"); 
           CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();
           CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
           ctNumRef.setF("Sheet1!$B$" + r + ":$D$" + r);

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

        FileOutputStream fileOut = new FileOutputStream("BarChart.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }
}
