package cn.qingwei.graduationproject.mappertypeHandler;

import cn.qingwei.graduationproject.pojo.Habitation;
import cn.qingwei.graduationproject.pojo.Hometown;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//声明jdbcType 为
@MappedJdbcTypes(JdbcType.CHAR)
//声明JavaType为SexEnum
@MappedTypes(value = Hometown.class)
public class HometownTypeHandler extends BaseTypeHandler<Hometown>{
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Hometown Hometown, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,Hometown.toString());
    }
    //    通过列名读取性别
    @Override
    public Hometown getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String hometown=resultSet.getString(s);
        if(hometown==null||!hometown.contains("-"))
            return  null;
        return Hometown.getHometownbyStr(hometown);
    }

    @Override
    public Hometown getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String hometown=resultSet.getString(i);
        if(hometown==null||!hometown.contains("-"))
            return  null;
        return Hometown.getHometownbyStr(hometown);
    }

    //    通过存储过程读取性别
    public Hometown getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String hometown = callableStatement.getString(i);
        if (hometown == null || !hometown.contains("-"))
            return null;
        return Hometown.getHometownbyStr(hometown);
    }
}
