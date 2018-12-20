package com.lotterycheck.numbers;

import java.util.ArrayList;
import java.util.HashMap;

public class ImplementingArraysLogic {
	
	public static void implementing(){
		HashMap<String, ArrayList<Integer>> map_actual = KeysandArrayValues.gethashMap("Map_ACTUAL");
        System.out.println("map_actual --> "+map_actual);
//        HashMap<String, ArrayList<Integer>> map_ASC = KeysandArrayValues.gethashMap("Map_ASC");
//        System.out.println("map_ASC --> "+map_ASC);
//        HashMap<String, ArrayList<Integer>> map_DSC = KeysandArrayValues.gethashMap("Map_DSC");
//        System.out.println("map_DSC --> "+map_DSC);
	}
}
