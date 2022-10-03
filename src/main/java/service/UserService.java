package service;

import dto.CreateUserRequest;
import dto.UpdateUserRequest;
import dto.UserDto;
import exception.UserDoesNotExistException;

import java.util.List;

public interface UserService {
    public UserDto createUser(CreateUserRequest createUserRequest);
    public UserDto findUserById(Long id) throws UserDoesNotExistException;
    public UserDto updateUserDetails(Long id, UpdateUserRequest updateUserRequest) throws UserDoesNotExistException;
    public String deleteUser(Long id) throws UserDoesNotExistException;
    public List<UserDto> getAllUser();
}
