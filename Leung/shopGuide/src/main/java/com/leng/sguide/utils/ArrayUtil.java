package com.leng.sguide.utils;

import java.util.*;

/**
 * 数组工具类
 *
 * @author by@Deng
 * @create 2017-09-20 14:59
 */
public class ArrayUtil {

    /**
     * 获取两个数组相同的元素
     * @author by@Deng
     * @date 2017/9/20 下午3:03
     */
    public static Set<Integer> getSameValue(Integer[] arr1, Integer[] arr2){

        Set<Integer> same = new HashSet<>();  //用来存放两个数组中相同的元素
        Set<Integer> temp = new HashSet<>();  //用来存放数组arr1中的元素

        for (int i = 0; i < arr1.length; i++) {
            temp.add(arr1[i]);   //把数组arr1中的元素放到Set中，可以去除重复的元素
        }

        for (int j = 0; j < arr2.length; j++) {
            //把数组b中的元素添加到temp中
            if(!temp.add(arr2[j])) same.add(arr2[j]);
        }

        return same;
    }


    /**
     * 获取两个数组不相同的元素
     * @author by@Deng
     * @date 2017/9/20 下午3:03
     */
    public static <T> List<T> compare(T[] t1, T[] t2) {
        List<T> list1 = Arrays.asList(t1);
        List<T> list2 = new ArrayList<T>();
        for (T t : t2) {
            if (!list1.contains(t)) {
                list2.add(t);
            }
        }
        return list2;
    }


}
