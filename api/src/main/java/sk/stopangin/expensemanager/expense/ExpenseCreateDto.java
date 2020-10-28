package sk.stopangin.expensemanager.expense;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ExpenseCreateDto {

    @Min(0)
    @NotNull
    private Double amount;

    private String description;

    private Long categoryId;

    private Long creatorId;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}
