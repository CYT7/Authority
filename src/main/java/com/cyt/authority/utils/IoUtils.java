package com.cyt.authority.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author Chenyt7
 * @date  2021/5/20/11:27
 * @version 1.0.0
 * @describe IO相关工具类
 **/
public class IoUtils {
    /**关闭对象，连接*/
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            //ignore
        }
    }
}