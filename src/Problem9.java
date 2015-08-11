import Question18_9.MaxHeapComparator;
import Question18_9.MinHeapComparator;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by dongweij on 2015/8/11.
 */
public class Problem9 {
    public static class maxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > o2) {
                return 1;
            }
            else if(o1 < o2) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    public static class minHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1 > o2) {
                return -1;
            }
            else if(o1 < o2) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static void addNewNumberAndPrintMedian(int n, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        //Should insert in maxHeap
        if(maxHeap.size() == minHeap.size()) {
            //If n doesn't belong to maxHeap cuz of number comparsion
            if(!minHeap.isEmpty() && n > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(n);
            }
            else {
                maxHeap.offer(n);
            }
        }
        //Should insert in minHeap
        else {
            if(n < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(n);
            }
            else {
                minHeap.offer(n);
            }
        }
        if(maxHeap.size() == minHeap.size()) {
            System.out.println("The medium is: " + ((double)(maxHeap.peek() + minHeap.peek()) / 2));
        }
        else {
            System.out.println("The medium is: " + maxHeap.peek());
        }
    }

    //The general idea is to use two heaps, sizeof maxheap is always greater than sizeof minheap but
    //the values in maxheap is always smaller than values in minheap
    public static void main(String args[]) {
        int arraySize = 10;
        int range = 7;

        MaxHeapComparator maxHeapComparator = new MaxHeapComparator();
        MinHeapComparator minHeapComparator = new MinHeapComparator();
        PriorityQueue<Integer>maxHeap = new PriorityQueue<Integer>(arraySize - arraySize/2, maxHeapComparator);
        PriorityQueue<Integer>minHeap = new PriorityQueue<Integer>(arraySize/2, minHeapComparator);

        for(int i = 0; i < arraySize; i++) {
            int randomNumber = (int) (Math.random( ) * (range+1));
            System.out.println("The number is " + randomNumber);
            addNewNumberAndPrintMedian(randomNumber, maxHeap, minHeap);
        }
    }
}
