package FindDuplicates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
public class FindDups {
    public static void main(String[] args){
        int[] arr = {2,1,2,1};
        System.out.println(Dups(arr));

    }
    public static List<Integer> Dups(int[] arr){
        int n = arr.length;
        Set<Integer> l = new HashSet<Integer>();
        int[] table =  new int[n+1]; 
        for(int x : arr){
                if(table[x] != 0) l.add(x);
                else{
                    table[x]++;
                }
        }
        return new ArrayList<Integer>(l);
    }
}