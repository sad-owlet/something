package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.AbstractEntity;
import com.es.firmware.manager.db.type.HStoreType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "person")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})
public class Person extends AbstractEntity<Integer> {

    @Basic(optional = false)
    private String login;
    @Column(name = "password_hash")
    private String passwordHash;
    private boolean active;
    private boolean root;
    @Column(name = "date_add", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
}
