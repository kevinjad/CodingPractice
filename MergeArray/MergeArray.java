package MergeArray;
import java.util.*;

class Node{
    int val;
    int index;
    int arrNo;
    Node(int val, int index, int arrNo){
        this.val = val;
        this.index = index;
        this.arrNo = arrNo;
    }

    public String toString(){
        return "value: "+val+" index "+index+" array no: "+arrNo;
    }
}

class MyComparator implements Comparator<Node>{
    @Override
    public int compare(Node n, Node m){
        return n.val < m.val ? -1 : 1;
    }
}

public class MergeArray {
    public static void main(String[] args){
        LinkedList<LinkedList<Integer>> arrs = new LinkedList<LinkedList<Integer>>();
        arrs.add(new LinkedList<Integer>(List.of(1,4,7)));
        arrs.add(new LinkedList<Integer>(List.of(2,5,8)));
        arrs.add(new LinkedList<Integer>(List.of(3,6,9)));
        System.out.println(mergeKArray(arrs));
        
    }
    public static LinkedList<Integer> mergeKArray(LinkedList<LinkedList<Integer>> arrs){
        LinkedList<Integer> ans = new LinkedList<Integer>();
        TreeSet<Node> s = new TreeSet<Node>(new MyComparator());
        for(int i =0;i<arrs.size();i++){
            s.add(new Node(arrs.get(i).get(0),0,i));
            arrs.get(i).removeFirst();
        }
        int tmpIndex;
        while(!s.isEmpty()){
            ans.add(s.first().val);
            tmpIndex = s.first().arrNo;
            s.pollFirst();
            System.out.println(s);
            if(!arrs.get(tmpIndex).isEmpty()){
                s.add(new Node(arrs.get(tmpIndex).get(0),0,tmpIndex));
                arrs.get(tmpIndex).removeFirst();
            }
        }
        return ans;
    }
}