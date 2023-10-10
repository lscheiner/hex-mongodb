package br.com.scheiner.infra.mongodb.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {

	@Bean
	public MongoClient mongo() {
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/users");
		MongoClientSettings mongoClientSettings = 
				MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.applyToConnectionPoolSettings(settings -> {
					settings
					.minSize(20)
					.maxSize(200)
					.maxConnectionLifeTime(60, TimeUnit.MINUTES);
				}).build();

		return MongoClients.create(mongoClientSettings);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), "users");
	}
}
