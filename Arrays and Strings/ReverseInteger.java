class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        int sign = 1;
        if(x < 0) {
            sign = -1;
            x = -1 * x;
        }
        while(x > 0) {
            int r = x%10;
            if(res > Integer.MAX_VALUE/10) {
                return 0;
            }
            res = res * 10 + r;
            x = x/10;
        }

        return (sign == -1)? -1 * res : res;
    }
}

//reverse Integer. if it overflows return 0;