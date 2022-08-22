package com.vems.linkedlist;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        INSERTION o = new INSERTION();
        int n,i;
        n = sc.nextInt();
        int [] a = new int [n];
        for(i=0;i<n;i++){
            a[i]=sc.nextInt();
            o.insertLast(a[i]);
        }
        o.insertatindex(155,3);
        o.Display();


    }}



