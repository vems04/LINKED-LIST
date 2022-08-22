package com.vems.linkedlist;
public class INSERTION {
    private Node head;
    private Node tail;
    private int size;
    public INSERTION() {
        this.size = 0;
    }
    public void insertFirst(int v){
        Node node = new Node(v);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
    }
    public void insertLast(int v){
        if(tail == null){
            insertFirst(v);
            return;
        }
        Node node = new Node(v);
        tail.next = node;
        tail = node;
        size++;
    }
    public void insertatindex(int v,int index){
        if(index == 0){
            insertFirst(v);
        }
        else if(index == size){
            insertLast(v);
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp =temp.next;
        }
        Node node = new Node(v,temp.next);
        temp.next = node;
        size++;
    }
    public void Display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp = temp.next;
        }
        System.out.println("End");
    }
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
           this.value = value;
        }
        public Node(int value, Node next) {
           this.value = value;
            this.next = next;
       }
    }
}
