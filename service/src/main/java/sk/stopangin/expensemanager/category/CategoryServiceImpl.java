package sk.stopangin.expensemanager.category;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import sk.stopangin.expensemanager.common.NotFoundException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Transactional
    @Override
    public CategoryDto create(@Valid CategoryDto categoryDto) {
        Category categoryToBeCreated = categoryMapper.fromCreateDto(categoryDto);

        Category createdCategory = categoryRepository.save(categoryToBeCreated);

        return categoryMapper.toReadDto(createdCategory);
    }

    @Transactional
    @Override
    public CategoryDto update(@NotNull Long id, @Valid CategoryDto categoryDto) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);

        if (existingCategory == null) {
            throw new NotFoundException();
        }

        categoryMapper.updateFromDto(categoryDto, existingCategory);

        return categoryMapper.toReadDto(existingCategory);
    }

    @Transactional
    @Override
    public void delete(@NotNull Long id) {
        categoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public CategoryDto getById(@NotNull Long id) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);

        if (existingCategory == null) {
            throw new NotFoundException();
        }

        return categoryMapper.toReadDto(existingCategory);
    }
}
