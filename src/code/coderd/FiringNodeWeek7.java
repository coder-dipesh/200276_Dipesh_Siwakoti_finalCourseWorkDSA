package code.coderd;


//     There are N nodes representing the number of houses in the form of tree, return
//      minimum number of nodes in which you can start fire in order to burn all house.
//      Note that fire starts on any node can burn its children, parents and itself.
//      coder-dipesh

public class FiringNodeWeek7 {

    static class Node {
        public int key;
        public Node left, right;
    };

    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }
    static int count = 0;

    static int CaptureFire(Node root)
    {
        if (root == null)
            return 1;
        int L = CaptureFire(root.left);
        int R = CaptureFire(root.right);

        if (L == 1 && R == 1)
            return 2;

        else if (L == 2 || R == 2) {
            count++;
            return 3;
        }
        return 1;
    }

    static void Setup(Node root)
    {
        int value = CaptureFire(root);

        System.out.println(count + (value == 2 ? 1 : 0));
    }

    public static void main(String[] args)
    {
        Node root = newNode(0);
        root.left = newNode(0);
        root.left.left = newNode(0);
        root.left.left.left = newNode(0);
        root.left.left.left.right = newNode(0);
        Setup(root);
    }
}
