package com.developersdelicias;

class StringCalculator {
    int sum(String parameters) {

        if (parameters == null)
            throw new InvalidNumberException();

        if (isEmpty(parameters))
            return 0;

        String[] stringValues = parameters.split(",");

        int result = 0;

        for (String value : stringValues) {
            result += toInteger(value);
        }
        return result;
    }

    private boolean isEmpty(String parameters) {
        return "".equals(parameters.trim());
    }

    private int toInteger(String value) {
        String trimValue = value.trim();
        if (!trimValue.matches("[-]?[0-9]+")) {
            throw new InvalidNumberException(trimValue);
        }

        return Integer.parseInt(trimValue);
    }
}
