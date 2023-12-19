package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InOrder;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    ExpenseRepository er;

    @BeforeEach
    void setUp() {

    }

    @Test
    void loadExpenses() {
        IFancyDatabase mock = mock(FancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());

        er = new ExpenseRepository(mock);

        er.loadExpenses();

        assertTrue(er.getExpenses().isEmpty());

        InOrder inOrder = inOrder(mock);
        inOrder.verify(mock, times(1)).connect();
        inOrder.verify(mock, times(1)).queryAll();
        inOrder.verify(mock, times(1)).close();

    }
    @Test
    void saveExpenses() {
        IFancyDatabase mock = mock(FancyDatabase.class);

        er = new ExpenseRepository(mock);
        Expense ex = new Expense();

        int n = 5;

        ArrayList<Expense> exl = new ArrayList<Expense>(
                Collections.nCopies(n, new Expense())
        );

        exl.forEach((expense -> er.addExpense(expense)));

        er.saveExpenses();

        verify(mock, times(n)).persist(any(Expense.class));

    }
}
