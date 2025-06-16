package com.dailydose.binary_search;
import java.util.*;
public class Intersection_array {
    public static void main(String[] args){
        int[][]  matrix=new int[][]{{1,5,9},{10,11,12},{12,13,15}};
        System.out.println(kthSmallest(matrix,8));
    }

    public static int[] getIntersecitonBS(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        HashSet<Integer> set= new HashSet<>();
        int i=0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                set.add(nums1[i]);
                i++;
                j++;
            }

        }
        int[] result=new int[set.size()];
        int k=0;
        for(int ele:set){
            result[k]=ele;
            k++;
        }

        return result;
    }
    public static int lengthOfLIS(int[] nums){

        int longest=1;
        for(int i=0; i<nums.length;i++){
            int start=i;
            int end= start;
            while(end<nums.length && nums[start]<=nums[end]){
                longest=Math.max(longest,end-start);
                end++;
            }
        }

        return longest;
    }

    public static int lengthOfLIS2(int[] nums,int index,ArrayList<Integer> curr){
        int max=curr.size();
        for(int i=index;i<nums.length;i++){
            if(curr.size()>0 && curr.get(curr.size()-1)>=nums[i]) continue;
            curr.add(nums[i]);
            max=Math.max(max,lengthOfLIS2(nums,i+1,curr));
            curr.remove(curr.size()-1);

        }
        return max;
    }

    public static int kthSmallest(int[][] matrix,int k){
        int m= matrix.length;
        int n=matrix.length;
        int i= 0;
        int j= n-1;

        while(i<m && j>=0){
            k-=(j+1);
            if(k==0){
                return matrix[i][j];
            }
            if(k<0){
                k+=j+1;
                j--;
            }
            else{
                i++;
            }
        }

        return -1;
    }
    
}
