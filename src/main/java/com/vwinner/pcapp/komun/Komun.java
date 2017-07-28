package com.vwinner.pcapp.komun;


import com.vwinner.pcapp.komun.Controllers.Controller;
import com.vwinner.pcapp.komun.Models.DataModel;
import com.vwinner.pcapp.komun.Views.MainScreen;

public class Komun {
    public static void main(String ... args){
        DataModel dataModel = new DataModel();
        MainScreen mainScreen = new MainScreen(dataModel);
        Controller controller = new Controller(dataModel, mainScreen);
        controller.start();

    }
}
