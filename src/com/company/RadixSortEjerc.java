package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.company.StringUtil.lNormalize;
import static com.company.StringUtil.toStringArray;

public class RadixSortEjerc {
    public static void radixSort(int[] arr) {
        String sArray[] = toStringArray(arr);
        lNormalize(sArray, '0');
        Map<Character, String> map = new HashMap<Character, String>();
        for (int k = sArray[0].length() - 1; k >= 0; k--) {
            pushArrayInHashMap(map,sArray,k);
            regenetateArrayFromMap(map, sArray);
        }
        showArray(sArray);
    }

    public  static void pushArrayInHashMap(Map<Character, String> map, String[] arr, int indexToEvaluate){
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i].charAt(indexToEvaluate)) == null) {
                map.put(arr[i].charAt(indexToEvaluate), arr[i]);
            } else {
                map.put(arr[i].charAt(indexToEvaluate), map.get(arr[i].charAt(indexToEvaluate)) + "," + arr[i]);
            }
        }
    }

    public static void regenetateArrayFromMap(Map<Character, String> map, String[] arr) {
        int count = 0;
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            String aux[] = entry.getValue().split((","));
            for (int j = 0; j < aux.length; j++) {
                arr[count++] = aux[j];
            }
        }
        map.clear();
    }

    public static void main(String[] args) {
        int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
        if(arr.length ==0 )
            System.out.println("Array sin elementos para evaluar.");
        else
            radixSort(arr);
    }

    public static void showArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? "," : ""));
        }
    }
}

