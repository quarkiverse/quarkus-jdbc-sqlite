package io.quarkiverse.jdbc.sqlite.deployment;

import org.hibernate.community.dialect.SQLiteDialect;

import io.quarkiverse.jdbc.sqlite.runtime.SQLiteConstants;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.hibernate.orm.deployment.spi.DatabaseKindDialectBuildItem;

public class SqliteHibernateProcessor {

    @BuildStep
    void processHibernate(
            BuildProducer<DatabaseKindDialectBuildItem> producer) {
        producer.produce(
                DatabaseKindDialectBuildItem.forThirdPartyDialect(SQLiteConstants.DB_KIND, SQLiteDialect.class.getName()));
    }
}
