package com.dailydose.recursion_and_backtracking;

import java.util.*;
public class ValidIP {
    public static void main(String[] args){
        ArrayList<String> result=new ArrayList<>();
        validIPAddresses("1231231231234",0,result,3);
        System.out.println(result);
    }

    private static void validIPAddresses(String input,int index,List<String> result,int dotCount){
        if(dotCount<=0){
            //check for the valid IP arrdresses
            if(isValidIP(input)){
                // then insert in the main result
                result.add(input);
            }

            return;
        }

        for(int i=index;i<=input.length()-2;i+=1){
            String newInput= input.substring(0, i+1)+ '.'+ input.substring(i+1);
            validIPAddresses(newInput, i+2, result, dotCount-1);
            

        }
    }

    private static boolean isValidIP(String ip){
        String[] parts = ip.split("\\."); // split on dot (need to escape it with \\)

        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if(parts[i].length()>1 && parts[i].charAt(0)=='0'){
                return false;
            }
            numbers[i] = Integer.parseInt(parts[i]);
            if(numbers[i]>255 || numbers[i]<0){
                return false;
            }
        }

        return true; 
    }
}
