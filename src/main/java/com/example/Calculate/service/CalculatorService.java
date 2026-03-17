package com.example.Calculate.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(double a, double b, String op) {
        return switch (op) {
            case "add"      -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide"   -> {
                if (b == 0) throw new ArithmeticException("Sıfıra bölmək olmaz!");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Naməlum əməliyyat");
        };
    }
}
