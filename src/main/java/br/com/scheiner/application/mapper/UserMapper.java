package br.com.scheiner.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.scheiner.application.dtos.UserDto;
import br.com.scheiner.domain.model.User;

@Mapper
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	public List<UserDto> toUserDto(List<User> user);

	public UserDto toUserDto(User user);

	public User toUser(UserDto user);

}
