package com.es.firmware.manager.db;

import org.flywaydb.core.Flyway
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
abstract class PgRunner extends Specification {

    @Shared
    String dbName = "test"
    @Shared
    String dbUser = "test"
    @Shared
    String dbPassword = "test"
    @Shared
    PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:11")
            .withDatabaseName(dbName)
            .withUsername(dbUser)
            .withPassword(dbPassword)

    def setupSpec() {
        Flyway flyway = Flyway.configure()
                .dataSource(postgres.jdbcUrl, dbUser, dbPassword)
                .locations("classpath:/db/migration")
                .load()
        flyway.clean()
        flyway.migrate()
        onInit(postgres.jdbcUrl)
    }

    def cleanupSpec() {
        postgres.stop()
    }

    protected abstract void onInit(String url)
}
