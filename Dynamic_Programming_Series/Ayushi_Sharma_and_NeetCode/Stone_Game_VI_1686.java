package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.util.Pair;

public class Stone_Game_VI_1686 {
    public int stoneGameVI(int[] A, int[] B) {
        int n = A.length;
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            list.add(new Pair<Integer,Integer>(A[i] + B[i], i));
        }

        // Collections.sort(list, Comparator.comparingInt(x->x.getKey()));
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {

            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                if (p1.getKey() < p2.getKey()) return 1;
                else if (p1.getKey() > p2.getKey()) return -1;
                return 0;
            }
        }); // sorting in descending order

        int flag = 1;
        int a = 0, b = 0;
        for (Pair<Integer, Integer> x : list)
        {
            if (flag == 1) a += A[x.getValue()];
            else b += B[x.getValue()];
            flag = 1 - flag;
        }
        if (a > b) return 1;
        else if (a < b) return -1;
        return 0;
    }
}
