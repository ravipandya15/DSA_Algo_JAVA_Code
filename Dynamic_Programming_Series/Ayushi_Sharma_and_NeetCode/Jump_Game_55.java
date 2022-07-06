package Dynamic_Programming_Series.Ayushi_Sharma_and_NeetCode;

public class Jump_Game_55 {

    // Greedy solution
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;

        for (int i = n - 1; i >= 0; i--)
        {
            if (i + nums[i] >= goal) goal = i;
        }
        return goal == 0 ? true : false;
    }
}
