class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];
        for(char ch : tasks)
            count[ch-'A']++;

        Arrays.sort(count);
        int fmax = count[25];
        int idle_count = (fmax-1) * n; // where n is minimum time between two tasks



        for(int i = count.length-2; i>=0 && idle_count>0; i--) {
            idle_count -= Math.min(count[i],fmax-1); // count[i] > fmax-1 only when count[i] = fmax.
        }

        idle_count = Math.max(0,idle_count);
        return tasks.length+idle_count;

    }
}

// not sure how people get idea in the interview if experienced suddenly but its typically a greedy solution.
// intuition. here the total_time = tasks.length + idle time.
// if we can find the idle time required to complete the highest frequency. which we can find (fmax-1) *n
// iterate other tasks in the order of frequency.try to fill as many idle spots as possible.
// finally return idle_time + tasks.length

// time complexity : O(n) number of tasks.
// space complexity : O(1)