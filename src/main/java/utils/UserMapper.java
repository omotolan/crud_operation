package utils;

import data.model.User;
import dto.CreateUserRequest;
import dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);

        @Mapping(target = "id", ignore = true)
    User toUser(CreateUserRequest createUserRequest);
}
