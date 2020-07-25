package Permutation;
import java.util.*;

public class Permutation {
    public static void main(String[] args){
        Integer[] arr = {1,2,3};
        LinkedList<Integer> ars = new LinkedList<Integer>(Arrays.asList(arr));
        System.out.println(permutations(ars));
    }
    public static ArrayList<LinkedList<Integer>> permutations(LinkedList<Integer> arr){
        ArrayList<LinkedList<Integer>> ans = new ArrayList<LinkedList<Integer>>();
        permutations(ans, new LinkedList<Integer>(), arr);
        return ans;
    }
    public static void permutations(ArrayList<LinkedList<Integer>> ans,LinkedList<Integer> prefix, LinkedList<Integer> suffix){
        if(suffix.isEmpty()){
            ans.add(prefix);
        }
        else{
            for(int i =0;i<suffix.size();i++){
                LinkedList<Integer> p = new LinkedList<Integer>(prefix);
                p.add(suffix.get(i));
                LinkedList<Integer> s = new LinkedList<Integer>(suffix);
                s.remove(i);
                permutations(ans, p ,s);
            }
        }
    }
}