package Stack_and_Queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair
{
    int freq;
    int pos;
    int val;

    Pair() {}
    Pair(int freq, int pos, int val)
    {
        this.freq = freq;
        this.pos = pos;
        this.val = val;
    }
}

// class Node
// {
//     int freq;
//     Pair pair;

//     Node() {}
//     Node(int freq, Pair pair)
//     {
//         this.freq = freq;
//         this.pair = pair;
//     }
// }

class FreqStack {
    HashMap<Integer, Integer> map;
    PriorityQueue<Pair> maxi;
    int pos;

    public FreqStack() {
        this.map = new HashMap<>();
        this.maxi = new PriorityQueue<>(new Comparator<Pair>() {

            @Override
            public int compare(Pair o1, Pair o2) {
                if (o2.freq > o1.freq) return 1;
                else if (o2.freq < o1.freq) return -1;
                else if (o2.freq == o1.freq)
                {
                    return o2.pos - o1.pos;
                }
                return 0;
            }
            
        });
        this.pos = 0;
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);
        maxi.add(new Pair(freq, this.pos++, val));
    }
    
    public int pop() {
        Pair top = maxi.peek();
        maxi.poll();

        int val = top.val;
        map.put(val, map.get(val) - 1);
        return val;
    }
}

public class Maximum_Frequency_Stack_895 {
    
}
