/**
 * Created by dongweij on 2015/8/11.
 */
public class Problem6 {
    //So the solution is using the quick sort approach, find pivot, split the array and try to reduce the problem in half
    //But I think the better approach is to use a heap. Most heap implementation guarantees O(1) insertion time and
    //O(log(n)) deletion time. So we can just insert all the keys into the heap and do 'find_max + delete_max' for
    //one million times
    public static void main(String[] args) {

    }
}
