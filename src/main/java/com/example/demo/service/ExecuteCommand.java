package com.example.demo.service;

import com.example.demo.model.Iphone11;
import com.example.demo.model.IphoneX;

public class ExecuteCommand implements Command{
    @Override
    public void execute() {
        Iphone11 i=new Iphone11(1,"128GB","12",4000);
        System.out.println("Open...");
        ManagerDoc.getInstance().setMobile(i);
    }
}
