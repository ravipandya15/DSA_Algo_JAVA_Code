package Trees;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {

    public Node connect(Node root) {
        Node cur = root;

        while (cur != null)
        {
            Node temp = null;
            while (cur != null)
            {
                if (cur.left != null)
                {
                    if (temp == null) temp = cur.left;
                    if (cur.right != null)
                    {
                        cur.left.next = cur.right;
                    }
                    else
                    {
                        boolean flag = false;
                        Node temp2 = cur;
                        while (temp2.next != null)
                        {
                            if (temp2.next.left != null)
                            {
                                flag = true;
                                cur.left.next = temp2.next.left;
                            }
                            else if (temp2.next.right != null)
                            {
                                flag = true;
                                cur.left.next = temp2.next.right;
                            }
                            if (flag == true) break;
                            temp2 = temp2.next;
                        }
                    }
                }
    
                if (cur.right != null)
                {
                    if (temp == null) temp = cur.right;
                    boolean flag = false;
                    Node temp2 = cur;
                    while (temp2.next != null)
                    {
                        if (temp2.next.left != null)
                        {
                            flag = true;
                            cur.right.next = temp2.next.left;
                        }
                        else if (temp2.next.right != null)
                        {
                            flag = true;
                            cur.right.next = temp2.next.right;
                        }
                        if (flag == true) break;
                        temp2 = temp2.next;
                    }
                }
                cur = cur.next;
                
            }
            cur = temp;
        }
        return root;
    }
}
