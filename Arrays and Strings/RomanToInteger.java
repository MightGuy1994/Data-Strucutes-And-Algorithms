class Solution {
    private Map<Character,Integer> map;

    Solution(){
        this.map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

    public int romanToInt(String s) {
        int length = s.length();
        int j = length -1, i = length -2, result = map.get(s.charAt(j));

        while(i>=0){
            if(map.get(s.charAt(i)) < map.get(s.charAt(j))){
                result -=map.get(s.charAt(i));
            }
            else {
                result +=map.get(s.charAt(i));
            }
            i--;
            j--;
        }
        return result;
    }
}
// again two pointer method. this time right to left. i,j are consecutive.
// intuition: if value(i) < value(j) remove value(i) from result. else add value(i).
// timecomplexity : O(n)
// space complexity :O(1).