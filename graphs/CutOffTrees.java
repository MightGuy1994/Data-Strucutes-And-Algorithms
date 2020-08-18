class CutOffTrees {
    int[] dr = {0,1,-1,0};
    int[] dc = {1,0,0,-1};

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        List<int[]> trees = new ArrayList<>();
        int ans = 0;

        //listing all tree positions.
        for(int i =0; i<m ; i++){
            for(int j = 0; j<n; j++){
                int val = forest.get(i).get(j);
                if(val > 1) {trees.add(new int[]{val,i,j});}
            }
        }
        // sorting trees by height so that we know between which trees we should find mininum distance
        Collections.sort(trees,(a,b)->a[0]-b[0]);

        int sr = 0, sc = 0;
        for(int[] tree : trees){
            int dist = bfs(forest,sr,sc,tree[1],tree[2]);
            if(dist<0) return -1;
            ans += dist;
            sr = tree[1];
            sc = tree[2];
        }
        return ans;
    }

    int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc){
        int m = forest.size(), n = forest.get(0).size();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        queue.add(new int[]{sr,sc,0});
        seen[sr][sc] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] == tr && curr[1] == tc) {return curr[2];}
            for(int d = 0; d<4; d++){
                int nr = curr[0]+dr[d];
                int nc = curr[1]+dc[d];
                if(nr < m && nc < n && nr >= 0 && nc >= 0 && !seen[nr][nc] && forest.get(nr).get(nc)>0){
                    queue.add(new int[]{nr,nc,curr[2]+1});
                    seen[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}

// time complexity: O((RC)^2)
//Space Complexity : O(RC).
// intuiton: I liked this question in the way it presented. it is to find min distance between two trees. We use bfs for that.
// The main point here is the sorting of tree by its height and store its co-ordinates.