class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i<nums.length && nums[i] <=0 ; i++){
            if(i >0 && nums[i] == nums[i-1]) {continue;}
            twoSum(nums,i,res);
        }
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res){
        int lo = i+1, hi = nums.length-1;

        while(lo<hi){
            int sum = nums[i]+nums[lo]+nums[hi];

            if(sum >0){
                hi--;
            }
            else if (sum <0){
                lo++;
            }
            else {
                res.add(Arrays.asList(nums[i],nums[lo++],nums[hi--]));
                while(lo <hi && nums[lo] == nums[lo-1]) lo++;
            }
        }
    }
}

// interesing question. Sort the array. for each value of i, find two sum on rest of the array elements. use two pointer logic.
// time complexity : O(n2)
// space complexity : O(1);