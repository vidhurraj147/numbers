package com.lotterycheck.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.*;
import java.util.Map.Entry.*;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ImplementingArraysLogic {
	
	public static void implementing(){
 		HashMap<Integer, Integer> occuranceNumbers = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> powerBallNumbers = new HashMap<Integer, Integer>();
		for(int i=1;i<80;i++){
			occuranceNumbers.put(i, 0);
			if(i<26){
				powerBallNumbers.put(i, 0);
			}
		}
		// System.out.println("occurance "+occuranceNumbers+"  -- powerball"+powerBallNumbers);
		HashMap<String, ArrayList<Integer>> map_actual = KeysandArrayValues.gethashMap("Map_ACTUAL");
        // System.out.println("map_actual --> "+map_actual);
        java.util.Iterator<Entry<String, ArrayList<Integer>>> it = map_actual.entrySet().iterator();
        while(it.hasNext()){
                Map.Entry pair = (Map.Entry)it.next();
                // System.out.println(pair.getKey() + " = " + pair.getValue());
                ArrayList<Integer> valuesreceived = new ArrayList<Integer>();
                valuesreceived = (ArrayList<Integer>) pair.getValue();
                int countPB = 0;
                // System.out.println(valuesreceived);
                for(int value:valuesreceived){
                	countPB++; 
                	System.out.println("value "+value);
                	int mapValue = occuranceNumbers.get(value);
                	mapValue++;
                	if(countPB < 6){
                		occuranceNumbers.replace(value, mapValue);
                	}else{
                		powerBallNumbers.replace(value, mapValue);
                	}
                }
                it.remove(); // avoids a ConcurrentModificationException
        }
        System.out.println("ActualNumber "+occuranceNumbers);
        System.out.println("powerBallNumbers "+powerBallNumbers);
        
        System.out.println("\n \n \n ");

        // let's sort this map by values first
        Map<Integer, Integer> occuranceNumbersSorted = occuranceNumbers
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(
                		Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                        LinkedHashMap::new));
        
        System.out.println("map after occuranceNumbersSorted: " + occuranceNumbersSorted);
        
        Map<Integer, Integer> powerBallNumbersSorted = powerBallNumbers
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue())
                .collect(
                		Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                        LinkedHashMap::new));
        
        System.out.println("map after powerBallNumbersSorted by values: " + powerBallNumbersSorted);

        
        
//        java.util.Iterator<Entry<Integer, Integer>> itoccuranceNumbers = occuranceNumbers.entrySet().iterator();
//        java.util.Iterator<Entry<Integer, Integer>> itpowerBallNumbers = powerBallNumbers.entrySet().iterator();
//        while(itoccuranceNumbers.hasNext()){
//                Map.Entry pair = (Map.Entry)itoccuranceNumbers.next();
//                System.out.println(pair.getKey() + " = " + pair.getValue());
//        }
//        while(itpowerBallNumbers.hasNext()){
//                Map.Entry pair = (Map.Entry)itpowerBallNumbers.next();
//                System.out.println(pair.getKey() + " = " + pair.getValue());
//        }
        
//        HashMap<String, ArrayList<Integer>> map_ASC = KeysandArrayValues.gethashMap("Map_ASC");
//        System.out.println("map_ASC --> "+map_ASC);
//        HashMap<String, ArrayList<Integer>> map_DSC = KeysandArrayValues.gethashMap("Map_DSC");
//        System.out.println("map_DSC --> "+map_DSC);
	}
}
