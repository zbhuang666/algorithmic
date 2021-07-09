package com.zhs.zbhuang.subject;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        System.out.println(list.stream().allMatch(i -> i==2));
    }
}
