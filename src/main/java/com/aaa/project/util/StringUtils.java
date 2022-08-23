package com.aaa.project.util;

/**
 * @Author:江Sir
 * @Date:23 2022/08/23 17:53
 * @description: Exercise
 * @Version 1.0.0
 */
public class StringUtils {
    public static boolean isEmpty(String str){
        return str==null || "".equals(str);
    }
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
