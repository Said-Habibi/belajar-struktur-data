package Tree.BinaryTree;

public class Node {
    Node leftChild;
    Node rightChild;
    int data;

    public Node(int data){ 
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    private Node insdertRec(Node root, int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        
        if(data < root.data){
            root.leftChild = insdertRec(root.leftChild, data);
        }else if(data > root.data){
            root.rightChild = insdertRec(root.rightChild, data);
        }
        return root;
    }

    private void inOrderTraversal(Node root){
        if(root != null){
            inOrderTraversal(root.leftChild);
            System.out.println(root.data + " ");
            inOrderTraversal(root.rightChild);
        }
    }
}
