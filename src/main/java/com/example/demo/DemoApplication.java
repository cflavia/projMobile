package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.net.ImportData;
import com.example.demo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication extends ImportData {

    public DemoApplication() {
        super();
    }

    public static void main(String[] args)throws Exception {
        try
        {
            SpringApplication.run(DemoApplication.class, args);
            Site site = new ProxySite();
            site.connectTo("https://altex.ro/telefoane/cpl");
            connect();
            createTablePerson();
            createTableProdus();
            MobileCount nr=new MobileCount();
            Person p=new Person(1,"Mara");
            List<Telefon>list=new ArrayList<>();
            Telefon i=new Telefon(1,"Iphone11","Iphone","128GB","12","incarcator, casti","-");
            list.add(i);
            String[] parts = getIdProdus(3).split(" ");
            Telefon i1=new Telefon(Integer.valueOf(parts[0]),parts[1],parts[2],parts[3],parts[4],parts[5],parts[6]);
            list.add(i1);
            p.cumpara(list);
            File file = new File("output.jpg");
            BufferedImage image = null;
            try
            {
                image = ImageIO.read(file);
                ImageIO.write(image, "jpg", new File("output1.jpg"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
           /* Photo photo=new Photo("output.jpg");
            photo.print();*/
            Iphone11Pro i11=new Iphone11Pro(5,"256GB","12");
            if (i11.getCapacitate().contains("128GB")) {
                i11.setCapacitatePos(new MiddleCapacitate());
            }else
            {
                if(i11.getCapacitate().contains("256GB") || i11.getCapacitate().contains("512GB"))
                    i11.setCapacitatePos(new HighCapacitate());
                else
                    i11.setCapacitatePos(new LowCapacitate());
            }
            System.out.println(i11.getCapacitate());
            i11.addAccesorii(new Accesoriu("casti"));
            i11.addAccesorii(new Accesoriu("incarcator"));
            i11.print();
            FirstObserver firstObserver = new FirstObserver();
            SecondObserver secondObserver = new SecondObserver();
            i11.addObserver(firstObserver);
            i11.addObserver(secondObserver);
            i11.setNewValue("11");
            Iphone12 i12=new Iphone12(6,"256GB","16");
            Iphone12 i121=new Iphone12(7,"516GB","16");
            i12.addAccesorii(new Accesoriu("incarcator"));
            ManagerDoc.getInstance().setMobile(i12);
            ManagerDoc.getMobile().print();
            i12.accept(nr);
            i11.accept(nr);
            i121.accept(nr);
            nr.printCount();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


}
