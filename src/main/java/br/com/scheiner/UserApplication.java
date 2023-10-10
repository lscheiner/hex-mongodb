package br.com.scheiner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.scheiner.infra.repository.mock.UserMockRepository;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "br.com.scheiner.infra.repository")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

//	@Bean
//	public UserMockRepository get() throws StreamReadException, DatabindException, IOException   {
//		Resource resource = new ClassPathResource("userRoles.json");
//		return new ObjectMapper().readValue(resource.getInputStream(), UserMockRepository.class);
//	}

	@Bean
	public UserMockRepository get(@Value("${mock.user.mapUser}") String json) throws JsonMappingException, JsonProcessingException {
		return new ObjectMapper().readValue(json, UserMockRepository.class);
	}

	@Bean
	public ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
		return new ObservedAspect(observationRegistry);
	}
}
