package sk.stopangin.expensemanager.category;

import org.mapstruct.Mapper;
import sk.stopangin.expensemanager.common.GenericDtoMapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends GenericDtoMapper<CategoryDto, CategoryDto, CategoryDto, Category> {
}
