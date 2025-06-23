package com.dailydose.binary_search;
import java.util.*;
public class CapacityToShipPackageWithinDays {
    public static void main(String[] args){
        int[] weights=new int[]{1,2,3,4,5,6,7,8,9,10};
        int days=5;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights,int days){
        int start= Arrays.stream(weights).max().getAsInt();
        int end=Arrays.stream(weights).sum();
        while(start<end){
            int mid=start+(end-start)/2;
            if(isFeasible(weights,days,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }

    private static boolean isFeasible(int[] weights,int days,int minCapacity){
        int countDays=1;
        int weightSum=0;
        for(int i=0;i<weights.length;i++){
            if(weightSum+weights[i]>minCapacity){
                countDays+=1;
                weightSum=weights[i];
            }
            else{
                weightSum+=weights[i];
            }
            if(countDays>days){
                return false;
            }
        }

        return true;


    }
}
