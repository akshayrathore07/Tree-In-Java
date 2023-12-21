package TraversalUsingRecursion;


class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left = null;
        this.right = null;
    }
}

public class BTree {
    static int idx = -1;
    public static Node buildTree(int[] nodes){
        idx++;
        if (idx >= nodes.length || nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        int[] node = {1,2,4,-1,5,-1,-1,3,-1,6,-1,-1};
        BTree tree = new BTree();
        Node root = tree.buildTree(node);
        System.out.println(root.data);
        System.out.println("Pre-Order traversal");
        preOrder(root);
        System.out.println();
        System.out.println("In-Order traversal");
        inOrder(root);
        System.out.println();
        System.out.println("Post-Order traversal");
        postOrder(root);
    }
}
