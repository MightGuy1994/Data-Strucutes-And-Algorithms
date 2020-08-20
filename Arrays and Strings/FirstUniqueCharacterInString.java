class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        if(s.isEmpty())
            return -1;

        int[] values = new int[26];

        for(int i = 0; i<s.length(); i++){
            values[s.charAt(i)-'a']++;
        }
        for(int i =0; i<s.length(); i++){
            if(values[s.charAt(i)-'a'] ==1)
                return i;
        }
        return -1;
    }
}

//TC : o(n)
// sc : O(1);