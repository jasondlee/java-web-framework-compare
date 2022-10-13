package com.steeplesoft.jwfc.quarkus.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

@ApplicationScoped
public class FlywayMigration {

//    @ConfigProperty(name = "myapp.flyway.migrate")
//    boolean runMigration;

    @ConfigProperty(name = "quarkus.datasource.reactive.url")
    String datasourceUrl;
    @ConfigProperty(name = "quarkus.datasource.username")
    String datasourceUsername;
    @ConfigProperty(name = "quarkus.datasource.password")
    String datasourcePassword;

    public void runFlywayMigration(@Observes StartupEvent event) {
//        if (runMigration) {
            Flyway flyway = Flyway.configure()
                    .dataSource("jdbc" + datasourceUrl.replace("vertx-reactive", ""),
                        datasourceUsername, datasourcePassword)
                    .baselineOnMigrate(true)
                    .locations("classpath:/db/migrations")
                    .cleanDisabled(false)
                    .load();
            flyway.clean();
            flyway.migrate();
//        }
    }
}
