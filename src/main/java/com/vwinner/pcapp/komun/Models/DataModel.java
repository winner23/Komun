package com.vwinner.pcapp.komun.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataModel {

    private KomService komService;
    private MonthServices monthServices;
    private DBService dbService;

    public DataModel(){
        this.dbService = new DBService();
    }

public KomService getServiceById(int id){
    String request = "SELECT * FROM services WHERE ServID = " + id;
    ResultSet rs = dbService.qReqest(request);
    try {
        while(rs.next()){
            String name = rs.getString("Name");
            double price = rs.getDouble("price");
            String type = rs.getString("Type");
            KomService service = new KomService(id, name, price, type);
            service.setDescription(rs.getString("Account"));
            return service;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

public List<KomService> getAllServices(){
    List<KomService> result = new ArrayList();
    ResultSet rs = dbService.getServices();
    try {
        while(rs.next()){
            int id = rs.getInt("ServID");
            String name = rs.getString("Name");
            double price = rs.getDouble("price");
            String type = rs.getString("Type");
            KomService service = new KomService(id, name, price, type);
            service.setDescription(rs.getString("Account"));
            result.add(service);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    if(result.size()<1)
        return null;
    else
        return result;
}

/**  Return  the date of payment for defined date of month
    @param date String in format --
        Only certain month and year are taken into account for defined date in the argument.
        Pattern: dd mm yyyy"
    @return  the date of payment for defined date of month
*/
public Date getDate4Month(String date){
    DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
    return getDate4Month(date, df);
}

public Date getDate4Month(String date, DateFormat format){
    Date requestedDay;
    try {
        requestedDay = format.parse(date);
    } catch (ParseException e) {
        e.printStackTrace();
        return null;
    }
    return getDate4Month(requestedDay);
}

public Date getDate4Month(Date date){
    DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    Date begin = cal.getTime();

    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    Date end = cal.getTime();

    String request = "SELECT DISTINCT Date FROM Data_1 WHERE Date BETWEEN '" +
            df.format(begin) + "' AND '" + df.format(end) + "'";

    ResultSet rs = dbService.qReqest(request);
    String resultStr;

    try {
        resultStr = rs.getString(1);
        if(!rs.next()) return null;
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }

    Date result = null;
    try {
        result = df.parse(resultStr);
    } catch (ParseException e) {
        e.printStackTrace();
        return null;
    }
    return result;

}


public MonthServices getMonthServices(Date date){

    String query = "SELECT * FROM Data_1 WHERE Date = " + date.toString();
    ResultSet rs = dbService.qReqest(query);
    MonthServices monthServices = new MonthServices(date);
    try {
        while(rs.next()){

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return monthServices;
}


}
