package com.es.firmware.manager.db;

import com.es.firmware.manager.db.type.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "firmware")
public class Firmware extends AbstractEntity<Integer> {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "gearbox_type", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GearboxType gearboxType;
    private String hardware;
    private String software;
    @Column(name = "software_number")
    private String softwareNumber;
    @Column(name = "file_name")
    private String fileName;
    private String path;
    private int size;
    private String author;
    private int crc32;
    @Column(name = "date_add", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;
}
