class FloodFill {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,1,-1};
    int m;
    int n;
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.m = image.length;
        this.n = image[0].length;
        this.oldColor = image[sr][sc];

        if(newColor == oldColor){
            return image;
        }

        dfs(image,sr,sc,newColor);
        return image;
    }

    void dfs(int[][] image, int sr, int sc, int newColor){

        if(image[sr][sc] == newColor)
            return;

        image[sr][sc] = newColor;
        for(int d = 0; d < 4; d++){
            int r = sr+dr[d];
            int c = sc+dc[d];

            if(r>=0 && c>=0 && r<m && c<n && image[r][c] == oldColor){
                dfs(image,r,c,newColor);
            }
        }
    }
}

//TC : O(v+e)
// sc :o(n^2)
// simple dfs logic on grid. move in all directions and check if the color is similar to old color. if yes, replace with new color.
// return when you see the newColor filled.
