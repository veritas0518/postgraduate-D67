package Day33;

import org.junit.Test;

import java.util.Date;

/**
 * @ClassName: DateTimeTest
 * @Description: String中的Date方法
 * @Author: TianXing.Xue
 * @Date: 2021/7/29 14:44
 * @Version: 1.0
 *
 *      java.util.Date类
 *          |---java.sql.Date类
 *
 *      1.两个构造器的使用
 *
 *      2.两个方法的使用
 *          >toString():显示当前的年、月、日、时、分、秒
 *          >getTime():获取当前Date对象对应的毫秒数。（时间戳）
 *
 *      3.java.sql.Date对应着数据库中的日期类型的变量
 *          >如何实例化
 *          >如何将 java.util.Date 对象转化为 java.sql.Date 对象
 **/
public class DateTimeTest {
    //1.System类中的currentTimeMillis()
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

    @Test
    public void test2() {
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());

        System.out.println(date1.getTime()); //毫秒数

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(974975665444L);
        System.out.println(date2);

        java.sql.Date date3 = new java.sql.Date(43748384743L);
        System.out.println(date3);

        //如何将 util.Date.java 对象转化为 sql.Date.java 对象
//        Date date = new java.util.Date(2838393813333L);
//        java.sql.Date date4 = (java.sql.Date) date;

        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }
}
