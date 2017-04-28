package com.bishe.yuanye.common;

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
}
