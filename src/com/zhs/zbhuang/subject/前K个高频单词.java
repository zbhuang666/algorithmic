package com.zhs.zbhuang.subject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class 前K个高频单词 {

    public static List<String> topKFrequent(String[] words, int k) {
        return Arrays.asList(words).stream().
                collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
                entrySet().stream().sorted((o1, o2) -> {
                    if(o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }
        }).map(Map.Entry::getKey).limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 4;
        List<String> strings = topKFrequent(words, k);
        for (String str:strings) {
            System.out.println(str);
        }
    }
}
