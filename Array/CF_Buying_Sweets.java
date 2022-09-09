import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF_Buying_Sweets {
    class Sweet{
        public int cost;
        public int cashBack;
        public int diff;
        
        Sweet(int cost, int cashBack, int diff)
        {
            this.cost = cost;
            this.cashBack = cashBack;
            this.diff = diff;
        }

        Sweet() {}
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0)
        {
            int n = Integer.parseInt(sc.nextLine());
            int R = Integer.parseInt(sc.nextLine());
            
            List<Sweet> sweet = new ArrayList<>();
            
            for (int i = 0; i < n; i++)
            {
                Sweet s = new Sweet();
                s.cost = Integer.parseInt(sc.nextLine());
                sweet.add(s);
            }
            for (int i = 0; i < n; i++)
            {
                sweet.get(i).cashBack = Integer.parseInt(sc.nextLine());
                sweet.get(i).diff = sweet.get(i).cost - sweet.get(i).cashBack;
            }

            Collections.sort(sweet, (a, b) -> a.diff - b.diff);
            int count = 0, index = 0;
            while (R > 0 && index < n)
            {
                if (sweet.get(index).cost <= R)
                {
                    R -= sweet.get(index).diff;
                    count++;
                }
                else
                {
                    index++;
                }
            }
            t--;
        }
     }
}
