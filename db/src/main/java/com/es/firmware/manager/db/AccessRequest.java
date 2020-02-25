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

    private boolean approved = false;
    @Column(name = "date_add", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)    
    private Person person;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Firmware firmware;
}
