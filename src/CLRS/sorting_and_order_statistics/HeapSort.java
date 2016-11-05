/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLRS.sorting_and_order_statistics;

import java.util.Arrays;

/**
 * The MAX-HEAPIFY procedure, which runs in O(lg n) time, is the key to
 * maintaining the max-heap property. The BUILD-MAX-HEAP procedure, which runs
 * in linear time, produces a max-heap from an unordered input array. The
 * HEAPSORT procedure, which runs in O(n lgn) time, sorts an array in place. The
 * MAX-HEAP-INSERT, HEAP-EXTRACT-MAX, HEAP-INCREASE-KEY, and HEAP-MAXIMUM
 * procedures, which run in O(lg n) time, allow the heap data structure to
 * implement a priority queue.
 *
 * @author Poonawala
 */
public class HeapSort {

    private int heapSize;

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] array = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
//                new int[]{27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
//        hs.MaxHeapify(array, 2);
//        hs.buildMaxHeap(array);
//                new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        hs.heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Sorts the array using heap sort algorithm. The HEAPSORT procedure takes
     * time O(n lgn), since the call to BUILD-MAX-HEAP takes time O(n) and each
     * of the n - 1 calls to MAX-HEAPIFY takes time O(lg n).
     *
     * @param array input array to sort
     */
    private void heapSort(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length-1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapSize--;

            MaxHeapify(array, 0);
        }
    }

    /**
     * Constructs max heap of the input array
     *
     * @param array int[] array to build max heap
     */
    private void buildMaxHeap(int[] array) {
        heapSize = array.length;
        for (int i = (int) Math.floor((array.length - 1) / 2); i >= 0; i--) {
            MaxHeapify(array, i);
        }
    }

    /**
     * Running time of this procedure is T(n) <= T(2n/3) + Theta(1). Worst case
     * occurs when bottom level of the heap is exactly half filled.
     *
     * @param array the current heap
     * @param indexViolatingTheProperty index of the node currently violating
     * the min-heapify property
     */
    private void MinHeapify(int[] array, int indexViolatingTheProperty) {
        int r = 2 * indexViolatingTheProperty + 1 + 1;//considering 0 indexes for array
        int l = 2 * indexViolatingTheProperty + 1;//l and r formula changes here if considering 0 indexes, if indexes start from
        //1 then the value of l and r would be 1 less then in the current formula
        int smallest;
        if (l < heapSize && array[l] < array[indexViolatingTheProperty]) {
            smallest = l;
        } else {
            smallest = indexViolatingTheProperty;
        }
        if (r < heapSize && array[r] < array[smallest]) {
            smallest = r;
        }
        if (smallest != indexViolatingTheProperty) {
            int temp = array[indexViolatingTheProperty];
            array[indexViolatingTheProperty] = array[smallest];
            array[smallest] = temp;
            MaxHeapify(array, smallest);
        }
    }

    /**
     * Running time of this procedure is T(n) <= T(2n/3) + Theta(1). Worst case
     * occurs when bottom level of the heap is exactly half filled.
     *
     * @param array the current heap
     * @param indexViolatingTheProperty index of the node currently violating
     * the max-heapify property
     */
    private void MaxHeapify(int[] array, int indexViolatingTheProperty) {
        int r = 2 * indexViolatingTheProperty + 1 + 1;//considering 0 indexes for array
        int l = 2 * indexViolatingTheProperty + 1;//l and r formula changes here if considering 0 indexes, if indexes start from
        //1 then the value of l and r would be 1 less then in the current formula
        int largest;
        if (l < heapSize && array[l] > array[indexViolatingTheProperty]) {
            largest = l;
        } else {
            largest = indexViolatingTheProperty;
        }
        if (r < heapSize && array[r] > array[largest]) {
            largest = r;
        }
        if (largest != indexViolatingTheProperty) {
            int temp = array[indexViolatingTheProperty];
            array[indexViolatingTheProperty] = array[largest];
            array[largest] = temp;
            MaxHeapify(array, largest);
        }
    }

    /**
     * Finds the value of node to the left of the input node
     *
     * @param array the current heap
     * @param index index of the node
     * @return @return Returns the value of node to the left of the input node
     * or -1 if no node is present
     */
    private int left(int[] array, int index) {
        if (2 * index + 1 < array.length) {
            return array[2 * index + 1];
        } else {
            return -1;

        }
    }

    /**
     * Finds the value of node that is parent to the input node
     *
     * @param array the current heap
     * @param index index of the node
     * @return @return Returns the value of node parent to the input node or -1
     * if root node
     */
    private int parent(int[] array, int index) {
        if (index == 0) {
            return -1;
        }
        return array[(int) Math.floor((index - 1) / 2)];
    }

    /**
     * Finds the value of node to the right of the input node
     *
     * @param array the current heap
     * @param index index of the node
     * @return Returns the value of node to the right of the input node or -1 if
     * no node is present
     */
    private int right(int[] array, int index) {
        if ((2 * index + 1 + 1) < array.length) {
            return array[2 * index + 1 + 1];
        } else {
            return -1;

        }
    }
}
