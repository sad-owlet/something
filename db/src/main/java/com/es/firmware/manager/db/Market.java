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
@Table(name = "market")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})

public class Market implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "market")
    private List<CarBrand> carBrands;

    public Market(){}

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
