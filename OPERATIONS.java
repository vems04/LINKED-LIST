package com.vems.linkedlist;
public class OPERATIONS {
    private Node head; //"PRIVATE BECAUSE TO MAKE THEM AVAILABLE ONLY IN THIS CLASS"
    private Node tail;
    private int size;
    public OPERATIONS() {
        this.size = 0;
    }
    public void insertFirst(int v){ //" INT V FOR GIVING THE VALUE FOR FIRST NODE"
        Node node = new Node(v);//" CREATE A NEW NODE"
        node.next = head;//"ADDING THE ELEMENT LIKE STACK THE INCOMING ELEMENTS ARE HEAD AS IN STACK"
        head = node;
        if(tail==null){
            tail = head;//" IF THERE IS NO TAIL VALUE THEN LASTLY ADDED HEAD IS THE TAIL"
        }
        size++;// INCREAMENTING SIZE FOR EACH VALUE ADDED"
    }
    public void insertLast(int v){
        if(tail == null){
            insertFirst(v);
            return;
        }
        Node node = new Node(v);
        tail.next = node;//"ADDING THE ELEMENT FROM TAIL IN A LINKED LIST"
        tail = node;
        size++;
    }
    //"ADDING THE ELEMENT AT SPECIFIC INDEX"
    public void insertatindex(int v,int index){
        if(index == 0){
            insertFirst(v);//"AS INDEX IS 0 INSECTION IN FIRST INDEX THEN CALL THE METHOD "
        }
        else if(index == size){
            insertLast(v);//"AS INDEX IS SIZE INSECTION IN LAST INDEX THEN CALL THE METHOD "
        }
        Node temp = head;//" CREATE TEMPORARY NODE TO TRANSVERSE THROUGH THE LINKED LIST"
        for(int i=1;i<index;i++){
            temp =temp.next;//" TRANSVERSE TILL THE INDEX BEFORE THE SPECIFIC INDEX THE ELEMENT IS TO BE ADDED"
        }
        Node node = new Node(v,temp.next);//" CREATION OF NEW NODE WITH INDEX AND VALUE OF THE NEW NODE AT SPECIFIC INDEX"
        temp.next = node; //" ASSIGNING THE SPECIFIC INDEX TO THE NEW NODE"
        size++; //" INCREMENT THE SIZE AS NEW ELEMENT IS ADDED"
    }
    public Node Deleteatfirst(){
        Node v = head; //"ASSSUMING TO A TEMPORARY NODE"
        head = head.next;//" MOVING THE HEAD TO NEXT NODE"
        if(head == null){//"IF THE HEAD IS NULL THEN TAIL IS ASLO NULL THAT'S  NO ELEMENT IS PRESENT THEN HEAD AND TAIL ARE EQUAL;
            tail = head;
        }
        size --;//" DECREMENTING THE SIZE"
        return v;// "NOT NECESSARY IF NEEDED TO BE USED TO PRINT THE REMOVED ELEMENT "
    }
    public Node Deleteatlast(){
        if(size<=1){ //IF THE ELEMENT IS ONE THE DELTE FIRST AND LAST IS SAME SO CALLED DELETE FIRST
            return Deleteatfirst();
        }
        Node v = get(size-2);//" GET HELP TO GO BEFORE THE VALUE NEEDED TO BE DELETE AND CHANGE IT'S NEXT TO NULL "
       tail = v;
       tail.next = null;
       return v;

    }
    public Node DelteatIndex(int Ind){
        if(Ind == 0){
            return Deleteatfirst();
        }
        if(Ind == size -1){
            return Deleteatlast();
        }
        Node v = get(Ind-1 );//" GET HELP TO GO BEFORE THE VALUE NEEDED TO BE DELETE AND CHANGE IT'S NEXT TO NULL "
       //Node q = v;//(just for storing the value)
       // Node va.int value = v.next.value;
        v.next = v.next.next;
        return v;

    }
    public Node get(int Index){
        Node temp = head;
        for(int i=0;i<Index;i++){//HELPS TO GET INDEX IN ORDER TO MANIPLUTE THE DATA IN BETWEEN THE HEAD AND TAIL"
            temp = temp.next;
        }
        return temp;
    }
    public void Display(){
        Node temp = head;//"PRINT THE DATA BY MAKING A TEMP EQUAL TO HEAD AND MOVING IT TILL THE TAIL"
        while(temp!=null){
            System.out.print(temp.value+"-->");
            temp = temp.next;
        }
        System.out.println("End");
    }
    private class Node {
        private int value; // CREATE A NEW DATA TYPE WITH HELP OF STRUCT WHICH HAS A VALUE AND NODE TYPE OF NEXT
                          // WHICH MEANS THE NEXT ELEMENT IN THE LIST IS ALSO OF SAME DATA TYPE "
        private Node next;

        public Node(int value) {
           this.value = value;
        }//USED TO MANIPULATE AT HEAD OR TAIL
        public Node(int value, Node next) {// USED TO MANIPULATE AT A SPECIFIC POSITION
           this.value = value;
            this.next = next;
       }
    }
}
