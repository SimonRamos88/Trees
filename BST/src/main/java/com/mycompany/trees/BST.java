package com.mycompany.trees;

public class BST extends Tree{


    //CONSTRUCTORES 
    public BST(NodeTree root){
        super(root);
    }
    
    public BST() {
        this(null);
    }

    //METODOS

  
    //INSERT
    private NodeTree insertBST(NodeTree root, int key) {
        if (root == null) {
            return new NodeTree(key);
        } else {
            if (root.getKey() > key) {
                root.setLeft(insertBST(root.getLeft(), key));
            } else if (root.getKey() < key) {
                root.setRight(insertBST(root.getRight(), key));
            }
            return root;
        }
    }
    
    @Override
    public void insert(int key) {
        this.setRoot( insertBST(this.getRoot(),key )  );
    }

    /*En la recursion, vamos asignando de nuevo el nodo a un lado izquierdo o derecho
    del arbol pq es como si fueramos buscando, eliminando y asignando todo al mismo tiempo*/
    private NodeTree deleteBST(int i, NodeTree root) {
        if (root != null) {
            if (root.getKey() > i) { //lo buscamos
                root.setLeft(deleteBST(i, root.getLeft()));

            } else if (root.getKey() < i) { // lo buscamos
                root.setRight(deleteBST(i, root.getRight()));
            } else { // si lo encontramos                                     
                if (root.getLeft() == null && root.getRight() == null) {
                    root = null;
                } else if (root.getLeft() == null) {
                    root = root.getRight();
                } else if (root.getRight() == null) {
                    root = root.getLeft();

                } else {
                    NodeTree n = minNode(root.getRight());
                    root.setKey(n.getKey());
                    root.setRight(deleteBST(n.getKey(), root.getRight()));
                }

            }

        }
        return root;

    }
    
    @Override
    public void remove(int i) {
        this.setRoot( deleteBST(i,this.getRoot() )  );

    }



}
