package ch02;

import java.util.Objects;

public class NYPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NYPizza build() {
            return new NYPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NYPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

}