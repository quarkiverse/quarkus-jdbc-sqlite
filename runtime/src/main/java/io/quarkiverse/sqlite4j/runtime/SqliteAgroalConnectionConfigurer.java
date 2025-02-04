package io.quarkiverse.sqlite4j.runtime;

import io.agroal.api.configuration.supplier.AgroalDataSourceConfigurationSupplier;
import io.quarkus.agroal.runtime.AgroalConnectionConfigurer;
import io.quarkus.agroal.runtime.JdbcDriver;

/**
 * Empty Agroal configurer
 *
 */
@JdbcDriver(SQLiteConstants.DB_KIND)
public class SqliteAgroalConnectionConfigurer implements AgroalConnectionConfigurer {

    @Override
    public void disableSslSupport(String databaseKind, AgroalDataSourceConfigurationSupplier dataSourceConfiguration) {
        // do not log anything for SQLite
    }

    @Override
    public void setExceptionSorter(String databaseKind, AgroalDataSourceConfigurationSupplier dataSourceConfiguration) {
        // Do not log a warning: we don't have an exception sorter for SQLite,
        // but there is nothing the user can do about it.
    }
}
