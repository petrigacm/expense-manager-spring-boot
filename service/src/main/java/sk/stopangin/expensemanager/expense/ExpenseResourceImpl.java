package sk.stopangin.expensemanager.expense;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseResourceImpl implements ExpenseResource {

    private ExpenseService expenseService;

    public ExpenseResourceImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping(path = "expense", consumes = "application/json")
    @Override
    public ExpenseDto create(@RequestBody ExpenseCreateDto expenseCreateDto) {
        return expenseService.create(expenseCreateDto);
    }

    @PutMapping(path = "expense/{id}", consumes = "application/json")
    @Override
    public ExpenseDto update(@PathVariable("id") Long id, @RequestBody ExpenseUpdateDto expenseUpdateDto) {
        return expenseService.update(id, expenseUpdateDto);
    }

    @DeleteMapping(path = "expense")
    @Override
    public void delete(Long id) {
        expenseService.delete(id);
    }

    @GetMapping(path = "expense/{id}")
    @Override
    public ExpenseDto getById(@PathVariable("id") Long id) {
        return expenseService.getById(id);
    }

    @GetMapping(path = "category/{categoryId}/expense")
    @Override
    public List<ExpenseDto> findByCategoryId(@PathVariable("categoryId") Long categoryId) {
        return expenseService.findByCategoryId(categoryId);
    }

    @GetMapping(path = "expense/findByCreatorId")
    @Override
    public List<ExpenseDto> findByCreatorId(@RequestParam("creatorId") Long creatorId) {
        return expenseService.findByCreatorId(creatorId);
    }

    @GetMapping(path = "expense/findByAmountGreaterThan")
    @Override
    public List<ExpenseDto> findByAmountGreaterThan(@RequestParam("amount") Double amount) {
        return expenseService.findByAmountGreaterThan(amount);
    }
}
