
class MinWin {
    public String minWindow(String s, String t) {


        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int i = 0, j  = 0, k = 0;
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> ref = new HashMap<>();


        for(char ch: t.toCharArray()) {
            ref.put(ch,ref.getOrDefault(ch,0)+1);
        }
        int required = ref.size();

        int[] ans = {-1,0,0};
        int formed = 0;

        while(i < s.length()){
            char ch = s.charAt(i);

            window.put(ch,window.getOrDefault(ch,0)+1);
            if(ref.containsKey(ch) && window.get(ch).intValue() == ref.get(ch).intValue()){
                formed++;
                // System.out.println(formed);
            }

            while(j <= i && required == formed ){

                ch = s.charAt(j);
                if(ans[0] == -1 || ans[0] > i-j+1){
                    ans[0] = i-j+1;
                    ans[1] = j;
                    ans[2] = i;
                }
                window.put(ch,window.get(ch)-1);
                if(ref.containsKey(ch) && window.get(ch).intValue() < ref.get(ch).intValue()){
                    formed--;
                }
                j++;
            }
            i++;
        }
        return ans[0] == -1 ? "":s.substring(ans[1],ans[2]+1);

    }
}

// time complexity : O(s+t)
// space complexity : O(s+t)