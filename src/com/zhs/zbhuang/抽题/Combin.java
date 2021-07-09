package com.zhs.zbhuang.抽题;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combin {
    // 集合中所有子集组合
    private static List<List<BigDecimal>> COMBINATION_SET = new ArrayList<>();
    /**
     * 用递归获取所有子集组合
     *
     * @param selector 选完的组合，初始化为空
     * @param oddsSet  待选组合
     * @param n        子集组合大小
     */
    private static void combination(List<BigDecimal> selector, List<BigDecimal> oddsSet, int n) {

        if (n == 0) {
            List<BigDecimal> tmp = new ArrayList<>();
            for (BigDecimal i : selector) {
                tmp.add(i);
            }
            COMBINATION_SET.add(tmp);
            return;
        }

        if (oddsSet.isEmpty()) {
            return;
        }

        // 选择第一个元素,将元素放入集合
        selector.add(oddsSet.get(0));
        // 从第二个元素开始选择，再选择两个
        combination(selector, oddsSet.subList(1, oddsSet.size()), n - 1);

        // 不选择第一个元素
        selector.remove(selector.size() - 1);
        // 从第二个元素开始选择，选择两个
        combination(selector, oddsSet.subList(1, oddsSet.size()), n);
    }

    public static void main(String[] args) {
        List<BigDecimal> selector = new ArrayList<>();
        combination(selector,new ArrayList<BigDecimal>(Arrays.asList(new BigDecimal("1"),new BigDecimal("2"),new BigDecimal("3"),new BigDecimal("4"))), 3);
        System.out.println(COMBINATION_SET);
    }

}
