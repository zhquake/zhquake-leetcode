package com.zhquake.sort;

import java.util.Arrays;

public class BubbleSort {
    public static <E extends Comparable<? super E>> void sort(E[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) >= 0) {
                    E tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[] {
                123, 34, 6, 234, 6, 23, 123 };
        BubbleSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
