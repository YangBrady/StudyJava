package me.yangjun.study.config.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import me.yangjun.study.entity.GenderEnum;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.CHAR)
public class GenderEnumTypeHandler extends BaseTypeHandler<GenderEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GenderEnum parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, parameter.getGenderCode());
    }

    @Override
    public GenderEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String genderDbValue = rs.getString(columnName);
        return GenderEnum.getByCode(genderDbValue);
    }

    @Override
    public GenderEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String genderDbValue = rs.getString(columnIndex);
        return GenderEnum.getByCode(genderDbValue);
    }

    @Override
    public GenderEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String genderDbValue = cs.getString(columnIndex);
        return GenderEnum.getByCode(genderDbValue);
    }
}
