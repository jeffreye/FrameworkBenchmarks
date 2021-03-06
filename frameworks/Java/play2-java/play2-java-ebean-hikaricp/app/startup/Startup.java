package startup;

import com.typesafe.config.Config;
import play.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Startup {

    private static final Logger.ALogger logger = Logger.of(Startup.class);

    @Inject
    public Startup(final Config config) {
        logger.info("System properties");
        logger.info("-----------------");
        logger.info("physical_cpu_count: {}", System.getProperty("physical_cpu_count"));
        logger.info("thread_count: {}", System.getProperty("thread_count"));
        logger.info("db_pool_size: {}", System.getProperty("db_pool_size"));
        logger.info("");
        logger.info("Configuration");
        logger.info("-------------");
        logger.info("akka.actor.default-dispatcher.fork-join-executor.parallelism-max: {}", config.getInt("akka.actor.default-dispatcher.fork-join-executor.parallelism-max"));
        logger.info("fixedConnectionPool: {}", config.getInt("fixedConnectionPool"));
        logger.info("database.dispatcher.thread-pool-executor.fixed-pool-size: {}", config.getInt("database.dispatcher.thread-pool-executor.fixed-pool-size"));
        logger.info("db.default.hikaricp.maximumPoolSize: {}", config.getInt("db.default.hikaricp.maximumPoolSize"));
        logger.info("");
    }
}
