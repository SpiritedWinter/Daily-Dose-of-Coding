package com.dailydose;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> in = new ArrayList<>(Arrays.asList(1, 2,2, 3));

        System.out.println(subsetsDuplicates(in));
    }
    //finding subset of the array using the iterative approach

    // this approach is very similar to level order traaversal of a binary tree


    // take the previous result and add new elements to form a new sub array
    // Input : [1,2,3]
    // first Iteration
    //                               [ ]
    //              []                                [1]
    //     []           [1]               [2]                     [1,2]
    // []     [1]  [2]    [1,2]      [3]       [1,3]        [2,3]        [1,2,3]
    
    public static List<List<Integer>> subsets(ArrayList<Integer> nums){
        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num:nums){
            int n=result.size();
            for(int i=0;i <n;i++){
                ArrayList<Integer> subset=new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }

    public static List<List<Integer>> subsetsDuplicates(ArrayList<Integer> nums){
        List<List<Integer>> result= new ArrayList<>();
        result.add(new ArrayList<>());
        int start=0;
        int end=0;
        for(int i=0;i<nums.size();i++){
            start=0;
            if(i>0 && nums.get(i-1)==nums.get(i)){
                start=end+1;
            }
            end=result.size();
            for(int j=start;j<end;j++){
                ArrayList<Integer> subset=new ArrayList<>(result.get(j));
                subset.add(nums.get(i));
                result.add(subset);
            }
            end=0;
        }
        return result;
    }
} 