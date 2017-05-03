package com.bishe.yuanye.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by yuanye on 2017/4/28.
 *
 * @author yuanye
 * @date 2017/04/28
 */
public class CommonUtil {

    public static boolean isRightPictureFormat(String fileName) {

        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png") || fileName.endsWith(
            "bmp")) {
            return true;
        } else {
            return false;
        }
    }

    public static String getNewRandomName(String oldFileName) {

        String num = System.currentTimeMillis() + "";
        int index = oldFileName.lastIndexOf(".");
        String format = oldFileName.substring(index, oldFileName.length());
        return num + format;
    }

    public static String formatDateToString(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static String handleQuestionText(String questionText) {
        return "";
    }
}
