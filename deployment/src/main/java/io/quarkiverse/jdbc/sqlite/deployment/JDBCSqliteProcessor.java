package io.quarkiverse.jdbc.sqlite.deployment;

import org.sqlite.JDBC;
import org.sqlite.SQLiteDataSource;

import io.quarkiverse.jdbc.sqlite.runtime.SqliteAgroalConnectionConfigurer;
import io.quarkus.agroal.spi.JdbcDriverBuildItem;
import io.quarkus.arc.deployment.AdditionalBeanBuildItem;
import io.quarkus.arc.processor.BuiltinScope;
import io.quarkus.datasource.deployment.spi.DefaultDataSourceDbKindBuildItem;
import io.quarkus.datasource.deployment.spi.DevServicesDatasourceConfigurationHandlerBuildItem;
import io.quarkus.deployment.Capabilities;
import io.quarkus.deployment.Capability;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.SslNativeConfigBuildItem;

/**
 * Deploy extention to Quarkus framework
 *
 * @author Alexey Sharandin <sanders@yandex.ru>
 */
@SuppressWarnings("unused")
class JDBCSqliteProcessor {

    private static final String FEATURE = "JDBC-Sqlite";

    static final String DRIVER_NAME = JDBC.class.getName();
    private static final String DATA_SOURCE_NAME = SQLiteDataSource.class.getName();
    private static final String DB_KIND = "sqlite";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    void registerDriver(BuildProducer<JdbcDriverBuildItem> jdbcDriver,
            SslNativeConfigBuildItem sslNativeConfigBuildItem) {

        jdbcDriver.produce(
                new JdbcDriverBuildItem(
                        DB_KIND,
                        DRIVER_NAME,
                        DATA_SOURCE_NAME));
    }

    @BuildStep
    DevServicesDatasourceConfigurationHandlerBuildItem devDbHandler() {
        return DevServicesDatasourceConfigurationHandlerBuildItem.jdbc(DB_KIND);
    }

    @BuildStep
    void configureAgroalConnection(BuildProducer<AdditionalBeanBuildItem> additionalBeans,
            Capabilities capabilities) {
        if (capabilities.isPresent(Capability.AGROAL)) {
            additionalBeans.produce(new AdditionalBeanBuildItem.Builder().addBeanClass(SqliteAgroalConnectionConfigurer.class)
                    .setDefaultScope(BuiltinScope.APPLICATION.getName())
                    .setUnremovable()
                    .build());
        }
    }

    @BuildStep
    void registerDefaultDbType(BuildProducer<DefaultDataSourceDbKindBuildItem> dbKind) {
        dbKind.produce(new DefaultDataSourceDbKindBuildItem(DB_KIND));
    }
}
