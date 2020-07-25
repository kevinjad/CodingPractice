//import java.util.concurrent.TimeUnit;

class Item{
    int value;
    int weight;
    Item(int value, int weight){
        this.value= value;
        this.weight = weight;
    }
}

public class knapsackBasic {
    public static void main(String[] args){
        long startTime = System.nanoTime();
        Item[] arr = {new Item(6, 1),new Item(10, 2),new Item(12, 3)};

        System.out.println(knapsackSolver(5, arr));
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime)/1000);
        System.out.print(" us");
    }

    public static int knapsackSolver(int W,Item[] arr){
        int n = arr.length;
        int[][] dp = new int[W+1][n+1]; 
        return knapsackSolver(W, arr,0,dp);
    }

    public static int knapsackSolver(int W, Item[] arr,int index,int[][] dp){
        if(index >= arr.length) return 0;
        if(W <= 0) return 0;
        else if(W-arr[index].weight < 0) {
            if(dp[W][index] != 0){
                return dp[W][index];
            }
            dp[W][index] = knapsackSolver(W, arr, index+1,dp);
            return dp[W][index];
        }
        else{
            if(dp[W][index] != 0){
                return dp[W][index];
            }
            dp[W][index] = Math.max(knapsackSolver(W-arr[index].weight, arr, index+1,dp)+arr[index].value,knapsackSolver(W, arr, index+1,dp));
            return dp[W][index];
        }
    }
}