class MissingNumber {
    public int missingNumber(int[] nums) {
        //find length and calculat sum.
        // find sum of these
        // subtract and we will get missing number
        int n = nums.length;
        int target = (n*(n+1))/2;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        return target-sum;
    }
}

//TC : O(n)
// SC: O(1)