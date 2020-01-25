package com.es.firmaware.manager.db;

import com.es.firmaware.manager.db.type.AbstractEntity;
import com.es.firmaware.manager.db.type.HStoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "person")
@TypeDefs({
        @TypeDef(name = "hstore", typeClass = HStoreType.class)
})
public class Person extends AbstractEntity<Integer> {}
