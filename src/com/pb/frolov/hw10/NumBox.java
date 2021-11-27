package com.pb.frolov.hw10;

public class NumBox<T extends Number> {
    private final T[] numbers;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }


    public T get(int index) {
        return numbers[index];
    }

    public void add(T number) {
        int i = 0;
        while (numbers[i] != null) {
            ++i;
        }
        this.numbers[i] = number;
    }

    public int length() {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != null)
                count++;
            else break;
        }
        return count;
    }

    public double average() {
        double sum = 0;
        for (int i = 0; i < length(); i++) {
            sum += numbers[i].doubleValue();
        }
        return sum / length();
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < length(); i++) {
            sum += numbers[i].doubleValue();
        }
        return sum;
    }

    public T max() {
        T maxValue = numbers[0];

        for (int i = 1; i < length(); i++) {
            if (maxValue instanceof Integer) {
                if (numbers[i].intValue() > maxValue.intValue())
                    maxValue = numbers[i];
            } else if (maxValue instanceof Float) {
                if (numbers[i].floatValue() > maxValue.floatValue())
                    maxValue = numbers[i];
            } else if (maxValue instanceof Double) {
                if (numbers[i].doubleValue() > maxValue.doubleValue())
                    maxValue = numbers[i];
            }

        }
        return maxValue;
    }
}
