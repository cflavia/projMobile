package com.example.demo.model;

public class RealSite implements Site{
    public void connectTo(String serverhost)
    {
        System.out.println("Connecting to "+ serverhost);
    }
}
