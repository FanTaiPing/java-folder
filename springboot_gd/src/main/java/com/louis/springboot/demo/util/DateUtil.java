package com.louis.springboot.demo.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * @author zx
 * @Company ydtf
 * @date 2020/4/17 9:58
 */
public class DateUtil {

    public static Timestamp getCurrentDateTime(){
        Timestamp time= new Timestamp(System.currentTimeMillis());//获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = df.format(time);
        time = Timestamp.valueOf(timeStr);
//        System.out.println(time);//2017-05-06 15:54:21.0
        return time;
    }


    public static  void main(String ar[]){

        DateUtil.getCurrentDateTime();
    }

}
