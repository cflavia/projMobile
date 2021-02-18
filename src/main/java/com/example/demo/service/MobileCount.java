package com.example.demo.service;

import com.example.demo.model.*;

public class MobileCount implements Visitor {

    int iphoneX=0;
    int iphone11=0;
    int iphone11Pro=0;
    int iphone12=0;
    int iphone12Max=0;
    int iphone12ProMax=0;
    int P40=0;
    int P40Lite=0;
    int S20=0;
    int Y6S=0;
    int A71=0;
    int M21=0;
    int Piese=0;
    @Override
    public void visit(IphoneX i) {
        iphoneX++;
    }

    @Override
    public void visit(Iphone11 i) {
        iphone11++;
    }

    @Override
    public void visit(Iphone11Pro i) {
        iphone11Pro++;
    }

    @Override
    public void visit(Iphone12 i) {
        iphone12++;
    }

    @Override
    public void visit(Iphone12Max i) {
        iphone12Max++;
    }

    @Override
    public void visit(Iphone12ProMax i) {
        iphone12ProMax++;
    }

    @Override
    public void visit(Y6S y) {
        Y6S++;
    }

    @Override
    public void visit(P40 p) {
        P40++;
    }

    @Override
    public void visit(P40Lite p) {
        P40Lite++;
    }

    @Override
    public void visit(A71 a71) {
        A71++;
    }

    @Override
    public void visit(M21 m) {
        M21++;
    }

    @Override
    public void visit(S20 s20) {
        S20++;
    }

    @Override
    public void visit(Piese piese) {
        Piese++;
    }


    public void printCount(){
        System.out.println(
                "IphoneX: "+iphoneX+
                        "\nIphone11: "+iphone11
                        +"\nIphone11Pro: "+iphone11Pro
                        +"\nIphone12: "+iphone12
                        +"\nIphone12Max: "+iphone12Max
                        +"\nIphone12ProMax: "+iphone12ProMax
                +"\nS20: "+S20
                +"\nA71: "+A71
                        +"\nM21: "+ M21
                +"\nP40: "+P40
                        +"\nP40Lite"+P40Lite+
                "\nY6S: "+Y6S);
    }
}
