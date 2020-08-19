class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length && diff != 0; i++){
            int lo = i+1, hi = nums.length-1;
            while(lo<hi){
                int sum = nums[i] + nums[lo] + nums[hi];

                if(Math.abs(target-sum) < Math.abs(diff)){
                    diff = target-sum;
                }

                if(sum < target){
                    lo++;
                }
                else {
                    hi--;
                }
            }
        }
        return target - diff;
    }
}

//intuition: logic is very similar to 3 sum. sort array and use two pointer logic. instead of sum use, diff and update the mininum
//difference.
// Time complexity O(n2)
// space complexity : O(logn) or O(1) depending on sorting algorithm

