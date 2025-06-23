package com.dailydose.linkedList;
import java.util.*;
public class OddEvenList {
    public static void main (String[] args){

    }
    public static ListNode oddEvenList(ListNode head){
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;

        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;

            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;

        return head;
    }

    public static ListNode[] splitListParts(ListNode head, int k){

        int length=getListLength(head);
        int partLength=length/k;
        int extraLength=length%k;
        
        ListNode[] result= new ListNode[k];
        ListNode dummy=head;
        ListNode first=head;
        int position=0;
        while(length>0){
            int subSize=partLength;
            if(extraLength>0){
                subSize++;
                extraLength--;
            }
            length=length-subSize;
            while(subSize>1){
                dummy=dummy.next;
                subSize--;
            }

            //after the the loop ends
            //store the next head before breaking
            ListNode nextHead=dummy.next;
            dummy.next=null;
            result[position]=first;

            //move for the next round
            dummy=nextHead;
            first=dummy;
            position++;
            
        }

        return result;
    }

    private static int getListLength(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }

        return count;
    }
}
