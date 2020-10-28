package sk.stopangin.expensemanager.category;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface CategoryService {

    CategoryDto create(@Valid CategoryDto categoryDto);

    CategoryDto update(@NotNull Long id, @Valid CategoryDto categoryDto);

    void delete(@NotNull Long id);

    CategoryDto getById(@NotNull Long id);
}
