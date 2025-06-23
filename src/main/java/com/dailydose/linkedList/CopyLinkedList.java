package com.dailydose.linkedList;

public class CopyLinkedList {
    public static void main(String[] args){

    }

    public static Node deepCopy(Node head){
        Node dummy=head;

        while(head!=null){
            Node newNode= new Node(head.val);
            Node nextNode = head.next;
            head.next=newNode;
            newNode.next=nextNode;

            head=newNode.next;

            //inserted a node with the same value inside the list;
        }

        // assign the random pointer while traverssing through the list
        head=dummy;
        while(head!=null ){
            Node newHead=head.next;
            Node currRando=head.random;
            newHead.random=currRando==null?null:currRando.next;

            head=head.next.next;
        }

        //assigned the random pointer
        // last task is to detach the new list
        Node res= new Node(-1);
        Node temp=res;
        dummy=head;
        while(head!=null ){
            Node newHead=head.next;
            temp.next=newHead;
            
            Node nextMain=newHead.next;
            newHead.next=null;
            
            head.next=nextMain;
            head=head.next;
            temp=temp.next;

        }

        return res.next;
    }
}
