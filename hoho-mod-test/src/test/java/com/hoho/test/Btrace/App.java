package com.hoho.test.Btrace;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

/**
 * 使用：下载btrace，进入bin目录执行：./btrace Pid App.java </br>
 * 将App.java可以直接放入bin目录,并通过ftp修改后之后上传替换。 <br>
 * 问题：1、操作上不是很方便,学习成本高 2、执行此功能需要root权限，否则无法执行
 * 
 * @author linx
 *
 */
@BTrace
public class App {
    @OnMethod(clazz = "cn.yunlai.cjds.web.controller.user.UserController", method = "getUserConvergeInfo")
    public static void func(@ProbeClassName String clasName, @ProbeMethodName String methodName) {
        BTraceUtils.println("监控到类名:" + clasName + ",方法:" + methodName + "当前时间:" + BTraceUtils.timeMillis());
    }
}
