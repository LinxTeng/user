package com.hoho.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ZipUtils {
    private static final Logger logger = LoggerFactory.getLogger(ZipUtils.class);

    public static boolean doZip(String filesDirPath, String zipFilePath, String zipFileName) {
        ZipOutputStream out = null;
        File zipFile = new File(zipFilePath);
        try {
            if (!zipFile.isDirectory()) {
                zipFile.mkdirs();
            }
            out = new ZipOutputStream(new FileOutputStream(zipFilePath + zipFileName));
            return doZip(out, new File(filesDirPath), "");
        } catch (Exception e) {
            logger.error("文件压缩失败", e);
            return false;
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                logger.error("文件压缩失败", e);
                return false;
            }
        }
    }

    private static boolean doZip(ZipOutputStream out, File file, String base) {
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                out.putNextEntry(new ZipEntry(base + "/"));
                base = base.length() == 0 ? "" : base + "/";
                for (int i = 0; i < files.length; i++) {
                    if (files[i].getName().contains(".zip")) {// 排除自己
                        continue;
                    }
                    doZip(out, files[i], base + files[i].getName());
                }
            } else {
                out.putNextEntry(new ZipEntry(base));
                FileInputStream in = new FileInputStream(file);
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
                in.close();
            }
            return true;
        } catch (Exception e) {
            logger.error("文件压缩失败", e);
            return false;
        }
    }
}
