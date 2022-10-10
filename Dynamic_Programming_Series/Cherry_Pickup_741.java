package Dynamic_Programming_Series;

public class Cherry_Pickup_741 {

    public static int solve(int i, int j, int n, int[][] grid)
    {
        
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int ans = solve(n-1, n-1, n, grid);
        if (ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}
