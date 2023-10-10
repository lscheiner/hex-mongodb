package br.com.scheiner.infra.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserIdEntity {

	private String document;
	private String email;
}
