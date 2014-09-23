package com.zhquake.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort<E extends Comparable<E>> {

    public static final Random random = new Random();

    public void sort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(E[] array, int begin, int end) {
        if (end - begin >= 1) { // end > begin
            int pivot = partition(array, begin, end);
            quickSort(array, begin, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    private int partition(E[] array, int begin, int end) {
        int index = begin + random.nextInt(end - begin + 1);
        E pivot = array[index];
        swap(array, index, end);

        for (int j = index = begin; j < end; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                swap(array, index++, j);
            }
        }

        swap(array, index, end);
        return index;
    }

    private void swap(E[] array, int from, int to) {
        E tem = array[from];
        array[from] = array[to];
        array[to] = tem;
    }

    public static void main(String[] args) {
        QuickSort<Integer> s = new QuickSort<Integer>();
        Integer[] data = new Integer[] {
                120, 123, 11, 123, 34, 2, 6, 90, 22 };
        s.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
