package com.vwinner.pcapp.komun.Models;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KomService {

    //Main fields of Service
    private String name;
    private double price;
    private int id;
    private static List<Integer> ids = new LinkedList<>();

    private String type;

    //Additional fields
    private String account;
    private String description;

    private KomService(){
    }

    public KomService(int id, String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
        if(ids.contains(id))
            throw new RuntimeException("Id exist!");
        else {
            this.id =id;
            ids.add(id);
            ids.sort((o1, o2) -> o1 - o2);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if(ids.contains(this.id)){
            ids.remove(new Integer(id));
        }
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
