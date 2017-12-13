package BST;

import java.util.Arrays;

class BinarySearchTree{
    private Node root;
    private int[] items;
    public int size;

    public BinarySearchTree(){
        root = null;
        items = new int[1];
        size = 0;
        
    }
     
    public boolean isEmpty(){
        return root == null;
    }

    public Object root() {
        return root;
    }
    
    public int countNodes(){
         return countNodes(root);
     }
    
    private int countNodes(Node r){
        if (r == null){
            return 0;
        }
        else{
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    
    public void coutArray(){
        System.out.println(size);
    }
    
    public void tampilArray(){
        for(int i = 0; i<size;i++){
            System.out.print(items[i]+" ");
        }
    }
    
    public boolean contains(final int key){
        return contains(items, key);
    }
    
    private boolean contains(final int[] array, final int key) {
        for (final int i : array){
            if (i == key) {
                return true;
            }
        }
        return false;
    }
    
    public void searchPaths(int x){
        searchgetPaths(root, x);
    }
    
    private void searchgetPaths(Node root,int x){
        if(contains(items, x)==true){
            if(root.getData()<x){
            System.out.print(root.getData()+" ");
            searchgetPaths(root.getRight(), x);  
            }

            else if(root.getData()>x){
                System.out.print(root.getData()+" ");
                searchgetPaths(root.getLeft(), x);
            }

            else if(root.getData()==x){
                System.out.print(root.getData()+" ");
            }
        }
        else{
            System.out.println("data kosong");
        }
    }
    
    public int getLeafCount(){
        return getLeafCount(root);
    }
  
    private int getLeafCount(Node node){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        }
        else{
            return getLeafCount(node.left) + getLeafCount(node.right);
        }
    }
    
    private void push(int item){
        if(root == null){
            items[size] = item;
            size++;
        }
        else{
        items = Arrays.copyOf(items, items.length+1);
            items[size] = item;
            size++;
        }
    }
    
    public void insert(int data){
        push(data);
        root = insert(root, data);
    }
    
    private Node insert(Node node, int data){
        if (node == null){
             node = new Node(data);
         }
         else{
             if (data <= node.data)
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         
         return node;
     }
    
    public void printPath(){
         printPaths(root);
     }
    
    private void printPaths(Node node) {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
  
    private void printPathsRecur(Node node, int path[], int pathLen){
        if (node == null){
            return;
        }
  
        path[pathLen] = node.data;
        pathLen++;

        if (node.left == null && node.right == null){
            printArray(path, pathLen);
        }
        else
        {
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }
  
    private void printArray(int ints[], int len){
        int i;
        for (i = 0; i < len; i++) 
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }
    
    private void deleteArray(int k){
        for(int i=0; i<items.length; i++){
           if(items[i] == k){
               for(int j=i; j<(items.length-1); j++){
                   items[j] = items[j+1];
               }
               size--;
               break;
           }
        }
    }
    
    public void delete(int k){
        if (isEmpty()){
            System.out.println("Tree kosong");
        }
        else if (contains(items, k) == false){
            System.out.println("Maaf "+ k +" tidak ada");
        }
        else{
            deleteArray(k);
            root = delete(root, k);
            System.out.println(k+ " di hapus dari tree");
        }
    }
    
    private Node delete(Node root, int k){
        Node p, p2, n;
        if (root.getData() == k){
            Node lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null){
                return null;
            }
            else if (lt == null){
                p = rt;
                return p;
            }
            else if (rt == null){
                p = lt;
                return p;
            }
            else{
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                 p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()){
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else{
            n = delete(root.getRight(), k);
            root.setRight(n);             
        }
        return root;
    }
    
    public void inorder(){
        inorder(root);
    }
    
    private void inorder(Node r){
        if (r != null){
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    
    public void preorder(){
        preorder(root);
    }

    private void preorder(Node r){
         if (r != null){
             System.out.print(r.data +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
    
    public void postorder(){
        postorder(root);
    }
    
    private void postorder(Node r){
        if (r != null){
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }  
}