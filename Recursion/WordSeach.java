class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)
            return false;

        int m = board.length;
        int n = board[0].length;
        int index =0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == word.charAt(index)){
                    if(wordExist(board,word,index+1,i,j,m,n,visited))
                        return true;
                }
            }
        }
        return false;
    }

    boolean wordExist(char[][] board, String word, int index, int i ,int j,int m, int n,boolean[][] visited){

        if(visited[i][j] == true)
            return false;
        if(index == word.length())
            return true;

        visited[i][j] = true;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int[] dir: directions){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && r<m && c >=0 && c<n && board[r][c] == word.charAt(index) ){
                if(wordExist(board,word,index+1,r,c,m,n,visited))
                    return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}

//SC : Stack can increase up to length of word. O(w)
//TC: O(MN)