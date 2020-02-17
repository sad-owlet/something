package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.HStoreType;
import lombok.Data;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "firmware")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})

public class Firmware implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dateAdded", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date add_date;
    private String HW_id;
    private String SW_id;
    private String SW_number;
    private String file_name;
    private Integer size;
    private String author;
    private Integer CRC32;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private GearboxType gearboxType;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private ECUtype ecuType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accessRequest")
    private List<AccessRequest> accessRequests;

    public Firmware(){}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }

    public Date getAdd_date() {
        return add_date;
    }
    public void setAdd_date(Date add_date) { this.add_date = add_date; }

    public String getHW_id() { return HW_id; }
    public void setHW_id(String HW_id) {
        this.HW_id = HW_id;
    }

    public String getSW_id() { return SW_id; }
    public void setSW_id(String SW_id) {
        this.SW_id = SW_id;
    }

    public String getSW_number() {
        return SW_number;
    }
    public void setSW_number(String SW_number) {
        this.SW_number = SW_number;
    }

    public String getFile_name() {
        return file_name;
    }
    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCRC32() {
        return CRC32;
    }
    public void setCRC32(Integer CRC32) {
        this.CRC32 = CRC32;
    }

}
