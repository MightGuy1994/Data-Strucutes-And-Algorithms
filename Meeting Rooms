class Solution {
public:
    bool canAttendMeetings(vector<vector<int>>& intervals) {
       if (intervals.size() == 0 || intervals.size() == 1) {
           return true;
       }
       std::sort(intervals.begin(), intervals.end());
       for (int i = 1; i < intervals.size(); i++) {
           if (intervals[i][0] < intervals[i-1][1]) {
               return false;
           }
       }
       return true; 
    }
};
