package com.vwinner.pcapp.komun.Controllers;

import java.io.InputStream;

public class ImportXLSX {

    private InputStream fileIn;

    private ImportXLSX(){
    }

    private ImportXLSX(String name) {
        if(name==null||name.length()<3)
            throw new RuntimeException("Incorrect file name");


    }
    public static ImportXLSX getData(String fileName){
        return new ImportXLSX(fileName);
    }




}
