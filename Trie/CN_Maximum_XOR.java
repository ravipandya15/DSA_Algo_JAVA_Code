package Trie;
import java.util.ArrayList;

class Node
{
    Node[] links = new Node[2];

    boolean containesKey(int bit)
    {
        return (links[bit] != null);
    }

    Node get(int bit)
    {
        return links[bit];
    }

    void put(int bit, Node node)
    {
        links[bit] = node;
    }
}

class Trie
{
    private Node root;

    Trie()
    {
        root = new Node();
    }

    public void insert(int num)
    {
        Node node = root;
        for (int i = 31; i >= 0; i--)
        {
            int bit = (num >> i) & 1;
            if (!node.containesKey(bit))
            {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num)
    {
        Node node = root;
        int max = 0;
        for (int i = 31; i >=0; i--)
        {
            int bit = (num >> i) & 1;
            if (node.containesKey(1 - bit))
            {
                max = max | (1 << i);
                node = node.get(1 - bit);
            }
            else
            {
                node = node.get(bit);
            }
        }
        return max;
    }
}

public class CN_Maximum_XOR {
    
    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) 
	{
	    // Write your code here.  
        Trie trie = new Trie();
        for (Integer it : arr1) 
        {
            trie.insert(it);
        }
        
        int max = 0;
        for (Integer it : arr2)
        {
            max = Math.max(max, trie.getMax(it));
        }
        return max;
	}

}
