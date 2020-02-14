package com.example.beirut;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

    public final String p1;
    public final String p2;
    public int p1makes;
    public int p2makes;
    public int p1misses;
    public int p2misses;
    public int p1last;
    public int p2last;
    public int p1head;
    public int p2head;
    public ArrayList<Integer> p1List;
    public ArrayList<Integer> p2List;


    public Game(String player1, String player2){
        p1 = player1;
        p2 = player2;
        p1makes=0;
        p2makes=0;
        p1misses=0;
        p2misses=0;
        p1last=0;
        p2last=0;
        p1head=0;
        p2head=0;
        p1List = new ArrayList<Integer>();
        p2List = new ArrayList<Integer>();
    }
}
