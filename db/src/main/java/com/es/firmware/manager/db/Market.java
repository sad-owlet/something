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
@Table(name = "market")
public class Market extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<CarBrand> carBrands;
}
