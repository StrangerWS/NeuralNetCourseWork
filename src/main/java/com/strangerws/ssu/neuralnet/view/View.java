package com.strangerws.ssu.neuralnet.view;

import java.util.ArrayList;
import java.util.Scanner;

public class View{

    public void printMsg(String msg){
        System.out.println(msg);
    }

    public void printArray(ArrayList<Character> array){
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}