package com.ber.learn.arrayList.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ber
 * @date: 2022/7/5 0005 16:18
 * -------------------------------
 * Github：https://github.com/berbai
 * Blog：https://blog.csdn.net/Ber_Bai
 */
public class RandomAccess {
    /**
     * 测试ArrayList随机访问比顺序访问快，这里仅对ArrayList做遍历操作
     *
     * @param args
     */
    static class RandomAccessTest01 {
        public static void main(String[] args) {
            // 创建ArrayList集合
            List<String> list = new ArrayList<>();
            // 添加50W条数据
            for (int i = 0; i < 500000; i++) {
                list.add(i + "a");
            }
            System.out.println("----通过索引(随机访问)----");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("随机访问用时: " + (endTime - startTime));


            System.out.println("----通过迭代器(顺序访问)----");
            startTime = System.currentTimeMillis();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            endTime = System.currentTimeMillis();
            System.out.println("顺序访问用时: " + (endTime - startTime));
        }
    }

    /**
     * LinkedList没有实现`RandomAccess`接口，顺序遍历比随机访问快。
     */
    static class RandomAccessTest02 {
        public static void main(String[] args) {
            // 创建ArrayList集合
            List<String> list = new LinkedList<>();
            // 添加10W条数据
            for (int i = 0; i < 100000; i++) {
                list.add(i + "a");
            }
            System.out.println("----通过索引(随机访问)----");
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("随机访问用时: " + (endTime - startTime));


            System.out.println("----通过迭代器(顺序访问)----");
            startTime = System.currentTimeMillis();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            endTime = System.currentTimeMillis();
            System.out.println("顺序访问用时: " + (endTime - startTime));
        }
    }

}
//----通过索引(随机访问)----
//随机访问用时: 11851
//----通过迭代器(顺序访问)----
//顺序访问用时: 3
