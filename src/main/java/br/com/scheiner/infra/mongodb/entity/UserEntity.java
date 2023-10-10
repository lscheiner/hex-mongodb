package br.com.scheiner.infra.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document("usuarios")
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

	@Id
	private UserIdEntity id;

	private String firstname;

	private String lastname;

	private String email;

	private String password;
}
