package TreeDS;

import java.util.LinkedList;
import java.util.Queue;

public class Implementation {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static void display(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val +" --> ");
        if (root.left != null) System.out.print(root.left.val +" , ");
        if (root.right != null) System.out.print(root.right.val);
        System.out.println();
        display(root.left);
        display(root.right);
    }

    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public static void nthLevel(Node root ,int n){
        if (root == null){
            return;
        }
        if (n == 1){
            System.out.print(root.val +" ");
            return;
        }
        nthLevel(root.left , n-1);
        nthLevel(root.right , n-1);
    }

    public static void bfs(Node root){
        Queue<Node> q = new LinkedList<>();
        if (root != null){
            q.add(root);
        }

        while (q.size() > 0){
            Node temp = q.peek();

            if (temp.left != null ){
                q.add(temp.left);
            }
            if (temp.right != null){
                q.add(temp.right);
            }

            System.out.print(temp.val +" ");
            q.remove();
        }
    }
    public static int sum(Node root){
        if (root == null){
            return 0;
        }
        return root.val + sum(root.left)+sum(root.right);
    }

    public static int max(Node root){
        if (root == null){
            return Integer.MIN_VALUE;
        }

        int a = root.val;
        int b = max(root.left);
        int c = max(root.right);

        return Math.max(a , Math.max(b , c));
    }

    public static int height(Node root){
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 0;
        }

        return 1+Math.max(height(root.left) , height(root.right));
    }
    public static int size(Node root){
        if (root == null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        //root.val= 1;
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;
        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;
        Node e = new Node(6);
        b.right = e;

        //display(root);
        //preOrder(root);
        System.out.println(size(root));
//        System.out.println(sum(root));
//        System.out.println(max(root));
//        System.out.println(height(root));

//        int level = height(root)+1;
//        for (int i=1; i<=level ; i++){
//            nthLevel(root , i);
//            System.out.println();
//        }

//        bfs(root);
    }
}
