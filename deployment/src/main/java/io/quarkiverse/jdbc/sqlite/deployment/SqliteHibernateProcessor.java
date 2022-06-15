package io.quarkiverse.jdbc.sqlite.deployment;

import org.sqlite.hibernate.dialect.SQLiteDialect;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.hibernate.orm.deployment.spi.DatabaseKindDialectBuildItem;

//https://github.com/gwenn/sqlite-dialect/
@SuppressWarnings("unused")
public class SqliteHibernateProcessor {

    @BuildStep
    void processHibernate(
            BuildProducer<DatabaseKindDialectBuildItem> producer) {
        producer.produce(new DatabaseKindDialectBuildItem("sqlite", SQLiteDialect.class.getName()));
    }
}
