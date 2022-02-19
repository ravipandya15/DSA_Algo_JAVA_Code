package Queue.Love_bubber_Queue;

import java.util.LinkedList;

import java.util.Queue;
import java.util.HashMap;

public class GFG_First_non_repeating_character_in_a_stream {
    
    public String FirstNonRepeating(String A)
    {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();

        for (int i = 0; i < A.length(); i++)
        {
            // increase count;
            if (count.containsKey(A.charAt(i)))
            {
                int temp = count.get(A.charAt(i));
                temp++;
                count.put(A.charAt(i), temp);
            }
            else
            {
                count.put(A.charAt(i), 1);
            }

            // add it in queue
            q.add(A.charAt(i));

            while (!q.isEmpty())
            {
                if (count.get(q.peek()) > 1)
                {
                    q.poll();
                }
                else
                {
                    sb.append(q.peek());
                    break;
                }
            }

            if (q.isEmpty())
            {
                sb.append('#');
            }
        }

        return sb.toString();
    }
}
