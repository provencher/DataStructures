/**
 * Created by Eric on 2014-12-04.
 */
public class Driver {
    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();

        System.out.println("Insert 25 randomly generated numbers to Binary Search Tree");
        for (int i = 0; i< 25; i++){
            int rand = (int) (Math.random()*150 + 1);
            System.out.print(rand + "\t");
            tree.insert(rand);

        }
        System.out.println("\n");



        System.out.println("inOrder Traversal");
        tree.inOrder(tree.root);
        System.out.println("\n");

        System.out.println("PreOrder Traversal");
        tree.preOrder(tree.root);
        System.out.println("\n");

        System.out.println("PostOrder Traversal");
        tree.postOrder(tree.root);
        System.out.println("\n");


    }
}
