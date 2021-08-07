package Day33;

import org.junit.Test;

/**
 * @ClassName: StringBufferBuilderTest
 * @Description: 关于StringBuffer 和 StringBuilder的使用
 * @Author: TianXing.Xue
 * @Date: 2021/7/29 12:49
 * @Version: 1.0
 *
 *    1.String、StringBuffer、StringBuilder三者的异同
 *    String：不可变的字符序列；底层使用char[]进行存储
 *    StringBuffer：可变的字符序列；线程安全的，效率偏；低底层使用char[]进行存储
 *    StringBuilder：可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]进行存储
 *
 *    2.对比String、StringBuffer、StringBuilder三者的效率：
 *    从高到底排列：StringBuilder > StringBuffer > String
 *
 *    3.源码分析：
 *    String str = new String();  //char[] value = new char[0]
 *    String str1 = new String("abc"); //char[] value = new char[]{'a','b','c'};
 *
 *    StringBuffer sb1 = new StringBuffer();  //char[] value = new char[16];底层创建了一个长度是16的数组
 *    sb1.append('a'); // value[0] = 'a';
 *    sb1.append('b'); // value[1] = 'b';
 *
 *    StringBuffer sb2 = new StringBuffer("abc");  //char[] value = new char["abc".length() + 16];
 *
 *    4.问题1：扩容问题：如果要添加的数据底层数组盛不了，那就需要扩容底层的数组
 *          默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中
 *
 *          指导意义：开发中建议使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)
 *
 *    5.总结：
 *     增：append(xxx)
 *     删：delete(int start,int end)
 *     改：setCharAt(int n,char ch) / replace(int start, int end,String str)
 *     查：charAt(int n)
 *     插：insert(int offset, xxx)
 *     长度：length()
 *     遍历：for + charAt()
 *
 **/

public class StringBufferBuilderTest {
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb2.length());  //3
    }

    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);  //abc11
//        s1.delete(2,4);
//        System.out.println(s1);  //ab1
//        s1.replace(2,4,"hello");
        s1.insert(2, false);  //10
        s1.reverse();
        String s2 = s1.substring(1, 3);

        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s2);
        s1.setCharAt(0, 'z');
        System.out.println(s1);
    }
}
