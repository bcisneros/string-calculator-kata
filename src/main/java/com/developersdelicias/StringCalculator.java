package com.developersdelicias;

class StringCalculator {
    int sum(String values) {
        validateNotNull(values);
        return isEmpty(values) ? 0 : sumOf(values);
    }

    private int sumOf(String parameters) {
        String[] stringValues = parameters.split(",");

        int result = 0;

        for (String value : stringValues) {
            result += toInteger(value);
        }
        return result;
    }

    private void validateNotNull(String values) {
        if (values == null)
            throw new InvalidNumberException();
    }

    private boolean isEmpty(String values) {
        return "".equals(values.trim());
    }

    private int toInteger(final String value) {
        String trimmedValue = value.trim();
        if (notAnInteger(trimmedValue)) {
            throw new InvalidNumberException(trimmedValue);
        }

        return Integer.parseInt(trimmedValue);
    }

    private boolean notAnInteger(String value) {
        return !value.matches("[-]?[0-9]+");
    }
}
