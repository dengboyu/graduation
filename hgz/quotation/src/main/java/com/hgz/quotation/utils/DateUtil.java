package com.hgz.quotation.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期一些的工具类
 * Created by by@Deng on 2017/7/11.
 */
public class DateUtil {

    /**
     * 把某段时间转为每一天时间
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<Date> getDates(Date dBegin,Date dEnd){
        List<Date> dateList = new ArrayList();
        dateList.add(dBegin);

        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            dateList.add(calBegin.getTime());
        }
        return dateList;
    }


    /**
     * 获取某一时间段特定星期几的日期
     * @param dateFrom 开始时间
     * @param dateEnd 结束时间
     * @param weekDays "一,三,日(天)"
     * @return 返回时间集合
     */
    public static List<Date> getDates(String dateFrom, String dateEnd, String weekDays) {
        long time = 1l;
        long perDayMilSec = 24 * 60 * 60 * 1000;
        List<Date> dateList = new ArrayList<Date>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //需要查询的星期系数
        String strWeekNumber = weekForNum(weekDays);
        try {
            dateFrom = sdf.format(sdf.parse(dateFrom).getTime() - perDayMilSec);
            time = sdf.parse(dateFrom).getTime();
            while (time<sdf.parse(dateEnd).getTime()) {
                time = time + perDayMilSec;
                Date date = new Date(time);
                if (dateFrom.compareTo(dateEnd) <= 0) {
                    //查询的某一时间的星期系数
                    Integer weekDay = dayForWeek(date);
                    //判断当期日期的星期系数是否是需要查询的
                    if (strWeekNumber.indexOf(weekDay.toString())!=-1) {
                        dateList.add(date);
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateList;
    }


    /**
     * 拼接星期对应的数字
     * @author by@Deng
     * @date 2017/8/29 上午1:08
     */
    public static String weekForNum(String weekDays){
        String weekNumber = "";
        if(StringUtils.isNotEmpty(weekDays)){
            String[] strWeeks = weekDays.split(",");
            for (int i = 0; i < strWeeks.length; i++) {
                weekNumber = weekNumber + "" + getWeekNum(strWeeks[i]).toString();
            }
        }

        return weekNumber;
    }

    /**
     * 将星期转换为对应的系数  星期日(天)：1，星期一：2，星期二：3，星期三：4，星期四：5，星期五：6，星期六：7
     * @author by@Deng
     * @date 2017/8/29 上午1:01
     */
    public static Integer getWeekNum(String strWeek){
        Integer number = 1;//默认为星期日
        if("日".equals(strWeek)){
            number = 1;
        }else if("一".equals(strWeek)){
            number = 2;
        }else if("二".equals(strWeek)){
            number = 3;
        }else if("三".equals(strWeek)){
            number = 4;
        }else if("四".equals(strWeek)){
            number = 5;
        }else if("五".equals(strWeek)){
            number = 6;
        }else if("六".equals(strWeek)){
            number = 7;
        }
        return number;
    }

    /**
     * 得到date时间的周系数。星期日：1，星期一：2，星期二：3，星期三：4，星期四：5，星期五：6，星期六：7
     * @author by@Deng
     * @date 2017/8/29 上午1:00
     */
    public static Integer dayForWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

}
