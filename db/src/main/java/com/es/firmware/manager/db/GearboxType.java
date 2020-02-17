package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.HStoreType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "gearboxType")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})

public class GearboxType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    private String name;

    @OneToOne (optional=false, mappedBy="passport")
    private CarModel carModel;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "firmware")
    private List<FuelType> fuelTypes;

    public GearboxType(){}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
