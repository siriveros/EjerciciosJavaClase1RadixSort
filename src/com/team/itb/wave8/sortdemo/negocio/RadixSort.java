package com.team.itb.wave8.sortdemo.negocio;

import com.team.itb.wave8.sortdemo.utils.StringUtils;

import java.util.*;
import java.util.stream.Stream;

public class RadixSort {

    public static final String DEFAULT_NORMALIZE_CHARACTER = "0";

    public static int[] sort(int arr[],String normalizeCharacter){
        String strArr[] = StringUtils.toStringArray(arr);
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

        return StringUtils.toIntArray(strArr);
    }

    public static int[] sort(int arr[]){
        return sort(arr,DEFAULT_NORMALIZE_CHARACTER);
    }




}
