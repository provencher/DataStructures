import java.util.ArrayList;

/**
 * Created by Eric on 2014-12-04.
 */
public class BinaryTree {

    Node root;



    BinaryTree(){
        root = null;
    }


    void inOrder(Node focus){

       if (focus != null){
           inOrder(focus.left);
           System.out.print(focus.key + "\t");
           inOrder(focus.right);
       }

    }

    void postOrder(Node focus){
        if (focus != null){
            inOrder(focus.left);
            inOrder(focus.right);
            System.out.print(focus.key + "\t");
        }
    }

    void preOrder(Node focus){
        if (focus != null){
            System.out.print(focus.key + "\t");
            inOrder(focus.left);
            inOrder(focus.right);

        }
    }




    void insert(int key) {
        if (root == null) {
            root = new Node(key, null);
        } else {

            boolean found = false;
            Node pointer = root;
            while (!found) {


                if (pointer.key > key) {
                    if (pointer.left == null) {
                        pointer.left = new Node(key, root);
                        found = true;
                    } else {
                        pointer = pointer.left;
                    }


                } else {
                    if (pointer.right == null) {
                        pointer.right = new Node(key, root);
                        found = true;
                    } else {
                        pointer = pointer.right;
                    }

                }
            }

        }
    }



    private class Node{
        Node parent;
        Node left;
        Node right;
        int key;



        Node(int key, Node parent){
            this.key = key;
            this.parent = parent;
            left = null;
            right = null;
        }



    }

}
