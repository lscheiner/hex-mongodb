package br.com.scheiner.infra.repository.mock;

import java.util.Map;

import br.com.scheiner.infra.mongodb.entity.UserEntity;

public class UserMockRepository {

    private Map<String, UserEntity> mapUser;
    
   // public List<User> findByName(String name);
    
   // public List<User> findById(String name);

	public Map<String, UserEntity> getMapUser() {
		return mapUser;
	}

	public void setMapUser(Map<String, UserEntity> mapUser) {
		this.mapUser = mapUser;
	}
}
