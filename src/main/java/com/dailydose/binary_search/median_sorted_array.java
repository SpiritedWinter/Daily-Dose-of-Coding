package com.dailydose.binary_search;

public class median_sorted_array {
    public static void main(String[] args){
        int[] nums1= new int[]{1,2,3};
        int[] nums2= new int[]{4,5,6,7,8};
        double median= findMedian(nums1,nums2);
        System.out.println(median);
    }

    public static double findMedian(int[] nums1,int[] nums2){
        
        if(nums1.length>nums2.length){
            return findMedian(nums2, nums1);
            
        }
        int median=0;
        // main logic here
        int n1= nums1.length;
        int n2=nums2.length;
        int left=0;
        int right= n1;
        while(left<=right){
            int cut1=(left+right)/2;
            int cut2= (n1+n2+1)/2 -cut1;


            int L1= cut1==0? Integer.MIN_VALUE:nums1[cut1-1];
            int L2= cut2==0? Integer.MIN_VALUE:nums2[cut2-1];
            int R1= cut1==n1? Integer.MAX_VALUE:nums1[cut1];
            int R2= cut2==n2? Integer.MAX_VALUE:nums2[cut2];

            if(L1<=R2 && L2<=R1){
                if((n1+n2)%2==0){
                    return (Math.max(L1,L2)+Math.min(R1,R2))/2;
                }
                else{
                    return Math.max(L1,L2);
                }
            }
            if (R1 > L2) {
                left = cut1 + 1;
            } else {
                right = cut2 - 1;
            }
        }
        //
        return median;
    }
}
