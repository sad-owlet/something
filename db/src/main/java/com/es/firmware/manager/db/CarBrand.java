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
@Table(name = "car_brand")
public class CarBrand extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Market market;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "market")
    private List<FuelType> fuelTypes;
}
