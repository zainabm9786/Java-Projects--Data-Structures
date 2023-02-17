// Name: Zainab Mohammed
// Assignment: 9-Part-2-AVL

import chapter25.BST.TreeNode;
import chapter26.*;

import java.util.Scanner;

public class AVLTreeMain {
    public static void main(String[] args) {// WRITE COMMENTS!!
        Scanner sc = new Scanner(System.in);
        System.out.println("Follow the directions to enter a tree's node values:");
        AVLTree<Integer> avlTree = new AVLTree<Integer>();//creates the list to make tree

        System.out.println("Enter y/n to enter node values or an empty tree: ");
        String inputForFIrstNode = sc.nextLine();
        if (inputForFIrstNode.equalsIgnoreCase("y")) {
            while (true) {
                System.out.println("Enter node value: ");//enter number
                int value = sc.nextInt();//puts input into
                avlTree.insert(value);

                System.out.println("Enter y to continue or n to finish adding nodes: ");
                String yn = sc.next().toLowerCase().trim();
                if (yn.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }

        System.out.println("The number of nodes in the AVL Tree is " + avlTree.getSize() + " nodes.");

        if (checkIsAVLTree(avlTree)) {
            System.out.println("The provided tree is an AVL Tree");
        } else {
            System.out.println("The provided tree is not an AVL Tree");
        }

    }

    public static final Integer minAVLHeight = 0;
    public static final Integer maxAVLHeight = Integer.MAX_VALUE;

    public static boolean checkIsAVLTree(AVLTree<Integer> avlTree) {

        boolean isBST = checkIsBST(avlTree.getRoot(), minAVLHeight, maxAVLHeight);
        boolean isBalanced = checkIsBalanced(avlTree.getRoot());//is it balanced
        boolean isAVLTree = isBST && isBalanced;//if both are true then it is an avl tree
        return isAVLTree;
    }

    public static boolean checkIsBST(TreeNode<Integer> root, Integer minHeight, Integer maxHeight) {
        if (root == null) {//if the root is null, then the tree is a BST tree
            return true;
        }
        if (root.element > maxHeight || root.element < minHeight) {//if value is greater than maxhight or min hight return false
            return false;
        }
        boolean b = (checkIsBST(root.left, minHeight, root.element - 1)
                && checkIsBST(root.right, root.element + 1, maxHeight));
        return b;
    }

    public static boolean checkIsBalanced(TreeNode<Integer> root) {//checks if tree is balanced or not
        int leftSubTreeHeight, rightSubTreeHeight;
        if (root == null) {//if empty then the tree is balanced
            return true;//return true
        }
        leftSubTreeHeight = height(root.left);//recurses to find the left side height
        rightSubTreeHeight = height(root.right);//recurses to find the right side height
        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1 && checkIsBalanced(root.left) && checkIsBalanced(root.right)) {
            return true;
        }
        return false;
    }

    public static int max(int a, int b) {//compares the values of a and b, which can be height
        //and return the greater value
        int result;
        if (b <= a) {//if they are equal
            result = a;
        } else {//if a is left than b
            result = b;
        }
        return result;
    }

    public static int height(TreeNode<Integer> root) {//finds height
        int leftHeight, rightHeight, maxHeight, height = 0;

        if (root == null) {//if the empty then return the height is currently at
            return height;
        }
        leftHeight = height(root.left);//recurses through the left nodes until it reaches bottom node and then
        //makes leftHeight the hight of the left side of the tree
        rightHeight = height(root.right);//recurses through the left nodes until it reaches the bottom node and then mkes
        //rightHight the height of the right side of the tree
        maxHeight = 1 + max(leftHeight, rightHeight);//uses the max ethod to find which height it greater and then returns the value
        return maxHeight;
    }
}
