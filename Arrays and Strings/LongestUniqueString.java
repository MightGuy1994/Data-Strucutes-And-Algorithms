class Solution {
    public int lengthOfLongestSubstring(String s) {
        //two pointer method

        if(s.length()==0)
            return 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j =0;
        int ans =0;

        while(i<s.length()){

            while(j<i && set.contains(s.charAt(i))){
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            ans = Math.max(i-j+1,ans);
            i++;
        }
        return ans;
    }
}

// simple logic window sliding. use two pointers. that moves on same direction. Use set to store iterated elements.
// TC O(n)
// SC O(n);