package com.hoho.test.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MapperProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> clz) {
        return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[] { clz }, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> declaringClass = method.getDeclaringClass();
        Class<? extends Method> class1 = method.getClass();
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        return new User(1, "hello", 23);
    }

    public static void main(String[] args) {
        UserMapper userMapper = new MapperProxy().newInstance(UserMapper.class);
        User userById = userMapper.getUserById(123L);
        System.out.println(userById);
    }

}
