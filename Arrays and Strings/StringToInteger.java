class Solution {
    public int myAtoi(String str) {
        int sign = 1;
        int ans = 0;
        int i = 0;

        while(i<str.length() && str.charAt(i) == ' '){
            i++;
        }

        if(i<str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')){
            sign = (str.charAt(i++) == '+')?1:-1;
        }

        while(i<str.length() && Character.isDigit(str.charAt(i))){

            if((ans>Integer.MAX_VALUE/10)||((ans==Integer.MAX_VALUE/10)&&str.charAt(i)-'0'> Integer.MAX_VALUE%10))
                return (sign == -1)?Integer.MIN_VALUE : Integer.MAX_VALUE;

            ans = ans*10+(str.charAt(i)-'0');
            i++;
        }

        return (sign == -1)?-1*ans: ans;
    }
}

//iterate through i. ignore spaces. check if first element is a sign.
// main logic: considering int overflows.
//time complexity : O(n)
// space complexity : O(1)