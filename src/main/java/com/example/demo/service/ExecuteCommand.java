package com.example.demo.service;

import com.example.demo.model.Iphone11;
import com.example.demo.model.IphoneX;

public class ExecuteCommand implements Command{
    @Override
    public void execute() {
        Iphone11 i=new Iphone11(1,"Iphone11","Iphone","128GB","12");
        System.out.println("Open...");
        ManagerDoc.getInstance().setMobile(i);
    }
}
