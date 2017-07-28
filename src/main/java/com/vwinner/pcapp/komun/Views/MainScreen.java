package com.vwinner.pcapp.komun.Views;

import com.vwinner.pcapp.komun.Models.DataModel;
import com.vwinner.pcapp.komun.Models.MonthServices;

import javax.swing.*;


/**
 * Created by TATO on 02.07.2017.
 */
public class MainScreen {
    private DataModel dataModel;

    private JFrame frame;

    private JTable tableMonth;
    private JButton buttonMonth;
    private JButton buttonServices;
    private JButton buttonReport;
    private JTextField dateField;
    private JTable table1;


    public MainScreen(DataModel dataModel) {

        this.dataModel = dataModel;
    }

    public void init() {

    }


    public void setData(MonthServices data) {
        dateField.setText(data.getDate());
    }

    public void getData(MonthServices data) {
        data.setDate(dateField.getText());
    }

    public boolean isModified(MonthServices data) {
        if (dateField.getText() != null ? !dateField.getText().equals(data.getDate()) : data.getDate() != null)
            return true;
        return false;
    }


}
