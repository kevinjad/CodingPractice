package MatrixFind;


public class MatrixFind {
    public static void main(String[] args){
        int[][] mat = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(ContainsElementInMatrix(mat, 9));
    }

    public static boolean ContainsElementInMatrix(int[][] mat,int x){
        int n = mat.length;
        int m = mat[0].length;
        int mid;
        for(int i =0;i<n;i++){
            if(x >= mat[i][0] && x <= mat[i][m-1]){
                int l=0;
                int h = m-1;
                while(l<=h){
                    mid = (l+h)/2;
                    if(x == mat[i][mid]) return true;
                    if(x<mat[i][mid]){
                        h = mid-1;
                        continue;
                    }
                    if(x>mat[i][mid]){
                        l = mid+1;
                    }
                }
            }
        }
        return false;
    }
}