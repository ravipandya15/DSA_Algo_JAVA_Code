package Trie;

class Node
{
    Node[] links = new Node[26];
    int countEndWith = 0;
    int countPrefix = 0;

    Node() {}

    boolean containsKey(char ch)
    {
        return (links[ch - 'a'] != null);
    }
    
    void put(char ch, Node node)
    {
        links[ch - 'a'] = node;
    }

    Node get(char ch)
    {
        return links[ch - 'a'];
    }

    void increaseEndWith()
    {
        countEndWith++;
    }

    void increasePrefix()
    {
        countPrefix++;
    }

    void decreaseEndWith()
    {
        countEndWith--;
    }

    void decreasePrefix()
    {
        countPrefix--;
    }

    int getEnd()
    {
        return countEndWith;
    }

    int getPrefix()
    {
        return countPrefix;
    }
}

class Trie {
    private Node root; 
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for (int i =0; i < word.length(); i++)
        {
            if (!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }

        node.increaseEndWith();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for (int i =0; i < word.length(); i++)
        {
            if (node.containsKey(word.charAt(i)))
            {
                node = node.get(word.charAt(i));
            }
            else
                return 0;
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for (int i =0; i < word.length(); i++)
        {
            if (node.containsKey(word.charAt(i)))
            {
                node = node.get(word.charAt(i));
            }
            else
                return 0;
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for (int i =0; i < word.length(); i++)
        {
            if (!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.decreasePrefix();
        }

        node.decreaseEndWith();
    }
}

public class CN_Implement_Trie_ll {
    
}
