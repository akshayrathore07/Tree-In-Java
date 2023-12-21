package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeDS {
    private static void formTree(Node root){
        root.child.add(new Node(5));
        root.child.add(new Node(11));
        root.child.add(new Node(63));
        root.child.get(0).child.add(new Node(1));
        root.child.get(0).child.add(new Node(4));
        root.child.get(0).child.add(new Node(8));
        root.child.get(1).child.add(new Node(6));
        root.child.get(1).child.add(new Node(7));
        root.child.get(1).child.add(new Node(15));
        root.child.get(2).child.add(new Node(31));
        root.child.get(2).child.add(new Node(55));
        root.child.get(2).child.add(new Node(65));
    }
    public static class Node{
        int val;
        List<Node> child;

        Node(int val){
            this.val = val;
            child = new ArrayList<>();
        }
    }
    public static void preorderTraversal(Node root){
        if (root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        System.out.print(root.val+" ");
        int n = root.child.size();
        for (int i=0; i<n; i++){
            preorderTraversal(root.child.get(i));
        }
    }

    public static void postorderTraversal(Node root){
        if (root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        int n = root.child.size();
        for (int i=0; i<n; i++){
            postorderTraversal(root.child.get(i));
        }
        System.out.print(root.val+" ");
    }

    static void levelOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.peek();
            System.out.print(curr.val+" ");
            q.remove();
            int noOfChild = curr.child.size();
            for (int i = 0; i < noOfChild; i++) {
                q.add(curr.child.get(i));
            }
        }

    }

    static void zigZagOrderTraversal(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Node> currLevel = new ArrayList<>();

            while (levelSize-- >0){
                Node curr = q.peek();
                currLevel.add(curr);
                q.remove();
                int noOfChild = curr.child.size();
                for (int i = 0; i < noOfChild; i++) {
                    q.add(curr.child.get(i));
                }
            }
            if (flag == false){
                printNodeList(currLevel);
            }
            else{
                reverse(currLevel);
                printNodeList(currLevel);
            }
            flag = !flag;
        }

    }

    static List<Node> reverse(List<Node> nodeList){
        List<Node> rev = new ArrayList<>();
        for (int i=nodeList.size()-1; i>=0; i--){
            rev.add(nodeList.get(i));
        }
        return rev;
    }
    public static void printNodeList(List<Node> nodeList){
        for (int i=0; i<nodeList.size(); i++){
            System.out.print(nodeList.get(i).val+" ");
        }
        System.out.println();
    }

    public static int findMax(Node root){
        if (root.child.isEmpty()){
            return root.val;
        }
        int maxTillNow = root.val;

        int n = root.child.size();
        for (int i=0; i<n; i++){
           int childMax =  findMax(root.child.get(i));
           if (childMax > maxTillNow){
               maxTillNow = childMax;
           }
        }
        return maxTillNow;
    }

    private static void mirrorTree(Node root) {
        if (root.child.isEmpty()) {
            return;
        }

        int noOfChildren = root.child.size();
        if (noOfChildren == 1) {
            return;
        }

        for (int i = 0; i < noOfChildren; i++) {
            mirrorTree(root.child.get(i));
            rev(root.child.get(i).child);
        }
    }


    static void rev(List<Node> root) {
        int n = root.size();
        List<Node> reversed = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            reversed.add(root.get(i));
        }
        root.clear();
        root.addAll(reversed);
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        formTree(root);
        postorderTraversal(root); // Print the original post-order traversal
        System.out.println();
        levelOrderTraversal(root);
        System.out.println();
        mirrorTree(root); // Mirror the tree
        levelOrderTraversal(root); // Print the mirrored tree
    }


}
