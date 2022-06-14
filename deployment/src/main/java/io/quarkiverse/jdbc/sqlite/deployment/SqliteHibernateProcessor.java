package io.quarkiverse.jdbc.sqlite.deployment;

import org.sqlite.SQLiteDataSource;

import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.ExecutionTime;
import io.quarkus.deployment.annotations.Record;
import io.quarkus.hibernate.orm.deployment.spi.DatabaseKindDialectBuildItem;

//https://github.com/gwenn/sqlite-dialect/
public class SqliteHibernateProcessor {

    @BuildStep
    @Record(ExecutionTime.STATIC_INIT)
    void processHibernate(
            BuildProducer<DatabaseKindDialectBuildItem> producer) {
        producer.produce(new DatabaseKindDialectBuildItem("sqllite", SQLiteDataSource.class.getName()));
        //recorder.recordSqlliteDialect(producer);
        //cfg.dialect
        //io.quarkus.hibernate.orm.deployment.HibernateOrmProcessor
        //io.quarkus.hibernate.orm.deployment.Dialects
    }

    /*
     * @BuildStep
     * void registerService(BuildProducer<ServiceProviderBuildItem> producer) {
     * System.out.println("producer = " + producer);
     * producer.produce(new ServiceProviderBuildItem(
     * MetadataBuilderInitializer.class.getName(),
     * SQLiteMetadataBuilderInitializerImpl.class.getName()));
     * }
     * 
     * private static class SQLiteMetadataBuilderInitializerImpl implements MetadataBuilderInitializer {
     * 
     * @Override
     * public void contribute(MetadataBuilder metadataBuilder, StandardServiceRegistry serviceRegistry) {
     * DialectResolver dialectResolver = serviceRegistry.getService(DialectResolver.class);
     * 
     * if (!(dialectResolver instanceof DialectResolverSet)) {
     * 
     * logger.warnf("DialectResolver '%s' is not an instance of DialectResolverSet, not registering SQLiteDialect",
     * dialectResolver);
     * 
     * return;
     * }
     * 
     * ((DialectResolverSet) dialectResolver).addResolver(resolver);
     * }
     * 
     * }
     * 
     * static private final SQLiteDialect dialect = new SQLiteDialect();
     * static private final DialectResolver resolver = info -> {
     * System.out.println("!!!!!!!!!!!!!info = " + info);
     * if (info.getDatabaseName().equalsIgnoreCase("SQLite"))
     * return dialect;
     * 
     * return null;
     * };
     */

}
