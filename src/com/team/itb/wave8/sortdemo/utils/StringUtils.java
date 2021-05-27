package com.team.itb.wave8.sortdemo.utils;

import java.util.Locale;

public class StringUtils {

    public static String[] toStringArray (int arr[]){
        String strArray[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArray[i] = String.valueOf(arr[i]);
        }
        return strArray;
    }

    public static int[] toIntArray (String arr[]){
        int intArray[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArray[i] = Integer.parseInt(arr[i]);
        }
        return intArray;
    }

    public static int maxLength(String arr[]){
        int maxStringLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if(maxStringLength < arr[i].length()){
                maxStringLength = arr[i].length();
            }
        }
        return maxStringLength;
    }

    public static String[] normalizeStringArray(String arr[],int maxStringLength,String normalizeCharacter){
        for (int i = 0; i < arr.length; i++) {
            int missingCharacters = maxStringLength - arr[i].length();
            if(missingCharacters > 0){
                arr[i] = addMissingCharacters(arr[i],normalizeCharacter,missingCharacters);
            }
        }
        return arr;
    }

    public static String addMissingCharacters(String word, String normalizeCharacter, int missingCharacters){
        for (int i = 0; i < missingCharacters; i++) {
            word = normalizeCharacter + word;
        }
        return word;
    }

    public static String getCharacterAtPosition(String word, int pos){
        return String.valueOf(word.charAt(pos)).toLowerCase();
    }

}
