package algorithms.basic.twoPointer;

/*
2134. Minimum Swaps to Group All 1's Together II
https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/?envType=daily-question&envId=2024-08-02
 */
public class MinSwaps {
    public int minSwaps(int[] nums) {

        int swaps = Integer.MAX_VALUE, window = 0;

        // count num 1s
        for(int num:nums){
            if(num==1) window++;
        }

        if(window == 0 || window == nums.length) return 0;

        int count1 = 0;

        // Calculate initial num of 1s count in window
        for (int i = 0; i < window; i++) {
            if (nums[i] == 1) count1++;
        }

        int L = 0, R = window - 1;
        swaps = Math.min(swaps,window-count1);

        // increase L & R by 1 to adjust the window size. Update count of 1s accordingly
        while(L<nums.length){
            if(nums[L] == 1) count1--;
            L++;
            R++;
            if(R==nums.length) R = 0;
            if(nums[R] == 1) count1++;
            swaps = Math.min(swaps,window-count1);
        }

        return swaps;
    }
}
