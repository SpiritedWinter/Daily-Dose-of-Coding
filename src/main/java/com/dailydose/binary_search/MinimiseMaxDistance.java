package com.dailydose.binary_search;

public class MinimiseMaxDistance {
    public static void main(String[] args){
        int[] stations=new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k=9;
        System.out.println(minimiseMaxDistance(stations, k));

    }
    public static double minimiseMaxDistance(int[] stations,int k){
        double start=0;
        double end= stations[stations.length-1]-stations[0];
        double epsilon=1e-6;
        while(end-start>epsilon){
            double mid=start+ (end-start)/2;
            if(isFeasible(stations,k,mid)){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }

        return end;
    }

    public static boolean isFeasible(int[] distance,int k,double minDistance){
        int gasStations=0;
        for(int i=1;i<distance.length;i++){
            int diff=distance[i]-distance[i-1];
            if(diff>minDistance){
                gasStations+=(int)(diff/minDistance);
                if(gasStations>k){
                    return false;
                }
            }

        }

        return gasStations<=k;
        
    }
}
