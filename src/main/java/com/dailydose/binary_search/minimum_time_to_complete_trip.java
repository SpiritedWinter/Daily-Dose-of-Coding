package com.dailydose.binary_search;
import java.util.*;
public class minimum_time_to_complete_trip {
    public static void main(String[] args){
        int[] time=new int[]{1,2,3};
        
        long minDays=minimumTime(time,5);
        System.out.println(minDays);
    }

    private static long minimumTime(int[] time,int totalTrips){
        long start=1;
        long end= (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        while(start<end){
            long mid=start+(end-start)/2;
            if(isFeasible(time,totalTrips,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return start;
    }

    private static boolean isFeasible(int[] time,int totalTrips,long minDays){
        int trips=0;
        for(int i=0;i<time.length;i++){
            trips+=minDays/time[i];
            if(trips>=totalTrips){
                return true;
            }
        }

        return false;
    }



}
