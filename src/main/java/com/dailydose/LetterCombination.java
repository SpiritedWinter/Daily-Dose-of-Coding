package com.dailydose;

import java.util.*;

public class LetterCombination{
    static Map<Character, String> map = new HashMap<>();
    
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
     public static void main(String[] args){
        ArrayList<String> left = new ArrayList<>();
        left.add("");
        String right = "234";

        System.out.println(letterCompbinationsIter(right));
     }

     //recursive solution
     private static ArrayList<String> letterCombinations(ArrayList<String> result, String mainStr){
        if(mainStr.length()==0){
            return result;
        }
        char ch= mainStr.charAt(0);
        String currStr= map.get(ch);

        ArrayList<String> newres=new ArrayList<>();
        for(int i=0; i<result.size();i++){
            for(int j=0; j<currStr.length();j++){
                newres.add(result.get(i)+currStr.charAt(j));
            }
        }
        letterCombinations(newres,mainStr.substring(1));
        return newres;
     }
     // iterative approach

     public static ArrayList<String> letterCompbinationsIter(String mainStr){
        Queue<String> result= new LinkedList<>();
        result.add("");
        for(int i=0; i<mainStr.length();i++){
            int n=result.size();
            for(int j=0; j<n;j++){
                // pop first element
                String popped=result.poll();
                // we need to get the characters now
                String chr= map.get(mainStr.charAt(i));
                for(int k=0; k<chr.length();k++){
                    String newStr= popped+chr.charAt(k);
                    // new string has to be added in the queue;
                    result.add(newStr);

                }
            }
        }

        return new ArrayList<>(result);
     }
}