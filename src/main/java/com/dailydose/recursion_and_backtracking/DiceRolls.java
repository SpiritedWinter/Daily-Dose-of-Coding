package com.dailydose.recursion_and_backtracking;

import java.util.* ;

public class DiceRolls{
    public static void main(String[] args){
        // given n,k we need to recalculate
        int n=2;
        int k=6;
        ArrayList<Integer> dice=new ArrayList<>();
        for(int i=1; i<=k;i++){
            dice.add(i);
        }
        ArrayList<ArrayList<Integer>> dices= new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> d=new ArrayList<>(dice);
            dices.add(d);
        }

        int countRolls= numRolls(dices, 7,0);
        System.out.println(countRolls);
    }

    public static  int numRolls(ArrayList<ArrayList<Integer>> dice,int target, int index){
        if(target<0){
            return 0;
        }
        if(index==dice.size()){
            return target==0?1:0;
        }
        ArrayList<Integer> currentDice= dice.get(index);
        int count=0;
        for(int i=0;i<currentDice.size();i++){
            count+=numRolls(dice,target-currentDice.get(i),index+1);
        }


        return count;
    }
}