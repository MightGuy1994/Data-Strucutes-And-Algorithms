class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexPositions = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<S.length(); i++) {
            char ch = S.charAt(i);
            lastIndexPositions[ch-'a'] = i;
        }

        int j = 0, anchor = 0;

        for(int i = 0; i<S.length(); i++) {
            char ch = S.charAt(i);
            j = Math.max(j,lastIndexPositions[ch-'a']);
            if(i == j){
                ans.add(j-anchor+1);
                anchor = i+1;
            }
        }
        return ans;
    }
}

// two pointers j, anchor.
// anchor - it points to starting point of that partition.
// j points to the end of parition.
// logic here is : store all the possible last indexes of the characters.
// while iterating second time, j should be the max of all characters present in that partition.

