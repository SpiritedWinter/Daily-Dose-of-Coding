package com.dailydose;

import java.util.*;
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {

        System.out.println(permutationIter("abc"));
    }

    public static ArrayList<String> permutation(String mainStr, String res) {
        if (mainStr.length() == 0) {
            ArrayList<String> lastres = new ArrayList<String>();
            lastres.add(res);
            return lastres;
        }

        char ch = mainStr.charAt(0);

        ArrayList<String> finalres = new ArrayList<>();
        for (int i = 0; i <=res.length(); i++) {
            String newres = res.substring(0, i) + ch + res.substring(i);
            finalres.addAll(permutation(mainStr.substring(1), newres));
        }

        return finalres;
    }

    // now the function which takes in th  result array and returns it
    public static ArrayList<String> permutations2(String mainStr,String resStr, ArrayList<String> result){
        if(mainStr.length()==0){
            result.add(resStr);
            return result;
        }

        char ch=mainStr.charAt(0);
        for(int i=0;i<=resStr.length();i++){
            String newStr= resStr.substring(0, i)+ch+ resStr.substring(i);
            permutations2(mainStr.substring(1), newStr,result);
            
        }

        return result;
    }

    //iterative approach ---- must do the iterative approach for the recursive solution it will help me in dp
    public static Queue<String> permutationIter(String str){
        // your code here
        // we are going over each character in the main string and finding all the possible places we can keep the character in the res string
        // so the result string should start from the empty string
        // then for each selected string from the array we will form a new string with the previous result
        // this time we not keeping the pervius strings in the result we can use stack to pop out the first result
        Queue<String> result=new LinkedList<>();
        result.add("");
        for(int i=0; i<str.length();i++){
            int n=result.size();
            for(int j=0; j<n;j++){
                String poppedStr=result.poll();
                for(int k=0; k<=poppedStr.length();k++){
                    String newStr= poppedStr.substring(0, k)+ str.charAt(i)+ poppedStr.substring(k);
                    result.add(newStr);
                }
            }
        }
        return result;
    }
}
