package com.linx.test.mode.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理处理器
 */
public class OwnerInvoctionHandler  implements InvocationHandler {
    PersonBean personBean;//真实的处理者

    public OwnerInvoctionHandler(PersonBean personBean){
        this.personBean=personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("get")){
            return method.invoke(personBean,args);
        }else if(method.getName().equals("setName")){
            System.out.println("你不能再次设置名称!");
        }else if(method.getName().startsWith("set")){
            System.out.println("你重设了年龄为:"+args[0]);
            return method.invoke(personBean,args);
        }
        return null;
    }
}
