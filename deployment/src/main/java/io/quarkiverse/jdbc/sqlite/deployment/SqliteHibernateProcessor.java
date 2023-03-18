package io.quarkiverse.jdbc.sqlite.deployment;

import org.hibernate.community.dialect.SQLiteDialect;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.hibernate.orm.deployment.spi.DatabaseKindDialectBuildItem;

public class SqliteHibernateProcessor {

    @BuildStep
    void processHibernate(
            BuildProducer<DatabaseKindDialectBuildItem> producer) {
        producer.produce(new DatabaseKindDialectBuildItem("sqlite", SQLiteDialect.class.getName()));
    }
}
