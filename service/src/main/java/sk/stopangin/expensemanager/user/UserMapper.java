package sk.stopangin.expensemanager.user;

import org.mapstruct.Mapper;
import sk.stopangin.expensemanager.common.GenericDtoMapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericDtoMapper<UserDto, UserDto, UserDto, User> {
}
