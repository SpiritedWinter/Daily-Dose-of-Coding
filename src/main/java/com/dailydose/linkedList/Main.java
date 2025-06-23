package com.dailydose.linkedList;
public class Main {
    public static void main(String[] args){

        // LinkedList list=new LinkedList();
        // int[] nodes=new int[]{34,45,6,12,31,90};
        // list.addNodeList(nodes);

        // System.out.println(list.toString());

        // list.insert(5, 3);
        // System.out.println(list.toString());

        // list.deleteIndex(6);
        // System.out.println(list.toString());
    }

    public static ListNode rotateRight(ListNode head,int k){
        int size=getListSize(head);
        int condition=size-k;
        ListNode temp=head;
        while(condition>1){
            temp=temp.next;
            condition--;
        }
        //our final head
        ListNode tempHead=temp.next;
        //break the link 
        temp.next=null;
        // form the new link
        ListNode newHead=tempHead;
        while(tempHead.next!=null){
            tempHead=tempHead.next;
        }
        tempHead.next=head;

        return newHead;
    }

    private static int getListSize(ListNode head){
        int size=0;
        while(head!=null){
            size+=1;
            head=head.next;
        }

        return size;
    }
}
