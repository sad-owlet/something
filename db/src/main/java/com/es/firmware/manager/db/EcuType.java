package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ecu_type")
public class EcuType extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "fuel_type", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FuelType fuelType;
    @Basic(optional = false)
    private String name;
}
