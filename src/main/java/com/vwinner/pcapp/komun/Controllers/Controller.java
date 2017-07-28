package com.vwinner.pcapp.komun.Controllers;

import com.vwinner.pcapp.komun.Models.DataModel;
import com.vwinner.pcapp.komun.Views.MainScreen;

import java.util.Date;


/**
 * Created by TATO on 02.07.2017.
 */
public class Controller {
    private DataModel dataModel;
    private MainScreen mainScreen;


    public Controller(DataModel dataModel, MainScreen mainScreen) {
        this.dataModel = dataModel;
        this.mainScreen = mainScreen;
        start();
    }

    public void start() {
        Date getPayman = dataModel.getDate4Month("01.02.2017");
        mainScreen.init();
    }


}
