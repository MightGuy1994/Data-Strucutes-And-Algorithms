class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length == 0)
            return 0;

        int i = 0, j = height.length-1, volume = 0;

        while(i<j){

            volume = Math.max(volume,Math.min(height[i],height[j])*(j-i));

            if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return volume;
    }
}

// two pointer concept : opposite ends
// calculate max volume at a position and compare it with global max.
// iterate i, j which ever is less at that time.
// TC O(n)
// sc o(1)