package sk.stopangin.expensemanager.expense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("FROM Expense e LEFT JOIN FETCH e.category LEFT JOIN FETCH e.creator WHERE e.id = :id")
    Optional<Expense> findByIdJoinCategoryJoinCreator(@Param("id") Long id);

    List<Expense> findAllByCategoryId(Long categoryId);

    List<Expense> findAllByCreatorId(Long creatorId);

    List<Expense> findAllByAmountGreaterThan(Double amount);
}
