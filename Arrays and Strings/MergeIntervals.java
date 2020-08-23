class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        if(intervals.length == 1 || intervals.length == 0){
            return intervals;
        }

        Arrays.sort(intervals,(int[] a,int[] b)-> {
            return a[0]-b[0];
        });

        for(int i =1 ; i< intervals.length; i++){
            int lo = intervals[i][0];
            int hi = intervals[i][1];
            int prev = intervals[i-1][1];
            if(prev >= lo){
                intervals[i][0] = intervals[i-1][0];
                if(prev > hi) {
                    intervals[i][1] = intervals[i-1][1];
                }
            }
            else {
                ans.add(new int[]{intervals[i-1][0], intervals[i-1][1]});
            }
        }

        ans.add(new int[]{intervals[intervals.length-1][0],intervals[intervals.length-1][1]});

        int[][] result = new int[ans.size()][2];
        result = ans.toArray(result);
        return result;
    }
}

//time complexity : O(nlogn)
// space complexity : O(1);
// intuition: sort by the starting interval and then compare end intervals to merge two intervals at a time