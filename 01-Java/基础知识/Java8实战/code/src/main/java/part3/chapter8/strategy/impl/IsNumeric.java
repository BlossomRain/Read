package part3.chapter8.strategy.impl;

import part3.chapter8.strategy.ValidationStrategy;

public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
