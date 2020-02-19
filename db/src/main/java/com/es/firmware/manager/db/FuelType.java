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
@Table(name = "fuel_type")
public class FuelType extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    private String name;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private CarBrand carBrand;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private EcuType ecuType;
}
