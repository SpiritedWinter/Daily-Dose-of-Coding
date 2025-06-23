package com.dailydose.linkedList;

public class MergeTwoSortedList {
    public static void main(String[] args){

    }
    private static ListNode mergeSort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }

        ListNode mid =findMid(head);
        ListNode left=mergeSort(head);
        ListNode right = mergeSort(mid);

        return merge(left, right);
    }

    private static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev=null;

        while(fast!=null || fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        if(prev!=null){
            prev.next=null;
        }
        return slow;
    }
    private static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode dummy=new ListNode();
        ListNode tail=dummy;

        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }

        tail.next= l1==null?l2:l1;


        return dummy.next;
    }


    private static ListNode sortLinkedList(ListNode head){

        ListNode prev=new ListNode(-1);
        ListNode result=prev;

        while(head!=null && head.next!=null){
            if(head.val>head.next.val){
                ListNode f=head;
                ListNode s=head.next;

                ListNode ns=s.next;
                f.next=ns;
                s.next=f;
                prev.next=s;
                s=ns;
            }
            else{
                head=head.next;
            }
            prev=prev.next;
        }

        return result.next;
    }

    private static ListNode reverseBetween(ListNode head, int left, int right){
        //with respect to the position
        if(left==right){
            return head;
        }
        int postion=0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(postion<left){
            prev=prev.next;
            postion++;
        }

        // we have the previous postion stored in the previous which is goidng to help us later while reversing the liinked list
        ListNode p=null;
        ListNode nCache=prev.next;
        ListNode curr=prev.next;
        while(curr!=null && postion<=right){
            ListNode nexthead=curr.next;
            curr.next=p;
            p=curr;
            curr=nexthead;
            postion++;
        }

        prev.next=p;
        nCache.next=curr;

        return dummy.next;

    }
}
