package com.vwinner.pcapp.komun.Controllers;

import com.vwinner.pcapp.komun.Models.MonthServices;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ImportXLSX {

    final private InputStream fileIn;
    private List<String> dateSheets = new ArrayList();

    private ImportXLSX(InputStream fileIn){
        this.fileIn = fileIn;
    }
    private ImportXLSX(String name) throws FileNotFoundException {
        if(name==null||name.length()<3)
            throw new RuntimeException("Incorrect file name");
        fileIn = new FileInputStream(name);
    }
    public static ImportXLSX getData(String fileName) throws FileNotFoundException{
        ImportXLSX data = new ImportXLSX(fileName);
        String ext = fileName.substring(fileName.lastIndexOf('.'));
        if(ext.equals(".xls")) data.getXLS();
        else if(ext.equals(".xlsx")) data.getXLSX();

        return data;
    }

    private void getXLSX() {
        int sizeBook;
        List<String> services = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(fileIn);
            sizeBook = workbook.getNumberOfSheets();
            for(int i = 0; i < sizeBook; i++) {

                Sheet sheet = workbook.getSheetAt(i);
                String date = sheet.getSheetName();
                dateSheets.add(date);
                Date tempDate = null;
                try {
                    tempDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                MonthServices monthServices = new MonthServices(tempDate);

                int iRow = 5;
                Row row;
                String servText;

                do {
                    row = sheet.getRow(iRow);
                    Cell service = row.getCell(1);
                    servText = service.getStringCellValue();

                    if(!services.contains(servText))
                        services.add(servText);

                    iRow++;
                } while (servText.length() > 2);


            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }

    private void getXLS() {
    }


}
