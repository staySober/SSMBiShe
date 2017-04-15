package com.bishe.yuanye.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuanye on 2017/2/24.
 */
public class DateConverter implements Converter<String, Date> {


    public Date convert(String source) {

        //将日期串转化成日期类型（格式是：yyyy-MM-dd HH:mm:ss）
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
