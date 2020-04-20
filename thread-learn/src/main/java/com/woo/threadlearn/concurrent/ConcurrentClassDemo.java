package com.woo.threadlearn.concurrent;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcurrentClassDemo {

    public static void main(String[] arg){
//        Hashtable<String, Integer> hashtable = new Hashtable();
//        hashtable.put("one", 1);
//        hashtable.put("two", 2);
//        hashtable.put("three", 3);
//        Integer n = hashtable.get("two");
//        if(n!=null){
//            System.out.println("two="+n);
//        }

//        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put("one", 1);
//        concurrentHashMap.put("two", 2);
//        concurrentHashMap.put("three", 3);
//        System.out.println(concurrentHashMap.get("one"));
//        if(concurrentHashMap.containsKey("one")&&concurrentHashMap.get("one").equals(1)){
//            concurrentHashMap.remove("one");
//        }
//        System.out.println(concurrentHashMap.get("one"));

//        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
//        copyOnWriteArrayList.add("one");
//        copyOnWriteArrayList.add("three");
//        copyOnWriteArrayList.add(1, "two");
//        System.out.println(copyOnWriteArrayList.get(1));
//        if(copyOnWriteArrayList.contains("three")){
//            Iterator<String> iterator = copyOnWriteArrayList.iterator();
//            while(iterator.hasNext()){
//                System.out.println(iterator.next());
//            }
//        }

//        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
//        copyOnWriteArraySet.add("one");
//        copyOnWriteArraySet.add("three");
//        Iterator<String> stringIterator = copyOnWriteArraySet.iterator();
//        while(stringIterator.hasNext()){
//            System.out.println(stringIterator.next());
//        }

        Vector<String> vector = new Vector<>();
        vector.add("one");
        vector.add("two");
        vector.add("three");
        vector.removeElement("two");
        if(vector.contains("three")){
            Iterator<String> iterator = vector.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
