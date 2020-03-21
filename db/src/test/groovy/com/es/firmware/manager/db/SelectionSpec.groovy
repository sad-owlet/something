package com.es.firmware.manager.db

class SelectionSpec extends EntityManagerSpec {

    def "Selection all entity"() {
        expect:
        em.createQuery(hql).getResultList().size() >= size
        where:
        hql                             | size
        'select e from AccessRequest e' | 0
        'select e from CarBrand e'      | 0
        'select e from CarModel e'      | 0

        'select e from EcuType e'       | 0
        'select e from Firmware e'      | 0

        'select e from FuelType e'      | 0
        'select e from GearboxType e'   | 0
        'select e from Market e'        | 0
        'select e from Person e'        | 1
    }
}

