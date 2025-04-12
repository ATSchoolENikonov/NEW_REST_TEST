package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Array_Exrec {
    public static void main(String[] args) {
//        ArrayList<String> arrayList= new ArrayList<>();
//        arrayList.add("Ivan");
//        arrayList.add("Ivan2");
//        arrayList.add("Ivan3");
//        arrayList.add("Ivan4");
//        arrayList.add("Ivan5");
//        arrayList.remove("Ivan2");
//        if(arrayList.contains("Ivan")){
//            System.out.println(arrayList);
//        }
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("Ivan","777");
        hashMap.put("Pavel","5555");
        hashMap.put("Egor","345");
        System.out.println(hashMap.get("Ivan"));
        System.out.println(hashMap.containsValue("123-456"));
        for (String key: hashMap.keySet()){
            System.out.println(key + "=" + hashMap.get(key));
        }
    }
}
