package com.dailydose.binary_search;
import java.util.*;
public class minimum_time_to_complete_trip {
    public static void main(String[] args){
        int[] time=new int[]{10000};
        
        long minDays=minimumTime(time,10000000);
        System.out.println(minDays);
    }

    public static long minimumTime(int[] time, int totalTrips){
        // this problem is pretty stright forward becausewe are given search space that
        // min time complete total trips could be max of that array
        // and the max time could be total trip * max of that array
        // so we kno the search space now
        long start=1;
        long end= (long) Arrays.stream(time).min().getAsInt() * totalTrips;

        while( start<end){
            long mid=start+(end-start)/2;
            if(isFeasable(time, totalTrips, mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return (long)start;
    }

    public static boolean isFeasable(int[] time,int totaltrips, long thisTime){
        long trips = 0;
        for(int bus : time){
            trips += thisTime / bus;  // much faster than while loop
        }
        return trips >= totaltrips;
    }
}
