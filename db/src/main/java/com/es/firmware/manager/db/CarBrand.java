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
@Table(name = "carBrand")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})

public class CarBrand implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Market market;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "market")
    private List<FuelType> fuelTypes;

    public CarBrand() {}

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