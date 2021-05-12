
// TC Your runtime beats 99.89 % of java submissions.
// SC Your memory usage beats 53.37 % of java submissions.

class NumMatrix {

    int[][] sumMatrix;
    
    public NumMatrix(int[][] matrix) {
        
        sumMatrix = new int[matrix.length][matrix[0].length];    
        
        sumMatrix[0][0] = matrix[0][0];
        
        for (int c = 1; c < matrix[0].length; c++) {
            sumMatrix[0][c] = matrix[0][c] + sumMatrix[0][c-1];
        }
        
        for (int r = 1; r < matrix.length; r++) {
            sumMatrix[r][0] = matrix[r][0] + sumMatrix[r-1][0];
            for (int c = 1; c < matrix[0].length; c++) {
                sumMatrix[r][c] = matrix[r][c] + sumMatrix[r][c-1] + sumMatrix[r-1][c] - + sumMatrix[r-1][c-1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int fullRegionSum = sumMatrix[row2][col2];
        
        if (row1 > 0) {
            fullRegionSum -= sumMatrix[row1-1][col2];            
        }

        if (col1 > 0) {
            fullRegionSum -= sumMatrix[row2][col1-1];            
        }
        
        if (row1 > 0 && col1 > 0) {                
            fullRegionSum += sumMatrix[row1-1][col1-1];
        }
        
        return fullRegionSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */