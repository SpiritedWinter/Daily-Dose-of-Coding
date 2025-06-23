package com.dailydose.linkedList;

public class LinkedListPair {
    public static void main(String[] args){


    }

    private ListNode reverseInPiars(ListNode head){
        ListNode prev= new ListNode(-1);
        ListNode returnPrev=prev;
        while(head!=null && head.next!=null){
            ListNode nextPrev= head;
            head=head.next;
            ListNode nextHead=head.next;
            nextPrev.next=null;
            head.next=nextPrev;
            prev.next=head;

            head=nextHead;
            prev=nextPrev;
        }

        return returnPrev;
    }

    public static ListNode reverseInK(ListNode head,int k){
        ListNode prev = new ListNode(-1);
        ListNode returnPrev = prev;
        while(head!=null && head.next!=null){
            ListNode check = head;
            int count = 0;
            while (count < k && check != null) {
                check = check.next;
                count++;
            }
            if (count < k) {
                prev.next = head;
                break;
            }
            
            ListNode nextPrev = head;
            ListNode p = nextPrev;

            head=head.next;
            nextPrev.next=null;
            int iter=k;

            
            while( head != null && iter > 1 ){
                ListNode nextNode = head.next;
                head.next=p;
                p=head;
                head=nextNode;
            }
            prev.next=p;
            prev=nextPrev;

        }

        return returnPrev.next;
    }
}
