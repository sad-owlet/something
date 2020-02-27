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

    @JoinColumn(name = "car_model", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CarModel carModel;
    @Basic(optional = false)
    private String name;
}
