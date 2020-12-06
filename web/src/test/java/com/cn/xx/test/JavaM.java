package com.cn.xx.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaM {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 0));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, -5, 0));
        System.out.println(list2 .containsAll(list1));
    }
}
