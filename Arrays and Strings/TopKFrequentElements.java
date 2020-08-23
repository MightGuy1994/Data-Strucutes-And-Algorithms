class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> map.get(b).intValue()-map.get(a).intValue());

        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        heap.addAll(map.keySet());
        int[] result = new int[k];
        int i = 0;
        while(i<k){
            result[i++] = heap.poll();
        }
        return result;
    }
}

//time complexity : O(nlogn)
// space complexity : O(n);