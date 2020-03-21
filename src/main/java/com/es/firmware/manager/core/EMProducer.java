package com.es.firmware.manager.core;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@ApplicationScoped
public class EMProducer {

    private EntityManagerFactory emf;

    @PostConstruct
    public void postConstruct() {
        emf = createFactory(false);
    }

    private EntityManagerFactory createFactory(boolean exceptional) {
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("javax.persistence.nonJtaDataSource", "java:/comp/env/jdbc/firmware");
            params.put("hibernate.show_sql", true);
            params.put("hibernate.use_sql_comments", true);

            params.put("hibernate.jdbc.batch_size", "20");
            params.put("hibernate.jdbc.fetch_size", "40");

            loadEntityClasses(params);

            return Persistence.createEntityManagerFactory("default", params);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            if (exceptional) {
                throw e;
            }
        }
        return null;
    }

    public EntityManagerFactory emf() {
        if (this.emf == null) {
            this.emf = createFactory(true);
        }
        return emf;
    }

    private void loadEntityClasses(Map<String, Object> params) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.forPackages("com.es");
        Set<Class<?>> allEntityClasses = new Reflections(builder).getTypesAnnotatedWith(Entity.class);
        log.trace("Class founded for registration in PU: {}", allEntityClasses);
        params.put("hibernate.ejb.loaded.classes", new ArrayList<>(allEntityClasses));
    }

    @Produces
    @RequestScoped
    public EntityManager entityManager() {
        return emf().createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
