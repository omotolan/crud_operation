package service;


import data.model.User;
import data.repository.UserRepository;
import dto.CreateUserRequest;
import dto.UpdateUserRequest;
import dto.UserDto;
import exception.UserDoesNotExistException;
import utils.UserMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
public class UserServiceImpl implements UserService {
    @Inject
    UserRepository userRepository;
    @Inject
    UserMapper userMapper;

    @Override
    public UserDto createUser(CreateUserRequest createUserRequest) {
        User user = userMapper.toUser(createUserRequest);
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setStacks(createUserRequest.getStacks());
        userRepository.persistAndFlush(user);

        return userMapper.toDto(user);
    }

    @Override
    public UserDto findUserById(Long id) throws UserDoesNotExistException {
        return userMapper.toDto(findUserByIdInternal(id));
    }

    private User findUserByIdInternal(Long id) throws UserDoesNotExistException {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserDoesNotExistException("User does not exist");
        }
        return user;
    }

    @Override
    public UserDto updateUserDetails(Long id, UpdateUserRequest updateUserRequest) throws UserDoesNotExistException {
        User foundUser = findUserByIdInternal(id);
        foundUser.setFirstName(updateUserRequest.getFirstName());
        foundUser.setLastName(foundUser.getLastName());
        userRepository.persist(foundUser);

        return userMapper.toDto(foundUser);
    }

    @Override
    public String deleteUser(Long id) throws UserDoesNotExistException {
        User foundUser = findUserByIdInternal(id);
        userRepository.delete(foundUser);
        return "user deleted";
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.listAll();
        return users.stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
    }
}
