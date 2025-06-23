package com.dailydose.linkedList;

public class RotateList {
    public static void main(String[] args){

    }
    public static ListNode rotateList(ListNode head,int k){
        
        ListNode mainHead=head;
        int length= getListLength(head);
        
        k=k%length;
        if(k==0){
            return head;
        }
        // return if the k size is divible by its head because no point in rotating list twice or thrice etc
        // essentially its going to be the same
        int pointOfDisconnect=length-k;
        while(pointOfDisconnect>1){
            head=head.next;
            pointOfDisconnect--;
        }
        // now we have the head pointing to the node we would like to disconnect
        ListNode newStart=head.next;
        head.next=null;

        ListNode lastNode=newStart;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
        }

        lastNode.next=mainHead;


        return newStart;
    }

    public static int getListLength(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }

    public static ListNode getIntersection(ListNode headA,ListNode headB){

        ListNode h1 = headA;
        ListNode h2 = headB;
        int count1 = 1;
        int count2 = 1;

        while(h1.next != null){
            h1 = h1.next ;
            count1++ ;
        }
        while(h2.next != null){
            h2 = h2.next ;
            count2++ ;
        }
        if(h1 != h2){
            return null ;
        }
        //if h1 is bigger we have to skip nodes from h1 
        int skipCount;
        if(count1 > count2){
            skipCount = count1-count2;
            while(skipCount > 0){
                headA=headA.next;
                skipCount--;
            }
        }
        // if h2 is bigger we have to skip nodes from h2
        else if(count2 > count1){
            skipCount=count2-count1;
            while(skipCount>0){
                headB=headB.next;
                skipCount--;
            }
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }

        return headA;
        

    }

    public static ListNode removeNthFromEnd(ListNode head,int n){
        if(n==0 || head==null){
            return null;
        }
        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;

        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        ListNode delNode=slow.next;
        ListNode lastNode=delNode.next;

        slow.next=lastNode;

        return dummy.next;

    }

    public static ListNode deleteMiddle(ListNode head){

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

        ListNode delNode=slow;
        ListNode nextNode=delNode.next;
        prev.next=nextNode;

        return dummy.next;
    }
}
