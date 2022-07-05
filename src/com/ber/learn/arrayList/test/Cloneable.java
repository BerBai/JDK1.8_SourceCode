package com.ber.learn.arrayList.test;

import com.ber.learn.arrayList.model.Address;
import com.ber.learn.arrayList.model.User;

import java.util.ArrayList;

/**
 * @author: ber
 * @date: 2022/7/4 0004 15:00
 * -------------------------------
 * Github：https://github.com/berbai
 * Blog：https://blog.csdn.net/Ber_Bai
 */
public class Cloneable {
    public static void main(String[] args) {
        // 创建用户对象集合
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("李四", 78));
        list.add(new User("张三", 28));

        Object o = list.clone();
        System.out.println(o);
        System.out.println(list);
        System.out.println(o == list);


        // 一般拷贝对象方法
        User user1 = new User("张", 12);
        User user2 = new User();

        user2.setAge(user1.getAge());
        user2.setName(user1.getName());

        System.out.println(user1 == user2);
    }

    /**
     * 普通类支持clone()
     */
    static class Cloneable01 {

        public static void main(String[] args) throws CloneNotSupportedException {
            User user1 = new User("张", 12);

            Object user2 = user1.clone();
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user1 == user2);
        }
    }

    /**
     * 浅拷贝
     */
    static class Cloneable02 {
        public static void main(String[] args) throws CloneNotSupportedException {
            Address address = new Address("北京");
            User user1 = new User("张", 12, address);

            User user2 = (User) user1.clone();
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user1 == user2);

            System.out.println(user2.getAddress() == user1.getAddress());

            address.setCity("海口");
            user1.setAddress(address);
            System.out.println(user1);
            System.out.println(user2);
        }
    }

    /**
     * 深拷贝 实现地方在User、Address类
     */
    static class Cloneable03 {
        public static void main(String[] args) throws CloneNotSupportedException {
            Address address = new Address("北京");
            User user1 = new User("张", 12, address);

            User user2 = (User) user1.clone();
            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user1 == user2);

            System.out.println(user2.getAddress() == user1.getAddress());

            address.setCity("海口");
            user1.setAddress(address);
            System.out.println(user1);
            System.out.println(user2);
        }
    }

}
