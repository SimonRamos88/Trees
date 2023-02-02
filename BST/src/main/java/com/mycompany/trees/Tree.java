
package com.mycompany.trees;


public abstract class Tree {
    
    private NodeTree root;
    
    //CONSTRUCTORES
    
    public Tree(NodeTree root){
        this.root = root;
    }
    
      
    //METODOS
    
    
    //INSERT
    public abstract void insert(int key);
    
    //REMOVE
    public abstract void remove(int key);
    
    //FIND
    //devuelve la posicion del nodo o donde deberia estar el nodo
    public NodeTree find(int i, NodeTree n) {
        NodeTree find = n;
        if (n.getKey() > i) {
            if (n.getLeft() != null) {
                find = find(i, n.getLeft());
            }

        } else if (n.getKey() < i) {
            if (n.getRight() != null) {
                find = find(i, n.getRight());
            }
        }

        return find;
    }

    public NodeTree findNode(int i) {
        return find(i, this.root);
    }

    public boolean isNode(int i) {
        NodeTree n = findNode(i);
        return n.getKey() == i;
    }
    
    //NEXT

    public void next(int i) {
        NodeTree next = nextNode(i, this.root, this.root);
        if (next != null) {
            System.out.println("next: " + next.getKey());
        } else {
            System.out.println("No hay next");
        }
    }

    public NodeTree nextNode(int i, NodeTree n, NodeTree parent) {

        /*buscamos el nodo*/
        if (n.getKey() > i) { //lo buscamos en el lado izquierdo

            if (n.getLeft() != null) { // como en find
                NodeTree root = nextNode(i, n.getLeft(), n);
                if (root == null) {
                    if (parent.getKey() > i) {
                        root = parent;
                    } else {
                        return null;
                    }
                }
                return root;
                //return nextNode(i, n.getLeft(), n);
            } else { //Implicitamente tambien estamos buscando el minimo
                /*si el izq es nulo, entonces el nodo de key i no esta en el arbol
            luego, al tratarse del hijo izquierdo, el siguiente a este es el nodo mas pequeño cercano*/
                return n;
            }

        } else { //Si lo encontramos o esta en el derecho
            if (n.getRight() != null) {
                NodeTree root = nextNode(i, n.getRight(), n);
                if (root == null) {
                    if (parent.getKey() > i) {
                        root = parent;
                    }

                }
                return root;
                //return nextNode(i, n.getRight(), n);
            } else {
                if (parent.getKey() > i) {
                    return parent;
                } else {
                    return null;
                }
            }
        }

    }

    //RANGE
    //Obviamente x > y
    public Pila rangeSearch(int x, int y) {
        Pila<Integer> range = new Pila();
        NodeTree n = nextNode(x, this.root, this.root);
        boolean bandera = n != null;

        if (isNode(x)) {
            range.push(x);
        }
        if (bandera) {
            if (n.getKey() <= y) {
                range.push(n.getKey());
            }
        }
        while (bandera) {
            n = nextNode(n.getKey(), this.root, this.root);
            if (n == null) {
                bandera = false;
            } else {
                if (n.getKey() > y) {
                    bandera = false;
                } else {
                    range.push(n.getKey());
                }
            }

        }
        return range;
    }

    public void rangePrint(int x, int y) {
        String cad = "[ ";
        Pila<Integer> range = rangeSearch(x, y);
        while (!range.empty()) {
            cad += range.pop() + " ";
        }
        System.out.println(cad + " ]");

    }

    //MAX
    
    public NodeTree maxNode(NodeTree p) {
        NodeTree n = p;
        if (p != null) {
            while (n.getRight() != null) {
                n = n.getRight();
            }
        }

        return n;
    }
    
    //MIN
    
    public NodeTree minNode(NodeTree p) {
        NodeTree n = p;
        if (p != null) {
            while (n.getLeft() != null) {
                n = n.getLeft();
            }
        }
        return n;
    }
    
    //DFS
    public void preOrder(NodeTree p) {
        if (p != null) {

            System.out.println(p.getKey());

            if (p.getLeft() != null) {
                preOrder(p.getLeft());
            }

            if (p.getRight() != null) {
                preOrder(p.getRight());
            }
        }
    }

    public void inOrder(NodeTree p) {
        if (p != null) {
            //System.out.println("p: " + p.getKey());                     
            if (p.getLeft() != null) {
                inOrder(p.getLeft());
            }

            System.out.println(p.getKey());

            if (p.getRight() != null) {
                inOrder(p.getRight());
            }
        }

    }

    public void postOrder(NodeTree p) {
        if (p != null) {

            if (p.getLeft() != null) {
                postOrder(p.getLeft());
            }

            if (p.getRight() != null) {
                postOrder(p.getRight());
            }

            System.out.println(p.getKey());
        }

    }

    //BFS
    public void bfs(NodeTree p) {
        Cola<NodeTree> cola = new Cola();
        if (this.root != null) {
            cola.Encolar(this.root);
        }

        while (!cola.empty()) {
            NodeTree n = cola.Desencolar();
            if (n.getLeft() != null) {
                cola.Encolar(n.getLeft());
            }
            if (n.getRight() != null) {
                cola.Encolar(n.getRight());
            }
            System.out.println(n.getKey() + " lvl: " + n.getHeight());

        }

    }
    
    
     //GETTERS AND SETTERS
    public NodeTree getRoot() {
        return root;
    }
    
     
    public void setRoot(NodeTree root) {
        this.root = root;
    }

}
