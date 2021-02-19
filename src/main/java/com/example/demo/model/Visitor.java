package com.example.demo.model;

public interface Visitor {

    void visit(IphoneX iphoneX);
    void visit(Iphone11 iphone11);
    void visit(Iphone11Pro iphone11Pro);
    void visit(Iphone12 iphone12);
    void visit(Iphone12Max iphone12Max);
    void visit(Iphone12ProMax iphone12ProMax);
    void visit(Y6S y6S);
    void visit(P40 p40);
    void visit(P40Lite p40Lite);
    void visit(A71 a71);
    void visit(M21 m21);
    void visit(S20 s20);
    void visit(CosCumparaturi piese);
    void visit(Accesoriu accesoriu);
    void visit(Casti casti);
    void visit(Incarcator incarcator);
}
