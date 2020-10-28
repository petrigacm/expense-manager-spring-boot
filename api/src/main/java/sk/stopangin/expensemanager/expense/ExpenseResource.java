package sk.stopangin.expensemanager.expense;

import sk.stopangin.expensemanager.CrudResource;

import java.util.List;

public interface ExpenseResource extends CrudResource<ExpenseDto, ExpenseCreateDto, ExpenseUpdateDto, Long> {

    List<ExpenseDto> findByCategoryId(Long categoryId);

    List<ExpenseDto> findByCreatorId(Long creatorId);

    List<ExpenseDto> findByAmountGreaterThan(Double amount);
}
