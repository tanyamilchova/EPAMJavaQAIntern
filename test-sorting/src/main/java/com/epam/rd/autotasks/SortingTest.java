package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SortingTest {

    Sorting sorting = new Sorting();

    @Test
    public void testNullCase() {
        assertThrows(IllegalArgumentException.class,()->sorting.sort(null));
    }

    @Test
    public void testEmptyCase() {
        int[] emptyArray = new int[0];
        sorting.sort(emptyArray);
        assertArrayEquals(new int[0], emptyArray);
    }

    @Test
    public void testSingleElementArrayCase() {
        int[]arr={5};
        sorting.sort(arr);
        int[]expected={5};
        assertArrayEquals(expected,arr);
    }

    @Test
    public void testSortedArraysCase() {
        int[]arr={1,4,7,8,10};
        sorting.sort(arr);
        int[]expected={1,4,7,8,10};
        assertArrayEquals(expected,arr);
    }

    @Test
    public void testOtherCases() {
        int[]arr={2,-10,0,5};
        sorting.sort(arr);
        int[]expected={-10,0,2,5};
        assertArrayEquals(expected,arr);
    }
}