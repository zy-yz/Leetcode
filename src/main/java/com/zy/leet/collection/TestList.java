package com.zy.leet.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestList {
    public static void main(String[] args) {

        List<String> arrayList1 = new ArrayList();
        arrayList1.add("1");

        List<String> arrayList2 = new ArrayList<String>(){{
            add("1");
            add("2");
        }};

        List<String> arrayList3 = Arrays.asList("1","2");

        List<String> arrayList4  = Stream.of("1","2").collect(Collectors.toList());

        //List<String> arraylist5 = Lists.newArrayLisy("1","2");
        List<String> arrayList = new ArrayList<String>(10);

        arrayList.add("12");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.set(5,"5");
        System.out.println(arrayList.get(5));
        arrayList.add(5,"55");
        System.out.println(arrayList.get(5));
        arrayList.remove("55");
        System.out.println(arrayList.get(5));
        arrayList.clear();
        arrayList.addAll(0,arrayList1);
        System.out.println(arrayList.get(0));
        //System.out.println(arrayList.get(5));


//        for (int i = 0; i < arrayList.size(); i++) {
//            String app1 = arrayList.get(i);
//            for (int j = i + 1; j < arrayList.size(); j++) {
//                String app2 = arrayList.get(j);
//                if (app1.compareTo(app2) == 0) {
//                    arrayList.remove(app2);
//                    j--;
//                    ((ArrayList<String>) arrayList).trimToSize();
//                }
//            }
//        }

       // ((ArrayList<String>) arrayList).trimToSize();
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains("1"));
        System.out.println(arrayList.indexOf("2"));



        System.out.println("d ");

    }
}
