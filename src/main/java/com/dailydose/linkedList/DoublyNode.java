package com.dailydose.linkedList;

public class DoublyNode {
    public int data;
    public DoublyNode  next;
    public DoublyNode prev;

    public DoublyNode(int data){
        this.data=data;
    }   
    public DoublyNode(int data,DoublyNode next,DoublyNode prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
}
