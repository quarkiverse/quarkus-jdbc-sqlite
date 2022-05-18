package io.quarkiverse.jdbc.sqlite.deployment;

import static io.quarkiverse.jdbc.sqlite.deployment.JDBCSqliteProcessor.DRIVER_NAME;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;

/**
 * Registers the {@code org.sqlite.JDBC} so that it can be loaded
 * by reflection, as commonly expected.
 *
 * @author Alexey Sharandin <sanders@yandex.ru>
 */

public class SqliteJDBCReflections {
    @BuildStep
    void build(BuildProducer<ReflectiveClassBuildItem> reflectiveClass) {
        //Not strictly necessary when using Agroal, as it also registers
        //any JDBC driver being configured explicitly through its configuration.
        //We register it for the sake of people not using Agroal.
        reflectiveClass.produce(new ReflectiveClassBuildItem(false, false, DRIVER_NAME));
    }
}
