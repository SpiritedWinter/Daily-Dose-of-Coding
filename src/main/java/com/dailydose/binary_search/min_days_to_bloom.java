package com.dailydose.binary_search;
import java.util.*;
public class min_days_to_bloom {
    public static void main(String[] args){
        int[] flowers=new int[]{7,7,7,7,12,7,7};
        int m=2;
        int k=3;
        System.out.println(findMin(flowers, m, k));
    }
    private static int findMin(int[] flowers, int m, int k){
        // need to make m bouquets
        // with k adjacent flowers
        int start=Arrays.stream(flowers).min().getAsInt();
        int end=Arrays.stream(flowers).max().getAsInt()*m*k;
        int answer=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isFeasible(flowers,m,k,mid)){
                answer=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return answer;
    }

    private static boolean isFeasible(int[] flowers,int m, int k, int minDays){
         int bouquets=0;
         int flowerCount=0;
         for(int i=0;i<flowers.length;i++){
            if(flowers[i]<=minDays){
                flowerCount+=1;
                if(flowerCount==k){
                    bouquets++;
                    flowerCount=0;
                }
            }
            else{
                flowerCount=0;
            }
         }

         return bouquets>=m;

    }
}
