package com.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 类型转换器，将Java类型的boolean 转为 数据库中的int类型
// 这里加上泛型约束，代表我们要转换的是Java的Boolean类型
// true: 1  false: 0
public class BooleanAndIntConverter extends BaseTypeHandler<Boolean> {

    // Java - > 数据库
    // preparedStatement
    // i： 是preparedStatement对象操作的参数的位置
    // o： 是Java的值
    // jdbcType: 是jdbc操作的数据库类型
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean o, JdbcType jdbcType) throws SQLException {
        if (o) {
            preparedStatement.setInt(i, 1);
        } else {
            preparedStatement.setInt(i, 0);
        }
    }

    // 数据库 -> java
    // 根据列名来取值
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sexNum = resultSet.getInt(s);
        if (sexNum == 1) {
            return true;
        }

        return false;
    }

    // 数据库 -> java
    // 根据下标来取值
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sexNum = resultSet.getInt(i);
        if (sexNum == 1) {
            return true;
        }

        return false;
    }

    // 数据库 -> java
    // 通过存储过程取值
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sexNum = callableStatement.getInt(i);
        if (sexNum == 1) {
            return true;
        }

        return false;
    }
}
