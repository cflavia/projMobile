package com.example.demo.service;

import com.example.demo.model.Iphone11;
import com.example.demo.model.Telefon;

public class StaticCommand implements Command{
    @Override
    public void execute() {
        Iphone11 i=new Iphone11(1,"128GB","12",4000);
        if(i!=null){
            MobileCount mobileCount=new MobileCount();
            i.accept(mobileCount);
            mobileCount.printCount();
        }
    }
}
