package com.dailydose.linkedList;

public class LinkedList{

    private Node head;
    private Node tail;
    public int size;
    public LinkedList(){
        size=0;
    }
    public void addNodeFront(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=node;
        }
        this.size+=1;
        //done
    }

    private void addNodeBack(int val){
        if(tail==null){
            addNodeFront(val);
            return;
        }
        Node temp=new Node(val);
        tail.next=temp;
        tail=temp;
        this.size+=1;

    }

    public void insert(int val,int index){
        // add node at an index in a linked list

        if(this.head==null){
            addNodeFront(val);
            return;
        }
        if(this.size<=index){
            addNodeBack(val);
            return;
        }

        Node temp=this.head;
        while(index-1>0){
            temp=temp.next;
            index--;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        
        this.size++;


    }

    public void deleteIndex(int index){
        if(index==0){
            head=head.next;
            return;
        }
        Node temp=head;
        while(index-1>0){
            temp=temp.next;
            index--;
        }
        Node DelNode=temp.next;
        temp.next=DelNode.next;
        DelNode.next=null;
    }
    public void addNodeList(int[] nodes){
        for(int i=0; i<nodes.length;i++){
            addNodeBack(nodes[i]);
        }
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        Node temp=this.head;
        while(temp!=null){
            if(sb.isEmpty()){
                sb.append(temp.value);
            }
            else{
                sb.append(String.format(" -> %d", temp.value));
            }
            temp=temp.next;
        }
        return sb.toString();
    }

    private class Node{
        private int value;
        private Node next;

        Node(int val){
            this.value=val;
        }
        Node(int val,Node node){
            this.value=val;
            this.next=node;
        }
    }
}
