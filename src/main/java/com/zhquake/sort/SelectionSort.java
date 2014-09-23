package com.zhquake.sort;

import java.util.Arrays;

public class SelectionSort {

    public static <E extends Comparable<? super E>> void sort(E[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int index = i; index < array.length; index++) {
                if (array[index].compareTo(array[min]) < 0) {
                    min = index;
                }
            }
            if (min != i) {
                E tem = array[i];
                array[i] = array[min];
                array[min] = tem;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[] {
                123, 34, 6, 234, 6, 23, 1234 };
        SelectionSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
