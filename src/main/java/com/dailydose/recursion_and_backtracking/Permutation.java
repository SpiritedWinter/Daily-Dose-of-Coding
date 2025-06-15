package com.dailydose.recursion_and_backtracking;

import java.util.*;
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        List<String> result=new ArrayList<>();
        validParenthesis(3,0,0,new StringBuilder(),result);
        
        System.out.println(result);
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
    public static ArrayList<String> permutations(String mainStr,String resStr, ArrayList<String> result){
        if(mainStr.length()==0){
            result.add(resStr);
            return result;
        }

        char ch=mainStr.charAt(0);
        for(int i=0;i<=resStr.length();i++){
            String newStr= resStr.substring(0, i)+ch+ resStr.substring(i);
            permutations(mainStr.substring(1), newStr,result);
            
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


    public static Queue<ArrayList<Integer>> Permutations2(int[] nums){
        Queue<ArrayList<Integer>> result= new LinkedList<>();
        ArrayList<Integer> prevRes=new ArrayList<>();
        
        result.add(new ArrayList<>());

        for(int i=0; i<nums.length;i++){
            Set<List<Integer>> used = new HashSet<>();
            int n= result.size();
            for(int j=0; j<n;j++){
                ArrayList<Integer> popped= result.poll();
                for(int k=0; k<=popped.size();k++){
                    ArrayList<Integer> newres= new ArrayList<>(popped);
                    
                    newres.add(k,nums[i]);
                    if(used.add(newres)){
                        result.add(newres);
                    }
                }
            }
        }
        return result;

    }

    public static void subset2(int[] nums,int i, ArrayList<Integer> curr,ArrayList<ArrayList<Integer>> result){
        result.add(new ArrayList<>(curr));

        for (int row = i; row < nums.length; row++) {
            // Prune duplicates at the same level
            if (row > i && nums[row] == nums[row - 1]) continue;
    
            curr.add(nums[row]);
            subset2(nums, row + 1, curr, result);
            curr.remove(curr.size() - 1); // backtrack
        }
    }

    private static void subsetbt(int[] arr, int index,ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){

        result.add(new ArrayList<>(curr));

        for(int i=index; i<arr.length;i++){

            curr.add(arr[i]);
            subsetbt(arr, i+1, curr, result);
            curr.remove(curr.size()-1);
        }



    }

    public static void stringPermutation(char[] input,int index,List<String> result){
        if(index>=input.length){
            result.add( new String(input));
            return;
        }
        if (Character.isDigit(input[index])) {
            stringPermutation(input, index + 1, result);
            return;
        }
    
        // Branch 1: Uppercase
        input[index]^=32;
        stringPermutation(input, index + 1, result);
    
        // Branch 2: Lowercase
        input[index]^=32;
        stringPermutation(input, index + 1, result);
        
    }

    private static void validParenthesis(int n, int left,int right,StringBuilder str, List<String> result){
        if(str.length()>=2*n){
            if(isValidP(str.toString())){
                result.add(str.toString());
            }
            
            return;
        }

        if(left<n){
            str.append('(');
            validParenthesis(n, left+1, right, str, result);
            str.deleteCharAt(str.length()-1);
        }
        if(right<left){
            str.append(')');
            validParenthesis(n, left, right+1, str, result);
            str.deleteCharAt(str.length()-1);
        }
    }

    private static boolean isValidP(String paran){
        int balance=0;

        for(int i=0;i<paran.length();i++){
            if(paran.charAt(i)=='('){
                balance++;
            }
            else{
                balance--;
            }
            if(balance<0){
                return false;
            }
        }
        return balance==0;
    }


    


}

