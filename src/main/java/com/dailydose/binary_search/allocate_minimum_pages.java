package com.dailydose.binary_search;
import java.util.*;

public class allocate_minimum_pages {
    public static void main(String[] args){
        int[] pages= new int[] {12,34,67,90};
        int k=2;
        System.out.println(allocatePages(pages, k));
    }
    private static int allocatePages(int[] pages, int k){
        int start=Arrays.stream(pages).max().getAsInt();
        int end= Arrays.stream(pages).sum();
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isFeasable(pages,k,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }

        return result;
    }

    private static boolean isFeasable(int[] pages,int k,int mid){
        int student=1;
        int sumPages=0;
        for(int i=0; i<pages.length;i++){
            if(pages[i]+sumPages>mid){
                student+=1;
                sumPages=pages[i];
            }
            else{
                sumPages+=pages[i];
            }

        }
        return student<=k ;
    }
}
