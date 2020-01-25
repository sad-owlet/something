package com.es.firmaware.manager.db.type;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public interface IPrimaryKey<PK extends Number> extends Serializable {

    String PREFIX = "e";
    String SEPARATOR = ".";

    PK getId();

    void setId(PK id);

    default int _hashCode() {
        return Objects.hashCode(getId());
    }

    default boolean _equals(Object object, Class _class) {
        if (!_class.isInstance(object)) {
            return false;
        }
        IPrimaryKey other = (IPrimaryKey) object;
        return !((getId() == null && other.getId() != null) || (getId() != null && !getId().equals(other.getId())));
    }

    default boolean _equals(Object object) {
        return _equals(object, getClass());
    }

    default String _toString(Class _class) {
        return _class.getName() + "[ id=" + getId() + " ]";
    }

    default String _toString() {
        return _toString(getClass());
    }

    static <PK extends Number> PK getNullOrId(IPrimaryKey<PK> entity) {
        return entity != null ? entity.getId() : null;
    }

    static <T extends IPrimaryKey> boolean isManaged(final T instance) {
        return getNullOrId(instance) != null;
    }

    static <PK extends Number> Collection<PK> getIds(Collection<? extends IPrimaryKey<PK>> list) {
        return list.stream().map(IPrimaryKey::getId).collect(Collectors.toList());
    }
}
