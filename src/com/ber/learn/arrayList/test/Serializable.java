package com.ber.learn.arrayList.test;

import com.ber.learn.arrayList.model.User;

import java.io.*;
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
            writeObject();
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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("..\\obj.txt"));
            User user = (User) ois.readObject();
            // 将对象数据写入文件
            System.out.println(user.toString());
            // 关闭流
            ois.close();
        }
    }

    public static void main(String[] args) throws Exception {
        User s = new User();
        System.out.println(s);
        //创建对象操作流 --> 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MyTest\\obj.txt"));
        //创建集合,且添加学生对象
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("悔创阿里杰克马", 51));
        list.add(new User("会点一点长几颗", 26));
        list.add(new User("容颜老去蒋青青", 32));
        list.add(new User("将里最丑刘一飞", 27));
        //将集合写入到文件
        oos.writeObject(list);
        //创建对象输入流 --> 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MyTest\\obj.txt"));
        //读取数据
        Object o = ois.readObject();
        //向下转型
        ArrayList<User> al = (ArrayList<User>) o;
        //遍历集合
        for (int i = 0; i < al.size(); i++) {
            //根据索引取出集合的每一个元素
            User stu = al.get(i);
            System.out.println(stu);
        }
    }
}