package com.rapis.util;

import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author siboran
 * @create 2022/2/18
 */
public final class DbUtil {

    public static String ADMIN="admin";

    public  static void addCreateInfo(Object object,String user) throws Exception {
        Class<?> clazz=object.getClass();
        Method setCreateBy=clazz.getMethod("setCreateBy",String.class);
        Method setCreateTime=clazz.getMethod("setCreateTime", Date.class);
        Method setUpdateBy=clazz.getMethod("setUpdateBy",String.class);
        Method setUpdateTime=clazz.getMethod("setUpdateTime", Date.class);
        setCreateBy.invoke(object,user);
        setCreateTime.invoke(object,CommonUtil.getCurrTime());
        setUpdateBy.invoke(object,user);
        setUpdateTime.invoke(object,CommonUtil.getCurrTime());
    }
    public static void addUpdateInfo(Object object,String user) throws Exception {
        Class<?> clazz=object.getClass();
        Method setUpdateBy=clazz.getMethod("setUpdateBy",String.class);
        Method setUpdateTime=clazz.getMethod("setUpdateTime", Date.class);
        setUpdateBy.invoke(object,user);
        setUpdateTime.invoke(object,CommonUtil.getCurrTime());
    }
}
