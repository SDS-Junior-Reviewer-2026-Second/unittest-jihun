package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {
    @Mock
    Adder mockAdder;

    @InjectMocks
    Calculator calculator;

    @BeforeEach
    void setUp() {
        when(mockAdder.add(anyInt(), anyInt())).thenAnswer(invocation -> {
                    int firstArgument = invocation.getArgument(0);
                    int secondArgument = invocation.getArgument(1);
                    return firstArgument + secondArgument;
                }
        );
    }
    @Test
    void addTest() {
        assertThat(calculator.add(2,3)).isEqualTo(5);
    }

    @Test
    void subtractTest() {
        assertThat(calculator.subtract(2,3)).isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        assertThat(calculator.multiply(2,3)).isEqualTo(6);
    }
}