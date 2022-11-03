package Stack_and_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Car_Fleet_853 {

    public class Car
    {
        int position;
        int speed;

        public Car() {}
        public Car(int position, int speed)
        {
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];
        Stack<Float> st = new Stack<>(); // contains the time
        for (int i = 0; i < n; i++)
        {
            cars[i] = new Car(position[i], speed[i]);
        }

        Arrays.sort(cars, (a, b) -> a.position - b.position);
        for (int i = n-1; i >= 0; i--)
        {
            float time = (float)(target - cars[i].position) / cars[i].speed;
            if (st.isEmpty() || st.peek() < time)
            {
                st.push(time);
            }
        }
        return st.size();
    }
}
