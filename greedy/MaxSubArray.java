class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int max_sum = nums[0];
        int sum  = nums[0];

        for(int i = 1; i < nums.length; i++) {
            sum = Math.max(sum+nums[i],nums[i]);
            max_sum = Math.max(max_sum,sum);
        }
        return max_sum;
    }
}

// It can be done using greedy logic. at each point, see compare if cumulative sum and value at that position.
// then compare it with global max
// return global max;

// time complexity : O(n)
// space Complexity : O(1)
