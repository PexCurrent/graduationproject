package cn.qingwei.graduationproject.mappertypeHandler;

import cn.qingwei.graduationproject.pojo.Habitation;
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
@MappedTypes(value = Habitation.class)
public class HabitationTypeHandler extends BaseTypeHandler<Habitation> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Habitation habitation, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,habitation.toString());
    }
    //    通过列名读取性别
    @Override
    public Habitation getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String habitation=resultSet.getString(s);
        if(habitation==null||!habitation.contains("-"))
            return  null;
        return Habitation.getHabitationbyStr(habitation);
    }

    @Override
    public Habitation getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String habitation=resultSet.getString(i);
        if(habitation==null||!habitation.contains("-"))
            return  null;
        return Habitation.getHabitationbyStr(habitation);
    }

    //    通过存储过程读取性别
    public Habitation getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String habitation = callableStatement.getString(i);
        if (habitation == null || !habitation.contains("-"))
            return null;
        return Habitation.getHabitationbyStr(habitation);
    }
}
