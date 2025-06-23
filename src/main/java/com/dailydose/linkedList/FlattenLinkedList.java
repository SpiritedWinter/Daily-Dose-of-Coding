package com.dailydose.linkedList;


public class FlattenLinkedList {
    public static void main(String[] args){

    }

    public static Node flattenList(Node head){


        Node dummy=head;
        Node merged=head;
        
        while(dummy.next!=null){
            merged=merge(merged,dummy.next);
            dummy=dummy.next;
        }

        return downflatten(head);
    }
    public static Node merge(Node head1,Node head2){
        // we have to merge two sorted list using pointer
        Node dummy= new Node(-1);
        Node prev=dummy;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                prev.bottom=head1;
                head1=head1.bottom;
                
            }
            else{
                prev.bottom=head2;
                head2=head2.bottom;
            }

            prev=prev.bottom;
        }

        prev.bottom=head1==null?head2:head1;

        return dummy.bottom;
    }


    private static Node downflatten(Node head){
        Node result=head;
        while(head!=null){
            head.next=head.bottom;
            head=head.next;
        }

        return result;
    }
}
