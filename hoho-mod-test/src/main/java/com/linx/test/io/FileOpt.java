package com.linx.test.io;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOpt {
    public static void main(String[] args) throws Exception {
        String path = "E:/my/my-test-project/hoho-mod-test/src/main/resources/property/bb.txt";//项目下的文件
        String path2 = "E:/my/my-test-project/hoho-mod-test/src/main/resources/property/aa.txt";//项目下的文件
        FileOpt.readLine(path, path2);
    }

    /**
     * 通过字节流来读取文件
     *
     * @param path
     * @param charset
     * @return
     * @throws Exception
     */
    public static String readFile(String path, String charset) throws Exception {
        FileInputStream inputStream = new FileInputStream(path);//按字节操作
        InputStreamReader reader = new InputStreamReader(inputStream, charset);//按字符操作
        StringBuilder stringBuilder = new StringBuilder();
        char[] buf = new char[10];//java中的字符类型。代表一次读取10个字符。char占用16个字符。因此一个char可以表示单个汉字。
        int count = 0;
        try {
            while ((count = reader.read(buf)) != -1) {
                stringBuilder.append(buf, 0, count);
            }
        } finally {
            reader.close();
        }
        return stringBuilder.toString();
    }

    /**
     * 通过缓存行读取文件
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static void readLine(String path, String path2) throws Exception {
        FileReader fileReader = new FileReader(path);//使用ide默认的编码UTF-8读取文件,文件本身是GBK编码，所以会出现乱码。将文件改为UTF-8即可。
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String s = null;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                String s2 = null;
                FileReader fileReader2 = new FileReader(path2);//使用ide默认的编码UTF-8读取文件,文件本身是GBK编码，所以会出现乱码。将文件改为UTF-8即可。
                BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
                Pattern pattern = Pattern.compile(s);
                while ((s2 = bufferedReader2.readLine()) != null) {
                    Matcher matcher = pattern.matcher(s2);
                    if (matcher.find()) {
                        System.out.println(s2);//可以使用BufferedWriter进行文件的输出
                    }
                }
            }
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
    }

    /**
     * 输出到文件中
     *
     * @param readFile
     * @param writeFile
     */
    public void writeFile(String readFile, String writeFile) {
        // 指定要读取文件的缓冲输入字节流
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(readFile));
            File file = new File(writeFile);
            // 指定要写入文件的缓冲输出字节流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            byte[] b = new byte[1024];// 用来存储每次读取到的字节数组
            int len;// 每次读取到的字节数组的长度
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);// 写入到输出流
            }
            out.close();// 关闭流
            in.close();
        } catch (Exception e) {
            //
        }
    }

    /**
     * 根据webURL获取字节流。用来进行网络文件的下载
     *
     * @param webURL
     * @return
     * @throws Exception
     */
    public byte[] readBit(String webURL) throws Exception {
        //输入流
        InputStream inputStream = null;
        byte[] cc;
        try {
            // 当作一个URL来装载文件
            URL url = new URL(webURL);
            URLConnection con = url.openConnection();
            con.setConnectTimeout(3 * 1000);
            inputStream = con.getInputStream();

            BufferedInputStream in = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = in.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0, len);
            }
            cc = byteArrayOutputStream.toByteArray();
            BASE64Encoder base64Encoder = new BASE64Encoder();//bit流转字符。使用base64转码
            String encode = base64Encoder.encode(cc);
            in.close();
        } finally {
            if (inputStream != null) {
                // 关闭输出流
                inputStream.close();
            }
        }
        return cc;
    }
}
