package cn.qingwei.graduationproject.mappertypeHandler;

import cn.qingwei.graduationproject.pojo.Habitation;
import cn.qingwei.graduationproject.pojo.Order;
import cn.qingwei.graduationproject.pojo.OrderStatus;
import cn.qingwei.graduationproject.pojo.Status;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//声明jdbcType 为
@MappedJdbcTypes(JdbcType.INTEGER)
//声明JavaType为SexEnum
@MappedTypes(value = OrderStatus.class)
public class OrderStatusTypeHandler extends BaseTypeHandler<OrderStatus> {

    //    设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, OrderStatus status, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,status.getId());
    }


    //    通过列名读取性别
    @Override
    public OrderStatus getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int  status=resultSet.getInt(s);
        if(status!=0&&status!=1&&status!=2&&status!=3&&status!=4)
            return  null;
        return OrderStatus.getEnumByid(status);
    }
    //    通过下标读取性别
    @Override
    public OrderStatus getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int status=resultSet.getInt(i);
        if(status!=0&&status!=1&&status!=2&&status!=3&&status!=4)
            return  null;
        return OrderStatus.getEnumByid(status);
    }
    //    通过存储过程读取性别
    @Override
    public OrderStatus getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int status=callableStatement.getInt(i);
        if(status!=0&&status!=1&&status!=2&&status!=3&&status!=4)
            return  null;
        return OrderStatus.getEnumByid(status);
    }
}

