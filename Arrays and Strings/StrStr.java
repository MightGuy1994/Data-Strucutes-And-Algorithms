class StrStr {
    public int strStr(String haystack, String needle) {

        if(needle.length() == 0)
            return 0;

        int i = 0, j = 0;

        while(i < haystack.length()){

            if(haystack.charAt(i) == needle.charAt(j)){
                j++;

                if(j == needle.length()){
                    return i-j+1;
                }

            }
            else {

                i = i-j+1;
                j = 0;
                continue;
            }
            i++;
        }
        return -1;
    }
}

// logic. use two pointers. move j with respective i and compare characters. if j reache needle length, return i-j+1
// if any character mismatches, start i from i-j+1;
// time complexity : O((n-l)l) worst case
// space complexity : O(1)
