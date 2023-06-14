package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 练习拉姆达表达式
 */

public class ExerciseOne {

    /**
     * 获取数据方法
     *
     * @return
     */
    public List<Map<String, Object>> getList(int a, int b, int c) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        map1.put(String.valueOf(a), "111");
        map2.put(String.valueOf(b), "222");
        map3.put(String.valueOf(c), "333");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        return list;
    }

    public static void main(String[] args) {

        ExerciseOne exerciseOne2 = new ExerciseOne();

        ExerciseOne exerciseOne1 = new ExerciseOne();
        List<Map<String, Object>> list = exerciseOne1.getList(1, 2, 3);

        list.forEach(x -> {
            x.forEach((k, y) -> {
                System.out.println("key：" + k + " value：" + y);
            });
        });

    }
}
