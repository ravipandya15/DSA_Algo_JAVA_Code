package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class Jump_Game_III_1306 {

    // DFS and BFS topic

    public static boolean solve(int ind, int[] arr, boolean[] visited)
    {
        // base case
        if (ind < 0 || ind >= arr.length) return false;
        if (arr[ind] == 0) return true;
        if (visited[ind]) return false;

        // important
        visited[ind] = true;

        return solve(ind + arr[ind], arr, visited) || solve(ind - arr[ind], arr, visited);
    }

    // Memoization
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return solve(start, arr, visited);
    }
}
