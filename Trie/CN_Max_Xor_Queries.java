package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

public class CN_Max_Xor_Queries {
    
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        int m = queries.size();

        for (int i = 0; i < m; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(queries.get(i).get(1));
            temp.add(queries.get(i).get(0));
            temp.add(i);

            offlineQueries.add(temp);
        }

        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b)
            {
                return a.get(0).compareTo(b.get(0));
            }            
        });

        int index = 0;
        int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<Integer>(m);

        Trie trie = new Trie();

        // below line is required as ans.set will replace value with old value.
        for(int i = 0;i<m;i++) ans.add(-1); 

        for (int i = 0; i < m; i++)
        {
            while (index < n && arr.get(index) <= offlineQueries.get(i).get(0))
            {
                trie.insert(arr.get(index));
                index++;
            }
            
            int queryIndex = offlineQueries.get(i).get(2);
            if (index != 0)
            {
                ans.set(queryIndex, trie.getMax(offlineQueries.get(i).get(1)));
            }
            else
            {
                ans.set(queryIndex, -1);
            }
        }

        return ans;
    }
    
}
