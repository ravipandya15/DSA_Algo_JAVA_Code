package Heap_Aditya_Verma;
import java.util.PriorityQueue;;

public class Find_the_Kth_Largest_Integer_in_the_Array_1985 {

    // compareTo -> 
    // returns +ve number -> if o1 < 02
    // -ve number -> if o1 > o2
    // 0 -> if o1 == o2

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> mini = new PriorityQueue<String>((o1, o2) -> {
            if (o1.length() == o2.length())
            {
                return o1.compareTo(o2);
            }
            else
            {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        for (String num : nums)
        {
            mini.add(num);

            if (mini.size() > k)
            {
                mini.poll();
            }
        }

        return mini.peek();
    }
    
}
