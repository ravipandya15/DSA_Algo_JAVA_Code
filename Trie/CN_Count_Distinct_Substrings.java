package Trie;

class Node
{
    Node[] links = new Node[26];

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
}

public class CN_Count_Distinct_Substrings {
    
    public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
        int n = s.length();
        Node root = new Node();
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            Node node = root;
            for (int j = i; j < n; j++)
            {
                if (!node.containsKey(s.charAt(j)))
                {
                    count++;
                    node.put(s.charAt(j), new Node());
                }
                node = node.get(s.charAt(j));
            }
        }
        return count + 1;
	}

}
