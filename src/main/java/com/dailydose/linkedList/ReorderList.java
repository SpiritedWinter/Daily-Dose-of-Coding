package com.dailydose.linkedList;

public class ReorderList {
    public static void main(String[] args){

    }

    public static void reorderList(ListNode head){

        if(head==null || head.next==null){
            return ;
        }
        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            prev=prev.next;
            slow=slow.next ;
            fast=fast.next.next;
        }

        ListNode p=null;
        while(slow!=null){
            ListNode nextHead=slow.next;
            slow.next=p;
            p=slow;
            slow=nextHead;
        }

        ListNode head2=p;
        boolean change=false;
        while(head!=null && head2!=null){
            if(!change){
                head.next=head2;
                head=head.next;
            }
            else{
                head2.next=head;
                head2=head2.next;
            }
            change=!change;
        }
    }

    public static boolean isPalindrome(ListNode head){
        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev= dummy;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){

            prev=prev.next;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode p=null;
        while(slow!=null){
            ListNode nextSlow=slow.next;
            slow.next=p;
            p=slow;
            slow=nextSlow;
        }
        // head at p
        // we'll only check if the fist list is null or not
        // because always the first list is shorter than or equal the second list

        ListNode head1=dummy.next;
        ListNode head2=p;

        while(head1!=null){
            if (head1.val!=head2.val){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }

        return true;

    }


}
