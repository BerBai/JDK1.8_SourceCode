package com.ber.learn.arrayList.test;

import com.ber.learn.arrayList.model.User;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;

/**
 * @author: ber
 * @date: 2022/7/4 0004 11:19
 * -------------------------------
 * Github：https://github.com/berbai
 * Blog：https://blog.csdn.net/Ber_Bai
 */
public class Serializable {

    static class SerTest01 {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            // 测试序列化写入文件
            writeObject();
            // 测试反序列化文件读取
            readObject();
        }

        // 将对象数据写入文件
        private static void writeObject() throws IOException {
            // 序列化：将对象的数据写入到文件(写对象)
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testoutfile\\obj.txt"));
            User user = new User("李四", 78);
            // 将对象数据写入文件
            oos.writeObject(user);
            // 关闭流
            oos.close();
        }

        // 将对象数据写入文件
        private static void readObject() throws IOException, ClassNotFoundException {
            // 反序列化：将文件中对象的数据读取出来(读对象)
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testoutfile\\obj.txt"));
            User user = (User) ois.readObject();
            // 将对象数据写入文件
            System.out.println(user.toString());
            // 关闭流
            ois.close();
        }
    }

    public static void main(String[] args) throws Exception {
        // 对象操作流 --> 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testoutfile\\obj.txt"));
        oos.writeObject(new String("ces"));

        // 对象输入流 --> 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testoutfile\\obj.txt"));
        System.out.println((String) ois.readObject());

        // 创建用户对象集合
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("李四", 78));
        list.add(new User("张三", 28));
        // 将集合写入到文件
        oos.writeObject(list);
        oos.close();

        // 读取数据
        Object o = ois.readObject();
        ois.close();
        // 向下转型
        ArrayList<User> al = (ArrayList<User>) o;

        // stream流遍历 Lambda
        al.stream().forEach((user -> System.out.println(user)));
        // 方法引用
        al.stream().forEach(System.out::println);
    }
}