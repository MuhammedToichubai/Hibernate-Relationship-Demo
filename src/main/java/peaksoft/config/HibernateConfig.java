package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.models.Post;
import peaksoft.models.Profile;
import peaksoft.models.User;

import java.util.Properties;

public class HibernateConfig {

    public static EntityManagerFactory getEntityManagerFactory() {
        Properties properties = new Properties();
        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5454/java16");
        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "postgres");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.HBM2DDL_AUTO, "update");   // create
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Profile.class);
        configuration.addAnnotatedClass(Post.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
