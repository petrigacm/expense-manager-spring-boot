package sk.stopangin.expensemanager.category;

import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryResourceImpl implements CategoryResource {

    private CategoryService categoryService;

    public CategoryResourceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "category", consumes = "application/json")
    @Override
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

    @PutMapping(path = "category/{id}", consumes = "application/json")
    @Override
    public CategoryDto update(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto) {
        return categoryService.update(id, categoryDto);
    }

    @DeleteMapping(path = "category")
    @Override
    public void delete(Long id) {
        categoryService.delete(id);
    }

    @GetMapping(path = "category/{id}")
    @Override
    public CategoryDto getById(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }
}
