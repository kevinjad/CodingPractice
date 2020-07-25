package MatrixProduct;

public class MatrixProduct {
    public static void main(String[] args){
        int [][] arr = {
            {-1,2,3},
            {4,5,-6},
            {7,8,9}
        };
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[][] mat){
        int sign=1;
        return maxProduct(mat,0,0,sign);
        
    }
    public static int maxProduct(int[][] mat,int row,int col,int sign){
        
        if(mat[row][col]*sign < 0){
            sign = sign*(-1);
        }

        if(row == mat.length-1 && col ==mat[0].length-1){
            return mat[row][col];
        }
        if(row+1 < mat.length){
            if(col+1 < mat.length){
                if(sign > 0)
                    return Math.max(maxProduct(mat,row+1,col,sign)*mat[row][col],maxProduct(mat,row,col+1,sign)*mat[row][col]);
                else{
                    return Math.min(maxProduct(mat,row+1,col,sign)*mat[row][col],maxProduct(mat,row,col+1,sign)*mat[row][col]);
                }
            }
            return maxProduct(mat,row+1,col,sign)*mat[row][col];
        }
        return maxProduct(mat,row,col+1,sign)*mat[row][col];
    }
}