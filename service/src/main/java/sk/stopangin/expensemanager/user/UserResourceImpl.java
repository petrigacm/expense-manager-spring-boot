package sk.stopangin.expensemanager.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserResourceImpl implements UserResource {

    private UserService userService;

    public UserResourceImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "user", consumes = "application/json")
    @Override
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping(path = "user/{id}", consumes = "application/json")
    @Override
    public UserDto update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("user/{id}")
    @Override
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @GetMapping("user/{id}")
    @Override
    public UserDto getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }
}
