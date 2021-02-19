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
            connect();
            SpringApplication.run(DemoApplication.class, args);
            String par = String.join(",", getId(4));
            String[] par1=par.split(" ");
            Person p=new Person(Integer.valueOf(par1[0]),par1[1]);
            System.out.println("* Persoana: " + p.getName()+ " a accesat site-ul:");
            Site site = new ProxySite();
            site.connectTo("https://altex.ro/telefoane/cpl");
            MobileCount nr=new MobileCount();
            CosCumparaturi cosCumparaturi=new CosCumparaturi();
            List<Produs>listcumparate=new ArrayList<>();
            String[] parts = getIdProdus(4).split(" ");
            Telefon s20=new S20(Integer.valueOf(parts[0]),parts[3],parts[4],4000);
            cosCumparaturi.addContent(s20);
            Accesoriu a1=new Casti("casti","Iphone",800);
            cosCumparaturi.addContent(a1);
            listcumparate.add(a1);
            a1.accept(nr);
            s20.accept(nr);
            String[] parts1 = getIdProdus(3).split(" ");
            IphoneX ix=new IphoneX(Integer.valueOf(parts1[0]),parts1[3],parts1[4],4200);
            ix.accept(nr);
            listcumparate.add(ix);
            cosCumparaturi.addContent(ix);
            System.out.println("\n* A adaugat in cosul de cumparaturi produsele: ");
            cosCumparaturi.print();
            System.out.println("\n* A cumparat produsele: ");
            p.cumpara(listcumparate);
           /* File file = new File("output.jpg");
            BufferedImage image = null;
            try
            {
                image = ImageIO.read(file);
                ImageIO.write(image, "jpg", new File("output1.jpg"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }*/
          //  Photo photo=new Photo("output.jpg");
          //  photo.print();
            System.out.println("\n* Caracteristici telefon cumparat: ");
            if (ix.getCapacitate().contains("128GB")) {
                ix.setCapacitatePos(new MiddleCapacitate());
            }else
            {
                if(ix.getCapacitate().contains("256GB") || ix.getCapacitate().contains("512GB"))
                    ix.setCapacitatePos(new HighCapacitate());
                else
                    ix.setCapacitatePos(new LowCapacitate());
            }
            System.out.println(ix.getCapacitate());
            Accesoriu a2=new Incarcator("incarcator","Iphone",100);
            a2.accept(nr);
            ix.addAccesorii(a1);
            ix.print();
            System.out.println("\n* Schimbare pret produs: ");
            FirstObserver firstObserver = new FirstObserver();
            SecondObserver secondObserver = new SecondObserver();
            ix.addObserver(firstObserver);
            ix.addObserver(secondObserver);
            ix.setNewValue(3900);

            System.out.println("\n* Mai vizualizeaza si produsele: ");
            Iphone12 i121=new Iphone12(7,"516GB","16",5200);
            Iphone12 i12=new Iphone12(6,"256GB","16",4800);
            i12.addAccesorii(a2);
            ManagerDoc.getInstance().setMobile(i12);
            ManagerDoc.getMobile().print();
            System.out.println("");
            ManagerDoc.getInstance().setMobile(i121);
            ManagerDoc.getMobile().print();
            i12.accept(nr);
            i121.accept(nr);
            System.out.println("\n* Obiecte vizualizate: ");
            nr.printCount();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


}
