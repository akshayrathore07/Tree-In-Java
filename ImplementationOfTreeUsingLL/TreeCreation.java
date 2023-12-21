package ImplementationOfTreeUsingLL;

import java.util.Scanner;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class TreeCreation {

    static Node create(){
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.println();
        System.out.println("Enter value");
        int data = sc.nextInt();
        if (data == -1){
            return null;
        }
        root = new Node(data);
        System.out.print("Enter the left child of the root"+root.data);
        root.left = create();
        System.out.print("Enter the right child of the root "+root.data);
        root.right = create();
        return root;
    }

    public static void main(String[] args) {
        Node root = create();
    }
}
