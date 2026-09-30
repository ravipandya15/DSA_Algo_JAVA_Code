class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int result = 1; 
        long totalSum = 0;
        Arrays.sort(nums);
        for (int right = 0; right < n; right++) {
            totalSum += nums[right];

            while (getNumberOfOperationsNeeded(left, right, nums[right], totalSum) > k) {
                totalSum -= nums[left];
                left += 1;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    private static long getNumberOfOperationsNeeded(int left, int right, int elementToReach, long totalSum) {
        int totalElements = right - left + 1;
        return (long)((long)totalElements * elementToReach) - totalSum;
    }
}
