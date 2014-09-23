package com.zhquake.sort;

import java.util.Arrays;
import java.util.Comparator;

public class InsertionSort {

    public static <E> void sort(E[] array, Comparator<? super E> comparator) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            E key = array[i];
            while (j >= 0 && comparator.compare(array[j], key) >= 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[] {
                3, 4, 1, 231, 31, 45, 66, 97 };
        InsertionSort.sort(data, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(data));
    }

}
