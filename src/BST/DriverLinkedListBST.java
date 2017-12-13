package BST;

import java.util.Scanner;

 public class DriverLinkedListBST{
     public static void main(String[] args){                 
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();           
        char ch;
        do{
            System.out.println("\nBinary Search Tree\n");
            System.out.println("1. Masukkan Data ");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data dan Tampilkan route");
            System.out.println("4. Hitung Node");
            System.out.println("5. Hitung Leaf");
            System.out.println("6. Cek kosong atau tidak"); 
            System.out.println("7. Tampilkan Data");
 
            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
                System.out.println("Masukkan Angka yang akan di masukkan");
                bst.insert( scan.nextInt());                     
                break;                          
            case 2 : 
                System.out.println("Masukkan Angka yang akan di hapus");
                bst.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Masukkan Angka yang akan di cari");
                int a = scan.nextInt();
                System.out.println("Hasil pencarian : ");
                bst.searchPaths(a);
                break;                                          
            case 4 : 
                System.out.println("Banyak Node = "+ bst.countNodes());
                break;
            case 5 : 
                System.out.println("Banyak Leaf = "+ bst.getLeafCount());
                break;
            case 6 :  
                System.out.println("Empty status = "+ bst.isEmpty());
                break;     
            case 7: 
                bst.printPath();
                System.out.print("\nPost order : ");
                bst.postorder();
                System.out.print("\nPre order : ");
                bst.preorder();
                System.out.print("\nIn order : ");
                bst.inorder();
                break;
            default : 
                System.out.println("masukkan angka 1- 7 \n ");
                break;   
            } 
            System.out.println("\nApakah mau lanjut? (Type y or n)\n");
            ch = scan.next().toLowerCase().charAt(0);                        
        } while (ch == 'y');               
    }
 }