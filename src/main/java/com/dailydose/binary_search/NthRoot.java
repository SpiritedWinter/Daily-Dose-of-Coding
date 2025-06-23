package com.dailydose.binary_search;

public class NthRoot {
    public static void main(String[] args){
        System.out.println(NthRoot(3, 27));
    }
    public static int NthRoot(int N, int M){
         int start=1;
         int end= M;

         while(start<end){
            int mid=start+(end-start)/2;
            if(Math.pow(mid, N)>=M){
                end=mid;
            }
            else{
                start=mid+1;
            }
         }

         return start;
    }


}
