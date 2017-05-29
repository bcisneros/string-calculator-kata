package com.developersdelicias;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class StringCalculatorTests {
    private static final String EMPTY_STRING = "";
    private StringCalculator calculator;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    @Parameters(method = "singleIntegersParameters")
    public void sum_singleIntegerValue_returnsThisValue(String value, int expected) throws Exception {
        assertThat(sumOf(value), is(expected));
    }

    @Test
    @Parameters(method = "valuesForSum")
    public void sum_twoIntegersSeparatedByComma_returnsSumOfThem(String value, int expected) throws Exception {
        assertThat(sumOf(value), is(expected));
    }

    @Test(expected = InvalidNumberException.class)
    public void sum_nullValue_throwInvalidNumberException() throws Exception {
        sumOf(null);
    }

    @Test
    public void sum_valueWithALetter_throwInvalidNumberException() throws Exception {
        exception.expect(InvalidNumberException.class);
        exception.expectMessage(is("'a' is not an integer."));
        sumOf("a");
    }

    private int sumOf(String parameters) {
        return calculator.sum(parameters);
    }

    @SuppressWarnings("unused")
    private Object[] valuesForSum() {
        return new Object[]{
                $("7,6", 13),
                $("15,8", 23),
                $("6,8", 14),
                $("-6,-8", -14),
                $("5, 5", 10),
                $("   5,     5", 10),
                $("5     ,5     ", 10),
                $("    5     ", 5),
                $(EMPTY_STRING, 0),
                $("    ", 0),
                $("7,4,9", 20),
                $("1, 1, 1", 3),
        };
    }

    @SuppressWarnings("unused")
    private Object[] singleIntegersParameters() {
        Object[] parameters = new Object[10];

        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = $(String.valueOf(i), i);
        }

        return parameters;
    }
}
