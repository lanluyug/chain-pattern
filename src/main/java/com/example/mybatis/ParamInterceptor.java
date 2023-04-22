package com.example.mybatis;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Properties;

/**
 * 责任链模式在mybatis中的插件拦截器中的使用
 */
@Intercepts({

        @Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class),
})
@Component
@Slf4j
public class ParamInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.error("拦截器ParamInterceptor");
        //拦截 ParameterHandler 的 setParameters 方法 动态设置参数
        if (invocation.getTarget() instanceof ParameterHandler) {

            ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
            PreparedStatement ps = (PreparedStatement) invocation.getArgs()[0];
            // 反射获取 BoundSql 对象，此对象包含生成的sql和sql的参数map映射
            Field boundSqlField = parameterHandler.getClass().getDeclaredField("boundSql");
            boundSqlField.setAccessible(true);
            BoundSql boundSql = (BoundSql) boundSqlField.get(parameterHandler);
            // 反射获取 参数对像
            Field parameterField =
                    parameterHandler.getClass().getDeclaredField("parameterObject");
            parameterField.setAccessible(true);
            Object parameterObject = parameterField.get(parameterHandler);
            if (parameterObject instanceof Map) {
                Map<String, Object> parameterMap = ((Map<String, Object>) parameterObject);
                parameterObject = Maps.transformEntries(parameterMap, (k, v) -> {
                    if (v instanceof String) {
                        return ((String) v).replace("%", "\\%");
                    }
                    return v;
                });
            }

            // 改写的参数设置到原parameterHandler对象
            parameterField.set(parameterHandler, parameterObject);
            parameterHandler.setParameters(ps);
            log.warn(boundSql.getParameterMappings().toString());
            log.warn(parameterObject.toString());
        }
        return invocation.proceed();
    }
    @Override
    public Object plugin(Object o) {

        return Plugin.wrap(o, this);
    }
    @Override
    public void setProperties(Properties properties) {

    }
}