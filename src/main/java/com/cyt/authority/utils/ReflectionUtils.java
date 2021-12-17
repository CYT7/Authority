package com.cyt.authority.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Chenyt7
 * @date  2021/5/20/11:29
 * @version 1.0.0
 * @describe 反射相关辅助方法
 **/
public class ReflectionUtils {
    /**
     * 根据方法名调用指定对象的方法
     * @param object 要调用方法的对象
     * @param method 要调用的方法名
     * @param args 参数对象数组
     */
    public static Object invoke(Object object, String method, Object... args) {
        Object result = null;
        Class<?> clazz = object.getClass();
        Method queryMethod = getMethod(clazz, method, args);
        if(queryMethod != null) {
            try {
                result = queryMethod.invoke(object, args);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new NoSuchMethodException(clazz.getName() + " 类中没有找到 " + method + " 方法。");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 根据方法名和参数对象查找方法
     * @param clazz 参数对象
     * @param name 方法名
     * @param args 参数实例数据
     */
    public static Method getMethod(Class<?> clazz, String name, Object[] args) {
        Method queryMethod = null;
        Method[] methods = clazz.getMethods();
        for(Method method:methods) {
            if(method.getName().equals(name)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if(parameterTypes.length == args.length) {
                    boolean isSameMethod = true;
                    for(int i=0; i<parameterTypes.length; i++) {
                        if (!parameterTypes[i].equals(args[i].getClass())) {
                            isSameMethod = false;
                            break;
                        }
                    }
                    if(isSameMethod) {
                        queryMethod = method;
                        break ;
                    }
                }
            }
        }
        return queryMethod;
    }
}