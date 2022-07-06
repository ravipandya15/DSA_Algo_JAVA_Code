package String;

import java.util.ArrayList;

public class Baseball_Game_682 {
    public int calPoints(String[] ops) {
        ArrayList<Integer> list = new ArrayList<>();
        int size = 0;
        for (String ch : ops)
        {
            if (ch.equals("+"))
            {
                list.add(list.get(size - 1) + list.get(size - 2));
                size++;
            }
            else if (ch.equals("D"))
            {
                list.add(2 * list.get(size - 1));
                size++;
            }
            else if (ch.equals("C"))
            {
                list.remove(size - 1);
                size--;
            }
            else
            {
                list.add(Integer.parseInt(ch));
                size++;
            }
        }

        int sum = 0;
        for (int i : list)
        {
            sum += i;
        }
        return sum;
    }
}
