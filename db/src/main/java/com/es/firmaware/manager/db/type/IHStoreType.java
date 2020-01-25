package com.es.firmaware.manager.db.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public interface IHStoreType extends IType {

    @Override
    default Object copyObject(Object o, Class<?> returnedClass) {
        if (o == null) {
            return null;
        }
        Map m = (Map) o;
        return new HashMap(m);
    }

    @Override
    default Object getObject(ResultSet rs, String[] names, Class<?> returnedClass) throws SQLException {
        String col = names[0];
        Object result = rs.getObject(col);
        if (rs.wasNull()) {
            return new HashMap<>();
        }
        return result;
    }

    @Override
    default void setObject(PreparedStatement ps, Object value, int index) throws SQLException {
        if (value == null || ((Map) value).isEmpty()) {
            ps.setNull(index, Types.OTHER);
            return;
        }
        ps.setObject(index, value);
    }
}
