package com.example.naser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(17);
        int first = list.get(0);
    }
    


    private static void printList(List<? extends Number> myList){
        System.out.println(myList.size());
    }
}

