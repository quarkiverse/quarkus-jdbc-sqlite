package io.quarkiverse.sqlite4j.deployment;

import static io.quarkiverse.sqlite4j.runtime.SQLiteConstants.DB_KIND;

import io.quarkiverse.sqlite4j.runtime.SqliteAgroalConnectionConfigurer;
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
import io.roastedroot.sqlite4j.JDBC;
import io.roastedroot.sqlite4j.SQLiteDataSource;

/**
 * Deploy extension to Quarkus framework
 *
 */
@SuppressWarnings("unused")
class JDBCSqliteProcessor {

    private static final String FEATURE = "sqlite4j";

    static final String DRIVER_NAME = JDBC.class.getName();
    private static final String DATA_SOURCE_NAME = SQLiteDataSource.class.getName();

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
