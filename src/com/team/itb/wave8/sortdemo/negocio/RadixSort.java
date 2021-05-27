package com.team.itb.wave8.sortdemo.negocio;

import com.team.itb.wave8.sortdemo.utils.StringUtils;

import java.util.*;
import java.util.stream.Stream;

public class RadixSort {

    public static final String DEFAULT_NUMBER_NORMALIZE_CHARACTER = "0";
    public static final String DEFAULT_STRING_NORMALIZE_CHARACTER = " ";

    public static int[] sort(int arr[],String normalizeCharacter){
        String strArr[] = StringUtils.toStringArray(arr);
        return StringUtils.toIntArray(sort(strArr,normalizeCharacter));
    }

    public static int[] sort(int arr[]){
        return sort(arr, DEFAULT_NUMBER_NORMALIZE_CHARACTER);
    }

    public static String[] sort(String arr[]){
        return sort(arr, DEFAULT_STRING_NORMALIZE_CHARACTER);
    }

    public static String[] sort(String strArr[],String normalizeCharacter){
        int maxStringLength = StringUtils.maxLength(strArr);
        strArr = StringUtils.normalizeStringArray(strArr,maxStringLength, normalizeCharacter);

        SortedMap<String, List<String>> map = new TreeMap<>();

        for (int i = maxStringLength -1; i >= 0; i--) {
            for (int j = 0; j < strArr.length; j++) {
                String currentCharacter = StringUtils.getCharacterAtPosition(strArr[j],i);
                if(map.containsKey(currentCharacter)){
                    map.get(currentCharacter).add(strArr[j]);
                } else {
                    List<String> words = new ArrayList<>();
                    words.add(strArr[j]);
                    map.put(currentCharacter,words);
                }
            }
            strArr = new String[0];
            for (Map.Entry<String,List<String>> entry: map.entrySet()) {
                strArr = Stream.concat(Arrays.stream(strArr),Arrays.stream(entry.getValue().toArray())).toArray(String[]::new);
            }
            map.clear();
        }

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].trim();
        }
        return strArr;
    }



}
