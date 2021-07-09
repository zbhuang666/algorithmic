package com.zhs.zbhuang.抽题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectQuestions {
    private static ArrayList<Integer> store = new ArrayList<>();

    /**
     * 排列
     * 按照无序（随机）的方式取出元素，就是排列,元素个数[A arr.len 3]
     * @param k 选取的元素个数
     * @param questionList 数组
     */
    public static void arrangement(int k,List<Integer> questionList, List<List<Integer>> resultList){
        if(k == 1){
            for (int i = 0; i < questionList.size(); i++) {
                store.add(questionList.get(i));
                ArrayList<Integer> clone = (ArrayList<Integer>) store.clone();
                resultList.add(clone);
                store.remove(questionList.get(i));
            }
        }else if(k > 1){
            for (int i = 0; i < questionList.size(); i++) { //按顺序挑选一个元素
                store.add(questionList.get(i)); //添加选到的元素
                arrangement(k - 1, removeArrayElements(questionList, store.toArray(new Integer[1])), resultList); //没有取过的元素，继续挑选
                store.remove(questionList.get(i));
            }
        }
    }

    /**
     * 移除数组某些元素（不影响原数组）
     * @param questionList 数组
     * @param elements 待移除的元素
     * @return 剩余元素组成的新数组
     */
    public static List<Integer> removeArrayElements(List<Integer> questionList, Integer... elements){
        List<Integer> remainList = new ArrayList<>(questionList.size());
        for(int i=0;i<questionList.size();i++){
            boolean find = false;
            for(int j=0;j<elements.length;j++){
                if(questionList.get(i) == elements[j]){
                    find = true;
                    break;
                }
            }
            if(!find){ //没有找到的元素保留下来
                remainList.add(questionList.get(i));
            }
        }
        List<Integer> remainArray = new ArrayList<>(remainList.size());
        for(int i=0;i<remainList.size();i++){
            remainArray.add(i, remainList.get(i));
        }
        return remainArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        int k = 3;
        System.out.println("组合结果：");
        List<List<Integer>> resultList = new ArrayList<>();
        arrangement(k, list, resultList);
        resultList.stream().forEach(r -> System.out.println(r));
    }
}
