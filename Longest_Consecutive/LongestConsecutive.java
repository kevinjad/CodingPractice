package Longest_Consecutive;
import java.util.*;
public class LongestConsecutive {
    public static void main(String[] args){
        Integer[] arr = {5,5,3,1};
        System.out.println(longestConsecutive(arr));
    }
    public static int longestConsecutive(Integer[] arr){
        Set<Integer> s = new HashSet<Integer>(Arrays.asList(arr));
        Integer count=1;
        Integer max=0;
        for(Integer x : s){
            int i =1;
            while(true){
                if(s.contains(x+i)){
                    count++;
                    i++;
                }
                else{
                    break;
                }
            }
            max = (count > max) ? count : max;
            count=1;
        }
        return max;
    }
}