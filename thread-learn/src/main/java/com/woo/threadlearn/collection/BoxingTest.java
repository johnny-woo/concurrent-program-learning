package com.woo.threadlearn.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BoxingTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }
        System.out.println(list.toString());
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer i = iterator.next();
            if(i==8){
                iterator.remove();
            }
        }
        System.out.println(list.toString());
    }
}