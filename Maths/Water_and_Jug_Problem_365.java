class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) return false;
        if (target == x || target == y || target == x + y) return true;

        return target % GCD(x, y) == 0;
    }

    private static int GCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    // using BFS
    public boolean canMeasureWater(int x, int y, int target) {
  
          Queue<int[]> queue = new LinkedList<>();      
          Set<String> seen = new HashSet<>();         
          queue.add(new int[]{0, 0});
          seen.add(0 + "," + 0);
          while (!queue.isEmpty()) {
              int[] currSearch = queue.poll();
              int a = currSearch[0], b = currSearch[1];    // Current water levels of the jars x and y.
              if (a + b == target) return true;
              
              // Make all next possible moves with the current state of the jugs:
              List<int[]> nextMoves = new ArrayList<>();
              nextMoves.add(new int[]{0, b});     // Empty x.
              nextMoves.add(new int[]{x, b});     // Fill x.
              nextMoves.add(new int[]{a, 0});     // Empty y.
              nextMoves.add(new int[]{a, y});     // Fill y.
              if (x - a >= b) {
                  nextMoves.add(new int[] {a + b, 0});
              } else {
                  nextMoves.add(new int[] {x, b - (x - a)});
              }
  
              if (y - b >= a) {
                  nextMoves.add(new int[] {0, a + b});
              } else {
                  nextMoves.add(new int[] {a - (y - b), y});
              }
              
              for (int[] move : nextMoves) {
                  String key = move[0] + "," + move[1];
                  if (!seen.contains(key)) {
                      seen.add(key);
                      queue.add(move);
                  }
              }
          }
          return false;   // There is no way to measure z by using jugs x and y.
    }
}
