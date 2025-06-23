package com.dailydose.linkedList;

public class AddTwoNumber {
    public static void main(String[] args){

    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int sizeL1=getSize(l1);
        int sizeL2=getSize(l2);

        int carry=0;
        // we'll select only that array to be our solution which is bigger in size
        ListNode sumHead;
        if(sizeL2>=sizeL1){
            sumHead=l2;
        }
        else{
            sumHead=l1;
        }

        ListNode head=sumHead;
        while(l1!=null && l2!=null){
            int nodeSum=l1.val+l2.val+carry;
            if(nodeSum>=10){
                carry=1;
                nodeSum%=10;
            }
            else{
                carry=0;
            }

            sumHead.val=nodeSum;
            l1=l1.next;
            l2=l2.next;
            sumHead=sumHead.next;
        }

        // once the condition breaks there are three possiblities
        //1. either l1 is empty and we need to check l2 for other values
        //2. either l2 is empty and we need to check l1 for other values
        //3. both are empty -- if above two are implemented this need not be checked
        ListNode prev=sumHead;
        while(l1!=null){
            int nodeSum=carry+l1.val;
            if(nodeSum>=10){
                carry=1;
                nodeSum%=10;
            }
            else{
                carry=0;
            }
            sumHead.val=nodeSum;
            l1=l1.next;
            prev=sumHead;
            sumHead=sumHead.next;
        }

        while(l2!=null){
            int nodeSum=carry+l2.val;
            if(nodeSum>=10){
                carry=1;
                nodeSum%=10;
            }
            else{
                carry=0;
            }
            sumHead.val=nodeSum;
            l2=l2.next;
            prev=sumHead;
            sumHead=sumHead.next;
        }
        if(carry==1){
            prev.next=new ListNode(1);
        }
        return head;
    }

    private static int getSize(ListNode head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }


        return size;

    }
}
