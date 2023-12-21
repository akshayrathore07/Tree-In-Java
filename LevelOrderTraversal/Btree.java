package LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

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

public class Btree {
    static int idx = -1;

    public static Node createTree(int[] nodes){
        idx++;
        if (idx >= nodes.length || nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = createTree(nodes);
        newNode.right = createTree(nodes);
        return newNode;
    }

    public static void levelOrder(Node root){
        if (root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node curr = q.remove();
            if (curr == null){
                System.out.println();
                // queue is empty
                if (q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                System.out.print(curr.data +" ");
                if (curr.left != null){
                    q.add(curr.left);

                }
                if (curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] node = {1,2,4,-1,5,-1,-1,3,-1,6,-1,-1};
        Btree tree = new Btree();
        Node root = createTree(node);
//        System.out.println(root.data);
        levelOrder(root);
    }
}
