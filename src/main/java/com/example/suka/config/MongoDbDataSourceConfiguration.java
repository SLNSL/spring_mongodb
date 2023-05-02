package com.example.suka.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableMongoRepositories(
        basePackages = {"com.example.suka.repo.user"}
)
public class MongoDbDataSourceConfiguration {

    private final MongoProperties mongoProperties;

    public MongoDbDataSourceConfiguration(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Bean(name = "peopleMongoTemplate")
    public MongoTemplate peopleMongoTemplate() throws Exception {
        return new MongoTemplate(peopleDatabaseFactory());
    }

    @Bean
    public MongoDatabaseFactory peopleDatabaseFactory() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        return new SimpleMongoClientDatabaseFactory(mongoClient, "people");
    }

    @Bean(name = "peopleDataSource")
    public MongoDatabaseFactory peopleDataSource() throws Exception {
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSourceClassName("com.mongodb.client.MongoClient");
        xaDataSource.setUniqueResourceName("xa_people");
        xaDataSource.setXaProperties(createMongodbXaProperties());
        xaDataSource.setMaxPoolSize(20);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(List.of(new ServerAddress("localhost", 27017))))
                .build();
        MongoClient client = MongoClients.create(settings);
        return new SimpleMongoClientDatabaseFactory(client, "people");
    }

    private Properties createMongodbXaProperties() {
        Properties properties = new Properties();
        properties.setProperty("DatabaseName", "people");
        properties.setProperty("ServerName", "localhost");
        properties.setProperty("PortNumber", "27017");
        return properties;
    }
}