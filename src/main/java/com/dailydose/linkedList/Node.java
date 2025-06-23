package com.dailydose.linkedList;

public  class Node{
    int data;
    Node next;
    Node bottom;

    public Node(int data){
         this.data=data;
    }
    public Node(int data,Node next,Node bottom){
        this.data=data;
        this.next=next;
        this.bottom=bottom;
    }
}
