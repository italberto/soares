/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.starter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class teste {

    public static void main(String[] args) {

        Map<String, Integer> unsortMap = new HashMap<String, Integer>();
        unsortMap.put("D", 9);
        unsortMap.put("C", 7);
        unsortMap.put("A", 1);

        System.out.println("Unsort Map......");
        printMap(unsortMap);

        System.out.println("\nSorted Map......");
        Map<String, Integer> treeMap = new TreeMap<String, Integer>(
                new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }

                });

        treeMap.putAll(unsortMap);
        printMap(treeMap);

    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }

}
