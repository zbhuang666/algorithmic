package com.zhs.zbhuang.抽题;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

public class Combination {
//    public static <T> List<List<T>> combinations(List<T> list, int k) {
//        if (k == 0 || list.isEmpty()) {//去除K大于list.size的情况。即取出长度不足K时清除此list
//            return Collections.emptyList();
//        }
//        if (k == 1) {//递归调用最后分成的都是1个1个的，从这里面取出元素
//            return list.stream().map(e -> Stream.of(e).collect(toList())).collect(toList());
//        }
//        Map<Boolean, List<T>> headAndTail = split(list, 1);
//        List<T> head = headAndTail.get(true);
//        List<T> tail = headAndTail.get(false);
//        List<List<T>> c1 = combinations(tail, (k - 1)).stream().map(e -> {
//            List<T> l = new ArrayList<>();
//            l.addAll(head);
//            l.addAll(e);
//            return l;
//        }).collect(Collectors.toList());
//        List<List<T>> c2 = combinations(tail, k);
//        c1.addAll(c2);
//        return c1;
//    }
//
//    /**
//     *根据n将集合分成两组
//     **/
//    public static <T> Map<Boolean, List<T>> split(List<T> list, int n) {
//        return IntStream
//                .range(0, list.size())
//                .mapToObj(i -> new SimpleEntry<>(i, list.get(i)))
//                .collect(partitioningBy(entry -> entry.getKey() < n, mapping(SimpleEntry::getValue, toList())));
//    }
//
//    public static void main(String[] args) {
//        List<String> input = Stream.of("a", "b", "c").collect(toList());
//        List<List<String>> combinations = Combination.combinations(input, 2);
//        System.out.println("2-->"+combinations.toString());
//    }


}
