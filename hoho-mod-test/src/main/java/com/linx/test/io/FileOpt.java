package com.linx.test.io;

import java.io.*;

public class FileOpt {
    public static void main(String[] args) throws Exception {
        String path="src/main/resources/property/format.properties";//项目下的文件
        System.out.println(FileOpt.readFile(path,"GBK"));

        System.out.println(FileOpt.readLine(path));
    }

    /**
     * 通过字节流来读取文件
     * @param path
     * @param charset
     * @return
     * @throws Exception
     */
    public static String readFile(String path,String charset) throws Exception {
        FileInputStream inputStream=new FileInputStream(path);//按字节操作
        InputStreamReader reader=new InputStreamReader(inputStream,charset);//按字符操作
        StringBuilder stringBuilder=new StringBuilder();
        char[] buf=new char[10];//java中的字符类型。代表一次读取10个字符。char占用16个字符。因此一个char可以表示单个汉字。
        int count=0;
        try {
            while ((count = reader.read(buf)) != -1) {
                stringBuilder.append(buf, 0, count);
            }
        }finally {
            reader.close();
        }
        return stringBuilder.toString();
    }

    /**
     * 通过缓存行读取文件
     * @param path
     * @return
     * @throws Exception
     */
    public static String readLine(String path) throws Exception {
        FileReader fileReader=new FileReader(path);//使用ide默认的编码UTF-8读取文件,文件本身是GBK编码，所以会出现乱码。将文件改为UTF-8即可。
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        StringBuilder stringBuilder=new StringBuilder();
        String s=null;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s).append("\r\n");//添加一个换行符
            }
        }finally {
            bufferedReader.close();
            fileReader.close();
        }
        return stringBuilder.toString();
    }
}
