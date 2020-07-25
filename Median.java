import java.util.*;

public class Median{
    public static void main(String[] args){
        int[] arr = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        float median = medianOfTwoArray(arr,arr2);
        System.out.println(median);
    }

    public static float medianOfTwoArray(int[] a, int[] b){
        int n = a.length + b.length;
        List<Integer> ansHelp = new ArrayList<Integer>();
        int i =0,j=0;
        float val;
        while(i<a.length && j<b.length){
            if(a[i] <= b[j]){
                ansHelp.add(a[i]);
                i++;
            }
            else if(a[i] > b[j]){
                ansHelp.add(b[j]);
                j++;
            }
        }
        if(i == a.length){
            while(j < b.length){
                ansHelp.add(b[j]);
                j++;
            }
        }
        else if(j==b.length){
            while(i < a.length){
                ansHelp.add(a[i]);
                i++;
            }
        }
        val = (float) ansHelp.get((n-1)/2) + (float) ansHelp.get(n/2);
        val = val/2;
        System.out.println(ansHelp);
        return val;
    }
}