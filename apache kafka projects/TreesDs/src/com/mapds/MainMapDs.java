package com.mapds;

public class MainMapDs {

    public static void main(String[] args) {

        MapUsingHsh map = new MapUsingHsh();
        map.put("apple","01");
        map.put("mango","04");
        map.put("papaya","06");
        map.put("banana","09");

        System.out.println(map.get("apple"));

        /////map using linked list
        HashMapLinkList<String,String> map1 = new HashMapLinkList<>();
        map1.put("apple","01");
        map1.put("mango","04");
        map1.put("papaya","06");
        map1.put("banana","09");

        System.out.println(map1.toString());
    }
}
