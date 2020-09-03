class ArrayDerangement {
    public int findDerangement(int n) {

        if(n <= 1) {return 0;}
        long[] dp = new long[n+1];
        dp[2] =1;

        for(int i = 3; i<=n ; i++){
            dp[i] = (i-1) * (dp[i-1]+dp[i-2])%1000000007;
        }
        return (int)dp[n];
    }
}

// dynamic question it uses the following logic. dp[n] = (n-1) (dp[n-2]+dp[n-1])
// if n is position at i, we have two choices.
// swap n and i positions. then we are dealing with n-2 position and n-2 values : dp[n-2]
// not swap n and i positions. then we are looking at n-1 positons and n-1 values. dp[n-1]
// and n can be in n-1 positons.

// normal approach i got is : use recursion and backtracking. the time complexity will be O(n2). unfortunately its time limit exceed.

class ArrayDerangement {
    private int count = 0;
    public int findDerangement(int n) {
        Set<Integer> set = new HashSet<>();
        for(int i  =1 ; i<= n ; i++) {
            set.add(i);
        }

        findDerangement(n,1,set);
        return count%1000000007;
    }

    void findDerangement(int n, int position,Set<Integer> set) {
        if(position > n) {
            count++;
            return;
        }

        for(int i = 1 ; i<=n; i++) {
            if(i == position) { continue;}
            if(set.contains(i)){
                set.remove(i);
                findDerangement(n,position+1,set);
                set.add(i);
            }
        }
        return;
    }
}