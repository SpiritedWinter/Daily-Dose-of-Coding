package com.dailydose.recursion_and_backtracking;

import java.util.*;
public class CombinationSum {
    public static void main(String[] args){
        int[] array= new int[]{1,2,2,2,5};
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(result,new ArrayList<>(),1,3,9);
        System.out.println(result);

    }

    public static List<List<Integer>> combinationSum(int[] array, ArrayList<Integer> curr, ArrayList<List<Integer>> result, int target, int pointer){
        if(target==0){
            ArrayList<Integer> newIns= new ArrayList<>(curr);
            result.add(newIns);
            return result;
        }
        if(target<0|| pointer>=array.length){
            return result ;
        }

        for (int i=pointer; i<array.length;i++){
            curr.add(array[i]);
            combinationSum(array, curr, result, target-array[i],i);
            curr.remove(curr.size()-1);
        }

        return result;


    }

    public static List<List<Integer>> combinationSum2(int[] array, ArrayList<Integer> curr, ArrayList<List<Integer>> result, int target, int pointer){
        if(target==0){
            ArrayList<Integer> newIns= new ArrayList<>(curr);
            result.add(newIns);
            return result;
        }
        if(target<0){
            return result ;
        }

        for (int i=pointer; i<array.length;i++){

            if(i>pointer && array[i]==array[i-1]) continue;
            
            curr.add(array[i]);
            combinationSum2(array, curr, result, target-array[i],i+1);
            curr.remove(curr.size()-1);
        }

        return result;


    }

    private static void combinations(int[] arr,int index, int target, ArrayList<Integer> curr,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target<0|| index>=arr.length){
            return;
        }

        curr.add(arr[index]);
        combinations(arr,index+1,target-arr[index],curr,result);
        curr.remove(curr.size()-1);


        // we will not take same elements
        while(index<arr.length-1 && arr[index]==arr[index+1]){
            index++;
        }

        combinations(arr,index+1,target,curr,result);
    }

    private static void kCombinations(int index, int n, int k , ArrayList<Integer> currState, List<List<Integer>> result){
        if(currState.size()==k){
            result.add(new ArrayList<>(currState));
            return;
        }
        if(currState.size()>k){
            return;
        }
        for(int i=index ; i<=n; i++){
            currState.add(i);
            kCombinations(i+1, n, k, currState, result);
            currState.remove(currState.size()-1);
        }
    }

    private static void combinationSum3(List<List<Integer>> result, ArrayList<Integer> currState, int index,int k, int target){
        if(currState.size()==k){
            if(target==0){
                result.add(new ArrayList<>(currState));
            }
            
            return;
        }

        if(currState.size()>k){
            return;
        }

        for(int i=index; i<=9;i++){
            currState.add(i);
            combinationSum3(result, currState, i+1, k, target-i);
            currState.remove(currState.size()-1);
        }
    }
 
}
