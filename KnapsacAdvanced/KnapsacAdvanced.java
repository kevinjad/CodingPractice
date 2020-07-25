package KnapsacAdvanced;

class Item{
    int value;
    int weight;
    Item(int value, int weight){
        this.value= value;
        this.weight = weight;
    }
}

public class KnapsacAdvanced {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        Item[] arr = {new Item(6, 1),new Item(10, 2),new Item(12, 3)};

        System.out.println(knapsackSolver(5, arr));
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000);
        System.out.print(" us");
    }
    /*
        
    */

    public static int knapsackSolver(int W,Item[] arr){
        int n = arr.length;
        int[][] dp = new int[n+1][W+1];
        for(int i =1;i<=n;i++){
            for(int j =0;j<=W;j++){
                if(j < arr[i-1].weight) dp[i][j]=dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-arr[i-1].weight]+arr[i-1].value);
                }
            }

        }
        return dp[n][W];
    }
}