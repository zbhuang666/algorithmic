package com.zhs.zbhuang.abing;

import java.util.*;

public class 三门问题 {

    public static void main(String[] args) {
        chooseTheDoor2(1000000000, false);
        chooseTheDoor2(1000000000 , true);
    }

    /**
     * @param total    测试次数
     * @param isChange 是否换门
     */
    public static void chooseTheDoor(final int total, final boolean isChange) {
        //正确计数
        int rightCount = 0;
        //定义一个伪随机数组0是正确,1是错误
        String[] door = new String[]{"011", "101", "110"};
        for (int i = 0; i < total; i++) {
            //生成一个长度为3的数组,模拟3门
            String[] d = door[new Random().nextInt(3)].split("");
            int[] doors = {Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2])};
            //模拟选中一个门,记录下标
            int selected = new Random().nextInt(3);
            //模拟在未选择的两个门中,选择其中一个错误的排除
            int exclude = 0;
            for (int x = 0; x < doors.length; x++) {
                if (x != selected) {
                    if (doors[x] == 1) {
                        exclude = x;
                        break;
                    }
                }
            }
            //selected+exclude+canChange=3 算出可以换的门的下标
            int canChange = 3 - exclude - selected;
            //结果
            if (doors[isChange ? canChange : selected] == 0 ? true : false) {
                rightCount++;
            }
        }
        System.out.println(String.format("是否换门:%s,总数:%d,正确次数:%d,正确率:%s", isChange == true ? "是" : "否", total, rightCount, rightCount / (total * 1.0d)));
    }


    /**
     * @param total    测试次数
     * @param isChange 是否换门
     */
    public static void chooseTheDoor1(final int total, final boolean isChange) {
        int count = 0;
        //定义一个猜数副本
        int[] guess = new int[]{0, 0, 0};
        int len = guess.length;
        //定义生们
        int index = new Random().nextInt(3);
        guess[index] = 1;
        for (int i = 0; i <= total; i++) {
            //初始选择索引
            int selected = new Random().nextInt(3);
            //随机排除一个恶魔
            int random = 0;
            for (; ; ) {
                random = new Random().nextInt(3);
                if (guess[random] == 0) {
                    break;
                }
            }
            int numMoved = len - random - 1;
            int[] newGuess = new int[2];
            int[] guessClone = guess.clone();
            if (numMoved > 0)
                System.arraycopy(guessClone, random + 1, guessClone, random, numMoved);
            System.arraycopy(guessClone, 0, newGuess, 0, newGuess.length);
            int newSelected = new Random().nextInt(2);
            if (isChange) {
                if(newGuess[newSelected] == 1)
                    count++;
            } else {
                if(guess[selected] == 1)
                    count++;
            }
        }
        System.out.println("isChange:" + isChange + "count:" + count);
    }


    /**
     * @param total    测试次数
     * @param isChange 是否换门
     */
    public static void chooseTheDoor2(final int total, final boolean isChange) {
        int count = 0;
        //定义一个猜数副本
        int[] guess = new int[]{0, 0, 0};
        int len = guess.length;
        //定义生们
        int index = new Random().nextInt(3);
        guess[index] = 1;
        for (int i = 0; i <= total; i++) {
            //初始选择索引
            int selected = new Random().nextInt(3);
            //随机排除一个恶魔
            int random = 0;
            for(int j = 0;j<len;j++) {
                if(j != selected && guess[j] == 0) {
                    random = j;
                    break;
                }
            }
            int numMoved = len - random - selected;
            if(guess[isChange ? numMoved : selected] == 1) {
                count++;
            }
        }
        System.out.println(String.format("是否换门:%s,总数:%d,正确次数:%d,正确率:%s", isChange == true ? "是" : "否", total, count, count / (total * 1.0d)));
    }
}
