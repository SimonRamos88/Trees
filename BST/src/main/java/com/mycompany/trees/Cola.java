
package com.mycompany.trees;


public class Cola<T> {
    Node rear;
    Node front;
   
    public boolean empty(){
        return rear == null;
    }
    
    
    public void Encolar(T data){
        Node element = new Node(data);
        if(!empty()){
            this.rear.setNext(element); //Seteamos a que apunte a este nuevo elemento
            this.rear = element; //Hacemos que ahora la referencia vaya a este nuevo elemento para que ahora sea el nuevo rear
            
        }
        else{
            this.rear = element;
            this.front = element;
        }
    }
    
    public T Desencolar(){
        if(empty()){
            throw new IllegalArgumentException("Esta vacío pa");
        }
        T data = (T) front.getData();
        if(this.rear == this.front){ //Si solo hay un elemento  
            front = null;
            rear = null;           
        }else{
             front = front.getNext();
        }      
        return data;
    }
    
    public Cola(){
           this.rear = null;
           this.front = null;
       }
    
 
    
    
}
