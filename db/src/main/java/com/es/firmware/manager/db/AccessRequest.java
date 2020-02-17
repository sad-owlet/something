package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.HStoreType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "accessRequest")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})

public class AccessRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean approved;

    public AccessRequest(){}

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Person person;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Firmware firmware;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }

    public Boolean isApproved(){
        return approved;
    }
    public void setApproved(Boolean approved){
        this.approved=approved;
    }
}
