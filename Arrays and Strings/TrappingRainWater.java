class TrappingRainWater {
    public int trap(int[] height) {

        if(height.length==0)
            return 0;
        int maxVolume = 0;
        int[] lh = new int[height.length];
        int[] rh = new int[height.length];
        lh[0] = height[0];
        rh[height.length-1] = height[height.length-1];
        for(int i = 1; i<height.length; i++){
            lh[i] = Math.max(height[i], lh[i-1]);
        }

        for(int j = height.length-2; j>=0 ; j--){
            rh[j] = Math.max(height[j],rh[j+1]);
        }

        for(int i = 0; i<height.length;i++){
            maxVolume += Math.min(lh[i],rh[i])-height[i];
        }
        return maxVolume;
    }
}

//time complexity : o(n)
// space complexity : O(n)
// intuition : save left and right heights. and calculate volume at each point.