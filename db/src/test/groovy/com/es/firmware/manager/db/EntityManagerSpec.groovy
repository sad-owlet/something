package com.es.firmware.manager.db


import spock.lang.Shared

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

abstract class EntityManagerSpec extends PgRunner {

    @Shared
    EntityManager em

    @Override
    protected void onInit(String url) {
        def params = [
                "javax.persistence.jdbc.url"     : url,
                "javax.persistence.jdbc.user"    : dbUser,
                "javax.persistence.jdbc.password": dbPassword
        ]
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default", params)
        em = emf.createEntityManager()
    }
}

