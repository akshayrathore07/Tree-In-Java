package BST;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteNode {
    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }



    public static Node constructTreeBFS(String[] arr){
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < n-1){
            Node temp = q.remove();
            Node left = new Node(100);
            Node right = new Node(1000);

            if (arr[i].equals("")){
                left = null;
            }
            else {
                int l = Integer.parseInt(arr[i]);
                left.val = l;
                q.add(left);
            }

            if (arr[i+1].equals("")){
                right = null;
            }
            else {
                int r = Integer.parseInt(arr[i+1]);
                    right.val = r;
                    q.add(right);

            }
            temp.left=left;
            temp.right = right;

            i+=2;
        }
        return root;
    }
    public static void preorder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.val +" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void postorder(Node root){
        if (root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val +" ");
    }
    public static void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val +" ");
        inorder(root.right);
    }

    public static void deleteNode(Node root , int target){
        if (root == null){
            return;
        }
        if (root.val>target){
            if (root.left.val==target){
                if (root.left.left == null && root.left.right == null){
                    root.left = null;
                }
                else if (root.left.left == null || root.left.right == null){
                    if (root.left != null) root.left = root.left.left;
                    else root.left = root.left.right;
                }
            }
            else {
                deleteNode(root.left, target);
            }
        }
        else {
            if (root.right.val==target){
                if (root.right.left == null && root.right.right == null){
                    root.right = null;
                }
                else if (root.right.left == null || root.right.right == null){
                    if (root.right != null) root.right = root.right.left;
                    else root.right = root.right.right;
                }
            }
            else {
                deleteNode(root.right, target);
            }
        }

    }
    public static void main(String[] args) {
        String[] arr = {"50", "20", "60", "17", "34", "55", "89" ,"10", "" , "28", "", "", "", "70", "","", "14"};
        Node root = constructTreeBFS(arr);
        preorder(root);
        System.out.println();
        deleteNode(root, 89);
        preorder(root);
    }
}
