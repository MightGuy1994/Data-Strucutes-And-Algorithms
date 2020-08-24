class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });

        for(int i = 1; i<intervals.length; i++) {
            int lo = intervals[i][0];
            int hi = intervals[i-1][1];
            //int prev = intervals[i][1];
            if(hi > lo) {
                return false;
            }
        }
        return true;
    }
}

// time complexity : O(nlogn)
// space complexity : O(1)