class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for(int n : nums){
            heap.offer(n);
        }

        while(k>1){
            heap.poll();
            k--;
        }
        return heap.poll();
    }
}
// time complexity : O(nlogn)
// space complexity : O(n);
// use max heap. remove first k-1 elements and then return kth element which is also the kTh largest element. 