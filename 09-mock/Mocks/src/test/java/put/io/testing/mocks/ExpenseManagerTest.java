package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    void calculateTotal() {
        ExpenseRepository mock = mock(ExpenseRepository.class);

        List<Expense> exl = List.of(new Expense(), new Expense(), new Expense());
        exl.forEach(expense -> expense.setAmount(1));

        when(mock.getExpenses()).thenReturn(exl);

        FancyService fs = new FancyService();

        ExpenseManager em = new ExpenseManager(mock, fs);
        long sum = em.calculateTotal();
        assertEquals(sum, 3);
    }

    @Test
    void calculateTotalForCategory() {
        ExpenseRepository mock = mock(ExpenseRepository.class);

        List<Expense> exl = List.of(new Expense(), new Expense(), new Expense());
        exl.forEach(expense -> expense.setAmount(1));

        List<Expense> homeEx = List.of(
                new Expense(2, "Home"),
                new Expense(2, "Home"),
                new Expense(2, "Home"),
                new Expense(2, "Home")
        );
        List<Expense> carEx = List.of(
                new Expense(1, "Car"),
                new Expense(1, "Car"),
                new Expense(1, "Car"),
                new Expense(1, "Car")
        );

        when(mock.getExpensesByCategory(anyString())).thenReturn(List.of());
        when(mock.getExpensesByCategory("Home")).thenReturn(homeEx);
        when(mock.getExpensesByCategory("Car")).thenReturn(carEx);

        FancyService fs = new FancyService();

        ExpenseManager em = new ExpenseManager(mock, fs);

        assertEquals(em.calculateTotalForCategory("Home"), 8);
        assertEquals(em.calculateTotalForCategory("Car"), 4);
        assertEquals(em.calculateTotalForCategory("Sport"), 0);
        assertEquals(em.calculateTotalForCategory("Food"), 0);
        assertEquals(em.calculateTotalForCategory("Gym"), 0);

    }
}
