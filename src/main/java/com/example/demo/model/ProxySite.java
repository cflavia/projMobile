package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class ProxySite implements Site{
    private Site site = new RealSite();
    private static List<String> baseMenu;

    static
    {
        baseMenu = new ArrayList<String>();
        baseMenu.add("https://altex.ro/telefoane/cpl/");
        baseMenu.add("https://altex.ro/telefoane/cpl/filtru/brand-3334/apple/");
        baseMenu.add("https://altex.ro/telefoane/cpl/filtru/brand-3334/samsung/");
        baseMenu.add("https://altex.ro/telefoane/cpl/filtru/brand-3334/huawei/");
    }

    @Override
    public void connectTo(String serverhost) throws Exception
    {
        if(baseMenu.contains(serverhost.toLowerCase()))
        {
            throw new Exception("Access Denied");
        }

        site.connectTo(serverhost);
    }
}
