package com.vwinner.pcapp.komun.Models;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MonthServices {
    private List<KomService> serviceList;
    private Date data;
    private String date;

    public MonthServices(Date data) {
        this.data = data;
        this.serviceList = new ArrayList<>();
    }

    public void add(KomService service){
        serviceList.add(service);
    }


    public String getDate() {
        return date;
    }

    public void setDate(final String date) {
        this.date = date;
    }
}
