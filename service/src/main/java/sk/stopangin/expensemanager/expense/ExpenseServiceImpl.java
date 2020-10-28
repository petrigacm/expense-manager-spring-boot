package sk.stopangin.expensemanager.expense;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import sk.stopangin.expensemanager.category.Category;
import sk.stopangin.expensemanager.category.CategoryRepository;
import sk.stopangin.expensemanager.common.NotFoundException;
import sk.stopangin.expensemanager.user.User;
import sk.stopangin.expensemanager.user.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository, UserRepository userRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.expenseMapper = expenseMapper;
    }

    @Transactional
    @Override
    public ExpenseDto create(@Valid ExpenseCreateDto expenseDto) {
        Expense expenseToBeCreated = expenseMapper.fromCreateDto(expenseDto);

        if (expenseDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(expenseDto.getCategoryId()).orElse(null);
            expenseToBeCreated.setCategory(category);
        }

        if (expenseDto.getCreatorId() != null) {
            User creator = userRepository.findById(expenseDto.getCreatorId()).orElse(null);
            expenseToBeCreated.setCreator(creator);
        }

        Expense createdExpense = expenseRepository.save(expenseToBeCreated);

        return expenseMapper.toReadDto(createdExpense);
    }

    @Transactional
    @Override
    public ExpenseDto update(@NotNull Long id, @Valid ExpenseUpdateDto expenseUpdateDto) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);

        if (existingExpense == null) {
            throw new NotFoundException();
        }

        expenseMapper.updateFromDto(expenseUpdateDto, existingExpense);

        return expenseMapper.toReadDto(existingExpense);
    }

    @Transactional
    @Override
    public void delete(@NotNull Long id) {
        expenseRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public ExpenseDto getById(@NotNull Long id) {
        Expense existingExpense = expenseRepository.findByIdJoinCategoryJoinCreator(id).orElse(null);

        if (existingExpense == null) {
            throw new NotFoundException();
        }

        return expenseMapper.toReadDto(existingExpense);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseDto> findByCategoryId(@NotNull Long categoryId) {
        return expenseRepository.findAllByCategoryId(categoryId).stream()
                .map(expenseMapper::toReadDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseDto> findByCreatorId(@NotNull Long creatorId) {
        return expenseRepository.findAllByCreatorId(creatorId).stream()
                .map(expenseMapper::toReadDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseDto> findByAmountGreaterThan(@NotNull Double amount) {
        return expenseRepository.findAllByAmountGreaterThan(amount).stream()
                .map(expenseMapper::toReadDto)
                .collect(Collectors.toList());
    }
}
