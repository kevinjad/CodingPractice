package MatrixSubOne;

public class MatrixSubOne {
    public static void main(String[] args){
        int[][] matrix = {
            {1,1,1,0},
            {1,1,1,1},
            {1,1,0,0},
            {0,0,0,0}
        };
        System.out.println(matrixSubOne(matrix));
    }
    public static int matrixSubOne(int[][] matrix){
        int[][] dp_table = new int[matrix.length][matrix[0].length];
        int max=0;
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0) continue;
                if(i==0 || j==0){
                    dp_table[i][j]=1;
                }
                else{
                    dp_table[i][j]= Math.min(Math.min(dp_table[i-1][j], dp_table[i][j-1]),dp_table[i-1][j-1])+1;
                }
                max = dp_table[i][j] > max ? dp_table[i][j] : max;
            }
        } 
        return max;
    }
}