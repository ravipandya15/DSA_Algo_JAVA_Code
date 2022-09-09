package Heap_Love_Babbar;

import java.util.Collections;
import java.util.PriorityQueue;

public class Find_Median_from_Data_Stream_295 {
    class MedianFinder {
        // max Heap
        PriorityQueue<Integer> maxi = new PriorityQueue<>(Collections.reverseOrder());
        // min Heap
        PriorityQueue<Integer> mini = new PriorityQueue<>();
        double median = -1;
        public MedianFinder() {
        }

        public int sigmoid(int a, int b)
        {
            if (a == b) return 0;
            else if (a > b) return 1;
            else return -1;
        }
        
        public void addNum(int num) {
            switch (sigmoid(maxi.size(), mini.size()))
            {
                case 0:
                    if (num > median)
                    {
                        mini.add(num);
                        median = mini.peek();
                    }
                    else
                    {
                        maxi.add(num);
                        median = maxi.peek();
                    }
                    break;

                case 1:
                    if (num > median)
                    {
                        mini.add(num);
                        median = (maxi.peek() + mini.peek()) / 2.0;
                    }
                    else
                    {
                        mini.add(maxi.peek());
                        maxi.poll();
                        maxi.add(num);
                        median = (maxi.peek() + mini.peek()) / 2.0;
                    }
                    break;

                case -1:
                    if (num > median)
                    {
                        maxi.add(mini.peek());
                        mini.poll();
                        mini.add(num);
                        median = (maxi.peek() + mini.peek()) / 2.0;
                    }
                    else
                    {
                        maxi.add(num);
                        median = (maxi.peek() + mini.peek()) / 2.0;
                    }
                    break;
            }
        }
        
        public double findMedian() {
            return median;
        }
    }
}
