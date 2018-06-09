package com.hoho.tools;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.cglib.beans.BeanMap;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class BeanMapUtil {
    /**
     * 将对象装换为map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     *
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * 将List<T>转换为List<Map<String, Object>>
     *
     * @param objList
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, Object>> objectsToMaps(List<T> objList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = objList.size(); i < size; i++) {
                bean = objList.get(i);
                map = beanToMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将Enum[]转换为List<Map<String, Object>>
     * 
     * @param eumObjs
     * @return
     */
    public static List<Map<String, Object>> enumsToMaps(Enum[] eumObjs) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (eumObjs != null && eumObjs.length > 0) {
            Map<String, Object> map = null;
            Enum eumObj = null;
            for (int i = 0, length = eumObjs.length; i < length; i++) {
                eumObj = eumObjs[i];
                // 是否有deprecated注解
                boolean deprecated = false;
                // 获取枚举类中的字段
                Field[] fields = eumObj.getClass().getFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Deprecated.class) && eumObj.name().equals(field.getName())) {
                        deprecated = true;
                        break;
                    }
                }
                // 忽略加了Deprecated注解的对象
                if (deprecated) {
                    continue;
                }
                // 进行转换enumObj --> map
                map = Maps.newHashMap();
                if (eumObj != null) {
                    BeanMap beanMap = BeanMap.create(eumObj);
                    for (Object key : beanMap.keySet()) {
                        map.put(key + "", beanMap.get(key));
                    }
                    // 移除枚举类型转换多余的declaringClass属性
                    map.remove("declaringClass");
                }
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将List<Map<String,Object>>转换为List<T>
     *
     * @param maps
     * @param clazz
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> List<T> mapsToObjects(List<Map<String, Object>> maps, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        List<T> list = Lists.newArrayList();
        if (maps != null && maps.size() > 0) {
            Map<String, Object> map = null;
            T bean = null;
            for (int i = 0, size = maps.size(); i < size; i++) {
                map = maps.get(i);
                bean = clazz.newInstance();
                mapToBean(map, bean);
                list.add(bean);
            }
        }
        return list;
    }
}
