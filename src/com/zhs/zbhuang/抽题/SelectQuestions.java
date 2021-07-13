package com.zhs.zbhuang.抽题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectQuestions {
    private static ArrayList<Question> store = new ArrayList<>();
    private static List<Question> questionList = new ArrayList<>(Arrays.asList(
            new Question(1,"1,2",1,1),
            new Question(2,"1,2",1,1),
            new Question(3,"1,2",1,1),
            new Question(4,"1,2",1,1),
            new Question(5,"1,2",1,1),
            new Question(6,"1,2",1,1),
            new Question(7,"1,2",1,2),
            new Question(8,"1,2",1,2),
            new Question(9,"1,2",1,2),
            new Question(10,"1,2",1,2),
            new Question(11,"1,2",1,2),
            new Question(12,"1,2",1,2),
            new Question(13,"1,2",1,2),
            new Question(14,"1,2",1,2),
            new Question(15,"1,2",1,2),
            new Question(16,"1,2",1,2),
            new Question(17,"1,2",1,3),
            new Question(18,"1,2",1,3),
            new Question(19,"1,2",1,3),
            new Question(20,"1,2",1,3),
            new Question(21,"1,2",2,1),
            new Question(22,"1,2",2,1),
            new Question(23,"1,2",2,1),
            new Question(24,"1,2",2,1),
            new Question(25,"1,2",2,1),
            new Question(26,"1,2",2,1),
            new Question(27,"1,2",2,2),
            new Question(28,"1,2",2,2),
            new Question(29,"1,2",2,2),
            new Question(30,"1,2",2,2),
            new Question(31,"1,2",2,2),
            new Question(32,"1,2",2,2),
            new Question(33,"1,2",2,2),
            new Question(34,"1,2",2,3),
            new Question(35,"1,2",2,3),
            new Question(36,"1,2",2,3),
            new Question(37,"1,2",2,3),
            new Question(38,"1,2",2,3),
            new Question(39,"1,2",2,3),
            new Question(40,"1,2",2,3),
            new Question(41,"1,2",3,1),
            new Question(42,"1,2",3,1),
            new Question(43,"1,2",3,1),
            new Question(44,"1,2",3,1),
            new Question(45,"1,2",3,1),
            new Question(46,"1,2",3,1),
            new Question(47,"1,2",3,1),
            new Question(48,"1,2",3,1),
            new Question(49,"1,2",3,1),
            new Question(50,"1,2",3,1),
            new Question(51,"1,2",3,1),
            new Question(52,"1,2",3,2),
            new Question(53,"1,2",3,2),
            new Question(54,"1,2",3,2),
            new Question(55,"1,2",3,2),
            new Question(56,"1,2",3,2),
            new Question(57,"1,2",3,2),
            new Question(58,"1,2",3,2),
            new Question(59,"1,2",3,3),
            new Question(60,"1,2",3,3)
    ));

    /**
     * 排列
     * 按照无序（随机）的方式取出元素，就是排列,元素个数[A arr.len 3]
     * @param k 选取的元素个数
     * @param questionList 数组
     */
    public static void selectQuestions(int k,List<Question> questionList, List<List<Question>> resultList){
        if(k == 1){
            for (int i = 0; i < questionList.size(); i++) {
                store.add(questionList.get(i));
                ArrayList<Question> clone = (ArrayList<Question>) store.clone();
                resultList.add(clone);
                store.remove(questionList.get(i));
            }
        }else if(k > 1){
            for (int i = 0; i < questionList.size(); i++) { //按顺序挑选一个元素
                store.add(questionList.get(i)); //添加选到的元素
                selectQuestions(k - 1, filterElements(questionList, questionList.get(i)), resultList); //没有取过的元素，继续挑选
                store.remove(questionList.get(i));
            }
        }
    }

    /**
     * 移除数组某些元素（不影响原数组）
     * @param questionList 数组
     * @param question 待移除的元素
     * @return 剩余元素组成的新数组
     */
    public static List<Question> filterElements(List<Question> questionList, Question question){
        return questionList.stream().filter(q -> q.getQuestionId() != question.getQuestionId()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("组合结果：");
        List<List<Question>> resultList = new ArrayList<>();
        selectQuestions(3, questionList, resultList);
        resultList.stream().forEach(r -> System.out.println(r));
        System.out.println(resultList.size());
    }
}
