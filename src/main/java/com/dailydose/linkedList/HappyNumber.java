package com.dailydose.linkedList;

public class HappyNumber {
    public static void main(String[] args){

    }

    public static boolean happyNumber(int n){

        int slow=n;
        int fast=n;

        do{
            slow=findSquareSum(n);
            fast=findSquareSum(findSquareSum(n));
        }
        while(slow!=fast);

        if(slow==1){
            return true;
        }
        return false;

        
    }

    public static int findSquareSum(int n){
        int result=0;
        while(n>0){
            int rem=n%10;
            result+=rem*rem;
            n/=10;
        }
        return result;
    }
}
