package SUbArrayZero;

import java.util.*;

public class SubArrayZero {
    public static void main(String[] args){
        Integer[] a = {1,1,1,-3};
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));
        System.out.println(SubArrayZeroo(arr));
    }
    public static boolean SubArrayZeroo(ArrayList<Integer> arr){
        HashSet<Integer> s = new HashSet<Integer>();
        int count=0;
        for(int i=0;i<arr.size();i++){
            count+=arr.get(i);
            if(s.contains(count)) return true;
            if(count == 0) return true;
            s.add(count);
        }
        return false;
    } 
}