
package com.mycompany.trees;


public class NodeTree {
    
    private int key;
    private int height;
    private NodeTree right;
    private NodeTree left;
    
    //CONSTRUCTORES
    
    public NodeTree(int key, int height){
        this.key = key;
        this.height = height;
        this.right = this.left = null;
    }
    
    public NodeTree(int key){
        this(key,1);
    }
    
    public NodeTree(){
        this(0,1);
    }
    
    //GETTERS AND SETTERS

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    

    public NodeTree getRight() {
        return right;
    }

    public void setRight(NodeTree right) {
        this.right = right;
    }

    public NodeTree getLeft() {
        return left;
    }

    public void setLeft(NodeTree left) {
        this.left = left;
    }
    
    
}
