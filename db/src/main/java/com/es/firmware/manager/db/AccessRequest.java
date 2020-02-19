package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.AbstractEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "access_request")
public class AccessRequest extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    private boolean approved = false;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Person person;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Firmware firmware;
}
