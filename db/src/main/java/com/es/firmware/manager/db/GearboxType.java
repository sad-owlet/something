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
@Table(name = "gearbox_type")
public class GearboxType extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    private String name;
    @OneToOne(optional = false, mappedBy = "passport")
    private CarModel carModel;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "firmware")
    private List<FuelType> fuelTypes;
}
