class RotateImage {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        //transpose matrix

        for(int i = 0; i < n ; i++){
            for(int j = i; j < n ; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}

//logic: transpose the matrix and then reverse each row.
// tc : o(n2)
// sc : o(1) - in place

