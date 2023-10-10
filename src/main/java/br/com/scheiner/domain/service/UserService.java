package br.com.scheiner.domain.service;

import java.util.List;

import br.com.scheiner.domain.model.User;

public interface UserService {

	public List<User> findAll();
	
	public User save(User user);
}
