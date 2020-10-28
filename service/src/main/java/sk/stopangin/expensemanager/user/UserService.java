package sk.stopangin.expensemanager.user;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface UserService {

    UserDto create(@Valid UserDto userDto);

    UserDto update(@NotNull Long id, @Valid UserDto userDto);

    void delete(@NotNull Long id);

    UserDto getById(@NotNull Long id);
}
