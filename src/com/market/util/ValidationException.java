package com.market.util;

public class ValidationException extends Exception {
    public String toString() {
        return "Invalid input data. Please check your values.";
    }
}
