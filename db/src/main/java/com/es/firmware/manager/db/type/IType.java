package com.es.firmware.manager.db.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IType {

    Object copyObject(Object o, Class<?> returnedClass);

    default Object copyObject(Object o) {
        return copyObject(o, void.class);
    }

    Object getObject(ResultSet rs, String[] names, Class<?> returnedClass) throws SQLException;

    void setObject(PreparedStatement ps, Object value, int index) throws SQLException;
}
