package sk.stopangin.expensemanager.expense;

import org.mapstruct.Mapper;
import sk.stopangin.expensemanager.common.GenericDtoMapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper extends GenericDtoMapper<ExpenseDto, ExpenseCreateDto, ExpenseUpdateDto, Expense> {
}
