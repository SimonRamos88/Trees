
package com.mycompany.trees;


public class Pila<T> {
    
    private Node top;    
    
    public boolean empty(){
        return top.getNext() == null;
    }
    
    public boolean full(){ 
        return false;
    }
    
    public void push(T value){
       Node aux = new Node(value);
       aux.setNext(this.top);
       this.top = aux;
    }
    
    public T pop(){
        if(!empty()){
            T value = (T) this.top.getData();
            top = this.top.getNext(); //Guardamos la direccion del siguiente nodo
            return value;
        }else{
            throw new IllegalArgumentException("Esta vacio pa");
        }
        
    }
    
      public int toString(Node node){
        if(node.getNext()== null){
            return 0;
        }
        else{
            System.out.println(node.getData());
            return toString(node.getNext());
        }
    }
    
    public Pila(){
        this.top = new Node();
    }
    
    public Pila(int value){
        Node node = new Node(value);
        this.top = node;
    }
    
    
    
}

