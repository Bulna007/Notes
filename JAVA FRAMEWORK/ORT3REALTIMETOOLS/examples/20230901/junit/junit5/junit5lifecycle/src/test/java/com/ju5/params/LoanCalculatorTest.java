package com.ju5.params;

import com.ju5.bean.Loan;
import com.ju5.params.provider.LoanArgumentsProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class LoanCalculatorTest {
    LoanCalculator loanCalculator;

    @BeforeEach
    void init() {
        loanCalculator = new LoanCalculator();
    }

    @ParameterizedTest
    @ArgumentsSource(LoanArgumentsProvider.class)
    void testInterestAmount(Loan loan, double expectedInterestAmount) {
        Assertions.assertEquals(expectedInterestAmount, loanCalculator.interestAmount(loan));
    }

    @AfterEach
    void cleanup() {
        loanCalculator = null;
    }
}
