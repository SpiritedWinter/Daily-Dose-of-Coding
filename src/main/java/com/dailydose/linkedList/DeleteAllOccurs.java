package com.dailydose.linkedList;

public class DeleteAllOccurs {
    public static void main(String[] args){

    }
    private static DoublyNode deleteAllOccurs(DoublyNode head,int value){

        DoublyNode dummy=head;
        while(head.next!=null){

            if(head.next.data==value){
                if(head.next.next!=null){
                    head.next.next.prev=head;
                    DoublyNode node= head.next;
                    head.next=node.next;
                    node.prev=null;
                    node.next=null;
                }
                else{
                    DoublyNode delNode=head.next;
                    head.next=null;
                    delNode.prev=null;
                }
            }

            head=head.next;
        }

        return dummy;
    }
}
