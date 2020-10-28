package sk.stopangin.expensemanager.expense;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ExpenseService {

    ExpenseDto create(@Valid ExpenseCreateDto expenseCreateDto);

    ExpenseDto update(@NotNull Long id, @Valid ExpenseUpdateDto expenseDto);

    void delete(@NotNull Long id);

    ExpenseDto getById(@NotNull Long id);

    List<ExpenseDto> findByCategoryId(@NotNull Long categoryId);

    List<ExpenseDto> findByCreatorId(@NotNull Long creatorId);

    List<ExpenseDto> findByAmountGreaterThan(@NotNull Double amount);
}
