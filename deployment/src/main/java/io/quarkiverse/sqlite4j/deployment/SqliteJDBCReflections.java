package io.quarkiverse.sqlite4j.deployment;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;

/**
 * Registers the {@code io.roastedroot.sqlite4j.JDBC} so that it can be loaded
 * by reflection, as commonly expected.
 */

@SuppressWarnings("unused")
public class SqliteJDBCReflections {
    @BuildStep
    void build(BuildProducer<ReflectiveClassBuildItem> reflectiveClass) {
        //Not strictly necessary when using Agroal, as it also registers
        //any JDBC driver being configured explicitly through its configuration.
        //We register it for the sake of people not using Agroal.
        reflectiveClass.produce(ReflectiveClassBuildItem.builder(JDBCSqliteProcessor.DRIVER_NAME).build());
    }
}
