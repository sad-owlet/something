package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.AbstractEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "access_request")
public class AccessRequest extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;
    @JoinColumn(name = "firmware", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Firmware firmware;
    private boolean approved = false;
    @Column(name = "date_add", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
}
