/*
    The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

 

Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
Example 3:

Input: nums = [3,9,6], k = 2
Output: 1
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 105
*/

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


    /**
     Number of operations needed for all elements in the window [startIndex, endIndex] to hit A[endIndex]
     Example:
     Consider arr with [1, 2, 3, 4] with startIndex = 0; endIndex = 3: i.e If 1, 2, 3 wants to become 4.
     Number of operations needed
     = (4-1)+(4-2)+(4-3)+(4-4) = 6.
     =  4 + 4 + 4 + 4 - (1 + 2 + 3+ 4)
     = 4 * 4 - (1 + 2 + 3 + 4)
     = (number of elements) * ElementToReach - sum of elements in the window
     */
    private static long getNumberOfOperationsNeeded(int left, int right, int elementToReach, long totalSum) {
        int totalElements = right - left + 1;
        return (long)((long)totalElements * elementToReach) - totalSum;
    }
}
