package sk.stopangin.expensemanager.expense;

import sk.stopangin.expensemanager.category.CategoryDto;
import sk.stopangin.expensemanager.user.UserDto;

public class ExpenseDto {

    private Long id;

    private Double amount;

    private String description;

    private CategoryDto category;

    private UserDto creator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public UserDto getCreator() {
        return creator;
    }

    public void setCreator(UserDto creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", creator=" + creator +
                '}';
    }
}
