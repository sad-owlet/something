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

    @Basic(optional = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fuelType")
    private List<FuelType> fuelTypes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fuelType")
    private List<Firmware> firmwares;


}
