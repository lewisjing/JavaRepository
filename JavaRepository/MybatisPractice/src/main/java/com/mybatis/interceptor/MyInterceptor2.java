package com.mybatis.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

// 自定义拦截器
@Intercepts({
        // 拦截StatementHandler中的query方法
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class})
})
public class MyInterceptor2 implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截方法2.....");
        // 放行（通过）
        Object object = invocation.proceed();
        System.out.println(object);
        return object;
    }

    // 将拦截器中定义的增强功能与原来的对象合并并返回。
    public Object plugin(Object target) {
        // 将当前拦截器与核心对象合并
        System.out.println("plugin2.....");
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        System.out.println("设置属性2。。。" + properties);
    }

}
