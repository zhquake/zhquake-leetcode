package com.zhquake.sort;

import java.util.Arrays;

public class MergeSort<E extends Comparable<? super E>> {

    public void sort(E[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(E[] array, int begin, int end) {
        if (end > begin) {
            int center = (begin + end) / 2;
            mergeSort(array, begin, center);
            mergeSort(array, center + 1, end);
            merge(array, begin, center, end);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(E[] array, int begin, int center, int end) {
        // cannot create a generic array
        E[] tem = (E[]) new Comparable[end - begin + 1];
        int temindex = 0;
        int i = begin;
        int j = center + 1;
        while (i <= center && j <= end) {
            if (array[i].compareTo(array[j]) <= 0) {
                tem[temindex++] = array[i++];
            } else {
                tem[temindex++] = array[j++];
            }
        }

        while (i <= center) {
            tem[temindex++] = array[i++];
        }

        while (j <= end) {
            tem[temindex++] = array[j++];
        }

        for (temindex = begin; temindex <= end; temindex++) {
            array[temindex] = tem[temindex - begin];
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[] {
                554, 123, 6, 1231, 77, 2, 23 };
        MergeSort<Integer> sort = new MergeSort<Integer>();
        sort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
