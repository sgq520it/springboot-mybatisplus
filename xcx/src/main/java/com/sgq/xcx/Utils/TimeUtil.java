package com.sgq.xcx.Utils;

public class TimeUtil {
    public static  String changeTime(Integer integer){
        String str = "";
        if(integer<60){
            str = integer+"分钟前";
        }else if(integer>=60 && integer<60*24){
         //小时
            str = integer/60+"小时前";
        }else if(integer>=60*24 && integer<60*24*7){
         //天
            str = integer/(60*24)+"天前";
        }else if(integer>=60*24*7 && integer<60*24*30){
         //周
            str = integer/(60*24*7)+"周前";
        }else if(integer>=60*24*30){
            //月
            str = integer/(60*24*30)+"月前";
        }
        return str;
    }
}
