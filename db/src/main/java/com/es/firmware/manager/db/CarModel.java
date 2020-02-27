package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.AbstractEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car_model")
public class CarModel extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "ecu_type", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EcuType ecuType;
    @Basic(optional = false)
    private String name;
}
