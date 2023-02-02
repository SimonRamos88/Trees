
package com.mycompany.trees;



public class Node<T> {
    T data;
    Node next;
    
    public T getData(){
        return this.data;
    }
    
    public void setData(T Data){
        this.data = Data;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public void setNext(Node n){
        this.next = n;
    }
    
    public Node(){
        this(null);
    }
    public Node(T Data){
        this.data = Data;
        this.next = null;
    }
    
}
