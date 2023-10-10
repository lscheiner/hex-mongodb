package br.com.scheiner.infra.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.scheiner.infra.mongodb.entity.UserEntity;
import br.com.scheiner.infra.mongodb.entity.UserIdEntity;

public interface UserRepository extends MongoRepository<UserEntity, UserIdEntity> {
	
	public List<UserEntity> findByName(String name);

}