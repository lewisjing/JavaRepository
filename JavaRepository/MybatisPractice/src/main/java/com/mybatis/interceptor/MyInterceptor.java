package com.mybatis.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.javassist.tools.reflect.Metaobject;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Statement;
import java.util.Properties;

// 自定义拦截器
@Intercepts({
        // 拦截StatementHandler中的query方法
        @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
        @Signature(type = StatementHandler.class, method = "parameterize", args = {Statement.class})
})
public class MyInterceptor implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截方法.....");

        // 这里获取的target其实就是sql标签，其实就是StatementHandler
        Object target = invocation.getTarget();

        // 获取target对象中的参数
        MetaObject metaObject = SystemMetaObject.forObject(target);

        // 获取sql语句中的参数, 这里的参数值基本是固定的
        Object value = metaObject.getValue("parameterHandler.parameterObject");

        // 修改参数
        metaObject.setValue("parameterHandler.parameterObject", 2);

        // 放行（通过）
        Object object = invocation.proceed();
        System.out.println(object);
        return object;
    }

    // 将拦截器中定义的增强功能与原来的对象合并并返回。
    public Object plugin(Object target) {
        // 将当前拦截器与核心对象合并
        System.out.println("plugin.....");
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        System.out.println("设置属性。。。" + properties);
    }

}
