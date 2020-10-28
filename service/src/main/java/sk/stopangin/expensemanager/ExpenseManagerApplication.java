package sk.stopangin.expensemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import sk.stopangin.expensemanager.category.CategoryDto;
import sk.stopangin.expensemanager.category.CategoryService;
import sk.stopangin.expensemanager.user.UserDto;
import sk.stopangin.expensemanager.user.UserService;

import javax.servlet.Servlet;
import java.util.function.Function;

@SpringBootApplication
public class ExpenseManagerApplication implements ApplicationRunner {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ExpenseManagerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName("food");
        categoryDto.setDescription("just a food");

        UserDto userDto = new UserDto();
        userDto.setUsername("arthur");

        UserDto createdUser = userService.create(userDto);
        CategoryDto createdCategory = categoryService.create(categoryDto);

        System.out.println("Created " + createdUser);
        System.out.println("Created " + createdCategory);
    }
}
