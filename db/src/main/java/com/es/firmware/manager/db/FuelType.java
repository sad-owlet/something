package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.HStoreType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "fuelType")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})

public class FuelType implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private CarBrand carBrand;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private ECUtype ecuType ;

    public FuelType(){}

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
