package binarysearchtree;

import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        Node root = generateTree();
        // if (checkBST(root))
        // System.out.println("Yes");
        // else
        // System.out.println("No");

        ArrayList<Node> temp = nodesToArray(new ArrayList<Node>(), root);

        for (Node node : temp)
        {
            System.out.println(node.data);
        }
    }

    public static boolean checkBST(Node root)
    {
        boolean retVal = false;

        if (checkLeftNodes(root.left, root.data) && checkRightNodes(root.right, root.data))
        {
            retVal = true;
        }

        return retVal;
    }

    public static boolean checkLeftNodes(Node node, int parentData)
    {
        boolean retVal = true;

        if (node.left != null && node.right != null)
        {

            if ((node.left.data < node.data && node.data < node.right.data) && (node.left.data < parentData && node.right.data < parentData))
            {
                checkLeftNodes(node.left, node.data);
                checkRightNodes(node.right, node.data);
            }
            else
            {
                retVal = false;
            }
        }
        else if (node.left != null && node.right == null)
        {
            if (node.left.data < node.data)
                checkLeftNodes(node.left, node.data);
            else
                retVal = false;
        }
        else if (node.left == null && node.right != null)
        {
            if (node.right.data > node.data)
                checkRightNodes(node.right, node.data);
            else
                retVal = false;
        }
        else
        {
            retVal = true;
        }
        return retVal;
    }

    public static boolean checkRightNodes(Node node, int parentData)
    {
        boolean retVal = true;

        if (node.left != null && node.right != null)
        {

            if ((node.left.data < node.data && node.data < node.right.data) && (node.left.data > parentData && node.right.data > parentData))
            {
                checkLeftNodes(node.left, node.data);
                checkRightNodes(node.right, node.data);
            }
            else
            {
                retVal = false;
            }
        }
        else if (node.left != null && node.right == null)
        {
            if (node.left.data < node.data)
                checkLeftNodes(node.left, node.data);
            else
                retVal = false;
        }
        else if (node.left == null && node.right != null)
        {
            if (node.right.data > node.data)
                checkRightNodes(node.right, node.data);
            else
                retVal = false;
        }
        else
        {
            retVal = true;
        }
        return retVal;
    }

    public static ArrayList<Integer> convertArray(Node root)
    {
        ArrayList<Integer> retArray = new ArrayList<Integer>();
        ArrayList<Node> nodeArray = new ArrayList<Node>();

        return retArray;
    }

    public static ArrayList<Node> nodesToArray(ArrayList<Node> nodeArray, Node root)
    {
        if (root.left == null && root.right == null)
        {
            nodeArray.add(root);
            return nodeArray;
        }
        else
        {
            ArrayList<Node> tmp = nodeArray;
            if (root.left != null)
            {
                tmp = nodesToArray(tmp, root.left);
            }
            tmp.add(root);
            if (root.right != null)
            {
                tmp = nodesToArray(tmp, root.right);
            }
            return tmp;
        }

    }

    public static Node generateTree()
    {
        Node root = new Node();
        root.data = 5;
        root.left = new Node();
        root.right = new Node();

        root.left.data = 3;
        root.left.left = new Node();
        root.left.left.data = 1;
        root.left.right = new Node();
        root.left.right.data = 4;

        root.right.data = 8;
        root.right.left = new Node();
        root.right.left.data = 2;
        root.right.right = new Node();
        root.right.right.data = 9;

        return root;
    }

}
