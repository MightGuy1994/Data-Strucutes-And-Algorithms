class SubArrayEqualsToK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i =0 ; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

// interesting method of using maps to store the cumulative sum up to point i and the occurence of same sum values.
// at each point i, we find count of sum-k occurences and add them to count.
// time complexity : O(n)
// space complexity : O(n)


// we can also use brute force O(n2) and find out the sum of subarrays equal to k.
