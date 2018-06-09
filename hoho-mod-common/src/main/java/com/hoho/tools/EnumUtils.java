package com.hoho.tools;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将enum类转为list
 * 
 * @author yunnex
 * @date 2018年1月11日
 */
public class EnumUtils {
    /**
     * 将Enum类型转化成List<br>
     * 读取枚举中的get方法，并将值放入map中
     * 
     * @param obj
     * @return
     * @throws Exception
     * @date 2018年1月11日
     * @author linxTeng
     */
    public static List<Object> enumToList(Enum<?>[] obj) {
        List<Object> list = new ArrayList<>();
        for (Object o : obj) {
            Map<String, Object> map = new HashMap<String, Object>();
            Class<?> oclass = o.getClass();
            Method[] methods = oclass.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                if (methodName.indexOf("get") == 0) {
                    try {
                        // 去掉get和首字母小写
                        String putName = methodName.replaceFirst("get", "");
                        String fistChar = putName.substring(0, 1);
                        map.put(putName.replaceFirst(fistChar, fistChar.toLowerCase()), method.invoke(o));
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
            list.add(map);
        }
        return list;
    }
}
