class LongestSubStringWithOutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int i = 0, j = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();

        while(i<s.length()){
            while(set.contains(s.charAt(i)) && j < i){
                set.remove(s.charAt(j));
                j++;
            }
            maxLen = Math.max(i-j+1,maxLen);
            set.add(s.charAt(i));
            i++;
        }
        return maxLen;
    }
}

//window sliding slow catching technique.
// used hashset to store the characters.
//tc : O(n)
//sc : O(n)
