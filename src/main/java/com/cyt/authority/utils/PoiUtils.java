package com.cyt.authority.utils;

import org.apache.poi.ss.usermodel.Workbook;
import java.io.*;

/**
 * @author Chenyt7
 * @Time 2021/5/20/11:26
 * @version：1.0.0
 * @describe: POI相关操作
 **/
public class PoiUtils {
    //生成Excel文件
    public static File createExcelFile(Workbook workbook, String fileName) {
        OutputStream stream = null;
        File file = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());
            workbook.write(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }
        return file;
    }
}