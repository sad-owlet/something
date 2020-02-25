package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "firmware")
public class Firmware extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    private String hardware;
    private String software;
    private String software_number;
    private String file_name;
    private String path;
    private Integer size;
    private String author;
    private Integer crc32;
    @Column(name = "date_add", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private GearboxType gearboxType;
   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<AccessRequest> accessRequests;
}
