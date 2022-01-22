package Trie;

class Node
{
    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {}

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

    void setEnd()
    {
        flag = true;
    }

    boolean isEnd()
    {
        return flag;
    }
}

class Trie {

    private Node root;

    //Initialize your data structure here

    Trie() {
        root = new Node();
    }

    //Inserts a word into the trie

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++)
        {
            if (!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
            }

            node = node.get(word.charAt(i));
        }

        node.setEnd();
    }

    public boolean checkIfAllPrefixExists(String word)
    {
        Node node = root;
        for (int i = 0; i < word.length(); i++)
        {
            if (node.containsKey(word.charAt(i)))
            {
                node = node.get(word.charAt(i));
                if (node.isEnd() == false) return false;
            }
            else
            {
                return false;
            }
        }

        return true;
    } 
}


public class CN_Complete_String {
    
    public static String completeString(int n, String[] a) {
        // Write your code here.
        Trie trie = new Trie();
        for (String it : a)
        {
            trie.insert(it);
        }

        String longest = "";
        for (String it : a)
        {
            if (trie.checkIfAllPrefixExists(it))
            {
                if (it.length() > longest.length())
                {
                    longest = it;
                }
                else if (it.length() == longest.length() && it.compareTo(longest) < 0)
                {
                    longest = it;
                }
            }
        }

        if (longest == "") return "None";
        return longest;
    }

}
