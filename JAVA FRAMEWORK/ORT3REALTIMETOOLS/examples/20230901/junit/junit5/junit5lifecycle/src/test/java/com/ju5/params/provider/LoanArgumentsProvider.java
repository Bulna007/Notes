package com.ju5.params.provider;

import com.ju5.bean.Loan;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class LoanArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new Loan(1000, 12, 2.0f), 240),
                Arguments.of(new Loan(1000, 12, 3.0f), 360)
        );
    }
}
