package com.hoho.monitor;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class IPUtil {
    public static void main(String[] args) {
        String path = new IPUtil().getFilePathInSrcAfterRun();
        System.out.println(path);
        String filePath = path + "ipAddsess.properties";

        List<IpAddress> list = getProperties(filePath);
        for (IpAddress ipAddres : list) {
            if (isLocalPortUsing(ipAddres.getIp(), ipAddres.getPort())) {
                System.out.println("ip " + ipAddres.getIp() + "端口" + ipAddres.getPort() + "  正常");
            } else {
                System.out.println("ip " + ipAddres.getIp() + "端口 " + ipAddres.getPort() + "  失败");
            }
        }
    }

    private static List<IpAddress> getListResult() {
        IPUtil m = new IPUtil();
        String path = m.getFilePathInSrcAfterRun();
        System.out.println(path);
        List<IpAddress> list = null;

        return list;
    }

    public String getFilePathInSrcAfterRun() {
        String path = getClass().getClassLoader().getResource("").toString();

        int m = path.indexOf("/");
        path = path.substring(m + 1);

        return path;
    }

    public static boolean isLocalPortUsing(String ip, int port) {
        boolean flag = true;
        try {
            flag = isPortUsing(ip, port);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static boolean isPortUsing(String host, int port)
        throws UnknownHostException {
        boolean flag = false;
        InetAddress Address = InetAddress.getByName(host);
        try {
            Socket socket = new Socket(Address, port);
            flag = true;
        } catch (IOException localIOException) {
        }
        return flag;
    }

    public static List<IpAddress> getProperties(String filePath) {
        List<IpAddress> list = new ArrayList();
        Properties properties = new Properties();
        try {
            InputStream inStream = new BufferedInputStream(new FileInputStream(filePath));
            properties.load(inStream);
            Set<String> keys = properties.stringPropertyNames();
            for (Iterator<String> it = keys.iterator(); it.hasNext();) {
                String key = it.next();
                String value = properties.getProperty(key);

                String[] arrst = value.split(",");
                IpAddress ipAddress = new IpAddress(arrst[0], Integer.parseInt(arrst[1]));
                list.add(ipAddress);
            }
        } catch (IOException e) {
            Iterator<String> it;
            e.printStackTrace();
        }
        return list;
    }
}
