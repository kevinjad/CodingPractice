class Subarray{
    int[] base;
    int start;
    int end;
    int size;
    public static Subarray fromArray(int[] arr){
        Subarray sa = new Subarray();
        sa.base=arr;
        sa.start=0;
        sa.size = arr.length;
        return sa;
    }
    // returns subarray with i inclusive and j exclusive
    public Subarray subarray(int i, int j){
        if(i>j) throw new IllegalArgumentException();
        if(j>this.size) throw new IndexOutOfBoundsException();
        Subarray sa = new Subarray();
        sa.base = this.base;
        sa.start = this.start+i;
        sa.size=j-i;
        return sa;
    }
    public float getMedian(){
        float m;
        if(this.size %2 == 0){
            m = (float) (((float) this.base[this.start + (this.size / 2) - 1]
                    + (float) this.base[this.start + (this.size / 2)]) / 2.);
        }
        else{
            m = (float) this.base[this.start + (this.size/2)];
        }
        return m;
    }
    public int getFirst(){
        return this.base[this.start];
    }
    public int getLast(){
        return this.base[this.start+this.size-1];
    }
}

public class MedianOptimized{
    public static float median(int[] arr1, int[] arr2){
        if(arr1.length == 0 || arr1.length != arr2.length) throw new IllegalArgumentException();
        return median(Subarray.fromArray(arr1), Subarray.fromArray(arr2));
    }
    public static float median(Subarray s1, Subarray s2){
        if(s1.size == 1){
            return (float)( ((float)s1.getFirst() + (float)s2.getFirst())/2.);
        }
        else if(s1.size == 2){
            return (float) ((Math.max(s1.getFirst(), s2.getFirst()) + Math.min(s1.getLast(), s2.getLast())) / 2.);
        }
        else{
            float s1median = s1.getMedian();
            float s2median = s2.getMedian();
            if(s1median > s2median){
                return median(s1.subarray(0, s1.size/2 +1), s2.subarray((s2.size-1)/2, s2.size));
            }
            else if(s1median < s2median){
                return median(s1.subarray((s1.size-1)/2, s1.size), s2.subarray(0, s2.size/2 +1));
            }
            return s1median;
        }
    }
    public static void main(String[] args){
        int[] arr1 = {1,3,5};
        int[] arr2 = {2,4,6};
        System.out.println(median(arr1, arr2));
    }
}