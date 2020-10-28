package sk.stopangin.expensemanager.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import sk.stopangin.expensemanager.common.NotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Transactional
@Validated
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto create(@Valid UserDto userDto) {
        User userToBeCreated = userMapper.fromCreateDto(userDto);

        User createdUser = userRepository.save(userToBeCreated);

        return userMapper.toReadDto(createdUser);
    }

    @Override
    public UserDto update(@NotNull Long id, @Valid UserDto userDto) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            throw new NotFoundException();
        }

        userMapper.updateFromDto(userDto, existingUser);

        return userMapper.toReadDto(existingUser);
    }

    @Override
    public void delete(@NotNull Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto getById(@NotNull Long id) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            throw new NotFoundException();
        }

        return userMapper.toReadDto(existingUser);
    }
}
