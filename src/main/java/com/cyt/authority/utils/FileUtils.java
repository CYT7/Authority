package com.cyt.authority.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Chenyt7
 * @Time 2021/5/20/11:28
 * @version：1.0.0
 * @describe: 文件相关操作
 **/
public class FileUtils {
    //下载文件
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
        try {
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsolutePath());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];
            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
